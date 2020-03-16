package br.com.stefanini.servicos.cadastros.bean.IN;

import br.com.stefanini.servicos.cadastros.bean.Pessoa;
import java.io.Serializable;

/**
 * Stefanini 2020
 * @author Ximenes
 * Date 10/03/2020
 * Class Representa os atributos de entrada do web servicer de cadastro de Pessoas
 */
public class InCadastrarPessoa implements Serializable{

    private Pessoa pessoa;
    
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
}
