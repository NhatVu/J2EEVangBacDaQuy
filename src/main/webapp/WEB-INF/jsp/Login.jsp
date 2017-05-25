<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Admicro | Dashboard</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet" href="css/style.css">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->

<style type="text/css">
.errors {
	background-color: #FFCCCC;
	border: 1px solid #CC0000;
	width: 360px;
	margin-bottom: 8px;
}
.errors li {
	list-style: none;
}
</style>

</head>

<body class="body-login">
	<!-- <object type="text/html" data="signup.html"></object> -->
	<div id="includedContent"></div>
	<div class="logo-login">
		<img src="https://sso.admicro.vn//images/admicro.png">
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<h1 class="text-center">
					<span class="glyphicon glyphicon-share"></span> Login
				</h1>

				<s:if test="hasActionErrors()">
					<div class="errors">
						<s:actionerror />
					</div>
				</s:if>
				<s:if test="hasActionMessages()">
					<div class="welcome">
						<s:actionmessage />
					</div>
				</s:if>

				<form action="executeLogin" method="post">
					<div class="form-group">
						<label>Username</label> <input type="text" name="username"
							class="form-control">
					</div>
					<div class="form-group">
						<label>Password</label> <input type="password" name="password"
							class="form-control">
					</div>
					<a href="#">Forget password</a>
					<button type="submit" name="Login"
						class="btn btn-warning pull-right">Login</button>

				</form>
				<br>
				<!-- <a href="/oauth/facebook" class="btn btn-primary">Login via Facebook</span></a>
				<a href="/oauth/google" class="btn btn-danger">Login via Google</span></a>
				<a href="" class="btn btn-primary">Login via Twitter</span></a> -->
			</div>

		</div>
	</div>

	<div class="hidden-xs">
		<b class="login-footer">© 2016 Admicro.vn</b>
	</div>

	<script src="./plugins/jQuery/jquery-2.2.3.min.js"></script>
	<script src="./bootstrap/js/bootstrap.min.js"></script>
</body>


