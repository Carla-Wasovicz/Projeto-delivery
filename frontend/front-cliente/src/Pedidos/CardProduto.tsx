import { Produto } from './types';

type Props = {
    produto : Produto;
}

function formatarPreco(preco: number){
    const formatar = new Intl.NumberFormat('pt-BR',{
        style: 'currency',
        currency: 'BRL',
        minimumFractionDigits: 2
    });
    return formatar.format(preco);
}

function CardProduto({ produto }: Props){
    return(
        <div className="pedido-card-container">
            <h3 className="pedido-card-title">
                {produto.nome}
            </h3>
            <img src={produto.imagem} 
            className="pedido-card-image"
            alt={produto.nome}
            />
            <h3 className="pedido-card-prince">
                 {formatarPreco(produto.preco)}
            </h3>
            <div className="pedido-card-description">
                <h3>Descrição</h3>
                <p>{ produto.descricao}</p>

            </div>
        </div>
    )
}
export default CardProduto;
