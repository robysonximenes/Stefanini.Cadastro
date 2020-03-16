package br.com.stefanini.web.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Classe utilitária que tem métodos estático para manipulação de data.
 * 
 * @author 

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
     * Método que formata uma data que é pasada como uma string e o formato de como ela irá sair.
     * 
     * @param dataString - data do tipo string.
     * @param formato - formato de como irá sair a data.
     * @return Objeto do tipo date formatado.
     * @throws ParseException
     */
    public static Date formatarData(String dataString, String formato) throws ParseException {

        Date dataFormatada = null;

        if (dataString != null) {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formato);
            dataFormatada = simpleDateFormat.parse(dataString);
        }

        return dataFormatada;
    }

    /**
     * Metodo responsavel por converter Date em GregorianCalendar.
     * 
     * @param data A data a ser inserida.
     * @return Um GregorianCalendar
     */
    public static GregorianCalendar converterDateParaGregorianCalendar(Date data) {
        GregorianCalendar gregorianCalendar = null;

        if (data != null) {
            Locale locale = new Locale("pt", "BR");
            gregorianCalendar = new GregorianCalendar(locale);
            gregorianCalendar.setTime(data);
        }

        return gregorianCalendar;
    }

    /**
     * FIXME: cristiano.fonseca - Acrescentar o javadoc.
     * 
     * @return corrigir
     */
    public static Date recuperarDataAtual() {
        Locale locale = new Locale("pt", "BR");
        GregorianCalendar calendar = new GregorianCalendar(locale);
        return calendar.getTime();
    }

    /**
     * FIXME: cristiano.fonseca - Acrescentar o javadoc.
     * 
     * @param formato
     * 
     * @return corrigir
     */
    public static String recuperarDataAtualString(String formato) {
        GregorianCalendar calendar = new GregorianCalendar();
        SimpleDateFormat formatar = new SimpleDateFormat(formato);
        String retorno = formatar.format(calendar.getTime());

        return retorno;
    }

    /**
     * TODO cristiano.fonseca - Acrescentar comentário javadoc.
     * 
     * @param data
     * @param formato
     * @return TODO cristiano.fonseca - Acrescentar comentário javadoc.
     * @author cristiano.fonseca
     * 
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
     * Metodo responsavel por adicionar um valor em meses a uma data.
     * 
     * @param data A data a ser manipulada.
     * @param meses O numero de meses a adicionar a data.
     * @return Um Date
     */
    public static Date adicionarMes(Date data, int meses) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.add(Calendar.MONTH, meses);

        return cal.getTime();
    }

    /**
     * Metodo responsavel por adicionar um valor em dias a uma data.
     * 
     * @param data A data a ser manipulada.
     * @param dias O numero de dias a adicionar a data.
     * @return Um Date
     */
    public static Date adicionarDia(Date data, int dias) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.add(Calendar.DAY_OF_YEAR, dias);

        return cal.getTime();
    }

    /**
     * TODO cristiano.fonseca - Acrescentar comentário javadoc.
     * 
     * @param dataString - Data do tipo string.
     * @param formatoEntrada - Formato que a data está sendo passada.
     * @param formatoSaida - Formato que a data será retornada.
     * @return Data formatada de acordo com o formato passado.
     * @throws ParseException
     * @author cristiano.fonseca
     * 
     */
    public static String formatarData(String dataString, String formatoEntrada, String formatoSaida)
            throws ParseException {

        SimpleDateFormat simpleDateFormatEntrada = new SimpleDateFormat(formatoEntrada);
        SimpleDateFormat simpleDateFormatSaida = new SimpleDateFormat(formatoSaida);

        String dataFormatada = simpleDateFormatSaida.format(simpleDateFormatEntrada.parse(dataString));

        return dataFormatada;
    }

    /**
     * Método que retorna o último dia do mes referente a data passada por parâmetro.
     * 
     * @param data - Data utilizada como referência.
     * @return ultimo dia do mês.
     * @author cristiano.fonseca
     * 
     */
    public static Date ultimoDiaMes(Date data) {

        Calendar calendar = converterDateParaGregorianCalendar(data);
        Calendar calendarModificado =
                new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.getActualMaximum(Calendar.DAY_OF_MONTH),
                        calendar.getActualMaximum(Calendar.HOUR_OF_DAY),
                        calendar.getActualMaximum(Calendar.MINUTE), calendar.getActualMaximum(Calendar.SECOND));

        return calendarModificado.getTime();
    }
    
    public static java.sql.Date convertSqlData(String dataTexto) throws ParseException {
        DateFormat fmt = new SimpleDateFormat(FORMATO_DATA_HORA);
        java.sql.Date data = new java.sql.Date(fmt.parse(dataTexto).getTime());
        return data;
    }
    
    public static java.sql.Date convertSqlDataSemHora(String dataTexto) throws ParseException {
        DateFormat fmt = new SimpleDateFormat(FORMATO_DATA_CURTA);
        java.sql.Date data = new java.sql.Date(fmt.parse(dataTexto).getTime());
        return data;
    }
}