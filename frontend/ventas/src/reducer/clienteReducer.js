import { ELIMINAR_CLIENTE, MODIFICAR_CLIENTE, OBTENER_CLIENTE, OBTENER_CLIENTES, REGISTRAR_CLIENTE } from "../components/types/actionTypes";
// const initialState = {
//     clienteList: []
// }
// dispatch({
//     type: OBTENER_CLIENTES,
//     payload: clientes
// })

export const clienteReducer = ( state , action ) => {

    switch (action.type) {
        case OBTENER_CLIENTES:
            return{
                ...state,
                clienteList: action.payload
            };
        
        case REGISTRAR_CLIENTE:
            return{
                ...state,
                clienteList :[action.payload, ...state.clienteList]
            };
        
        case OBTENER_CLIENTE:
            return{
                ...state,
                clienteActual: action.payload
            };

        case MODIFICAR_CLIENTE:
            return{
                ...state,
                clienteList: state.clienteList.map( cli =>(
                    cli.idCliente === action.payload.idCliente ? action.payload : cli
                ))
            }
        
        case ELIMINAR_CLIENTE:
            return{
                ...state,
                clienteList: state.clienteList.filter(cli =>(
                    cli.idCliente !== action.payload 
                ))
            }
        default:
            return state;
    }
}