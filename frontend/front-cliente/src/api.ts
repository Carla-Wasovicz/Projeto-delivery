import axios from "axios";


const API_URL = 'http://localhost:8081';
export function fetchProdutos(){
    return axios(`${API_URL}/produtos`)
}