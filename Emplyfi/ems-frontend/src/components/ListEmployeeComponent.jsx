import React from "react";
import { useState, useEffect } from "react";
import { listEmployees } from "../services/EmployeeService";

const ListEmployeeComponent = () => {
  const [employees, setEmployees] = useState([]);

  useEffect(() => {
    listEmployees()
      .then((response) => {
        setEmployees(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);

 
  return (
    <div className="container my-5 text-center">
      <div className="card shadow rounded-4 border-0">
        <div className="card-body p-4">
          <h3 className="card-title text-center mb-4">Employees List</h3>
          <div className="table-responsive" style={{ maxHeight: "300px" }}>
            <table className="table table-hover table-bordered mb-0">
              <thead className="table-dark sticky-top">
                <tr>
                  <th>Employee ID</th>
                  <th>First Name</th>
                  <th>Last Name</th>
                  <th>Email</th>
                </tr>
              </thead>
              <tbody>
                {employees.map((employee) => (
                  <tr key={employee.id}>
                    <td>{employee.id}</td>
                    <td>{employee.firstName}</td>
                    <td>{employee.lastName}</td>
                    <td>{employee.email}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  );
};

export default ListEmployeeComponent;
