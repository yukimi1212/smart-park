<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Admin Template">
    <meta name="keywords" content="admin dashboard, admin, flat, flat ui, ui kit, app, web app, responsive">
    <link rel="shortcut icon" href="images/ico/favicon.png">
    <title>登录</title>

    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet">

</head>

  <body class="login-body">
      
      <div class="login-logo">
          <img src="images/logo.PNG" alt="smart"/>
      </div>

      <h2 class="form-heading">登录</h2>
      <div class="container log-row">
      	<form id="form" class="form-signin" action="/login/user" method="get" enctype="multipart/form-data"> 
              <div class="login-wrap">
              	  <span style="color:#f36616" id="warning_id"></span>
                  <input type="text" id="user_id" name="user_id" class="form-control" placeholder="用户id" autofocus>
                  <span style="color:#f36616" id="warning_pwd"></span>
                  <input type="password" id="user_pwd" name="user_pwd" class="form-control" placeholder="密码">
                  <button class="btn btn-lg btn-success btn-block" type="submit">登录</button>
                  <div class="registration">
                      	还未注册?
                      <a class="" href="registration.jsp">
                          	创建账号
                      </a>
                  </div>

              </div>
		</form> 
      </div>

      <script src="js/jquery-1.11.1.min.js"></script>
      <script src="js/bootstrap.min.js"></script>
      <script src="js/respond.min.js"></script>
	<script src="js/jquery.form.js" type="text/javascript"></script>  
	
  </body>
  

<script type="text/javascript">  	
	
	$(function () {
	    $(":submit").click(function () {
	        var options = {
	            url: "http://192.168.60.16:8080/login/user",
	            success: function (data) {
	                var n = data.split("|");	
	                alert(n[1]);
	                $("span").empty();
	                if(n[1] == "id为空"){
	                	document.getElementById("warning_id").innerHTML = "请输入id";
	                }
	                else if(n[1] == "密码为空"){
	                	document.getElementById("warning_pwd").innerHTML = "请输入密码";
	                }	
	                else if(n[1] == "不存在"){
	                	document.getElementById("warning_id").innerHTML = "用户名或密码错误，请重新输入";
	                	$("#user_id").val("");
                		$("#user_pwd").val("");
	                }	
	                else{
	                	var param = encode64(n[1]);
	                	window.location.href="http://192.168.60.16:8080/user/" + param + "/home";
	                }
	            }
	        };
	        $("#form").ajaxForm(options);
	    })
	})
	
	var keyStr = "ABCDEFGHIJKLMNOP" + "QRSTUVWXYZabcdef" + "ghijklmnopqrstuv" + "wxyz0123456789+/" + "=";  

	function encode64(input) {  
		var output = "";  
		var chr1, chr2, chr3 = "";  
		var enc1, enc2, enc3, enc4 = "";  
		var i = 0;  
		do {  
    		chr1 = input.charCodeAt(i++);  
    		chr2 = input.charCodeAt(i++);  
    		chr3 = input.charCodeAt(i++);  
    		enc1 = chr1 >> 2;  
    		enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);  
    		enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);  
    		enc4 = chr3 & 63;  
    		if (isNaN(chr2)) {  
        		enc3 = enc4 = 64;  
    		} else if (isNaN(chr3)) {  
        		enc4 = 64;  
    		}  
    		output = output + keyStr.charAt(enc1) + keyStr.charAt(enc2) + keyStr.charAt(enc3) + keyStr.charAt(enc4);  
    		chr1 = chr2 = chr3 = "";  
    		enc1 = enc2 = enc3 = enc4 = "";  
		} while (i < input.length);  

		return output;  
	}  
</script> 
</html>