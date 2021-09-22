function Instrucoes(){
    return(
        <header className="pedidos-intrucoes-container">
            <div className="pedidos-instrucoes-content">
                <h1 className="instrucoes-title">
                    Siga as <br /> instruções
                </h1>
                <ul className="instrucoes-items">
                    <li>
                        <span className="instrucoes-numero">1  </span>
                            Clique no produto para selecioná-lo a seguir escolha seu endereço.
                    </li>
                    <li>
                        <span className= "instrucoes-numero">2 </span>
                       Depois clique em <strong>"ENVIAR PEDIDO"</strong> 
                    </li>
                </ul>
            </div>
        </header>
    )
}
export default Instrucoes;
