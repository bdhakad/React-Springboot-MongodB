
async function fetchAllEmployees() {
  var requestOptions = {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json'
    },
    redirect: 'follow'
  };
  const response = await fetch("http://localhost:8080/api/employees/list", requestOptions);
  return response.json();
}
export default fetchAllEmployees;