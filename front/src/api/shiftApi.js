import { api } from './authApi';

export const getAllShifts = () =>
    api.get('/shifts');