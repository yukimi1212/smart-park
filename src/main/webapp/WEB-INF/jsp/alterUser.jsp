<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>统计</title>
    <link rel="stylesheet" href="../../vendor/simple-line-icons/css/simple-line-icons.css">
    <link rel="stylesheet" href="../../vendor/font-awesome/css/fontawesome-all.min.css">
    <link rel="stylesheet" href="../../css/styles.css">
    <link rel="shortcut icon" href="../../images/ico/favicon.png">
    
    <style> 		
      	#search input[type=text] {
      		margin:0 auto;
      		width:350px;
      		height:50px;
      		border:1px
        	font-size: 18px;
        	width: 705px;
      	}
      	#search .button {
        	padding: 10px;
        	width: 90px;
      	}
	</style> 
</head>
<body class="sidebar-fixed header-fixed">

<div class="page-wrapper">
    <nav class="navbar page-header">
        <a href="#" class="btn btn-link sidebar-mobile-toggle d-md-none mr-auto">
            <i class="fa fa-bars"></i>
        </a>

        <a href="#" class="btn btn-link sidebar-toggle d-md-down-none">
            <i class="fa fa-bars"></i>
        </a>

        <ul class="navbar-nav ml-auto">

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                	<img src="../../images/user.jpg" class="avatar avatar-sm" alt="user">
                    <span class="small ml-1 d-md-down-none" id="user_name">${user_name }</span>
                    <span id="user_id" style="display:none">${user_id }</span>
                    <span id="user_gender" style="display:none">${user_gender }</span> 
                    <span id="user_age" style="display:none">${user_age }</span>
                    <span id="user_phone" style="display:none">${user_phone }</span>
                </a>					
					
                <div class="dropdown-menu dropdown-menu-right">

					<a href="javascript:void(0)" onclick="jumpToIndex()" class="dropdown-item">                   
                        <i class="fa fa-user"></i> 主页
                    </a>

                    <a href="../../index.jsp" class="dropdown-item">
                        <i class="fa fa-lock"></i> 注销
                    </a>
               	</div>
            </li>
        </ul>
    </nav>

    <div class="main-container">
        <div class="sidebar">
            <nav class="sidebar-nav">
                <ul class="nav">
                    <li class="nav-title">数据展示</li>
					
					<li class="nav-item nav-dropdown ">
                        <a href="#" class="nav-link nav-dropdown-toggle">
                            <i class="icon icon-target"></i> 停车场查询 <i class="fa fa-caret-left"></i>
                        </a>

                        <ul class="nav-dropdown-items">
                        	<li class="nav-item">
                                <a href="javascript:void(0)" id="form" onclick="returnForm()" class="nav-link">
                                    <i class="icon icon-target"></i> 全部查询
                                </a>
                            </li>
                            
                        	<li class="nav-item">
                                <a href="javascript:void(0)" id="formpark" onclick="returnFormParking()" class="nav-link">
                                    <i class="icon icon-target"></i> 按停车场查询
                                </a>
                            </li>
                        
                            <li class="nav-item">
                                <a href="javascript:void(0)" id="formstreet" onclick="returnFormStreet()"  class="nav-link">
                                    <i class="icon icon-target"></i> 按街道查询
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="javascript:void(0)" id="formarea" onclick="returnFormArea()" class="nav-link">
                                    <i class="icon icon-target"></i> 按城区查询
                                </a>
                            </li>

                        </ul>
                    </li>
                    
                    <li class="nav-item nav-dropdown ">
                        <a href="#" class="nav-link nav-dropdown-toggle">
                            <i class="icon icon-target"></i> 停车场统计 <i class="fa fa-caret-left"></i>
                        </a>

                        <ul class="nav-dropdown-items">
                        
                            <li class="nav-item">
                                <a href="javascript:void(0)" onclick="getType()"  class="nav-link">
                                    <i class="icon icon-target"></i> 类型统计
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="javascript:void(0)" onclick="getArea()" class="nav-link">
                                    <i class="icon icon-target"></i> 城区统计
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="javascript:void(0)" onclick="getStreet()" class="nav-link">
                                    <i class="icon icon-target"></i> 街道统计
                                </a>
                            </li>

                        </ul>
                    </li>
                    
					 <li class="nav-item nav-dropdown ">
                        <a href="#" class="nav-link nav-dropdown-toggle">
                            <i class="icon icon-target"></i> 停车记录信息 <i class="fa fa-caret-left"></i>
                        </a>

                        <ul class="nav-dropdown-items">
                        	<li class="nav-item">
                                <a href="javascript:void(0)" onclick="getRecord()" class="nav-link">
                                    <i class="icon icon-graph"></i> 停车记录查询
                                </a>
                            </li>
                        
                            <li class="nav-item">
                                <a href="javascript:void(0)" onclick="getChartArea()"  class="nav-link">
                                    <i class="icon icon-graph"></i> 区域类型统计
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="javascript:void(0)" onclick="getChartTime()" class="nav-link">
                                    <i class="icon icon-graph"></i> 不同时段统计
                                </a>
                            </li>
                        </ul>
                    </li>


                    <li class="nav-item">
                        <a href="javascript:void(0)" onclick="getUser()" class="nav-link active">
                            <i class="icon icon-puzzle"></i> <sapn id="user">个人信息</sapn>
                        </a>
                    </li>
                    
                   
                </ul>
            </nav>
        </div>
		
        <div class="content">   
        	<div id="search">
    			<input type="text" id="searchWord" value="" placeholder="用户ID/用户名" size="18px">
    			<button class="button" type="submit" onclick="doSearch()">搜索</button>
  			</div><br>
  			
            <div class="row">             
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header bg-light" id="name">
                            	
                        </div>

                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table" id="tab">
                                    
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                
                <a id="btn0"></a>		
 				<a id="sjzl"></a>&nbsp;
                <a  href="#" id="btn1">首页</a>
                <a  href="#" id="btn2">&nbsp&nbsp上一页</a>
                <a  href="#" id="btn3">&nbsp&nbsp下一页</a>
                <a  href="#" id="btn4">&nbsp&nbsp尾页</a>&nbsp;
                <a  id="btnTo" >&nbsp&nbsp转到&nbsp;</a>
                <input id="changePage" type="text" size="1" maxlength="4"/>
                <a id="page">页&nbsp;</a>
                <a  href="#" id="btn5">&nbsp&nbsp跳转</a>				
            </div>
        </div>
    </div>
