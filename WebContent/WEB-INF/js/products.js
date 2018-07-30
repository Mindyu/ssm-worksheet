$(function() {
	$('#dg').datagrid({
		title : '产品信息',
		url : '/WorkSheet/productpage',
		method : 'get',
		toolbar : '#toolbar',
		pagination : true,
		striped : true,
		rownumbers : true,
		fitColumns : true,
		singleSelect : true,
		columns : [ [ {
			field : 'prodId',
			title : '产品编号',
			width : 50
		}, {
			field : 'prodName',
			title : '产品名称',
			width : 50
		}, {
			field : 'prodPrice',
			title : '产品价格',
			width : 50
		}, {
			field : 'prodDesc',
			title : '产品描述',
			width : 150
		}, ] ]
	});
});

var url;
var method;

function newProduct() {
	$('#dlg').dialog('open').dialog('setTitle', '新增产品'); // 弹出/显示 Dialog
	$('#fm').form('clear'); 		// 清空 Dialog上 的 form 表单
	$('#prodId').val(0);
	url = '/WorkSheet/product'; 	// 设置全局变量url
	method = 'post'; 				// 设置全局变量method
	
	console.info('debug: ' + $('#prodId').val());
}

// 修改某部门信息。需要在 DataGrid 中选中某行。
function editProduct() {
	var row = $('#dg').datagrid('getSelected'); // 获得用户选中的 Datagrid 中的一行
	if (row) {
		$('#dlg').dialog('open').dialog('setTitle', '修改产品');
		$('#fm').form('load', row);
		url = '/WorkSheet/product';
		method = 'put';
	}
}


// 通用功能：新增和修改最后都会调用到它。被 Dialog 上的确定按钮触发
function saveProduct() {

	var obj = {}; // 声明一个对象，此时该对象无任何属性

	obj.prodId = $('#prodId').val();// 此后，该对象就有了一个 deptno 属性
	obj.prodName = $('#prodName').val(); 	// 此后，该对象就有了一个 dname 属性
	obj.prodPrice = $('#prodPrice').val(); 		// 此后，该对象就有了一个 loc 属性
	obj.prodDesc =  $('#prodDesc').val();
	console.info(JSON.stringify(obj));

	$.ajax({ 
		url: url, 
		method: method,
		contentType:"application/json", 
		data: JSON.stringify(obj), 
		success : function(result) { // 服务端回数据之后，执行的回调函数
			var result = eval('(' + result + ')'); 
			if (result.code == 200 || result.code == 201) { // 操作成功
				$('#dlg').dialog('close'); // 关闭 Dialog 
				$('#dg').datagrid('reload'); // 重新加载 DataGrid 
			} 
		} 
	});
}

// 删除指定部门。需要用户在 datagrid 中选中一行
function removeProduct() {
	var row = $('#dg').datagrid('getSelected');
	if (row) {
		$.messager.confirm('确定', '是否确定删除该产品?', function(r) { // 要求用户确认删除
			if (r) {
				$.ajax({
					url : '/WorkSheet/product/' + row.prodId,
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


/*
 * $.post ('', {id:row.id}, function(result) { if
 * (result.success) { $('#dg').datagrid('reload'); // reload the
 * user data } else { $.messager.show({ // show error message
 * title: 'Error', msg: result.msg }); } },'json'); }
 */