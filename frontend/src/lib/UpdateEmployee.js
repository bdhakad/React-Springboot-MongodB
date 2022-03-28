async function updateEmployee(employee) {
  var requestOptions = {
    method: 'PATCH',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(employee)
  };
  fetch("http://localhost:8080/api/employees/update", requestOptions)
    .then(response => alert('Employee updated successfully !'))
    .then(result => console.log(result))
    .catch(error => alert('Error updating employee : ' + error.message))
}

export default updateEmployee;