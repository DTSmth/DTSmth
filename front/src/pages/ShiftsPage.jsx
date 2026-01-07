// src/pages/ShiftsPage.jsx
import { useEffect, useState } from 'react';
import { useSearchParams } from 'react-router-dom'; // Add this
import { getAllShifts } from '../api/shiftApi';
import ShiftTable from '../components/ShiftTable';

export default function ShiftsPage() {
    const [shifts, setShifts] = useState([]);
    const [loading, setLoading] = useState(true);
    const [searchParams, setSearchParams] = useSearchParams();

    // Get the clientId from the URL (?clientId=4)
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

    // Filter the shifts based on the URL parameter
    const displayedShifts = clientIdFilter
        ? shifts.filter(s => s.client?.clientId === parseInt(clientIdFilter))
        : shifts;

    return (
        <div className="py-8 px-4 sm:px-6 lg:px-8">
            <div className="max-w-7xl mx-auto">
                <div className="flex flex-col md:flex-row md:items-center md:justify-between mb-8">
                    <div>
                        <h1 className="text-3xl font-bold text-gray-900 tracking-tight">
                            {clientIdFilter ? 'Client Schedule' : 'Shift Board'}
                        </h1>
                        <p className="mt-1 text-sm text-gray-500">
                            {clientIdFilter
                                ? `Showing shifts for ${displayedShifts[0]?.client?.name || 'this client'}`
                                : 'Manage and assign upcoming service shifts to available staff.'
                            }
                        </p>
                    </div>

                    <div className="mt-4 md:mt-0 flex gap-2">
                        {clientIdFilter && (
                            <button
                                onClick={() => setSearchParams({})} // Clears the URL params
                                className="inline-flex items-center rounded-lg bg-white px-4 py-2 text-sm font-semibold text-gray-700 shadow-sm ring-1 ring-inset ring-gray-300 hover:bg-gray-50"
                            >
                                Show All Shifts
                            </button>
                        )}
                        <button className="inline-flex items-center rounded-lg bg-indigo-600 px-4 py-2 text-sm font-semibold text-white shadow-sm hover:bg-indigo-500">
                            Post New Shift
                        </button>
                    </div>
                </div>

                {loading ? (
                    <div className="flex justify-center items-center h-64">
                        <div className="animate-spin rounded-full h-8 w-8 border-b-2 border-indigo-600"></div>
                    </div>
                ) : (
                    <ShiftTable shifts={displayedShifts} />
                )}
            </div>
        </div>
    );
}