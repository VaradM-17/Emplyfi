import React, { useState, useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
import { listEmployees, deleteEmployee } from "../services/EmployeeService";

const ListEmployeeComponent = () => {
  const [employees, setEmployees] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    getAllEmployees();
  }, []);

  function getAllEmployees() {
    listEmployees()
      .then((response) => {
        setEmployees(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }

  // function addNewEmployee() {
  //   navigate("/add-employee");
  // }

  function updateEmployee(id) {
    navigate(`/edit-employee/${id}`);
  }

  function removeEmployee(id) {
    deleteEmployee(id)
      .then(() => {
        getAllEmployees();
      })
      .catch((error) => {
        console.error(error);
      });
  }

  return (
    <div className="container mt-5">
      <h2 className="mb-4 text-center">Employees List</h2>
      {/* <button
        type="button"
        className="btn btn-primary mb-3"
        onClick={addNewEmployee}
      >
        Add Employee
      </button> */}

      <Link to={'/add-employee'} className="btn btn-primary mb-3">Add Employee</Link>

      <div className="table-responsive text-center">
        <table className="table table-striped table-bordered">
          <thead className="table-dark">
            <tr>
              <th scope="col" className="text-center">Employee Id</th>
              <th scope="col" className="text-center">First Name</th>
              <th scope="col" className="text-center">Last Name</th>
              <th scope="col" className="text-center">Email</th>
              <th scope="col" className="text-center">Department</th>
              <th scope="col" className="text-center">Actions</th>
              
            </tr>
          </thead>
          <tbody>
            {employees.map((employee) => (
              <tr key={employee.id} className="text-center">
                <td>{employee.id}</td>
                <td>{employee.firstName}</td>
                <td>{employee.lastName}</td>
                <td>{employee.email}</td>
                <td>{employee.departmentName}</td>
                <td>
                  <button
                    className="btn btn-primary me-2"
                    onClick={() => updateEmployee(employee.id)}
                    title="Update"
                  >
                    <i class="fa-solid fa-user-pen"></i>
                  </button>
                  <button
                    className="btn btn-danger me-2"
                    onClick={() => removeEmployee(employee.id)}
                    title="Delete"
                  >
                    <i className="fas fa-trash"></i>
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default ListEmployeeComponent;
