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
	<label for="email" class="d-flex">Your email</label>
	<input type="email" id="email" name="email" 
		placeholder="Enter email address"  
		class="form-control validate"
		value=<%= request.getParameter("email") %> required />
		
    <label for="oldpassword">Old Password</label>
    <input type="password" id="oldpassword" name="oldpassword" required>

    <label for="password">New Password</label>
    <input type="password" id="password" name="password"
     pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
     title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required>
     
	<div id="message">
	  <span>Password must contain: </span>
	  <span id="letter" class="invalid">A <b>lowercase</b> letter, </span>
	  <span id="capital" class="invalid">A <b>capital (uppercase)</b> letter, </span>
	  <span id="number" class="invalid">A <b>number</b>, </span>
	  <span id="length" class="invalid">Minimum <b>8 characters</b>.</span>
	</div>
	
    <label for="password2">Confirm New Password</label>
    <input type="password" id="password2" name="password2" 
    pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
    title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required>
    
	<button type="sumbit" >Create account</button>
	
 	<script type="text/javascript" src="password.js"></script>
  </form>
			
 </div>
</body>
</html>