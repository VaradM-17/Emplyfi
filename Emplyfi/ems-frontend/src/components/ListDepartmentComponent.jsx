import React, { useState, useEffect } from "react";
import { listDepartments } from "../services/DepartmentService";
import { useNavigate } from "react-router-dom";

const ListDepartmentComponent = () => {
  const [departments, setDepartments] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    getAllDepartments();
  }, []);

  // read all
  function getAllDepartments() {
    listDepartments().then((response) => {
      setDepartments(response.data);
    });
  }

  //navigate to create 
  function addNewDepartment() {
    navigate("/add-department");
  }

  return (
    <div className="container">
      <h2 className="text-center mt-5 mb-4">List Departments</h2>

      <button className="btn btn-primary mb-3" onClick={addNewDepartment}>
        Add Department
      </button>

      <table className="table table-striped table-bordered">
        <thead className="table-dark text-center">
          <tr>
            <td>Department ID</td>
            <td>Department Name</td>
            <td>Department Description</td>
          </tr>
        </thead>
        <tbody>
          {departments.map((department) => (
            <tr key={department.id} className="text-center">
              <td>{department.id}</td>
              <td>{department.departmentName}</td>
              <td>{department.departmentDescription}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ListDepartmentComponent;
