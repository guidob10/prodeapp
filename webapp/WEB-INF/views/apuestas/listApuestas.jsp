<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">	
	<meta name="description" content="">
	<meta name="author" content="">		
	<title>Listado de Partidos por Jornada</title>
	<spring:url value="/resources" var="urlPublic" />
	<spring:url value="/jornadas" var="urlJornadas" />
	<spring:url value="/apuestas" var="urlApuestas" />
	<spring:url value="/apuestas/save" var="urlForm" />	
	
	<link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">	
	<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
	
	</head>

<body>

	<jsp:include page="../includes/menu.jsp"></jsp:include>
	
	<div class="container theme-showcase" role="main">

		<h3>Listado de Partidos</h3>
      
        <c:if test="${msg !=null }">        
        		<div class='alert alert-success' role='alert'>${msg}</div>
        </c:if>	                            
      
      	<form:form action="${urlForm}" method="POST" enctype="multipart/form-data"  modelAttribute="ApuestaForm" >
      	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div class="table-responsive">
	        <table class="table table-hover table-striped table-bordered">
	          <tr>
	              <th>Id</th>
	              <th>Fecha Inicio </th>
	              <th>Local</th>
	              <th>Visita</th>
	              <th>Apuesta</th>
	          </tr>
		
			  <c:forEach var="partido" items="${partidos}">
					<tr>
						<td>${partido.id}</td>
						<td><fmt:formatDate pattern="dd-MM-yyyy"
								value="${partido.fechaPartido}" /></td>
						<td>${partido.local.nombreClub} 
						        <label>
            						<input type="radio" name="ganador${partido.id}" value="azul"> 
        						</label>
        				</td>
						<td>${partido.visita.nombreClub}
						        <label>
            						<input type="radio" name="ganador${partido.id}" value="azul"> 
        						</label>
        				</td>
	
						<td>
							<a href="1/edit/1" class="btn btn-success btn-sm" role="button" title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>
							<a href="2/delete/2" onclick='return confirm("¿Estas seguro?")' class="btn btn-danger btn-sm" role="button" title="Eliminar"><span class="glyphicon glyphicon-trash"></span></a>
						</td>
					</tr>
				</c:forEach>
			
			</table>
		</div>	
    	<button type="submit" class="btn btn-danger" >Guardar</button>	
      	</form:form> 	
       	
		
		<!-- pag
		<nav aria-label="">
		  <ul class="pager">
		    <li><a href="">Anterior</a></li>
		    <li><a href="">Siguiente</a></li>
		  </ul>
		</nav>
 		--> 
      <hr class="featurette-divider">

      <jsp:include page="../includes/footer.jsp"></jsp:include>		

	</div> <!-- /container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>