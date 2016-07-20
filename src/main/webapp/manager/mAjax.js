var req;

function add1ToStatus(id,oid,toUrl) {
	//禁止，那个按钮。
	var button = document.getElementById(id);
	button.disabled=true;
	// 获取表单提交的内容
	//var idField = document.getElementById("oid");
	// 访问validate.do这个servlet，同时把获取的表单内容idField加入url字符串，以便传递给validate.do
	var url = toUrl+"?oid=" + escape(oid);
	// 创建一个XMLHttpRequest对象req
	if (window.XMLHttpRequest) {
		// IE7, Firefox, Opera支持
		req = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		// IE5,IE6支持
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}
	/*
	 * open(String method,String url, boolean )函数有3个参数
	 * method参数指定向servlet发送请求所使用的方法，有GET,POST等 boolean值指定是否异步，true为使用，false为不使用。
	 * 我们使用异步才能体会到Ajax强大的异步功能。
	 */
	req.open("GET", url, true);
	// onreadystatechange属性存有处理服务器响应的函数,有5个取值分别代表不同状态
	req.onreadystatechange = callback;
	// send函数发送请求
	req.send(null);
}
 
function callback() {
	if (req.readyState == 4 && req.status == 200) {
		var check = req.responseText;
		show(check);
	}
}

function show(str) {
	if (str == "success") {
		window.top.location.reload();

	} else if (str == "error") {
		window.location.href="../error.jsp";
	}
}

function showUsers() {
	document.getElementById("userShowDiv").style.display="";
}