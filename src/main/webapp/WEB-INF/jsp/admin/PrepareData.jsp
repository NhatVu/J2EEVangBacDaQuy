<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Admicro | Dashboard</title>
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
<script src="https://www.w3schools.com/lib/w3data.js"></script>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

<script>
	function OnPrepareData() {
		document.getElementById("logConsole").innerHTML = "Please wait for processing ... ";
		document.PrepareDataForm.submit();
	}
</script>
</head>

<body class="hold-transition sidebar-mini">
	<div class="wrapper">
		<jsp:include page="../../../layout/Header.jsp" flush="true"></jsp:include>
		<!-- Left side column. contains the logo and sidebar -->
		<jsp:include page="../../../layout/LeftSideBar.jsp" flush="true"></jsp:include>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1 class="text-center">Prepare Data</h1>
				<hr />
			</section>

			<!-- Main content -->
			<section class="content">
				<div class=row">
					<div class="col-md-1"></div>
					<div class="col-md-10">

						<div class="row">
							<form action="PrepareData" method="post" name="PrepareDataForm">
								<div class="form-horizontal">

									<div class="form-group">
										<label class="col-sm-2 col-sm-offset-2">Database: </label>
										<div class="col-sm-7">

											<%-- 									<s:select name="dataSource" list="{'Twitter','News'}" --%>
											<%-- 										headerKey="-1" headerValue="--- Please Select ---" --%>
											<%-- 										emptyOption="false" /> --%>

											<select class="form-control" name="dataSource">
												<option value="All">All</option>
												<option value="Twitter">Twitter (MongoDB)</option>
												<option value="News">News (MySQL)</option>
											</select>
										</div>
									</div>

									<div class="form-group form-inline">
										<label class="col-sm-2 col-sm-offset-2">Published
											date:</label>
										<div class="col-md-7">
											<div class="row">
												<div class="col-md-1">
													<span class="inline-margin">From</span>
												</div>

												<div class="col-sm-4" style="    margin-left: 15px;">
													<div class="form-group pull-left">
														<div class='input-group date' id='startDate'>
															<input type='text' class="form-control" name="fromDate"/>
															<span class="input-group-addon"> <span
																class="glyphicon glyphicon-calendar"></span>
															</span>
														</div>
													</div>
												</div>

												<div class="col-md-1">
													<span class="inline-margin">to </span>
												</div>

												<div class="col-md-4">
													<div class="form-group pull-left"
														style="margin-right: 1px;">
														<div class='input-group date' id='endDate'>
															<input type='text' class="form-control" name="toDate"/>
															<span class="input-group-addon"> <span
																class="glyphicon glyphicon-calendar"></span>
															</span>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-2 col-sm-offset-2">Log:</label>
										<div class="col-sm-7">
											<textarea class="form-control" rows="5" id="logConsole"
												readonly="readonly" name="logConsole">${logConsole}</textarea>
										</div>
									</div>
									<div class="form-group">
								<div class="download-file col-sm-offset-4 form-control-padding">
								<s:url id="fileDownload" namespace="/admin"
									action="downloadFile">
									<s:param name="filePath" value="%{downloadFilePath}"></s:param>	
								</s:url>
								<s:a href="%{fileDownload}">${downloadFileName}</s:a>
								</div>
								</div>
									<div class="form-group">
										<div class="col-sm-offset-4 col-sm-7">
											<button type="button"
												class="btn btn-success pull-right finish-button"
												onclick="OnPrepareData()">Run</button>
										</div>
									</div>
								</div>


								<!-- /.info-box -->
							</form>
						</div>
					</div>
					<div class="col-md-1"></div>
				</div>
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<jsp:include page="../../../layout/Footer.jsp" flush="true"></jsp:include>

	</div>
	<!-- ./wrapper -->

	<script type="text/javascript">
		$('#startDate').datepicker();
		$('#endDate').datepicker();
		$(document).ready(function() {
			$(".main-sidebar .admin-treeview").addClass("active");
			$(".main-sidebar .editor-treeview").removeClass("active");
		})
	</script>
</body>

</html>


</html>
