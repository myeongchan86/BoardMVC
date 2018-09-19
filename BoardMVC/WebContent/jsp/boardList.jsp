<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="kr.it.edu.bordmvc.action.*" %>
<%@ page import="kr.it.edu.bordmvc.*" %>  

<%@ page import="java.util.ArrayList" %>
<%@ page import="kr.it.edu.bordmvc.action.*" %>
<%
	ArrayList<BoardVO> result = (ArrayList<BoardVO>) request.getAttribute("data");	
	String btype = request.getParameter("btype");
	//result.clear();
%>

<%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/boardList.css">

</head>
<body>
	<h1>
	   
	</h1>
	
	<div class="container">
	
	<% if(result.size() > 0){ %>
		<table class="table">
			<tr>
			<th>번호</th>
			<th>제목</th>
			<th>등록일시</th>	
			<th>수정일시</th>	
			</tr>
			<tr>
			
			<%	for(int i=0; i < result.size(); i++){ %>	
			<td><%=result.get(i).getBid() %></td>
			<td>
			<a href="BoardDetail?bid=<%=result.get(i).getBid() %>">
			<%=result.get(i).getBtitle() %>
			</a>
			</td>
			<td><%=result.get(i).getBregdate() %></td>
			<td><%=result.get(i).getBregdate() %></td>
			</tr>
			<%	}	%>
		</table>
	<% } else { %>
	<h2>
		내용없음
	</h2>
	<% } %>
	<br>
		<a href="boardRegMod.jsp?bid=0">
			<input type="button" value="글쓰기">
		</a>
	</div>
	
</body>
</html>