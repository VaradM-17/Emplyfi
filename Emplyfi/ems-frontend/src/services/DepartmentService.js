import axios from "axios";

const BASE_URL = 'http://localhost:8080/departments';

export const listDepartments = () => axios.get(`${BASE_URL}/getAllDepartments`);

export const createDepartment = (department) => axios.post(`${BASE_URL}/create`, department);

export const getDepartmentById = (departmentId) => axios.get(`${BASE_URL}/getDepartmentById/${departmentId}`);

export const updateDepartment = (departmentId, department) => axios.put(`${BASE_URL}/updateDepartment/${departmentId}`, department);

export const deleteDepartment = (departmentId) => axios.delete(`${BASE_URL}/deleteDepartment/${departmentId}`);
