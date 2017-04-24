<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/header.jsp"%>
<%@ include file="/WEB-INF/sidebar.jsp"%>
<div id="page-content-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12 col-sm-offset-1 col-sm-9">
				<h1>Liste des matières</h1>
				<c:if test="${err != ''}">
					<div class="alert alert-danger" role="alert">
					  <strong>Une erreur s'est produite!</strong> ${err}
					</div>
				</c:if>
				
				<c:if test="${success == true}">
				<div class="alert alert-success" role="alert">
				    <strong>Succès!</strong> Matière ajoutée avec succès
				</div>
				</c:if>
				
				<table class="table table-striped">
					<thead>
						<tr>
							<th>#</th>
							<th>Nom matiere</th>
							<th>Spécialité</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="matiere" items="${matieres}">
							<tr>
								<td>${matiere.idMatiere}</td>
								<td>${matiere.nomMatiere}</td>
								<td>${matiere.specialite}</td>
								<td></td>
							</tr>
						</c:forEach>
							<tr>
								<form  class="form-horizontal" method="POST">
									<td colspan="2"><input class="form-control" type="text" name="nomMatiere" placeholder="Nom de la matière"></td>
									<td><input class="form-control" type="text" name="specialite" placeholder="Spécialité de la matière"></td>
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