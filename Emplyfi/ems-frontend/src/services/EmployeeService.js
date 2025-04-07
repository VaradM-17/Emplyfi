import axios from "axios";

const BASE_URL = 'http://localhost:8080/employees';

export const listEmployees = () => axios.get(`${BASE_URL}/getall`);
