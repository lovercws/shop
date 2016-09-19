/**
 * @license Copyright (c) 2003-2016, CKSource - Frederico Knabben. All rights
 *          reserved. For licensing, see LICENSE.md or
 *          http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function(config) {
	// Define changes to default configuration here.
	// For complete reference see:
	// http://docs.ckeditor.com/#!/api/CKEDITOR.config
	config.uiColor = '#AADC6E';
	config.language = 'zh-cn';
	// The toolbar groups arrangement, optimized for two toolbar rows.
	config.toolbarGroups = [ {
		name : 'clipboard',
		groups : [ 'clipboard', 'undo' ]
	}, {
		name : 'editing',
		groups : [ 'find', 'selection', 'spellchecker' ]
	}, {
		name : 'links'
	}, {
		name : 'insert'
	}, {
		name : 'forms'
	}, {
		name : 'tools'
	}, {
		name : 'document',
		groups : [ 'mode', 'document', 'doctools' ]
	}, {
		name : 'others'
	}, '/', {
		name : 'basicstyles',
		groups : [ 'basicstyles', 'cleanup' ]
	}, {
		name : 'paragraph',
		groups : [ 'list', 'indent', 'blocks', 'align', 'bidi' ]
	}, {
		name : 'styles'
	}, {
		name : 'colors'
	}, {
		name : 'about'
	} ];

	// Remove some buttons provided by the standard plugins, which are
	// not needed in the Standard(s) toolbar.
	config.removeButtons = 'Underline,Subscript,Superscript';

	// Set the most common block elements.
	config.format_tags = 'p;h1;h2;h3;pre';

	// Simplify the dialog windows.
	config.removeDialogTabs = 'image:advanced;link:advanced';

	config.filebrowserBrowseUrl = 'resources/ckfinder/ckfinder.html'; // 上传文件时浏览服务文件夹
	config.filebrowserImageBrowseUrl = 'resources/ckfinder/ckfinder.html?Type=Images'; // 上传图片时浏览服务文件夹
	config.filebrowserFlashBrowseUrl = 'resources/ckfinder/ckfinder.html?Type=Flash'; // 上传Flash时浏览服务文件夹
	config.filebrowserUploadUrl = 'resources/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files'; // 上传文件按钮(标签)
	config.filebrowserImageUploadUrl = 'resources/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images'; // 上传图片按钮(标签)
	config.filebrowserFlashUploadUrl = 'resources/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Flash'; // 上传Flash按钮(标签)
};
