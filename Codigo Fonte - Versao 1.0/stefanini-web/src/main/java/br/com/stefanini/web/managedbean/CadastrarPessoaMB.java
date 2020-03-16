package br.com.stefanini.web.managedbean;

import br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro.InCadastrarPessoa;
import br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro.OutCadastrarPessoa;
import br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro.Pessoa;
import br.com.stefanini.web.acesso.CadastroAcesso;
import br.com.stefanini.web.util.Utils;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Bean Gerenciavel correspondente a tela de Cadastrar Pessoa.
 * @author Robyson Ximenes
 * @created 14/03/2020 - 12:19:26 PM
 */
@ManagedBean(name = "CadastrarPessoaMB")
@ViewScoped
public class CadastrarPessoaMB implements Serializable {
    
    /**
     * Representa o serialVersionUID da classe.
     */
    private static final long serialVersionUID = 416628161346728341L;

    private String nome;
    private String cpf;
    private String sexo;
    private String email;
    private String dtNascimento;
    private String naturalidade;
    private String nacionalidade;
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(String dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public void limpar() {
        this.nome = "";
        this.cpf = "";
        this.sexo = "";
        this.email = "";
        this.dtNascimento = "";
        this.naturalidade = "";
        this.nacionalidade = "";
    }
    
    public void salvarPessoa() {
        InCadastrarPessoa in = new InCadastrarPessoa();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nome);
        pessoa.setCpf(cpf);
        pessoa.setSexo(sexo);
        pessoa.setEmail(email);
        pessoa.setDtNascimento(dtNascimento);
        pessoa.setNaturalidade(naturalidade);
        pessoa.setNacionalidade(nacionalidade);
        in.setPessoa(pessoa);
        OutCadastrarPessoa out = CadastroAcesso.getInstancia().cadastrarPessoa(in);
        if (out != null && out.getStatus() != null) {
            Utils.adicionarMensagem(out.getStatus().getMensagem(), FacesMessage.SEVERITY_INFO);
            if(out.getStatus().getCodigo().equalsIgnoreCase("CPCS002")) {
               this.limpar(); 
            }
        } else {
            Utils.adicionarMensagem("Erro no Serviço.", FacesMessage.SEVERITY_ERROR);
        }

    }
    
}
