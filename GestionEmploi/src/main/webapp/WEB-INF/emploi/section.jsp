<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	function addSeance(idHorraire, jour) {
		if (idHorraire == 4) {
			idHorraire = 3;
		}
		switch (idHorraire) {
		case 1:
			heureSeance = " de 8:45 à 10:45";
			break;

		case 2:
			heureSeance = " de 11:00 à 13:00";
			break;

		case 3:
			heureSeance = " de 14:15 à 16:15";
			break;

		default:
			break;
		}
		$('#timeSeance').html("Séance du " + jour + heureSeance);
		$('#idHorraire').val(idHorraire);
		let s = $('#idSec').find(":selected").val();
		$('#idSection').val(s);
		$('#jour').val(jour);
		$.ajax({
			url: '/seance/availableEnseignant/' + jour + '/' + idHorraire,
			type: 'GET'
		})
		.done(function(x) {
			  $("#enseignants-list").html(x);
		})
		.fail(function() {
			console.log("error");
		})
		$.ajax({
			url: '/seance/availableMatiere',
			type: 'GET'
		})
		.done(function(x) {
			  $("#matieres-list").html(x);
		})
		.fail(function() {
			console.log("error");
		})
		
		$.ajax({
			url: '/seance/findSalleLibre/' + jour + '/' + idHorraire,
			type: 'GET'
		})
		.done(function(x) {
			  $("#salles-list").html(x);
		})
		.fail(function() {
			console.log("error");
		})
	}
</script>
<div class="table-responsive">
	<table class="table table-bordered text-center emploi">
		<thead>
			<tr>
				<th>#</th>
				<th class="text-center">8:45 - 10:45</th>
				<th class="text-center">11:00 - 13:00</th>
				<th class="text-center">Pause</th>
				<th class="text-center">14:15 - 16:15</th>
			</tr>
		</thead>
		<tbody>
				<tr>
					<th scope="row">LUNDI</th>
					<c:forEach var="seance" items="${lundi}" varStatus="loop">
						<td <c:if test="${seance != null}">style="cursor:no-drop;"</c:if><c:if test="${seance == null && loop.index!= 2}">data-toggle="modal" data-target="#myModal7" style="cursor:crosshair;" onclick="addSeance(${loop.index+1 },'LUNDI')"</c:if>">
							<c:if test="${seance != null}">
								<div>${seance.matiere.nomMatiere}</div>
								<div>
									<span class="pull-left">${seance.enseignant.prenom}
										${seance.enseignant.nom}</span> <span class="pull-right">${seance.salle.blocSalle}${seance.salle.nomSalle}</span>
								</div>
							</c:if>
						</td>
					</c:forEach>
				</tr>
	
				<tr>
					<th scope="row">MARDI</th>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
	
				<tr>
					<th scope="row">MERCREDI</th>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
	
				<tr>
					<th scope="row">JEUDI</th>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
	
				<tr>
					<th scope="row">VENDREDI</th>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
	
				<tr>
				<th scope="row">SAMEDI</th>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</div>

<!-- Modal -->
<div class="modal fade" id="myModal7" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel3" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<!-- Modal Header -->
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">
					<div id="timeSeance">...</div>
				</h4>
			</div>

			<!-- Modal Body -->
			<div class="modal-body">

				<form class="form-horizontal" role="form" action="/seance/add" method="Post">
					<input type="hidden" id='idHorraire' name='horraire.idHorraire'>
					<input type="hidden" id="idSection" name="section.idSection">
					<input type="hidden" id="jour" name="jour">
					<div class="form-group">
						<label class="col-sm-2 control-label">Enseignant</label>
						<div class="col-sm-10">
							<div id="enseignants-list"></div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Matière</label>
						<div class="col-sm-10">
							<div id="matieres-list"></div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Salle</label>
						<div class="col-sm-10">
							<div id="salles-list"></div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-primary">Sauvegarder</button>
							<button type="reset" class="btn btn-default">Annuler</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>