import axios from 'axios';

const BASE_URL = "http://localhost:8080/api/complaints";

export const getAllComplaints = ()=> axios.get(BASE_URL);

export const createComplaint = (data) =>axios.post(BASE_URL,data);

export const assignTechnician = (id,techName) => axios.put(`${BASE_URL}/${id}/assign?technician=${techName}`);

export const updateStatus = (id, status) => axios.put(`${BASE_URL}/${id}/status?status=${status}`); 
