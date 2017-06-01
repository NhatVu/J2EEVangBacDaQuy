<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
<body>
	<section class="content">

      <div class="error-page">
        <h2 class="headline text-red">403</h2>

        <div class="error-content">
          <h3><i class="fa fa-warning text-red"></i> Oops! Access denied page.</h3>

          <p>
            We will work on fixing that right away.
            Meanwhile, you may <a href="../../index.html">return to dashboard</a> or try using the search form.
          </p>

          <form class="search-form">
            <div class="input-group">
              <input type="text" name="search" class="form-control" placeholder="Search">

              <div class="input-group-btn">
                <button type="submit" name="submit" class="btn btn-danger btn-flat"><i class="fa fa-search"></i>
                </button>
              </div>
            </div>
            <!-- /.input-group -->
          </form>
        </div>
      </div>
      <!-- /.error-page -->

    <div style="padding: 10px 0px; text-align: center;"><div class="text-muted">Excuse the ads! We need some help to keep our site up.</div><script async="" src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script><div class="visible-xs visible-sm"><!-- AdminLTE --><ins class="adsbygoogle" style="display:inline-block;width:300px;height:250px" data-ad-client="ca-pub-4495360934352473" data-ad-slot="5866534244"></ins><script>(adsbygoogle = window.adsbygoogle || []).push({});</script></div><div class="hidden-xs hidden-sm"><!-- Home large leaderboard --><ins class="adsbygoogle" style="display:inline-block;width:728px;height:90px" data-ad-client="ca-pub-4495360934352473" data-ad-slot="1170479443"></ins><script>(adsbygoogle = window.adsbygoogle || []).push({});</script></div></div></section>
</body>
</html>