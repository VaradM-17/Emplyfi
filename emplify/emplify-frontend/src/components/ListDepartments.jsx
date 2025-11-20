import React, { useEffect, useState } from "react";
import { getAll, getById, remove } from "../services/DepartmentService";
import { useNavigate } from "react-router-dom";
import { toast } from "react-toastify";

const ListDepartments = () => {
  const [departments, setDepartments] = useState([]);

  const navigate = useNavigate();

  useEffect(() => {
    listAllDepartments();
  }, []);

  function listAllDepartments() {
    getAll()
      .then((response) => {
        setDepartments(response.data);
        console.log(response.data);
      })
      .catch((error) => {
        console.error("Error fetching departments:", error);
      });
  }
  function deleteDepartment(id) {
    remove(id)
      .then(() => {
        toast("Department deleted successfully.", { type: "success" });
        listAllDepartments();
      })
      .catch((error) => {
        toast("Failed to delete department.", { type: "error" });
      });
  }

  return (
    <div className="container my-5">
      <h2 className="text-center fw-bold">Departments List</h2>
      <div>
        <button
          className="btn btn-primary"
          onClick={() => navigate("/add/department")}
        >
          Add Department
        </button>
        <table className="table table-bordered table-striped mt-3">
          <thead className="table-dark">
            <tr>
              <th>Department ID</th>
              <th>Department Name</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {departments.map((department) => (
              <tr key={department.id}>
                <td>{department.id}</td>
                <td>{department.departmentName}</td>
                <td>
                  <button
                    type="button"
                    className="btn btn-primary btn-sm me-2"
                    onClick={() =>
                      navigate(`/edit/department/${department.id}`)
                    }
                  >
                    Edit
                  </button>
                  <button
                    type="button"
                    className="btn btn-danger btn-sm"
                    onClick={() => {
                      deleteDepartment(department.id);
                    }}
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

export default ListDepartments;
