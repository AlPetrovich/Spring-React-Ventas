import React, { useState } from 'react';
import { RowCliente } from './RowCliente';

export const TableClient = () => {

    const [clientesList, setClientesList] = useState([
        {
            "idCliente":1,
            "nombres": "Juan",
            "apellidos":"Perez",
            "direccion": "calle12",
            "telefono": "123123",
            "email": "juan@gmail.com"
        },
        {
            "idCliente":2,
            "nombres": "PEPE",
            "apellidos":"Perez",
            "direccion": "calle1222",
            "telefono": "123123",
            "email": "pepe@gmail.com"
        }
    ]);


  return(
    <div className='table-container'>
    <table className='table is-hoverable is-fullwidth'>
        <thead>
            <tr>
                <th>Acciones</th>
                <th>Nombres</th>
                <th>Apellidos</th>
                <th>Direccion</th>
                <th>Telefono</th>
                <th>Email</th>
            </tr>
        </thead>
        <tbody>
            {
                clientesList.map(cliente => (
                    <RowCliente cliente={ cliente } key={cliente.idCliente} />
                ))
            }
        </tbody>
    </table>
    </div>
    )
};
