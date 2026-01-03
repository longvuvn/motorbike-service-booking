import axios from "axios";

export const api = axios.create({
  baseURL: process.env.REACT_APP_API_URL,
  timeout: parseInt(process.env.REACT_APP_TIMEOUT, 10),
  headers: { "Content-Type": "application/json" },
});

api.interceptors.request.use(
    (config) => {
        const token = localStorage.getItem("accessToken");
        if (token && token.trim() !== "" && token !== "undefined" && token !== "null") {
            config.headers.Authorization = `Bearer ${token}`;
        }
        return config;
    },
    (error) => {
        return Promise.reject(error);
    }
)

api.interceptors.response.use(
    (response) => {
        return response.data;
    },
    (error) => {
        const status = error.response?.status;

        if (status === 400) {
            console.log("Bad Request")
        } else if (status === 401){
            console.log("Unauthorized, please login again.")
        }else if (status >= 500) {
            console.log("Server is erroring, please try again later.")
        } 
        return Promise.reject(error);
    }
)

