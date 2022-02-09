import { createContext, useReducer } from "react";
import { ELIMINAR_CLIENTE, MODIFICAR_CLIENTE, OBTENER_CLIENTE, OBTENER_CLIENTES, REGISTRAR_CLIENTE } from "../components/types/actionTypes";
import  { clienteReducer } from "../reducer/clienteReducer";
import Axios from 'axios';

export const ClienteContext = createContext();

export const ClienteContextProvider = ( props ) =>{
    //definimos states que queremos compartir al resto de componentes
    const initialState = {
        clienteList: [],
        clienteActual: null
    }

    const [ state, dispatch ] = useReducer( clienteReducer , initialState );
   

    const obtenerClientes = async() =>{

        try{
            const resultado = await Axios.get('/clientes');
            dispatch({
                type: OBTENER_CLIENTES,
                payload: resultado.data//envia lista de clientes
            })
        }catch( error ){
            console.log(error);
        }
    }

    const registrarClientes = async(cliente)=>{

        try{
            const resultado = await Axios.post('/clientes', cliente);

            dispatch({
                type: REGISTRAR_CLIENTE,
                payload: resultado.data
            })
        }catch( error ){
            console.log(error);
        }    
    }

    const obtenerCliente = async(cliente) => {
        try {
            let clienteEncontrado = null;
            if(cliente !== null ){
                const resultado = await Axios.get(`/clientes/${cliente.idCliente}`);
                clienteEncontrado = resultado.data
            }else{
                clienteEncontrado = cliente;
            }
            dispatch({
                type : OBTENER_CLIENTE,
                payload: clienteEncontrado
            })
            
        } catch (error) {
            console.log(error)
        }
    }

    const actualizarCliente = async(cliente)=>{
        try {
            const resultado = await Axios.put(`/clientes`, cliente);

            dispatch({
                type: MODIFICAR_CLIENTE,
                payload: resultado.data,
            })
            
        } catch (error) {
            console.log(error)
        }
    }

    const eliminarCliente= async(idCliente) =>{
        try {
            await Axios.delete(`/clientes/${idCliente}`);
            
            dispatch({
                type: ELIMINAR_CLIENTE,
                payload: idCliente
            })
            
        } catch (error) {
            console.log(error)
        }
    }
    //indicar cual es el estado que queremos compartir
    return (
        <ClienteContext.Provider
            value={{
                clienteList: state.clienteList,
                clienteActual: state.clienteActual,

                obtenerClientes,
                registrarClientes,
                obtenerCliente,
                actualizarCliente,
                eliminarCliente
            }}
        >
            {/* compartimos a todos los hijos que tenga este provider */}
            { props.children } 
        </ClienteContext.Provider>
    )
}