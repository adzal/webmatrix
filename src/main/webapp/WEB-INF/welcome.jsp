<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Web login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<link rel="stylesheet" href="Login.css">
</head>

<body>
	<div class="container bg-light border">
		<h1>Consultant home page</h1>
		<h2>${message}</h2>

		<c:if test="${consultant.isChangePassword}">
			<div class="row">
				<p class="invalid">You must change your password:</p>
			</div>
		</c:if>
		<div class="row">
		<div class="col-12 col-md-6">
			<a href="ChangePassword"
				class="fw-bold text-body">Click here to change password</a>
		</div>		
		<div class="col-12 col-md-6">
			<a href="LogOut"
				class="fw-bold text-body">Click here to log out.</a>
		</div>	
		<div class="col-12 col-md-6">
			<a href="Preferences"
				class="fw-bold text-body">Click here to change preferences.</a>
		</div>
	</div>
</body>
</html>