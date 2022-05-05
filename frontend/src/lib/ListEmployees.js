import {baseUrl} from '../utils/constants';
async function fetchAllEmployees() {
  var requestOptions = {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json'
    },
    redirect: 'follow'
  };
  const response = await fetch(`${baseUrl}/api/employees/list`, requestOptions);
  return response.json();
}
export default fetchAllEmployees;