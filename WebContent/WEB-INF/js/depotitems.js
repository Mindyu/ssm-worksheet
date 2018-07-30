var selectdepotno=-1;
var selectdepotname;
var url;
var prodName;
var quantity;

$(function() {
	$('#dg').datagrid({
		title : '产品信息',
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
			field : 'quantity',
			title : '产品数量',
			width : 50
		}, {
			field : 'prodDesc',
			title : '产品描述',
			width : 100
		}, 
		] ]
	});
	$('#cb').combobox({    
	    url:'/WorkSheet/depot',    
	    valueField:'depotno',    
	    textField:'depotName', 
	    method: 'get',
	    onLoadSuccess: function(){
	    	var data= $(this).combobox("getData");
            if (data.length > 0) {
            	$('#cb').combobox('select', data[0].depotno);
            }
	    },
	    onSelect: function(rec) {
	    	selectdepotno = rec.depotno,
	    	selectdepotname = rec.depotName,
	    	$('#dg').datagrid({
	    		url:'/WorkSheet/depotitempage/'+rec.depotno,
	    		method: 'get'
	    	});
	    	$('#dg').datagrid('reload');
	    }
	});
	$("#cb1").textbox('textbox').keydown(function (e) {
		console.info(e.keyCode);
        if (e.keyCode == 13) {  
        	var productName = $('#cb1').val();
        	console.info(productName);
        	if ("" == productName) {
        		$('#dg').datagrid({
	 	    		url: '/WorkSheet/depotitempage/' + selectdepotno,
	 	    		method: 'get'
	 	    	});
			}else {
				$('#dg').datagrid({
	 	    		url: '/WorkSheet/depotitempage/' + selectdepotno + '/' + productName,
	 	    		method: 'get'
	 	    	});
			}
        	$('#dg').datagrid('reload');
        }  
    });
});

function getDepotitems() {
	console.info(selectdepotno);
	$.ajax({ 
		url:'/WorkSheet/depotitem/'+selectdepotno,
		method: 'get',
		success : function(result) { 			// 服务端回数据之后，执行的回调函数
			var result = eval('(' + result + ')'); 		// 转换成对应的对象数组
			var len=result.length;
			if (len == 0) {
				alert("请先选择一个仓库？");
			}else {
				console.info("Get:"+result);
				prodName=[];
				quantity=[];
				for (var i = 0; i < len; i++) {
					prodName[i] = result[i].prodName;
					quantity[i] = result[i].quantity;
					// console.info(prodName[i] + '--' + quantity[i]);
				}
				showChart();
			}
		} 
	});
}

function showChart() {
	$('#dlg3').dialog('open').dialog('setTitle', selectdepotname); // 弹出/显示 Dialog
	//基于准备好的DOM，初始化echarts实例
	var myChart = echarts.init(document.getElementById('dlg3'));
	//指定图表的配置项和数据
	var option = {
		title : {
			text : selectdepotname
		},
		//提示框组件
		tooltip : {
			//坐标轴触发，主要用于柱状图，折线图等
			trigger : 'axis'
		},
		//图例
		legend : {
			data : [ '库存量' ]
		},
		//横轴
		xAxis : {
			data : prodName
		},
		//纵轴
		yAxis : {},
		//系列列表。每个系列通过type决定自己的图表类型
		series : [ {
			name : '库存量',
			//折线图
			type : 'line',
			data : quantity
		} ]
	};

	//使用刚指定的配置项和数据显示图表
	myChart.setOption(option);
}

function newDepotitem() {
	$('#dlg').dialog('open').dialog('setTitle', '入库'); // 弹出/显示 Dialog
	$('#fm').form('clear'); 		// 清空 Dialog上 的 form 表单
	$('#depotno').val($('#cb').combobox('getValue'));
	$('#prodName').textbox();
	$('#prodId').combobox({
	    url:'/WorkSheet/product',    
	    valueField:'prodId',    
	    textField:'prodId', 
	    method: 'get',
	    onSelect: function(rec) {
	    	console.info('debug'+rec.prodId);
	    	var url1 = '/WorkSheet/product/'+rec.prodId;
	    	console.info(url1);
	    	$.ajax({ 
	    		url: url1, 
	    		method: 'get',
	    		success : function(result) { // 服务端回数据之后，执行的回调函数
	    			var result = eval('(' + result + ')'); 
	    			if (result.code == 200 || result.code == 201) { // 操作成功
	    			console.info(result.data);
	    			var prodName = result.data.prodName;
	    			console.info(prodName);
	    			$('#prodName').textbox('setValue',prodName);
	    			}
	    		} 
	    	});
	    	
	    }		
	});
	
	url = '/WorkSheet/depotitem'; 	// 设置全局变量url
	method = 'post'; 				// 设置全局变量method
	console.info('debug: ' + $('#depotno').val());
}

function saveDepotitem() {

	var obj = {}; // 声明一个对象，此时该对象无任何属性

	obj.prodId = $('#prodId').val();// 此后，该对象就有了一个 deptno 属性
	obj.depotno = $('#depotno').val();
	obj.quantity = $('#quantity').val();
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

function editDepotitem() {
	var row = $('#dg').datagrid('getSelected');// 获得用户选中的 Datagrid 中的一行
	$('#depotno1').val($('#cb').combobox('getValue'));
	$('#prodId1').val(row.prodId);
	
	$('#quantity1').textbox({
		width: '50px',
	});
	console.info('debug: ' + $('#depotno1').val() + ' ' + $('#prodId1').val());
	if (row) {
		$('#dlg1').dialog('open').dialog('setTitle', '修改库存');
		$('#fm1').form('load', row);
		$('#quantity1').textbox('setText',row.quantity);
		$('#quantity1').textbox('setValue',row.quantity);
		url = '/WorkSheet/depotitem';
		method = 'put';
	}
}

function saveEditDepotItem() {
	
	console.info($('#quantity1').textbox('getText'));
	var obj = {}; // 声明一个对象，此时该对象无任何属性
	obj.prodId = $('#prodId1').val();// 此后，该对象就有了一个 deptno 属性
	obj.depotno = $('#cb').combobox('getValue');
	obj.quantity = $('#quantity1').textbox('getText');
	console.info(JSON.stringify(obj));
	$.ajax({ 
		url: url, 
		method: method,
		contentType:"application/json", 
		data: JSON.stringify(obj), 
		success : function(result) { 	// 服务端回数据之后，执行的回调函数
			var result = eval('(' + result + ')'); 
			if (result.code == 200 || result.code == 201) { 	// 操作成功
				$('#dlg1').dialog('close'); 	// 关闭 Dialog 
				$('#dg').datagrid('reload'); 	// 重新加载 DataGrid 
			} 
		} 
	});
}

function removeDepotitem() {
	var row = $('#dg').datagrid('getSelected');
	var depotno =  $('#cb').combobox('getValue');
	var url1 = '/WorkSheet/depotitem/' + depotno +'/' + row.prodId;
	console.info("url 请求删除： " + url1 );
	if (row) {
		$.messager.confirm('确定', '是否确定清除该产品?', function(r) { 			// 要求用户确认删除
			if (r) {
				$.ajax({
					url : '/WorkSheet/depotitem/' + depotno +'/' + row.prodId,
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