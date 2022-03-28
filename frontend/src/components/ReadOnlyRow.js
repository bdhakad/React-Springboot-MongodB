import React from "react";

const ReadOnlyRow = ({ employee, handleEditClick, handleDeleteClick}) => {
    return (
        <tr>
        <td>{employee.firstName}</td>
        <td>{employee.lastName}</td>
        <td>{employee.description}</td>
        <td>
            <button onClick={(event) => handleEditClick(event, employee)}>Edit</button>
            <button onClick={(event) => handleDeleteClick(event, employee)}>Delete</button>
        </td>
        </tr>
    );
}
export default ReadOnlyRow;