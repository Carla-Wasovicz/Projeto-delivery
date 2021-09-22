import { useEffect, useState } from 'react';
import { fetchProdutos } from '../api';
import Instrucoes from './Instrucoes';
import ListarProdutos from './ListarProdutos';
import './styles.css';
import { Produto } from './types';
function Pedidos(){
    const [produtos, setProdutos] = useState<Produto[]>([]);

    useEffect(() => {
        fetchProdutos()
        .then(Response => setProdutos(Response.data))
        .catch(error => console.log(error));
    }, []);
    return(
        <div className="pedidos-container">
            <Instrucoes/>
            <ListarProdutos produtos={produtos}/>
        </div>
    )
}
export default Pedidos;
