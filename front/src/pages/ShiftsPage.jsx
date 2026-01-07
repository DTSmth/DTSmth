// src/pages/ShiftsPage.jsx
import { useEffect, useState } from 'react';
import { useSearchParams } from 'react-router-dom';
import { getAllShifts } from '../api/shiftApi';
import ShiftTable from '../components/ShiftTable';

export default function ShiftsPage() {
    const [shifts, setShifts] = useState([]);
    const [searchTerm, setSearchTerm] = useState('');
    const [searchParams] = useSearchParams();
    const clientIdFilter = searchParams.get('clientId');


    useEffect(() => {
        getAllShifts()
            .then(res => {
                setShifts(res.data);
                setLoading(false);
            })
            .catch(err => {
                console.error(err);
                setLoading(false);
            });
    }, []);

    const displayedShifts = shifts.filter(s => {
        // 1. Filter by Client ID (from URL)
        const matchesClient = clientIdFilter ? s.client?.clientId === parseInt(clientIdFilter) : true;

        // 2. Filter by Search Term (Zip or Service)
        const matchesSearch =
            s.zipcode.includes(searchTerm) ||
            s.service?.serviceName.toLowerCase().includes(searchTerm.toLowerCase());

        return matchesClient && matchesSearch;
    });

    return (
        <div className="py-8 px-4 sm:px-6 lg:px-8">
            <div className="max-w-7xl mx-auto">
                <div className="flex flex-col md:flex-row md:items-center md:justify-between mb-6">
                    <h1 className="text-3xl font-bold text-gray-900">Shifts</h1>

                    <div className="mt-4 md:mt-0 w-full md:w-96">
                        <input
                            type="text"
                            className="block w-full rounded-lg border-0 py-2 px-4 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm"
                            placeholder="Search by Zipcode or Service (e.g. Respite)..."
                            value={searchTerm}
                            onChange={(e) => setSearchTerm(e.target.value)}
                        />
                    </div>
                </div>

                <ShiftTable shifts={displayedShifts} />
            </div>
        </div>
    );
}