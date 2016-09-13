function openModal(url, param, whparam) {
	// 传递至子窗口的参数
	var paramObj = param || {};

	// 模态窗口高度和宽度
	var whparamObj = whparam || {
		width : 500,
		height : 500
	};

	// 相对于浏览器的居中位置
	var bleft = (window.screen.width - whparamObj.width) / 2;
	var btop = (window.screen.height - whparamObj.height) / 2;

	// 根据鼠标点击位置算出绝对位置
	// var tleft = e.screenX - e.clientX;
	// var ttop = e.screenY - e.clientY;

	// 最终模态窗口的位置
	var left = bleft;
	var top = btop;

	// 参数
	var p = "resizeable:no;help:no;status:no;location:no;toolbar:no;menubar:no;titlebar:no;";
	p += 'dialogWidth:' + (whparamObj.width) + 'px;';
	p += 'dialogHeight:' + (whparamObj.height) + 'px;';
	p += 'dialogLeft:' + left + 'px;';
	p += 'dialogTop:' + top + 'px;';
	window.showModalDialog(url, paramObj, p)
}