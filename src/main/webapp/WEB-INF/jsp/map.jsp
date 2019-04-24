<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<link rel="shortcut icon" href="../../images/ico/favicon.png">

<title>地图</title>
    
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
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=134db1b9cf1f1f2b4427210932b34dcb"></script>  

</head>
<body>


	<input type="text" id="areaName" value="西湖" />
	<input type="button" onclick="setCity()" value="查找" />
	<span id="user_id" style="display:none">${user_id }</span>
	
	<div id="container" style="width: 1700px; height: 700px;"></div>
</body>

<script type="text/javascript">	

	var x=121.48789949,y=31.24916171;	
	var map = new BMap.Map("container");  
    var point = new BMap.Point(x,y);  
    map.centerAndZoom(point,16);  
    
	window.onload = function() {  
		setMapEvent();
		if(navigator.geolocation) {  
			navigator.geolocation.getCurrentPosition(showPosition);         
            var geolocation = new BMap.Geolocation();  
            geolocation.getCurrentPosition(function(r){  
            	if(this.getStatus() == BMAP_STATUS_SUCCESS){  
            	  	var mk = new BMap.Marker(r.point);  
                	var user_id = $("#user_id").html();
            	    var param = encode64(user_id);
                	$.ajax({
    		   			type:'GET',
    		     		url:'http://localhost:8080/search/' + param + '/map',
    		     		async:true,
    		     		data:{
    		     			'lng':r.point.lng,
    		     			'lat':r.point.lat
    		     		},
    		     		success:function(result){
    		     			getMap(result,r.point);
    		     		},
    		     		error:function(error){
    		     			var jsonData = JSON.stringify(error);
    		     	    	alert(jsonData)
    		     		}
    		 		})   
    		 	 
            		map.addOverlay(mk);  
                	mk.setAnimation(BMAP_ANIMATION_BOUNCE);
                    map.panTo(r.point);  
                }  
                else {  
                	alert('failed'+this.getStatus());  
                }          
        	},{enableHighAccuracy: true})  
            
			return;
    	}  
		alert("你的浏览器不支持获取地理位置！");
	}

	function showPosition(position){
  		x=position.coords.latitude; 
  		y=position.coords.longitude;
	}	
	
	//地图事件设置函数：
    function setMapEvent(){
        map.enableDragging();
        map.enableScrollWheelZoom();
        map.enableDoubleClickZoom();
        map.enableKeyboard();
        map.enableContinuousZoom();    

		
		map.addControl(new BMap.NavigationControl()); 
		map.addControl(new BMap.MapTypeControl());
		map.addControl(new BMap.ScaleControl()); 
		map.addControl(new BMap.OverviewMapControl());     
    }
    
	function getMap(list,point){		
		
		map.centerAndZoom(point, 16);      
		
        var i = 0;
        for (;i<list.length;i++) {
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
		
        function markerFun (points,label,infoWindows) {
            var markers = new BMap.Marker(points);
            map.addOverlay(markers);
            markers.addEventListener("click",function (event) {
                map.openInfoWindow(infoWindows,points);
            });
        }
	}		
	
	
	
	function setCity() {
		var user_id = $("#user_id").html();
	    var param = encode64(user_id);
		var areaname = document.getElementById("areaName").value;
		// 创建地址解析器实例     
		var myGeo = new BMap.Geocoder();      
		// 将地址解析结果显示在地图上
		myGeo.getPoint(areaname, function(point){      
		    if (point) {
		    	$.ajax({
		   			type:'GET',
		     		url:'http://localhost:8080/search/' + param + '/map',
		     		async:true,
		     		data:{
		     			'lng':point.lng,
		     			'lat':point.lat
		     		},
		     		success:function(result){
		     			var mk = new BMap.Marker(point);  
	            		map.addOverlay(mk);  
	                	mk.setAnimation(BMAP_ANIMATION_BOUNCE);
		     			getMap(result,point);
		     		},
		     		error:function(error){
		     			var jsonData = JSON.stringify(error);
		     	    	alert(jsonData)
		     		}
		 		})    
		    }      
		 }, 
		"杭州市");
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