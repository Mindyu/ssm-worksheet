/**
 * 
 */

function login() {
	var obj = {};
	obj.username = $('#username').val();
	obj.password = $('#password').val();
	
	console.info(JSON.stringify(obj));						// 将 js 对象转化为 json 字符串
	
	$.ajax({
		url : '/WorkSheet/tologin',							// 请求地址 --对应于 IndexController 中的tologin请求
		method: 'post',										// 请求方式
		contentType:'application/json', 
		data : JSON.stringify(obj),							// 将 js 对象转化为 json 字符串
		success : function(result) {
			var result = eval('(' + result + ')');    		// 将返回的json字符串转换成对象形式
			console.info('成功返回登录信息');
			if (result.code == 200) { 						// 操作成功
				console.info('success:'+result);
				window.location.href='/WorkSheet/index';	// 跳转的主页面
			}else {
				 window.location.href='/WorkSheet/login';
			}
		}
	});
	
}