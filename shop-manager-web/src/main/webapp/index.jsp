<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="./resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<script src="./resources/jquery/jquery-3.1.0.min.js"></script>
<script src="./resources/bootstrap/js/bootstrap.min.js"></script>
<script
	src="./resources/bootstrap-datepicker/js/bootstrap-datepicker.min.js"></script>
<script
	src="./resources/bootstrap-datepicker/locales/bootstrap-datepicker.zh-CN.min.js"></script>
<link
	href="./resources/bootstrap-datepicker/css/bootstrap-datepicker3.min.css"
	rel="stylesheet">
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
	$(function() {
		$('#datetimepicker').datepicker({
			viewMode : 'years',
			language : 'zh',
			autoclose : 1,
			language : 'zh-CN',
			format : 'yyyy-mm-dd',
			todayHighlight : 1
		}).on('changeDate', function(ev) {
			$(this).datetimepicker('hide');
		});
	});
</script>
</head>
<body>
	<div class="form-group">
		<label class="col-sm-2 control-label">生日</label>
		<div class="col-sm-4">
			<div class='input-group date' id='datetimepicker'>
				<input type='text' class="form-control" /> <span
					class="input-group-addon"> <span
					class="glyphicon glyphicon-calendar"></span>
				</span>
			</div>
		</div>
		<select name="">
		 <option value=""></option>
		</select>
	</div>
</body>
</html>
