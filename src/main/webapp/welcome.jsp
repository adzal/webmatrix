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
		<h1>${message}</h1>
		<h2>${consultant.nom}</h2>
		<h2>${consultant.prenom}</h2>

		<c:if test="${consultant.isChangePassword}">
			<div class="row">
				<p class="invalid">You must change your password: </p>
				<a href="ChangePassword?email=${consultant.email}" 
				class="fw-bold text-body">Click here to change</a>
			</div>
		</c:if>
	</div>
</body>
</html>