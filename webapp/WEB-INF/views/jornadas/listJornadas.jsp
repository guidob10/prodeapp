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
	<title>Listado de Jornadas</title>
	<spring:url value="/resources" var="urlPublic" />
	<spring:url value="/jornadas" var="urlJornadas" />
	<spring:url value="/apuestas" var="urlApuestas" />
	
	<link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">	
	<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
	
	</head>

<body>

	<jsp:include page="../includes/menu.jsp"></jsp:include>
	<!--  crea fecha del dia -->
	<jsp:useBean id="date" class="java.util.Date" />
	
	<div class="container theme-showcase" role="main">

		<h3>Listado de Jornadas</h3>
      
        <c:if test="${msg !=null }">        
        		<div class='alert alert-success' role='alert'>${msg}</div>
        </c:if>	
                             
        <a href="${urlJornadas}/create" class="btn btn-success" role="button" title="Nuevo Banner" >Nuevo</a><br><br>     
                                 
        <!--   <a href="${urlJornadas}/create" class="btn btn-success" role="button" title="Nueva Pelicula" >Nueva</a><br><br>  -->       
      
        <div class="table-responsive">
	        <table class="table table-hover table-striped table-bordered">
	          <tr>
	              <th>Numero Jornada</th>
	              <th>Fecha Inicio </th>
	              <th>Fecha Fin </th>
	              <th>Apuesta</th>	         
	              
	          </tr>
	
				<c:forEach var="jornada" items="${jornadas.content}">
					<tr>
						<td>${jornada.numeroJornada}</td>
						<td><fmt:formatDate pattern="dd-MM-yyyy"
								value="${jornada.fechaInicio}" /></td>
						<td><fmt:formatDate pattern="dd-MM-yyyy"
								value="${jornada.fechaFin}" /></td>	
													
						<!-- 	<td><span class="label label-success"> </span></td>
								<td><span class="label label-danger"> </span></td> -->
								
						<td>
						<c:choose>
							<c:when test="${jornada.fechaFin gt date}">
    							<a href="${urlApuestas}/edit/${jornada.id}" class="btn btn-success btn-sm" role="button" title="Apostar Fecha"><span class="glyphicon glyphicon-pencil"></span></a>	
    						</c:when>
    						<c:otherwise>
    							<p><b><span class="wrap">Fecha Finalizada</span></b></p>    						
    						</c:otherwise>
						</c:choose>					
						</td>
						<c:choose>
							<c:when test="${usuario.hasRole('editor')}">
							<td>
								<a href="${urlJornadas}/edit/${jornada.id}" class="btn btn-success btn-sm" role="button" title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>
								<a href="${urlJornadas}/delete/${jornada.id}" onclick='return confirm("�Estas seguro?")' class="btn btn-danger btn-sm" role="button" title="Eliminar"><span class="glyphicon glyphicon-trash"></span></a>
							</td>
							</c:when>
						</c:choose>	
					</tr>
				</c:forEach>
			</table>
		</div>
		
		<nav aria-label="">
		  <ul class="pager">
		    <li><a href="${urlJornadas}/indexPaginate?page=${jornadas.number - 1 }">Anterior</a></li>
		    <li><a href="${urlJornadas}/indexPaginate?page=${jornadas.number + 1 }">Siguiente</a></li>
		  </ul>
		</nav>

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