import React, { useEffect, useState } from 'react';
import "./OrdersManagement.css";

function OrdersManagement() {
    const [sortedColumn, setSortedColumn] = useState(null);
    const [sortOrder, setSortOrder] = useState('asc');

    const orders = [
        {
            nameproduct: 'áo khoác Airism', namesender: 'Minh Anh', namereceiver: 'Phương Thanh', phonereceiver: '0912232555', phonesender: '0877781892', addressreceiver: '05 Phan Thị Ràng, Kiên Lương, Kiên Giang',
            addresssender: '82 Nghĩa Hưng, Bắc Hải, TPHCM', timesend: '07/09/2023', timereceive: '12/09/2023'
        },
    ];

    useEffect(() => {
        if (sortedColumn) {
            const sortedOrders = [...orders].sort((a, b) => {
                const aValue = a[sortedColumn];
                const bValue = b[sortedColumn];

                if (aValue < bValue) {
                    return sortOrder === 'asc' ? -1 : 1;
                } else if (aValue > bValue) {
                    return sortOrder === 'asc' ? 1 : -1;
                } else {
                    return 0;
                }
            });

            setSortOrder(sortOrder === 'asc' ? 'desc' : 'asc');
            orders.length = 0;
            orders.push(...sortedOrders);
        }
    }, [sortedColumn, sortOrder]);

    const handleSort = (column) => {
        setSortedColumn(column);
    };

    return (
        <div className="container">
            <h3>Danh sách đơn hàng</h3>
            <table className="table">
                <thead>
                    <tr>
                        <th onClick={() => handleSort('nameproduct')}>Tên món hàng</th>
                        <th onClick={() => handleSort('namesender')}>Họ tên người gửi</th>
                        <th onClick={() => handleSort('namereceiver')}>Họ tên người nhận</th>
                        <th onClick={() => handleSort('phonereceiver')}>Số điện thoại người nhận</th>
                        <th onClick={() => handleSort('phonersender')}>Số điện thoại người gửi</th>
                        <th onClick={() => handleSort('addressreceiver')}>Địa chỉ người nhận</th>
                        <th onClick={() => handleSort('addresssender')}>Địa chỉ người gửi</th>
                        <th onClick={() => handleSort('timesend')}>Thời gian gửi</th>
                        <th onClick={() => handleSort('timereceive')}>Thời gian nhận</th>
                    </tr>
                </thead>
                <tbody>
                    {orders.map((order) => (
                        <tr key={order.nameproduct}>
                            <td>{order.nameproduct}</td>
                            <td>{order.namesender}</td>
                            <td>{order.namereceiver}</td>
                            <td>{order.phonereceiver}</td>
                            <td>{order.phonesender}</td>
                            <td>{order.addressreceiver}</td>
                            <td>{order.addresssender}</td>
                            <td>{order.timesend}</td>
                            <td>{order.timereceive}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default OrdersManagement;
