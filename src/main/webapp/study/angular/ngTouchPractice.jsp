<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html lang="ko" data-ng-app="employeeApp">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<%@ include file="/WEB-INF/view/common.jspf" %>
<title>ngTouch.jsp</title>
<style type="text/css">
	.swipe-box{
		height: 200px;
		background-color: red;
		border: 1px solid black;
	}
	
</style>
<script type="text/javascript">
	var deps = ['ngRoute',
	            'ngAnimate',
	            'ngTouch',
	            'angular-loading-bar'
	            ];

	var app = angular.module("employeeApp",deps);
	
	var count = 0;
	var color=['ff0000','ff5e00','ffe400','1ddb16','0054ff','0100ff','5f00ff'];
	
	
	app.controller("mainController", function($scope, $http) {
		console.log("mainController...");
	
		
	$scope.swipeLeft = function(e){
		console.log("swipeLeft()...");
		console.dir(e);
		
		$(e.target).css('border-radius','0px');
		$scope.msg = "ng-swipe-left fired...";
		$scope.imgURL = "http://www.placehold.it/400x400/ff0000/0000ff?text=SwipeLeft";
		if(count > 0){
			count--;
		}else{
			count = 6;
		}
		$scope.imgURL2 = "http://www.placehold.it/400x400/"+color[count]+"/000000?text="+count;
	};
	
	$scope.swipeRight = function(e){
		console.log("swipeRight()...");
		console.dir(e);
		
		$(e.target).css('border-radius','50px');
		$scope.msg = "ng-swipe-right fired...";
		$scope.imgURL = "http://www.placehold.it/400x400/0000ff/ff0000?text=SwipeRight";
		if(count <6){
			count++;
				
			}else{
			count = 0;
			}
		$scope.imgURL2 = "http://www.placehold.it/400x400/"+color[count]+"/000000?text=SwipeRight";
	};
	
	$scope.imgswipeLeft = function(e){
		console.log("imgswipeLeft()...");
		console.dir(e);
		
		$scope.imgmsg = "ng-swipe-Left fired...";
		
	};	
	
	$scope.imgswipeRight = function(e){
		console.log("imgswipeRight()...");
		console.dir(e);
		
		$scope.imgmsg = "ng-swipe-right fired...";
		
	};
	
	
	
	});
</script>

</head>
<body data-ng-controller="mainController">
	<div data-ng-swipe-left="swipeLeft($event)"
		 data-ng-swipe-right="swipeRight($event)"
	 class="swipe-box" >
	 </div>
	<hr>
	<p>{{msg}}</p>
	<hr>
<!-- 	<img data-ng-swipe-left="imgswipeLeft($event)" -->
<!-- 		 data-ng-swipe-right="imgswipeRight($event)" -->
<!-- 	 draggable="false" class="img-responsive" alt="{{imgURL}}" src="{{imgURL}}"> -->
<!-- 	<hr> -->
<!-- 	<p>{{imgmsg}}</p> -->
<!-- 	<hr> -->
	<img 
	 draggable="false" class="img-responsive" alt="{{imgURL2}}" data-ng-src="{{imgURL2}}">
	<hr>
</body>
</html>