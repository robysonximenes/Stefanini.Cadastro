package br.com.stefanini.servicos.cadastros.bean.IN;

import java.io.Serializable;

/**
 * Stefanini 2020
 * @author Ximenes
 * Date 10/03/2020
 * Class Representa os atributos de entrada do web servicer de Buscar de Pessoas
 */
public class InBuscarPessoa implements Serializable{
    private String cpf;
    private String nome;

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

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

}
