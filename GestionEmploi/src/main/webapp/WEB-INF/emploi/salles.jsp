<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<select class="form-control" name="salle.idSalle">
	<option value="" selected disabled>---</option>
	<c:forEach var="salle" items="${salles}">
		<option value="${salle.idSalle}">${salle.blocSalle}${salle.nomSalle}</option>
	</c:forEach>
</select>