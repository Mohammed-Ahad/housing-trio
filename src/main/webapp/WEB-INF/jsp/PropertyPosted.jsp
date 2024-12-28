<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>

<jsp:include page="CommonLinks.jsp" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/property-posted.css">

</head>
<body>

	<jsp:include page="CommonHeader.jsp" />

	<main>

		<h2 class="title">Properties For Sale</h2>

		<div class="cards">
			<c:if test="${empty propertyPosted}">
				<span class="no-property">No Property Listed for now</span>
			</c:if>
			<c:forEach items="${propertyPosted}" var="property">
				<div class="card">

					<div class="card-body">
						<div class="left">
							<div class="content">
								<a target="_blank"
									href="${pageContext.request.contextPath}/property-details/${property.id}"><img
									alt="property-img" width="18"
									src="${pageContext.request.contextPath}/img/redirect.svg"></a>
								<h3>${property.propertyDetails.bhkType} in
									${property.apartmentName}</h3>
								<div class="details">
									<span class="price"> <span class="mute">Price:</span>
										&#8377; ${property.priceDetails.expectedPrice} lakhs
									</span> <span class="place semi-bold">Bangalore</span>
								</div>
							</div>

						</div>

						<div class="right">
							<div class="image">
								<img alt="property-img"
									src="${pageContext.request.contextPath}/img/img-not-found.png">
							</div>
						</div>
					</div>

					<div class="card-footer">
						<a href="#" class="primary-btn"
							onclick="contactOwner(${property.id})">Contact Owner</a>
					</div>
				</div>
			</c:forEach>
		</div>
	</main>

	<jsp:include page="CommonScripts.jsp" />
</body>
</html>