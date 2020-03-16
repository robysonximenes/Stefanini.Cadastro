package br.com.stefanini.web.locate;

import br.com.stefanini.web.base.LocateBase;
import br.com.stefanini.web.util.ConfLocate;
import java.io.Serializable;

/**
 * A Classe StefaniniBaseLocate é responsável por instânciar a classe proxy {@link CadastroService} para
 * abstrair a comunicação com o serviço.
 * @author Robyson Ximenes
 * @created 13/03/2020
 */
public abstract class StefaniniBaseLocate<T> extends LocateBase implements Serializable {

    /**
     * Representa o serial version da classe.
     */
    private static final long serialVersionUID = -7241883767078716188L;

    /**
     * Cria uma nova instância da classe.
     * 
     * @throws Exception
     *             caso ocorra algum erro ao realizar a configuração de acesso.
     */
    public StefaniniBaseLocate() throws Exception {
        super(ConfLocate.APPNAME, ConfLocate.FILENAME);
    }

}