
package br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _BuscarListPessoasResponse_QNAME = new QName("http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/", "buscarListPessoasResponse");
    private final static QName _CadastrarPessoa_QNAME = new QName("http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/", "cadastrarPessoa");
    private final static QName _AutenticarFuncionario_QNAME = new QName("http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/", "autenticarFuncionario");
    private final static QName _CadastrarPessoaResponse_QNAME = new QName("http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/", "cadastrarPessoaResponse");
    private final static QName _ExcluirPessoaResponse_QNAME = new QName("http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/", "excluirPessoaResponse");
    private final static QName _AtualizarPessoa_QNAME = new QName("http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/", "atualizarPessoa");
    private final static QName _AtualizarPessoaResponse_QNAME = new QName("http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/", "atualizarPessoaResponse");
    private final static QName _BuscarListPessoas_QNAME = new QName("http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/", "buscarListPessoas");
    private final static QName _AutenticarFuncionarioResponse_QNAME = new QName("http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/", "autenticarFuncionarioResponse");
    private final static QName _ExcluirPessoa_QNAME = new QName("http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/", "excluirPessoa");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InCadastrarPessoa }
     * 
     */
    public InCadastrarPessoa createInCadastrarPessoa() {
        return new InCadastrarPessoa();
    }

    /**
     * Create an instance of {@link AutenticarFuncionario }
     * 
     */
    public AutenticarFuncionario createAutenticarFuncionario() {
        return new AutenticarFuncionario();
    }

    /**
     * Create an instance of {@link InExcluirPessoa }
     * 
     */
    public InExcluirPessoa createInExcluirPessoa() {
        return new InExcluirPessoa();
    }

    /**
     * Create an instance of {@link InAtualizarPessoa }
     * 
     */
    public InAtualizarPessoa createInAtualizarPessoa() {
        return new InAtualizarPessoa();
    }

    /**
     * Create an instance of {@link OutExcluirPessoa }
     * 
     */
    public OutExcluirPessoa createOutExcluirPessoa() {
        return new OutExcluirPessoa();
    }

    /**
     * Create an instance of {@link InAutenticarFuncionario }
     * 
     */
    public InAutenticarFuncionario createInAutenticarFuncionario() {
        return new InAutenticarFuncionario();
    }

    /**
     * Create an instance of {@link Funcionario }
     * 
     */
    public Funcionario createFuncionario() {
        return new Funcionario();
    }

    /**
     * Create an instance of {@link InBuscarPessoa }
     * 
     */
    public InBuscarPessoa createInBuscarPessoa() {
        return new InBuscarPessoa();
    }

    /**
     * Create an instance of {@link Pessoa }
     * 
     */
    public Pessoa createPessoa() {
        return new Pessoa();
    }

    /**
     * Create an instance of {@link OutBuscarPessoa }
     * 
     */
    public OutBuscarPessoa createOutBuscarPessoa() {
        return new OutBuscarPessoa();
    }

    /**
     * Create an instance of {@link CadastrarPessoaResponse }
     * 
     */
    public CadastrarPessoaResponse createCadastrarPessoaResponse() {
        return new CadastrarPessoaResponse();
    }

    /**
     * Create an instance of {@link OutBuscarPessoa.ListPessoa }
     * 
     */
    public OutBuscarPessoa.ListPessoa createOutBuscarPessoaListPessoa() {
        return new OutBuscarPessoa.ListPessoa();
    }

    /**
     * Create an instance of {@link BuscarListPessoasResponse }
     * 
     */
    public BuscarListPessoasResponse createBuscarListPessoasResponse() {
        return new BuscarListPessoasResponse();
    }

    /**
     * Create an instance of {@link ExcluirPessoaResponse }
     * 
     */
    public ExcluirPessoaResponse createExcluirPessoaResponse() {
        return new ExcluirPessoaResponse();
    }

    /**
     * Create an instance of {@link BuscarListPessoas }
     * 
     */
    public BuscarListPessoas createBuscarListPessoas() {
        return new BuscarListPessoas();
    }

    /**
     * Create an instance of {@link OutAtualizarPessoa }
     * 
     */
    public OutAtualizarPessoa createOutAtualizarPessoa() {
        return new OutAtualizarPessoa();
    }

    /**
     * Create an instance of {@link AtualizarPessoa }
     * 
     */
    public AtualizarPessoa createAtualizarPessoa() {
        return new AtualizarPessoa();
    }

    /**
     * Create an instance of {@link AutenticarFuncionarioResponse }
     * 
     */
    public AutenticarFuncionarioResponse createAutenticarFuncionarioResponse() {
        return new AutenticarFuncionarioResponse();
    }

    /**
     * Create an instance of {@link AtualizarPessoaResponse }
     * 
     */
    public AtualizarPessoaResponse createAtualizarPessoaResponse() {
        return new AtualizarPessoaResponse();
    }

    /**
     * Create an instance of {@link CadastrarPessoa }
     * 
     */
    public CadastrarPessoa createCadastrarPessoa() {
        return new CadastrarPessoa();
    }

    /**
     * Create an instance of {@link OutAutenticarFuncionario }
     * 
     */
    public OutAutenticarFuncionario createOutAutenticarFuncionario() {
        return new OutAutenticarFuncionario();
    }

    /**
     * Create an instance of {@link OutCadastrarPessoa }
     * 
     */
    public OutCadastrarPessoa createOutCadastrarPessoa() {
        return new OutCadastrarPessoa();
    }

    /**
     * Create an instance of {@link Status }
     * 
     */
    public Status createStatus() {
        return new Status();
    }

    /**
     * Create an instance of {@link ExcluirPessoa }
     * 
     */
    public ExcluirPessoa createExcluirPessoa() {
        return new ExcluirPessoa();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarListPessoasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/", name = "buscarListPessoasResponse")
    public JAXBElement<BuscarListPessoasResponse> createBuscarListPessoasResponse(BuscarListPessoasResponse value) {
        return new JAXBElement<BuscarListPessoasResponse>(_BuscarListPessoasResponse_QNAME, BuscarListPessoasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CadastrarPessoa }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/", name = "cadastrarPessoa")
    public JAXBElement<CadastrarPessoa> createCadastrarPessoa(CadastrarPessoa value) {
        return new JAXBElement<CadastrarPessoa>(_CadastrarPessoa_QNAME, CadastrarPessoa.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AutenticarFuncionario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/", name = "autenticarFuncionario")
    public JAXBElement<AutenticarFuncionario> createAutenticarFuncionario(AutenticarFuncionario value) {
        return new JAXBElement<AutenticarFuncionario>(_AutenticarFuncionario_QNAME, AutenticarFuncionario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CadastrarPessoaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/", name = "cadastrarPessoaResponse")
    public JAXBElement<CadastrarPessoaResponse> createCadastrarPessoaResponse(CadastrarPessoaResponse value) {
        return new JAXBElement<CadastrarPessoaResponse>(_CadastrarPessoaResponse_QNAME, CadastrarPessoaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExcluirPessoaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/", name = "excluirPessoaResponse")
    public JAXBElement<ExcluirPessoaResponse> createExcluirPessoaResponse(ExcluirPessoaResponse value) {
        return new JAXBElement<ExcluirPessoaResponse>(_ExcluirPessoaResponse_QNAME, ExcluirPessoaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AtualizarPessoa }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/", name = "atualizarPessoa")
    public JAXBElement<AtualizarPessoa> createAtualizarPessoa(AtualizarPessoa value) {
        return new JAXBElement<AtualizarPessoa>(_AtualizarPessoa_QNAME, AtualizarPessoa.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AtualizarPessoaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/", name = "atualizarPessoaResponse")
    public JAXBElement<AtualizarPessoaResponse> createAtualizarPessoaResponse(AtualizarPessoaResponse value) {
        return new JAXBElement<AtualizarPessoaResponse>(_AtualizarPessoaResponse_QNAME, AtualizarPessoaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarListPessoas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/", name = "buscarListPessoas")
    public JAXBElement<BuscarListPessoas> createBuscarListPessoas(BuscarListPessoas value) {
        return new JAXBElement<BuscarListPessoas>(_BuscarListPessoas_QNAME, BuscarListPessoas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AutenticarFuncionarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/", name = "autenticarFuncionarioResponse")
    public JAXBElement<AutenticarFuncionarioResponse> createAutenticarFuncionarioResponse(AutenticarFuncionarioResponse value) {
        return new JAXBElement<AutenticarFuncionarioResponse>(_AutenticarFuncionarioResponse_QNAME, AutenticarFuncionarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExcluirPessoa }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/", name = "excluirPessoa")
    public JAXBElement<ExcluirPessoa> createExcluirPessoa(ExcluirPessoa value) {
        return new JAXBElement<ExcluirPessoa>(_ExcluirPessoa_QNAME, ExcluirPessoa.class, null, value);
    }

}
