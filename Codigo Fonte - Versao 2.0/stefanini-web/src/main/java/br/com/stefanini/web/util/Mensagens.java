//package br.com.stefanini.web.util;
//
//import javax.faces.application.FacesMessage;
//import javax.faces.application.FacesMessage.Severity;
//import javax.faces.context.FacesContext;
//import org.apache.commons.lang.StringUtils;
//
///**
// *
// * @author Ximenes
// */
//public class Mensagens {
//
//    //Mensagens
//    public static final String PESSOA_JA_CADASTRADO = "Pessoa já Cadastrada";
//    public static final String COD_PESSOA_JA_CADASTRADO = "CPJC001";
//    public static final String PESSOA_CADASTRADO_SUCESSO = "Pessoa Cadastrado Com Sucesso";
//    public static final String COD_PESSOA_CADASTRADO_SUCESSO = "CPCS002";
//    public static final String FUNCIONARIO_NAO_TEM_PERMISSSAO = "Funcionario não tem permissão para realizar esta ação, ou Senha foi digitada errada";
//    public static final String COD_FUNCIONARIO_NAO_TEM_PERMISSSAO = "CFNTP003";
//    public static final String PESSOA_NAO_LOCALIZADO = "Pessoa Não Localizado,Favor tentar com o CPF";
//    public static final String COD_PESSOA_NAO_LOCALIZADO = "CCNL004";
//    public static final String PESSOA_CPF_NAO_LOCALIZADO = "Pessoa Não Cadastrado";
//    public static final String COD_PESSOA_CPF_NAO_LOCALIZADO = "CCCNL005";
//    public static final String FUNCIONARIO_CADASTRADO_SUCESSO = "Funcionario Cadastrado Com Sucesso";
//    public static final String COD_FUNCIONARIO_CADASTRADO_SUCESSO = "CFCCS006";
//    public static final String FUNCIONARIO_JA_CADASTRADO = "Funcionario Ja Cadastrado";
//    public static final String COD_FUNCIONARIO_JA_CADASTRADO = "CFJC007";
//    public static final String ERRO_COM_SERVIDOR = "Servidor Indisponível";
//    public static final String COD_ERRO_COM_SERVIDOR = "CECS008";
//    public static final String PEDIDOS_CANCELADOS = "Pedidos Cancelados";
//    public static final String COD_PEDIDOS_CANCELADOS = "CPC009";
//    public static final String ITEM_CANCELADO = "Item Cancelado";
//    public static final String COD_ITEM_CANCELADO = "CIC010";
//    public static final String MESA_LIBERADO = "Mesa Liberada";
//    public static final String COD_MESA_LIBERADO = "CML011";
//    public static final String SENHA_INVALIDA = "Senha Inválida";
//    public static final String COD_SENHA_INVALIDA = "CSI012";
//    public static final String PRODUTO_INDISPONIVEL = "Produto Indisponível";
//    public static final String COD_PRODUTO_INDISPONIVEL = "CPI013";
//    public static final String PRODUTO_CADASTRADO_SUCESSO = "Produto Cadastrado com Sucesso";
//    public static final String COD_PRODUTO_CADASTRADO_SUCESSO = "CPCS014";
//    public static final String PRODUTO_JA_CADASTRADO = "Produto Ja Cadastrado";
//    public static final String COD_PRODUTO_JA_CADASTRADO = "CPJC015";
//    public static final String FORNECEDOR_CADASTRADO_SUCESSO = "Fornecedor Cadastrado com Sucesso";
//    public static final String COD_FORNECEDOR_CADASTRADO_SUCESSO = "CFCS016";
//    public static final String CNPJ_INVALIDO = "CNPJ Inválido";
//    public static final String COD_CNPJ_INVALIDO = "CCI017";
//    public static final String FORNECEDOR_JA_CADASTRADO = "Fornecedor já Cadastrado";
//    public static final String COD_FORNECEDOR_JA_CADASTRADO = "CFJC018";
//    public static final String CPF_INVALIDO = "CPF Inválido";
//    public static final String COD_CPF_INVALIDO = "CCI018";
//    public static final String NOTA_ENTRADA_VALIDADA = "Nota Fiscal de Entrada Cadastrada com Sucesso";
//    public static final String COD_NOTA_ENTRADA_VALIDADA = "CNEV019";
//    public static final String PAGAMENTO_REALIZADO = "Pagamento Realizado";
//    public static final String COD_PAGAMENTO_REALIZADO = "CPR020";
//    public static final String CHAMAR_GERENTE = "Somente com Senha Gerencial";
//    public static final String COD_CHAMAR_GERENTE = "CCG021";
//    public static final String TELEFONE_JA_CADASTRADO = "Telefone ja Cadastrado para: ";
//    public static final String COD_TELEFONE_JA_CADASTRADO = "CTJC022";
//    public static final String FORNECEDOR_CNPJ_NAO_CADASTRADO = "Fornecedor não Cadastrado com Este CNPJ";
//    public static final String COD_FORNECEDOR_CNPJ_NAO_CADASTRADO = "CFCNC023";    
//    public static final String PESQUISA_REALIZADA_COM_SUCESSO = "Pesqueisa Realizada com Sucesso";    
//    public static final String COD_PESQUISA_REALIZADA_COM_SUCESSO = "CPRCS024";    
//    public static final String PRODUTO_NAO_CADASTRADO = "Produto Não Cadastrado";
//    public static final String COD_PRODUTO_NAO_CADASTRADO = "CPNC025";
//    public static final String PRODUTO_ESTA_DESABILITADO = "Produto Desabilitado";
//    public static final String COD_PRODUTO_ESTA_DESABILITADO = "CPED026";
//    public static final String PRODUTO_JA_TEM_PRECO = "Produto Já Contem Preço, deve ser preenchido o Motivo e confirmar o fim da virgência para criar uma nova";
//    public static final String COD_PRODUTO_JA_TEM_PRECO = "CPJTP027";
//    public static final String PRECO_CADASTRADO_COM_SUCESSO = "Preço cadastrado com Sucesso";
//    public static final String COD_PRECO_CADASTRADO_COM_SUCESSO = "CPCCS028";
//    public static final String FUNCIONARIO_ATUALIZADO = "Funcionario Atualizado com Sucesso";
//    public static final String COD_FUNCIONARIO_ATUALIZADO = "CFA029";
//    public static final String MESA_EM_UTILIZACAO = "Mesa já esta sendo utilizada";
//    public static final String COD_MESA_EM_UTILIZACAO = "CMEU030";
//    public static final String MESA_COLOCADA_ATENDIMENTO = "Mesa colocada em Atendimento";
//    public static final String COD_MESA_COLOCADA_ATENDIMENTO = "CMCA031";
//    public static final String MESA_STATUS_MODIFICADO = "Status Modificado";
//    public static final String COD_MESA_STATUS_MODIFICADO = "CMSM032";
//    public static final String CANCELAR_MESA_PEDIDOS_CANCELADOS = "Todos os Pedidos da Mesa devem ser cancelados antes";
//    public static final String COD_CANCELAR_MESA_PEDIDOS_CANCELADOS = "CCMPC033";
//    public static final String SOLICITACAO_PEDIDO = "Pedido realizado com Sucesso";
//    public static final String COD_SOLICITACAO_PEDIDO = "CSP034";
//    public static final String SOLICITACAO_CONTA = "Solicitação Conta com Sucesso";
//    public static final String COD_SOLICITACAO_CONTA = "CSC035";
//    public static final String MESAS_DESAGRUPADAS = "Mesas Desagrupadas";
//    public static final String COD_MESAS_DESAGRUPADAS = "CMD036";
//    public static final String MESAS_AGRUPADAS = "Mesas Agrupadas";
//    public static final String COD_MESAS_AGRUPADAS = "CMD037";
//    public static final String MESAS_NAO_EXISTE = "Mesa Não Existe ou Não esta em Atendimento";
//    public static final String COD_MESAS_NAO_EXISTE = "CMD038";
//    public static final String ITENS_TRANSFERIDOS_SUCESSO = "Itens Transferidos com Sucesso";
//    public static final String COD_ITENS_TRANSFERIDOS_SUCESSO = "CITS039";
//    public static final String CADASTRO_ATUALIZADO = "Cadastro atualizado com Sucesso";
//    public static final String COD_CADASTRO_ATUALIZADO = "CCA040";
//    public static final String CADASTRADO_PRODUTO_ATUALIZADO = "Produto atualizado com Sucesso";
//    public static final String COD_CADASTRADO_PRODUTO_ATUALIZADO = "CCPA041";
//    public static final String DADOS_OBRIGATORIOS_NAO_PREENCHIDOS = "Dados Obrigatorios não Preenchidos";
//    public static final String COD_DADOS_OBRIGATORIOS_NAO_PREENCHIDOS = "CDONP042";
//    public static final String NAO_EXISTE_PAGAMENTO_PARA_MESA = "Não Existe Pagamentos Realizados para esta Mesa";
//    public static final String COD_NAO_EXISTE_PAGAMENTO_PARA_MESA = "CNEPPM043";
//    public static final String PAGAMENTO_FECHAMENTO_MESA = "Nota Fiscal disponivél para impressão";
//    public static final String COD_PAGAMENTO_FECHAMENTO_MESA = "CPFM044";
//    public static final String ERRO_VERIFICAR_VALORES = "Verificar valores, caso não resolva chamar a Gerência";
//    public static final String COD_ERRO_VERIFICAR_VALORES = "CEVV045";
//    public static final String EXISTE_PAGAMENTO_PENDENTES = "Valor pago não é suficiente para encherra a Mesa";
//    public static final String COD_EXISTE_PAGAMENTO_PENDENTES = "CEPP046";
//    public static final String PAGAMENTO_NAO_PERTENCE_MESA = "Dados de Pagamentos não pertence a mesa selecionada";
//    public static final String COD_PAGAMENTO_NAO_PERTENCE_MESA = "CPNPM047";
//    public static final String INICIAR_CAIXA_JA_INICIADO = "Caixa já foi iniciado na Data de Hoje, Nova operação não pode ser realizada.";
//    public static final String COD_INICIAR_CAIXA_JA_INICIADO = "CICJI048";
//    
//    //Tipo Mensagem
//    public static final String ALERTA = "Alerta";
//    public static final String ERRO = "Erro";
//    public static final String SUCESSO = "Sucesso";
//    public static final String AVISO = "Aviso";
//    
//    //Cod Sucesso das Buscas
//    public static final String COD_SUCESSO = "0001";
//    
//    
//    
//    public static void adicionarMensagem(String mensagem, Severity severidade) {
//        FacesContext contexto = FacesContext.getCurrentInstance();
//
//        if (contexto != null) {
//            FacesMessage facesMensagem = new FacesMessage(severidade, mensagem, StringUtils.EMPTY);
//            contexto.addMessage(null, facesMensagem);
//        }
//    }
//}
