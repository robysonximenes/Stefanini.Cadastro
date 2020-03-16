package br.com.stefanini.servicos.cadastros.bean;

import java.io.Serializable;

/**
 * Stefanini 2020
 * @author Ximenes
 * Date 11/03/2020
 * Class Bean Representa os atributos de uma pessoa
 */
public class Pessoa implements Serializable{

    private Object _id;
    private String idPessoa;
    private String nome;
    private String sexo;
    private String email;
    private String dtNascimento;
    private String naturalidade;
    private String nacionalidade;
    private String cpf;
    private String dtCadastro;
    private String dtAtualizacaoCadastro;

    public String getId() {
        return _id.toString();
    }

    public void setId(Object _id) {
        this._id = _id;
    }
    
    public String getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(String idPessoa) {
        this.idPessoa = idPessoa;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(String dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(String dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public String getDtAtualizacaoCadastro() {
        return dtAtualizacaoCadastro;
    }

    public void setDtAtualizacaoCadastro(String dtAtualizacaoCadastro) {
        this.dtAtualizacaoCadastro = dtAtualizacaoCadastro;
    }

}
