import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import ListAdminComponent from './components/ListAdminComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import AdminComponent from './components/AdminComponent';
// import ListPharmacistComponent from './components/ListPharmacistComponent';
// import PharmacistComponent from './components/PharmacistComponent';
import ListMedicineShopComponent from './components/ListMedicineShopComponent';
import MedicineShopComponent from './components/MedicineShopComponent';
import HomeComponent from './components/HomeComponent';

function App() {
  return (
    <>
      <BrowserRouter>
        <HeaderComponent />
        <Routes>
          {/* Home Route */}
          <Route path='/' element={<HomeComponent />} />

          {/* Admin Routes */}
          <Route path='/admin' element={<ListAdminComponent />} />
          <Route path='/add-admin' element={<AdminComponent />} />
          <Route path='/edit-admin/:admin_id' element={<AdminComponent />} />

          {/* Pharmacist Routes */}
          {/* <Route path='/pharmacists' element={<ListPharmacistComponent />} />
          <Route path='/add-pharmacist' element={<PharmacistComponent />} />
          <Route path='/edit-pharmacist/:pharmacist_id' element={<PharmacistComponent />} /> */}

          {/* Medicine Routes */}
          <Route path='/medicine-shop' element={<ListMedicineShopComponent />} />
          <Route path='/add-medicine-shop' element={<MedicineShopComponent />} />
          <Route path='/edit-medicine-shop/:shop_id' element={<MedicineShopComponent />} />

        </Routes>
        <FooterComponent />
      </BrowserRouter>
    </>
  );
}

export default App;
