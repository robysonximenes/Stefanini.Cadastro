package br.com.stefanini.web.util;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;

public class Utils implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 6971792671509959353L;
    
            /**
     * Responsável por retornar um determinado valor que está no escopo flash da aplicação. Caso não encontre o valor,
     * ou o mesmo seja uma instância de diferente tipo do que foi passado, retornará <code>null</code>.
     * 
     * @param <E>
     *            Parametrizador do tipo do valor buscado.
     * @param nomeAtributo
     *            O nome do atributo que deseja-se retornar
     * @param tipoAtributo
     *            O tipo do valor que deseja-se buscar.
     * @return Caso encontre o valor, retorar a intância do mesmo, do contrário <code>null</code>.
     * 
     * @author cleber.alberto.silva
     */
    public static <E> E getAtributoFlash(String nomeAtributo, Class<E> tipoAtributo) {

        E retorno = null;
        FacesContext contexto = FacesContext.getCurrentInstance();

        if (contexto != null && contexto.getExternalContext() != null
                && contexto.getExternalContext().getFlash() != null) {

            Map<String, Object> flash = contexto.getExternalContext().getSessionMap();

            Object valorBruto = flash.get(nomeAtributo);

            if (valorBruto != null && valorBruto.getClass().isAssignableFrom(tipoAtributo)) {
                retorno = tipoAtributo.cast(valorBruto);
            }
        }

        return retorno;
    }

    /**
     * Insere um determinado valor no escopo flash da aplicação, de acordo com a sua chave correspondente.
     * 
     * @param nomeAtributo
     *            {@link String} que é a chave do atributo que será inserido.
     * @param valorAtributo
     *            {@link Object} representando o valor que será inserido.
     * 
     * @author cleber.alberto.silva
     */
    public static void adicionarAtributoFlash(String nomeAtributo, Object valorAtributo) {

        FacesContext contexto = FacesContext.getCurrentInstance();

        if (contexto != null && contexto.getExternalContext() != null
                && contexto.getExternalContext().getFlash() != null) {

            Map<String, Object> flash = contexto.getExternalContext().getSessionMap();
            flash.put(nomeAtributo, valorAtributo);
        }

    }

    /**
     * Remove dados especificos da sessao atual, atraves dos nomes passados.
     * 
     * @param chaves
     * 
     * @author cleber.alberto.silva
     */
    public static void removeDadosSessao(final String... chaves) {

        final HttpSession sessao = Utils.getSessaoAtual();

        if (Utils.isNotNull(sessao)) {

            for (String chave : chaves) {
                sessao.removeAttribute(chave);
            }
        }
    }
    
    /**
     * Retorna a sessao atual da aplicacao.
     * 
     * @return
     * 
     * @author cleber.alberto.silva
     */
    public static HttpSession getSessaoAtual() {

        HttpSession sessao = null;

        final FacesContext contexto = FacesContext.getCurrentInstance();

        if (Utils.isNotNull(contexto) && Utils.isNotNull(contexto.getExternalContext())) {
            sessao = (HttpSession) contexto.getExternalContext().getSession(true);
        }

        return sessao;
    }

    private void mensagemErro(final String textoErro) {

        final FacesContext contexto = FacesContext.getCurrentInstance();

        String msgErro;

        FacesMessage facesMensagem;

        if (textoErro != null && textoErro.length() == 6) {
            msgErro = textoErro;
        } else {
            msgErro = "Erro Insperado, Contacte o Administrador";
        }

        facesMensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, msgErro, "Erro");

        if (contexto != null) {
            contexto.addMessage(null, facesMensagem);
        }
    }
    
    public static boolean isEmpty(Collection<?> colecao) {
        boolean vazia = false;

        if (colecao == null || colecao.isEmpty()) {
            vazia = true;
        }

        return vazia;
    }

    /**
     * Identifica se uma {@link Collection} não esta nula ou vazia.This method returns true if the collection is null or
     * is empty.
     * 
     * @param colecao
     *            A instância a ser validada.
     * 
     * @return Retorna <code>false</code> caso a coleção esteja nula ou vazia, caso contrário retorna <code>true</code>.
     * 
     */
    public static boolean isNotEmpty(Collection<?> colecao) {
        boolean preenchida = false;

        if (colecao != null && !colecao.isEmpty()) {
            preenchida = true;
        }

        return preenchida;
    }

    /**
     * Identifica se o objeto preenchido é nulo.
     * 
     * @param objeto
     *            a instância a ser validada.
     * @return Retorna <code>true</code> caso o objeto seja nulo, caso contrário retorna <code>false</code>.
     * 
     */
    public static boolean isNull(Object objeto) {
        return objeto == null;
    }
    
    public static boolean isNotBlank(String objeto) {
        return objeto != null && !objeto.isEmpty();
    }

    /**
     * Identifica se o objeto preenchido não é nulo.
     * 
     * @param objeto
     *            a instância a ser validada.
     * @return Retorna <code>false</code> caso o objeto seja nulo, caso contrário retorna <code>true</code>.
     * 
     */
    public static boolean isNotNull(Object objeto) {
        return objeto != null;
    }

    /**
     * Valida se todos os objetos informados estão diferentes de nulo.
     * 
     * @param objetos
     *            Representa a lista de objetos a serem validados.
     * @return Retorna <code>true</code> caso todos os objetos informados na lista estejam diferentes de nulo, caso
     *         contrário retorna <code>false</code>.
     * 
     */
    public static boolean isParamsNotNull(Object... objetos) {
        boolean preenchidos = true;

        for (Object objeto : objetos) {
            if (isNull(objeto)) {
                preenchidos = false;
                break;
            }
        }

        return preenchidos;
    }

    /**
     * Identifica se o wrapper de tipos como {@link Long}, {@link Integer}, {@link Double}, {@link Float} e
     * {@link BigDecimal} está diferente de nulo e com valor maior do que zero.
     * 
     * @param object
     *            A instância que contém o valor a ser validado.
     * @return Retorna <code>true</code> caso o objeto seja diferente de nulo e maior que zero, caso contrário retorna
     *         <code>false</code>.
     * 
     */
    public static boolean isWrapperNotEmpty(Object object) {
        boolean preenchido = false;

        if (object != null) {
            if (object instanceof Long) {
                preenchido = ((Long) object) > 0;
            } else if (object instanceof Integer) {
                preenchido = ((Integer) object) > 0;
            } else if (object instanceof BigDecimal) {
                preenchido = ((BigDecimal) object).compareTo(BigDecimal.valueOf(0)) == 1;
            } else if (object instanceof Float) {
                preenchido = ((Float) object) > 0;
            }
        }

        return preenchido;
    }

    /**
     * Identifica a quantidade de dias entre uma data e a data atual.
     * 
     * @param data
     *            A instância que contém a data a ser comparada com a atual.
     * @return Retorna a diferença em dias da data atual, zero caso as duas datas sejam iguais ou a data informada seja
     *         nula.
     * 
     */
    public static long diferencaEmDiasDaDataAtual(Date data) {
        long qtdDias = 0;

        if (data != null) {
            qtdDias = ((System.currentTimeMillis() - data.getTime()) / (1000 * 60 * 60 * 24));
        }

        return qtdDias;
    }

    public static boolean isStringNotEmpty(String objeto) {
        boolean preenchido = false;

        if (isNotNull(objeto) && !objeto.trim().isEmpty()) {
            preenchido = true;
        }

        return preenchido;
    }
    
    public static BigDecimal formataDecimalDuasCasas(BigDecimal vlrFator){  
        BigDecimal numFormatado  = vlrFator.setScale(2, BigDecimal.ROUND_UP); 
        return numFormatado;		
    }
    
    public static List<Long> ConvertArrayList(List<Object[]> item){
        List<Long> out = new ArrayList<Long>();
        for(int x = 0; x < item.size(); x++){
            Object[] valor = item.get(x);
            Long valorLong = new Long(valor[0].toString());
            out.add(valorLong);
        }
        return out;
    }
    
    public static Boolean isNullOrVazio(String texto) {
        Boolean out = false;
        if(texto == null || texto.isEmpty()) {
            out = true;
        }
        return out;
    }
    
    public static BigDecimal convertBigDecimal(String valor) {
        valor = valor.trim();
        if(!Utils.isNullOrVazio(valor)) {
            valor = valor.replaceAll(",", ".");
        } else {
            valor = "0";
        }
        
        return new BigDecimal(valor);
    }
    
    /**
     * Adiciona uma nova mensagem no contexto da apresentacao.
     * 
     * @param mensagem
     *            String contendo a mensagem que sera apresentada.
     * @param severidade
     *            Eh o nivel de severidade que a mesagem possui.
     * 
     * @author Ximenes
     */
    public static void adicionarMensagem(String mensagem, FacesMessage.Severity severidade) {
        FacesContext contexto = FacesContext.getCurrentInstance();

        if (contexto != null) {
            FacesMessage facesMensagem = new FacesMessage(severidade, mensagem, StringUtils.EMPTY);
            contexto.addMessage(null, facesMensagem);
        }
    }

}
