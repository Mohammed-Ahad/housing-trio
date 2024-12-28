<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<jsp:include page="CommonLinks.jsp" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/approve-properties.css">
</head>
<body>

	<jsp:include page="AdminHeader.jsp" />

	<main class="space-y-6">
		<div class="table-conatainer processing">
			<h2 class="title">Properties Posted</h2>
			<table id="postedPropertiesTable">
				<thead>
					<tr>
						<th>View</th>
						<th>Name</th>
						<th>Email</th>
						<th>Phone</th>
						<th>Apartment Name</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="property" items="${newPoperties}">
						<tr>
							<td><a target="_blank"
								href="${pageContext.request.contextPath}/property-details/${property.id}"><img
									alt="property-img" width="18"
									src="${pageContext.request.contextPath}/img/redirect.svg"></a></td>
							<td>${property.userDetails.fullName}</td>
							<td>${property.userDetails.emailAddress}</td>
							<td>${property.userDetails.phoneNo}</td>
							<td>${property.apartmentName}</td>
							<td class="action-btns"><a href="#" class="primary-btn"
								onclick="approveProperty(${property.id})">Approve</a> <a
								href="#" class="secondary-btn"
								onclick="cancelProperty(${property.id})">Calcel</a></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
		
		
		<div class="table-conatainer processing">
			<h2 class="title">Listed Properties</h2>
			<table id="listedPropertiesTable">
				<thead>
					<tr>
						<th>View</th>
						<th>Name</th>
						<th>Email</th>
						<th>Phone</th>
						<th>Apartment Name</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="property" items="${listedPoperties}">
						<tr>
							<td><a target="_blank"
								href="${pageContext.request.contextPath}/property-details/${property.id}"><img
									alt="property-img" width="18"
									src="${pageContext.request.contextPath}/img/redirect.svg"></a></td>
							<td>${property.userDetails.fullName}</td>
							<td>${property.userDetails.emailAddress}</td>
							<td>${property.userDetails.phoneNo}</td>
							<td>${property.apartmentName}</td>
					</c:forEach>

				</tbody>
			</table>
		</div>

		<div class="table-conatainer processing">
			<h2 class="title">Contact Owner Info</h2>
			<table id="contactOwnerTable">
				<thead>
					<tr>
						<th>View</th>
						<th>Name</th>
						<th>Email</th>
						<th>Phone</th>
						<th>Apartment Name</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="property" items="${contactOwners}">
						<tr>
							<td><a target="_blank"
								href="${pageContext.request.contextPath}/property-details/${property.id}"><img
									alt="property-img" width="18"
									src="${pageContext.request.contextPath}/img/redirect.svg"></a></td>
							<td>${property.userDetails.fullName}</td>
							<td>${property.userDetails.emailAddress}</td>
							<td>${property.userDetails.phoneNo}</td>
							<td>${property.property.apartmentName}</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>

		</div>

	</main>

	<jsp:include page="CommonScripts.jsp" />

	<script
		src="${pageContext.request.contextPath}/js/approve-properties.js"></script>
</body>
</html>