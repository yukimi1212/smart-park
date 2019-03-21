<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- PAGE TITLE -->
<title>Home</title>

<!-- ===================================
	FAVICON ICON
==================================== -->
<link rel="shortcut icon" href="../../images/ico/favicon.png">

<!-- ===================================
	NORMALIZE CSS
==================================== -->
<link rel="stylesheet" href="../../css/normalize.css">

<!-- ===================================
	BOOTSTRAP 
==================================== -->
<link rel="stylesheet" href="../../css/bootstrap.min.css">

<!-- ===================================
	GOOGLE FONTS
==================================== -->
<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Raleway:600,700,400,300' rel='stylesheet' type='text/css'>

<!-- ===================================
	FONTS ICON
==================================== -->
<link rel="stylesheet" href="../../css/font-awesome/css/font-awesome.css">

<!-- ===================================
	PLUGIN
==================================== -->
<link rel="stylesheet" href="../../css/magnific-popup.css">
<link rel="stylesheet" href="../../css/slider-pro.css">
<link rel="stylesheet" href="../../css/owl.carousel.css">
<link rel="stylesheet" href="../../css/owl.theme.css">
<link rel="stylesheet" href="../../css/owl.transitions.css">
<link rel="stylesheet" href="../../css/animate.css">

<!-- ===================================
	MAIN STYLESHEET
==================================== -->
<link rel="stylesheet" href="../../css/main.css">
<link rel="stylesheet" href="../../css/responsive.css" />
<link rel="stylesheet" href="../../css/color-green.css" id="colors" />



<!--[if lt IE 9]>
	<script src="../../js/html5shiv.min.js"></script>
	<script src="../../js/respond.min.js"></script>
	<script type="text/javascript" src="../../js/selectivizr-min.js"></script>
	<script src="http://s3.amazonaws.com/nwapi/nwmatcher/nwmatcher-1.2.5-min.js"></script>
	<script src="http://css3-mediaqueries-js.googlecode.com/files/css3-mediaqueries.js"></script>
	<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/IE9.js"></script>
<![endif]-->
</head>

<body>

<div class="preloader">
	<div class="status"></div>
</div>

<header>
	<!-- Navigation Menu start-->
	<nav class="navbar clean-main-menu" role="navigation">
		<div class="container">

			<!-- Navbar Toggle -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>

				<!-- Logo -->
				<a class="navbar-brand" href="index.jsp"><img class="logo" id="logo" src="../../images/logo.PNG" alt="Page"></a>

			</div>
			<!-- Navbar Toggle End -->

			<!-- navbar-collapse start-->
			<div id="nav-menu" class="navbar-collapse collapse" role="navigation">
				<ul class="nav navbar-nav clean-menu-wrapper">
					<li>
						<a href="#clean-slider">主页</a>
					</li>
					<li>
						<a href="#about">主要功能</a>
					</li>
					<li class="dropdown">
                		<a href="#" class="dropdown-toggle" data-toggle="dropdown">
<!--                     		<img src="../../images/user.PNG" alt="当前用户"  height="50" width="50"/> 	-->
                    		<span>${user_name }</span>
                    		<b class="caret"></b>
                		</a>

                		<ul class="dropdown-menu">
                    		<li class="divider"></li>
                    			<li><center><a href="#info">个人信息</a></center></li>
                    		<li class="divider"></li>
                    			<li><center><a href="../../index.jsp">注销</a></center></li>
                		</ul>
            		</li>
				</ul>
			</div>
			<!-- navbar-collapse end-->

		</div>
	</nav>
	<!-- Navigation Menu end-->
</header>


<!-- ===================================
	MAIN SLIDER
