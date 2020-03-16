
package br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.3-b02-
 * Generated source version: 2.1
 * 
 */
@WebService(name = "CadastroService", targetNamespace = "http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CadastroService {


    /**
     * 
     * @param inCadastrarPessoa
     * @return
     *     returns br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro.OutCadastrarPessoa
     */
    @WebMethod
    @WebResult(name = "outCadastrarPessoa", targetNamespace = "")
    @RequestWrapper(localName = "cadastrarPessoa", targetNamespace = "http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/", className = "br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro.CadastrarPessoa")
    @ResponseWrapper(localName = "cadastrarPessoaResponse", targetNamespace = "http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/", className = "br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro.CadastrarPessoaResponse")
    public OutCadastrarPessoa cadastrarPessoa(
        @WebParam(name = "inCadastrarPessoa", targetNamespace = "")
        InCadastrarPessoa inCadastrarPessoa);

    /**
     * 
     * @param inBuscarPessoa
     * @return
     *     returns br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro.OutBuscarPessoa
     */
    @WebMethod
    @WebResult(name = "outBuscarPessoa", targetNamespace = "")
    @RequestWrapper(localName = "buscarListPessoas", targetNamespace = "http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/", className = "br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro.BuscarListPessoas")
    @ResponseWrapper(localName = "buscarListPessoasResponse", targetNamespace = "http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/", className = "br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro.BuscarListPessoasResponse")
    public OutBuscarPessoa buscarListPessoas(
        @WebParam(name = "inBuscarPessoa", targetNamespace = "")
        InBuscarPessoa inBuscarPessoa);

    /**
     * 
     * @param inAtualizarPessoa
     * @return
     *     returns br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro.OutAtualizarPessoa
     */
    @WebMethod
    @WebResult(name = "outAtualizarPessoa", targetNamespace = "")
    @RequestWrapper(localName = "atualizarPessoa", targetNamespace = "http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/", className = "br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro.AtualizarPessoa")
    @ResponseWrapper(localName = "atualizarPessoaResponse", targetNamespace = "http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/", className = "br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro.AtualizarPessoaResponse")
    public OutAtualizarPessoa atualizarPessoa(
        @WebParam(name = "inAtualizarPessoa", targetNamespace = "")
        InAtualizarPessoa inAtualizarPessoa);

    /**
     * 
     * @param inExcluirPessoa
     * @return
     *     returns br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro.OutExcluirPessoa
     */
    @WebMethod
    @WebResult(name = "outExcluirPessoa", targetNamespace = "")
    @RequestWrapper(localName = "excluirPessoa", targetNamespace = "http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/", className = "br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro.ExcluirPessoa")
    @ResponseWrapper(localName = "excluirPessoaResponse", targetNamespace = "http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/", className = "br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro.ExcluirPessoaResponse")
    public OutExcluirPessoa excluirPessoa(
        @WebParam(name = "inExcluirPessoa", targetNamespace = "")
        InExcluirPessoa inExcluirPessoa);

    /**
     * 
     * @param inAutenticarFuncionario
     * @return
     *     returns br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro.OutAutenticarFuncionario
     */
    @WebMethod
    @WebResult(name = "outAutenticarFuncionario", targetNamespace = "")
    @RequestWrapper(localName = "autenticarFuncionario", targetNamespace = "http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/", className = "br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro.AutenticarFuncionario")
    @ResponseWrapper(localName = "autenticarFuncionarioResponse", targetNamespace = "http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/", className = "br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro.AutenticarFuncionarioResponse")
    public OutAutenticarFuncionario autenticarFuncionario(
        @WebParam(name = "inAutenticarFuncionario", targetNamespace = "")
        InAutenticarFuncionario inAutenticarFuncionario);

}
