package br.com.stefanini.web.util;

import java.io.Serializable;

/**
 * A Classe ConfLocate representa as configurações para o mecanismo de locate dos serviços.
 * @author robyson ximenes
 * @created 13/03/2020
 */
public final class ConfLocate implements Serializable {

    /**
     * Representa o serial version da classe.
     */
    private static final long serialVersionUID = -6208783709629275524L;

    private ConfLocate() {
        // evita a instanciação da classe.
    }

    /**
     * Nome da aplicação.
     */
    public static final String APPNAME = "stefanini-web";

    /**
     * Nome do arquivo de propriedades que contem as informações dos webservices.
     */
    public static final String FILENAME = "stefanini-locator-webservice.properties";

}
