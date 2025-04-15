import React, { useState, useEffect } from "react";
import {
  listDepartments,
  deleteDepartment,
} from "../services/DepartmentService";
import { Link, useNavigate } from "react-router-dom";

const ListDepartmentComponent = () => {
  const [departments, setDepartments] = useState([]);
  const navigate = useNavigate();

  //useEffect to fetch all department data
  useEffect(() => {
    getAllDepartments();
  }, []);

  // fetch all department
  function getAllDepartments() {
    listDepartments().then((response) => {
      setDepartments(response.data);
    });
  }

  // redirect to update page (department component) passing id 
  function updateDepartment(id) {
    navigate(`/edit-department/${id}`);
  }

  // delete department
  function removeDepartment(id) {
    deleteDepartment(id)
      .then(() => {
        getAllDepartments();
      })
      .catch((error) => {
        console.error(error);
      });
  }

  return (
    <div className="container">
      <h2 className="text-center mt-5 mb-4">List Departments</h2>

      <Link to={"/add-department"} className="btn btn-primary mb-3">
        Add Department
      </Link>

      <table className="table table-striped table-bordered">
        <thead className="table-dark text-center">
          <tr>
            <td>Department ID</td>
            <td>Department Name</td>
            <td>Department Description</td>
            <td>Actions</td>
          </tr>
        </thead>
        <tbody>
          {departments.map((department) => (
            <tr key={department.id} className="text-center">
              <td>{department.id}</td>
              <td>{department.departmentName}</td>
              <td>{department.departmentDescription}</td>
              <td>
                <button
                  className="btn btn-primary me-2"
                  onClick={() => updateDepartment(department.id)}
                  title="Update"
                >
                  <i className="fa-solid fa-user-pen"></i>
                </button>
                <button
                  className="btn btn-danger"
                  onClick={() => removeDepartment(department.id)}
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
  );
};

export default ListDepartmentComponent;
