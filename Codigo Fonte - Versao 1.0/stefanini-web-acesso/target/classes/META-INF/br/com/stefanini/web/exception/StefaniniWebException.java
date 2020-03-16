package br.com.stefanini.web.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * Stefanini 2020
 * Exceção geral da aplicacao para erros de negocio.
 * @date 14/03/2020
 * @author Ximenes
 */
public class StefaniniWebException extends RuntimeException {

    /**
     * Representa o serial version da classe.
     */
    private static final long serialVersionUID = 678582126978876149L;

    private List<FaultServiceWeb> faultServiceWebs;

    /**
     * @autor ximenes
     * Cria uma nova instância da exceção inicializando a mensagem do erro.
     * @data 14/03/2020
     * @param string
     */
    public StefaniniWebException(String mensagem) {
        super(mensagem);
    }

    /**
     * @autor ximenes
     * Cria uma nova instância da exceção inicializando a causa do erro.
     * @data 14/03/2020
     * @param causa
     */
    public StefaniniWebException(Throwable causa) {
        super(causa);

        if (causa != null && "CadastroException_Exception".equalsIgnoreCase(causa.getClass().getSimpleName())) {
            Object servException;
            try {
                servException = causa.getClass().getMethod("getFaultInfo").invoke(causa);
                if (servException != null) {
                    List<Object> faultServices = (List<Object>) servException.getClass().getMethod("getFaultService")
                            .invoke(servException);
                    if (faultServices != null) {
                        this.faultServiceWebs = new ArrayList<FaultServiceWeb>();
                        for (Object fault : faultServices) {
                            String codErro = fault.getClass().getMethod("getCodErro").invoke(fault) != null ? (String) fault
                                    .getClass().getMethod("getCodErro").invoke(fault) : " ";

                            String desErro = fault.getClass().getMethod("getDesErro").invoke(fault) != null ? (String) fault
                                    .getClass().getMethod("getDesErro").invoke(fault) : "";

                            String desMotivo = fault.getClass().getMethod("getDesMotivo").invoke(fault) != null ? (String) fault
                                    .getClass().getMethod("getDesMotivo").invoke(fault) : "";

                            String tipoErro = fault.getClass().getMethod("getTipoErro").invoke(fault) != null ? fault
                                    .getClass().getMethod("getTipoErro").invoke(fault).toString() : "";

                            FaultServiceWeb faultServiceWeb = new FaultServiceWeb(codErro, desErro, desMotivo, tipoErro);
                            this.faultServiceWebs.add(faultServiceWeb);
                        }
                    }
                }
            } catch (Exception e) {

            }
        }
    }

    /**
     * @autor ximenes
     * Cria uma nova instância da exceção inicializando a mensagem do erro.
     * @data 14/03/2020
     * @param mensagem
     * @param causa
     */
    public StefaniniWebException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

    public List<FaultServiceWeb> getFaultServiceWebs() {
        return this.faultServiceWebs;
    }

    public void setFaultServiceWebs(List<FaultServiceWeb> faultServiceWebs) {
        this.faultServiceWebs = faultServiceWebs;
    }

}
