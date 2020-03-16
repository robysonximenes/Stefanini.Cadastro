package br.com.stefanini.servicos.cadastros.dao;

import br.com.stefanini.servicos.cadastros.bean.Pessoa;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
* Stefanini 2020
* @author Ximenes
* Date 12/03/2020
* Class Responsavel pela manipulação de dados de pessoas no banco de dados.
*/
public class PessoaDAO implements Serializable {
    
    /**
    * Stefanini 2020
    * @author Ximenes
    * Date 12/03/2020
    * Metodo Responsavel por conectar ao banco de dados.
    * @return MongoDatabase
    */
    private MongoDatabase conectarBanco() {
        //Conectando ao servidor mongodb
        MongoClient mongoClient = new MongoClient("localhost",27017);
        // Conecta ao banco de dados test
        MongoDatabase db = mongoClient.getDatabase("testemongodb");
        return db;
    }

    /**
    * Stefanini 2020
    * @author Ximenes
    * Date 12/03/2020
    * Metodo Responsavel por pesquizar pessoas no banco por cpf.
    * @param cpf
    * @return List<Document>
    */
    public List<Document> pesquisarPessoaCpf(String cpf) {
        
        MongoDatabase db = this.conectarBanco();
        MongoCollection<Document> collection = db.getCollection("pessoa");
        // Buscar todos os dados
        Document filtroQuery = new Document("cpf", cpf);
        List<Document> cursor = collection.find(filtroQuery).into(new ArrayList<Document>());

        return cursor;

    }

    /**
    * Stefanini 2020
    * @author Ximenes
    * Date 12/03/2020
    * Metodo Responsavel por cadastrar pessoas no banco.
    * @param pessoaEntity
    */
    public void cadastrarPessoa(Pessoa pessoaEntity) {
        MongoDatabase db = this.conectarBanco();
        MongoCollection<Document> collection = db.getCollection("pessoa");
        collection.insertOne(
            new Document("nome", pessoaEntity.getNome())
                .append("sexo", pessoaEntity.getSexo())
                .append("email", pessoaEntity.getEmail())
                .append("dtNascimento", pessoaEntity.getDtNascimento())
                .append("naturalidade", pessoaEntity.getNaturalidade())
                .append("nacionalidade", pessoaEntity.getNacionalidade())
                .append("cpf", pessoaEntity.getCpf())
                .append("dtCadastro", pessoaEntity.getDtCadastro())
                .append("dtAtualizacaoCadastro", pessoaEntity.getDtAtualizacaoCadastro())
                //Inicio - Inclusao campo de Endereco - 15/03/2020 - robyson.ximenes - Versão 2.0
                .append("endereco", pessoaEntity.getEndereco())
                //FIM - Inclusao campo de Endereco - 15/03/2020 - robyson.ximenes - Versão 2.0
            );
    }

    /**
    * Stefanini 2020
    * @author Ximenes
    * Date 12/03/2020
    * Metodo Responsavel por pesquizar pessoas no banco pelo nome.
    * @param nome
    * @return List<Document>
    */
    public List<Document> pesquizarPeloNome(String nome) {

        MongoDatabase db = this.conectarBanco();
        MongoCollection<Document> collection = db.getCollection("pessoa");
        // Buscar todos os dados
        Document filtroQuery = new Document("nome", nome);
        List<Document> cursor = collection.find(filtroQuery).into(new ArrayList<Document>());
        
        return cursor;
    }

    /**
    * Stefanini 2020
    * @author Ximenes
    * Date 12/03/2020
    * Metodo Responsavel retornar todas pessoas do banco.
    * @return List<Document>
    */
    public List<Document> buscarTodasPessoa() {

        MongoDatabase db = this.conectarBanco();
        MongoCollection<Document> collection = db.getCollection("pessoa");
        // Buscar todos os dados
        List<Document> cursor = collection.find().into(new ArrayList<Document>());
        
        return cursor;
    }

    /**
    * Stefanini 2020
    * @author Ximenes
    * Date 12/03/2020
    * Metodo Responsavel por atualizar dados de uma pessoas do banco.
    * @param pessoaEntity
    */
    public void atualizarPessoa(Pessoa pessoaEntity) {
        MongoDatabase db = this.conectarBanco();
        MongoCollection<Document> collection = db.getCollection("pessoa");
        collection.updateOne(eq("cpf", pessoaEntity.getCpf()), new Document("$set",
            new Document("nome", pessoaEntity.getNome())
                .append("sexo", pessoaEntity.getSexo())
                .append("email", pessoaEntity.getEmail())
                .append("dtNascimento", pessoaEntity.getDtNascimento())
                .append("naturalidade", pessoaEntity.getNaturalidade())
                .append("nacionalidade", pessoaEntity.getNacionalidade())
                .append("cpf", pessoaEntity.getCpf())
                .append("dtAtualizacaoCadastro", pessoaEntity.getDtAtualizacaoCadastro())
                //Inicio - Inclusao campo de Endereco - 15/03/2020 - robyson.ximenes - Versão 2.0
                .append("endereco", pessoaEntity.getEndereco())
                //FIM - Inclusao campo de Endereco - 15/03/2020 - robyson.ximenes - Versão 2.0
                )
            );
    }
    
    /**
    * Stefanini 2020
    * @author Ximenes
    * Date 12/03/2020
    * Metodo Responsavel por excluir dados de uma pessoas do banco.
    * @param cpf
    */
    public void excluirPessoa(String cpf) {
        MongoDatabase db = this.conectarBanco();
        MongoCollection<Document> collection = db.getCollection("pessoa");
        collection.deleteOne(eq("cpf", cpf));
    }
}
