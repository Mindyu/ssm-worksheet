<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html style="height:98%;">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="jquery,ui,easy,easyui,web">
<meta name="description"
	content="easyui help you build your web page easily!">
<title>管理员登录界面</title>
<link rel="stylesheet" type="text/css" href="/WorkSheet/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="/WorkSheet/easyui/themes/icon.css">

<script type="text/javascript" src="/WorkSheet/easyui/jquery.min.js"></script>
<script type="text/javascript" src="/WorkSheet/easyui/jquery.easyui.min.js"></script>

<link rel="stylesheet" type="text/css" href="/WorkSheet/css/login.css">
<script type="text/javascript" src="/WorkSheet/js/login.js?t=" + Math.random()></script>    <!-- ?t=" + Math.random() -->

<title>登录</title>
</head>

<body>

	<div id="container">

		<div id="header">
			<h1>Welcome</h1>
		</div>
		
		<div id="content">
			<form>
				<p>
					<input id="username" type="text" placeholder="username">
				</p>
				<p>																<!-- 键盘事件，若点击回车则直接登录 -->
					<input id="password" type="password" placeholder="password" onkeydown='if(event.keyCode==13){login();}'>
				</p>
				<p>
					<input type="button" value="loging" onclick="login();">
				</p>
			</form>
		</div>
	
	</div>
	
</body>
</html>