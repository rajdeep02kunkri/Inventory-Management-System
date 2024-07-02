import React, { useState } from 'react';
import { createStudent, updateStudent } from '../service/StudentService';
import { useNavigate, useParams } from 'react-router-dom';

const StudentComponent = () => {
  const [clgRegNo, setClgRegNo] = useState('');
  const [name, setName] = useState('');
  const currentDate = new Date().toISOString().split('T')[0];
  const [dob, setDob] = useState(currentDate);
  const [address, setAddress] = useState('');
  const [emailId, setEmailId] = useState('');
  const [mobileNo, setMobileNo] = useState('');
  const [dept, setDept] = useState('');
  const [semNo, setSemNo] = useState(1);
  const [year, setYear] = useState(1);
  const [rollNo, setRollNo] = useState(1);
  const [marks1, setMarks1] = useState(0.0);
  const [marks2, setMarks2] = useState(0.0);
  const [marks3, setMarks3] = useState(0.0);

  const navigator = useNavigate();
  const reg = useParams();
  
  
  function saveOrUpdateStudent(e) {
    e.preventDefault();
    const flag1=clgRegNo && name && dob && address && emailId && mobileNo && dept && semNo && year && rollNo && marks1 && marks2 && marks3;
    const flag2=name && dob && address && emailId && mobileNo && dept && semNo && year && rollNo && marks1 && marks2 && marks3;
    const flag3=Object.keys(reg).length > 0;


    if (flag1 || (flag2 && flag3)) {
      const stcetStudent = { clgRegNo, name, dob, address, emailId, mobileNo, dept, semNo, year, rollNo, marks1, marks2, marks3 };
      console.log(stcetStudent);

      if(flag3){
        updateStudent(reg.clgRegNo,stcetStudent).then((response) =>{
          console.log(response.data);
          navigator('/students');
        }).catch(error => console.error(error));

        }
        else{
          createStudent(stcetStudent).then((response) =>{
            console.log(response.data);
            navigator('/students');
          }).catch(error => console.error(error));
        }


    } else {
      alert('Please fill in all required fields.');
    }
  }
  
  function handleReset() {
    setClgRegNo('');
    setAddress('');
    const currentDate = new Date().toISOString().split('T')[0];
    setDob(currentDate);
    setMarks1(0.0);
    setMarks2(0.0);
    setMarks3(0.0);
    setMobileNo('');
    setName('');
    setEmailId('');
    setDept('');
    setYear(1);
    setSemNo(1);
    setRollNo(1);
  }

  function pageTitle() {
    if (Object.keys(reg).length > 0) {
      return <h2 className='text-center'>Update Student</h2>;
    } else {
      return <h2 className='text-center'>Add Student</h2>;
    }
  }
  function getClgRegNo() {
    if (Object.keys(reg).length > 0) {
      return (
        <div className='form-group mb-2'>
              <label className='form-label'>College Registration No.: {reg.clgRegNo}<span style={{color:"red"}}>*</span></label>
        </div>
      );
    } else {
      return (
        <div className='form-group mb-2'>
          <label className='form-label'>College Registration No.:<span style={{color:"red"}}>*</span></label>
          <input
            type='text'
            placeholder='Enter College Reg. No. Here'
            name='clgRegNo'
            value={clgRegNo}
            className='form-control'
            onChange={(e) => setClgRegNo(e.target.value)}
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
                {getClgRegNo()}

                <div className='form-group mb-2'>
                  <label className='form-label'>Name :<span style={{color:"red"}}>*</span></label>
                  <input
                      type='text'
                      placeholder='Enter Student Name Here'
                      name='name'
                      value={name}
                      className='form-control'
                      onChange={(e)=>setName(e.target.value)}
                      required
                  ></input>
                </div>


                <div className='form-group mb-2'>
                  <label className='form-label'>Select Date of Birth :<span style={{color:"red"}}>*</span></label>
                  <input
                      type='date'
                      placeholder='Date of Birth Here'
                      name='dob'
                      value={dob}
                      className='form-control'
                      onChange={(e)=>setDob(e.target.value)}
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
                  <label className='form-label'>Email Id :<span style={{color:"red"}}>*</span></label>
                  <input
                      type='email'
                      placeholder='Enter Email Id Here'
                      name='emailId'
                      value={emailId}
                      className='form-control'
                      onChange={(e)=>setEmailId(e.target.value)}
                      required
                  ></input>
                </div>

                <div className='form-group mb-2'>
                  <label className='form-label'>Mobile No. :<span style={{color:"red"}}>*</span></label>
                  <input
                      type='text'
                      pattern='[0-9]{10}'
                      maxLength={10}
                      minLength="10"
                      placeholder='Enter Mobile No. Here'
                      name='mobileNo'
                      value={mobileNo}
                      className='form-control'
                      onChange={(e)=>setMobileNo(e.target.value)}
                      required
                  ></input>
                </div>

                <div className='form-group mb-2'>
                <label className='form-label'>
                  Department :<span style={{ color: 'red' }}>*</span>
                </label>
                <select
                  name='dept'
                  value={dept}
                  className='form-control'
                  onChange={(e)=>setDept(e.target.value)}
                  required
                >
                  <option value=''>Select Department</option>
                  <option value='CSE'>CSE</option>
                  <option value='IT'>IT</option>
                  <option value='EE'>EE</option>
                  <option value='ECE'>ECE</option>
                  <option value='AIML'>AIML</option>
                </select>
              </div>

                <div className='form-group mb-2'>
                  <label className='form-label'>Semester No. :<span style={{color:"red"}}>*</span></label>
                  <input
                      type='number'
                      placeholder='Enter Semester No. Here'
                      name='semNo'
                      max={8}
                      min={1}
                      value={semNo}
                      className='form-control'
                      onChange={(e)=>setSemNo(e.target.value)}
                      required
                  ></input>
                </div>

                <div className='form-group mb-2'>
                  <label className='form-label'> Current Year of Study :<span style={{color:"red"}}>*</span></label>
                  <input
                      type='number'
                      placeholder='Enter Year No. Here'
                      name='year'
                      max={4}
                      min={1}
                      value={year}
                      className='form-control'
                      onChange={(e)=>setYear(e.target.value)}
                      required
                  ></input>
                </div>


                <div className='form-group mb-2'>
                  <label className='form-label'>Roll No. :<span style={{color:"red"}}>*</span></label>
                  <input
                      type='number'
                      placeholder='Enter Roll No. Here'
                      name='rollNo'
                      min={1}
                      value={rollNo}
                      className='form-control'
                      onChange={(e)=>setRollNo(e.target.value)}
                      required
                  ></input>
                </div>

                <div className='form-group mb-2'>
                  <label className='form-label'>Marks of the 1st Subject. :<span style={{color:"red"}}>*</span></label>
                  <input
                      type='number'
                      placeholder='Enter Marks Here'
                      name='marks1'
                      min={0}
                      max={100}
                      step={0.01}
                      value={marks1}
                      className='form-control'
                      onChange={(e)=>setMarks1(e.target.value)}
                      required
                  ></input>
                </div>

                <div className='form-group mb-2'>
                  <label className='form-label'>Marks of the 2nd Subject. :<span style={{color:"red"}}>*</span></label>
                  <input
                      type='number'
                      placeholder='Enter Marks Here'
                      name='marks2'
                      min={0}
                      max={100}
                      step={0.01}
                      value={marks2}
                      className='form-control'
                      onChange={(e)=>setMarks2(e.target.value)}
                      required
                  ></input>
                </div>

                
                <div className='form-group mb-2'>
                  <label className='form-label'>Marks of the 3rd Subject. :<span style={{color:"red"}}>*</span></label>
                  <input
                      type='number'
                      placeholder='Enter Marks Here'
                      name='marks3'
                      min={0}
                      max={100}
                      step={0.01}
                      value={marks3}
                      className='form-control'
                      onChange={(e)=>setMarks3(e.target.value)}
                      required
                  ></input>
                </div>

              <button className='btn btn-success mb-2' onClick={saveOrUpdateStudent}>Submit</button>
              <span style={{ margin: '0 20px' }}></span>
              <input className="btn btn-primary mb-2" type="reset" value="Reset" onClick={handleReset}/>

              </form>
            </div>
          </div>
        </div>
    </div>
  )
}

export default StudentComponent