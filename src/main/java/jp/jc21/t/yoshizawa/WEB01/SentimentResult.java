package jp.jc21.t.yoshizawa.WEB01;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResultServlet
 */
@WebServlet("/SentimentResult")
public class SentimentResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SentimentResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String string = "";
		try {
			Sentiments result = Sentiment.getSentiments(string);
			ConfidenceScores message = result.documents[0].confidenceScores;
			float positive = message.positive;
			float neutral = message.neutral;
			float negative = message.negative;
			request.setAttribute("message", message);
			request.setAttribute("positive", positive);
			request.setAttribute("neutral", neutral);
			request.setAttribute("negative", negative);
			request.getRequestDispatcher("/WEB-INF/jsp/SentimentResult.jsp").forward(request, response);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String string = request.getParameter("string");
		request.setAttribute("string", string);
		
		try {
			Sentiments result = Sentiment.getSentiments(string);
			ConfidenceScores message = result.documents[0].confidenceScores;
			float positive = message.positive;
			float neutral = message.neutral;
			float negative = message.negative;
			request.setAttribute("message", message);
			request.setAttribute("positive", positive);
			request.setAttribute("neutral", neutral);
			request.setAttribute("negative", negative);
			request.getRequestDispatcher("/WEB-INF/jsp/SentimentResult.jsp").forward(request, response);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