==================================== -->
<section class="slider-pro clean-slider" id="clean-slider">
	<div class="sp-slides">

		<!-- Slides -->
		<div class="sp-slide clean-main-slides">
			<div class="clean-img-overlay"></div>

			<img class="sp-image" src="../../images/slider/3.jpg" alt="Slider 1"/>

			<h1 class="sp-layer clean-slider-text-big"
			data-position="center" data-show-transition="right" data-hide-transition="right" data-show-delay="1500" data-hide-delay="200">
			<span class="clean-color-contras">SMART</span> - PARKING SYSTEM
			</h1>
			<p class="sp-layer"
			data-position="center" data-vertical="15%" data-show-delay="2000" data-hide-delay="200" data-show-transition="left" data-hide-transition="down">
			   智慧城市，智能停车.
			</p>

		</div>
		<!-- Slides End -->

		<!-- Slides -->
		<div class="sp-slide clean-main-slides">
		<div class="clean-img-overlay"></div>
			<img class="sp-image" src="../../images/slider/2.jpg" alt="Slider 2"/>

			<h1 class="sp-layer clean-slider-text-big"
			 data-position="center" data-show-transition="right" data-hide-transition="right" data-show-delay="1500" data-hide-delay="200">
				<span class="clean-color-contras">SMART</span> - PARKING SYSTEM
			</h1>

			<p class="sp-layer"
			 data-position="center" data-vertical="15%" data-show-delay="2000" data-hide-delay="200" data-show-transition="left" data-hide-transition="down">
				智慧城市，智能停车.
			</p>
		</div>
		<!-- Slides End -->

		<!-- Slides -->
		<div class="sp-slide clean-main-slides">
			<div class="clean-img-overlay"></div>

			<img class="sp-image" src="../../images/slider/1.jpg" alt="Slider 3"/>

			<h1 class="sp-layer clean-slider-text-big"
			data-position="center" data-show-transition="right" data-hide-transition="right" data-show-delay="1500" data-hide-delay="200">
			 <span class="clean-color-contras">SMART</span> - PARKING SYSTEM
			</h1>

			<p class="sp-layer"
			data-position="center" data-vertical="15%" data-show-delay="1000" data-hide-delay="200" data-show-transition="left" data-hide-transition="down">
				智慧城市，智能停车.
			</p>

		</div>
		<!-- Slides End -->

	</div>
</section>


<!-- ===================================
	ABOUT SECTION
==================================== -->
<section class="clean-section-wrapper background-one" id="about">
	<div class="container">
		<div class="row">

			<!-- Section Header -->
			<div class="col-md-12 col-sm-12 col-xs-12 clean-section-header wow fadeInDown">
				<h1><span class="clean-color-contras">主要功能</span></h1>
				<div class="clean-line"></div>
				<p class="col-md-8 col-sm-10 col-xs-12 col-md-offset-2 col-sm-offset-1">智慧停车系统提供以下功能与服务</p>
			</div>
			<!-- Section Header End -->

			<!-- What We Do -->
			<div class="clean-what-we-do">

				<div class="col-md-3 col-sm-3 col-xs-12 clean-blurb-round-icon wow bounceInLeft">
					<div class="clean-icon">
						<a href="javascript:void(0)" onclick="jumpToMap()">
						<i class="fa fa-html5"></i>
						</a>
					</div>
					<h3>地图搜索</h3>
					<p>实时定位搜索附近停车场；输入目的地搜索停车场。</p>
				</div>

				<div class="col-md-3 col-sm-3 col-xs-12 clean-blurb-round-icon wow bounceIn" data-wow-delay=".5s">
					<div class="clean-icon">
						<a href="javascript:void(0)" onclick="jumpToParking()">
						<i class="fa fa-edit"></i>
						</a>
					</div>
					<h3>停车场统计</h3>
					<p>统计了各个停车场的数据，可按地区按类型查询停车场的相关信息。</p>
				</div>

				<div class="col-md-3 col-sm-3 col-xs-12 clean-blurb-round-icon wow bounceIn" data-wow-delay=".5s">
					<div class="clean-icon">
						<i class="fa fa-laptop"></i>
					</div>
					<h3>历史记录</h3>
					<p>查看个人历史停车记录。</p>
				</div>

				<div class="col-md-3 col-sm-3 col-xs-12 clean-blurb-round-icon wow bounceInRight" data-wow-delay=".5s">
					<div class="clean-icon">
						<a href="javascript:void(0)" onclick="jumpToOpen()">
						<i class="fa fa-support"></i>
						</a>
					</div>
					<h3>分析统计</h3>
					<p>综合各种数据，对停车场，车位利用率等信息进行统计分析。</p>
				</div>
		 
			</div>
			<!-- What We Do End -->

		</div>
	</div>
</section>


<!-- ===================================
	个人信息 
