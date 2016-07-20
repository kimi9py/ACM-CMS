<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- saved from url=(0058)http://getbootstrap.com/2.3.2/examples/justified-nav.html# -->
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>用户信息导入</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le styles -->
<link href="${pageContext.request.contextPath}/bootstrap.css"
	rel="stylesheet">
<style type="text/css">
body {
	padding-top: 20px;
	padding-bottom: 60px;
}

/* Custom container */
.container {
	margin: 0 auto;
	max-width: 1000px;
}

.container>hr {
	margin: 60px 0;
}

/* Main marketing message and sign up button */
.jumbotron {
	margin: 80px 0;
	text-align: center;
}

.jumbotron h1 {
	font-size: 100px;
	line-height: 1;
}

.jumbotron .lead {
	font-size: 24px;
	line-height: 1.25;
}

.jumbotron .btn {
	font-size: 21px;
	padding: 14px 24px;
}

/* Supporting marketing content */
.marketing {
	margin: 60px 0;
}

.marketing p+h4 {
	margin-top: 28px;
}

/* Customize the navbar links to be fill the entire space of the .navbar */
.navbar .navbar-inner {
	padding: 0;
}

.navbar .nav {
	margin: 0;
	display: table;
	width: 100%;
}

.navbar .nav li {
	display: table-cell;
	width: 1%;
	float: none;
}

.navbar .nav li a {
	font-weight: bold;
	text-align: center;
	border-left: 1px solid rgba(255, 255, 255, .75);
	border-right: 1px solid rgba(0, 0, 0, .1);
}

.navbar .nav li:first-child a {
	border-left: 0;
	border-radius: 3px 0 0 3px;
}

.navbar .nav li:last-child a {
	border-right: 0;
	border-radius: 0 3px 3px 0;
}
</style>
<link
	href="${pageContext.request.contextPath}/bootstrap-responsive.css"
	rel="stylesheet">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->

<!-- Fav and touch icons -->
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="http://getbootstrap.com/2.3.2/assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="http://getbootstrap.com/2.3.2/assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="http://getbootstrap.com/2.3.2/assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="http://getbootstrap.com/2.3.2/assets/ico/apple-touch-icon-57-precomposed.png">
<link rel="shortcut icon"
	href="http://getbootstrap.com/2.3.2/assets/ico/favicon.png">
</head>

<body>

	<div class="container">

		<div class="masthead">
			<h3 class="muted">ACM 后台管理系统</h3>

			<div class="navbar">
				<div class="navbar-inner">
					<div class="container">
						<ul class="nav">
							<li><a href="welcome.action">首页</a></li>
							<li class="active"><a href="userImportShow.action">用户管理</a></li>
							<li><a href="contestImportShow.action">比赛信息</a></li>
							<li><a href="problemImportShow.action">试题管理</a></li>
							<li><a href="reservationImportShow.action">比赛分配</a></li>
							<li><a href="../me.jsp">联系作者</a></li>
						</ul>
					</div>
				</div>
			</div>
			<!-- /.navbar -->
		</div>

		<!--/span-->
		<div class="span9 main-content row-fluid">
			<h3 class="muted">单用户导入</h3>

			<form action="../commit/userImportCommit.action" method="post"
				class="form-horizontal" id="quckOrderForm">
				<!-- <div class="alert alert-error hide">
						<button class="close" data-dismiss="alert"></button>
						您的输入有误
					</div>
					<div class="alert alert-success hide">
						<button class="close" data-dismiss="alert"></button>
						验证成功!
					</div> -->
				<div class="control-group">
					<label class="control-label">用户学号</label>
					<div class="controls">
						<input type="userid" name="userid" required="true"
							class="span4 m-wrap"><font
							style="font-weight: bold; font-size: 16px;" color="red">*</font>
						<span for="name" class="help-inline"></span>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">用户姓名</label>
					<div class="controls">
						<input type="name" name="name" required="true"
							class="span4 m-wrap"><font
							style="font-weight: bold; font-size: 16px;" color="red">*</font>
						<span for="name" class="help-inline"></span>
					</div>
				</div>

				<div class="control-group">
					<label class="control-label">所在班级</label>
					<div class="controls">
						<input name="school" type="text" required="true"
							class="span4 m-wrap"> <font
							style="font-weight: bold; font-size: 16px;" color="red">*</font>
						<span for="tel" class="help-inline"></span>
					</div>
				</div>


				<div class="control-group">
					<label class="control-label">昵称</label>
					<div class="controls">
						<input type="text" name="nick" required="true"
							class="span4 m-wrap"><font
							style="font-weight: bold; font-size: 16px;" color="red">*</font>
						<span for="name" class="help-inline"></span>
					</div>
				</div>

				<div class="control-group">
					<label class="control-label">邮箱</label>
					<div class="controls">
						<input name="email" type="text" required="true"
							class="span4 m-wrap"> <font
							style="font-weight: bold; font-size: 16px;" color="red">*</font>
						<span for="tel" class="help-inline"></span>
					</div>
				</div>




				<div class="control-group">
					<label class="control-label">擅长语言</label>
					<div class="controls">
						<input name="language" type="text" class="span4 m-wrap"
							number="true"> <span for="weight" class="help-inline"></span>
					</div>
				</div>


				<div class="control-group">
					<div class="controls">
						<button type="submit" class="btn btn-primary">
							<i class="icon-ok icon-white"></i>确定
						</button>
					</div>
				</div>

			</form>

		</div>
		<!-- span9 -->

		<div class="span9 main-content row-fluid">
			<h3 class="muted">批量用户导入</h3>

			<form action="../file/upload.action" method="post"
				class="form-horizontal" id="quckOrderForm"
				enctype="multipart/form-data">

				<div class="control-group">
					<label class="control-label">选择文件</label>
					<div class="controls">
						<input type="file" name="file" /> <span for="note"
							class="help-block">注: 只支持Excel文件.</span> <a
							href="../users_template.xls"> 请下载模板后填写！！</a>
					</div>
				</div>

				<div class="control-group">
					<div class="controls">
						<button type="submit" class="btn btn-primary">
							<i class="icon-ok icon-white"></i>确定
						</button>
					</div>
				</div>

			</form>

		</div>

		<div class="btn-group">
			<button class="btn btn-small" onclick="javascript:showUsers()">显示已有的用户</button>

		</div>
		<div id="userShowDiv" style="display: none">
			<div class="span9 main-content row-fluid"></div>
			<table class="table table-hover">
				<tr class="success">
					<td>编号</td>
					<td>用户id</td>
					<td>电邮</td>
					<td>昵称</td>
					<td>删除</td>
					<td>修改</td>
				</tr>
				<c:forEach var="xx" items="${users}" varStatus="i">
					<tr class="success">
						<td></td>
						<td>${xx.user_id }</td>
						<td>${xx.email}</td>
						<td>${xx.nick}</td>
						<td><a class="btn btn-danger"
							href="../commit/userd.action?id=${xx.user_id }"> <font
								color="white">删除</font></a></td>
						<td><a class="btn btn-warning"
							href="../manager/userModify.action?user_id=${xx.user_id }"> <font
								color="white">修改</font>
						</a></td>

					</tr>
				</c:forEach>
			</table>
		</div>





		<!-- span9 -->
		<footer>
			<p>© dhuacm 2014</p>
		</footer>
	</div>
	<!-- /container -->
	<script src="mAjax.js">
		
	</script>


</body>
</html>
