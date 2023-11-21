<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Add New Post</h1>
<form action="addpost.jsp" method="post">
<table>
<tr><td>Level:<input type="radio" id="WordLevel" name="level" value="1">
    <label for="WordLevel">1</label>
    <input type="radio" name="level" value="2">
    <label for="WordLevel">2</label>
    <input type="radio" name="level" value="3">
    <label for="WordLevel">3</label>
<tr><td>Word:</td><td><input type="text" name="vocab"/></td></tr>
<tr><td>Definition:</td><td><textarea cols="50" rows="5" name="def"></textarea></td></tr>
<tr><td><a href="posts.jsp">View All Records</a></td><td align="right"><input type="submit" value="Add Post"/></td></tr>
</table>
</form>

</body>
</html>