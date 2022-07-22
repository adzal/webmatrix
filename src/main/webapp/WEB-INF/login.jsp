<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
		<h2>Consultant login</h2>
		<c:if test="${not empty message}">
			<p class="invalid">${message}</p>
		</c:if>
		
		<form action="Login" method="post">
  			<div class="row align-items-center">
				<div class="col-12 col-md-3">Email</div>
				<div class="col-12 col-md-9">
					<input type="text" class="form-control" id="email"
						placeholder="Enter email address" name="email" 
						value="${email}" required />
				</div>
			</div>
				
		  	<div class="row align-items-center">
				<div class="col-12 col-md-3">Password</div>
				<div class="col-12 col-md-9">
					<input type="password" class="form-control" id="password"
						placeholder="Enter password"
						name="password" required>
				</div>
			</div>			
			
		  	<div class="row align-items-center mt-3">
				<div class="col-12 col-md-3">
					<a href="Registration" class="fw-bold text-body">Create Account</a>				
				</div>
				<div class="col-12 col-md-9">
					<button type="submit" class="btn btn-primary">Submit</button>
			
					<div class="form-check">
		              <input class="form-check-input" name="rememberme" 
		              type="checkbox" value="0"  >
		              <label class="form-check-label"> Remember me</label>
		            </div>
		    	</div>	
			</div>
		</form>
	</div>
</body>

</html>
