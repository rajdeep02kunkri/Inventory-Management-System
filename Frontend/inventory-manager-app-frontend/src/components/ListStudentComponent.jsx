import React,{useEffect, useState} from 'react'
import {deleteStudent, listStudents} from '../service/StudentService'
import { useNavigate } from 'react-router-dom';

const ListStudentComponent = () => {
    const [students,setStudents] =useState([]);
    const navigator= useNavigate();

    useEffect(() => {
        getAllStudents();
    },[])


    function getAllStudents(){
        listStudents().then((response) =>{
            setStudents(response.data);
        }).catch(error => console.error(error));
    }

    function addNewStudent(){
        navigator("/add-student")
        
    }
    function updateStudent(clgRegNo){
        navigator(`/edit-student/${clgRegNo}`);
    }
    function removeStudent(clgRegNo){
        console.log(clgRegNo)
        //navigator(`/delete-student/${clgRegNo}`);
        deleteStudent(clgRegNo).then((response)=>{
            getAllStudents();

        }).catch(error =>
            console.error(error)
        )
    }
    
  return (
    <div className='container'>
        <h2 className='text-center'>List of Students</h2>
        <button className="btn btn-secondary mb-2" onClick={addNewStudent}>Add Student</button>
        <table className='table table-striped table-bordered'>
            <thead>
                <tr>
                <th>College Registhation No.</th>
                <th>Name</th>
                <th>Date of Birth</th>
                <th>Address</th>
                <th>Email Id</th>
                <th>Mobile No.</th>
                <th>Department</th>
                <th>Semester No.</th>
                <th>Year</th>
                <th>Roll No.</th>
                <th>Marks-1</th>
                <th>Marks-2</th>
                <th>Marks-3</th>
                <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                {
                    students.map(student =>
                        <tr key={student.clgRegNo}>
                            <td>{student.clgRegNo}</td>
                            <td>{student.name}</td>
                            <td>{student.dob}</td>
                            <td>{student.address}</td>
                            <td>{student.emailId}</td>
                            <td>{student.mobileNo}</td>
                            <td>{student.dept}</td>
                            <td>{student.semNo}</td>
                            <td>{student.year}</td>
                            <td>{student.rollNo}</td>
                            <td>{student.marks1}</td>
                            <td>{student.marks2}</td>
                            <td>{student.marks3}</td>
                            <td>
                                <div style={{ display: 'flex' }}>
                                    <button className='btn btn-info' onClick={() => updateStudent(student.clgRegNo)}>Update</button>
                                    <span style={{ margin: '0 10px' }}></span>
                                    <button className='btn btn-danger' onClick={() => removeStudent(student.clgRegNo)}>Delete</button>
                                </div>
                            </td>

                        </tr>
                    )
                }
            </tbody>
        </table>
    </div>
  )
}

export default ListStudentComponent