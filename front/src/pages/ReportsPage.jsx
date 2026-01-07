// src/pages/ReportsPage.jsx
import { useState } from 'react';
import ReportView from '../components/ReportView';

export default function ReportsPage({ clients, shifts }) {
    const [activeReport, setActiveReport] = useState(null);

    const reportTypes = [
        {
            id: 'client-roster',
            title: 'Active Client Roster',
            columns: [
                { header: 'Full Name', render: (r) => `${r.firstName} ${r.lastName}` },
                { header: 'Address', key: 'address1' },
                { header: 'Phone', key: 'phoneNumber' },
                { header: 'Personal Care', render: (r) => r.hasPersonalCare ? 'Yes' : 'No' }
            ],
            data: clients
        },
        {
            id: 'open-shifts',
            title: 'Shift Availability Summary',
            columns: [
                { header: 'Service', render: (r) => r.service?.serviceName },
                { header: 'Zip', key: 'zipcode' },
                { header: 'Hours', key: 'totalHours' },
                { header: 'Status', render: (r) => r.available ? 'Available' : 'Filled' }
            ],
            data: shifts
        }
    ];

    return (
        <div className="py-8 px-4 sm:px-6 lg:px-8 bg-gray-100 min-h-screen">
            <div className="max-w-7xl mx-auto">
                <div className="flex justify-between items-center mb-8 print:hidden">
                    <h1 className="text-3xl font-bold text-gray-900">Reports</h1>
                    {activeReport && (
                        <button
                            onClick={() => window.print()}
                            className="bg-indigo-600 text-white px-4 py-2 rounded-lg font-semibold hover:bg-indigo-700 shadow-sm"
                        >
                            Download/Print PDF
                        </button>
                    )}
                </div>

                {/* Report Selector */}
                <div className="grid grid-cols-1 md:grid-cols-2 gap-4 mb-8 print:hidden">
                    {reportTypes.map(report => (
                        <button
                            key={report.id}
                            onClick={() => setActiveReport(report)}
                            className={`p-6 text-left rounded-xl border-2 transition-all ${
                                activeReport?.id === report.id
                                    ? 'border-indigo-600 bg-indigo-50 shadow-md'
                                    : 'border-white bg-white hover:border-gray-200 shadow-sm'
                            }`}
                        >
                            <h3 className="font-bold text-gray-900">{report.title}</h3>
                            <p className="text-sm text-gray-500">Generate a snapshot of {report.id.replace('-', ' ')}.</p>
                        </button>
                    ))}
                </div>

                {/* The Actual Report Preview */}
                {activeReport ? (
                    <ReportView
                        title={activeReport.title}
                        columns={activeReport.columns}
                        data={activeReport.data}
                    />
                ) : (
                    <div className="text-center py-20 bg-white rounded-xl border-2 border-dashed border-gray-300">
                        <p className="text-gray-400">Select a report type above to generate a preview.</p>
                    </div>
                )}
            </div>
        </div>
    );
}