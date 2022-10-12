<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <meta name="description" content="">
	    <meta name="author" content="">
	    <meta charset="UTF-8">
			<title></title>
	
		<link href="/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
		<link href="/css/modal.css" rel="stylesheet" type="text/css">
	    <link
	        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	        rel="stylesheet">
	
	    <!-- Custom styles for this template -->
	    <link href="/css/sb-admin-2.min.css" rel="stylesheet">
	    <!-- Custom styles for this page -->
	    <link href="/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
	    
	    <script src="/vendor/jquery/jquery.min.js"></script>
	    <script src="/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	
	    <!-- Core plugin JavaScript-->
	    <script src="/vendor/jquery-easing/jquery.easing.min.js"></script>
	
	    <!-- Custom scripts for all pages-->
	    <script src="/js/sb-admin-2.min.js"></script>
	
	    <!-- Page level plugins -->
	    <script src="/vendor/datatables/jquery.dataTables.min.js"></script>
	    <script src="/vendor/datatables/dataTables.bootstrap4.min.js"></script>
	
	    <!-- Page level custom scripts -->
	    <script src="/js/demo/datatables-demo.js"></script>
	
	    
	</head>
	
	
	<body id="page-top">
		<div id="wrapper">
			<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
            	<!-- Sidebar - Brand -->
	            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/">
	                <div class="sidebar-brand-icon rotate-n-15">
	                    <i class="fas fa-laugh-wink"></i>
	                </div>
	                
	                <div class="sidebar-brand-text mx-3"> RAEL </div>
	            </a>
	
	            <!-- Divider -->
	            <hr class="sidebar-divider my-0">
	
	            <!-- Nav Item - Dashboard -->
	            <li class="nav-item">
	                <a class="nav-link" href="/">
	                    <i class="fas fa-fw fa-tachometer-alt"></i>
	                    <span>처음으로</span></a>
	            </li>
	
	            <!-- Divider -->
	            <hr class="sidebar-divider">
	
	            <!-- Heading -->
	            <div class="sidebar-heading">
	                상품
	            </div>
	
	            <!-- Nav Item - Pages Collapse Menu -->
	            <li class="nav-item">
	                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
	                    aria-expanded="true" aria-controls="collapseTwo">
	                    <i class="fas fa-fw fa-folder"></i>
	                    <span>상품 분류</span>
	                </a>
	                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
	                    <div class="bg-white py-2 collapse-inner rounded">
	                        <h6 class="collapse-header">상풍 분류 탭</h6>
	                        <a class="collapse-item" href="/product/category_select?page=1&recordSize=10&pageSize=10">상품 분류 조회</a>
	                        <a class="collapse-item" href="/product/category_insert?insertresult=0">상품 분류 등록</a>
	                        <a class="collapse-item" href="/product/category_update">상품 분류 수정</a>
	                    </div>
	                </div>
	            </li>
	
	            <!-- Nav Item - Utilities Collapse Menu -->
	            <li class="nav-item">
	                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
	                    aria-expanded="true" aria-controls="collapseUtilities">
	                    <i class="fas fa-fw fa-folder"></i>
	                    <span>상품</span>
	                </a>
	                <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
	                    data-parent="#accordionSidebar">
	                    <div class="bg-white py-2 collapse-inner rounded">
	                        <h6 class="collapse-header">상품 탭</h6>
	                        <a class="collapse-item" href="/product/all_select?page=1&recordSize=10&pageSize=10">상품 조회</a>
	                        <a class="collapse-item" href="/product/product_insert">상품 등록</a>
	                        <a class="collapse-item" href="/product/product_insert_detail">상품 추가 등록</a>
	                        <a class="collapse-item" href="/product/product_update">상품명/상세정보 수정</a>
	                    </div>
	                </div>
	            </li>
	
	            <!-- Divider -->
	            <hr class="sidebar-divider">
	
	            <!-- Heading -->
	            <div class="sidebar-heading">
	                재고
	            </div>
	
	            <!-- Nav Item - Pages Collapse Menu -->
	            <li class="nav-item">
	                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages"
	                    aria-expanded="true" aria-controls="collapsePages">
	                    <i class="fas fa-fw fa-folder"></i>
	                    <span>재고</span>
	                </a>
	                <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
	                    <div class="bg-white py-2 collapse-inner rounded">
	                        <h6 class="collapse-header">재고</h6>
	                        <a class="collapse-item" href="/stock/stock_select?page=1&recordSize=10&pageSize=10">재고 조회 및 입/출고</a>
	                        <div class="collapse-divider"></div>
	                        <h6 class="collapse-header">재고 입/출고</h6>
	                        <a class="collapse-item" href="/stock/stock_history?page=1&recordSize=10&pageSize=10">내역</a>
	                        <a class="collapse-item" href="/stock/stock_history_cancel?page=1&recordSize=10&pageSize=10">취소</a>
	                    </div>
	                </div>
	            </li>
	
	            <!-- Divider -->
	            <hr class="sidebar-divider d-none d-md-block">
	
	            <!-- Sidebar Toggler (Sidebar) -->
	            <div class="text-center d-none d-md-inline">
	                <button class="rounded-circle border-0" id="sidebarToggle"></button>
	            </div>

        	</ul>
        
       		<!-- End of Sidebar -->

	        <!-- Content Wrapper -->
	        <div id="content-wrapper" class="d-flex flex-column">
	
	            <!-- Main Content -->
	            <div id="content">
	
	                <!-- Topbar -->
	                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
	
	                    <!-- Sidebar Toggle (Topbar) -->
	                    <form class="form-inline">
	                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
	                            <i class="fa fa-bars"></i>
	                        </button>
	                    </form>
	
	                    <!-- Topbar Search -->
	                    <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search" 
	                     id="searchForm" autocomplete="off" action="/product/all_select?page=1&recordSize=10&pageSize=10">
							
							<div class="input-group">
								<select id="searchType" name="searchType" class="form-control">
						           <option value="" selected>전체</option>
						           <option value="product_name">제품 이름</option>
						           <option value="product_company">회사명</option>
								</select>
								<input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
                                aria-label="Search" aria-describedby="basic-addon2" id="keyword" name="keyword">
                                <div class="input-group-append">
	                                <button class="btn btn-primary" type="submit">
	                                    <i class="fas fa-search fa-sm"></i>
	                                </button>
                            	</div>
					    	</div>
						</form>
					        
								
	
	                    <!-- Topbar Navbar -->
	                    <ul class="navbar-nav ml-auto">
	
	                        <!-- Nav Item - Search Dropdown (Visible Only XS) -->
	                        <li class="nav-item dropdown no-arrow d-sm-none">
	                            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
	                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	                                <i class="fas fa-search fa-fw"></i>
	                            </a>
	                            <!-- Dropdown - Messages -->
	                            <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
	                                aria-labelledby="searchDropdown">
	                                <form class="form-inline mr-auto w-100 navbar-search">
	                                    <div class="input-group">
	                                        <input type="text" class="form-control bg-light border-0 small"
	                                            placeholder="Search for..." aria-label="Search"
	                                            aria-describedby="basic-addon2">
	                                        <div class="input-group-append">
	                                            <button class="btn btn-primary" type="button">
	                                                <i class="fas fa-search fa-sm"></i>
	                                            </button>
	                                        </div>
	                                    </div>
	                                </form>
	                            </div>
	                        </li>
	                        
	                        <div class="topbar-divider d-none d-sm-block"></div>
	
	                        <!-- Nav Item - User Information -->
	                        <li class="nav-item dropdown no-arrow">
	                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
	                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">라엘이</span>
	                                <img class="img-profile rounded-circle"
	                                    src="/img/undraw_rocket.svg">
	                            </a>
	                            <!-- Dropdown - User Information -->
	                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
	                                aria-labelledby="userDropdown">
	                                <div class="dropdown-divider"></div>
	                                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
	                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
	                                    Logout
	                                </a>
	                            </div>
	                        </li>	
						</ul>	
					</nav>
				</div>          
	    	<!-- End of Topbar -->
	    	</div>
	    </div>
</body>
</html>