import { hostNameUrl } from "../config/api";
import axios from "axios";
export const getAllSecurities = () =>{
    const securities = axios.get(`${hostNameUrl}/securities`);
    return securities;
}

