import { Produto } from "./types";
import CardProduto from "./CardProduto";

type Props = {
    produtos: Produto[];
}

function ListarProdutos({produtos}: Props){
    return(
        <div className="pedidos-list-container">
            <div className="pedidos-list-items">
               {produtos.map(produto => (
                    <CardProduto key={produto.id} produto={produto}/>
               ))}
            </div>
        </div>
    )
}
export default ListarProdutos;
