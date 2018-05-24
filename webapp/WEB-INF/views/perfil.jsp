<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">	
	<meta name="description" content="">
	<meta name="author" content="">	
	<title>ProdeApp | Bienvenido</title>
	<spring:url value="/resources" var="urlPublic" />
		
	<link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">	
	<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
	
	</head>

<body>

	<jsp:include page="includes/menu.jsp"></jsp:include>
	
	<div class="container theme-showcase" role="main">

		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">PERFIL</h3>
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-sm-3">
						<p class="text-center">
							
						</p>
					</div>
					<div class="col-sm-3">
				
							<div class="panel-heading">
								<h3 class="panel-title">Nombre: ${nombre}   </h3>
								<h3 class="panel-title">Email: ${email}   </h3>
							</div>
							<div class="panel-body">
								
							<%  
        						out.println("<b>Videos: </b><p>");        					         					  
        					%>
          					 <iframe width="560" height="315" src="https://www.youtube.com/embed/f845_v41YFo" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
        					<%        
        						out.println("<br>" + "<br>");
							%> 
							</div>
					</div>
				</div>
			</div>
		</div>

	    <jsp:include page="includes/footer.jsp"></jsp:include> 	

	</div> <!-- /container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>