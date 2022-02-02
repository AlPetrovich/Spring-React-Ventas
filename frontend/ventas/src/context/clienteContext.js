import { createContext, useReducer } from "react";
import { OBTENER_CLIENTES } from "../components/types/actionTypes";
import  ClienteRedurcer from "../reducer/clienteReducer";


export const ClienteContext = createContext();

export const ClienteContextProvider = ( props ) =>{
    //definimos states que queremos compartir al resto de componentes
    const initialState = {
        clienteList: []
    }

    const [ state, dispatch ] = useReducer( ClienteRedurcer , initialState );
    const { clienteList } = state;

    const obtenerClientes = () =>{
        const clientes =[
            {
                "idCliente":1,
                "nombres":"Alexis",
                "apellidos":"Petrovich",
                "direccion":"Calle 12",
                "telefono": "341283212",
                "email": "alexispetro@gmail.com"
            }
        ]

        dispatch({
            type: OBTENER_CLIENTES,
            payload: clientes
        })
    }

    //indicar cual es el estado que queremos compartir
    return (
        <ClienteContext.Provider
            value={{
                clienteList 
            }}
        >
            {/* compartimos a todos los hijos que tenga este provider */}
            { props.children } 
        </ClienteContext.Provider>
    )
}