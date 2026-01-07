import { useEffect, useState } from 'react';
import { getAllShifts } from '../api/shiftApi'; // Assuming this exists
import ShiftTable from '../components/ShiftTable';

export default function ShiftsPage() {
    const [shifts, setShifts] = useState([]);
    const [loading, setLoading] = useState(true);

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

    return (
        <div className="py-8 px-4 sm:px-6 lg:px-8">
            <div className="max-w-7xl mx-auto">
                <div className="flex flex-col md:flex-row md:items-center md:justify-between mb-8">
                    <div>
                        <h1 className="text-3xl font-bold text-gray-900 tracking-tight">Shift Board</h1>
                        <p className="mt-1 text-sm text-gray-500">
                            Manage and assign upcoming service shifts to available staff.
                        </p>
                    </div>

                    <button className="mt-4 md:mt-0 inline-flex items-center justify-center rounded-lg bg-indigo-600 px-4 py-2.5 text-sm font-semibold text-white shadow-sm hover:bg-indigo-500 transition-all">
                        Post New Shift
                    </button>
                </div>

                {loading ? (
                    <div className="flex justify-center items-center h-64">
                        <div className="animate-spin rounded-full h-8 w-8 border-b-2 border-indigo-600"></div>
                    </div>
                ) : (
                    <ShiftTable shifts={shifts} />
                )}
            </div>
        </div>
    );
}