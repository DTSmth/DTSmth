import { api } from './authApi';

export const getAllShifts = () => api.get('/shifts');

export const createShift = (shiftData) => api.post('/shifts', shiftData);

export const deleteShift = (id) => api.delete(`/shifts/${id}`);