<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String userNameLogged = (String) session
			.getAttribute("userNameLogged");
%>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Admicro | Dashboard</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet" href="/VangBacDaQuy/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">

<!-- DataTables -->
<link rel="stylesheet"
	href="/VangBacDaQuy/plugins/datatables/dataTables.bootstrap.css">

<!-- Theme style -->
<link rel="stylesheet" href="/VangBacDaQuy/dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="/VangBacDaQuy/dist/css/skins/_all-skins.min.css">
<!-- iCheck -->
<link rel="stylesheet" href="/VangBacDaQuy/plugins/iCheck/flat/blue.css">
<!-- Morris chart -->
<link rel="stylesheet" href="/VangBacDaQuy/plugins/morris/morris.css">
<!-- jvectormap -->
<link rel="stylesheet"
	href="/VangBacDaQuy/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
<!-- Date Picker -->
<link rel="stylesheet" href="/VangBacDaQuy/plugins/datepicker/datepicker3.css">
<link rel="stylesheet" href="/VangBacDaQuy/css/style.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/css/bootstrap-select.min.css">




<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
<script>
	function OnCrawl() {
		if (document.getElementById("logConsole").innerHTML == null
				|| document.getElementById("logConsole").innerHTML == "") {
			document.getElementById("logConsole").innerHTML = "Please wait for processing ... ";
		}
		document.CrawlTweetForm.submit();
	}
	function OnUploadKeywords() {
		if (document.getElementById("logConsole").innerHTML == null
				|| document.getElementById("logConsole").innerHTML == "") {
			document.getElementById("logConsole").innerHTML = "Please wait for processing ... ";
		}
		document.UploadKeywordsForm.elements["logConsole"].value += document
				.getElementById("logConsole").innerHTML;
		document.UploadKeywordsForm.submit();
	}
</script>


<header class="main-header">
	<!-- Logo -->
	<a href="/VangBacDaQuy/editor/ShowHotNews" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
		<span class="logo-mini"><b>A</b>LT</span> <!-- logo for regular state and mobile devices -->
		<span class="logo-lg"> <img
			src="https://bigdata.admicro.vn/static/themes/bigdata/images/logo.png"
			style="height: 34px;" alt="Admicro Bigdata" title="Admicro Bigdata">
	</span>
	</a>
	<!-- Header Navbar: style can be found in header.less -->
	<nav class="navbar navbar-static-top">
		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">

				<li class="dropdown user user-menu"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"> <!-- <img src="/dist/img/user2-160x160.jpg" class="user-image" alt="User Image"> -->
						<span class="hidden-xs"><b>Hello, <%=userNameLogged%></b></span>
				</a>
					<ul class="dropdown-menu">
						<!-- Menu Footer-->
						<li class="user-footer">
							<div class="inline">
								<a href="#" class="btn btn-default btn-flat">Profile</a>
							</div>
							<div class="pull-right">
								<a href="/VangBacDaQuy/Logout" class="btn btn-danger btn-flat">Sign
									out</a>
							</div>
						</li>
					</ul></li>

			</ul>
		</div>
	</nav>
</header>
