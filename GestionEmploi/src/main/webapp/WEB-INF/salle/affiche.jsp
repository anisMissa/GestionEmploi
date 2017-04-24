<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/header.jsp"%>
<%@ include file="/WEB-INF/sidebar.jsp"%>
<div id="page-content-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12 col-sm-offset-1 col-sm-9">
				<h1>Liste des salles</h1>
				<c:if test="${err != ''}">
					<div class="alert alert-danger" role="alert">
					  <strong>Une erreur s'est produite!</strong> ${err}
					</div>
				</c:if>
				
				<c:if test="${success == true}">
				<div class="alert alert-success" role="alert">
				    <strong>Succès!</strong> Salle ajoutée avec succès
				</div>
				</c:if>
				
				<table class="table table-striped">
					<thead>
						<tr>
							<th>#</th>
							<th>Nom salle</th>
							<th>Bloc</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="salle" items="${salles}">
							<tr>
								<th scope="row">${salle.idSalle}</th>
								<td>${salle.nomSalle}</td>
								<td>${salle.blocSalle}</td>
								<td></td>
							</tr>
						</c:forEach>
							<tr>
								<form  class="form-horizontal" method="POST">
									
									<td colspan="2"><input type="text" class="form-control" name="nomSalle" placeholder="Nom de la salle"/></td>
									<td>
										<select class="form-control" name="blocSalle">
											<option value="" selected disabled>---</option>
											<option value="A">Bloc A</option>
											<option value="B">Bloc B</option>
											<option value="C">Bloc C</option>
											<option value="D">Bloc D</option>
										</select>
									</td>
									<td><button class="btn btn-success btn-block">Ajouter</button></td>
								</form>
							</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/footer.jsp"%>