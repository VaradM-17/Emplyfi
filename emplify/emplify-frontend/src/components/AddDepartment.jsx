import React, { useEffect, useState } from "react";
import { create, getById, update } from "../services/DepartmentService";
import { useNavigate, useParams } from "react-router-dom";
import { toast } from "react-toastify";

const AddDepartment = () => {
  const [departmentName, setDepartmentName] = useState("");
  const [departmentDescription, setDepartmentDescription] = useState("");

  const { id } = useParams();
  const navigate = useNavigate();

  useEffect(() => {
    if (id) {
      getById(id).then((response) => {
        const department = response.data;
        setDepartmentName(department.departmentName);
        setDepartmentDescription(department.departmentDescription);
      });
    }
  }, [id]);

  function saveOrUpdateDepartment(e) {
    e.preventDefault();

    const department = { departmentName, departmentDescription };

    if (id) {
      update(id, department)
        .then((response) => {
          toast("Department Updated Successfully!", { type: "success" });
          navigate("/departments");
        })
        .catch((error) => {
          toast("Failed to Update Department.", { type: "error" });
        });
    } else {
      create(department)
        .then((response) => {
          toast("Department Added Successfully!", { type: "success" });
          navigate("/departments");
        })
        .catch((error) => {
          toast("Failed to Add Department.", { type: "error" });
        });
    }
  }

  function title(id) {
    if (id) {
      return <h2 className="text-center fw-bold mb-4">Update Department</h2>;
    } else {
      return <h2 className="text-center fw-bold mb-4">Add Department</h2>;
    }
  }

  return (
    <div
      className="container my-5 border border-dark border-2 p-5 rounded shadow bg-primary bg-opacity-10"
      style={{ maxWidth: "550px" }}
    >
      <form onSubmit={saveOrUpdateDepartment}>
        <h2 className="text-center fw-bold mb-4">{title(id)}</h2>

        <div className="mb-3">
          <label className="form-label">Department Name</label>
          <input
            type="text"
            className="form-control"
            value={departmentName}
            onChange={(e) => setDepartmentName(e.target.value)}
          />
        </div>

        <div className="mb-3">
          <label className="form-label">Department Description</label>
          <textarea
            className="form-control"
            rows="4"
            value={departmentDescription}
            onChange={(e) => setDepartmentDescription(e.target.value)}
          ></textarea>
        </div>

        <button type="submit" className="btn btn-primary w-100 mt-4">
          {id ? "Update" : "Add"}
        </button>
      </form>
    </div>
  );
};

export default AddDepartment;
