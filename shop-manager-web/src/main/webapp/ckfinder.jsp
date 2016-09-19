<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>CKFinder</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="robots" content="noindex, nofollow" />
<script src="./resources/jquery/jquery-3.1.0.min.js"></script>
<script src="./resources/ckfinder/ckfinder.js"></script>
<style type="text/css">
body, html, iframe, #ckfinder {
	margin: 0;
	padding: 0;
	border: 0;
	width: 100%;
	height: 100%;
	overflow: hidden;
}
</style>
</head>
<body class="CKFinderFrameWindow">
	<div id="ckfinder"></div>
	<script type="text/javascript">
		(function() {
			var config = {};
			var get = CKFinder.tools.getUrlParam;
			// Always use 100% width and height when nested using this middle page.
			config.width = config.height = '100%';
			var ckfinder = new CKFinder(config);
			ckfinder.skin = 'bootstrap';
			ckfinder.replace('ckfinder', config);
		})();
	</script>
</body>
</html>
