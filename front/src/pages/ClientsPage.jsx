import { useEffect, useState } from 'react';
import { getAllClients } from '../api/clientApi';
import ClientTable from '../components/ClientTable';

// Simple icon component for the button (optional)
const PlusIcon = () => (
    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth={2} stroke="currentColor" className="w-5 h-5">
        <path strokeLinecap="round" strokeLinejoin="round" d="M12 4.5v15m7.5-7.5h-15" />
    </svg>
);

export default function ClientsPage() {
    const [clients, setClients] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        getAllClients()
            .then(res => {
                setClients(res.data);
                setLoading(false);
            })
            .catch(err => {
                console.error(err);
                setLoading(false);
            });
    }, []);

    return (
        <div className="min-h-screen bg-gray-50 py-8 px-4 sm:px-6 lg:px-8">
            <div className="max-w-7xl mx-auto">
                {/* Header Section */}
                <div className="flex flex-col md:flex-row md:items-center md:justify-between mb-8">
                    <div>
                        <h1 className="text-3xl font-bold text-gray-900 tracking-tight">Clients</h1>
                        <p className="mt-1 text-sm text-gray-500">
                            A list of all clients currently in the system including their care requirements.
                        </p>
                    </div>

                    <div className="mt-4 md:mt-0 flex items-center gap-3">
                        <span className="text-sm font-medium text-gray-500 bg-white border border-gray-200 px-3 py-2 rounded-lg shadow-sm">
                            Total: {clients.length}
                        </span>
                        <button className="inline-flex items-center gap-2 rounded-lg bg-indigo-600 px-4 py-2 text-sm font-semibold text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600 transition-all">
                            <PlusIcon />
                            Add Client
                        </button>
                    </div>
                </div>

                {/* Main Content Area */}
                {loading ? (
                    <div className="flex justify-center items-center h-64">
                        <div className="animate-spin rounded-full h-8 w-8 border-b-2 border-indigo-600"></div>
                    </div>
                ) : (
                    <div className="bg-white rounded-xl shadow-sm ring-1 ring-gray-900/5">
                        <ClientTable clients={clients} />
                    </div>
                )}
            </div>
        </div>
    );
}