import React from 'react';
import { MondalContextProvider } from '../../context/modal/modalContext';
import { Header } from './Header';
import { Menu } from './Menu';

export const Layout = ( props ) => {
  return(
      <MondalContextProvider>
        <div>
            <Header />
            <br />
            <div className='container'>
                <div className='columns'>
                        <div className='column is-one-quarter'>
                            <Menu />
                        </div>
                        <div className='column'>
                            {props.children}
                        </div>
                </div>
            </div>
        </div>
      </MondalContextProvider>
  )
};
