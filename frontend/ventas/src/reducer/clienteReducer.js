import { OBTENER_CLIENTES } from "../components/types/actionTypes";
export default ( state , action ) => {

    switch (action.type) {
        case OBTENER_CLIENTES:
            return{
                ...state,
                clientesList: action.payload
            };
            
        default:
            return state;
    }
}