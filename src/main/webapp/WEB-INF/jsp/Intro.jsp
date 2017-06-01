<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>UIT | Dashboard</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet" href="/eds/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="/eds/dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="/eds/dist/css/skins/_all-skins.min.css">
<!-- iCheck -->
<link rel="stylesheet" href="/eds/plugins/iCheck/flat/blue.css">
<!-- Morris chart -->
<link rel="stylesheet" href="/eds/plugins/morris/morris.css">
<!-- jvectormap -->
<link rel="stylesheet"
	href="/eds/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
<!-- Date Picker -->
<link rel="stylesheet" href="/eds/plugins/datepicker/datepicker3.css">

<link rel="stylesheet" href="/eds/css/style.css">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>

<body class="hold-transition sidebar-mini">
	<div class="wrapper">
		<jsp:include page="../../layout/Header.jsp" flush="true"></jsp:include>
		<!-- Left side column. contains the logo and sidebar -->
		<jsp:include page="../../layout/LeftSideBar.jsp" flush="true"></jsp:include>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1 class="text-center">Giới thiệu</h1>
				<hr />
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-sm-12">
					Đồ án môn học J2EE
					</div>
				</div>

			
					
				<!-- result list -->
				<ul class="search-result">
<!-- 					<li> -->
<!-- 						style="background: #a8afac;" -->
<!-- 						<p> -->
<!-- 							<a href="#"><b>Quan 1 ra quan lay lai via he cho nguoi di -->
<!-- 									bo</b></a> -->
<!-- 						</p> -->
<!-- 						<p>Nguồn: Twitter, Thể loại: General, Thời gian: 27/2/2017, Độ -->
<!-- 							hot: 0.9</p> -->
<!-- 						<p>Keywords: quận 1, vỉa hè</p> -->
<!-- 						<hr class="hr-black"> -->
<!-- 					</li> -->

<!-- 					<li> -->
<!-- 						<p> -->
<!-- 							<a href="#"><b>Quan 1 ra quan lay lai via he cho nguoi di -->
<!-- 									bo</b></a> -->
<!-- 						</p> -->
<!-- 						<p>Nguồn: Twitter, Thể loại: General, Thời gian: 27/2/2017, Độ -->
<!-- 							hot: 0.9</p> -->
<!-- 						<p>Keywords: quận 1, vỉa hè</p> -->
<!-- 						<hr class="hr-black"> -->
<!-- 					</li> -->

				</ul>
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<jsp:include page="../../layout/Footer.jsp" flush="true"></jsp:include>


	</div>
	<!-- ./wrapper -->

	<!-- jQuery 2.2.3 -->
	<script src="/eds/plugins/jQuery/jquery-2.2.3.min.js"></script>
	<!-- jQuery UI 1.11.4 -->
	<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
	<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
	<script>
		$.widget.bridge('uibutton', $.ui.button);
	</script>
	<!-- Bootstrap 3.3.6 -->
	<script src="/eds/bootstrap/js/bootstrap.min.js"></script>
	<!-- Morris.js charts -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
	<script src="/eds/plugins/morris/morris.min.js"></script>
	<!-- Sparkline -->
	<script src="/eds/plugins/sparkline/jquery.sparkline.min.js"></script>
	<!-- jvectormap -->
	<script src="/eds/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
	<script
		src="/eds/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
	<!-- jQuery Knob Chart -->
	<script src="/eds/plugins/knob/jquery.knob.js"></script>
	<!-- daterangepicker -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
	<!-- datepicker -->
	<script src="/eds/plugins/datepicker/bootstrap-datepicker.js"></script>
	<!-- Slimscroll -->
	<script src="/eds/plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<!-- FastClick -->
	<script src="/eds/plugins/fastclick/fastclick.js"></script>
	<!-- AdminLTE App -->
	<script src="/eds/dist/js/app.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="/eds/dist/js/demo.js"></script>
	<script src="https://www.w3schools.com/lib/w3data.js"></script>
	<!-- load momentjs -->
	<script src="/eds/js/moment.min.js"></script>
	<!-- Custom js file -->
	<script src="/eds/js/search.js"></script>

	<script type="text/javascript">

		// get query parameter
		$(".main-sidebar .editor-treeview").addClass("active");
		$(".main-sidebar .admin-treeview").removeClass("active");
		// call ajax to fill table 
		
		// fill query for search box
		$("#query").val(decodeURIComponent(getUrlParameter()["query"]))
		// 
		var config = {}
		config.query = decodeURIComponent(getUrlParameter()["query"])
		config.contextPath = "${pageContext.request.contextPath}";
		config.offset = 0
		config.sortBy = "probabilityForYes"
		config.decs = "TRUE"
		config.NO = 0;
		config.isLoad = true
		config.source = "twitter"
		config.searchToDate = moment().format("DD-MM-YYYY")
		config.searchFromDate = "1-1-1970"
		searchNews(config);
		// load addition 10 rows when scrollTop < 100
		$(window).scroll(function() {

			var scrollHeight = $(document).height();
			var scrollPosition = $(window).height() + $(window).scrollTop();
			if ((scrollHeight - scrollPosition) < 30 && config.isLoad == true) {
				// when scroll to bottom of the page
				config.isLoad = false
				config.offset += 1
				console.log("offset, ", config.offset)
				// load

				searchNews(config)
			}
		});

	</script>
</body>
</html>



