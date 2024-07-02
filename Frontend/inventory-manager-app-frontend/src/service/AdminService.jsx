import axios from 'axios';
const REST_API_BASE_URL='http://localhost:8080/admin'

export const listAdmins = () => axios.get(REST_API_BASE_URL+'/');

export const createAdmin = (admin) =>axios.post(REST_API_BASE_URL+'/',admin);
  
export const updateAdmin = (admin_id,admin) =>axios.put(REST_API_BASE_URL+'/'+admin_id,admin);

export const deleteAdmin = (admin_id) => axios.delete(REST_API_BASE_URL + '/' + admin_id);

