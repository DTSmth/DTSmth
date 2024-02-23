import axios from 'axios';



export default {
    
    listClients: () => axios.get('/clients'),

    getClient: (id) => axios.get(`/clients/${id}`),

    updateClient: (id, client) => axios.put(`/clients/${id}`, client),

    createClient: (client) => axios.post('/clients', client),

    deleteClient: (id) => axios.delete(`/clients/${id}`),

    listShifts: () => axios.get('/shifts'),

    getShift: (id) => axios.get(`/shifts/${id}`),

    updateShift: (id, shift) => axios.put(`/shifts/${id}`, shift),

    createShift: (shift) => axios.post('/shifts', shift),

    deleteShift: (id) => axios.delete(`/shifts/${id}`),

    getClientShifts: (clientId) => axios.get(`/clients/${clientId}/shifts`),

    login: (credentials) => axios.post('/login', credentials),

}