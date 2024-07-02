import React from 'react';
import { useNavigate } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';

function HomeComponent() {
  const navigate = useNavigate();

  const handleNavigation = (path) => {
    navigate(path);
  };

  return (
    <div className="container mt-5">
      <h2 className="text-center mb-4">Select Entity</h2>
      <div className="row justify-content-center">
        <div className="col-12 col-md-4 d-flex justify-content-center mb-3">
          <button type="button" className="btn btn-secondary w-100" onClick={() => handleNavigation('/admin')}>Admin</button>
        </div>
        {/* <div className="col-12 col-md-4 d-flex justify-content-center mb-3">
          <button type="button" className="btn btn-secondary w-100" onClick={() => handleNavigation('/pharmacists')}>Pharmacist</button>
        </div> */}
        <div className="col-12 col-md-4 d-flex justify-content-center mb-3">
          <button type="button" className="btn btn-secondary w-100" onClick={() => handleNavigation('/medicine-shop')}>Medicine Shop</button>
        </div>
      </div>
    </div>
  );
}

export default HomeComponent;
