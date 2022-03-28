import './App.css';
import React, { useState, useEffect, Fragment } from "react";
import ReadOnlyRow from './components/ReadOnlyRow';
import EditableRow from './components/EditableRow';
import fetchAllEmployees from './lib/ListEmployees';
import deleteEmployee from './lib/DeleteEmployee';
import addEmployee from './lib/AddEmployee';
import updateEmployee from './lib/UpdateEmployee';
import { nanoid } from 'nanoid';
import { tableheaders, columns } from './utils/constants';

function App() {
  //set the initial state
  const [isLoading, setIsLoading] = useState(true);
  const [data, setData] = useState([]);
  const [editEmployeeId, setEditEmployeeId] = useState(null);
  const [addFormData, setAddFormData] = useState({
    id: nanoid(),
    firstName: "",
    lastName: "",
    description: "",
  });
  const [editFormData, setEditFormData] = useState({
    // id: nanoid(),
    firstName: "",
    lastName: "",
    description: "",
  });

  //create add form data from inputs
  const handleAddFormDataChange = (event) => {
    event.preventDefault();
    const { name, value } = event.target;
    setAddFormData({ ...addFormData, [name]: value });
  }

  //create edit form data from inputs
  const handleEditFormDataChange = (event) => {
    event.preventDefault();
    const { name, value } = event.target;
    setEditFormData({ ...editFormData, [name]: value });
  }

  //add new data to the table and database
  const handleAddFormSubmit = (event) => {
    event.preventDefault();
    addEmployee(addFormData);
    const newData = [...data, addFormData];
    setData(newData);
    setAddFormData({
      id: "",
      firstName: "",
      lastName: "",
      description: "",
    });
  }

  //update data in the table and database
  const handleEditFormSubmit = (event) => {
    event.preventDefault();
    const newData = data.map(employee => {
      if (employee.id === editFormData.id) {
        updateEmployee(editFormData);
        return editFormData;
      }
      return employee;
    });
    setData(newData);
    setEditEmployeeId(null);
  }


  const handleEditClick = (event, employee) => {
    event.preventDefault();
    setEditEmployeeId(employee.id);
    const formValues = {
      id: employee.id,
      firstName: employee.firstName,
      lastName: employee.lastName,
      description: employee.description,
    }
    setEditFormData(formValues);
  }

  const handleCancelClick = (event) => {
    event.preventDefault();
    setEditEmployeeId(null);
    setEditFormData({
      id: "",
      firstName: "",
      lastName: "",
      description: "",
    });
  }

  //delete data from the table and database
  const handleDeleteClick = (event, employee) => {
    event.preventDefault();
    const newData = data.filter(item => item.id !== employee.id);
    setData(newData);
    deleteEmployee(employee);
  }

  //fetch data from the api
  useEffect(async () => {
    const data = await fetchAllEmployees();
    setData(data);
  }, []);

  //set the state to false once the data is received
  useEffect(() => {
    console.log("isLoading", isLoading);
    if (data.length !== 0) {
      setIsLoading(false);
    }
    console.log("data", data);
  }, [data]);

  //render the table only when the data is received
  return (
    <div className="App">
      <form onSubmit={handleEditFormSubmit}>
        <table>
          <thead>
            <tr>
              {tableheaders.map(header => <th key={header}>{header}</th>)}
            </tr>
          </thead>
          <tbody>
            {data.map((employee) => {
              return (
                <Fragment>
                  {editEmployeeId === employee.id
                    ? (<EditableRow employee={employee}
                      editFormData={editFormData}
                      handleEditFormDataChange={handleEditFormDataChange}
                      handleCancelClick={handleCancelClick} />)
                    : (<ReadOnlyRow
                      employee={employee}
                      handleEditClick={handleEditClick}
                      handleDeleteClick={handleDeleteClick} />)}
                </Fragment>
              )
            })}
          </tbody>
        </table>
      </form>
      <h2> Add an employee</h2>
      <form onSubmit={handleAddFormSubmit}>
        <tr>
          {columns.map(column =>
            <th key={column}>
              <input
                type="text"
                name={column}
                required="required"
                placeholder={column.toLocaleLowerCase()}
                onChange={handleAddFormDataChange}
              />
            </th>)}
          <th><button type="submit">Add</button></th>
        </tr>

      </form>
    </div>
  );
}

export default App;
