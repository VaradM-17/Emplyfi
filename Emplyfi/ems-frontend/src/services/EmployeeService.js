import axios from "axios";

const BASE_URL = 'http://localhost:8080/employees';

export const listEmployees = () => axios.get(`${BASE_URL}/getall`);

export const createEmployee = (employee) => axios.post(`${BASE_URL}/create`, employee);

export const getEmployee = (employeeId) => axios.get(`${BASE_URL}/${employeeId}`);

export const updateEmployee = (employeeId, employee) => axios.put(`${BASE_URL}/updateEmployee/${employeeId}`, employee);

export const deleteEmployee = (employeeId) => axios.delete(`${BASE_URL}/deleteEmployee/${employeeId}`);