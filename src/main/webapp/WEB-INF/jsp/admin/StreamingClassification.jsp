<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
	function OnStart() {
		$.LoadingOverlay("show");
		if (document.getElementById("logConsole").innerHTML == null
				|| document.getElementById("logConsole").innerHTML == "") {
			document.getElementById("logConsole").innerHTML = "Please wait for processing ... ";
		}
		document.StartClassificationForm.submit();
	}

	function OnStop() {
		$.LoadingOverlay("show");
		if (document.getElementById("logConsole").innerHTML == null
				|| document.getElementById("logConsole").innerHTML == "") {
			document.getElementById("logConsole").innerHTML = "Please wait for processing ... ";
		}
		document.StopClassificationForm.elements["logConsole"].value += document
				.getElementById("logConsole").innerHTML;
		document.StopClassificationForm.submit();
	}
	function OnUploadModel() {
		if($("#uploadFile")[0].files[0] != null && $("#uploadFile")[0].files[0].size > 0){
			$.LoadingOverlay("show");
			if (document.getElementById("logConsole").innerHTML == null
					|| document.getElementById("logConsole").innerHTML == "") {
				document.getElementById("logConsole").innerHTML = "Please wait for processing ... ";
			}
			document.UploadModelForm.elements["logConsole"].value += document
					.getElementById("logConsole").innerHTML;
			document.UploadModelForm.submit();
		}else{
			alert("File rỗng!");
		}
		
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
				<h1 class="text-center">Streaming Data Classification</h1>
				<hr />
			</section>

			<!-- Main content -->
			<section class="content">
				<input type="hidden" id="statusBackground" name="statusBackground" value="<s:property value="statusBackground"/>">
<!-- 				<div class="container"> -->
					<div class="row" style="    margin-bottom: 25px;">
						<label
										class="col-md-2 col-md-offset-2 col-sm-3 col-sm-offset-2" style="    padding-left: 5px;
    text-align: left;">Status:
									</label>
						<div class="col-sm-6">
							<span id="status" class="label" style="font-size: 13px;"><s:if
									test="classifierStatus == null">Đã ngừng hoạt động!</s:if> <s:else>
									<s:property value="classifierStatus" />
								</s:else> </span>
						</div>
					</div>

					<div class="row">
								<div class="form-horizontal">

							<div class="form-group">
								<form action="uploadFile" method="post"
									enctype="multipart/form-data" name="UploadModelForm">
									<input type="hidden" name="logConsole"> <label
										class="col-md-2 col-md-offset-2 col-sm-3 col-sm-offset-2">Load model (.model):
									</label>
									<div class="col-md-6">
										<div class="input-group">
											<input type="hidden" name="actionName"
												value="StreamingClassification"> 
											<input id="uploadFile" type="file"
												name="uploadFile" class="filestyle"
												data-buttonName="btn-primary">
											<button class="btn btn-info" style="margin-left: 10px;" onclick="OnUploadModel()">Upload</button>
										</div>
									</div>
								</form>
							</div>

							<form action="StartClassification" method="post"
										name="StartClassificationForm">
										<div class="form-group">
											<label class="col-md-2 col-md-offset-2 col-sm-3 col-sm-offset-2">Log:</label>
											<div class="col-md-6">
												<textarea class="form-control" rows="5" id="logConsole"
													readonly="readonly" name="logConsole">${logConsole}</textarea>
											</div>
										</div>
									</form>
									
									<form action="StopClassification" method="post"
										enctype="multipart/form-data" name="StopClassificationForm">
										<input type="hidden" name="logConsole">
									</form>
								</div>
						</div>
						
						<div class="row">
							<div class="col-xs-4 col-xs-push-8 col-sm-8 col-md-8 col-lg-8">
								<button id="btnStart" class="btn btn-info"
									style="margin-right: 10px;" onclick="OnStart()">
									<i class="fa fa-play"></i> Start
								</button>
								<button id="btnStop" class="btn btn-danger" onclick="OnStop()">
									<i class="fa fa-stop"></i> Stop
								</button>
							
								
							</div>
						</div>
<!-- 				</div> -->
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<jsp:include page="../../../layout/Footer.jsp" flush="true"></jsp:include>

	</div>

	<!-- ./wrapper -->

	<script type="text/javascript">
		$(document).ready(function() {
			$(".bootstrap-filestyle").css("float", "left");
			var back = $("#statusBackground").val();
			if(back == null || back == "") back ="label-danger";
			$("#status").addClass(back);
			$(".main-sidebar .admin-treeview").addClass("active");
			$(".main-sidebar .editor-treeview").removeClass("active");
		
			if($("#status").html().trim() != "Đã ngừng hoạt động!" && $("#status").html().trim() != "Đã ngừng hoạt động"){
				 $('#btnStart').prop('disabled', true);
				 $('#btnStop').prop('disabled', false);
			}else{
				 $('#btnStop').prop('disabled', true);
				 $('#btnStart').prop('disabled', false);
			}
		})
	</script>
</body>

</html>
