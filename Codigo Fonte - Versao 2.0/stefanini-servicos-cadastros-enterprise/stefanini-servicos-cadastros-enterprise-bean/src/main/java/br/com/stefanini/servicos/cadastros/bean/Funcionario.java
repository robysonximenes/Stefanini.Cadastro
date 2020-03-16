package br.com.stefanini.servicos.cadastros.bean;

import java.io.Serializable;

/**
 * Stefanini 2020
 * @author Ximenes
 * Date 11/03/2020
 * Class Bean Representa os atributos de um funcionario
 */
public class Funcionario implements Serializable{
    private String nome;
    private String senha;
    private Boolean habilitado;


    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the habilitado
     */
    public Boolean getHabilitado() {
        return habilitado;
    }

    /**
     * @param habilitado the habilitado to set
     */
    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    
}
