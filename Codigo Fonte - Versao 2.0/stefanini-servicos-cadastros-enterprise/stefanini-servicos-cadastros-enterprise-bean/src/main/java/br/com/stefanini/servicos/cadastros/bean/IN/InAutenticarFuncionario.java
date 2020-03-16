package br.com.stefanini.servicos.cadastros.bean.IN;

import br.com.stefanini.servicos.cadastros.bean.Funcionario;
import java.io.Serializable;

/**
 * Stefanini 2020
 * @author Ximenes
 * Date 10/03/2020
 * Class Representa os atributos de entrada do web servicer de Autenticar de Login Funcionario
 */
public class InAutenticarFuncionario implements Serializable {
    
    private Funcionario funcionario;

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
}
