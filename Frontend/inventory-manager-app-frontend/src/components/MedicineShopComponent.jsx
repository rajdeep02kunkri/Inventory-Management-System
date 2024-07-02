import React, { useState } from 'react';
import { createMedicine_shop, updateMedicine_shop } from '../service/MedicineShopService';
import { useNavigate, useParams } from 'react-router-dom';

const MedicineShopComponent = () => {
  const [shop_id, setShop_id] = useState(0);
  const [shop_name, setShop_name] = useState('');
  const [address, setAddress] = useState('');
  const [contact_number, setContact_number] = useState('');
  const [email_id, setEmail_id] = useState('');
  const [other_details, setOther_details] = useState('');


  const navigator = useNavigate();
  const reg = useParams();
  
  
  function saveOrUpdateMedicine_shop(e) {
    e.preventDefault();
    const flag1=shop_id && shop_name && address && email_id && contact_number && other_details;
    const flag2= shop_name && address && email_id && contact_number && other_details;
    const flag3=Object.keys(reg).length > 0;


    if (flag1 || (flag2 && flag3)) {
      const medicine_shop = { shop_id,shop_name,address,contact_number,email_id,other_details };
      console.log(medicine_shop);

      if(flag3){
        updateMedicine_shop(reg.shop_id,medicine_shop).then((response) =>{
          console.log(response.data);
          navigator('/medicine-shop');
        }).catch(error => console.error(error));

        }
        else{
          createMedicine_shop(medicine_shop).then((response) =>{
            console.log(response.data);
            navigator('/medicine-shop');
          }).catch(error => console.error(error));
        }


    } else {
      alert('Please fill in all required fields.');
    }
  }
  
  function handleReset() {
    setShop_id(0);
    setShop_name('');
    setAddress('');
    setEmail_id('');
    setContact_number('');
    setOther_details('');
  }

  function pageTitle() {
    if (Object.keys(reg).length > 0) {
      return <h2 className='text-center'>Update Medicine Shop</h2>;
    } else {
      return <h2 className='text-center'>Add Medicine Shop</h2>;
    }
  }
  function getShop_id() {
    if (Object.keys(reg).length > 0) {
      return (
        <div className='form-group mb-2'>
              <label className='form-label'>Medicine Shop Id.: {reg.shop_id}</label>
        </div>
      );
    } else {
      return (
        <div className='form-group mb-2'>
          <label className='form-label'>Medicine  Shop Id.:<span style={{color:"red"}}>*</span></label>
          <input
            type='number'
            placeholder='Enter Shop Id. Here'
            name='shop_id'
            value={shop_id}
            className='form-control'
            onChange={(e) => setShop_id(e.target.value)}
            required
          ></input>
        </div>
      );
    }
  }
  
  return (
    <div className='container'>
      <br/><br/>
        <div className='row'>
          <div className='card col-md-6 offset-md-3 offset-md-3'>
            {pageTitle()}
            <div className='card-body'>
              <form>
                {getShop_id()}

                <div className='form-group mb-2'>
                  <label className='form-label'>Shop Name :<span style={{color:"red"}}>*</span></label>
                  <input
                      type='text'
                      placeholder='Enter shop name Here'
                      name='shop_name'
                      value={shop_name}
                      className='form-control'
                      onChange={(e)=>setShop_name(e.target.value)}
                      required
                  ></input>
                </div>

                <div className='form-group mb-2'>
                  <label className='form-label'>Address :<span style={{color:"red"}}>*</span></label>
                  <input
                      type='text'
                      placeholder='Enter Address Here'
                      name='address'
                      value={address}
                      className='form-control'
                      onChange={(e)=>setAddress(e.target.value)}
                      required
                  ></input>
                </div>

                <div className='form-group mb-2'>
                  <label className='form-label'>Contact No :<span style={{color:"red"}}>*</span></label>
                  <input
                      type='text'
                      placeholder='Enter Contact No Here'
                      name='contact_number'
                      value={contact_number}
                      className='form-control'
                      onChange={(e)=>setContact_number(e.target.value)}
                      required
                  ></input>
                </div>


                <div className='form-group mb-2'>
                  <label className='form-label'>Email Id :<span style={{color:"red"}}>*</span></label>
                  <input
                      type='text'
                      placeholder='Enter Email Id Here'
                      name='email_id'
                      value={email_id}
                      className='form-control'
                      onChange={(e)=>setEmail_id(e.target.value)}
                      required
                  ></input>
                </div>

                
                <div className='form-group mb-2'>
                  <label className='form-label'>Other Details :<span style={{color:"red"}}>*</span></label>
                  <input
                      type='text'
                      placeholder='Enter Other details Here'
                      name='other_details'
                      value={other_details}
                      className='form-control'
                      onChange={(e)=>setOther_details(e.target.value)}
                      required
                  ></input>
                </div>
                

              <button className='btn btn-success mb-2' onClick={saveOrUpdateMedicine_shop}>Submit</button>
              <span style={{ margin: '0 20px' }}></span>
              <input className="btn btn-primary mb-2" type="reset" value="Reset" onClick={handleReset}/>

              </form>
            </div>
          </div>
        </div>
    </div>
  )
}

export default MedicineShopComponent