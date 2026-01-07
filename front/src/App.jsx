import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import LoginPage from './pages/LoginPage';
import ClientsPage from './pages/ClientsPage';
import ProtectedRoute from './auth/ProtectedRoute';
import { AuthProvider } from './auth/AuthContext';

function App() {
    return (
        <AuthProvider>
            <BrowserRouter>
                <Routes>
                    {/* Root redirect */}
                    <Route path="/" element={<Navigate to="/login" replace />} />

                    {/* Public */}
                    <Route path="/login" element={<LoginPage />} />

                    {/* Protected */}
                    <Route
                        path="/clients"
                        element={
                            <ProtectedRoute>
                                <ClientsPage />
                            </ProtectedRoute>
                        }
                    />
                </Routes>
            </BrowserRouter>
        </AuthProvider>
    );
}

export default App;
