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
    <title>注册</title>

    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet">

</head>

  <body class="login-body">
      
      <div class="login-logo">
          <img src="images/logo.PNG" alt="smart"/>
      </div>

      <h2 class="form-heading">注册</h2>
      <div class="container log-row">
      	<form id="form" class="form-signin" action="/login/register" method="post" enctype="multipart/form-data"> 
        	<div class="login-wrap">
              	<span style="color:#f36616" id="warning_id"></span>
               	<input type="text" id="user_id" name="user_id" class="form-control" placeholder="用户ID" autofocus>
                <span style="color:#f36616" id="warning_name"></span>
                <input type="text" id="user_name" name="user_name" class="form-control" placeholder="用户名" autofocus>
                <span style="color:#f36616" id="warning_pwd"></span>
                <input type="password" id="user_pwd" name="user_pwd" class="form-control" placeholder="密码">
                <span style="color:#f36616" id="warning_repwd"></span>
                <input type="password" id="reuser_pwd" name="reuser_pwd" class="form-control" placeholder="确认密码">
                <span style="color:#f36616" id="warning_age"></span>
               	<input type="text" id="user_age" name="user_age" class="form-control" placeholder="年龄" autofocus>
               	<span style="color:#f36616" id="warning_phone"></span>
               	<input type="text" id="user_phone" name="user_phone" class="form-control" placeholder="联系电话" autofocus>

                <button class="btn btn-lg btn-success btn-block" type="submit">注册</button>
				<div class="radio-custom radio-success">
                	<input type="radio" value="男" checked="checked" name="gender" id="male">
                  	<label for="male">男</label>
                  	<input type="radio"  value="女" name="gender" id="female">
                  	<label for="female">女</label>
              	</div>

                <div class="registration m-t-20 m-b-20">
                	已有账号.请直接
                  	<a class="" href="login.jsp">
                      	登录
                  	</a>
              	</div>

            </div>
		</form> 
      </div>

      <script src="js/jquery.min.js"></script>
      <script src="js/bootstrap.min.js"></script>
      <script src="js/respond.min.js"></script>
	<script src="js/jquery.form.js" type="text/javascript"></script>  
	
  </body>
  

<script type="text/javascript">  	
		
	 $(function () {
	    $(":submit").click(function (e) {
	    	e.preventDefault();
	    	var user_gender = $("input[name='gender']:checked").val();	
	        var user_id = document.getElementById("user_id").value;
	        var user_name = document.getElementById("user_name").value;
	        var user_pwd = document.getElementById("user_pwd").value;
	        var reuser_pwd = document.getElementById("reuser_pwd").value;
	        var user_phone = document.getElementById("user_phone").value;
	        var user_age = document.getElementById("user_age").value;
	    	$.ajax({
                type:'POST',
                url:"http://localhost:8080/login/register",
                async:true,
	            data:{
                    'user_id':user_id,
                    'user_name':user_name,
                    'user_pwd':user_pwd,
                    'reuser_pwd':reuser_pwd,
                    'user_gender':user_gender,
                    'user_age':user_age,
                    'user_phone':user_phone
                }, 
                dataType:'json',
                success:function(result){
                	var flag = result["flag"];              	
                	$("span").empty();
                	if(flag == "id为空")
                		document.getElementById("warning_id").innerHTML = "请输入id";                   	              	
                	else if(flag == "name为空")
                		document.getElementById("warning_name").innerHTML = "请输入用户名";             	
                	else if(flag == "pwd为空")
                		document.getElementById("warning_pwd").innerHTML = "请输入密码";            	
                	else if(flag == "id已存在")
                		document.getElementById("warning_id").innerHTML = "id已存在";               	
                	else if(flag == "age输入错误"){
                		document.getElementById("warning_age").innerHTML = "年龄应为数字  0-100";
                		$("#user_age").val("");
                	}
                	else if(flag == "phone输入错误"){
                		document.getElementById("warning_phone").innerHTML = "联系电话应为数字";
                		$("#user_phone").val("");
                	}
                	else if(flag == "pwd不一致"){
                		document.getElementById("warning_pwd").innerHTML = "两次输入不一致，请重新输入";
                		$("#user_pwd").val("");
                		$("#reuser_pwd").val("");
                	}
                	else{
                		var param = encode64(flag);
	                	window.location.href="http://localhost:8080/user/" + param + "/home";
                	}
 				},
 				error:function(error){
 					var jsonData = JSON.stringify(error);
                    alert("login error: " + jsonData);
                }
                        
			}) 
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