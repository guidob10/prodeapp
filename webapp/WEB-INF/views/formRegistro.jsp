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
	<title>ProdeApp | Registro</title>
	<spring:url value="/resources" var="urlPublic" />	 
		
	<link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">	
	<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
	<link href="${urlPublic}/bootstrap/css/signin.css" rel="stylesheet">
	
	</head>

<body>
 	<jsp:include page="includes/menu.jsp"></jsp:include>	
	<div class="container theme-showcase" role="main">

		<hr class="featurette-divider">
		
	   <img src="${urlPublic}/images/login.png" width="136" height="136" class="center">
	   
            <div id="cuerpo" align="center">
 
				<form id="formulario" action="registroProceso" method="post" commandName="userForm" class="form-signin">                
                    <p><label for="nombre">Nombre:</label></p>
                        <input name="nombre" type="text" id="nombre" class="form-signin-heading required" placeholder="Pon tu nombre" autofocus=""/ ></p>
 
                    <!--=============================================================================================-->
                    <!--La sisguientes 2 líneas son para agregar campos al formulario con sus respectivos labels-->
                    <!--Puedes usar tantas como necesites-->
                    <p><label for="apellidos">Apellidos:</label></p>
                        <input name="apellidos" type="text" id="apellidos" class="form-signin-heading required" placeholder="Pon tus apellidos" /></p>
                    <!--=============================================================================================-->
 
                    <p><label for="correo">Correo:</label></p>
                        <input name="email" type="text" id="email" class="form-signin-heading required email" placeholder="Pon tu mail" /></p>
                        
                    <p><label for="nombredeusuario">Nombre de Usuario:</label></p>
                        <input name="username" type="text" id="username" class="form-signin-heading password" placeholder="Pon tu usuario" /></p>
   
                    <p><label for="password">Password:</label></p>
                        <input name="password" type="password" id="password" class="form-signin-heading" placeholder="Pon tu contraseña"/ ></p>
 
                    <p><label for="repass">Repetir Password:</label></p>
                        <input name="repass" type="password" id="repass" class="form-signin-heading" placeholder="Repite contraseña" /></p>
 
                    <p id="bot"><input name="submit" type="submit" id="boton" value="Registrar" class="boton"/></p>
                </form>
            </div>   
	</div> <!-- /container -->
	<jsp:include page="includes/footer.jsp"></jsp:include>	
	      	
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!--<script type="text/javascript" src="http://jzaefferer.github.com/jquery-validation/jquery.validate.js"></script>-->
	<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>	
	<script src="${urlPublic}/bootstrap/js/bootstrap.min.js" ></script>
    <script type="text/javascript">
    function validarFormulario(){
    	   jQuery.validator.messages.required = 'Esta campo es obligatorio.';
    	   jQuery.validator.messages.number = 'Esta campo debe ser num&eacute;rico.';
    	   jQuery.validator.messages.email = 'La direcci&oacute;n de correo es incorrecta.';  	   
    	  // $("#formulario").validate(); este es default
             $("#formulario").validate({
               rules: {
                   password: { 
                     required: true,
                     minlength: 8
                   } , 
                       repass: { 
                        equalTo: "#password"
                   }
               },
               messages: {
                   password: {
                       required: "Este campo es obligatorio.",
                       minlength: "Debe ser un password mas seguro (8 car)."
                   },
                   confirmpassword: {
                       equalTo: "El password debe coincidir."
                   }
               }
           });   
    	}
    
       $(document).ready(function(){
          validarFormulario();
       });
    </script>
 	
</body>
    <style type="text/css">
       .error {color: #f00;}
    </style>   
</html>