package br.com.stefanini.web.acesso;

import br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro.*;
import br.com.stefanini.web.base.BaseAcesso;
import br.com.stefanini.web.locate.CadastroLocate;


/**
 * Stefanini 2020
 * @author Robyson Ximenes
 * Class Responsavel Pelo Acesso ao Web Service de Cadastro
 * @created 14/03/2020 - 17:58:03
 */
public class CadastroAcesso extends BaseAcesso<CadastroService, CadastroLocate> {

    /**
     * Instancia singleton da classe.
     */
    private static CadastroAcesso INSTANCIA;

    /**
     * Inicializa o mecanismo de locate da classe.
     */
    private CadastroAcesso() {
        super();
    }

    /**
     * Retorna a instância singleton da pessoa.
     * 
     * @return instância de {@link EventoAcesso}.
     */
    public static CadastroAcesso getInstancia() {
        if (INSTANCIA == null) {
            INSTANCIA = new CadastroAcesso();
        }
        return INSTANCIA;
    }

    
    public OutCadastrarPessoa cadastrarPessoa(InCadastrarPessoa inCadastrarPessoa) {
        OutCadastrarPessoa out = this.getInstanciaServico().cadastrarPessoa(inCadastrarPessoa);
        return out;
    }

    public OutBuscarPessoa buscarListPessoas(InBuscarPessoa inBuscarPessoa) {
        OutBuscarPessoa out = this.getInstanciaServico().buscarListPessoas(inBuscarPessoa);
        return out;
    }

    public OutAtualizarPessoa atualizarPessoa(InAtualizarPessoa inAtualizarPessoa) {
        OutAtualizarPessoa out = this.getInstanciaServico().atualizarPessoa(inAtualizarPessoa);
        return out;
    }

    public OutExcluirPessoa excluirPessoa(InExcluirPessoa inExcluirPessoa) {
        OutExcluirPessoa out = this.getInstanciaServico().excluirPessoa(inExcluirPessoa);
        return out;
    }

    public OutAutenticarFuncionario autenticarFuncionario(InAutenticarFuncionario inBuscarPessoa) {
        OutAutenticarFuncionario out = this.getInstanciaServico().autenticarFuncionario(inBuscarPessoa);
        return out;
    }

    @Override
    public org.apache.commons.logging.Log getLog() {
        throw new UnsupportedOperationException("------- Inicio Log --------");
    }
}
