<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- saved from url=(0041)http://v2.bootcss.com/examples/fluid.html -->
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>RecruitmentProcess</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le styles -->
<link href="http://v2.bootcss.com/assets/css/bootstrap.css"
	rel="stylesheet">
<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) {
	/* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>
<link href="http://v2.bootcss.com/assets/css/bootstrap-responsive.css"
	rel="stylesheet">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->

<!-- Fav and touch icons -->
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="http://v2.bootcss.com/assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="http://v2.bootcss.com/assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="http://v2.bootcss.com/assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="http://v2.bootcss.com/assets/ico/apple-touch-icon-57-precomposed.png">
<link rel="shortcut icon"
	href="http://v2.bootcss.com/assets/ico/favicon.png">

<style>
.timeline {
	position: relative;
}

.line-list {
	
}

.line-list:before {
	position: absolute;
	top: 3px;
	left: 0px;
	width: 1px;
	display: block;
	background: #ccc;
	content: '';
	height: 95%;
	overflow: hidden;
	z-index: 1;
}

.item {
	position: relative;
	padding-bottom: 10px;
}

.item img {
	left: -6px;
	display: block;
	z-index: 2;
	position: absolute;
}

.item-content {
	padding-left: 10px;
}

.item .time {
	display: block;
	color: #ef800d;
	font-size: 16px;
	padding-bottom: 5px;
}
</style>


</head>

<body>

	<%@include file="../common/top.jsp"%>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span2">
				<div class="well sidebar-nav">
					<ul class="nav nav-list">
						<li class="nav-header">部门申请</li>
						<li  ><a
							href="quickOrderShow.action">快速申请</a></li>


						<li class="nav-header">部门职位申请录</li>
						<li ><a href="unpaidOrders.action">待提交申请</a></li>
						<li><a href="paidOrders.action">已提交申请</a></li>
						<li class="nav-header">流程进行中</li>
						<li class="active"><a href="untransportingOrders.action">未完成申请</a></li>
						<li><a href="transportingOrders.action">进行中申请</a></li>
						<li><a href="transportedOrders.action">已完成申请</a></li>

						
							<li class="nav-header">我的信息</li>
						<li><a href="accountShow.action">我的部门</a></li>
					</ul>
				</div>
				<!--/.well -->
			</div>
			<!--/span-->
			<div class="span9 main-content">
				<h2 class="title-line">未开始审核的申请书详情</h2>
				<div class="progress progress-info progress-striped">
					<div class="bar" style="width: 10%"></div>
				</div>
				<div class="well">
					<div class="tabbable tabs-left">
						<ul class="nav nav-tabs" style="margin-right: 0">
							<li class="active"><a href="#lA" data-toggle="tab"> 申请书编号：
									${untransportingOrder.oid}</a></li>

						</ul>
						<div class="tab-content"
							style="background-color: #fff; padding-left: 20px; padding-top: 5px;">
							<div class="tab-pane active timeline" id="lA">

								<div class="line-list">

									<div class="item">
										<img src="dot.gif" />
										<div class="item-content">
											<span class="time">${untransportingOrder.orderTime}</span>
											部门主管已提交申请书
										</div>
									</div>


								</div>

							</div>

						</div>
					</div>
				</div>
				<!-- well -->
			</div>
			<!-- span9 -->
		</div>
		<!--/row-->



		<footer>
			<p>© xxx 2013</p>
		</footer>

	</div>
	<!--/.fluid-container-->

	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

	<script src="Ajax.js">
		
	</script>
</body>
</html>
