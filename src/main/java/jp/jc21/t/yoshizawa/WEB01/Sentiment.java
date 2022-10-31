package jp.jc21.t.yoshizawa.WEB01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class Sentiment {

	public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
		Sentiments message = getSentiments("Stepover Toehold With Facelock");
		if (message != null) {
			System.out.println("positive：" + message.documents[0].confidenceScores.positive);
			System.out.println("neutral：" + message.documents[0].confidenceScores.neutral);
			System.out.println("negative：" + message.documents[0].confidenceScores.negative);
		}
	}

	static Sentiments getSentiments(String string) throws IOException, URISyntaxException, InterruptedException {
		Gson gson = new Gson();

		String url = "https://r04jk3a03-text.cognitiveservices.azure.com//" + "text/analytics/v3.0/Sentiment";
		Map<String, String> map = new HashMap<>();
		map.put("Ocp-Apim-Subscription-Key", "3d5e59ec5a4243379e94315da1002761");

		ADocs doc = new ADocs();
		doc.id = "1";
		doc.text = string;

		ASource src = new ASource();
		src.documents = new ADocs[1];
		src.documents[0] = doc;

		String jsonData = new Gson().toJson(src);

		InetSocketAddress proxy = new InetSocketAddress("172.17.0.2", 80);

		JsonReader reader = WebApiConnector.postJsonReader(url, proxy, map, jsonData);
		Sentiments message = null;
		if (reader != null) {
			message = gson.fromJson(reader, Sentiments.class);
			reader.close();
		}
		return message;
	}

}

class Sentiments {
	ADocuments[] documents;
	String[] errors;
	String modelVersion;
}

class ADocuments {
	ConfidenceScores confidenceScores;;
}

class ConfidenceScores {
	float positive;
	float neutral;
	float negative;
}

class ASource {
	ADocs[] documents;
}

class ADocs {
	String id;
	String text;
}
