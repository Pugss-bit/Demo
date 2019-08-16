<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<a href="http://localhost:8080/download?fileName=o.jpeg">head_default</a>
	</div>
	<form action="http://localhost:8080/upload" method="post"
		enctype="multipart/form-data">
		<input type="file" name="file"> <br> <input type="submit">
	</form>
</body>
</html>