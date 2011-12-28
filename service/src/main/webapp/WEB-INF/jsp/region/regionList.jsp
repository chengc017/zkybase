<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
	<c:choose>
		<c:when test="${empty regionList}">
			<p>No regions.</p>
		</c:when>
		<c:otherwise>
			<table class="bordered-table zebra-striped sortable">
				<thead>
					<tr>
						<th>Name</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="region" items="${regionList}">
						<c:url var="regionUrl" value="/regions/${region.id}" />
						<tr>
							<td><a href="${regionUrl}"><c:out value="${region.name}" /></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
</div>