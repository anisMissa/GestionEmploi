<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/header.jsp"%>
<%@ include file="/WEB-INF/sidebar.jsp"%>
<div id="page-content-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12">
				<h1>Ajouter un enseignant</h1>
				<form  class="form-horizontal" method="POST">
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
						<label class="control-label col-sm-2">Spécialité</label>
						<div class="col-sm-8">
							<select name="specialite" class="form-control">
								<option value="mecanique">
									mecanique
								</option>
								<option value="informatique de gestion">
									informatique de gestion
								</option>
								<option value="telecom et reseau">
									télécom et reseau
								</option>
								
								<option value="informatique">
									informatique
								</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">Grade</label>
						<div class="col-sm-8">
							<select name="grade" class="form-control">
								<option value="assistant">
									assistant
								</option>
								<option value="maitre assistant">
									maitre assistant
								</option>
								<option value="maitre de conference">
									maitre de conference
								</option>
								
								<option value="professeur">
									professeur
								</option>
							</select>
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