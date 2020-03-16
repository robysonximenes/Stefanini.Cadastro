package br.com.stefanini.servicos.cadastros.bo;

import br.com.stefanini.servicos.cadastros.bean.IN.InBuscarPessoa;
import br.com.stefanini.servicos.cadastros.bean.Pessoa;
import br.com.stefanini.servicos.cadastros.bean.Status;
import br.com.stefanini.servicos.cadastros.dao.PessoaDAO;
import br.com.stefanini.servicos.cadastros.util.DateUtil;
import br.com.stefanini.servicos.cadastros.util.GeralUtil;
import br.com.stefanini.servicos.cadastros.util.Mensagens;
import com.google.gson.Gson;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
* Stefanini 2020
* @author Ximenes
* Date 11/03/2020
* Class Responsavel pela regra de negocio de cadastrar, buscar, alterar, excluir pessoa.
*/
public class PessoaBO implements Serializable {

    PessoaDAO pessoaDAO = new PessoaDAO();

    /**
    * Stefanini 2020
    * @author Ximenes
    * Date 11/03/2020
    * Metodo Responsavel por cadastro de pessoa.
    * @param pessoa
    */
    public void cadastrarPessoa (Pessoa pessoa) {
        pessoa.setDtCadastro(DateUtil.recuperarDataAtualString(DateUtil.FORMATO_DATA_CURTA));
        pessoa.setDtAtualizacaoCadastro(DateUtil.recuperarDataAtualString(DateUtil.FORMATO_DATA_CURTA));
        pessoaDAO.cadastrarPessoa(pessoa);
    }
    
    /**
    * Stefanini 2020
    * @author Ximenes
    * Date 11/03/2020
    * Metodo Responsavel por atualizar de pessoa.
    * @param pessoa
    */
    public void atualizarCadastroPessoa (Pessoa pessoa) {
        pessoa.setDtAtualizacaoCadastro(DateUtil.recuperarDataAtualString(DateUtil.FORMATO_DATA_CURTA));
        pessoaDAO.atualizarPessoa(pessoa);
    }
    
    /**
    * Stefanini 2020
    * @author Ximenes
    * Date 11/03/2020
    * Metodo Responsavel por excluir de pessoa.
    * @param pessoa
    */
    public Status excluirCadastroPessoa (String cpf) {
        List<Document> listPessoaEntity = pessoaDAO.pesquisarPessoaCpf(cpf);
        Status status = new Status();
        if(listPessoaEntity.size() >= 1) {
            pessoaDAO.excluirPessoa(cpf);
            status.setCodigo(Mensagens.COD_CADASTRO_EXCLUIDO_SUCESSO);
            status.setMensagem(Mensagens.CADASTRO_EXCLUIDO_SUCESSO);
            status.setTipo(Mensagens.SUCESSO);
        } else {
            status.setCodigo(Mensagens.COD_PESSOA_CPF_NAO_LOCALIZADO);
            status.setMensagem(Mensagens.PESSOA_CPF_NAO_LOCALIZADO);
            status.setTipo(Mensagens.ALERTA); 
        }
        
        return status;
    }
    
    /**
     * Método Responsavel por buscar pessoa de acordo com a entrada:
     * Preferencias: CPF, Nome, Caso não tenha sido passada
     * nenhuma informação trará todas as pessoas.
     *
     * @author Ximenes Date 12/03/2020
     * @param in InBuscarPessoa
     * @return List<Pessoa> lista de Pessoas
     */
    public List<Pessoa> buscarListPessoa(InBuscarPessoa in) {
        List<Document> listPessoaEntity;
        if (!GeralUtil.isNullOrVazio(in.getCpf())) {
             listPessoaEntity = pessoaDAO.pesquisarPessoaCpf(in.getCpf());
        } else if (!GeralUtil.isNullOrVazio(in.getNome())) {
            listPessoaEntity = pessoaDAO.pesquizarPeloNome(in.getNome());
        } else {
            listPessoaEntity = pessoaDAO.buscarTodasPessoa();
        }

        List<Pessoa> listPessoa = this.convertPessoaEntityBean(listPessoaEntity);
        return listPessoa;
    }

