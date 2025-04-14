import "./App.css";
import ListEmployeeComponent from "./components/ListEmployeeComponent";
import HeaderComponent from "./components/HeaderComponent";
import EmployeeComponent from "./components/EmployeeComponent";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import ListDepartmentComponent from "./components/ListDepartmentComponent";
import DepartmentComponent from "./components/DepartmentComponent";

function App() {
  return (
    <>
      <BrowserRouter>
        <HeaderComponent />
        <Routes>
          {/* employees */}
          <Route path="/" element={<ListEmployeeComponent />} />
          <Route path="/employees" element={<ListEmployeeComponent />} />
          <Route path="/add-employee" element={<EmployeeComponent />} />
          <Route path="/edit-employee/:id" element={<EmployeeComponent />} />

           {/* departments  */}
          <Route path="/departments" element={<ListDepartmentComponent />} />
          <Route path="/add-department" element={<DepartmentComponent />} />
          {/* <Route path="/edit-department/:id" element={<DepartmentComponent />}/> */}
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
