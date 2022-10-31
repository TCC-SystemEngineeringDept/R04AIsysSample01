<%@page import="java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	Optional<String> message = 
		Optional.ofNullable((String) request.getAttribute("string"));
	 float positive = 
			 ((float)request.getAttribute("positive"));
	 float neutral = 
			 ((float)request.getAttribute("neutral"));
	 float negative = 
			 ((float)request.getAttribute("negative"));

%>

<body>
<H1>Sentiment</H1>
<H3>positive：<%= positive %></H3>
<H3>neutral：<%= neutral %></H3>
<H3>negative：<%= negative %></H3>
</body>
</html>