    /**
    * Stefanini 2020
    * @author Ximenes
    * Date 11/03/2020
    * Metodo Responsavel por transformar lista de Documentos em uma Lista de Objetos do Tipo Pessoa.
    * @param listEntity
    * @return List<Pessoa>
    */
    private List<Pessoa> convertPessoaEntityBean(List<Document> listEntity) {
        List<Pessoa> listPessoa = new ArrayList<Pessoa>();
        
        for (Document pessoaEntity : listEntity) {
            Pessoa pessoa = new Gson().fromJson(pessoaEntity.toJson(), Pessoa.class);
            String idPessoa = pessoa.getId().toString().substring(6, pessoa.getId().toString().length()-1);
            pessoa.setIdPessoa(idPessoa);
            listPessoa.add(pessoa);
        }

        return listPessoa;
    }
    
    /**
    * Stefanini 2020
    * @author Ximenes
    * Date 11/03/2020
    * Metodo Responsavel por validar entrada passada de uma pessoa.
    * @param pessoa
    * @param atualizar
    * @return Status
    */
    public Status validarPessoa(Pessoa pessoa, Boolean atualizar) {
        Status status = null;
        //Validar formato CPF e se foi passado
        if(GeralUtil.isNullOrVazio(pessoa.getCpf()) || !GeralUtil.validaFormatoCpf(pessoa.getCpf())) {
            status = new Status();
            status.setCodigo(Mensagens.COD_CPF_INVALIDO);
            status.setMensagem(Mensagens.CPF_INVALIDO);
            status.setTipo(Mensagens.ALERTA);
        } else {
            //retira os caracteres, deixando somente numeros
            String cpf = GeralUtil.removerCaracteresCpf(pessoa.getCpf());
            if(!GeralUtil.isCPF(cpf)){
                status = new Status();
                status.setCodigo(Mensagens.COD_CPF_INVALIDO);
                status.setMensagem(Mensagens.CPF_INVALIDO);
                status.setTipo(Mensagens.ALERTA);
            }
            if (status == null) {
                //verifica se o cpf ja esta cadastrdo no banco de dados.
                List<Document> listPessoaEntity = pessoaDAO.pesquisarPessoaCpf(pessoa.getCpf());
                //variavel atualizar, faz referencia se foi quem esta chamando é para atualizar pessoa
                if(listPessoaEntity.size() >= 1  && !atualizar) {
                    status = new Status();
                    status.setCodigo(Mensagens.COD_PESSOA_JA_CADASTRADO);
                    status.setMensagem(Mensagens.PESSOA_JA_CADASTRADO);
                    status.setTipo(Mensagens.ALERTA);
                } else if (listPessoaEntity.size() < 1  && atualizar) {
                    status = new Status();
                    status.setCodigo(Mensagens.COD_PESSOA_CPF_NAO_LOCALIZADO);
                    status.setMensagem(Mensagens.PESSOA_CPF_NAO_LOCALIZADO);
                    status.setTipo(Mensagens.ALERTA); 
                }
            }
            if (status == null && GeralUtil.isNullOrVazio(pessoa.getNome())) {
                status = new Status();
                status.setCodigo(Mensagens.COD_DADOS_OBRIGATORIOS_NAO_PREENCHIDOS);
                status.setMensagem(Mensagens.DADOS_OBRIGATORIOS_NAO_PREENCHIDOS);
                status.setTipo(Mensagens.ALERTA);
            }
            if (status == null && !GeralUtil.isNullOrVazio(pessoa.getEmail())) {
                if (!GeralUtil.isValidEmailAddressRegex(pessoa.getEmail())) {
                    status = new Status();
                    status.setCodigo(Mensagens.COD_EMAIL_INVALIDO);
                    status.setMensagem(Mensagens.EMAIL_INVALIDO);
                    status.setTipo(Mensagens.ALERTA);
                }
            }
            //valida formado da tada e se é uma data valida
            if (status == null && !DateUtil.validaData(pessoa.getDtNascimento(), DateUtil.FORMATO_DATA_CURTA)) {
                status = new Status();
                status.setCodigo(Mensagens.COD_DATA_INVALIDA);
                status.setMensagem(Mensagens.DATA_INVALIDA);
                status.setTipo(Mensagens.ALERTA);
            }
            //Inicio - Inclusao campo de Endereco - 15/03/2020 - robyson.ximenes - Versão 2.0
            if (status == null && GeralUtil.isNullOrVazio(pessoa.getEndereco())) {
                status = new Status();
                status.setCodigo(Mensagens.COD_ENDERECO_OBRIGATORIO);
                status.setMensagem(Mensagens.ENDERECO_OBRIGATORIO);
                status.setTipo(Mensagens.ALERTA);
            }
            //Fim - Inclusao campo de Endereco - 15/03/2020 - robyson.ximenes - Versão 2.0
        }
        
        return status;
    }
    
}
