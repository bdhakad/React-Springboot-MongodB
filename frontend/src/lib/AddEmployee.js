
async function addEmployee(employee) {
  var requestOptions = {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(employee)
  };
  fetch('http://localhost:8080/api/employees/add', requestOptions)
    .then(response => alert('Employee added successfully !'))
    .then(result => console.log(result))
    .catch(error => alert('Error adding employee : ' + error.message))
}

export default addEmployee;