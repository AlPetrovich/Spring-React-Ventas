import React from 'react';
import { TableClient } from '../components/client/TableClient';
import { ToolbarCliente } from '../components/client/ToolbarCliente';
import { Layout } from '../components/common/Layout';
import { Modal } from '../components/common/Modal';

export const Clientes = () => {
  return(
      <Layout>
          <div className='panel '>
            <div className='panel-heading'>
                Clientes
            </div>
            <div className='box'>

                <ToolbarCliente />

                <TableClient />
            </div>
          </div>
          <Modal />
      </Layout>
  )
};
