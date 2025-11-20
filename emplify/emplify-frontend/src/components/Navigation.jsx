import React from "react";
import { Link } from "react-router-dom";

const Navigation = () => {
  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
      <div className="container">
        <Link to="/" className="navbar-brand fs-2 fw-bold">
          Employee Management
        </Link>

        <div className="d-flex">
          <Link to="/employees" className="nav-link fs-5 text-white">
            Employees
          </Link>

          <Link to="/departments" className="nav-link fs-5 text-white ms-3">
            Departments
          </Link>
        </div>
      </div>
    </nav>
  );
};

export default Navigation;
