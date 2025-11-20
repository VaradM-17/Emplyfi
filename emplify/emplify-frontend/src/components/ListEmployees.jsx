import React, { useEffect, useState } from "react";
import { getAll, remove, searchByName } from "../services/EmployeeService";
import { useNavigate } from "react-router-dom";
import { toast } from "react-toastify";

const ListEmployees = () => {
  const [employees, setEmployees] = useState([]);
  const [search, setSearch] = useState("");

  const navigate = useNavigate();

  useEffect(() => {
    listAllEmployees();
  }, []);

  function listAllEmployees() {
    getAll()
      .then((response) => {
        setEmployees(response.data);
        console.log("React received:", response.data);
      })
      .catch((error) => {
        toast("Failed to fetch employees.", { type: "error" });
        console.error("Error fetching employees:", error);
      });
  }

  function deleteEmployee(id) {
    remove(id)
      .then(() => {
        toast("Employee deleted successfully.", { type: "success" });
        listAllEmployees();
      })
      .catch((error) => {
        toast("Failed to delete employee.", { type: "error" });
        console.error("Error deleting employee:", error);
      });
  }

  function searchEmployees(name) {
    if (name.trim() === "") {
      listAllEmployees();
      return;
    }

    searchByName(name)
      .then((response) => {
        setEmployees(response.data);
      })
      .catch(() => {
        toast("No employees found.", { type: "info" });
      });
  }

  return (
    <div className="container my-5">
      <h2 className="text-center fw-bold mb-5">Employees List</h2>
      <div>
        <div className="d-flex justify-content-between align-items-center mt-3">
          <button
            className="btn btn-primary"
            onClick={() => navigate("/add/employee")}
          >
            Add Employee
          </button>

          <div className="input-group" style={{ width: "250px" }}>
            <span className="input-group-text">
              <i className="bi bi-search"></i>
            </span>

            <input
              type="text"
              className="form-control"
              placeholder="Search by first name"
              value={search}
              onChange={(e) => {
                setSearch(e.target.value);
                searchEmployees(e.target.value);
              }}
            />
          </div>
        </div>

        <table className="table table-bordered table-striped mt-3">
          <thead className="table-dark">
            <tr>
              <th>Employee ID</th>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Email</th>
              <th>Department</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {employees.map((employee) => (
              <tr key={employee.id}>
                <td>{employee.id}</td>
                <td>{employee.firstName}</td>
                <td>{employee.lastName}</td>
                <td>{employee.email}</td>
                <td>{employee.departmentName}</td>
                <td>
                  <button
                    type="button"
                    className="btn btn-primary btn-sm me-2"
                    onClick={() => navigate(`/edit/employee/${employee.id}`)}
                  >
                    Edit
                  </button>
                  <button
                    type="button"
                    className="btn btn-danger btn-sm"
                    onClick={() => deleteEmployee(employee.id)}
                  >
                    Delete
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

export default ListEmployees;