</div>
<script src="../../vendor/jquery/jquery.min.js"></script>
<script src="../../vendor/popper.js/popper.min.js"></script>
<script src="../../vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="../../vendor/chart.js/chart.min.js"></script>
<script src="../../js/carbon.js"></script>
<script src="../../js/demo.js"></script>
</body>

<script type="text/javascript">  

	var pageSize = 15;    //每页显示的记录条数
 	var curPage=0;        //当前页
 	var lastPage;        //最后页
 	var direct=0;        //方向
	var len;            //总行数
	var page;            //总页数
	var begin;
	var end;
    
	function doSearch() {
		var sWord = $("#searchWord").val();
		if(sWord == "")
			returnUser();
		else{
			var user_id = $("#user_id").html();
		    var param = encode64(user_id);
			var url = "http://localhost:8080/admin/" + sWord + "/user";
	        window.location.href=url;
		}
	}

	
	$(document).ready(function(){  
		showForm();
	});
	
	function showForm(){
		var user_id = $("#user_id").html();
		if(user_id == "admin"){
			$("user").empty();
			document.getElementById("user").innerText = "用户管理";
			$.ajax({
	   			type:'GET',
	     		url:'http://localhost:8080/record/admin/user',
	     		async:true,
	     		data:{
	     		},
	     		success:function(result){
	     	    	showData(result);
	     	    	display();
	     		},
	     		error:function(error){
	     			var jsonData = JSON.stringify(error);
	     	    	alert(jsonData)
	     		}
	 		})
		}
		else{
			document.getElementById("search").style.display="none";
			document.getElementById("btn0").style.display="none";
			document.getElementById("sjzl").style.display="none";
			document.getElementById("btn1").style.display="none";
			document.getElementById("btn2").style.display="none";
			document.getElementById("btn3").style.display="none";
			document.getElementById("btn4").style.display="none";
			document.getElementById("btnTo").style.display="none";
			document.getElementById("changePage").style.display="none";
			document.getElementById("page").style.display="none";
			document.getElementById("btn5").style.display="none";
			         
			var param = encode64(user_id);
			$.ajax({
	   			type:'GET',
	     		url:'http://localhost:8080/record/' + param + '/user',
	     		async:true,
	     		data:{
	     		},
	     		success:function(result){
	     	    	showData(result);
	     	    	display();
	     		},
	     		error:function(error){
	     			var jsonData = JSON.stringify(error);
	     	    	alert(jsonData)
	     		}
	 		})
		}
	    
		
	}
	
	function returnForm() {
		var user_id = $("#user_id").html();
	    var param = encode64(user_id);
        var url = "http://localhost:8080/user/" + param + "/form";
        window.location.href=url;
	}
	
	function returnFormParking() {
		var user_id = $("#user_id").html();
	    var param = encode64(user_id);
        var url = "http://localhost:8080/user/" + param + "/formpark";
        window.location.href=url;
	}
	
	function returnFormStreet() {
		var user_id = $("#user_id").html();
	    var param = encode64(user_id);
        var url = "http://localhost:8080/user/" + param + "/formstreet";
        window.location.href=url;
	}
	
	function returnFormArea() {
		var user_id = $("#user_id").html();
	    var param = encode64(user_id);
        var url = "http://localhost:8080/user/" + param + "/formarea";
        window.location.href=url;
	}
	
	function returnUser() {
		var user_id = $("#user_id").html();
	    var param = encode64(user_id);
		var url = "http://localhost:8080/user/" + param + "/user";
		window.location.href=url;
	}
	
	function getType(){
		var user_id = $("#user_id").html();
	    var param = encode64(user_id);
        var url = "http://localhost:8080/user/" + param + "/type";
        window.location.href=url;
	}
 	
	function getArea(){
		var user_id = $("#user_id").html();
	    var param = encode64(user_id);
		var url = "http://localhost:8080/user/" + param + "/area";
		window.location.href=url;
	}
	
	function getStreet() {
		var user_id = $("#user_id").html();
	    var param = encode64(user_id);
		var url = "http://localhost:8080/user/" + param + "/street";
		window.location.href=url;
	} 
	
	function showData(data) {
		var user_id = $("#user_id").html();
		var user_name = $("#user_name").html();
		var user_gender = $("#user_gender").html();
		var user_age = $("#user_age").html();
		var user_phone = $("#user_phone").html();
		$("#tab").html("");
		var str = "<thead><tr><th>用户ID</th><th>用户名</th><th>性别</th><th>年龄</th><th>联系电话</th><th>操作</th></tr></thead><tbody>";
		
		str = str + "<tr><td>" + user_id + "</td><td>" + user_name + "</td><td>" + "<input type=\"text\" id=\"alter_gender\" value=" + user_gender + "/></td><td>" + "<input type=\"text\" id=\"alter_age\" value= " + user_age + "/></td><td>" + "<input type=\"text\" id=\"alter_phone\" value= " + user_phone + "/>";
		str = str + "</td><td><a href=\"javascript:void(0)\" onclick=\"alterUser(this)\">确认修改</a>" + "</td></tr>"; 			
		
		str = str + "</tbody>";
		document.getElementById("name").innerHTML = "用户信息";
		$("#tab").append(str); 
	}
	
	function alterUser(id) {
		var user_id = $("#user_id").html();
	    var param = encode64(user_id);
	    var user_gender = ((document.getElementById("alter_gender").value).split("/"))[0];
	    var user_age = ((document.getElementById("alter_age").value).split("/"))[0];
	    var user_phone = ((document.getElementById("alter_phone").value).split("/"))[0];
		alert(user_gender);
		$.ajax({
   			type:'GET',
     		url:'http://localhost:8080/user/' + param + "/alterU",
     		async:true,
     		data:{
     			'user_gender':user_gender,
     			'user_age':user_age,
     			'user_phone':user_phone
     		},
     		success:function(){
     			var url = "http://localhost:8080/user/" + param + "/user";
     			window.location.href=url;
     		},
     		error:function(error){
     			var jsonData = JSON.stringify(error);
     	    	alert(jsonData)
     		}
 		})
	}
	
	function showRecord(id) {
		var rows = id.parentNode.parentNode.rowIndex;
		var search_id = $("#tab tr:eq(" + rows + ") td:eq(0)").html();
		var param = encode64(search_id);
		var url = "http://localhost:8080/user/" + param + "/record&";
		window.open(url);		
	}

	function getRecord() {
		var user_id = $("#user_id").html();
	    var param = encode64(user_id);
		var url = "http://localhost:8080/user/" + param + "/record";
		window.location.href=url;
	}
	
	
	function getUser() {
		var user_id = $("#user_id").html();
	    var param = encode64(user_id);
		var url = "http://localhost:8080/user/" + param + "/user";
		window.location.href=url;
	}
	
	function getChartArea(){
		var user_id = $("#user_id").html();
	    var param = encode64(user_id);
        var url = "http://localhost:8080/user/" + param + "/chartArea";
        window.location.href=url;
    }	
	
	function getChartTime(){
		var user_id = $("#user_id").html();
	    var param = encode64(user_id);
        var url = "http://localhost:8080/user/" + param + "/chartTime";
        window.location.href=url;
    }
	
	function jumpToIndex() {
		var user_id = $("#user_id").html();
	    var param = encode64(user_id);
    	var url = "http://localhost:8080/user/" + param + "/home";
    	window.open(url);  
	}
	
	function display() {
    	len =$("#tab tr").length - 1;    // 求这个表的总行数，剔除第一行介绍

    	page=len % pageSize==0 ? len/pageSize : Math.floor(len/pageSize)+1;//根据记录条数，计算页数
    	curPage=1;    // 设置当前为第一页
    	displayPage();//显示第一页
    
    	document.getElementById("btn0").innerHTML="当前 " + curPage + "/" + page + " 页&nbsp&nbsp&nbsp每页15条 ";    // 显示当前多少页
   		document.getElementById("sjzl").innerHTML="&nbsp&nbsp&nbsp数据总量 " + len + "&nbsp&nbsp&nbsp";        // 显示数据量       
    
    	$("#btn1").click(function firstPage(){    // 首页
        	curPage=1;
        	direct = 0;
        	displayPage();
    	});	
    	$("#btn2").click(function frontPage(){    // 上一页
    	    direct=-1;
    	    displayPage();
    	});
    	$("#btn3").click(function nextPage(){    // 下一页
    	    direct=1;
       		displayPage();
    	});
    	$("#btn4").click(function lastPage(){    // 尾页
       		curPage=page;
        	direct = 0;
        	displayPage();
    	});
    	$("#btn5").click(function changePage(){    // 转页
    	    curPage=document.getElementById("changePage").value * 1;
    	    if (!/^[1-9]\d*$/.test(curPage)) {
    	        alert("请输入正整数");
    	        return ;
    	    }
    	    if (curPage > page) {
       	    	alert("超出数据页面");
            	return ;
        	}
        	direct = 0;
        	displayPage();
    	});
	}

	function displayPage(){
    	if(curPage <=1 && direct==-1){
        	direct=0;
        	alert("已经是第一页了");
        	return;
    	} else if (curPage >= page && direct==1) {
       		direct=0;
        	alert("已经是最后一页了");
        	return ;
    	}
    
    	lastPage = curPage;
    	
    	// 修复当len=1时，curPage计算得0的bug
    	if (len > pageSize) {
        	curPage = ((curPage + direct + len) % len);
    	} else {
        	curPage = 1;
    	}
    
    	document.getElementById("btn0").innerHTML="当前 " + curPage + "/" + page + " 页&nbsp&nbsp&nbsp每页15条 ";        // 显示当前多少页
    	begin=(curPage-1)*pageSize + 1;// 起始记录号
    	end = begin + 1*pageSize - 1;    // 末尾记录号
     
    	if(end > len ) 
    		end=len;
    	$("#tab tr").hide();    // 首先，设置这行为隐藏
    	$("#tab tr").each(function(i){    // 然后，通过条件判断决定本行是否恢复显示
        	if((i>=begin && i<=end) || i==0 )//显示begin<=x<=end的记录
            	$(this).show();
    	});
 	}
	
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


