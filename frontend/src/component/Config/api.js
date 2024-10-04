import axios from "axios";

// Update the API URL if needed
export const API_URL = "http://localhost:5454";

// Create an Axios instance with default configurations
export const api = axios.create({
    baseURL: API_URL,
    headers: {
        "Content-Type": "application/json",
        // Optionally add Authorization header if needed
        // "Authorization": `Bearer ${token}`, // Uncomment and replace token with your JWT token if required
    },
});
axios.post('http://localhost:8080/auth/signin', {
    email: "test@example.com",
    password: "password123"
}, { withCredentials: true })
.then(response => {
    console.log(response.data);
})
.catch(error => {
    console.error(error);
});
// Optional: Add a request interceptor to attach authorization headers if needed
api.interceptors.request.use(
    (config) => {
        const token = localStorage.getItem("token"); // or wherever you store your token
        if (token) {
            config.headers.Authorization = `Bearer ${token}`;
        }
        return config;
    },
    (error) => {
        return Promise.reject(error);
    }
);
