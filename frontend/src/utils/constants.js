const _tableheaders = ["First Name", "Last Name", "Description", "Actions"];
export { _tableheaders as tableheaders };

const _columns = ["firstName", "lastName", "description"];
export { _columns as columns };

// const baseUrl = 'https://demo.localdev.me';
const baseUrl = process.env.REACT_APP_BACKEND_URL;
export { baseUrl as baseUrl };