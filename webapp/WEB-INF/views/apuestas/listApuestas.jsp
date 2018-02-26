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
	<spring:url value="/apuestas/save" var="urlForm" />	
	<spring:url value="/apuestas/savee" var="urlForme" />	
	
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
      
      	<form:form action="${urlForm}" method="POST"   modelAttribute="apuestaForm"  >
        <div class="table-responsive">
	        <table class="table table-hover table-striped table-bordered">
	          <tr>
	              <th>Id</th>
	              <th>Fecha Inicio </th>
	              <th>Local</th>
	              <th>Visita</th>
	              <th>Ganador</th>
	          </tr>
		
			  <c:forEach varStatus="us" var="apuesta" items="${apuestaForm.apuestas}" >
					<tr>
						<td>${apuesta.id}</td>
						<td><fmt:formatDate pattern="dd-MM-yyyy"
								value="${apuesta.partido.fechaPartido}" /></td>
						<td>${apuesta.partido.local.nombreClub} 
        				</td>
						<td>${apuesta.partido.visita.nombreClub}   				         					    						
        				</td>	
						<td>					 							   					              				
	                 		<form:radiobutton path="apuestas[${us.index}].ganador" value="0"/> Local
	                 		<form:radiobutton path="apuestas[${us.index}].ganador" value="1"/> Visita              								       
						</td>
						<form:input type="hidden"  path="apuestas[${us.index}].id"/>
						<form:input type="hidden"  path="apuestas[${us.index}].partido.id"/>	
						<form:input type="hidden" path="apuestas[${us.index}].usuario.id" value="1"  />											
					</tr>	
				</c:forEach>			
			</table>
		</div>	
    	<button type="submit" class="btn btn-danger" >Guardar</button>	
    	<input type="hidden"name="${_csrf.parameterName}" value="${_csrf.token}"/>
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