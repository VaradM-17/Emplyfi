import React from "react";
import { Link } from "react-router-dom";

const HeaderComponent = () => {
  return (
    <header>
      <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
        <div className="container-fluid">
          <Link className="navbar-brand" to="/">
            Emplyfi
          </Link>
          <ul className="navbar-nav me-auto mb-2 mb-lg-0 d-flex flex-row gap-3">
            <li className="nav-item">
              <Link className="nav-link" to="/employees">
                Employees
              </Link>
            </li>
            <li className="nav-item">
              <Link className="nav-link" to="/departments">
                Departments
              </Link>
            </li>
          </ul>
        </div>
      </nav>
    </header>
  );
};

export default HeaderComponent;
