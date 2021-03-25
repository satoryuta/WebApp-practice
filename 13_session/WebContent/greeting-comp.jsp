<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="Bean.BookBean" %>
<% BookBean bbean=(BookBean)session.getAttribute("bookdata");%>

<!DOCTYPE html>
<html>
	<head>
	<title>登録完了画面</title>
	</head>
	
	<body>
		<p>書籍「<%= bbean.getTitle()%>」を登録しました</p>
		
		
	</body>
</html>