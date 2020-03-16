package br.com.stefanini.servicos.cadastros.bean.OUT;

import br.com.stefanini.servicos.cadastros.bean.Status;
import java.io.Serializable;

/**
 * Stefanini 2020
 * @author Ximenes
 * Date 10/03/2020
 * Class Representa os atributos de saida/retorno do web servicer de Atualizar cadastro de Pessoas
 */
public class OutAtualizarPessoa implements Serializable{
    
    private Status status;

    /**
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }

}
