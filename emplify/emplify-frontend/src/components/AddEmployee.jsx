import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { create, getById, update } from "../services/EmployeeService";
import { getAll } from "../services/DepartmentService";
import { toast } from "react-toastify";

const AddEmployee = () => {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [departmentId, setDepartmentId] = useState("");

  const [departments, setDepartments] = useState([]);

  const navigate = useNavigate();
  const { id } = useParams();

  useEffect(() => {
    getAll().then((response) => setDepartments(response.data));
  }, []);

  // get by id
  useEffect(() => {
    if (id) {
      getById(id)
        .then((response) => {
          const employee = response.data;
          setFirstName(employee.firstName);
          setLastName(employee.lastName);
          setEmail(employee.email);
          setDepartmentId(employee.departmentId);
        })
        .catch((error) => {
          console.error("Error fetching employee:", error);
        });
    }
  }, [id]);

  function saveOrUpdateEmployee(e) {
    e.preventDefault();

    const employee = { firstName, lastName, email, departmentId };

    if (id) {
      update(id, employee)
        .then((response) => {
          toast("Employee Updated Successfully!", { type: "success" });
          navigate("/employees");
        })
        .catch((error) => {
          toast("Failed to Update Employee.", { type: "error" });
        });
    } else {
      create(employee)
        .then((response) => {
          toast("Employee Added Successfully!", { type: "success" });
          navigate("/employees");
        })
        .catch((error) => {
          toast("Failed to Add Employee.", { type: "error" });
        });
    }
  }

  function title(id) {
    if (id) {
      return <h2 className="text-center fw-bold mb-4">Update Employee</h2>;
    } else {
      return <h2 className="text-center fw-bold mb-4">Add Employee</h2>;
    }
  }

  return (
    <div
      className="container my-5 border border-dark border-2 p-5 rounded shadow bg-primary bg-opacity-10"
      style={{ maxWidth: "600px" }}
    >
      <form onSubmit={saveOrUpdateEmployee}>
        <h2 className="text-center fw-bold mb-4">{title(id)}</h2>

        <div className="mb-3">
          <label className="form-label">First Name</label>
          <input
            type="text"
            className="form-control"
            value={firstName}
            onChange={(e) => setFirstName(e.target.value)}
          />
        </div>

        <div className="mb-3">
          <label className="form-label">Last Name</label>
          <input
            type="text"
            className="form-control"
            value={lastName}
            onChange={(e) => setLastName(e.target.value)}
          />
        </div>

        <div className="mb-3">
          <label className="form-label">Email</label>
          <input
            type="email"
            className="form-control"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
        </div>

        <div className="mb-3">
          <label className="form-label">Select Department</label>
          <select
            className="form-control"
            value={departmentId}
            onChange={(e) => setDepartmentId(e.target.value)}
          >
            <option value="Select Department">-- Select --</option>
            {departments.map((department) => (
              <option key={department.id} value={department.id}>
                {department.departmentName}
              </option>
            ))}
          </select>
        </div>

        <button type="submit" className="btn btn-primary w-100 mt-4">
          {id ? "Update" : "Add"}
        </button>
      </form>
    </div>
  );
};

export default AddEmployee;