==================================== -->
<section id="info"  class="clean-testimonial-section background-two">

	<div class="clean-parallax-overlay"></div>

	<div class="clean-testimonial-wrapper wow bounceIn">
		<div class="container">
			<div class="row">

				<i class="icon-bubbles comment-icon"></i>

				<!-- Testimonial Slider -->
				<div id="clean-testimonial" class="owl-carousel clean-testimonial">

					<!-- Slides -->

					<div class="clean-testimonial-slides col-md-8 col-sm-10 col-xs-12 col-md-offset-2 col-sm-offset-1"> 
						<div class="clean-member-img-wrapper">
							<img src="../../images/user.jpg" alt="用户头像" height="120" width="120">
						</div>
						<p class="clean-client-info" id="user_name">${user_name }</p><br>
						<p>您好，欢迎来到智能停车管理系统，</p>
						<p>城市停车场智能化管理，数据录入，分类整理，实时展示，统计分析。</p>						
						<a href="../../index.jsp"><span style="color:green; font-weight:bold;">登出</span></a>
					</div>
					<!-- Slides End -->
				</div>
				<!-- Testimonial Slider End -->

			</div>
		</div>
	</div>
</section>



<!-- ===================================
	FOOTER SECTION
==================================== -->
<footer class="background-two">
	<div class="container">
		<div class="row">
			<div class="clean-footer-content">

				<div class="clean-footer-logo wow bounceIn" data-wow-offset="0">
					<img id="logo-footer" src="../../images/logo.PNG" alt="clean">
				</div>
				
				<p class="clean-copyright-info">This is SMART PARKING SYSTEM.</p>
			</div>
		</div>
	</div>
</footer>

<!-- ===================================
	SCRIPTS
==================================== -->
<script src="../../js/modernizr.min.js"></script>
<script src="../../js/jquery.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<script src="../../js/jquery.easing.js"></script>
<script src="../../js/jquery.scrollUp.min.js"></script>
<script src="../../js/smooth-scroll.min.js"></script>
<script src="../../js/jquery.magnific-popup.min.js"></script>
<script src="../../js/jquery.sliderPro.min.js"></script>
<script src="../../js/owl.carousel.min.js"></script>
<script src="../../js/jquery.easypiechart.js"></script>
<script src="../../js/jquery.countTo.js"></script>
<script src="../../js/isotope.pkgd.min.js"></script>
<script src="../../js/jquery.stellar.min.js"></script>
<script src="../../js/jquery.waypoints.min.js"></script>
<script src="../../js/wow.min.js"></script>
<script src="../../js/jquery.nav.js"></script>
<script src="../../js/custom.js"></script>
</body>

<script type="text/javascript">  
	function jumpToMap(){
		var user_name = document.getElementById("user_name").innerHTML;
	    var param = encode64(user_name);
        var uurl = "http://192.168.60.16:8080/user/" + param + "/map"; 
        window.open(uurl); 
    
       /*  var uurl = "http://localhost:8080/user/";
        $.ajax({
            type:'GET',
            url:'http://localhost:8080/login/decode',
            async:true,
            data:{
            	'user_name':user_name
            },
            success:function(result){
                var jsonData = JSON.stringify(result);
                var n = jsonData.split("\"");
                window.open(uurl + n[1] + "/map");
            },
            error:function(error){
            	var jsonData = JSON.stringify(error);
                alert(jsonData);
            }
        }) */
    }	
	
	function jumpToOpen(){
		var user_name = document.getElementById("user_name").innerHTML;
	 	var param = encode64(user_name);
        var uurl = "http://192.168.60.16:8080/user/" + param + "/analysis";
        window.open(uurl);  
      
     	/* var uurl = "http://localhost:8080/user/";
     	$.ajax({
       		type:'GET',
         	url:'http://localhost:8080/login/decode',
         	async:true,
         	data:{
         		'user_name':user_name
         	},
         	success:function(result){
         	    var jsonData = JSON.stringify(result);
         	    alert(jsonData)
         	   	var n = jsonData.split("\"");
         	   	alert(n[1])
             	window.open(uurl + n[1] + "/analysis");
         	},
         	error:function(error){
         		var jsonData = JSON.stringify(error);
            	alert(jsonData);
         	}
     	}) */
    }	
	
	function jumpToParking() {
		var user_name = document.getElementById("user_name").innerHTML;
	 	var param = encode64(user_name);
        var url = "http://192.168.60.16:8080/user/" + param + "/parking";
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
