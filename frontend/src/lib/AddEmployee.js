import { baseUrl } from '../utils/constants';
async function addEmployee(employee) {
  delete employee.id;
  var requestOptions = {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(employee)
  };
  fetch(`${baseUrl}/api/employees/add`, requestOptions)
    .then(response => alert('Employee added successfully !'))
    .then(result => console.log(result))
    .catch(error => alert('Error adding employee : ' + error.message))
}

export default addEmployee;