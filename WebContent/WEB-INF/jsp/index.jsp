<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/WorkSheet/images/favicon.ico">

    <title>工作单管理</title>

    <!-- Bootstrap core CSS -->
    <link href="/WorkSheet/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="/WorkSheet/bootstrap/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
    <link href="/WorkSheet/css/dashboard.css" rel="stylesheet">

    <script src="/WorkSheet/bootstrap/assets/js/ie-emulation-modes-warning.js"></script>
    <script src="/WorkSheet/js/index.js?t=" + Math.random()></script>
    
</head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand">工作单管理</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">关于</a></li>
          </ul>
          <!-- <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form> -->
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
      	<!-- 左侧导航栏信息 -->
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li id="depots" class="active"><a onclick="refresh('depots','仓库信息')">仓库信息管理 <span class="sr-only">(current)</span></a></li>
            <li id="products"><a onclick="refresh('products','产品信息')">产品信息管理</a></li>
            <li id="depotitems"><a onclick="refresh('depotitems','库存信息')">库存信息管理</a></li>
          </ul>
        </div>
        
        <!-- 右侧内容 -->
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 id="content_title" class="page-header">仓库信息</h1>

          <div id="content_right" class="row placeholders">
          
          	<%-- <%@include file="depot.jsp" %> --%>
          	<%-- <jsp:include page="depots.jsp" flush="true"/> --%>
          	<iframe id="miframe" src="" style="width: 100%; height:530px;border: 0px;"></iframe>
          	
          </div>
        </div>
      </div>
    </div>
	
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <script>window.jQuery || document.write('<script src="/WorkSheet/bootstrap/assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="/WorkSheet/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="/WorkSheet/bootstrap/assets/js/vendor/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="/WorkSheet/bootstrap/assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
