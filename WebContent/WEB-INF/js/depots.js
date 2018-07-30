$(function() {														// 等同于 window.onload = function(){}
	$('#dg').datagrid({												// 初始化 表格的信息
		title : '仓库信息',
		url : '/WorkSheet/depotpage',
		method : 'get',
		toolbar : '#toolbar',
		pagination : true,
		striped : true,
		rownumbers : true,
		fitColumns : true,
		singleSelect : true,
		columns : [ [ {
			field : 'depotno',
			title : '仓库编号',
			width : 50
		}, {
			field : 'depotName',
			title : '仓库名称',
			width : 50
		}, {
			field : 'loc',
			title : '仓库所在地',
			width : 50
		}, ] ]
	});
});

var url;
var method;

// 新增仓库信息
function newDepot() {
	$('#dlg').dialog('open').dialog('setTitle', '新增仓库'); 	// 弹出显示 Dialog
	$('#fm').form('clear'); 									// 清空 Dialog上 的 form 表单
	$('#depotno').val(0);
	url = '/WorkSheet/depot'; 									// 设置全局变量url
	method = 'post'; 											// 设置全局变量method
	
	console.info('debug: ' + $('#depotno').val());
}

// 修改某仓库信息。需要在 DataGrid 中选中某行。
function editDepot() {
	var row = $('#dg').datagrid('getSelected'); 				// 获得用户选中的 Datagrid 中的一行
	if (row) {
		$('#dlg').dialog('open').dialog('setTitle', '修改仓库');
		$('#fm').form('load', row);
		url = '/WorkSheet/depot';
		method = 'put';
	}
}

// 通用功能：新增和修改最后都会调用到它。被 Dialog 上的确定按钮触发
function saveDepot() {

	var obj = {}; 						// 声明一个对象，此时该对象无任何属性
	
	obj.depotno = $('#depotno').val();	        			// 此后，该对象就有了一个 depotno 属性
	obj.depotName = $('#depotName').val(); 					// 此后，该对象就有了一个 depotName 属性
	obj.loc = $('#loc').val(); 								// 此后，该对象就有了一个 loc 属性
	
	console.info(JSON.stringify(obj));						// 将 js 对象转化为 json 字符串

	$.ajax({ 
		url: url, 											// 请求地址
		method: method,										// 请求方式
		contentType:"application/json", 
		data: JSON.stringify(obj), 
		success : function(result) { 						// 服务端回数据之后，执行的回调函数
			var result = eval('(' + result + ')'); 
			if (result.code == 200||result.code == 201) { 	// 操作成功 200为更新操作，201为新增操作
				$('#dlg').dialog('close'); 					// 关闭 Dialog 
				$('#dg').datagrid('reload'); 				// 重新加载 DataGrid 
			} 
		} 
	});

}

// 删除指定仓库。需要用户在 datagrid 中选中一行
function removeDepot() {
	var row = $('#dg').datagrid('getSelected');
	if (row) {
		$.messager.confirm('确定', '是否确定删除该仓库?', function(r) { 			// 要求用户确认删除
			if (r) {
				$.ajax({
					url : '/WorkSheet/depot/' + row.depotno,
					type : 'delete',
					success : function(result) {
						var result = eval('(' + result + ')');
						if (result.code == 204) { // 操作成功
							$('#dg').datagrid('reload'); // 重新加载 DataGrid
						}
					}
				});

			}
		});
	}
}

function refresh() {
	$('#dg').datagrid({												// 初始化 表格的信息
		title : '仓库信息',
		url : '/WorkSheet/depotpage',
		method : 'get',
		toolbar : '#toolbar',
		pagination : true,
		striped : true,
		rownumbers : true,
		fitColumns : true,
		singleSelect : true,
		columns : [ [ {
			field : 'depotno',
			title : '仓库编号',
			width : 50
		}, {
			field : 'depotName',
			title : '仓库名称',
			width : 50
		}, {
			field : 'loc',
			title : '仓库所在地',
			width : 50
		}, ] ]
	});
}
