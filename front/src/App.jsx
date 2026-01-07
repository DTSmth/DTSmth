import { BrowserRouter, Routes, Route, Navigate, Outlet } from 'react-router-dom';
import { useState, useEffect } from 'react'; // Added useEffect and useState
import LoginPage from './pages/LoginPage';
import ClientsPage from './pages/ClientsPage';
import ShiftsPage from "./pages/ShiftsPage.jsx";
import ReportsPage from "./pages/ReportsPage.jsx";
import ProtectedRoute from './auth/ProtectedRoute';
import { AuthProvider, useAuth } from './auth/AuthContext';
import Navbar from './components/Navbar';
import { getAllClients } from './api/clientApi';
import { getAllShifts } from './api/shiftApi';

function AppLayout() {
    return (
        <div className="min-h-screen bg-gray-50">
            <Navbar />
            <main>
                <Outlet />
            </main>
        </div>
    );
}

function AppContent() {
    const [clients, setClients] = useState([]);
    const [shifts, setShifts] = useState([]);
    const { token } = useAuth(); // We only fetch if we have a token

    useEffect(() => {
        if (token) {
            // Fetch both at the same time
            Promise.all([getAllClients(), getAllShifts()])
                .then(([clientRes, shiftRes]) => {
                    setClients(clientRes.data);
                    setShifts(shiftRes.data);
                })
                .catch(err => console.error("Error loading app data", err));
        }
    }, [token]);

    return (
        <Routes>
            <Route path="/" element={<Navigate to="/login" replace />} />
            <Route path="/login" element={<LoginPage />} />

            <Route element={<ProtectedRoute><AppLayout /></ProtectedRoute>}>
                {/* Now we pass the data as props to the pages */}
                <Route path="/clients" element={<ClientsPage clients={clients} />} />
                <Route path="/shifts" element={<ShiftsPage shifts={shifts} />} />
                <Route path="/reports" element={<ReportsPage clients={clients} shifts={shifts} />} />
            </Route>

            <Route path="*" element={<Navigate to="/clients" replace />} />
        </Routes>
    );
}

export default function App() {
    return (
        <AuthProvider>
            <BrowserRouter>
                <AppContent />
            </BrowserRouter>
        </AuthProvider>
    );
}