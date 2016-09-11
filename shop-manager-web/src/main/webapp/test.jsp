<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="./resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<script src="./resources/jquery/jquery-3.1.0.min.js"></script>
<script src="./resources/bootstrap/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="dropdown">
		<a data-toggle="dropdown" href="#">下拉菜单（Dropdown）触发器</a>
		<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
			<li><a href="#">jmeter</a></li>
			<li><a href="#">EJB</a></li>
			<li><a href="#">Jasper Report</a></li>
			<li class="divider"></li>
			<li><a href="#">分离的链接</a></li>
			<li class="divider"></li>
			<li><a href="#">另一个分离的链接</a></li>
		</ul>
	</div>
	<select class="selectpicker">
		<option style="" class="glyphicon glyphicon-search">Mustard</option>
		<option>Ketchup</option>
		<option>Relish</option>
	</select>
</body>
</html>