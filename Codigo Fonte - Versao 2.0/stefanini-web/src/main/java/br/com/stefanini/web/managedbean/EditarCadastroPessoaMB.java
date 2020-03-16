package br.com.stefanini.web.managedbean;

import br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro.InAtualizarPessoa;
import br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro.OutAtualizarPessoa;
import br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro.Pessoa;
import br.com.stefanini.web.acesso.CadastroAcesso;
import br.com.stefanini.web.util.Utils;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

/**
 * Bean Gerenciavel correspondente a tela de Buscar Pessoa.
 * @author Robyson Ximenes
 * @created 14/03/2020 - 12:19:26 PM
 */
@ManagedBean(name = "EditarCadastroPessoaMB")
@ViewScoped
public class EditarCadastroPessoaMB implements Serializable {
    
    /**
     * Representa o serialVersionUID da classe.
     */
    private static final long serialVersionUID = 356628126746728147L;

    private String nome = "";
    private String cpf = "";
    private String sexo = "";
    private String email = "";
    private String dtNascimento = "";
    private String naturalidade = "";
    private String nacionalidade = "";
//    Inicio - Inclusao campo de Endereco - 15/03/2020 - robyson.ximenes - Versão 2.0
    private String endereco;

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
//    Fim - Inclusao campo de Endereco - 15/03/2020 - robyson.ximenes - Versão 2.0
    
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
    
    public EditarCadastroPessoaMB(){
        Pessoa pessoaRecuperada = Utils.getAtributoFlash("PESSOA_SELECIONADA", Pessoa.class);
        this.nome = pessoaRecuperada.getNome();
        this.cpf = pessoaRecuperada.getCpf();
        this.sexo = pessoaRecuperada.getSexo();
        this.email = pessoaRecuperada.getEmail();
        this.dtNascimento = pessoaRecuperada.getDtNascimento();
        this.naturalidade = pessoaRecuperada.getNaturalidade();
        this.nacionalidade = pessoaRecuperada.getNacionalidade();
        //    Inicio - Inclusao campo de Endereco - 15/03/2020 - robyson.ximenes - Versão 2.0
        this.endereco = pessoaRecuperada.getEndereco();
        //    FIM - Inclusao campo de Endereco - 15/03/2020 - robyson.ximenes - Versão 2.0
    }
    
    public void limpar() {
        this.nome = "";
        this.cpf = "";
        this.sexo = "";
        this.email = "";
        this.dtNascimento = "";
        this.naturalidade = "";
        this.nacionalidade = "";
        //    Inicio - Inclusao campo de Endereco - 15/03/2020 - robyson.ximenes - Versão 2.0
        this.endereco = "";
        //    FIM - Inclusao campo de Endereco - 15/03/2020 - robyson.ximenes - Versão 2.0
    }
    
    public void salvarPessoa() {
        InAtualizarPessoa in = new InAtualizarPessoa();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nome);
        pessoa.setCpf(cpf);
        pessoa.setSexo(sexo);
        pessoa.setEmail(email);
        pessoa.setDtNascimento(dtNascimento);
        pessoa.setNaturalidade(naturalidade);
        pessoa.setNacionalidade(nacionalidade);
        //    Inicio - Inclusao campo de Endereco - 15/03/2020 - robyson.ximenes - Versão 2.0
        pessoa.setEndereco(endereco);
        //    FIM - Inclusao campo de Endereco - 15/03/2020 - robyson.ximenes - Versão 2.0
        in.setPessoa(pessoa);
        OutAtualizarPessoa out = CadastroAcesso.getInstancia().atualizarPessoa(in);
        if (out != null && out.getStatus() != null) {
            Utils.adicionarMensagem(out.getStatus().getMensagem(), FacesMessage.SEVERITY_INFO);
            if(out.getStatus().getCodigo().equalsIgnoreCase("CCA040")) {
               FacesContext context = FacesContext.getCurrentInstance();
                HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
                String path = context.getExternalContext().getRequestContextPath() + "/faces/index.xhtml";
                try {
                    response.sendRedirect(path);
                } catch (IOException ex) {
                    Logger.getLogger(BuscarPessoaMB.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
        } else {
            Utils.adicionarMensagem("Erro no Serviço.", FacesMessage.SEVERITY_ERROR);
        }

    }
    
}
