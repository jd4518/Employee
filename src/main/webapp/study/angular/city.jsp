<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html lang="ko" data-ng-app="employeeApp">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<%@include file="/WEB-INF/view/common.jspf" %>
<title>city.jsp</title>

<c:url var="url_all" value="/city"/>
<c:url var="url_page" value="/city/page/"/>
<script type="text/javascript">
	var app = angular.module('employeeApp',[]);
	
	app.controller('listController',function($scope, $http){
		var url_all = "${url_all}";
		var url_page = "${url_page}";
		
		$scope.pageNo = 1;
		$scope.citys = [];
		$scope.paging = {};
		$scope.pagePerCount = {};
		
		$scope.selectPage = function(){
			$http.get(url_page+$scope.pageNo).success(function(data, status, headers, config){
				console.dir(data);
				$scope.citys = data.citys;
				$scope.paging = data.paging;
				$scope.pagePerCount = data.paging.PagePerCount;
//	 			alert("success...");
			});	
		};
		
		$scope.selectPage();
		
		$scope.prevClick = function(pageNo) {
// 			alert(pageNo);
			$scope.pageNo = pageNo;
			$scope.selectPage();
		};
		
		$scope.pageClick = function(pageNo) {
// 			alert(pageNo);
			$scope.pageNo = pageNo;
			$scope.selectPage();
		};
		
		$scope.nextClick = function(pageNo) {
// 			alert(pageNo);
			$scope.pageNo = pageNo;
			$scope.selectPage();
		};
		
	});
</script>
</head>
<body data-ng-controller="listController" class="container">
<h1>City List</h1>
<div class="row">
	<div class="col-sm-2"></div>
	<div class="col-sm-8">
	<div class="table-responsive">
		<ul class="pagination">
			<li><a href="#" data-ng-click="prevClick(paging.firstPage - 1)">Prev</a></li>
			<li data-ng-repeat="city in citys">
				<a href="#" data-ng-click="pageClick(paging.firstPage + $index)">{{paging.firstPage + $index}}</a>
			</li>
			<li><a href="#" data-ng-click="nextClick(paging.lastPage + 1)">Next</a></li>
		</ul>
	
		<table class="table table-striped table-hover">
			<thead>
				<th>No</th><th>ID</th><th>Name</th><th>CountryCode</th><th>District</th><th>Population</th>
			</thead>
			<tbody>
				<tr data-ng-repeat="city in citys">
					<td>{{$index+1}}</td>
					<td>{{city.id}}</td>
					<td>{{city.name}}</td>
					<td>{{city.countryCode}}</td>
					<td>{{city.district}}</td>
					<td>{{city.population}}</td>
				</tr>
			</tbody>
		</table>
	</div>
	</div>
	<div class="col-sm-2"></div>
</div>
<div class="row">
	<div class="col-sm-12">
		<div class="form-group">
		<textarea rows="20" class="form-control">{{citys}}{{paging}}</textarea>
		</div>
	</div>
</div>
</body>
</html>