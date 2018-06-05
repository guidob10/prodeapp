<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>Creacion de Usuarios</title>
	<spring:url value="/resources" var="urlPublic" />
	<spring:url value="/usuarios/save" var="urlForm" />
	
	<link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">	
	<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	
	</head>

<body>

	<!--  da error el menu, debe ser porque recupera el usuario, y no tiene rol..., o porque se llama varaible usuario, como en jsp -->
	 <jsp:include page="../includes/menu.jsp"></jsp:include>
	 
	 <!--agregar combo rol/perfil -->
		
	<div class="container theme-showcase" role="main">

		<div class="page-header">
          <h3 class="blog-title"><span class="label label-success">Datos de Usuario</span></h3>
      </div>

		<spring:hasBindErrors name="usuario">
			<div class='alert alert-danger' role='alert'>
			Por favor corrija los siguientes errores:
				<ul>
					<c:forEach var="error" items="${errors.allErrors}">
						<li><spring:message message="${error}" /></li>
					</c:forEach>
				</ul>
				<!-- 
				<form:errors path="pelicula.*" cssClass="error" />
				-->
			</div>
		</spring:hasBindErrors>

      <form:form action="${urlForm}" method="POST" modelAttribute="usuarioform" >
          		 	
        <div class="row">
          <div class="col-sm-3">
            <div class="form-group">
              <!--  <img class="img-rounded" src="${urlPublic}/images/${pelicula.imagen}" title="${pelicula.titulo}" width="150" height="200"> -->
            </div>  
          </div>
        </div>
        
        <!-- Inician los inputs del form -->
        <div class="row">
          <div class="col-sm-3">
            <div class="form-group">
              <label for="titulo">Nombre</label>
              <form:hidden class="form-control" path="id"/>             
              <form:input type="text" class="form-control" path="nombre" id="nombre" required="required" />
            </div>  
          </div>
          <div class="col-sm-3">
            <div class="form-group">
              <label for="duracion">Email</label>
              <form:input type="text" class="form-control" path="email" id="email" required="required"/>
            </div>  
          </div>
          <div class="col-sm-3">
            <div class="form-group">
              <label for="genero" class="control-label">Usuario</label>              
               <form:input type="text" class="form-control" path="username" id="username" required="required" />          
            </div> 
          </div>         
        </div>

        <div class="row">
                  
          <div class="col-sm-3">
            <div class="form-group">
              <label for="password">Constrasena</label>             
              <form:input type="text" class="form-control" path="password" id="password" required="required"  />
            </div>  
          </div>	
          <!--  .. recuperar perfiles hardcodeados, e insertar en tabla de perfil -->
          <div class="col-sm-3">
            <div class="form-group">
              <label for="jornada" class="control-label">Rol</label>                                           
				<form:select id="perfil" path="perfil" itemValue="perfil" itemLabel="perfil" class="form-control" items="${roles}"/>                           
            </div> 
          </div>            		 			
         
        </div>
        
  
        <button type="submit" class="btn btn-danger" >Guardar</button>
      </form:form> 

		<hr class="featurette-divider">

      <jsp:include page="../includes/footer.jsp"></jsp:include>		

	</div> <!-- /container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

</body>
</html>