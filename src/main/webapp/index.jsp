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
<link rel="shortcut icon" href="images/ico/favicon.png">

<!-- ===================================
	NORMALIZE CSS
==================================== -->
<link rel="stylesheet" href="css/normalize.css">

<!-- ===================================
	BOOTSTRAP 
==================================== -->
<link rel="stylesheet" href="css/bootstrap.min.css">

<!-- ===================================
	GOOGLE FONTS
==================================== -->
<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Raleway:600,700,400,300' rel='stylesheet' type='text/css'>

<!-- ===================================
	FONTS ICON
==================================== -->
<link rel="stylesheet" href="css/font-awesome/css/font-awesome.css">

<!-- ===================================
	PLUGIN
==================================== -->
<link rel="stylesheet" href="css/magnific-popup.css">
<link rel="stylesheet" href="css/slider-pro.css">
<link rel="stylesheet" href="css/owl.carousel.css">
<link rel="stylesheet" href="css/owl.theme.css">
<link rel="stylesheet" href="css/owl.transitions.css">
<link rel="stylesheet" href="css/animate.css">

<!-- ===================================
	MAIN STYLESHEET
==================================== -->
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/responsive.css" />
<link rel="stylesheet" href="css/color-green.css" id="colors" />



<!--[if lt IE 9]>
	<script src="js/html5shiv.min.js"></script>
	<script src="js/respond.min.js"></script>
	<script type="text/javascript" src="js/selectivizr-min.js"></script>
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
				<a class="navbar-brand" href="index.jsp"><img class="logo" id="logo" src="images/logo.PNG" alt="Page"></a>

			</div>
			<!-- Navbar Toggle End -->

			<!-- navbar-collapse start-->
			<div id="nav-menu" class="navbar-collapse collapse" role="navigation">
				<ul class="nav navbar-nav clean-menu-wrapper">
					<li class="active">
						<a href="#clean-slider">主页</a>
					</li>
					<li>
						<a href="#about">主要功能</a>
					</li>
					<li class="dropdown">
                		<a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    		<span>游客</span>
                    		<b class="caret"></b>
                		</a>

                		<ul class="dropdown-menu">
                    		<li class="divider"></li>
                    			<li><center><a href="login.jsp">登录</a></center></li>
                    		<li class="divider"></li>
                    			<li><center><a href="registration.jsp">注册</a></center></li>
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

			<img class="sp-image" src="images/slider/1.jpg" alt="Slider 1"/>

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
			<img class="sp-image" src="images/slider/2.jpg" alt="Slider 2"/>

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

			<img class="sp-image" src="images/slider/3.jpg" alt="Slider 3"/>

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
<section id="about" class="clean-section-wrapper background-one">
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

				<div class="col-md-3 col-sm-3 col-xs-12 clean-blurb-round-icon wow bounceInLeft" data-wow-delay=".5s">
					<div class="clean-icon">
						<a href="javascript:void(0)" onclick="jump()">
						<i class="fa fa-html5"></i>
						</a>
					</div>
					<h3>地图搜索</h3>
					<p>实时定位搜索附近停车场；输入目的地搜索停车场。</p>
				</div>

				<div class="col-md-3 col-sm-3 col-xs-12 clean-blurb-round-icon wow bounceInLeft" data-wow-delay=".5s">
					<div class="clean-icon">
						<a href="javascript:void(0)" onclick="jump()">
						<i class="fa fa-laptop"></i>
						</a>
					</div>
					<h3>停车记录</h3>
					<p>查看历史停车记录。</p>
				</div>

				<div class="col-md-3 col-sm-3 col-xs-12 clean-blurb-round-icon wow bounceInRight" data-wow-delay=".5s">
					<div class="clean-icon">
						<a href="javascript:void(0)" onclick="jump()">
						<i class="fa fa-support"></i>
						</a>
					</div>
					<h3>分析统计</h3>
					<p>综合各种数据，对停车场，车位利用率等信息进行统计分析。</p>
				</div>
				
				<div class="col-md-3 col-sm-3 col-xs-12 clean-blurb-round-icon wow bounceInRight" data-wow-delay=".5s">
					<div class="clean-icon">
						<a href="javascript:void(0)" onclick="jump()">
						<i class="fa fa-user"></i>
						</a>
					</div>
					<h3>个人信息</h3>
					<p>查看，修改个人信息。</p>
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
							<img src="images/user.jpg" alt="用户头像" height="120" width="120">
						</div>
						<p class="clean-client-info">游客</p><br>
						<p>您好，欢迎来到智能停车管理系统，</p>
						<p>城市停车场智能化管理，数据录入，分类整理，实时展示，统计分析。</p>	
						<a href="login.jsp"><h4>登录</h4></a>
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
					<a href="index.jsp">
						<img id="logo-footer" src="images/logo.PNG" alt="clean">
					</a>
				</div>

				<p class="clean-copyright-info">This is SMART PARKING SYSTEM.</p>
			</div>
		</div>
	</div>
</footer>

<!-- ===================================
	SCRIPTS
==================================== -->
<script src="js/modernizr.min.js"></script>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.easing.js"></script>
<script src="js/jquery.scrollUp.min.js"></script>
<script src="js/smooth-scroll.min.js"></script>
<script src="js/jquery.magnific-popup.min.js"></script>
<script src="js/jquery.sliderPro.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/jquery.easypiechart.js"></script>
<script src="js/jquery.countTo.js"></script>
<script src="js/isotope.pkgd.min.js"></script>
<script src="js/jquery.stellar.min.js"></script>
<script src="js/jquery.waypoints.min.js"></script>
<script src="js/wow.min.js"></script>
<script src="js/jquery.nav.js"></script>
<script src="js/custom.js"></script>
</body>

<script type="text/javascript">  
	function jump(){
		alert("请登录！");
		window.location.href="#info";
    }	
	
</script>
</html>