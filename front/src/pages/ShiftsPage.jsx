// src/pages/ShiftsPage.jsx
import { useEffect, useState } from 'react';
import { useSearchParams } from 'react-router-dom';
import { getAllShifts } from '../api/shiftApi';
import ShiftTable from '../components/ShiftTable';

export default function ShiftsPage() {
    const [shifts, setShifts] = useState([]);
    const [searchTerm, setSearchTerm] = useState('');
    const [searchParams, setSearchParams] = useSearchParams();
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
                {/* Top Row */}
                <div className="flex items-center justify-between mb-6">
                    <div>
                        <h1 className="text-3xl font-bold text-gray-900 tracking-tight">
                            {clientIdFilter ? 'Client Schedule' : 'Shift Board'}
                        </h1>
                    </div>
                    <div className="flex gap-3">
                        {clientIdFilter && (
                            <button
                                onClick={() => setSearchParams({})}
                                className="inline-flex items-center rounded-lg bg-white px-4 py-2 text-sm font-semibold text-gray-700 shadow-sm ring-1 ring-inset ring-gray-300 hover:bg-gray-50 transition-all"
                            >
                                Clear Client Filter
                            </button>
                        )}
                        <button className="inline-flex items-center rounded-lg bg-indigo-600 px-4 py-2 text-sm font-semibold text-white shadow-sm hover:bg-indigo-500 transition-all">
                            Post New Shift
                        </button>
                    </div>
                </div>

                {/* Search Toolbar */}
                <div className="mb-6">
                    <div className="relative max-w-md w-full">
                        <input
                            type="text"
                            className="block w-full rounded-lg border-0 py-2 px-4 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-indigo-600 sm:text-sm"
                            placeholder="Search Zipcode or Service..."
                            value={searchTerm}
                            onChange={(e) => setSearchTerm(e.target.value)}
                        />
                    </div>
                    {clientIdFilter && (
                        <p className="mt-2 text-xs text-indigo-600 font-medium italic">
                            * Filtering by specific client
                        </p>
                    )}
                </div>

                <ShiftTable shifts={displayedShifts} />
            </div>
        </div>
    );
}