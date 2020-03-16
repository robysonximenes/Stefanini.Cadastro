package br.com.stefanini.servicos.cadastros.bo;

import br.com.stefanini.servicos.cadastros.bean.Funcionario;
import br.com.stefanini.servicos.cadastros.dao.FuncionarioDAO;
import java.io.Serializable;
import java.util.List;
import org.bson.Document;

/**
* Stefanini 2020
* @author Ximenes
* Date 12/03/2020
* Class Responsavel pela regra de negocio de funcionarios.
*/
public class FuncionarioBO implements Serializable{
    
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    /**
    * Stefanini 2020
    * @author Ximenes
    * Date 12/03/2020
    * Metodo Responsavel por verificar login e senha passados pelo funcionario.
    * @param funcionario
    * @return Funcionario
    */
    public Funcionario autenticarFuncionario(Funcionario funcionario) {
        List<Document> listDoc = funcionarioDAO.autenticarFuncionario(funcionario.getNome(), funcionario.getSenha());
        if(listDoc.size() >= 1) {
            funcionario.setHabilitado(Boolean.TRUE);
        } else {
            funcionario.setHabilitado(Boolean.FALSE);
        }
        return funcionario;
    }
}
