<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Registration</title>
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
<h2>Consultant Registration</h2>
<c:if test="${not empty message}">
<p class="invalid">${message}</p>
</c:if>

  <form action="Registration" method="post">
  	<div class="row align-items-center">
		<div class="col-12 col-md-3">Your lastname</div>
		<div class="col-12 col-md-9">
		<input type="text" class="form-control" id="nom"
			placeholder="Enter lastname" name="nom"
			value="${consultant.nom}" required />
		</div>
	</div>
 	<div class="row align-items-center">
		<div class="col-12 col-md-3">Your firstname</div>
		<div class="col-12 col-md-9">	
		<input type="text" class="form-control" id="prenom"
			placeholder="Enter firstname" name="prenom" 
			value="${consultant.prenom}" required />
		</div>
	</div>
  	<div class="row align-items-center">
		<div class="col-12 col-md-3">Your email</div>
		<div class="col-12 col-md-9">	
		<input type="email" id="email" name="email" 
			placeholder="Enter email address"  
			class="form-control validate"
			value="${consultant.email}" required />
		</div>
	</div>
	<div class="row align-items-center">
		<div class="col-12 col-md-3">Password</div>
		<div class="col-12 col-md-9">	
			<input type="password" id="password" name="password" 
		    pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
		    title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required>
		</div>
		<div class="col-12 col-md-9 offset-md-3" id="message">
		  <span>Password must contain: </span>
		  <span id="letter" class="invalid">A <b>lowercase</b> letter, </span>
		  <span id="capital" class="invalid">an <b>uppercase</b> letter, </span>
		  <span id="number" class="invalid">a <b>number</b>, </span>
		  <span id="length" class="invalid">minimum <b>8 characters</b>.</span>
		</div>		
	</div>
  
    
  	<div class="row align-items-center">
		<div class="col-12 col-md-3">Confirm Password</div>
		<div class="col-12 col-md-9">	
			<input type="password" id="password2" name="password2" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required>
    	</div>
	</div>

  	<div class="row align-items-center">
		<div class="col-12 col-md-9 offset-md-3">		
			<button type="sumbit" class="btn btn-primary mt-3">Create account</button>
		</div>
	</div>
	
	<div class="row align-items-center">
		<div class="col-12 col-md-9 offset-md-3 mt-2">		
			Have already an account? <a href="Login"
			class="fw-bold text-body">Login here</a>
		</div>
	</div>
	
	
  </form>
</div>

 <script type="text/javascript" src="password.js"></script>

</body>
</html>