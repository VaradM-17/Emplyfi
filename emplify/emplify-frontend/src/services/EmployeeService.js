import axios from "axios";

const BASE_URL = "http://localhost:8080/api/employees";

export const getAll = () => axios.get(BASE_URL);
export const getById = (id) => axios.get(`${BASE_URL}/${id}`);
export const create = (employee) => axios.post(BASE_URL, employee);
export const update = (id, employee) => axios.put(`${BASE_URL}/${id}`, employee);
export const remove = (id) => axios.delete(`${BASE_URL}/${id}`);

export const searchByName = (name) => axios.get(`${BASE_URL}/search?name=${name}`);
