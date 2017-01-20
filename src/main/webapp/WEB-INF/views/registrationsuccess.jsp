<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Registration Confirmation Page</title>
	<link href="<c:url value='/static/css/style.css' />" rel="stylesheet"></link>
</head>
<body>
	<div class="container">
		<%@include file="authheader.jsp" %>
		<div class="container-list">
			<div class="titulo">
				<h2>Cliente Registrado Exitosamente!</h2>
			</div>
			
			<div class="lista">
		        <table class="gridtable">	
		        	<thead>
						<tr>
							<th>Atributos</th>
							<th>Valores</th>
						</tr>
					</thead>
					<tbody>
						<tr>
			                <td>Client Id:</td>
			                <td>${oauthClientDetails.clientId}</td>
			            </tr>
			            <tr>
			                <td>Client Name:</td>
			                <td>${oauthClientDetails.clientName}</td>
			            </tr>
			            <tr>
			                <td>Client Secret:</td>
			                <td>${oauthClientDetails.clientSecret}</td>
			            </tr>
			            <tr>
			                <td>Resource Ids:</td>
			                <td>${oauthClientDetails.resourceIds}</td>
			            </tr>
			            <tr>
			                <td>Scopes:</td>
			                <td>${oauthClientDetails.scope}</td>
			            </tr>
			 			<tr>
			                <td>Grant Types:</td>
			                <td>${oauthClientDetails.authorizedGrantTypes}</td>
			            </tr>
			            <tr>
			                <td>Redirect URI:</td>
			                <td>${oauthClientDetails.webServerRedirectUri}</td>
			            </tr>
			            <tr>
			                <td>Authorities:</td>
			                <td>${oauthClientDetails.authorities}</td>
			            </tr>
			            <tr>
			                <td>Access Token Validity:</td>
			                <td>${oauthClientDetails.accessTokenValidity}</td>
			            </tr>
			            <tr>
			                <td>Refresh Token Validity:</td>
			                <td>${oauthClientDetails.refreshTokenValidity}</td>
			            </tr>
			            <tr>
			                <td>Auto Approve:</td>
			                <td>${oauthClientDetails.autoapprove}</td>
			            </tr>
					</tbody>
		        </table>
		    </div>
		    
			<div class="lista">
				<span class="well floatRight">
					<a class="ref-register"href="<c:url value='/list' />">Listado Clientes</a>
				</span>
			</div>
		</div>
	</div>
</body>

</html>