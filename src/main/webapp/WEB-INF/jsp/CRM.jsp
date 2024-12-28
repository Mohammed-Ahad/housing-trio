<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Housing Trio / CRM</title>

<jsp:include page="CommonLinks.jsp" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/crm.css">
</head>
<body>
	<jsp:include page="AdminHeader.jsp" />

	<main class="space-y-6">
		<div class="table-conatainer processing">
			<div class="flex gap-2 items-center">
				<h2 class="title">Leads</h2>
				<button class="primary-btn" onclick="showLeadPopUp()">Add</button>
			</div>


			<div class="advance-search">
				<div class="based-on">
					<div>
						<input id="followUpDate" name='basedOn' type='radio' checked
							value='followUpDate' /> <label for='followUpDate'
							onclick="loadLeadsTable('followUpDate')">Follow Up</label>
					</div>

					<div>
						<input id="active" name='basedOn' type='radio' value='active' />
						<label for='active' onclick="loadLeadsTable('active')">Active</label>
					</div>


					<div>
						<input id="closed" name='basedOn' type='radio' value='closed' /> <label
							for='closed' onclick="loadLeadsTable('closed')">Closed</label>
					</div>

					<div>
						<input id="dead" name='basedOn' type='radio' value='dead' /> <label
							for='dead' onclick="loadLeadsTable('dead')">Dead</label>
					</div>
				</div>
			</div>

			<table id="leadsTable">
			</table>
		</div>
	</main>

	<jsp:include page="CommonScripts.jsp" />

	<script src="${pageContext.request.contextPath}/js/crm.js"></script>
</body>
</html>