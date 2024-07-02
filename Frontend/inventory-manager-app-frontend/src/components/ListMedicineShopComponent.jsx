import React, { useEffect, useState } from 'react';
import { deleteMedicine_shop, listMedicine_shops } from '../service/MedicineShopService';
import { useNavigate } from 'react-router-dom';

const ListMedicineShopComponent = () => {
  const [medicine_shops, setMedicine_shops] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    getAllMedicine_shops();
  }, []);

  const getAllMedicine_shops = () => {
    listMedicine_shops()
      .then((response) => {
        setMedicine_shops(response.data);
      })
      .catch((error) => console.error(error));
  };

  const addNewMedicine_shop = () => {
    navigate('/add-medicine-shop');
  };

  const updateMedicine_shop = (shop_id) => {
    navigate(`/edit-medicine-shop/${shop_id}`);
  };

  const removeMedicine_shop = (shop_id) => {
    deleteMedicine_shop(shop_id)
      .then(() => {
        getAllMedicine_shops();
      })
      .catch((error) => console.error(error));
  };

  return (
    <div className="container">
      <h2 className="text-center">List of Medicine shops</h2>
      <button className="btn btn-secondary mb-2" onClick={addNewMedicine_shop}>
        Add Medicine Shop
      </button>
      <table className="table table-striped table-bordered">
        <thead>
          <tr>
            <th>Medicine Shop Id</th>
            <th>Shop Name</th>
            <th>Address</th>
            <th>Contact No.</th>
            <th>Email Id</th>
            <th>Other Details</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {medicine_shops.map((medicine_shop) => (
            <tr key={medicine_shop.shop_id}>
              <td>{medicine_shop.shop_id}</td>
              <td>{medicine_shop.shop_name}</td>
              <td>{medicine_shop.address}</td>
              <td>{medicine_shop.contact_number}</td>
              <td>{medicine_shop.email_id}</td>
              <td>{medicine_shop.other_details}</td>
              <td>
                <div style={{ display: 'flex' }}>
                  <button className="btn btn-info" onClick={() => updateMedicine_shop(medicine_shop.shop_id)}>
                    Update
                  </button>
                  <span style={{ margin: '0 10px' }}></span>
                  <button className="btn btn-danger" onClick={() => removeMedicine_shop(medicine_shop.shop_id)}>
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

export default ListMedicineShopComponent;
