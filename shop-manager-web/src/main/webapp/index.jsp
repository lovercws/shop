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
<title>省市区三级联动</title>
<style type="text/css">
.container {
	width: 700px;
}
</style>
<script type="text/javascript">
	(function() {
		//加载省信息
		$.get('./common/province', function(provinces) {
			for (var p = 0, plength = provinces.length; p < plength; p++) {
				var province = provinces[p];
				$("#provinceSelect").append("<option value="+province.provinceCode+">"+ province.provinceName + "</option>")
			}
			//监听省选择
			$('#provinceSelect').change(function(){
				var provinceCode=$(this).children('option:selected').val();
				//获取省下的城市列表
				loadCity(provinceCode);
			});
			//加载第一个省下的城市列表
			var firstProvince=provinces[0].provinceCode;
			loadCity(firstProvince);
			
			//加载省下的城市列表
			function loadCity(provinceCode){
				$.get('./common/city?provinceCode='+provinceCode, function(citys){
					$("#citySelect").empty();
					$("#areaSelect").empty();
					for (var c = 0, clength = citys.length; c < clength; c++) {
						var city = citys[c];
						$("#citySelect").append("<option value="+city.cityCode+">"+ city.cityName + "</option>")
					}
					//城市监听
					$('#citySelect').change(function(){
						var cityCode=$(this).children('option:selected').val();
						loadArea(cityCode);
					});
					//加载第一个城市列表下的地区列表
					var firstCityCode=citys[0].cityCode;
					loadArea(firstCityCode);
				});
			}
			
			//加载地区
			function loadArea(cityCode){
				$("#areaSelect").empty();
				//获取城市下的所有地区
				$.get('./common/area?cityCode='+cityCode, function(areas){
					for (var a = 0, alength = areas.length; a < alength; a++) {
						var area = areas[a];
						$("#areaSelect").append("<option value="+area.areaCode+">"+ area.areaName + "</option>")
					}
				});
			}
		});
	})();
</script>
</head>
<body>
	<div class="container">
		<form class="form-horizontal" role="form">
			<div class="form-group province-city-area">
				<label for="province" class="col-sm-1 control-label">省</label>
				<div class="col-sm-2">
					<select class="form-control" id="provinceSelect" title="省"
						style="width: 100px;" onchange=""></select>
				</div>
				<label for="city" class="col-sm-1 control-label">市</label>
				<div class="col-sm-2">
					<select class="form-control" id="citySelect" title="市"
						style="width: 100px;">
					</select>
				</div>
				<label for="area" class="col-sm-1 control-label">区</label>
				<div class="col-sm-2">
					<select class="form-control" id="areaSelect" title="区"
						style="width: 100px;">
					</select>
				</div>
			</div>
		</form>
	</div>
</body>
</html>