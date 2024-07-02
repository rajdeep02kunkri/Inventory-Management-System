import React, { useState } from 'react';
import { createAdmin, updateAdmin } from '../service/AdminService';
import { useNavigate, useParams } from 'react-router-dom';

const AdminComponent = () => {
  const [admin_id, setAdmin_id] = useState(0);
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [email_id, setEmail_id] = useState('');
  const [contact_number, setContact_number] = useState('');
  const [other_details, setOther_details] = useState('');


  const navigator = useNavigate();
  const reg = useParams();
  
  
  function saveOrUpdateAdmin(e) {
    e.preventDefault();
    const flag1=admin_id && username && password && email_id && contact_number && other_details;
    const flag2= username && password && email_id && contact_number && other_details;
    const flag3=Object.keys(reg).length > 0;


    if (flag1 || (flag2 && flag3)) {
      const admin = { admin_id,username,password,email_id,contact_number,other_details };
      console.log(admin);

      if(flag3){
        updateAdmin(reg.admin_id,admin).then((response) =>{
          console.log(response.data);
          navigator('/admin');
        }).catch(error => console.error(error));

        }
        else{
          createAdmin(admin).then((response) =>{
            console.log(response.data);
            navigator('/admin');
          }).catch(error => console.error(error));
        }


    } else {
      alert('Please fill in all required fields.');
    }
  }
  
  function handleReset() {
    setAdmin_id(0);
    setUsername('');
    setPassword('');
    setEmail_id('');
    setContact_number('');
    setOther_details('');
  }

  function pageTitle() {
    if (Object.keys(reg).length > 0) {
      return <h2 className='text-center'>Update Admin</h2>;
    } else {
      return <h2 className='text-center'>Add Admin</h2>;
    }
  }
  function getId() {
    if (Object.keys(reg).length > 0) {
      return (
        <div className='form-group mb-2'>
              <label className='form-label'>Admin Id.: {reg.admin_id}</label>
        </div>
      );
    } else {
      return (
        <div className='form-group mb-2'>
          <label className='form-label'>Admin Id.:<span style={{color:"red"}}>*</span></label>
          <input
            type='number'
            placeholder='Enter Id. Here'
            name='admin_id'
            value={admin_id}
            className='form-control'
            onChange={(e) => setAdmin_id(e.target.value)}
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
                {getId()}

                <div className='form-group mb-2'>
                  <label className='form-label'>Username :<span style={{color:"red"}}>*</span></label>
                  <input
                      type='text'
                      placeholder='Enter Username Here'
                      name='username'
                      value={username}
                      className='form-control'
                      onChange={(e)=>setUsername(e.target.value)}
                      required
                  ></input>
                </div>

                <div className='form-group mb-2'>
                  <label className='form-label'>Password :<span style={{color:"red"}}>*</span></label>
                  <input
                      type='text'
                      placeholder='Enter Password Here'
                      name='password'
                      value={password}
                      className='form-control'
                      onChange={(e)=>setPassword(e.target.value)}
                      required
                  ></input>
                </div>

                <div className='form-group mb-2'>
                  <label className='form-label'>Email Id :<span style={{color:"red"}}>*</span></label>
                  <input
                      type='text'
                      placeholder='Enter Email admin_id Here'
                      name='email_id'
                      value={email_id}
                      className='form-control'
                      onChange={(e)=>setEmail_id(e.target.value)}
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
                

              <button className='btn btn-success mb-2' onClick={saveOrUpdateAdmin}>Submit</button>
              <span style={{ margin: '0 20px' }}></span>
              <input className="btn btn-primary mb-2" type="reset" value="Reset" onClick={handleReset}/>

              </form>
            </div>
          </div>
        </div>
    </div>
  )
}

export default AdminComponent