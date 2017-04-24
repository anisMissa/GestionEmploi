<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<select class="form-control" name="enseignant.idUser">
	<option value="" selected disabled>---</option>
	<c:forEach var="ens" items="${enseignants}">
		<option value="${ens.idUser}">${ens.nom} ${ens.prenom}</option>
	</c:forEach>
</select>