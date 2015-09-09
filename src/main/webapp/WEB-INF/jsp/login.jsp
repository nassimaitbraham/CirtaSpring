<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

	<!-- General Metas -->
	<meta charset="UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">	<!-- Force Latest IE rendering engine -->
	<title>Login Form</title>
	<meta name="description" content="">
	<meta name="author" content="">
	<!-- Mobile Specific Metas -->
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" /> 
</head>
<body>


	



	<!-- Primary Page Layout -->

	<div class="container">
		
		<c:if test="${not empty error}">
		<div class="errorblock">
			Erreur d'authentification : votre login/password sont errones<br />veuillez reessayer et si le probleme persiste veuillez contacter l'administrateur.<br />
			<!-- le propriete ci-dessous permet d'afficher l'exception spring -->
			<!-- Caused : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}-->
		</div>

	</c:if>
		
		<div class="form-bg">
			<form name='f' action="<c:url value='j_spring_security_check' />" method='POST'>
				<h2>Login</h2>
				<p><input type='text' name='j_username' value=''></p>
				<p><input type='password' name='j_password' /></p>
				<label for="remember">
				  <input type="checkbox" id="remember" value="remember" />
				  <span>Remember me on this computer</span>
				</label>
				<input name="submit" type="submit"
					value="submit" />
			</form>
		</div>

	
		<p class="forgot">Forgot your password? <a href="">Click here to reset it.</a></p>


	</div><!-- container -->

	

</body>
</html>