import React, { useEffect, useState } from 'react';
import { deleteAdmin, listAdmins } from '../service/AdminService';
import { useNavigate } from 'react-router-dom';

const ListAdminComponent = () => {
  const [admins, setAdmins] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    getAllAdmins();
  }, []);

  const getAllAdmins = () => {
    listAdmins()
      .then((response) => {
        setAdmins(response.data);
      })
      .catch((error) => console.error(error));
  };

  const addNewAdmin = () => {
    navigate('/add-admin');
  };

  const updateAdmin = (admin_id) => {
    navigate(`/edit-admin/${admin_id}`);
  };

  const removeAdmin = (admin_id) => {
    deleteAdmin(admin_id)
      .then(() => {
        getAllAdmins();
      })
      .catch((error) => console.error(error));
  };

  return (
    <div className="container">
      <h2 className="text-center">List of Admins</h2>
      <button className="btn btn-secondary mb-2" onClick={addNewAdmin}>
        Add Admin
      </button>
      <table className="table table-striped table-bordered">
        <thead>
          <tr>
            <th>Admin Id</th>
            <th>Username</th>
            <th>Password</th>
            <th>Email Id</th>
            <th>Contact No.</th>
            <th>Other Details</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {admins.map((admin) => (
            <tr key={admin.admin_id}>
              <td>{admin.admin_id}</td>
              <td>{admin.username}</td>
              <td>{'•'.repeat(admin.password.length)}</td>
              <td>{admin.email_id}</td>
              <td>{admin.contact_number}</td>
              <td>{admin.other_details}</td>
              <td>
                <div style={{ display: 'flex' }}>
                  <button className="btn btn-info" onClick={() => updateAdmin(admin.admin_id)}>
                    Update
                  </button>
                  <span style={{ margin: '0 10px' }}></span>
                  <button className="btn btn-danger" onClick={() => removeAdmin(admin.admin_id)}>
                    Delete
                  </button>
                </div>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ListAdminComponent;
