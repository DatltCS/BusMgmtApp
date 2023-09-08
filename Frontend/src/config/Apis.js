import axios from "axios";
import cookie from "react-cookies";

const SERVER_CONTEXT = "/Server";
const SERVER = "http://localhost:8080";


export const endpoints = {
    "buses": `${SERVER_CONTEXT}/api/buses/`,
    "login":`${SERVER_CONTEXT}/api/login/`,
    "register":`${SERVER_CONTEXT}/api/users/`,
    "bustrips":`${SERVER_CONTEXT}/api/bustrips/`,
    "current-user": `${SERVER_CONTEXT}/api/current-user/`,
    "comments": (tripId) => `${SERVER_CONTEXT}/api/bustrips/${tripId}/comments/`,
    "details": (tripId) => `${SERVER_CONTEXT}/api/bustrips/${tripId}/`,
    "add-comment": `${SERVER_CONTEXT}/api/comments/`,
}

export const authApi = () => {
    return axios.create({
        baseURL: SERVER,
        headers: {
            "Authorization":  cookie.load("token"),
            
        }
    })
}

export default axios.create({
    baseURL: 'http://localhost:8080',
    headers: {
        "Authorization":  cookie.load("token"),
        
    }
})