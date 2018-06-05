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
	<title>Creacion de Jornadas</title>
	<spring:url value="/resources" var="urlPublic" />
	<spring:url value="/jornadas/save" var="urlForm" />
	
	<link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">	
	<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	
	</head>

<body>

	<jsp:include page="../includes/menu.jsp"></jsp:include>
	
	<div class="container theme-showcase" role="main">

		<div class="page-header">
          <h3 class="blog-title"><span class="label label-success">Datos de la Jornada</span></h3>
      </div>

		<spring:hasBindErrors name="jornada">
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
	 
      <form:form action="${urlForm}" method="POST"   modelAttribute="jornada" >
      
		<div class="row"> 
          <div class="col-sm-3">
            <div class="form-group">
              <label for="local" class="control-label">Id</label>        
              <form:hidden path="id"/>      
              <form:input type="text" class="form-control" path="id" id="id" required="required"  disabled="true"/>             
            </div>            
          </div>
        </div>
              
		<div class="row"> 
          <div class="col-sm-3">
            <div class="form-group">
              <label for="local" class="control-label">Numero Jornada</label>              
              <form:input type="text" class="form-control" path="numeroJornada" id="numeroJornada" required="required"/>             
            </div>            
          </div>
        </div>
            
        <div class="row">               
          <div class="col-sm-3">
            <div class="form-group">
              <label for="fechaEstreno">Fecha Inicio</label>             
              <form:input type="text" class="form-control" path="fechaInicio" id="fechaInicio" required="required"  />
            </div>  
          </div>		

          <div class="col-sm-3">
            <div class="form-group">
              <label for="fechaFin">Fecha Fin</label>             
              <form:input type="text" class="form-control" path="fechaFin" id="fechaFin" required="required"  />
            </div>  
          </div>	          	 			           
        </div>
        
        <div class="page-header">
          <h3 class="blog-title"><span class="label label-success">Detalles de Jornada</span></h3>
        </div>
        

        <button type="submit" class="btn btn-danger" >Guardar</button>
      </form:form> 

		<hr class="featurette-divider">

      <jsp:include page="../includes/footer.jsp"></jsp:include>		
	</div> 

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
   <script>
      $(function () {
         $("#fechaInicio").datepicker({dateFormat: 'dd-mm-yy'});
      }
      );
      $(function () {
          $("#fechaFin").datepicker({dateFormat: 'dd-mm-yy'});
       }
       );            
   </script>
</body>
</html>