<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Registro Clientes</title>
	<link href="<c:url value='/static/css/style.css' />" rel="stylesheet"></link>
</head>

<body>
 	<div class="container">
		<%@include file="authheader.jsp" %>
		<div class="container-standart">
			<div class="titulo">
				<h2>Formulario Registro Clientes</h2>
			</div>
					
		 	<form:form method="POST" modelAttribute="oauthClientDetails" class="form-horizontal">
				<form:input type="hidden" path="oid" id="oid"/>
				
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="clientId">Client Id</label>
						<div class="col-md-7">
							<form:input type="text" path="clientId" id="clientId" class="form-control input-sm"  required="required"/>
							<div class="has-error">
								<form:errors path="clientId" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="clientName">Client Name</label>
						<div class="col-md-7">
							<form:input type="text" path="clientName" id="clientName" class="form-control input-sm" required="required"/>
							<div class="has-error">
								<form:errors path="clientName" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
		
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="resourceIds">Resource Ids</label>
						<div class="col-md-7">
							<form:input type="text" path="resourceIds" id="resourceIds" class="form-control input-sm" required="required"/>
							<div class="has-error">
								<form:errors path="resourceIds" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
				
				<c:choose>
					<c:when test="${edit}">
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable" for="clientSecret">Client Secret</label>
								<div class="col-md-7">
									<form:input type="text" path="clientSecret" id="clientSecret" class="form-control input-sm" readonly="true"/>										
								</div>
							</div>
						</div>
					</c:when>								
				</c:choose>
				
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="scope">Scope</label>
						<div class="col-md-7">
							<form:select path="scope" multiple="true" itemValue="id" itemLabel="type" class="form-control input-sm" required="required" >
								<form:option value="read"/>
								<form:option value="write"/>
							</form:select>
							<div class="has-error">
								<form:errors path="scope" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
		
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="authorizedGrantTypes">Authorized Grant Types</label>
						<div class="col-md-7">
							<form:select path="authorizedGrantTypes" multiple="true" itemValue="id" itemLabel="type" class="form-control input-sm" required="required">
								<form:option value="password"/>
								<form:option value="refresh_token"/>
								<form:option value="client_credential"/>
							</form:select>
							<div class="has-error">
								<form:errors path="authorizedGrantTypes" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
		
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="webServerRedirectUri">Web Server Redirect Uri</label>
						<div class="col-md-7">
							<form:input type="text" path="webServerRedirectUri" id="webServerRedirectUri" class="form-control input-sm" required="required" />
							<div class="has-error">
								<form:errors path="webServerRedirectUri" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
		
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="authorities">Authorities</label>
						<div class="col-md-7">
							<form:select path="authorities" multiple="true" itemValue="id" itemLabel="type" class="form-control input-sm" required="required">
								<form:option value="ADMIN"/>
								<form:option value="USER"/>
								<form:option value="GUEST"/>
							</form:select>
							<div class="has-error">
								<form:errors path="authorities" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="accessTokenValidity">AccessToken Validity</label>
						<div class="col-md-7">
							<form:input type="text" path="accessTokenValidity" id="accessTokenValidity" class="form-control input-sm" required="required"/>
							<div class="has-error">
								<form:errors path="accessTokenValidity" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="refreshTokenValidity">RefreshToken Validity</label>
						<div class="col-md-7">
							<form:input type="text" path="refreshTokenValidity" id="refreshTokenValidity" class="form-control input-sm" required="required" />
							<div class="has-error">
								<form:errors path="refreshTokenValidity" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="autoapprove">Auto Approve</label>
						<div class="col-md-7">
							<form:input type="text" path="autoapprove" id="autoapprove" class="form-control input-sm" required="required"/>
							<div class="has-error">
								<form:errors path="autoapprove" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
		
				<div class="row">
					<div class="form-actions floatRight">
						<c:choose>
							<c:when test="${edit}">
								<input type="submit" value="Update" class="botones2"/>  <a class="ref-delete" href="<c:url value='/list' />">Cancel</a>
							</c:when>
							<c:otherwise>
								<input type="submit" value="Register" class="botones2"/>  <a class="ref-delete" href="<c:url value='/list' />">Cancel</a>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>