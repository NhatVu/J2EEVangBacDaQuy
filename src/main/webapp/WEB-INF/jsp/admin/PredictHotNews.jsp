<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<!-- jQuery 2.2.3 -->
<script src="/eds/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
<script>
	function OnPredict() {
		if (document.getElementById("logConsole").innerHTML == null
				|| document.getElementById("logConsole").innerHTML == "") {
			document.getElementById("logConsole").innerHTML = "Please wait for processing ... ";
		}
		document.PredictHotNewsForm.submit();
	}
	function OnUploadModel() {
		if (document.getElementById("logConsole").innerHTML == null
				|| document.getElementById("logConsole").innerHTML == "") {
			document.getElementById("logConsole").innerHTML = "Please wait for processing ... ";
		}
		document.UploadModelForm.elements["logConsole"].value += document
				.getElementById("logConsole").innerHTML;
		document.UploadModelForm.submit();
	}
	function OnUploadDataFile() {
		if (document.getElementById("logConsole").innerHTML == null
				|| document.getElementById("logConsole").innerHTML == "") {
			document.getElementById("logConsole").innerHTML = "Please wait for processing ... ";
		}
		document.UploadDataFileForm.elements["logConsole"].value += document
				.getElementById("logConsole").innerHTML;
		document.UploadDataFileForm.submit();
	}
	function OnUploadLabelValues() {
		if (document.getElementById("logConsole").innerHTML == null
				|| document.getElementById("logConsole").innerHTML == "") {
			document.getElementById("logConsole").innerHTML = "Please wait for processing ... ";
		}
		document.UploadLabelValuesForm.elements["logConsole"].value += document
				.getElementById("logConsole").innerHTML;
		document.UploadLabelValuesForm.submit();
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
				<h1 class="text-center">Predict Hot News</h1>
				<hr />
			</section>

			<!-- Main content -->
			<section class="content">
						<div class="row">
							<div class="form-horizontal">

								<div class="form-group">
									<form action="uploadFile" method="post"
										enctype="multipart/form-data" name="UploadModelForm">
										<input type="hidden" name="logConsole"> <label
											class="col-sm-2 col-sm-offset-2">Load model (.model): </label>
										<div class="col-md-6">
											<div class="input-group">
												<input type="hidden" name="actionName"
													value="PredictHotNews_ModelFile"> 
												<input  type="file"
									name="uploadFile" class="filestyle"
									data-buttonName="btn-primary">
									<button class="btn btn-info" style="margin-left: 10px;" onclick="OnUploadModel()">Upload</button>
											</div>
										</div>
									</form>
								</div>
								
								<div class="form-group">
									<form action="uploadFile" method="post"
										enctype="multipart/form-data" name="UploadLabelValuesForm">
										<input type="hidden" name="logConsole"> <label
											class="col-sm-2 col-sm-offset-2">Label values (.txt): </label>
										<div class="col-md-6">
											<div class="input-group">
												<input type="hidden" name="actionName"
													value="PredictHotNews_LabelValuesFile"> 
													<input  type="file"
									name="uploadFile" class="filestyle"
									data-buttonName="btn-primary">
									<button class="btn btn-info" style="margin-left: 10px;" onclick="OnUploadLabelValues()">Upload</button>

											</div>
										</div>
									</form>
								</div>
								<div class="form-group">
									<form action="uploadFile" method="post"
										enctype="multipart/form-data" name="UploadDataFileForm">
										<input type="hidden" name="logConsole"> <label
											class="col-sm-2 col-sm-offset-2">Unlabeled data (.csv): </label>
										<div class="col-md-6">
											<div class="input-group">
												<input type="hidden" name="actionName"
													value="PredictHotNews_DataFile">
													<input  type="file"
									name="uploadFile" class="filestyle"
									data-buttonName="btn-primary">
									<button class="btn btn-info" style="margin-left: 10px;" onclick="OnUploadDataFile()">Upload</button>
											</div>
										</div>
									</form>
								</div>
								<form action="PredictHotNews" method="post" name="PredictHotNewsForm">
								<div class="form-group">
									<label class="col-sm-2 col-sm-offset-2">Log:</label>
									<div class="col-sm-6">
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
									
										<div class="col-sm-offset-4 col-sm-6">
											<button type="button"
												class="btn btn-success pull-right finish-button"
												onclick="OnPredict()">Predict data</button>
										</div>
									
								</div>
								</form>
							</div>
						</div>
					</div>
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<jsp:include page="../../../layout/Footer.jsp" flush="true"></jsp:include>

	</div>


	</div>
	<!-- ./wrapper -->

	<script type="text/javascript">
		$(document).ready(function() {
			$(".bootstrap-filestyle").css("float", "left");
			$(".main-sidebar .admin-treeview").addClass("active");
			$(".main-sidebar .editor-treeview").removeClass("active");
		})
	</script>
</body>

</html>
