import React from "react";
import { columns } from "../utils/constants";

const EditableRow = ({ editFormData, handleEditFormDataChange, handleCancelClick }) => {
    return (
        <tr>
            {columns.map(column => (
                <td key={column}>
                    <input
                        type="text"
                        name={column}
                        required="required"
                        placeholder={column.toLocaleLowerCase()}
                        value={editFormData[column]}
                        onChange={handleEditFormDataChange}
                    />
                </td>
            ))}
            <td>
                <button type="submit">Save</button>
                <button type="button" onClick={handleCancelClick}>Cancel</button>
            </td>
        </tr>
    );
}
export default EditableRow;