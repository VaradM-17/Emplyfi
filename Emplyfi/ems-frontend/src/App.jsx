import { useState } from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "/vite.svg";
import "./App.css";
import ListEmployeeComponent from "./components/ListEmployeeComponent";
import HeaderComponent from "./components/HeaderComponent";
import FooterComoonent from "./components/FooterComponent";

function App() {
  return (
    <>
      <HeaderComponent></HeaderComponent>
      <ListEmployeeComponent></ListEmployeeComponent>
      <FooterComoonent></FooterComoonent>
    </>
  );
}

export default App;
