<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CognitiveServiceを使うサイト</title>
</head>

<body>
<h1>CognitiveServiceを使うサイト</h1>

<h3>調べたい文字列を教えてください。</h3>
<form method="POST" action="./SentimentResult">
<input type="TEXT" name="string" />
<input type="submit" />
</form>
</body>
</html>