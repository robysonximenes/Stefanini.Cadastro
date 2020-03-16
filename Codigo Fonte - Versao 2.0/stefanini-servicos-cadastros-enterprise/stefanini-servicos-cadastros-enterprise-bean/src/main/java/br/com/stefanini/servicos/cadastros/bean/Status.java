package br.com.stefanini.servicos.cadastros.bean;

import java.io.Serializable;

/**
 * Stefanini 2020
 * @author Ximenes
 * Date 12/03/2020
 * Class Bean Representa os atributos de uma mensagem informativa.
 */
public class Status implements Serializable {
    private String mensagem;
    private String tipo;
    private String codigo;

    /**
     * @return the mensagem
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * @param mensagem the mensagem to set
     */
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
