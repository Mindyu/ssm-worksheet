<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="jquery,ui,easy,easyui,web">
<meta name="description" content="easyui help you build your web page easily!">
<title>jQuery EasyUI CRUD Demo</title>

<link rel="stylesheet" type="text/css" href="/WorkSheet/easyui/themes/material/easyui.css">
<link rel="stylesheet" type="text/css" href="/WorkSheet/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="/WorkSheet/css/index.css">

<script type="text/javascript" src="/WorkSheet/easyui/jquery.min.js"></script>
<script type="text/javascript" src="/WorkSheet/easyui/jquery.easyui.min.js"></script>

<script type="text/javascript" src="/WorkSheet/js/depots.js?t=" + Math.random()></script>

<title>部门</title>
</head>

<body>
	
	<!-- 表格信息 -->
	<div style="width:90%; height:auto; margin: 0 auto;">
		<table id="dg" style="width:100%; height:453px;">
		</table>
	</div>

	<!-- 导航栏信息 -->
	<div id="toolbar">
		<a href="#" class="easyui-linkbutton" data-options="plain:true, iconCls:'icon-add'" onclick="newDepot()">新增</a>
		<a href="#" class="easyui-linkbutton" data-options="plain:true, iconCls:'icon-edit'" onclick="editDepot()">修改</a>
		<a href="#" class="easyui-linkbutton" data-options="plain:true, iconCls:'icon-remove'" onclick="removeDepot()">删除</a>
	</div>
	
	<!-- 新增与修改使用的弹出框 -->
	<div id="dlg" class="easyui-dialog" data-options="closed:true, buttons:'#dlg-buttons', width:400, height:280" style="padding:10px 20px">
		<div class="ftitle">仓库信息</div>
		<form id="fm" novalidate>
			<div class="fitem"><input id="depotno" name="depotno" type="hidden"></div>
			<div class="fitem"><label>仓库名称:</label> <input id="depotName" name="depotName"></div>
			<div class="fitem"><label>仓库所在地:</label><input id="loc" name="loc"></div>
		</form>
	</div>
	
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" data-options="iconCls: 'icon-ok'" onclick="saveDepot()">确定</a>
		<a href="#" class="easyui-linkbutton" data-options="iconCls: 'icon-cancel'" onclick="javascript:$('#dlg').dialog('close')">取消</a>
	</div>

</body>
</html>