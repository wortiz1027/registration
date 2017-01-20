<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
<link href="<c:url value='/static/css/style.css' />" rel="stylesheet"></link>
</head>

<body>
	<div class="container">
	 	<div class="container-login">
	 		<c:url var="loginUrl" value="/login" />
			<form action="${loginUrl}" method="post" class="form-horizontal">
				<div class="imgcontainer">
					<img src="http://www.freeiconspng.com/uploads/user-login-icon-14.png"/>
	  			</div>
	  			
				<c:if test="${param.error != null}">
					<div class="alert alert-danger">
						<p>Usuario Invalido.</p>
					</div>
				</c:if>
				<c:if test="${param.logout != null}">
					<div class="alert alert-success">
						<p>Sesion cerrada exitosamente!</p>
					</div>
				</c:if>
				
				<input type="text" class="inputText" id="username" name="username" placeholder="Usuario" required> 
				
				<br> 
				
				<input type="password" class="inputText" id="password" name="password" placeholder="Password" required>
	
				<div class="input-group input-sm">
					<div>
						<label><input type="checkbox" id="rememberme" name="remember-me"> Remember Me</label>
					</div>
				</div>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
	
				<div>
					<input type="submit" value="Log in" class="botones">
				</div>
				
				<div class="" style="background-color:#f1f1f1">
				    <input type="submit" value="Cancelar" class="cancelbtn">
				    <span class="psw"><a class="ref-edit" href="#">Registrar</a></span>
			   </div>
			</form>
	 	</div>
		
	</div>
</body>
</html>