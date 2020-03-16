package br.com.stefanini.web.locate;

import br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro.CadastroService;
import br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro.CadastroService_Service;
import java.io.Serializable;


/**
 * Responsável por instânciar a classe proxy {@link CadastroService} para abstrair a comunicação com o serviço
 * GestaoLimite.
 * @author Robyson Ximenes
 * @created 13/03/2020
 */
public class CadastroLocate extends StefaniniBaseLocate<CadastroService> implements Serializable {

    /**
     * Serial version da classe.
     */
    private static final long serialVersionUID = 2895264482008454921L;

    private static final String SERVICENAME = "CadastroService";

    /**
     * Cria uma nova instância do locate.
     * 
     * @throws Exception
     *             Caso ocorra algum erro durante a inicialização do serviço.
     */
    public CadastroLocate() throws Exception {
        super();
    }

    @Override
    public CadastroService get() throws Exception {
        return new CadastroService_Service(super.getURLWSDL(SERVICENAME), super.getNameSpaceURI(SERVICENAME))
                .getCadastroServicePort();

    }
}
