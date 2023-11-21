<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.example.project4_p2.BoardDAO, com.example.project4_p2.BoardVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Form</title>
</head>
<body>

<%
	BoardDAO boardDAO = new BoardDAO();
	String id=request.getParameter("id");	
	BoardVO u=boardDAO.getBoard(Integer.parseInt(id));
%>

<h1>Edit Form</h1>
<form action="editpost.jsp" method="post">
<input type="hidden" name="seq" value="<%=u.getSeq() %>"/>
<table>
<tr><td>Level:<input type="radio" id="WordLevel" name="level" value="1">
	<label for="WordLevel">1</label>
	<input type="radio" name="level" value="2">
	<label for="WordLevel">2</label>
	<input type="radio" name="level" value="3">
	<label for="WordLevel">3</label></tr>
<tr><td>Word:</td><td><input type="text" name="vocab" value="<%= u.getVocab()%>" /></td></tr>
<tr><td>Definition:</td><td><textarea cols="50" rows="5" name="def"><%= u.getDef()%></textarea></td></tr>
<tr><td colspan="2"><input type="submit" value="Edit Post"/>
<input type="button" value="Cancel" onclick="history.back()"/></td></tr>
</table>
</form>

</body>
</html>