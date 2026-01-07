import { BrowserRouter, Routes, Route, Navigate, Outlet } from 'react-router-dom';
import LoginPage from './pages/LoginPage';
import ClientsPage from './pages/ClientsPage';
import ProtectedRoute from './auth/ProtectedRoute';
import { AuthProvider } from './auth/AuthContext';
import Navbar from './components/Navbar';
import ShiftsPage from "./pages/ShiftsPage.jsx";

// 1. Create a Layout wrapper
function AppLayout() {
    return (
        <div className="min-h-screen bg-gray-50">
            <Navbar />
            <main>
                <Outlet /> {/* This is where ClientsPage/ShiftsPage will render */}
            </main>
        </div>
    );
}

function App() {
    return (
        <AuthProvider>
            <BrowserRouter>
                <Routes>
                    {/* Root redirect */}
                    <Route path="/" element={<Navigate to="/login" replace />} />

                    {/* Public Route (No Navbar) */}
                    <Route path="/login" element={<LoginPage />} />

                    {/* Protected Routes (Wrapped in Navbar) */}
                    <Route element={<ProtectedRoute><AppLayout /></ProtectedRoute>}>
                        <Route path="/clients" element={<ClientsPage />} />
                        <Route path="/shifts" element={<ShiftsPage />} />
                    </Route>

                    {/* Catch-all redirect */}
                    <Route path="*" element={<Navigate to="/clients" replace />} />
                </Routes>
            </BrowserRouter>
        </AuthProvider>
    );
}

export default App;