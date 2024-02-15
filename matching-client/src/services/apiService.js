import axios from 'axios';

const api = axios.create({
    baseURL: 'http://localhost:9000'
});

export default {
    
    listClients: () => api.get('/clients'),

    getClient: (id) => api.get(`/clients/${id}`),

    updateClient: (id, client) => api.put(`/clients/${id}`, client),

    createClient: (client) => api.post('/clients', client),

    deleteClient: (id) => api.delete(`/clients/${id}`),

    listShifts: () => api.get('/shifts'),

    getShift: (id) => api.get(`/shifts/${id}`),

    updateShift: (id, shift) => api.put(`/shifts/${id}`, shift),

    createShift: (shift) => api.post('/shifts', shift),

    deleteShift: (id) => api.delete(`/shifts/${id}`)

}