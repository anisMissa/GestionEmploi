<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<select class="form-control" name="matiere.idMatiere">
	<option value="" selected disabled>---</option>
	<c:forEach var="mat" items="${matieres}">
		<option value="${mat.idMatiere}">${mat.nomMatiere}</option>
	</c:forEach>
</select>