package br.com.stefanini.servicos.cadastros.util;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Stefanini 2020
 * @author Ximenes
 * Date 12/03/2020
 * Class de Utilitarios com metodos importantes que podem ser utilizados em todo o sistema.
 */
public class GeralUtil implements Serializable {
    
    /**
    * Stefanini 2020
    * @author Ximenes
    * Date 12/03/2020
    * Metodo utilizado para verificar se o numero passado é de um CPF valido, verifica o digito verificados do cpf.
    * @param cpf
    * @return boolean
    */
    public static boolean isCPF(String cpf) {
    // considera-se erro CPF's formados por uma sequencia de numeros iguais
    if (cpf.equals("00000000000") ||
        cpf.equals("11111111111") ||
        cpf.equals("22222222222") || cpf.equals("33333333333") ||
        cpf.equals("44444444444") || cpf.equals("55555555555") ||
        cpf.equals("66666666666") || cpf.equals("77777777777") ||
        cpf.equals("88888888888") || cpf.equals("99999999999") ||
        (cpf.length() != 11))
        return(false);

    char dig10, dig11;
    int sm, i, r, num, peso;

    // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
    try {
    // Calculo do 1o. Digito Verificador
        sm = 0;
        peso = 10;
        for (i=0; i<9; i++) {              
    // converte o i-esimo caractere do CPF em um numero:
    // por exemplo, transforma o caractere '0' no inteiro 0         
    // (48 eh a posicao de '0' na tabela ASCII)         
        num = (int)(cpf.charAt(i) - 48); 
        sm = sm + (num * peso);
        peso = peso - 1;
        }

        r = 11 - (sm % 11);
        if ((r == 10) || (r == 11))
            dig10 = '0';
        else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

    // Calculo do 2o. Digito Verificador
        sm = 0;
        peso = 11;
        for(i=0; i<10; i++) {
        num = (int)(cpf.charAt(i) - 48);
        sm = sm + (num * peso);
        peso = peso - 1;
        }

        r = 11 - (sm % 11);
        if ((r == 10) || (r == 11))
            dig11 = '0';
        else dig11 = (char)(r + 48);

    // Verifica se os digitos calculados conferem com os digitos informados.
        if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))
            return(true);
        else return(false);
            } catch (InputMismatchException erro) {
            return(false);
        }
    }
    
    /**
    * Stefanini 2020
    * @author Ximenes
    * Date 12/03/2020
    * Metodo utilizado para verificar o formato de um CPF xxx.xxx.xxx-xx.
    * @param cpf
    * @return Boolean
    */
    public static Boolean validaFormatoCpf(String cpf){
        Boolean out = Boolean.TRUE;
        if(cpf.length() != 14){
            out = Boolean.FALSE;
        } else {
            for(int x=0 ; x < 14; x++) {
                if(x != 3 && x != 7 && x != 11) {
                    if(!Character.isDigit(cpf.charAt(x))) {
                        out = Boolean.FALSE;
                        break;
                    }
                } else if (x == 3 || x == 7) {
                    if (!cpf.subSequence(x, x+1).equals(".")) {
                        out = Boolean.FALSE;
                        break;
                    }
                } else {
                    if (!cpf.subSequence(x, x+1).equals("-")) {
                        out = Boolean.FALSE;
                        break;
                    }
                }
            }
        }
        
        
        return out;
    }
    
    /**
    * Stefanini 2020
    * @author Ximenes
    * Date 12/03/2020
    * Metodo utilizado para retirar caracteres como . e - de um CPF xxx.xxx.xxx-xx.
    * @param cpf
    * @return String
    */
    public static String removerCaracteresCpf(String cpf){    
        cpf = cpf.replace("-","");
        cpf = cpf.replace(".","");
        return cpf;
    }
    
    /**
    * Stefanini 2020
    * @author Ximenes
    * Date 12/03/2020
    * Metodo utilizado para verificar se uma variavel esta null ou vazia.
    * @param texto
    * @return Boolean
    */
    public static Boolean isNullOrVazio(String texto) {
        Boolean out = false;
        if(texto == null || texto.isEmpty()) {
            out = true;
        }
        return out;
    }
    
    /**
    * Stefanini 2020
    * @author Ximenes
    * Date 12/03/2020
    * Metodo utilizado para verificar se um email esta no formato correto.
    * @param email
    * @return boolean
    */
    public static boolean isValidEmailAddressRegex(String email) {
        boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;
    }
    
}
