<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=11">
<title>WebApp</title>
<link rel="shortcut icon" href='<c:url value="/images/favicon.ico" />' />
<link href="<c:url value='/css/bootstrap.min.css' />" rel="stylesheet" />
<link href="<c:url value='/css/style.css' />" rel="stylesheet" />
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">WebApp</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="<c:url value='/' />">Home</a></li>
				<li><a href="<c:url value='/find.jsp' />"> Find</a></li>
				<li><a href="<c:url value='/add.jsp' />"> Add</a></li>
				<li><a href="<c:url value='/update.jsp' />"> Update</a></li>
				<li><a href="<c:url value='/delete.jsp' />"> Delete</a></li>
				<li><a href="<c:url value='/upload.jsp' />"> Upload</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<h2>Books</h2>
			<form class="form-horizontal" id="deleteform">
				<div class="form-group">
					<label class="btn btn-default" for="id">Browse
						<input type="file" name="filename" id="filename" hidden="hidden"/>
					</label>
				</div>
				<div class="form-group">
					<input type="button" value="Upload" class="btn btn-danger"/>
				</div>
			</form>
			<div id="status">
				
			</div>
		</div>
	</div>
	</div>

	<!-- Load scripts at end of page -->
	<script src="<c:url value='/js/jquery.min.js' />"></script>
	<script src="<c:url value='/js/bootstrap.min.js' />"></script>
	<script src="<c:url value='/js/app.js' />"></script>
</body>
</html>
