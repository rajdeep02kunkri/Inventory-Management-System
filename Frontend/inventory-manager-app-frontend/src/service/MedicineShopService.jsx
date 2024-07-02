import axios from 'axios';
const REST_API_BASE_URL='http://localhost:8080/medicine-shop'

export const listMedicine_shops = () => axios.get(REST_API_BASE_URL+'/');

export const createMedicine_shop = (medicine_shop) =>axios.post(REST_API_BASE_URL+'/',medicine_shop);
  
export const updateMedicine_shop = (shop_id,medicine_shop) =>axios.put(REST_API_BASE_URL+'/'+shop_id,medicine_shop);

export const deleteMedicine_shop = (shop_id) => axios.delete(REST_API_BASE_URL + '/' + shop_id);

