import { Product } from "./types";

type Props = {
    product: Product;
}
function ProductCard({product }: Props ) {
    
    return(
        <div className="order-card-container">
           <h3 className="order-card-title">
               {product.nome}
           </h3>
           
        </div>
    )
}
export default ProductCard;