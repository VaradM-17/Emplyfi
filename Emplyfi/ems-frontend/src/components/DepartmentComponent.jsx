import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { createDepartment } from "../services/DepartmentService";

const DepartmentComponent = () => {
  const [departmentName, setDepartmentName] = useState("");
  const [departmentDescription, setDepartmentDescription] = useState("");

  const navigator = useNavigate();

  function saveDepartment(e) {
    e.preventDefault();

    const department = { departmentName, departmentDescription };

    createDepartment(department)
      .then((response) => {
        console.log(response.data);
        navigator("/departments");
      })
      .catch((error) => {
        console.error(error);
      });
  }

  return (
    <div className="container mt-5">
      <div className="row">
        <div className="card col-md-6 offset-md-3 mt-5">
          <h2 className="text-center mt-4">Add Department</h2>

          <div className="card-body">
            <form>
              <div className="form-group mb-2">
                <label className="form-label">Department Name :</label>
                <input
                  type="text"
                  name="departmentName"
                  placeholder="Enter department name"
                  value={departmentName}
                  onChange={(e) => setDepartmentName(e.target.value)}
                  className="form-control"
                />
              </div>

              {/* Department Description */}
              <div className="form-group mb-2">
                <label className="form-label">Department Description :</label>
                <input
                  type="text"
                  name="departmentDescription"
                  placeholder="Enter department description"
                  value={departmentDescription}
                  onChange={(e) => setDepartmentDescription(e.target.value)}
                  className="form-control"
                />
              </div>

              <div className="text-center">
                <button
                  className="btn btn-success btn-lg mt-3"
                  onClick={saveDepartment}
                >
                  Submit
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default DepartmentComponent;
