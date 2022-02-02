import React from 'react';
import { FormCliente } from '../components/client/FormCliente';
import { TableClient } from '../components/client/TableClient';
import { ToolbarCliente } from '../components/client/ToolbarCliente';
import { Layout } from '../components/common/Layout';
import { Modal } from '../components/common/Modal';
import { ClienteContextProvider } from '../context/clienteContext';

export const Clientes = () => {
  return(
      <Layout>

          <ClienteContextProvider> 

            <div className='panel '>
                <div className='panel-heading'>
                    Clientes
                </div>
                <div className='box'>

                    <ToolbarCliente />

                    <TableClient />
                </div>
            </div>
            <Modal>

                <FormCliente />
                
            </Modal>

          </ClienteContextProvider>

      </Layout>
  )
};
