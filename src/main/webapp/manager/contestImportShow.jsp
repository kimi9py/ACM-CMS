<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<!-- saved from url=(0058)http://getbootstrap.com/2.3.2/examples/justified-nav.html# -->
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>比赛信息录入</title>
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
<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.8.3/jquery.min.js">
	
</script>
<script type="text/javascript"
	src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js">
	
</script>
<script type="text/javascript"
	src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.min.js">
	
</script>
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
							<li><a href="userImportShow.action">用户管理</a></li>
							<li class="active"><a href="contestImportShow.action">比赛信息</a></li>
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
			<h3 class="muted">比赛信息录入</h3>

			<form action="../commit/contestImportCommit.action" method="post"
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
					<label class="control-label">比赛名称</label>
					<div class="controls">
						<input type="text" name="title" required="true"
							class="span4 m-wrap"><font
							style="font-weight: bold; font-size: 16px;" color="red">*</font>
						<span for="name" class="help-inline"></span>
					</div>
				</div>

				<div class="control-group">
					<label class="control-label">开始时间</label>
					<!-- <div class="controls">
						<input name="start_time" type="text" required="true"
							class="span4 m-wrap"> <font
							style="font-weight: bold; font-size: 16px;" color="red">*</font>
						<span for="tel" class="help-inline"></span>
					</div> -->
					<div id="start_datetimepicker" class="controls">
						<input name="start_time" type="text" required="true"></input> <span
							class="add-on"> <i data-time-icon="icon-time"
							data-date-icon="icon-calendar"></i>
						</span>
					</div>

					<script type="text/javascript">
						$('#start_datetimepicker').datetimepicker({
							format : 'MM/dd/yyyy hh:mm',
							language : 'en',
							pickDate : true,
							pickTime : true,
							hourStep : 1,
							minuteStep : 15,
							secondStep : 30,
							inputMask : true
						});
					</script>
				</div>
				<div class="control-group">
					<label class="control-label">结束时间</label>

					<div id="end_datetimepicker" class="controls">
						<input name="end_time" type="text" required="true"></input> <span
							class="add-on"> <i data-time-icon="icon-time"
							data-date-icon="icon-calendar"></i>
						</span>
					</div>
					<script type="text/javascript">
						$('#end_datetimepicker').datetimepicker({
							format : 'MM/dd/yyyy hh:mm',
							language : 'en',
							pickDate : true,
							pickTime : true,
							hourStep : 1,
							minuteStep : 15,
							secondStep : 30,
							inputMask : true
						});
					</script>

				</div>

				<div class="control-group">
					<label class="control-label">比赛描述</label>
					<div class="controls">
						<input name="description" type="text" required="true"
							class="span4 m-wrap"> <font
							style="font-weight: bold; font-size: 16px;" color="red">*</font>
						<span for="tel" class="help-inline"></span>
					</div>
				</div>



				<div class="control-group">
					<label class="control-label">试题路径</label>
					<div class="controls">
						<input name="paper_path" type="text" class="span4 m-wrap"
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
		</div>
		<!-- span9 -->

		<div class="btn-group">
			<button class="btn btn-small" onclick="javascript:showUsers()">显示已有的比赛</button>

		</div>
		<div id="userShowDiv" style="display: none">
			<div class="span9 main-content row-fluid"></div>
			<table class="table table-hover">
				<tr class="success">
					<td>编号</td>
					<td>比赛id</td>
					<td>title</td>
					<td>开始时间</td>
					<td>结束时间</td>
					<td>试卷路径</td>
					<td>删除</td>
					<td>修改</td>
				</tr>
				<c:forEach var="xx" items="${contests}" varStatus="i">
					<tr class="success">
						<td></td>
						<td>${xx.contest_id }</td>
						<td>${xx.title}</td>
						<td>${xx.start_time}</td>
						<td>${xx.end_time}</td>
						<td>${xx.paper_path}</td>
						<td><a class="btn btn-danger"
							href="../commit/cond.action?id=${xx.contest_id  }"> <font
								color="white">删除</font></a></td>
						<td><a class="btn btn-warning" href="../manager/contestModify.action?id=${xx.contest_id  }"> <font color="white">修改</font>
						</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>


		<div class="footer">
			<p>© dhuacm 2014</p>
		</div>

	</div>
	<!-- /container -->

	<!-- Le javascript
    ================================================== -->

	<script src="mAjax.js">
		
	</script>


</body>
</html>
