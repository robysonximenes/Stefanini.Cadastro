package br.com.stefanini.servicos.cadastros.ejb;

import br.com.stefanini.servicos.cadastros.bean.Funcionario;
import br.com.stefanini.servicos.cadastros.bean.IN.*;
import br.com.stefanini.servicos.cadastros.bean.OUT.*;
import br.com.stefanini.servicos.cadastros.bean.Pessoa;
import br.com.stefanini.servicos.cadastros.bean.Status;
import br.com.stefanini.servicos.cadastros.bo.FuncionarioBO;
import br.com.stefanini.servicos.cadastros.bo.PessoaBO;
import br.com.stefanini.servicos.cadastros.util.Mensagens;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;


/**
 * Stefanini 2020
 * @author Ximenes
 * Date 10/03/2020
 * Class Representa Web Service de cadastro e servico como cadastrar, buscar, alterar, excluir e autenticar.
 */
@WebService(serviceName = "CadastroService",
targetNamespace = "http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/")
@Stateless
public class CadastroService {

    PessoaBO pessoaBO = new PessoaBO();
    FuncionarioBO funcionarioBO = new FuncionarioBO();
    
    /**
    * Stefanini 2020
    * @author Ximenes
    * Date 10/03/2020
    * Servico responsavel pela validacao dos dados de entrada e cadastro de pessoa.
    * @param inCadastrarPessoa
    * @return OutCadastrarPessoa
    */
    @WebResult(name = "outCadastrarPessoa")
    public OutCadastrarPessoa cadastrarPessoa (@WebParam(name = "inCadastrarPessoa") InCadastrarPessoa inCadastrarPessoa) {
        OutCadastrarPessoa out = new OutCadastrarPessoa();
        
        Status status = new PessoaBO().validarPessoa(inCadastrarPessoa.getPessoa(), Boolean.FALSE);
        if(status == null || status.getCodigo() == null || status.getCodigo().isEmpty()){
            status = new Status();
            try {
                this.pessoaBO.cadastrarPessoa(inCadastrarPessoa.getPessoa());
                status.setCodigo(Mensagens.COD_PESSOA_CADASTRADO_SUCESSO);
                status.setMensagem(Mensagens.PESSOA_CADASTRADO_SUCESSO);
                status.setTipo(Mensagens.SUCESSO);
            } catch (Exception ex) {
                Logger.getLogger(CadastroService.class.getName()).log(Level.SEVERE, null, ex);
                status.setCodigo(Mensagens.COD_ERRO_COM_SERVIDOR);
                status.setMensagem(Mensagens.ERRO_COM_SERVIDOR + " - " + ex);
                status.setTipo(Mensagens.ERRO);
                out.setStatus(status);
            }
            
        } 
        out.setStatus(status);
        return out;
    }

    /**
    * Stefanini 2020
    * @author Ximenes
    * Date 10/03/2020
    * Servico realiza a validacao dos dados de entrada e retorna com 1 ou mais pessoas, 
    * ou nenhuma pessoa se nao encontrada.
    * @param inBuscarPessoa
    * @return OutBuscarPessoa
    */
    @WebResult(name = "outBuscarPessoa")
    public OutBuscarPessoa buscarListPessoas (@WebParam(name = "inBuscarPessoa") InBuscarPessoa inBuscarPessoa) {
        OutBuscarPessoa out = new OutBuscarPessoa();
        Status status = new Status();
        try{
            List<Pessoa> listPessoa = pessoaBO.buscarListPessoa(inBuscarPessoa);
            out.setListPessoa(listPessoa);
            if (listPessoa == null || listPessoa.isEmpty()) {
                status.setCodigo(Mensagens.COD_PESSOA_NAO_LOCALIZADO);
                status.setMensagem(Mensagens.PESSOA_NAO_LOCALIZADO);
                status.setTipo(Mensagens.AVISO);
            } else {
                status.setCodigo(Mensagens.COD_SUCESSO);
                status.setMensagem(Mensagens.SUCESSO);
                status.setTipo(Mensagens.SUCESSO);
            }
        } catch (Exception e) {
            status.setCodigo(Mensagens.COD_ERRO_GENERICO);
            status.setMensagem(e.toString());
            status.setTipo(Mensagens.ERRO);
        }
        out.setStatus(status);
        return out;
     }

