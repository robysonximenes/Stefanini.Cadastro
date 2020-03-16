package br.com.stefanini.web.base;

import br.com.stefanini.web.exception.StefaniniWebException;
import java.lang.reflect.ParameterizedType;
import org.apache.commons.logging.Log;

/**
 * A Classe BaseAcesso representa a primeira camada da arquitetura de acesso aos serviços externos.
 * @author Ximenes
 * @created 13/03/2020
 */
@SuppressWarnings("deprecation")
public abstract class BaseAcesso<S, L extends LocateBase> {

    /**
     * Representa a instância do serviço parametrizado.
     */
    private S instanciaServico;

    /**
     * Representa o Class do Locate parametrizado pela classe.
     */
    private Class<L> locate;

    /**
     * Inicializa a classe do locate.
     */
    @SuppressWarnings("unchecked")
    public BaseAcesso() {
        this.locate = (Class<L>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    /**
     * Responsável por retornar a intância do serviço parametrizado.
     * 
     * @return nova instância de {@link S}.
     */
    @SuppressWarnings("unchecked")
    protected S getInstanciaServico() {
        try {
            if (instanciaServico == null) {
                this.instanciaServico = (S) this.locate.newInstance().get();
            }
        } catch (Exception e) {
            this.getLog().error(e);

            Class<S> servico = (Class<S>) ((ParameterizedType) getClass().getGenericSuperclass())
                    .getActualTypeArguments()[0];

            throw new StefaniniWebException("Não foi possivel acessar o serviço " + servico.getSimpleName() + ".");
        }

        return this.instanciaServico;
    }

    /**
     * Responsável por retornar a instância do mecanismo de log da aplicação.
     * 
     * @return instância de um objeto {@link Log}.
     */
    public abstract Log getLog();

}