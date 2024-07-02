import axios from 'axios';
const REST_API_BASE_URL='http://localhost:8080/students'

export const listStudents = () => axios.get(REST_API_BASE_URL);

export const createStudent = (student) =>axios.post(REST_API_BASE_URL,student);
  
export const updateStudent = (clgRegNo,student) =>axios.put(REST_API_BASE_URL+'/'+clgRegNo,student);

export const deleteStudent = (clgRegNo) => axios.delete(REST_API_BASE_URL + '/' + clgRegNo);

