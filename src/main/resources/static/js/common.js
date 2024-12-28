const baseUrl = '/housing-trio';

function success(title, message = '') {
	iziToast.success({
		title,
		message,
	});
}

function error(title, message = '') {
	iziToast.error({
		title,
		message,
	});

}

const sendGetReq = (url, data = {}) => {
	let params = new URLSearchParams(data)

	url = `${url}?${params}`
	return fetch(url, { mode: 'no-cors' })
}

const sendPostReq = (url, data, isFormData = false) => {

	data = (data == undefined) ? {} : data

	if (isFormData) {
		data = new FormData(data)
		for (let pair of data.entries()) {
			data[pair[0]] = pair[1];
		}
	}

	return fetch(url, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(data)
	})
}

function contactOwner(propertyId) {

	$.confirm({
		title: 'Contact Owner!',
		theme: 'modern',
		boxWidth: '400px',
		useBootstrap: false,
		closeIcon: true,
		content: '' +
			'<form action="" class="formName">' +
			'<div class="form-group">' +
			'<input type="text" placeholder="Enter your name" class="name form-control" required />' +
			'</div>' +
			'<div class="form-group">' +
			'<input type="email" placeholder="Enter your email" class="email form-control" required />' +
			'</div>' +
			'<div class="form-group">' +
			'<input type="tel" placeholder="Enter your phone number" class="phone form-control" required />' +
			'</div>' +
			'</form>',
		buttons: {
			formSubmit: {
				text: 'Submit',
				btnClass: 'btn-blue',
				action: function() {
					const name = this.$content.find('.name').val();
					const email = this.$content.find('.email').val();
					var phoneNo = this.$content.find('.phone').val();

					if (!name) {
						error('provide a valid name');
						return false;
					}

					if (!email) {
						error('provide a valid email');
						return false;
					}

					// Validate email format
					const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
					if (!emailPattern.test(email)) {
						error('Please provide a valid email address');
						return false;
					}

					if (!phoneNo) {
						error('provide a valid phone no');
						return false;
					}

					// Validate Indian phone number (10 digits, starting with 7, 8, or 9)
					const phonePattern = /^[789]\d{9}$/;
					if (!phonePattern.test(phoneNo)) {
						error('Please provide a valid Indian phone number (10 digits starting with 7, 8, or 9)');
						return false;
					}

					const data = {
						propertyId, name, email, phoneNo
					}

					const sendReq = async () => {
						try {

							const res = await sendPostReq(`${baseUrl}/api/contact-owner`, data)

							if (res.ok){
								const msg = await res.text();
								if(msg){
									alert(msg);
									return
								}
								
								alert('Request sent will contact you soon!')
							}
								
							else
								error(`something went wrong try again later`);
						}
						catch (e) {
							error(`Request failed: ${e.message}`);
						}
					}

					sendReq();

				}
			},
		}
	});
}

function alert(msg) {
	$.confirm({
		title: msg,
		theme: 'modern',
		boxWidth: '400px',
		useBootstrap: false,
		closeIcon: true,
		content: '',
	})
}