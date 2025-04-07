import React from "react";

const FooterComponent = () => {
  return (
    <div>
      <footer className="bg-body-tertiary text-center">
        <div className="container p-4"></div>

        <div
          className="text-center p-3"
          style={{ backgroundColor: "rgba(0, 0, 0, 0.05)" }}
        >
          © 2025 Copyright:
          <a className="text-body" href="#">
            {" "}Emplyfi
          </a>
        </div>
      </footer>
    </div>
  );
};

export default FooterComponent;
