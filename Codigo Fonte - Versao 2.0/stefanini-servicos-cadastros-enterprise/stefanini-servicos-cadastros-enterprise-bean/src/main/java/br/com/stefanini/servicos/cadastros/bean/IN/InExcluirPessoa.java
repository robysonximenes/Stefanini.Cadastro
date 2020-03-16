package br.com.stefanini.servicos.cadastros.bean.IN;

import java.io.Serializable;

/**
 * Stefanini 2020
 * @author Ximenes
 * Date 11/03/2020
 * Class Representa os atributos de entrada do web servicer Excluir Pessoas
 */
public class InExcluirPessoa implements Serializable{

    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
