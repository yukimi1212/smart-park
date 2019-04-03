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
    <link rel="stylesheet" type="text/css" href="../../css/jquery.autocomplete.css">
	<link rel="stylesheet" href="../../css/jquery-ui.min.css">
    
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
					
					<li class="nav-item">
                        <a href="javascript:void(0)" onclick="getRecord()" class="nav-link">
                            <i class="icon icon-graph"></i> 停车记录
                        </a>
                    </li>
					
                    <li class="nav-item nav-dropdown ">
                        <a href="#" class="nav-link nav-dropdown-toggle">
                            <i class="icon icon-target"></i> 停车场统计 <i class="fa fa-caret-left"></i>
                        </a>

                        <ul class="nav-dropdown-items">
                        	<li class="nav-item">
                                <a href="javascript:void(0)" onclick="returnForm()" class="nav-link">
                                    <i class="icon icon-target"></i> 所有统计
                                </a>
                            </li>
                        
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
                    
                    <li class="nav-item nav-dropdown">
                        <a href="#" class="nav-link nav-dropdown-toggle active">
                            <i class="icon icon-clock"></i> 停车记录统计 <i class="fa fa-caret-left"></i>
                        </a>

                        <ul class="nav-dropdown-items">
                            <li class="nav-item">
                                <a href="javascript:void(0)" onclick="getChartArea()" class="nav-link">
                                    <i class="icon icon-clock"></i> 区域类型
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="javascript:void(0)" onclick="getChartTime()" class="nav-link active">
                                    <i class="icon icon-clock"></i> 不同时段
                                </a>
                            </li>
                        </ul>
                    </li>  
                   
                  	<li class="nav-item">
                        <a href="javascript:void(0)" onclick="getUser()" class="nav-link">
                            <i class="icon icon-puzzle"></i> <sapn id="user">个人信息</sapn>
                        </a>
                    </li>
                    
                </ul>
            </nav>
        </div>
		
        <div class="content">   
        	<div id="search">
    			<input type="text" id="searchWord" value="" placeholder="指定停车场/街道/区域/停车场类型"  size="18px">
    			<button class="button" type="submit" onclick="checkSearchWord()">搜索</button>
  			</div><br>
             <div class="row mt-4">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header bg-light">
                            	分时段（8：00 - 18：00）<sapn id="sum"></sapn>
                        </div>						
                	    <div class="card-body" id="card-body">
                            <canvas id="chartTime" width="100%" height="30"></canvas>
                        </div>		 
                    </div>
                </div>
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
<script type="text/javascript" src="../../js/jquery.autocomplete.min.js"></script>
<script src="../../js/jquery-ui.min.js"></script>

</body>

<script type="text/javascript">  

/* 	function checkSearchWord() {
		var sWord = $("#searchWord").val();
		if(sWord == "")
			getChartTime();
		else{
			var user_id = $("#user_id").html();
			var param = encode64(user_id);
			var url = "http://localhost:8080/user/" + param + "/" + sWord + "&time";
       		window.location.href=url;
		}		
	}
 */   
 
 function checkSearchWord() {
		var sWord = $("#searchWord").val();
		if(sWord == "")
			getChartTime();
		else{
			var user_id = $("#user_id").html();
			var param = encode64(user_id);
			$.ajax({
	   			type:'GET',
	     		url:'http://localhost:8080/search/' + sWord + '/check',
	     		async:true,
	     		data:{
	     		},
	     		success:function(result){
	     			if(result != "null")
	     				doSearch(sWord,result);
	     		},
	     		error:function(error){
	     			var jsonData = JSON.stringify(error);
	     	    	alert(jsonData)
	     		}
	 		})
		}		
	}

	function doSearch(sWord,source){
		$.ajax({
				type:'GET',
	 		url:'http://localhost:8080/search/' + sWord + '/time',
	 		async:true,
	 		data:{
	 			'source':source
	 		},
	 		success:function(result){
	 			getTimeChart(result);
	 		},
	 		error:function(error){
	 			var jsonData = JSON.stringify(error);
	 	    	alert(jsonData)
	 		}
		})
	}
	
	window.onload = function(){	
		auto();
		var sWord = $("#searchWord").val();
		if(sWord == "") {
			var user_id = $("#user_id").html();
			if(user_id == "admin"){
				$("user").empty();
				document.getElementById("user").innerText = "用户管理";
			}
			var param = encode64(user_id);
				$.ajax({
					type:'GET',
	 				url:'http://localhost:8080/record/' + param + '/time',
	 				async:true,
	 				data:{
	 				},
	 				success:function(result){
	 					getTimeChart(result);
	 				},
	 				error:function(error){
	 					var jsonData = JSON.stringify(error);
	 	    			alert(jsonData)
	 				}
				})	
		}
		else{
			checkSearchWord();
		}
		
	}

function auto() {
	var user_id = $("#user_id").html();
	var param = encode64(user_id);
    var availableTags = [];
    $.ajax({
			type:'GET',
 		url:'http://localhost:8080/search/' + param + '/tags',
 		async:true,
 		data:{
 		},
 		success:function(list){
 			for (var i = 0; i < list.length; i++) {
 				availableTags.push(list[i].value);
 		    }
 		},
 		error:function(error){
 			var jsonData = JSON.stringify(error);
 	    	alert(jsonData)
 		}
		})
    
    $( "#searchWord" ).autocomplete({
      source: availableTags
    });

  }

function getTimeChart(list) {
	$("sum").empty();
	document.getElementById("sum").innerHTML = "&nbsp&nbsp总记录数：" + list[0].amount;
	$('#chartTime').remove();
	$('#card-body').append('<canvas id="chartTime" width="100%" height="30"></canvas>');
	
	var ctx = document.getElementById("chartTime").getContext('2d');
	var labels = [];
	var data = [];
	var backgroundColor = [];
	var borderColor = [];
	var backColor = ['rgba(244, 88, 70, 0.5)','rgba(33, 150, 243, 0.5)','rgba(0, 188, 212, 0.5)','rgba(42, 185, 127, 0.5)','rgba(156, 39, 176, 0.5)','rgba(253, 178, 68, 0.5)'];
	var bordColor = ['#F45846','#2196F3','#00BCD4','#2ab97f','#9C27B0','#fdb244'];
	
	for (var i = 1; i < list.length; i++) {
        labels.push(list[i].time);
        data.push(list[i].amount);
        backgroundColor.push(backColor[i%6]);
        borderColor.push(bordColor[i%6]);
    }
	
	var myLineChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: labels,
            datasets: [{
                label: '记录数',
                data: data,
                backgroundColor: backgroundColor,
                borderColor: borderColor,
                borderWidth: 1
            }]
        },
        options: {
            legend: {
                display: false
            },
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            }
        }
    });
}

function returnForm() {
	var user_id = $("#user_id").html();
    var param = encode64(user_id);
    var url = "http://localhost:8080/user/" + param + "/form";
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


