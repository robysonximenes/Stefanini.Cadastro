package br.com.stefanini.servicos.cadastros.bean.OUT;

import br.com.stefanini.servicos.cadastros.bean.Funcionario;
import br.com.stefanini.servicos.cadastros.bean.Status;
import java.io.Serializable;

/**
 * Stefanini 2020
 * @author Ximenes
 * Date 10/03/2020
 * Class Representa os atributos de saida/retorno do web servicer de Autenticar de Login Funcionario
 */
public class OutAutenticarFuncionario implements Serializable {
    
    private Funcionario funcionario;
    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
