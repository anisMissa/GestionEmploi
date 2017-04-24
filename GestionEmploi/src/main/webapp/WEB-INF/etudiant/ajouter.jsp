<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/header.jsp"%>
<%@ include file="/WEB-INF/sidebar.jsp"%>
<div id="page-content-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12">
				<h1>Ajouter un étudiant</h1>
				<form  class="form-horizontal" method="POST" action="/etudiant/add">
					<div class="form-group">
						<label class="control-label col-sm-2">Nom</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" name="nom"/>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">Prenom</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" name="prenom"/>
						</div>
					</div>
					<div class="form-group">
					<label class="control-label col-sm-2">Section</label>
					<div class="col-sm-8">
					<select name="idSection" class="form-control">
					
					<c:forEach var="section" items="${sections}">
						<option value="${section.idSection}">
							${section.niveauSection} ${section.nomSection} ${section.numGroupe}
						</option>
						</c:forEach>
					</select>
					</div>
					</div>
					<div class="form-group">
					<label class="control-label col-sm-2">Adresse</label>
					<div class="col-sm-8">
					<input class="form-control" type="text" name="address"/>
					</div>
					</div>
					<div class="form-group">
					<label class="control-label col-sm-2">Téléphone</label>
					<div class="col-sm-8">
					<input class="form-control" type="text" name="telephone"/>
					</div>
					</div>
					<div class="form-group">
					<label class="control-label col-sm-2">Adresse Mail</label>
					<div class="col-sm-8">
					<input class="form-control" type="text" name="email"/>
					</div>
					</div>
					<div class="form-group">
					<label class="control-label col-sm-2">Mot de passe</label>
					<div class="col-sm-8">
					<input class="form-control" type="password" name="password"/>
					</div>
					</div>
					<div class="col-sm-offset-9 col-sm-3">
					<button class="btn btn-success" type="submit">Ajouter</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/footer.jsp"%>