<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/header.jsp"%>
<%@ include file="/WEB-INF/sidebar.jsp"%>
<div id="page-content-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12 col-sm-offset-1 col-sm-9">
				<h1>Liste des sections</h1>
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
							<th>Niveau</th>
							<th>Nom section</th>
							<th>Groupe</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="section" items="${sections}">
							<tr>
								<td>${section.niveauSection}</td>
								<td>${section.nomSection}</td>
								<td>${section.numGroupe}</td>
								<td></td>
							</tr>
						</c:forEach>
							<tr>
								<form  class="form-horizontal" method="POST">
									<td>
										<select class="form-control" name="niveauSection">
											<option value="" selected disabled>---</option>
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
											<option value="6">6</option>
										</select>
									</td>
									<td><input class="form-control" type="text" name="nomSection" placeholder="Nom de la section"></td>
									<td><input class="form-control" type="number" name="numGroupe" placeholder="Numero groupe"></td>
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