import axios from "axios";

const BASE_URL = "http://localhost:8080/api/departments";

export const getAll = () => axios.get(BASE_URL);
export const getById = (id) => axios.get(`${BASE_URL}/${id}`);
export const create = (department) => axios.post(BASE_URL, department);
export const update = (id, department) => axios.put(`${BASE_URL}/${id}`, department);
export const remove = (id) => axios.delete(`${BASE_URL}/${id}`);
