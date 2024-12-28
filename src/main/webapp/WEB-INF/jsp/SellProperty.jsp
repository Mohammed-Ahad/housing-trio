<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/img/favicon.ico"
	type="image/x-icon">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/output.css">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.4/jquery-confirm.min.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/common.css">
</head>

<jsp:include page="CommonHeader.jsp" />

<main>
	<div class="container mx-auto px-8">
		<div class="max-w-lg mx-auto bg-white p-8 rounded-lg shadow-lg">
			<!-- Personal Details Section -->
			<h2 class="text-2xl font-bold text-center mb-6">Personal Details</h2>
			<form class="space-y-6" onsubmit="postProperty(event)">
				<!-- Full Name -->
				<div>
					<label for="fullName" class="block text-gray-700 font-medium mb-2">
						Full Name <span class="red">*</span>
					</label> <input type="text" id="fullName" name="fullName"
						placeholder="Full Name" required
						class="w-full px-4 py-2 border-2 border-gray-300 rounded-lg focus:outline-none focus:border-blue-500" />
				</div>

				<!-- Mobile Number -->
				<div>
					<label for="mobileNumber"
						class="block text-gray-700 font-medium mb-2"> Mobile
						Number <span class="red">*</span>
					</label> <input type="tel" id="mobileNumber" name="mobileNumber"
						placeholder="Mobile Number" required
						class="w-full px-4 py-2 border-2 border-gray-300 rounded-lg focus:outline-none focus:border-blue-500" />
				</div>

				<!-- Email Address -->
				<div>
					<label for="email" class="block text-gray-700 font-medium mb-2">
						Email Address <span class="red">*</span>
					</label> <input type="email" id="email" name="email"
						placeholder="Email Address" required
						class="w-full px-4 py-2 border-2 border-gray-300 rounded-lg focus:outline-none focus:border-blue-500" />
				</div>



				<div class="space-y-6">
					<h2 class="text-2xl font-bold text-center mb-6 mt-8">Property
						Details</h2>

					<div>
						<label for="apartmentName"
							class="block text-gray-700 font-medium mb-2">
							Apartment/Society Name <span class="red">*</span>
						</label> <input type="text" id="apartmentName" name="apartmentName"
							placeholder="Apartment/Society Name" required
							class="w-full px-4 py-2 border-2 border-gray-300 rounded-lg focus:outline-none focus:border-blue-500" />
					</div>

					<div>
						<label for="ownershipType"
							class="block text-gray-700 font-medium mb-2"> Ownership
							Type <span class="red">*</span>
						</label> <select id="ownershipType" name="ownershipType" required
							class="w-full px-4 py-2 border-2 border-gray-300 rounded-lg focus:outline-none focus:border-blue-500">
							<option value="" disabled selected>Select Ownership Type</option>
							<option value="Self Owned">Self Owned</option>
							<option value="On Lease">On Lease</option>
						</select>
					</div>

					<div>
						<label for="builtUpArea"
							class="block text-gray-700 font-medium mb-2"> Built-up
							Area (sq ft) <span class="red">*</span>
						</label> <input type="number" id="builtUpArea" name="builtUpArea"
							placeholder="Built-up Area in sq ft" required
							class="w-full px-4 py-2 border-2 border-gray-300 rounded-lg focus:outline-none focus:border-blue-500" />
					</div>

					<div>
						<label for="carpetArea"
							class="block text-gray-700 font-medium mb-2"> Carpet Area
							(sq ft) <span class="red">*</span>
						</label> <input type="number" id="carpetArea" name="carpetArea"
							placeholder="Carpet Area in sq ft" required
							class="w-full px-4 py-2 border-2 border-gray-300 rounded-lg focus:outline-none focus:border-blue-500" />
					</div>

					<div>
						<label for="flooringType"
							class="block text-gray-700 font-medium mb-2"> Flooring
							Type <span class="red">*</span>
						</label> <select id="flooringType" name="flooringType" required
							class="w-full px-4 py-2 border-2 border-gray-300 rounded-lg focus:outline-none focus:border-blue-500">
							<option value="" disabled selected>Select Flooring Type</option>
							<option value="Cement">Cement</option>
							<option value="Mosaic">Mosaic</option>
							<option value="Marble / Granite">Marble/Granite</option>
							<option value="wooden">Wooden</option>
							<option value="Vitrified Tiles">Vitrified Tiles</option>
						</select>
					</div>

					<div>
						<label for="bhkType" class="block text-gray-700 font-medium mb-2">
							BHK Type <span class="red">*</span>
						</label> <select id="bhkType" name="bhkType" required
							class="w-full px-4 py-2 border-2 border-gray-300 rounded-lg focus:outline-none focus:border-blue-500">
							<option value="" disabled selected>Select BHK Type</option>
							<option value="1RK">1 RK</option>
							<option value="1BHK">1 BHK</option>
							<option value="2BHK">2 BHK</option>
							<option value="3BHK">3 BHK</option>
							<option value="4BHK">4 BHK</option>
							<option value="4+BHK">4+ BHK</option>
						</select>
					</div>

					<div>
						<label for="facing" class="block text-gray-700 font-medium mb-2">
							Facing <span class="red">*</span>
						</label> <select id="facing" name="facing" required
							class="w-full px-4 py-2 border-2 border-gray-300 rounded-lg focus:outline-none focus:border-blue-500">
							<option value="" disabled selected>Select Facing</option>
							<option value="North">North</option>
							<option value="South">South</option>
							<option value="East">East</option>
							<option value="West">West</option>
						</select>
					</div>

					<div>
						<label for="propertyAge"
							class="block text-gray-700 font-medium mb-2"> Property
							Age <span class="red">*</span>
						</label> <select id="propertyAge" name="propertyAge" required
							class="w-full px-4 py-2 border-2 border-gray-300 rounded-lg focus:outline-none focus:border-blue-500">
							<option value="" disabled selected>Select Property Age</option>
							<option value="less than 1">Less than 1 year</option>
							<option value="1 - 3">1-3 years</option>
							<option value="3 - 5">3-5 years</option>
							<option value="5 - 10">5-10 years</option>
							<option value="10+">More than 10 years</option>
						</select>
					</div>

					<div class="grid grid-cols-2 gap-4">
						<div>
							<label for="floor" class="block text-gray-700 font-medium mb-2">
								Floor <span class="red">*</span>
							</label> <input type="number" id="floor" name="floor" placeholder="Floor"
								required
								class="w-full px-4 py-2 border-2 border-gray-300 rounded-lg focus:outline-none focus:border-blue-500" />
						</div>

						<div>
							<label for="totalFloors"
								class="block text-gray-700 font-medium mb-2"> Total
								Floors <span class="red">*</span>
							</label> <input type="number" id="totalFloors" name="totalFloors"
								placeholder="Total Floors" required
								class="w-full px-4 py-2 border-2 border-gray-300 rounded-lg focus:outline-none focus:border-blue-500" />
						</div>
					</div>


					<div class="flex space-x-3 justify-center">
						<input type="checkbox" id="letUsHelp" name="letUsHelp"
							onclick="toggleForm(this)"
							class="px-4 py-2 border-2 border-gray-300 rounded-lg focus:outline-none focus:border-blue-500" />
						<label for="letUsHelp" class="block text-gray-700 font-medium">Let
							us help to sell your property</label>
					</div>
				</div>

				<!-- Property Details -->
				<div class="full-form">
					<!-- Locality Details Section -->

					<div class="space-y-6">
						<h2 class="text-2xl font-bold text-center mb-6 mt-8">Locality
							Details</h2>

						<div>
							<label for="locality"
								class="block text-gray-700 font-medium mb-2"> Locality <span
								class="red">*</span>
							</label> <input type="text" id="locality" name="locality"
								placeholder="Locality" required
								class="w-full px-4 py-2 border-2 border-gray-300 rounded-lg focus:outline-none focus:border-blue-500" />
						</div>

						<div>
							<label for="streetAreaLandmark"
								class="block text-gray-700 font-medium mb-2">
								Street/Area/Landmark <span class="red">*</span>
							</label> <input type="text" id="streetAreaLandmark"
								name="streetAreaLandmark" placeholder="Street/Area/Landmark"
								required
								class="w-full px-4 py-2 border-2 border-gray-300 rounded-lg focus:outline-none focus:border-blue-500" />
						</div>
					</div>

					<!-- Price Details Section -->
					<div class="space-y-6">

						<h2 class="text-2xl font-bold text-center mb-6 mt-8">Price
							Details</h2>

						<div>
							<label for="expectedPrice"
								class="block text-gray-700 font-medium mb-2"> Expected
								Price (in lacks) <span class="red">*</span>
							</label> <input type="number" id="expectedPrice" name="expectedPrice"
								step="0.1" placeholder="Expected Price" required
								class="w-full px-4 py-2 border-2 border-gray-300 rounded-lg focus:outline-none focus:border-blue-500" />
						</div>

						<div class="flex items-center space-x-3">
							<input type="checkbox" id="negotiable" name="negotiable"
								class="form-checkbox text-blue-600" /> <label for="negotiable"
								class="text-gray-700 font-medium">Negotiable</label>
						</div>

						<div>
							<label for="maintenanceCost"
								class="block text-gray-700 font-medium mb-2"> Monthly
								Maintenance Cost (in thousands) <span class="red">*</span>
							</label> <input type="number" id="maintenanceCost" name="maintenanceCost"
								step="0.1" placeholder="Monthly Maintenance Cost" required
								class="w-full px-4 py-2 border-2 border-gray-300 rounded-lg focus:outline-none focus:border-blue-500" />
						</div>

						<div class="flex items-center space-x-3">
							<input type="checkbox" id="underLoan" name="underLoan"
								class="form-checkbox text-blue-600" /> <label for="underLoan"
								class="text-gray-700 font-medium">Currently Under Loan</label>
						</div>

						<div>
							<label for="possessionDate"
								class="block text-gray-700 font-medium mb-2"> Possession
								Date <span class="red">*</span>
							</label> <input type="date" id="possessionDate" name="possessionDate"
								required
								class="w-full px-4 py-2 border-2 border-gray-300 rounded-lg focus:outline-none focus:border-blue-500" />
						</div>

						<div>
							<label for="furnishing"
								class="block text-gray-700 font-medium mb-2"> Furnishing
								<span class="red">*</span>
							</label> <select id="furnishing" name="furnishing" required
								class="w-full px-4 py-2 border-2 border-gray-300 rounded-lg focus:outline-none focus:border-blue-500">
								<option value="" disabled selected>Select Furnishing</option>
								<option value="Full">Full</option>
								<option value="Semi">Semi</option>
								<option value="Unfurnished">Unfurnished</option>
							</select>
						</div>


						<div>
							<label for="parking" class="block text-gray-700 font-medium mb-2">
								Parking <span class="red">*</span>
							</label> <select id="parking" name="parking" required
								class="w-full px-4 py-2 border-2 border-gray-300 rounded-lg focus:outline-none focus:border-blue-500">
								<option value="" disabled selected>Select Parking</option>
								<option value="Car">Car</option>
								<option value="Bike">Bike</option>
								<option value="Car & bike">Car & Bike</option>
								<option value="None">None</option>
							</select>
						</div>


						<div>
							<label for="kitchenType"
								class="block text-gray-700 font-medium mb-2"> Kitchen
								Type <span class="red">*</span>
							</label> <select id="kitchenType" name="kitchenType" required
								class="w-full px-4 py-2 border-2 border-gray-300 rounded-lg focus:outline-none focus:border-blue-500">
								<option value="" disabled selected>Select Kitchen Type</option>
								<option value="Modular">Modular</option>
								<option value="Covered Shelves">Covered Shelves</option>
								<option value="Open Shelves">Open Shelves</option>
							</select>
						</div>

						<div>
							<label for="propertyDescription"
								class="block text-gray-700 font-medium mb-2"> Property
								Description <span class="red">*</span>
							</label>
							<textarea id="propertyDescription" name="propertyDescription"
								placeholder="Property Description" rows="4" required
								class="w-full px-4 py-2 border-2 border-gray-300 rounded-lg focus:outline-none focus:border-blue-500"></textarea>
						</div>
					</div>


					<!-- Amenities Details Section -->
					<div class="space-y-6">
						<h2 class="text-2xl font-bold text-center mb-6 mt-8">Amenities
							Details</h2>

						<div>
							<label for="bathrooms"
								class="block text-gray-700 font-medium mb-2">Bathroom(s)</label>
							<input type="number" id="bathrooms" name="bathrooms"
								placeholder="Number of Bathrooms"
								class="w-full px-4 py-2 border-2 border-gray-300 rounded-lg focus:outline-none focus:border-blue-500" />
						</div>

						<div>
							<label for="balconies"
								class="block text-gray-700 font-medium mb-2">Balcony(s)</label>
							<input type="number" id="balconies" name="balconies"
								placeholder="Number of Balconies"
								class="w-full px-4 py-2 border-2 border-gray-300 rounded-lg focus:outline-none focus:border-blue-500" />
						</div>

						<div>
							<label for="showBy" class="block text-gray-700 font-medium mb-2">Who
								Will Show This Property</label> <select id="showBy" name="showBy"
								class="w-full px-4 py-2 border-2 border-gray-300 rounded-lg focus:outline-none focus:border-blue-500">
								<option value="" disabled selected>Select</option>
								<option value="Need help">Need Help</option>
								<option value="I Will Show">I Will Show</option>
								<option value="Neighbours">Neighbours</option>
								<option value="Friends / Relatives">Friends/Relatives</option>
								<option value="Security">Security</option>
								<option value="Tenants">Tenants</option>
								<option value="Others">Others</option>
							</select>
						</div>

						<div class="flex items-center space-x-3">
							<input type="checkbox" id="gatedSecurity" name="gatedSecurity"
								class="form-checkbox text-blue-600" /> <label
								for="gatedSecurity" class="text-gray-700 font-medium">Gated
								Security</label>
						</div>

						<div class="flex items-center space-x-3">
							<input type="checkbox" id="gym" name="gym"
								class="form-checkbox text-blue-600" /> <label for="gym"
								class="text-gray-700 font-medium">Gym</label>
						</div>

						<div>
							<label for="waterSupply"
								class="block text-gray-700 font-medium mb-2">Water
								Supply</label> <select id="waterSupply" name="waterSupply"
								class="w-full px-4 py-2 border-2 border-gray-300 rounded-lg focus:outline-none focus:border-blue-500">
								<option value="" disabled selected>Select Water Supply</option>
								<option value="Corporation">Corporation</option>
								<option value="Borewell">Borewell</option>
								<option value="Corporation & Borewell">Both</option>
							</select>
						</div>

						<div>
							<label for="powerBackup"
								class="block text-gray-700 font-medium mb-2">Power
								Backup</label> <select id="powerBackup" name="powerBackup"
								class="w-full px-4 py-2 border-2 border-gray-300 rounded-lg focus:outline-none focus:border-blue-500">
								<option value="" disabled selected>Select Power Backup</option>
								<option value="Full">Full</option>
								<option value="Partial">Partial</option>
								<option value="None">None</option>
							</select>
						</div>
					</div>


					<!-- Other Amenities -->
					<div class="grid grid-cols-2 gap-4 my-3">
						<div class="flex items-center">
							<input type="checkbox" id="airConditioner" name="airConditioner"
								class="form-checkbox text-blue-600" /> <label
								for="airConditioner" class="text-gray-700 font-medium ml-2">Air
								Conditioner</label>
						</div>
						<div class="flex items-center">
							<input type="checkbox" id="club" name="club"
								class="form-checkbox text-blue-600" /> <label for="club"
								class="text-gray-700 font-medium ml-2">Club</label>
						</div>
						<div class="flex items-center">
							<input type="checkbox" id="playground" name="playground"
								class="form-checkbox text-blue-600" /> <label for="playground"
								class="text-gray-700 font-medium ml-2">Playground</label>
						</div>
						<div class="flex items-center">
							<input type="checkbox" id="gas" name="gas"
								class="form-checkbox text-blue-600" /> <label for="gas"
								class="text-gray-700 font-medium ml-2">Gas</label>
						</div>
						<div class="flex items-center">
							<input type="checkbox" id="rainWaterHarvesting"
								name="rainWaterHarvesting" class="form-checkbox text-blue-600" />
							<label for="rainWaterHarvesting"
								class="text-gray-700 font-medium ml-2">Rain Water
								Harvesting</label>
						</div>
						<div class="flex items-center">
							<input type="checkbox" id="sewage" name="sewage"
								class="form-checkbox text-blue-600" /> <label for="sewage"
								class="text-gray-700 font-medium ml-2">Sewage</label>
						</div>
						<div class="flex items-center">
							<input type="checkbox" id="lift" name="lift"
								class="form-checkbox text-blue-600" /> <label for="lift"
								class="text-gray-700 font-medium ml-2">Lift</label>
						</div>
						<div class="flex items-center">
							<input type="checkbox" id="fireAlarm" name="fireAlarm"
								class="form-checkbox text-blue-600" /> <label for="fireAlarm"
								class="text-gray-700 font-medium ml-2">Fire Alarm</label>
						</div>
						<div class="flex items-center">
							<input type="checkbox" id="houseKeeper" name="houseKeeper"
								class="form-checkbox text-blue-600" /> <label for="houseKeeper"
								class="text-gray-700 font-medium ml-2">House Keeper</label>
						</div>
						<div class="flex items-center">
							<input type="checkbox" id="park" name="park"
								class="form-checkbox text-blue-600" /> <label for="park"
								class="text-gray-700 font-medium ml-2">Park</label>
						</div>
						<div class="flex items-center">
							<input type="checkbox" id="shoppingCenter" name="shoppingCenter"
								class="form-checkbox text-blue-600" /> <label
								for="shoppingCenter" class="text-gray-700 font-medium ml-2">Shopping
								Center</label>
						</div>
						<div class="flex items-center">
							<input type="checkbox" id="swimmingPool" name="swimmingPool"
								class="form-checkbox text-blue-600" /> <label
								for="swimmingPool" class="text-gray-700 font-medium ml-2">Swimming
								Pool</label>
						</div>
						<div class="flex items-center">
							<input type="checkbox" id="intercom" name="intercom"
								class="form-checkbox text-blue-600" /> <label for="intercom"
								class="text-gray-700 font-medium ml-2">Intercom</label>
						</div>
						<div class="flex items-center">
							<input type="checkbox" id="visitorParking" name="visitorParking"
								class="form-checkbox text-blue-600" /> <label
								for="visitorParking" class="text-gray-700 font-medium ml-2">Visitor
								Parking</label>
						</div>
						<div class="flex items-center">
							<input type="checkbox" id="internet" name="internet"
								class="form-checkbox text-blue-600" /> <label for="internet"
								class="text-gray-700 font-medium ml-2">Internet</label>
						</div>
					</div>


					<!--Property Images and Videos Section
					<h2 class="text-2xl font-bold text-center mb-6 mt-8">Property
						Images and Videos</h2>

					Images Upload
					<div>
						<label for="propertyImages"
							class="block text-gray-700 font-medium mb-2">Property
							Images</label> <input type="file" id="propertyImages"
							name="propertyImages[]" multiple accept="image/*"
							class="w-full px-4 py-2 border-2 border-gray-300 rounded-lg focus:outline-none focus:border-blue-500" />
						<p class="text-gray-600 text-sm mt-1">You can upload multiple
							images. Supported formats: JPEG, PNG, GIF.</p>
					</div>

					Videos Upload
					<div>
						<label for="propertyVideos"
							class="block text-gray-700 font-medium mb-2">Property
							Videos</label> <input type="file" id="propertyVideos"
							name="propertyVideos[]" multiple accept="video/*"
							class="w-full px-4 py-2 border-2 border-gray-300 rounded-lg focus:outline-none focus:border-blue-500" />
						<p class="text-gray-600 text-sm mt-1">You can upload multiple
							videos. Supported formats: MP4, AVI, MOV.</p>
					</div> -->

					<!-- Additional Information Section -->
					<div class="space-y-6">
						<h2 class="text-2xl font-bold text-center mb-6 mt-8">Additional
							Information</h2>

						<div>
							<label for="khataCertificate"
								class="block text-gray-700 font-medium mb-2"> Do you
								have Khata Certificate? <span class="red">*</span>
							</label> <select id="khataCertificate" name="khataCertificate" required
								class="w-full px-4 py-2 border-2 border-gray-300 rounded-lg focus:outline-none focus:border-blue-500">
								<option value="" disabled selected>Select Khata
									Certificate Status</option>
								<option value="A khata">Yes, A-Khata</option>
								<option value="B khata">Yes, B-Khata</option>
								<option value="No">No</option>
								<option value="Dont Know">Don't Know</option>
							</select>
						</div>

						<div>
							<label for="saleDeedCertificate"
								class="block text-gray-700 font-medium mb-2"> Do you
								have Sale Deed Certificate? <span class="red">*</span>
							</label> <select id="saleDeedCertificate" name="saleDeedCertificate"
								required
								class="w-full px-4 py-2 border-2 border-gray-300 rounded-lg focus:outline-none focus:border-blue-500">
								<option value="" disabled selected>Select Sale Deed
									Certificate Status</option>
								<option value="Yes">Yes</option>
								<option value="No">No</option>
								<option value="Dont Know">Don't Know</option>
							</select>
						</div>

						<div>
							<label for="occupancyCertificate"
								class="block text-gray-700 font-medium mb-2"> Do you
								have Occupancy Certificate? <span class="red">*</span>
							</label> <select id="occupancyCertificate" name="occupancyCertificate"
								required
								class="w-full px-4 py-2 border-2 border-gray-300 rounded-lg focus:outline-none focus:border-blue-500">
								<option value="" disabled selected>Select Occupancy
									Certificate Status</option>
								<option value="Yes">Yes</option>
								<option value="No">No</option>
								<option value="Dont Know">Don't Know</option>
							</select>
						</div>

						<div>
							<label for="propertyTax"
								class="block text-gray-700 font-medium mb-2"> Have you
								paid Property Tax? <span class="red">*</span>
							</label> <select id="propertyTax" name="propertyTax" required
								class="w-full px-4 py-2 border-2 border-gray-300 rounded-lg focus:outline-none focus:border-blue-500">
								<option value="" disabled selected>Select Property Tax
									Status</option>
								<option value="Yes">Yes</option>
								<option value="No">No</option>
								<option value="Dont Know">Don't Know</option>
							</select>
						</div>

					</div>
				</div>

				<!-- Submit Button -->
				<div class="text-center mt-6">
					<button type="submit"
						class="text-white px-6 py-2 rounded-lg  focus:outline-none focus:ring-2 focus:ring-blue-500">Post
						Property</button>
				</div>
			</form>
		</div>
	</div>
</main>

<script
	src="${pageContext.request.contextPath}/js/plugins/jquery.min.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.4/jquery-confirm.min.js"></script>

<script src="${pageContext.request.contextPath}/js/common.js"></script>
<script src="${pageContext.request.contextPath}/js/sell-property.js"></script>
</body>
</html>