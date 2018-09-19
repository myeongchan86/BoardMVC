<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page errorPage="error.jsp" %>
<%@ page import="kr.it.edu.bordmvc.BoardVO" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% 
int bid = Integer.parseInt(request.getParameter("bid"));
String title;
String content;

if(bid == 0){
	title = "";
	content = "";
} else {
	BoardVO list = (BoardVO)request.getAttribute("vo");
	title = list.getBtitle();
	content = list.getBcontent();
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardRegMod</title>
</head>
<body>
	<div>
		<form action="BoardRegMod" name="type" method="post">
			<h2>
				제목
			</h2>
			<br>
			<input type="text" name="btitle" value="<%=title %>">
			<br>
			<h2>
				글
			</h2>
			<br>
			<textarea rows="5px" cols="50px" name="bcontent" placeholder="내용입력"><%=content %></textarea>
			<br>
			<input type="hidden" name="bid" value="<%=bid %>">
			<input type="submit" name="type" value="Send">
		</form>
	</div>
</body>
</html>