<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/header.jsp"%>
<%@ include file="/WEB-INF/sidebar.jsp"%>
<div id="page-content-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1>Liste des étudiants</h1>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>#</th>
							<th>Nom</th>
							<th>Prénom</th>
							<th>Section</th>
							<th>Adresse</th>
							<th>Téléphone</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="etudiant" items="${etudiants}">
							<tr>
								<th scope="row">${etudiant.idUser}</th>
								<td>${etudiant.nom}</td>
								<td>${etudiant.prenom}</td>
								<td>${etudiant.section.niveauSection} ${etudiant.section.nomSection}   G${etudiant.section.numGroupe}</td>
								<td>${etudiant.address}</td>
								<td>${etudiant.telephone}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/footer.jsp"%>