<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Change Password</title>
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

<div class="container bg-light border">	
<h2>Change password</h2>
<c:if test="${not empty message}">
	<p class="invalid">${message}</p>
</c:if>		
<form action="ChangePassword" method="post">

	<div class="row align-items-center">
		<div class="col-12 col-md-4">Your email</div>
		<div class="col-12 col-md-8">	
		<input type="email" id="email" name="email" 
			placeholder="Enter email address"  
			class="form-control validate"
			value="${consultant.email}" required />
		</div>
	</div>
	
  	<div class="row align-items-center">
		<div class="col-12 col-md-4">Old Password</div>
		<div class="col-12 col-md-8">	
	  	<input type="password" id="oldpassword" name="oldpassword" required>	
		</div>
	</div>

  	<div class="row align-items-center">
		<div class="col-12 col-md-4">New Password</div>
		<div class="col-12 col-md-8">	
			<input type="password" id="password" name="password" 
		    pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
		    title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required>
		</div>
		<div class="col-12 col-md-8 offset-md-4" id="message">
		  <span>Password must contain: </span>
		  <span id="letter" class="invalid">A <b>lowercase</b> letter, </span>
		  <span id="capital" class="invalid">an <b>uppercase</b> letter, </span>
		  <span id="number" class="invalid">a <b>number</b>, </span>
		  <span id="length" class="invalid">minimum <b>8 characters</b>.</span>
		</div>		
	</div>
    
  	<div class="row align-items-center">
		<div class="col-12 col-md-4">Confirm New Password</div>
		<div class="col-12 col-md-8">	
			<input type="password" id="password2" name="password2" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required>
    	</div>
	</div>
    
  	<div class="row align-items-center">
   		<div class="col-12 col-md-9 offset-md-4">		
			<button type="sumbit" >Change password</button>
		</div>
	</div>
	
 	<script type="text/javascript" src="password.js"></script>
  </form>
			
 </div>
</body>
</html>