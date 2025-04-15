import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import {createDepartment,getDepartmentById,updateDepartment} from "../services/DepartmentService";

const DepartmentComponent = () => {
  const [departmentName, setDepartmentName] = useState("");
  const [departmentDescription, setDepartmentDescription] = useState("");

  // dynamically change Title if id is present
  const { id } = useParams();
  const navigator = useNavigate();

  // useEffect to fetch department
  useEffect(() => {
    getDepartmentById(id)
      .then((response) => {
        setDepartmentName(response.data.departmentName);
        setDepartmentDescription(response.data.departmentDescription);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);

  // create
  function saveOrUpdateDepartment(e) {
    e.preventDefault();

    const department = { departmentName, departmentDescription };

    if (id) {
      // update department
      updateDepartment(id, department)
        .then((response) => {
          console.log(response.data);
          navigator("/departments");
        })
        .catch((error) => {
          console.error(error);
        });
    } else {
      // create department
      createDepartment(department)
        .then((response) => {
          console.log(response.data);
          navigator("/departments");
        })
        .catch((error) => {
          console.error(error);
        });
    }
  }

  function pageTitle() {
    if (id) {
      return <h2 className="text-center mt-3">Update Department</h2>;
    } else {
      return <h2 className="text-center mt-3">Add Department</h2>;
    }
  }

  return (
    <div className="container mt-5">
      <div className="row">
        <div className="card col-md-6 offset-md-3 mt-5">
          {pageTitle()}
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

              <div className="text-center mb-4">
                <button
                  className="btn btn-success btn-lg mt-4"
                  onClick={saveOrUpdateDepartment}
                >
                  {id ? "Update" : "Submit"}
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