    /**
    * Stefanini 2020
    * @author Ximenes
    * Date 10/03/2020
    * Servico realiza a validacao dos dados de entrada e atualiza o cadastro de pessoa.
    * @param inAtualizarPessoa
    * @return OutAtualizarPessoa
    */
    @WebResult(name = "outAtualizarPessoa")
    public OutAtualizarPessoa atualizarPessoa (@WebParam(name = "inAtualizarPessoa") InAtualizarPessoa inAtualizarPessoa) {
        OutAtualizarPessoa out = new OutAtualizarPessoa();
        Status status = new PessoaBO().validarPessoa(inAtualizarPessoa.getPessoa(), Boolean.TRUE);
        if(status == null || status.getCodigo() == null || status.getCodigo().isEmpty()){
            status = new Status();
            try {
                pessoaBO.atualizarCadastroPessoa(inAtualizarPessoa.getPessoa());
                status.setCodigo(Mensagens.COD_CADASTRO_ATUALIZADO);
                status.setMensagem(Mensagens.CADASTRO_ATUALIZADO);
                status.setTipo(Mensagens.SUCESSO);
            } catch (Exception ex) {
                Logger.getLogger(CadastroService.class.getName()).log(Level.SEVERE, null, ex);
                status.setCodigo(Mensagens.COD_ERRO_COM_SERVIDOR);
                status.setMensagem(Mensagens.ERRO_COM_SERVIDOR + " - " + ex);
                status.setTipo(Mensagens.ERRO);
            }
        } else {
            status.setTipo("Alerta");
        }
        out.setStatus(status);
        return out;
    }
    
    /**
    * Stefanini 2020
    * @author Ximenes
    * Date 10/03/2020
    * Servico realiza a validacao dos dados de entrada e Exclui definitivamente o cadastro de pessoa.
    * @param inExcluirPessoa
    * @return OutExcluirPessoa
    */
    @WebResult(name = "outExcluirPessoa")
    public OutExcluirPessoa excluirPessoa (@WebParam(name = "inExcluirPessoa") InExcluirPessoa inExcluirPessoa) {
        OutExcluirPessoa out = new OutExcluirPessoa();
        Status status = new Status();
        try {
            status = pessoaBO.excluirCadastroPessoa(inExcluirPessoa.getCpf());
        } catch (Exception ex) {
            Logger.getLogger(CadastroService.class.getName()).log(Level.SEVERE, null, ex);
            status.setCodigo(Mensagens.COD_ERRO_COM_SERVIDOR);
            status.setMensagem(Mensagens.ERRO_COM_SERVIDOR + " - " + ex);
            status.setTipo(Mensagens.ERRO);
        }
        out.setStatus(status);
        return out;
    }
    
    /**
    * Stefanini 2020
    * @author Ximenes
    * Date 10/03/2020
    * Servico realiza busca do usuario e retorna se tem ou nao autorizacao de acesso.
    * @param inAutenticarFuncionario
    * @return OutAutenticarFuncionario
    */
    @WebResult(name = "outAutenticarFuncionario")
    public OutAutenticarFuncionario autenticarFuncionario (@WebParam(name = "inAutenticarFuncionario") InAutenticarFuncionario inAutenticarFuncionario) {
        OutAutenticarFuncionario out = new OutAutenticarFuncionario();
        Status status = new Status();
        Funcionario funcionario = funcionarioBO.autenticarFuncionario(inAutenticarFuncionario.getFuncionario());
        out.setFuncionario(funcionario);
        if(funcionario.getHabilitado()) {
            status.setCodigo(Mensagens.COD_SUCESSO);
            status.setMensagem(Mensagens.AUTENTICADO_COM_SUCESSO);
            status.setTipo(Mensagens.SUCESSO);
        } else {
            status.setCodigo(Mensagens.COD_FUNCIONARIO_NAO_TEM_PERMISSSAO);
            status.setMensagem(Mensagens.FUNCIONARIO_NAO_TEM_PERMISSSAO);
            status.setTipo(Mensagens.SUCESSO);
        }
        out.setStatus(status);
        return out;
     }
    
}
