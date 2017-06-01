<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>UIT | Dashboard</title>
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
		<img src="data:image/jpeg;base64,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">
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
		<b class="login-footer">� 2016 Admicro.vn</b>
	</div>

	<script src="./plugins/jQuery/jquery-2.2.3.min.js"></script>
	<script src="./bootstrap/js/bootstrap.min.js"></script>
</body>


