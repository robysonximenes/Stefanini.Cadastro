import br.com.stefanini.servicos.cadastros.bean.Funcionario;
import br.com.stefanini.servicos.cadastros.bean.IN.InAtualizarPessoa;
import br.com.stefanini.servicos.cadastros.bean.IN.InBuscarPessoa;
import br.com.stefanini.servicos.cadastros.bean.IN.InCadastrarPessoa;
import br.com.stefanini.servicos.cadastros.bean.IN.InExcluirPessoa;
import br.com.stefanini.servicos.cadastros.bean.OUT.OutAtualizarPessoa;
import br.com.stefanini.servicos.cadastros.bean.OUT.OutBuscarPessoa;
import br.com.stefanini.servicos.cadastros.bean.OUT.OutCadastrarPessoa;
import br.com.stefanini.servicos.cadastros.bean.OUT.OutExcluirPessoa;
import br.com.stefanini.servicos.cadastros.bean.Pessoa;
import br.com.stefanini.servicos.cadastros.bean.Status;
import br.com.stefanini.servicos.cadastros.bo.FuncionarioBO;
import br.com.stefanini.servicos.cadastros.bo.PessoaBO;
import br.com.stefanini.servicos.cadastros.ejb.CadastroService;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Ximenes
 */
public class JUnitTestCadastro {
    

    @org.junit.BeforeClass
    public static void setUpClass() throws Exception {
        PessoaBO boPessoa = new PessoaBO();
        Pessoa pessoa = new Pessoa();
        pessoa.setCpf("756.834.257-35");
        pessoa.setDtNascimento("10/10/2000");
        pessoa.setEmail("grabriel@gmail.com");
        pessoa.setNacionalidade("BR");
        pessoa.setNaturalidade("Recife");
        pessoa.setNome("Gabriel");
        pessoa.setSexo("M");
        //Inicio - Inclusao campo de Endereco - 15/03/2020 - robyson.ximenes - Versão 2.0
        pessoa.setEndereco("Avenida Casa Amarela, 376");
        //FIM - Inclusao campo de Endereco - 15/03/2020 - robyson.ximenes - Versão 2.0
        boPessoa.cadastrarPessoa(pessoa);
        
        CadastroService serv = new CadastroService();
        InCadastrarPessoa in = new InCadastrarPessoa();
        pessoa.setCpf("552.887.333-92");
        pessoa.setDtNascimento("10/10/2000");
        pessoa.setEmail("grabriel@gmail.com");
        pessoa.setNacionalidade("BR");
        pessoa.setNaturalidade("Recife");
        pessoa.setNome("Gabriel");
        pessoa.setSexo("M");
        //Inicio - Inclusao campo de Endereco - 15/03/2020 - robyson.ximenes - Versão 2.0
        pessoa.setEndereco("Avenida Beira Mar, 1143");
        //FIM - Inclusao campo de Endereco - 15/03/2020 - robyson.ximenes - Versão 2.0
        in.setPessoa(pessoa);
        OutCadastrarPessoa teste1 = serv.cadastrarPessoa(in);
        assertTrue("CPCS002".equals(teste1.getStatus().getCodigo()));
    }

