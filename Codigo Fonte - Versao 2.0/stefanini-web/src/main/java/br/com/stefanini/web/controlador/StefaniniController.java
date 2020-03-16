package br.com.stefanini.web.controlador;

import br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro.Funcionario;
import br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro.InAutenticarFuncionario;
import br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro.OutAutenticarFuncionario;
import br.com.stefanini.web.acesso.CadastroAcesso;
import br.com.stefanini.web.util.Utils;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;


/**
 * Bean Gerenciavel.
 * 
 * @author Robyson Ximenes
 * 
 * @created 22/08/2016 - 6:35:17 PM
 */
@ManagedBean(name = "controller")
@ViewScoped
public class StefaniniController {

    public StefaniniController() {
        this.nomeUsuario = "";
        this.senhaUsuario = "";
        Boolean memoriaLogado = Utils.getAtributoFlash("LOGADO", Boolean.class);
        if (Utils.isNotNull(memoriaLogado)) {
            this.logado = memoriaLogado;
        }else {
            this.logado = Boolean.TRUE;
        }
    }
    
    private static final long serialVersionUID = 348825285885141319L;

    public static final String TELA_SOBRE_DESENVOLVEDOR = "desenvolvedor";
    public static final String TELA_SOBRE_STEFANINI = "sobreStefanini";
    
    public static final String PATH_ENTIDADE_NAO_AUTORIZADA_XHTML = "/faces/entidadeNaoAutorizada.xhtml";
    public static final String PATH_DETALHE_MANUTENCAO_LIMITES_ASSOCIADO = "/faces/pagina/manutencao/detalheDeLimites.xhtml";

    public static final String TELA_MANUTENCAO_GRUPO_LIMITE = "manutencaoGrupoLimite";
    public static final String TELA_MANUTENCAO_LIMITES = "consultaLimites";
    public static final String TELA_MANUTENCAO_LIMITE_CAMPANHA = "consultaLimitesCampanha";
    public static final String TELA_MANUTENCAO_LIMITE_MASSA = "consultaLimitesMassa";
    public static final String TELA_HABILITA_DIVULGACAO = "habilitaDivulgacao";
    public static final String TELA_POLITICA_LIMITE = "manutencaoPoliticaLimites";
    public static final String TELA_SOLICITACAO_RELATORIO = "solicitaRelatorioLimites";
    
    private Boolean logado;
    private String nomeUsuario;
    private String senhaUsuario;
    
    public Boolean getLogado() {
        return logado;
    }

    public void setLogado(Boolean logado) {
        this.logado = logado;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }
    
    public void limpar() {
        this.nomeUsuario = "";
        this.senhaUsuario = "";
        this.logado = Boolean.TRUE;
    }
    
    public void logar(){
        InAutenticarFuncionario in = new InAutenticarFuncionario();
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nomeUsuario);
        funcionario.setSenha(senhaUsuario);
        in.setFuncionario(funcionario);
        OutAutenticarFuncionario out = CadastroAcesso.getInstancia().autenticarFuncionario(in);
        if(out.getFuncionario().isHabilitado()) {
            logado = Boolean.FALSE;
        } else {
            logado = Boolean.TRUE;
            Utils.adicionarMensagem(out.getStatus().getMensagem(), FacesMessage.SEVERITY_INFO);
        }
        Utils.adicionarAtributoFlash("LOGADO", logado);
    }
    
    protected void navegarPara(String pagina) {
        if (Utils.isNotBlank(pagina)) {
            FacesContext context = FacesContext.getCurrentInstance();
            // /UIViewRoot oldView = context.getViewRoot();
            if (pagina.contains(".xhtml")) {
                HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();

                try {
                    String path = context.getExternalContext().getRequestContextPath() + pagina;
                    response.sendRedirect(path);
                } catch (IOException e) {
                }

            } else {

                UIViewRoot view = context.getApplication().getViewHandler().createView(context, pagina);
                context.setViewRoot(view);
                NavigationHandler nh = context.getApplication().getNavigationHandler();
                context.getPartialViewContext().setRenderAll(true);
                nh.handleNavigation(context, null, "/index.xhtml");

            }

        }
    }
    
    public String desenvolvedor() {
        return TELA_SOBRE_DESENVOLVEDOR;
    }
    
    public String sobreStefanini() {
        return TELA_SOBRE_STEFANINI;
    } 
    
}
