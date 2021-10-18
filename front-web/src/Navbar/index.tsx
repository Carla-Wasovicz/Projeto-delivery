import { Link } from 'react-router-dom';
import './styles.css'
function Navbar( ) {
    return(
        <nav className="main-navbar">
          <Link to="/" className="logo-text">BEM VINDO AOS PRODUTOS CASEIROS DA NANDA!!</Link>
        </nav>
    )
}
export default Navbar;