    @org.junit.AfterClass
    public static void tearDownClass() throws Exception {
        String cpf = "";
        PessoaBO bo = new PessoaBO();
        Status teste1 = bo.excluirCadastroPessoa(cpf);
        assertTrue("CCCNL005".equals(teste1.getCodigo()));
        cpf = "756.834.257-35";
        Status teste2 = bo.excluirCadastroPessoa(cpf);
        assertTrue("CCES045".equals(teste2.getCodigo()));
        cpf = "756.834.257-00";
        Status teste3 = bo.excluirCadastroPessoa(cpf);
        assertTrue("CCCNL005".equals(teste3.getCodigo()));
         
        CadastroService serv = new CadastroService(); 
        InExcluirPessoa in = new InExcluirPessoa();
        in.setCpf("552.887.333-92");
        OutExcluirPessoa teste4 = serv.excluirPessoa(in);
        assertTrue("CCES045".equals(teste4.getStatus().getCodigo()));

        OutExcluirPessoa teste5 = serv.excluirPessoa(in);
        assertTrue("CCCNL005".equals(teste5.getStatus().getCodigo()));
        
        in.setCpf("688.041.589-05");
        serv.excluirPessoa(in);
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void cadastroPessoaServicoTest() {
        CadastroService serv = new CadastroService();
        InCadastrarPessoa in = new InCadastrarPessoa();
        Pessoa pessoa = new Pessoa();
        pessoa.setCpf("688.041.589-05");
        pessoa.setDtNascimento("10/10/2000");
        pessoa.setEmail("grabriel@gmail.com");
        pessoa.setNacionalidade("BR");
        pessoa.setNaturalidade("Recife");
        pessoa.setNome("Gabriel");
        pessoa.setSexo("M");
        //Inicio - Inclusao campo de Endereco - 15/03/2020 - robyson.ximenes - Versão 2.0
        pessoa.setEndereco("Avenida Boa Viagem, 3070");
        //FIM - Inclusao campo de Endereco - 15/03/2020 - robyson.ximenes - Versão 2.0
        in.setPessoa(pessoa);
        OutCadastrarPessoa teste1 = serv.cadastrarPessoa(in);
        assertTrue("CPCS002".equals(teste1.getStatus().getCodigo()));
        
     }
    
    @Test
     public void buscarListPessoasServTest() {
        CadastroService serv = new CadastroService();
        InBuscarPessoa in = new InBuscarPessoa();
        in.setCpf("552.887.333-92");
        OutBuscarPessoa teste1 = serv.buscarListPessoas(in);
        assertTrue("0001".equals(teste1.getStatus().getCodigo()));
        in.setCpf("756.834.257-00");
        OutBuscarPessoa teste2 = serv.buscarListPessoas(in);
        assertTrue("CCNL004".equals(teste2.getStatus().getCodigo()));
        
     }
    
     @Test
     public void autenticarFuncionarioTest() {
         Funcionario funcionario = new Funcionario();
         FuncionarioBO bo = new FuncionarioBO();
         Funcionario teste1 = bo.autenticarFuncionario(funcionario);
         assertFalse(teste1.getHabilitado());
         funcionario.setNome("CARLOS");
         funcionario.setSenha("1234");
         Funcionario teste2 = bo.autenticarFuncionario(funcionario);
         assertTrue(teste2.getHabilitado());
         funcionario.setSenha("12345");
         Funcionario teste3 = bo.autenticarFuncionario(funcionario);
         assertFalse(teste3.getHabilitado());
     
     }
     
     @Test
     public void buscarListPessoaTest() {
         InBuscarPessoa entrada = new InBuscarPessoa();
         entrada.setCpf("756.834.257-35");
         PessoaBO bo = new PessoaBO();
         List<Pessoa> teste1 = bo.buscarListPessoa(entrada);
         assertTrue(teste1.size()>= 1);
         entrada.setCpf("046.263.789-02");
         List<Pessoa> teste2 = bo.buscarListPessoa(entrada);
         assertFalse(teste2.size()>= 1);
         entrada.setNome("Brenda");
         List<Pessoa> teste3 = bo.buscarListPessoa(entrada);
         assertFalse(teste3.size()>= 1);
         entrada.setCpf("");
         List<Pessoa> teste4 = bo.buscarListPessoa(entrada);
         assertFalse(teste4.size()>= 1);
     }
     
     @Test
     public void validarPessoaTest() {
        PessoaBO bo = new PessoaBO();
        Boolean atualizar = Boolean.FALSE;
        Pessoa pessoa = new Pessoa();
        pessoa.setCpf("756.834.257-35");
        pessoa.setDtNascimento("10/10/2000");
        pessoa.setEmail("grabriel@gmail.com");
        pessoa.setNacionalidade("BR");
        pessoa.setNaturalidade("Recife");
        pessoa.setNome("Gabriel");
        pessoa.setSexo("M");
        //Inicio - Inclusao campo de Endereco - 15/03/2020 - robyson.ximenes - Versão 2.0
        pessoa.setEndereco("Rua vinte quatro de Abril, Afogados");
        //FIM - Inclusao campo de Endereco - 15/03/2020 - robyson.ximenes - Versão 2.0
        Status teste1 = bo.validarPessoa(pessoa, atualizar);
        assertTrue("CPJC001".equals(teste1.getCodigo()));
        pessoa.setCpf("671.853.118-96");
        Status teste = bo.validarPessoa(pessoa, atualizar);
        assertNull(teste);
        pessoa.setCpf("75683425735");
        Status teste2 = bo.validarPessoa(pessoa, atualizar);
        assertTrue("CCI018".equals(teste2.getCodigo()));
        pessoa.setCpf("756.834.257-00");
        Status teste3 = bo.validarPessoa(pessoa, atualizar);
        assertTrue("CCI018".equals(teste3.getCodigo()));
        pessoa.setCpf("756.834.257-35");
        Status teste4 = bo.validarPessoa(pessoa, atualizar);
        assertTrue("CPJC001".equals(teste4.getCodigo()));
        pessoa.setCpf("671.853.118-96");
        atualizar = Boolean.TRUE;
        Status teste5 = bo.validarPessoa(pessoa, atualizar);
        assertTrue("CCCNL005".equals(teste5.getCodigo()));
        pessoa.setNome("");
        pessoa.setCpf("756.834.257-35");
        Status teste6 = bo.validarPessoa(pessoa, atualizar);
        assertTrue("CDONP042".equals(teste6.getCodigo()));
        pessoa.setNome("Patricia");
        pessoa.setEmail("fdsfdsfdsfdfsf");
        Status teste7 = bo.validarPessoa(pessoa, atualizar);
        assertTrue("CEI043".equals(teste7.getCodigo()));
        pessoa.setDtNascimento("35/11/2010");
        pessoa.setEmail("patricia@gmail.com");
        Status teste8 = bo.validarPessoa(pessoa, atualizar);
        assertTrue("CDI044".equals(teste8.getCodigo()));
        //Inicio - Inclusao campo de Endereco - 15/03/2020 - robyson.ximenes - Versão 2.0
        pessoa.setEndereco("");
        Status teste9 = bo.validarPessoa(pessoa, atualizar);
        assertTrue("CEO046".equals(teste9.getCodigo()));        
        //FIM - Inclusao campo de Endereco - 15/03/2020 - robyson.ximenes - Versão 2.0
        
     }
     
    @Test
    public void atualizarPessoaServTest() {
        CadastroService serv = new CadastroService();
        InAtualizarPessoa in = new InAtualizarPessoa();
        Pessoa pessoa = new Pessoa();
        pessoa.setCpf("552.887.333-92");
        pessoa.setDtNascimento("10/10/2000");
        pessoa.setEmail("grabriel@gmail.com");
        pessoa.setNacionalidade("BR");
        pessoa.setNaturalidade("Olinda");
        pessoa.setNome("Gabriel");
        pessoa.setSexo("M");
        //Inicio - Inclusao campo de Endereco - 15/03/2020 - robyson.ximenes - Versão 2.0
        pessoa.setEndereco("Rua dos Anjos, 27");
        //FIM - Inclusao campo de Endereco - 15/03/2020 - robyson.ximenes - Versão 2.0
        in.setPessoa(pessoa);
        OutAtualizarPessoa teste1 = serv.atualizarPessoa(in);
        assertTrue("CCA040".equals(teste1.getStatus().getCodigo()));
    }
     
    
}
