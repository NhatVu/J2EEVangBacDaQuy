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

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

<script>
	function OnPreprocess() {
		if (document.getElementById("logConsole").innerHTML == null
				|| document.getElementById("logConsole").innerHTML == "") {
			document.getElementById("logConsole").innerHTML = "Please wait for processing ... ";
		}

		var selectedValue = document.getElementById("dataType").value;
		document.PreprocessDataForm.elements["dataTypeSubmit"].value = selectedValue;
		document.PreprocessDataForm.submit();
	}
	function OnUploadStopwords() {
		if (document.getElementById("logConsole").innerHTML == null
				|| document.getElementById("logConsole").innerHTML == "") {
			document.getElementById("logConsole").innerHTML = "Uploading";
		}
		document.UploadStopwordsForm.elements["logConsole"].value += document
				.getElementById("logConsole").innerHTML;
		
		var selectedValue = document.getElementById("dataType").value;
		document.UploadStopwordsForm.elements["dataTypeSubmit"].value = selectedValue;
		document.UploadStopwordsForm.submit();
	}
	function OnUploadDataFile() {
		if (document.getElementById("logConsole").innerHTML == null
				|| document.getElementById("logConsole").innerHTML == "") {
			document.getElementById("logConsole").innerHTML = "Uploading";
		}
		document.UploadDataFileForm.elements["logConsole"].value += document
				.getElementById("logConsole").innerHTML;

		var selectedValue = document.getElementById("dataType").value;
		document.UploadDataFileForm.elements["dataTypeSubmit"].value = selectedValue;
		document.UploadDataFileForm.submit();
	}
	function OnUploadDictionaryFile() {
		if (document.getElementById("logConsole").innerHTML == null
				|| document.getElementById("logConsole").innerHTML == "") {
			document.getElementById("logConsole").innerHTML = "Uploading";
		}
		document.UploadDictionaryFileForm.elements["logConsole"].value += document
				.getElementById("logConsole").innerHTML;

		var selectedValue = document.getElementById("dataType").value;
		document.UploadDictionaryFileForm.elements["dataTypeSubmit"].value = selectedValue;
		document.UploadDictionaryFileForm.submit();
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
				<h1 class="text-center">Preprocess Data</h1>
				<hr />
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-md-1"></div>
					<div class="col-md-10">
						<div class="row">
							<div class="form-horizontal">
								<div class="form-group">
									<label class="col-md-2 col-md-offset-2 col-sm-3 col-sm-offset-2">Data type: </label>
									<div class="col-md-6 col-sm-6">
										<select class="form-control" name="dataType" id="dataType">
											<option value="Training">Training data</option>
											<option value="Testing">Testing or Unlabeled data</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<form action="uploadFile" method="post"
										enctype="multipart/form-data" name="UploadDataFileForm">
										<input type="hidden" name="logConsole"> <label
											class="col-md-2 col-md-offset-2 col-sm-3 col-sm-offset-2">Data file (.xlsx): </label>
										<input type="hidden" name="dataTypeSubmit">
										<div class="col-md-6">
											<div class="input-group">
												<input type="hidden" name="actionName"
												value="preprocessData_DataFile">
												<input  type="file"
												name="uploadFile" class="filestyle"
												data-buttonName="btn-primary">
												<button class="btn btn-info" style="margin-left: 10px;" onclick="OnUploadDataFile()">Upload</button>
											</div>
										</div>
									</form>
								</div>

								<div class="form-group" id="UploadDictionaryFileFormGroup">
									<form action="uploadFile" method="post"
										enctype="multipart/form-data" name="UploadDictionaryFileForm" >
										<input type="hidden" name="logConsole"> <label
											class="col-sm-2 col-sm-offset-2">Lucene term
											dictionary (.zip): </label> <input type="hidden"
											name="dataTypeSubmit">
										<div class="col-md-6">
											<div class="input-group">
												<input type="hidden" name="actionName"
													value="preprocessData_DictionaryFile"> 
												<input  type="file"
												name="uploadFile" class="filestyle"
												data-buttonName="btn-primary">
												<button class="btn btn-info" style="margin-left: 10px;" onclick="OnUploadDictionaryFile()">Upload</button>

											</div>
										</div>
									</form>
								</div>

								<div class="form-group">
									<form action="uploadFile" method="post"
										enctype="multipart/form-data" name="UploadStopwordsForm">
										<input type="hidden" name="logConsole"> <label
											class="col-sm-2 col-sm-offset-2">Stopwords (.txt): </label> <input type="hidden"
											name="dataTypeSubmit">
										<div class="col-md-6">
											<div class="input-group">
												<input type="hidden" name="actionName"
													value="PreprocessData_StopwordFile"> 
													<input  type="file"
												name="uploadFile" class="filestyle"
												data-buttonName="btn-primary">
												<button class="btn btn-info" style="margin-left: 10px;" onclick="OnUploadStopwords()">Upload</button>
											</div>
										</div>
									</form>
								</div>

								<form action="PreprocessData" method="post"
									name="PreprocessDataForm">
									<input type="hidden" name="dataTypeSubmit" value="">
									<div class="form-group">
										<label class="col-sm-2 col-sm-offset-2">Log:</label>
										<div class="col-md-6">
											<textarea class="form-control" rows="5" id="logConsole"
												readonly="readonly" name="logConsole">${logConsole}</textarea>
										</div>
									</div>
									<div class="form-group">
										<div
											class="download-file col-sm-offset-4 form-control-padding">
											<s:url id="fileDownload1" namespace="/admin"
												action="downloadFile">
												<s:param name="filePath" value="%{CSVFilePath}"></s:param>
											</s:url>
											<s:a id="csvFileName" href="%{fileDownload1}">${CSVFileName}</s:a>
											<br>

											<s:url id="fileDownload2" namespace="/admin"
												action="downloadFile">
												<s:param name="filePath" value="%{dictionaryFilePath}"></s:param>
											</s:url>
											<s:a id="dictFileName" href="%{fileDownload2}">${dictionaryFileName}</s:a>
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-offset-4 col-sm-6">
											<button type="button"
												class="btn btn-success pull-right finish-button"
												onclick="OnPreprocess()">Process data</button>
										</div>

									</div>
								</form>
							</div>

							<!-- /.info-box -->
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
		$(document).ready(function() {
			$(".bootstrap-filestyle").css("float", "left");
			$(".main-sidebar .admin-treeview").addClass("active");
			$(".main-sidebar .editor-treeview").removeClass("active");
			$("#dictFileName").show();
			$("#csvFileName").show();
			if ("${dataTypeSubmit}" == "" || "${dataTypeSubmit}" == "Training"){
				$("#UploadDictionaryFileFormGroup").hide();
				$("#dataType").val("Training")

			}
			else{
				$("#UploadDictionaryFileFormGroup").show();
				$("#dataType").val("${dataTypeSubmit}")
			}
		})
		$('#dataType').on('change', function() {
			$("#dictFileName").hide();
			$("#csvFileName").hide();
			if (this.value == "Training"){
				$("#UploadDictionaryFileFormGroup").hide();	
			}
			else
				$("#UploadDictionaryFileFormGroup").show();
		})
	</script>
</body>

</html>
