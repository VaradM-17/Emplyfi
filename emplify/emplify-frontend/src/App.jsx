import { BrowserRouter, Route, Routes } from "react-router-dom";
import "./App.css";
import ListEmployees from "./components/ListEmployees";
import AddEmployee from "./components/AddEmployee";
import Navigation from "./components/Navigation";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import ListDepartments from "./components/ListDepartments";
import AddDepartment from "./components/AddDepartment";

function App() {
  return (
    <div>
      <BrowserRouter>
        <Navigation />

        <Routes>
          <Route path="/" element={<ListEmployees />} />
          <Route path="/employees" element={<ListEmployees />} />
          <Route path="/add/employee" element={<AddEmployee />} />
          <Route path="/edit/employee/:id" element={<AddEmployee />} />
          
          <Route path="/departments" element={<ListDepartments />} />
          <Route path="/add/department" element={<AddDepartment />} />
          <Route path="/edit/department/:id" element={<AddDepartment />} />

          <Route
            path="*"
            element={<h2 className="text-center mt-5">404 Page Not Found</h2>}
          />
        </Routes>

        <ToastContainer position="top-right" autoClose={2000} />
      </BrowserRouter>
    </div>
  );
}

export default App;
