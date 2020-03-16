package br.com.stefanini.web.managedbean;

import br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro.*;
import br.com.stefanini.web.acesso.CadastroAcesso;
import br.com.stefanini.web.util.Utils;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpServletResponse;

/**
 * Bean Gerenciavel correspondente a tela de Buscar Pessoa.
 * @author Robyson Ximenes
 * @created 14/03/2020 - 12:19:26 PM
 */
@ManagedBean(name = "BuscarPessoaMB")
@ViewScoped
public class BuscarPessoaMB implements Serializable {

    /**
     * Representa o serialVersionUID da classe.
     */
    private static final long serialVersionUID = 416628161507220239L;

    private String nomeEntrada;
    private String cpfEntrada;
    private String cpfEscolhido;
    private int qtd;

    private List<Pessoa> resultadoPesquisa;

    private DataModel listPessoaModal;

    private Pessoa pessoaSelecionada;
    
    public DataModel getListPessoaModal() {
        listPessoaModal = new ListDataModel(resultadoPesquisa);
        return listPessoaModal;
    }

    public void setListPessoaModal(DataModel listPessoaModal) {
        this.listPessoaModal = listPessoaModal;
    }
       /**
     * @return the resultadoPesquisa
     */
    public List<Pessoa> getResultadoPesquisa() {
        return resultadoPesquisa;
    }

    /**
     * @param resultadoPesquisa the resultadoPesquisa to set
     */
    public void setResultadoPesquisa(List<Pessoa> resultadoPesquisa) {
        this.resultadoPesquisa = resultadoPesquisa;
    }

    public String getCpfEscolhido() {
        return cpfEscolhido;
    }

    public void setCpfEscolhido(String cpfEscolhido) {
        this.cpfEscolhido = cpfEscolhido;
    }
   /**
     * @return the nomeEntrada
     */
    public String getNomeEntrada() {
        return nomeEntrada;
    }

    /**
     * @param nomeEntrada the nomeEntrada to set
     */
    public void setNomeEntrada(String nomeEntrada) {
        this.nomeEntrada = nomeEntrada;
    }

    /**
     * @return the cpfEntrada
     */
    public String getCpfEntrada() {
        return cpfEntrada;
    }

    /**
     * @param cpfEntrada the cpfEntrada to set
     */
    public void setCpfEntrada(String cpfEntrada) {
        this.cpfEntrada = cpfEntrada;
    }
    
     /**
     * @return the qtd
     */
    public int getQtd() {
        return qtd;
    }

    /**
     * @param qtd the qtd to set
     */
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
   
    public Pessoa getPessoaSelecionada() {
        return pessoaSelecionada;
    }

    public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
        this.pessoaSelecionada = pessoaSelecionada;
    }
    
    
    public void pegarPessoaSelecionada(){
        pessoaSelecionada = (Pessoa) listPessoaModal.getRowData();
    }

    public void limpar() {
        this.nomeEntrada = "";
        this.cpfEntrada = "";

    }
    
    public void deletar() {
        this.pegarPessoaSelecionada();
        InExcluirPessoa in = new InExcluirPessoa();
        in.setCpf(pessoaSelecionada.getCpf());
        
        OutExcluirPessoa out = CadastroAcesso.getInstancia().excluirPessoa(in);
        this.pesquisar();
         
        Utils.adicionarMensagem(out.getStatus().getMensagem(), FacesMessage.SEVERITY_INFO);
    }
    
    public void editar() {
        this.pegarPessoaSelecionada();
        Utils.adicionarAtributoFlash("PESSOA_SELECIONADA", pessoaSelecionada);
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        String path = context.getExternalContext().getRequestContextPath() + "/faces/pagina/manutencao/editarCadastroPessoa.xhtml";
        try {
            response.sendRedirect(path);
        } catch (IOException ex) {
            Logger.getLogger(BuscarPessoaMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void pesquisar() {
        this.setQtd(0);
        setResultadoPesquisa(new ArrayList<Pessoa>());
        InBuscarPessoa in = new InBuscarPessoa();
        in.setCpf(cpfEntrada);
        in.setNome(nomeEntrada);
        OutBuscarPessoa out = CadastroAcesso.getInstancia().buscarListPessoas(in);
        if (out != null && out.getListPessoa() != null && out.getStatus().getCodigo().equalsIgnoreCase("0001")) {
            getResultadoPesquisa().addAll(out.getListPessoa().getPessoa());
        } else {
            Utils.adicionarMensagem(out.getStatus().getMensagem(), FacesMessage.SEVERITY_INFO);
        }
        this.setQtd(getResultadoPesquisa().size());
    }
    
    public Collection<String> getPrioridadeOrdenacaoTabela() {
        Collection<String> ordem = new ArrayList<String>();
        ordem.add("coluna-nome");
        ordem.add("coluna-cpf");

        return ordem;
    }

}
