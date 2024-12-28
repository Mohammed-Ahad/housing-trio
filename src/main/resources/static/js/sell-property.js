let fullForm = "";

function toggleForm(radioBtn) {

	if (radioBtn.checked) {
		fullForm = document.querySelector(".full-form").innerHTML
		document.querySelector(".full-form").innerHTML = "";
		document.querySelector("button[type='submit']").innerHTML = "Send Request"
	}
	else {
		document.querySelector(".full-form").innerHTML = fullForm;
		document.querySelector("button[type='submit']").innerHTML = "Post Property"
	}
}

async function postProperty(e) {
	e.preventDefault();
	const form = e.target

	try {
		await sendPostReq(`${baseUrl}/api/sell-your-property`, form, true)
		alert("Request sent will contact you soon!")
	}
	catch (e) {
		alert("Something went wrong, try again!")
	}
}