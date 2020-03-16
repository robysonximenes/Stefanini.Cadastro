package br.com.stefanini.servicos.cadastros.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Stefanini 2020
 * @author Ximenes
 * Date 12/03/2020
 * Classe utilitária que tem métodos estático para manipulação de data.
 */
public class DateUtil {

    /**
     * Constante para ser utilizada para datas curtas.
     */
    public static final String FORMATO_DATA_CURTA = "dd/MM/yyyy";

    /**
     * Constante para ser utilizada para data e hora juntas.
     */
    public static final String FORMATO_DATA_HORA = "dd/MM/yyyy HH:mm:ss";

    public static final String FORMATO_DATA_HORA_SEM_SEPARADO = "ddMMyyyy HH:mm:ss";

    public static final String FORMATO_DATA_HORA_SEM_SEPARADOR = "ddMMyyyy HHmmss";

    /**
     * Constante para ser utilizada para datas .
     */
    public static final String FORMATO_DATA_USA_SEM_SEPARADOR = "yyyyMMdd";
    public static final String FORMATO_DATA_USA_COM_SEPARADOR = "yyyy-MM-dd";

    /**
     * Constante para ser utilizada para hora .
     */
    public static final String FORMATO_HORA_EXTENCO = "HH:mm:ss";

    /**
     * Constante para ser utilizada para hora .
     */
    public static final String FORMATO_HORA_SEM_SEPARADOR = "HHmmss";

    public static final String FORMATO_DATA_yyMM = "yyMM";
    public static final String FORMATO_DATA_yyyyMM = "yyyyMM";

    /**
     * Constante para ser utilizada para datas Locale Brasil.
     */
    public static final String FORMATO_DATA_BR_SEM_SEPARADOR = "ddMMyyyy";

    public static final String FORMATO_DATA_ANO_MES_COM_SEPARADOR = "yyyy-MM";

    

    /**
    * Stefanini 2020
    * @author Ximenes
    * Date 12/03/2020
    * Metodo recupera a data atual e formata no formato passado como parametro.
    * @param cormato
    * @return String
    */
    public static String recuperarDataAtualString(String formato) {
        GregorianCalendar calendar = new GregorianCalendar();
        SimpleDateFormat formatar = new SimpleDateFormat(formato);
        String retorno = formatar.format(calendar.getTime());

        return retorno;
    }

    /**
    * Stefanini 2020
    * @author Ximenes
    * Date 12/03/2020
    * Metodo recebeuma data e formata no formato passado como parametro.
    * @param data
    * @param formato
    * @return String
    */ 
    public static String formatarData(Date data, String formato) {
        String dataFormatada = null;
        if(data != null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formato);
            dataFormatada = simpleDateFormat.format(data);
        }
        
        return dataFormatada;
    }

    /**
    * Stefanini 2020
    * @author Ximenes
    * Date 12/03/2020
    * Metodo valida a data passada, gerando um ParseException caso nao seja uma data valida, 
    * sendo tratado e retornando que a data nao é valida.
    * @param data
    * @param formato
    * @return Boolean
    */
    public static Boolean validaData(String data, String formato) {
        Boolean out = Boolean.TRUE;
        SimpleDateFormat format = new SimpleDateFormat(formato);
        try {
            format.setLenient(false);
            format.parse(data);
        } catch (ParseException e) {
            out = Boolean.FALSE;
        }
        return out;
    }
}