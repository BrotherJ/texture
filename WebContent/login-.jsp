<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
	String basePath =request.getContextPath();
	if(basePath==""){
		basePath="/texture";
	}
%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<% 
	response.setHeader("Pragma","No-cache");
	response.setHeader("Cache-Control","no-cache"); 
	response.setDateHeader("Expires", 0); 
%>  
<title>用户登录</title>
<link href="<%=basePath %>/css/User_Login.css" type="text/css" rel="stylesheet">
<script src="<%=basePath %>/js/jquery-1.5.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
	document.onkeydown=function(event){  
		var e = event || window.event || arguments.callee.caller.arguments[0];        
		//enter 键
		if(e && e.keyCode==13){ 
			login();
		}        
	}; 

	function login(){
		var account = $("#account").val();
		var password= $("#password").val();
		if(account ==""){
			alert("请输入账号！");
			return false;
		}
		if(password==""){
			alert("请输入密码！");
			return faslse;
		}
		$.ajax({ 
            cache: true, 
            type: "POST", 
            url:"<%=basePath %>/doLogin", 
            data:$('#loginForm').serialize(),// 你的formid 
            async: false, 
            error: function(request) { 
                alert("Connection error"); 
            }, 
            success: function(data) {
            	var result = eval('(' + data + ')'); 
            	//判断是否登录成功
            	if(result.succeed){
            		window.location.href="<%=basePath %>/index"
            	}else{
            		alert("账号密码不正确！");
            		return false;
            	}
            } 
        }); 
	}
</script>
</head>
<body id="userlogin_body">
	<form action="doLogin" method="post" id="loginForm">
	<div id=user_login>
		<dl>
			<dd id=user_top>
				<ul>
					<li class=user_top_l></LI>
					<li class=user_top_c></li>
					<li class=user_top_r></li>
				</ul>
				<dd id=user_main>
			<ul>
				<li class=user_main_l></li>
				<li class=user_main_c>
					<div class=user_main_box>
						<ul>
							<li class=user_main_text>账号： </li>
							<li class=user_main_input><INPUT type="text" class=TxtUserNameCssClass  id="account" name="account" maxLength=20 /> </li>
						</ul>
						<ul>
							<li class=user_main_text>密码： </li>
							<li class=user_main_input><INPUT  class=TxtPasswordCssClass  id="password" name="password" type=password /></li>
						</ul>
						<ul>
							<li class=user_main_text> </li>
							<li class=user_main_input><div  id="logDiv"style="display:none;">此处显示新 Div 标签的内容</div> </li>
						</ul>
					</div>
				</li>
				<li class=user_main_r>
					<img src="images/user_botton.gif" onclick="login()" style="cursor:pointer;"/>
				 </li>
			</ul>
			<dd id=user_bottom>
				<ul>
					<li class=user_bottom_l></li>
					<li class=user_bottom_c> </li>
					<li class=user_bottom_r></li>
				</ul>
			</dd>
		</dl>
	</div>
	<SPAN id=ValrUserName style="DISPLAY: none; COLOR: red"></SPAN>
	<SPAN id=ValrPassword style="DISPLAY: none; COLOR: red"></SPAN>
	<SPAN id=ValrValidateCode style="DISPLAY: none; COLOR: red"></SPAN>
	<DIV id=ValidationSummary1 style="DISPLAY: none; COLOR: red"></DIV>
	<DIV></DIV>
	
	</FORM>
</body>

</html>
