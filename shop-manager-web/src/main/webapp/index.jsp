<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<link href="./resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<script src="./resources/jquery/jquery-3.1.0.min.js"></script>
<script src="./resources/bootstrap/js/bootstrap.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	vertical-align: middle;
	overflow: scroll;
	overflow: auto;
	display: none;
	visibility: hidden;
}
</style>
<script type="text/javascript">
	
</script>
</head>
<body onload="load()">
    <div></div>>
	<H2>错误：$ex.class.simpleName</H2>
	<hr />
	<P>
		<strong>错误描述：</strong>$ex.message
	</P>
	<P>
		<strong>详细信息：</strong>
	</P>
	<pre>
	    #foreach($stack in $ex.getStackTrace())
     		$stack.toString()
 		#end
     </pre>
</body>
</html>
