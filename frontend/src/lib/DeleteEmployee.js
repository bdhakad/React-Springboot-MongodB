import { baseUrl } from '../utils/constants';
async function deleteEmployee(employee) {
    var requestOptions = {
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(employee)
    };
    fetch(`${baseUrl}/api/employees/delete`, requestOptions)
        .then(response => alert('Employee deleted successfully !'))
        .then(result => console.log(result))
        .catch(error => alert('Error deleting employee : ' + error.message))
}

export default deleteEmployee;