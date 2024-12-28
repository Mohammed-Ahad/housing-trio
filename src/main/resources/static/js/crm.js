window.onload = () => {
	loadLeadsTable();
}

const dataTables = {}

async function loadLeadsTable(basedOn = 'followUpDate') {

	const data = {
		basedOn
	}
	try {
		console.log('base', baseUrl)
	
		const res = await sendGetReq(`${baseUrl}/api/get-leads`, data)
		if (!res.ok) {
			throw new Error('Somthing went wrong please try again')
		}

		const resData = await res.json();

		if (dataTables['leadTable']) {
			dataTables['leadTable']
				.clear()
				.rows.add(resData)
				.draw();
			success('Success', "Lead loaded!")
			return;
		}

		const leadTable = $('#leadsTable').DataTable({
			data: resData,
			columns: [
				{ data: 'id', title: 'ID', visible: false }, // Hidden column
				{ data: 'name', title: 'Name' },
				{ data: 'phoneNo', title: 'Phone No' },
				{ data: 'assignedTo', title: 'Assigned To' },
				{ data: 'status', title: 'Status' },
				{ data: 'project', title: 'Project' },
				{ data: 'followUpDate', title: 'Follow Up' },
				{
					data: 'edit', title: 'Edit', render: (_, __, row) => {
						return `<span onclick='showDescriptionPopUp(${row.id})'>Descrintion</span>
								<i class="fa-regular fa-pen-to-square" data-id="${row.id}" onclick="showLeadPopUp(this)">Edit</i>`
					}
				},
			]
		});
		dataTables['leadTable'] = leadTable;

		success('Success', "Lead loaded!")
	}
	catch (e) {
		error('Error', e.message)
	}
}

async function showDescriptionPopUp(leadId) {
	try {
		const res = await sendGetReq(`${baseUrl}/api/get-lead-descriptions/${leadId}`)
		if (!res.ok) {
			throw new Error('Lead description fetch failed!')
		}
		const descriptions = await res.json();

		$.confirm({
			title: 'Add Description?',
			content: `
			<div class='description-popup'>
				<div class='left'>
					<table>
						<tr>
							<th>Description</th>
							<th>On</th>
						</tr>
						${descriptions.map(desc => `<tr><td>${desc.description}</td><td>${desc.updateDt}</td></tr>`)}
					</table>				
				</div>
				<div class='right'>
					<textarea placeholder='Enter Description' id="description"></textarea>
					<button class='primary-btn' onclick="addDescription(${leadId})">Add</button>
				</div>
			</div>`,
			boxWidth: "70vw",
			useBootstrap: false,
			buttons: {
				cancel: function() {
				}
			}
		});
	}
	catch (e) {
		error('Error', e.message);
	}
}

async function addDescription(leadId) {
	const description = document.getElementById('description').value;
	if (!description) {
		error('Error', 'Please enter description')
		return
	}

	try {
		const data = {
			leadId, description
		}
		const res = await sendPostReq(`${baseUrl}/api/add-description/`, data)
		if (!res.ok) {
			throw new Error('Lead description fetch failed!')
		}
		const descriptions = await res.json();

		const newDesc = `
					<table>
						<tr>
							<th>Description</th>
							<th>On</th>
						</tr>
						${descriptions.map(desc => `<tr><td>${desc.description}</td><td>${desc.updateDt}</td></tr>`)}
					</table>`

		const leftDiv = document.querySelector('.description-popup .left')
		leftDiv.innerHTML = newDesc;
		success('Succcess', 'Description added!')
	}
	catch (e) {
		error("Error", e.message)
	}

}

function showLeadPopUp(element) {

	//Row data from data table
	const rowData = dataTables['leadTable'].row($(element).closest('tr')).data(); // Use DataTable's API
	//Status options in form
	const statusOption = ['New', 'Hot', 'Follow Up', 'Booked and Closed', 'Dead'];
	//User options in form
	const users = ['info']

	$.confirm({
		title: 'Add Lead?',
		content: `<div>
				<form id="addLeadForm">
					<label for='cName'>Name: </label>
					<input id="cName" name="cName" placeholder='Enter name' value='${rowData?.name || ''}' />
					
					<label for='phone'>Phone no: </label>
					<input id="phone" name="phone" placeholder='Enter phone no' value='${rowData?.phoneNo || ''}' />
					
					<label for='assignTo'>Assign To: </label>
					<select id="assignTo" name="assignTo">
						<option value=''>--- Select ---</option>
						${users.map(op => `<option value='${op}' ${rowData?.assignedTo === op ? 'selected' : ''}>${op}</option>`)}
					</select>
					
					<label for='status'>Status: </label>
					<select id="status" name="status">
						<option value=''>--- Select ---</option>
						${statusOption.map(op => `<option value='${op}' ${rowData?.status === op ? 'selected' : ''}>${op}</option>`)}
					</select>
					
					<label for='project'>Project: </label>
					<input id="project" name="project" placeholder='Enter project' value='${rowData?.project || ''}' />
					
					<label for='followUpDate'>Follow Up: </label>
					<input id="followUpDate" name="followUpDate" placeholder='Select Date' type='date' value='${rowData?.followUpDate || ''}' />
					
					<label for='description'>Description: </label>
					<input id="description" name="description" placeholder='Enter description' value='${rowData?.description || ''}' />
				</form>
			</div>`,
		boxWidth: "30vw",
		useBootstrap: false,
		buttons: {
			[element ? 'save' : 'add']: function() {
				const addLeadForm = document.getElementById('addLeadForm')
				const name = addLeadForm.querySelector("[name='cName']").value
				if (!name) {
					error('Error', 'Enter name')
					return false
				}
				const phoneNo = addLeadForm.querySelector("[name='phone']").value
				if (!phoneNo) {
					error('Error', 'Enter phone no')
					return false
				}
				const assignedTo = addLeadForm.querySelector("[name='assignTo']").value
				if (!assignedTo) {
					error('Error', 'Select assign to')
					return false
				}

				const status = addLeadForm.querySelector("[name='status']").value
				if (!status) {
					error('Error', 'Select status')
					return false
				}

				const project = addLeadForm.querySelector("[name='project']").value
				if (!project) {
					error('Error', 'Enter project')
					return false
				}

				const followUpDate = addLeadForm.querySelector("[name='followUpDate']").value
				if (!followUpDate) {
					error('Error', 'Select follow up Date')
					return false
				}

				const description = addLeadForm.querySelector("[name='description']").value

				const data = {
					id: rowData?.id, name, phoneNo, assignedTo, status, project, description, followUpDate
				}

				async function saveLead() {
					try {
						const res = await sendPostReq(`${baseUrl}/api/save-lead`, data)
						if (!res.ok) {
							throw new Error('Lead was not saved try again!')
						}

						const basedOn = document.querySelector('input[name="basedOn"]:checked')?.value;
						loadLeadsTable(basedOn)

						success('Success', 'Lead added!')
					}
					catch (e) {
						error('Error', e.message);
					}
				}

				saveLead();

				return true
			},
			cancel: function() {
			}
		}
	});
}