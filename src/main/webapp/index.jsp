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
		<h2>Web Matrix</h2>
		<c:if test="${not empty message}">
			<p class="invalid">${message}</p>
		</c:if>
		<h3>Management of consultants skills matrix.</h3>
		<div class="row align-items-center">
			<div>
			<p>A platform that allows consultants to update there skill sets. 
			Then for the business managers to be able to search on these skills.</p>
			<ul>
				<li>Need to be able to apply skills to consultant by either the business manager or consultant themselves.</li>
				<li>All skills should be searchable.</li>
				<li>Consultants will be able to log in via a website.</li>
			</ul>
			</div>
		</div>
  		<div class="row align-items-center">
			<div class="col-12 col-md-6">
				<a href="Login" class="fw-bold text-body">Sign in</a>
			</div>
			<div class="col-12 col-md-6">
				<a href="Registration" class="fw-bold text-body">Create Account</a>
			</div>
		</div>
	</div>
</body>

</html>
