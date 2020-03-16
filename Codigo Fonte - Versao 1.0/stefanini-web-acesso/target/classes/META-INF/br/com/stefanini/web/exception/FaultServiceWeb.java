package br.com.stefanini.web.exception;

import java.io.Serializable;

/**
 * Stefanini 2020
 * Class Objeto de erro
 * @date 14/03/2020
 * @author Ximenes
 */
public class FaultServiceWeb implements Serializable {

    private String codErro;
    private String desErro;
    private String desMotivo;
    private String tipoErro;

    public FaultServiceWeb() {
    }

    public String getCodErro() {
        return this.codErro;
    }

    public void setCodErro(String codErro) {
        this.codErro = codErro;
    }

    public String getDesErro() {
        return this.desErro;
    }

    public void setDesErro(String desErro) {
        this.desErro = desErro;
    }

    public String getDesMotivo() {
        return this.desMotivo;
    }

    public void setDesMotivo(String desMotivo) {
        this.desMotivo = desMotivo;
    }

    public String getTipoErro() {
        return this.tipoErro;
    }

    public void setTipoErro(String tipoErro) {
        this.tipoErro = tipoErro;
    }
    
    private boolean isNotBlank(String objeto) {
        return objeto != null && !objeto.isEmpty();
    }

    public String getMegCompleta() {
        StringBuilder sb = new StringBuilder();

        if (this.isNotBlank(this.getDesErro())) {
            sb.append(this.getDesErro());
            sb.append(". ");
        }
        if (this.isNotBlank(this.getDesMotivo())) {
            sb.append(this.getDesMotivo());
            sb.append(".");
        }

        return sb.toString();
    }

    public FaultServiceWeb(String codErro, String desErro, String desMotivo, String tipoErro) {
        this.codErro = codErro;
        this.desErro = desErro;
        this.desMotivo = desMotivo;
        this.tipoErro = tipoErro;
    }

    public FaultServiceWeb(String codErro, String desErro) {
        this.codErro = codErro;
        this.desErro = desErro;
        this.desMotivo = "";
        this.tipoErro = "DESCONHECIDO";
    }

    public FaultServiceWeb(String codErro, String desErro, String tipoErro) {
        this.codErro = codErro;
        this.desErro = desErro;
        this.desMotivo = "";
        this.tipoErro = tipoErro;
    }

}
