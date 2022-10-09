<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="/css/style.css">
		<meta charset="UTF-8">
		<title>입고</title>
	</head>
	<body>
		<h1>입고 창 입니다.</h1>
		<form action='/stock/stock_in/INSERT' method="post">
			<input type='hidden' name='stock state' value='입' readonly>
			<div>
				<ul>
					<li>
						<label for='stock num'> 재고 번호 </label>
						<input type='text' name='stock num' value="${stocknum}" readonly>	
					</li>
					<li>
						<label for='stock name'> 재고 명 </label>
						<input type='text' name='stock name' value="${stockname}" readonly>
					</li>
					<li>
						<label for='stock quantity'> 입고 수량 </label>
						<input type='number' name='stock quantity' placeholder="입고 수량을 입력해주세요.">
					</li>
					<li>
						<label for='stock price'> 입고 상품 가격(수정가능) </label>
						<input type='number' name='stock price' value=${stockprice}>
					</li>
						
					
				</ul>		
			</div>
			<input type='submit' value="등록">
		</form>
	</body>
</html>