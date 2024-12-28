<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<jsp:include page="CommonLinks.jsp"></jsp:include>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/property-details.css">


</head>
<body>

	<jsp:include page="CommonHeader.jsp" />

	<main>
		<div>
			<h1 class="title">${property.propertyDetails.bhkType} in
				${property.apartmentName}</h1>
			<div class="property-images">

				<img alt="property-img"
					src="${pageContext.request.contextPath}/img/img-not-found.png">

			</div>
		</div>

		<div class="property-details">


			<!-- Resale Details -->
			<div class="card">

				<div class="head">
					<h3>RESALE DETAILS</h3>
				</div>

				<div class="body">

					<div>

						<div class="left">
							<span class="mute fs-sm">Price</span> <span>&#8377;
								${property.priceDetails.expectedPrice} lakhs</span> <span
								class="primary-color semi-bold">Negotiable</span>
						</div>
						<div class="right">
							<span class="mute fs-sm">Area</span> <span>${property.propertyDetails.buildUpArea }
								Sq.Ft</span>
						</div>
					</div>
				</div>
			</div>


			<!-- OverView -->
			<div class="card">

				<div class="head">
					<h3>OVERVIEW</h3>
				</div>

				<div class="body">
					<div>
						<div class="left">
							<ul>
								<li><img alt="property-icon.png"
									src="${pageContext.request.contextPath}/icons/property-icon.png">
									<div>
										<span class="mute fs-sm">Property Type</span> <span>NA</span>
									</div></li>


								<li><img alt="owner-icon.png"
									src="${pageContext.request.contextPath}/icons/owner-icon.png">
									<div>
										<span class="mute fs-sm">Ownership Type</span> <span>${property.ownershipType}</span>
									</div></li>


								<li><img alt="furnitire-icon.png"
									src="${pageContext.request.contextPath}/icons/furniture-icon.png">
									<div>
										<span class="mute fs-sm">Furnishing</span> <span>${property.priceDetails.furnishing}</span>
									</div></li>

								<li><img alt="posted-icon.png"
									src="${pageContext.request.contextPath}/icons/posted-icon.png">
									<div>
										<span class="mute fs-sm">Posted On</span> <span>${property.createDate}</span>
									</div></li>

							</ul>
						</div>
						<div class="right">
							<ul>
								<li><img alt="parking-icon.png"
									src="${pageContext.request.contextPath}/icons/parking-icon.png">
									<div>
										<span class="mute fs-sm">Parking</span> <span>${property.priceDetails.parking}</span>
									</div></li>


								<li><img alt="floor-icon.png"
									src="${pageContext.request.contextPath}/icons/floor-icon.png">
									<div>
										<span class="mute fs-sm">Floor</span> <span>${property.propertyDetails.floor}</span>
									</div></li>


								<li><img alt="age-icon.png"
									src="${pageContext.request.contextPath}/icons/age-icon.png">
									<div>
										<span class="mute fs-sm">Age of property</span> <span>${property.propertyDetails.propertyAge}
											years</span>
									</div></li>

								<li><img alt="calendar-icon.png"
									src="${pageContext.request.contextPath}/icons/calendar-icon.png">
									<div>
										<span class="mute fs-sm">Available from</span> <span>${property.priceDetails.possesionDate}</span>
									</div></li>

							</ul>
						</div>
					</div>
				</div>
			</div>


			<!-- Insights -->
			<div class="card">

				<div class="head">
					<h3>INSIGHTS</h3>
				</div>

				<div class="body">
					<div>
						<div class="left">
							<ul>
								<li><img alt="building-icon.png"
									src="${pageContext.request.contextPath}/icons/building-icon.png">
									<div>
										<span class="mute fs-sm">Facing</span> <span>${property.propertyDetails.facing}</span>
									</div></li>
							</ul>
						</div>
						<div class="right">
							<ul>
								<li><img alt="occupancy-icon.png"
									src="${pageContext.request.contextPath}/icons/occupancy-icon.png">
									<div>
										<span class="mute fs-sm">Flooring</span> <span>${property.propertyDetails.flooringType}</span>
									</div></li>
							</ul>
						</div>
					</div>
				</div>
			</div>


			<!-- Amenities -->
			<div class="card">

				<div class="head">
					<h3>AMENITIES</h3>
				</div>

				<div class="body">
					<div>
						<div class="left">
							<ul>
								<li><img alt="lift-icon.png"
									src="${pageContext.request.contextPath}/icons/lift-icon.png">
									<div>
										<span class="mute fs-sm">Lift</span> <span> <c:if
												test="${property.otherAmenities.lift == true}">
												Yes
											</c:if> <c:if test="${property.otherAmenities.lift == false}">
												No
											</c:if>
										</span>
									</div></li>

								<li><img alt="washroom-icon.png"
									src="${pageContext.request.contextPath}/icons/washroom-icon.png">
									<div>
										<span class="mute fs-sm">Washroom</span> <span>${property.amenities.bathrooms}</span>
									</div></li>

								<li><img alt="security-icon.png"
									src="${pageContext.request.contextPath}/icons/security-icon.png">
									<div>
										<span class="mute fs-sm">Security</span> <span> <c:if
												test="${property.amenities.gatedSecurity == true}">
												Yes
											</c:if> <c:if test="${property.amenities.gatedSecurity == false}">
												No
											</c:if>
										</span>
									</div></li>
							</ul>
						</div>
						<div class="right">
							<ul>
								<li><img alt="power-icon.png"
									src="${pageContext.request.contextPath}/icons/power-icon.png">
									<div>
										<span class="mute fs-sm">Power Backup</span> <span>${property.amenities.powerBackup}</span>
									</div></li>

								<li><img alt="water-storage-icon.png"
									src="${pageContext.request.contextPath}/icons/water-storage.png">
									<div>
										<span class="mute fs-sm">Water Storage</span> <span>${property.amenities.waterSupply}</span>
									</div></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>

		<button class="contact" onclick="contactOwner(${property.id})">Contact
			Owner</button>
	</main>

	<jsp:include page="CommonScripts.jsp"></jsp:include>

</body>
</html>