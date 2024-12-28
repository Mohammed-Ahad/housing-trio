// Initialize the DataTable
$(document).ready(function() {
	$('#postedPropertiesTable').DataTable();
	$('#contactOwnerTable').DataTable();
	$('#listedPropertiesTable').DataTable();
});

function approveProperty(propertyId) {

	$.confirm({
		title: 'Are you sure?',
		content: 'You want approve this property!',
		boxWidth: "30vw",
		useBootstrap: false,
		buttons: {
			approve: async function() {

				try {
					await sendPostReq(`${baseUrl}/api/approve-property/${propertyId}`)
					location.reload()
				}
				catch (e) {
					error('Error', e);
				}
			},
			cancel: function() {
			}
		}
	});
}


function cancelProperty(propertyId) {

	$.confirm({
		title: 'Are you sure?',
		content: 'You want to cancel this property!',
		boxWidth: "30vw",
		useBootstrap: false,
		buttons: {
			confirm: async function() {

				try {
					await sendPostReq(`${baseUrl}/api/cancel-property/${propertyId}`)
					location.reload()
				}
				catch (e) {
					error(e);
				}
			},
			cancel: function() {
			}
		}
	});

}