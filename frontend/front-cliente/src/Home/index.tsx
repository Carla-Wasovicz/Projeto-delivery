import './styles.css';
import { ReactComponent as MainImagem} from './main.svg';
import Footer from '../Footer';
import { Link } from 'react-router-dom';

function Home(){
    return(
       <>
        <div className="home-container">
            <div className="home-content">
                <div className="home-actions">
                    <h1 className="home-title">
                         Produtos caseiros <br /> no conforto do seu lar!!!
                    </h1>
                     <h3 className="home-subtitle">
                     Escolha o seu pedido e em poucos minutos <br/>
                     chegará em seu endereço
                    </h3>
                    <Link to="/pedidos" className="home-btn-order">
                        Realizar Pedido
                    </Link>
                </div>
                <div className="home-image">
                    <MainImagem />
                </div>
            </div>
        </div>
        <Footer/>
       </>
    )
}
export default Home;