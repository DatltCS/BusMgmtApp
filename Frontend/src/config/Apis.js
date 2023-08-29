import axios from "axios";
import cookie from "react-cookies";

const SERVER_CONTEXT = "/Server";
const SERVER = "http://localhost:8080";


export const endpoints = {
    "buses": `${SERVER_CONTEXT}/api/buses/`,
    "login":`${SERVER_CONTEXT}/api/login/`
}

export const authApi = () => {
    return axios.create({
        baseURL: SERVER,
        headers: {
            "Authorization":  cookie.load("token")
        }
    })
}

export default axios.create({
    baseURL: SERVER
})