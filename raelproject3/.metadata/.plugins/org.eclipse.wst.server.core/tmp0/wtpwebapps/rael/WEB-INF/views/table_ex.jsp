<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body id="page-top">

	<div class="container-fluid">
		<!-- Page Heading -->
		<h1 class="h3 mb-2 text-gray-800">테이블 헤드</h1>
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">테이블 소 제목</h6>
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
						<div class="row">
							<form>
								<div class="dataTable_filter" id="dataTable_filter">
									<select name="categoryBox" id="categoryBox">
										<option value="defaultValue" selected></option>
										<c:forEach var="list" items="${categorynums}">
											<option value="${list}">${list}</option>
										</c:forEach>
									</select> <input type="submit" value="카테고리 명으로 검색">
								</div>
							</form>
						</div>
						<div class="row">
							<div class="col-sm-12">
								<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
									<thead>
										<tr>
										</tr>
									</thead>
									<tfoot>
										<tr>
										</tr>
									</tfoot>
									<tbody>
										<tr>
										<tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12 col-md-5">
								<div class="dataTables_info" id="dataTable_info" role="status" aria-live="polite">
									<c:if test="${shownumber >= allcount}">
										Showing ${datas.pagination.limitStart + 1} to ${allcount} of ${allcount}
									</c:if>
									<c:if test="${shownumber < allcount}">
										Showing ${datas.pagination.limitStart + 1} to ${datas.pagination.limitStart + 10} of ${allcount}
									</c:if>
								</div>
							</div>
							<div class="col-sm-12 col-md-7">
								<div class="dataTables_paginate paging_simple_numbers" id="dataTable_paginate">
									<ul class="pagination">
										<c:if test="${datas.pagination.totalPageCount < 1}">
											<li>0</li>
										</c:if>
										<c:if test="${datas.pagination.existPrevPage eq true}">
											<li class="paginate_button page-item previous"><a aria-controls="dataTable" data-dt-idx="${num}" class="page-link" href='<c:url value="/product/all_select?page=${datas.pagination.startPage-1}&recordSize=10&pageSize=10&categoryBox=${categoryBox}&keyword=${param.keyword}&searchType=${param.searchType}"/>'>PREVIOUS</a></li>
										</c:if>
										<c:if test="${datas.pagination.totalPageCount > 0}">
											<c:forEach begin="${datas.pagination.startPage}" end="${datas.pagination.endPage}" var="num">
												<li class="paignate_button page-item"><a aria-controls="dataTable" data-dt-idx="${num}" class="page-link" href='<c:url value="/product/all_select?page=${num}&recordSize=10&pageSize=10&categoryBox=${categoryBox}&keyword=${param.keyword}&searchType=${param.searchType}"/>'>${num}</a></li>
											</c:forEach>
										</c:if>
										<c:if test="${datas.pagination.existNextPage eq true}">
											<li class="paginate_button page-item next" id="dataTable_next"><a aria-controls="dataTable" data-dt-idx="${num}" class="page-link" href='<c:url value="/product/all_select?page=${datas.pagination.endPage+1}&recordSize=10&pageSize=10&categoryBox=${categoryBox}&keyword=${param.keyword}&searchType=${param.searchType}"/>'>NEXT</a></li>
										</c:if>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>