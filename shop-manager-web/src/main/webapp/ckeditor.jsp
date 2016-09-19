<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CKFinder</title>
<script src="./resources/jquery/jquery-3.1.0.min.js"></script>
<script src="./resources/ckeditor/ckeditor.js"></script>
<script src="./resources/ckfinder/ckfinder.js"></script>
<style type="text/css">
body {
	vertical-align: middle;
	overflow: scroll;
	overflow: auto;
	display: block;
	visibility: visible;
}
</style>
<script type="text/javascript">
	var editor;
	$(document).ready(function() {
		editor = CKEDITOR.replace("content");
		CKFinder.setupCKEditor(editor, "/ckfinder/");
	});
</script>
</head>
<body>
	<span style="white-space: pre"> </span>
	<textarea name="content" id="content"></textarea>
</body>
</html>
