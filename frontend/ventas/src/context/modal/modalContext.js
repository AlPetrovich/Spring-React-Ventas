import React, { createContext, useState } from 'react';

export const  ModalContext = createContext();

export const MondalContextProvider = props =>{
    //states que queremos compartir con el resto de los componentes
    const [showModal, setShowModal] = useState(false);
    const [modaltTitle, setModalTitle] = useState('');

    return(
        <ModalContext.Provider value={{
            showModal,
            modaltTitle,
            setShowModal,
            setModalTitle
        }}
        >
         { props.children }
            
        </ModalContext.Provider>
    )
}
