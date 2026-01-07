import { useEffect, useState } from 'react';
import { getAllClients } from '../api/clientApi';
import ClientTable from '../components/ClientTable';

export default function ClientsPage() {
    const [clients, setClients] = useState([]);

    useEffect(() => {
        getAllClients().then(res => setClients(res.data));
    }, []);

    return (
        <div className="p-6">
            <h1 className="text-2xl font-bold mb-4">Clients</h1>
            <ClientTable clients={clients} />
        </div>
    );
}

