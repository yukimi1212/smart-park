<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<link rel="shortcut icon" href="../../images/ico/favicon.png">

<title>百度地图</title>
<style type="text/css">
html {
	height: 100%
}

body {
	height: 100%;
	margin: 0px;
	padding: 0px
}

#container {
	height: 100%
}
</style>
<script src="http://api.map.baidu.com/api?v=1.4" type="text/javascript"></script>
<script src="../../vendor/jquery/jquery.min.js"></script>

</head>
<body>


	<input type="text" id="cityName" value="天行国际" />
	<input type="button" onclick="setCity()" value="查找" />
	<span id="user_id" style="display:none">${user_id }</span>
	
	<div id="container" style="width: 1700px; height: 700px;"></div>
</body>

<script type="text/javascript">	
	window.onload = function(){	
//		buildMap();
		var user_id = $("#user_id").html();
	    var param = encode64(user_id);

		$.ajax({
   			type:'GET',
     		url:'http://localhost:8080/park/' + param + '/map',
     		async:true,
     		data:{
     		},
     		success:function(list){
//     			getMyPoints(list);
     			getMap(list);
     		},
     		error:function(error){
     			var jsonData = JSON.stringify(error);
     	    	alert(jsonData)
     		}
 		})
	}
	
	function getMyPoints(list) {
		for (var i = 0; i < 5; i++) {
			var str =  "{x:" + list[i].lat + ",y:" + list[i].lng + ",title:\"" + list[i].title + "\",con:\"" + list[i].con + "\",branch:\"" + list[i].branch + "\"}";
			myPoints.push(str);
		}		
	}
	
	function getMap(list){		
		var map = new BMap.Map("container"); //在container容器中创建一个地图,参数container为div的id属性;

		var point = new BMap.Point(120.2, 30.25); //创建点坐标
		map.centerAndZoom(point, 18); //初始化地图，设置中心点坐标和地图级别
		var opts = {anchor:BMAP_ANCHOR_BOTTOM_RIGHT};//设置定位按钮位置
		map.addControl(new BMap.GeolocationControl(opts));//将定位控件添加到地图上
		
		map.enableScrollWheelZoom(); //激活滚轮调整大小功能
	    map.enableContinuousZoom();    //启用地图惯性拖拽，默认禁用
		map.addControl(new BMap.NavigationControl()); //添加控件：缩放地图的控件，默认在左上角；
		map.addControl(new BMap.MapTypeControl()); //添加控件：地图类型控件，默认在右上方；
		map.addControl(new BMap.ScaleControl()); //添加控件：地图显示比例的控件，默认在左下方；
		map.addControl(new BMap.OverviewMapControl()); //添加控件：地图的缩略图的控件，默认在右下方； TrafficControl    

		
		//设置缩放按钮位置及类型
//		var ove={anchor:BMAP_ANCHOR_TOP_RIGHT,type:BMAP_NAVIGATION_CONTROL_ZOOM}
		
		//添加缩放按钮
//		map.addControl(new BMap.NavigationControl(ove));
		
		var marker = new BMap.Marker(point);
		
        var i = 0;
        map.addOverlay(marker);
        map.enableScrollWheelZoom(true);
        
        for (;i<825;i++) {
//        	alert(list[i].lng + "," + list[i].lat);
            var points = new BMap.Point(list[i].lng,list[i].lat);//创建坐标点
            var opts = {
                width:250,
                height: 100,
                title:list[i].title
            };
            var label = new BMap.Label(list[i].branch,{
                offset:new BMap.Size(25,5)
            });
            var infoWindows = new BMap.InfoWindow(list[i].con,opts);
            markerFun(points,label,infoWindows);
        }
		
    	// 函数 创建多个标注
        function markerFun (points,label,infoWindows) {
            var markers = new BMap.Marker(points);
            map.addOverlay(markers);
//            markers.setLabel(label);
            markers.addEventListener("click",function (event) {
                map.openInfoWindow(infoWindows,points);//参数：窗口、点  根据点击的点出现对应的窗口
            });
        }
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