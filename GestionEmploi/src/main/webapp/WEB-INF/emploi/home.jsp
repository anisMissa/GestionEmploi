<script type="text/javascript">
 function getEmploi(s) {
	 $.ajax({
			url: '/seance/get/' + s,
			type: 'GET'
		})
		.done(function(x) {
			  $("#emploi").html(x);
		})
		.fail(function() {
			console.log("error");
		})
 }
</script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/header.jsp"%>
<%@ include file="/WEB-INF/sidebar.jsp"%>
<div id="page-content-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12">
				<h1>Emplois du temps</h1>
				<form class="form-horizontal">
					<div class="form-group">
						<label class="control-label col-sm-1">Section</label>
						<div class="col-sm-4">
							<select name="idSection" id="idSec" class="form-control" onchange="getEmploi(this.value)">
								<option value="-1" selected disabled>Séléctionner une section</option>
								<c:forEach var="section" items="${sections}">
									<option value="${section.idSection}">
										${section.niveauSection} ${section.nomSection}
										Groupe N°${section.numGroupe}</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</form>
				<div id="emploi"></div>
			</div>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/footer.jsp"%>