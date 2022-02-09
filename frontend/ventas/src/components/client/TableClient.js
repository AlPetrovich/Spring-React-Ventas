import React, { useContext, useEffect } from 'react';
import { ClienteContext } from '../../context/clienteContext';
import { RowCliente } from './RowCliente';

export const TableClient = () => {

    const { clienteList, obtenerClientes } = useContext(ClienteContext);

    useEffect(()=>{
        obtenerClientes();
        //eslint-disable-next-line
    }, []);
    
    if(clienteList.length === 0) return <center><p>No existen clientes.</p></center>

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
            {/* Row cliente dibuja cada una de las filas de la tabla de cliente */}
            {
                clienteList.map(cliente => (
                    <RowCliente cliente={ cliente } key={cliente.idCliente} />
                ))
            }
        </tbody>
    </table>
    </div>
    )
};
