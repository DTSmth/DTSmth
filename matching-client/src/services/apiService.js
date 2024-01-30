import axios from 'axios';

const api = axios.create({
    baseURL: 'http://localhost:9000'
});

export default {
    
    list: () => api.get('/clients'),

    get: (id) => api.get(`/clients/${id}`),

    update: (id, client) => api.put(`/clients/${id}`, client),

    create: (client) => api.post('/clients', client),

    delete: (id) => api.delete(`/clients/${id}`)




}