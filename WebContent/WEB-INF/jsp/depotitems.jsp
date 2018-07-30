<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="jquery,ui,easy,easyui,web">
<meta name="description" content="easyui help you build your web page easily!">
<title>仓库信息管理</title>
<link rel="stylesheet" type="text/css" href="/WorkSheet/easyui/themes/material/easyui.css">
<link rel="stylesheet" type="text/css" href="/WorkSheet/easyui/themes/icon.css">
<script type="text/javascript" src="/WorkSheet/easyui/jquery.min.js"></script>
<script type="text/javascript" src="/WorkSheet/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/WorkSheet/js/depotitems.js?t=" + Math.random()></script>
<!-- 引入ECharts文件 -->
<script type="text/javascript" src='/WorkSheet/easyui/echarts.min.js'></script>

</head>
<body>

	<!-- 表格信息 -->
	<div style="width:90%;height:auto;margin: 0 auto;">
		<p>
			<input id="cb" name="depot" style="width:200px;"></input> 
			<input id="cb1" class="easyui-textbox" name="product" style="width:200px;margin-left: 50px;" placeholder="产品名称"></input> 
		</p> 

		<table id="dg" style="width:100%;height:453px;">
		</table>
	</div>

	<div id="toolbar">
		<a href="#" class="easyui-linkbutton" onclick="newDepotitem()" data-options="plain:true, iconCls:'icon-add'">入库</a> 
		<a href="#" class="easyui-linkbutton" onclick="editDepotitem()" data-options="plain:true, iconCls:'icon-edit'">修改</a> 
		<a href="#" class="easyui-linkbutton" data-options="plain:true, iconCls:'icon-remove'" onclick="removeDepotitem()">出库</a>
		<a href="#" class="easyui-linkbutton" data-options="plain:true, iconCls:'icon-large-chart'" onclick="getDepotitems()">统计</a>
	</div>
	<div id="dlg" class="easyui-dialog"
		data-options="closed:true, buttons:'#dlg-buttons', width:400, height:280"
		style="padding: 10px 20px">
		<div class="ftitle">库存信息</div>
		<form id="fm" novalidate>
			<div class="fitem">
				<p>
					<label>产品编号:</label><input id="prodId" name="prodId">
				</p>
			</div>
			<div class="fitem">
				<input id="depotno" name="depotno" type="hidden">
			</div>
			<div class="fitem">
				<p>
					<label>产品名称:</label><input id="prodName" name="prodName"></input>
				</p>
			</div>
			<div class="fitem">
				<p>
					<label>入库数量:</label><input id="quantity" name="quantity">
				</p>
			</div>
		</form>
	</div>
	<div id="dlg1" class="easyui-dialog"
		data-options="closed:true, buttons:'#dlg-buttons1', width:400, height:280"
		style="padding: 10px 20px">
		<div class="ftitle">库存信息</div>
		<form id="fm1" novalidate>
			<div class="fitem">
				<p>
					<input id="prodId1" name="prodId" type="hidden">
				</p>
			</div>
			<div class="fitem">
				<input id="depotno1" name="depotno" type="hidden">
			</div>
			<div class="fitem">
				<label>入库数量:</label><input id="quantity1" name="quantity">
			</div>
		</form>
	</div>
	<div id="dlg-buttons1">
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls: 'icon-ok'" onclick="saveEditDepotItem()">确定</a>
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls: 'icon-cancel'"
			onclick="javascript:$('#dlg1').dialog('close')">取消</a>
	</div>
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls: 'icon-ok'" onclick="saveDepotitem()">确定</a> <a
			href="#" class="easyui-linkbutton"
			data-options="iconCls: 'icon-cancel'"
			onclick="javascript:$('#dlg').dialog('close')">取消</a>
	</div>
	
	<!-- 显示统计报表的弹出框 -->
	<!-- 为ECharts准备一个具备大小（宽高）的DOM容器-->
	<div id="dlg3" class="easyui-dialog" data-options="closed:true, buttons:'#dlg-buttons3', width:550, height:400" style="padding:10px 20px">
	</div>
	
	<div id="dlg-buttons3">
		<a href="#" class="easyui-linkbutton" data-options="iconCls: 'icon-cancel'" onclick="javascript:$('#dlg3').dialog('close')">OK</a>
	</div>
</body>
</html>