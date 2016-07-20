<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- top  -->
<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container-fluid">
			<button type="button" class="btn btn-navbar" data-toggle="collapse"
				data-target=".nav-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="brand" href="/RecruitmentProcess">RP
			</a>
			<div class="nav-collapse collapse">
				<p class="navbar-text pull-right">
					您好! <a href=""
						class="navbar-link">${currentUser.name}</a>  
						 
				</p>
				<ul class="nav">
					<li class="active"><a
						href="">首页 </a></li>
					<li><a href="../me.jsp">关于作者
					</a></li>
					 
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
</div>