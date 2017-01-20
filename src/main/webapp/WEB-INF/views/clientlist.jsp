<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Lista Clientes OAUTH2</title>
		<link href="<c:url value='/static/css/style.css' />" rel="stylesheet"></link>
	</head>

	<body>
		<div class="container">
			<%@include file="authheader.jsp"%>
			<div class="container-list">
				<!-- Default panel contents -->
				<div class="titulo">
					<h2>Listado de Clientes</h2>
				</div>
				
				<br>
				
				<div class="lista">
					<table class="gridtable">
						<thead>
							<tr>
								<th>Client Name</th>
								<th>Resource Ids</th>
								<th>Authorized Grant Types</th>
								<th>Authories</th>
								<th>AccessToken Validity</th>
								<th>RefreshToken Validity</th>
								<th>Auto Approve</th>
								<sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
									<th width="100"></th>
								</sec:authorize>
								<sec:authorize access="hasRole('ADMIN')">
									<th width="100"></th>
								</sec:authorize>
	
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${oauthClientDetails}" var="clients">
								<tr>
									<td>${clients.clientName}</td>
									<td>${clients.resourceIds}</td>
									<td>${clients.authorizedGrantTypes}</td>
									<td>${clients.authorities}</td>
									<td>${clients.accessTokenValidity}</td>
									<td>${clients.refreshTokenValidity}</td>
									<td>${clients.autoapprove}</td>
	
									<sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
										<td><a
											href="<c:url value='/edit-client-${clients.oid}' />"
											class="ref-edit">Editar</a></td>
									</sec:authorize>
									<sec:authorize access="hasRole('ADMIN')">
										<td><a
											href="<c:url value='/delete-client-${clients.oid}' />"
											class="ref-delete">Eliminar</a></td>
									</sec:authorize>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				
				<br>
				
				<sec:authorize access="hasRole('ADMIN')">
					<div class="lista">
						<a class="ref-register" href="<c:url value='/newclient' />">Registrar Cliente</a>
					</div>
				</sec:authorize>
			</div>			
		</div>
	</body>
</html>