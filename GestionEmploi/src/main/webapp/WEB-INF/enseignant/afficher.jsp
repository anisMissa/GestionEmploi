<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/header.jsp"%>
<%@ include file="/WEB-INF/sidebar.jsp"%>
<div id="page-content-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1>Liste des enseignants</h1>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>#</th>
							<th>Nom</th>
							<th>Prénom</th>
							<th>Adresse</th>
							<th>Téléphone</th>
							<th>Specialite</th>
							<th>Grade</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="enseignant" items="${enseignants}">
							<tr>
								<th scope="row">${enseignant.idUser}</th>
								<td>${enseignant.nom}</td>
								<td>${enseignant.prenom}</td>
								<td>${enseignant.address}</td>
								<td>${enseignant.telephone}</td>
								<td>${enseignant.specialite}</td>
								<td>${enseignant.grade}</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/footer.jsp"%>