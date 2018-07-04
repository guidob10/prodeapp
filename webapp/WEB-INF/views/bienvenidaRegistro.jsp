<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">	
	<meta name="description" content="">
	<meta name="author" content="">	
	<title>Registro Correcto</title>
	<spring:url value="/resources" var="urlPublic" />
	<spring:url value="/" var="urlRoot" />
		
	<link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">	
	<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
	<link href="${urlPublic}/bootstrap/css/signin.css" rel="stylesheet">
	
	</head>

    <body>
	<div class="container theme-showcase" role="main">

		<hr class="featurette-divider">
		
        <table>

            <tr>

                <td>Bienvenido ${nombre}, ahora debes esperar la activacion de tu cuenta en poco tiempo.</td>

            </tr>

            <tr>

            </tr>

            <tr>

            </tr>

            <tr>

                <td><a href="${urlRoot}">Home</a>

                </td>

            </tr>

        </table>

    </body>

    </html>