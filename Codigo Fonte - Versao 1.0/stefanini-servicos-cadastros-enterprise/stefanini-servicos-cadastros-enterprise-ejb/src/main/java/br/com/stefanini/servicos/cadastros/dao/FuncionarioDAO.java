package br.com.stefanini.servicos.cadastros.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;


/**
* Stefanini 2020
* @author Ximenes
* Date 12/03/2020
* Class Responsavel pela manipulação de dados de funcionarios no banco de dados.
*/
public class FuncionarioDAO implements Serializable{
    
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
    * Metodo Responsavel por verificar no banco se o usuario e senha existem.
    * @param nome
    * @param senha
    * @return List<Document>
    */
    public List<Document> autenticarFuncionario(String nome, String senha) {
        
        MongoDatabase db = this.conectarBanco();
        MongoCollection<Document> collection = db.getCollection("funcionario");

        BasicDBObject andQuery = new BasicDBObject();
        List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
        obj.add(new BasicDBObject("nome", nome));
        obj.add(new BasicDBObject("senha", senha));
        andQuery.put("$and", obj);
        
        List<Document> cursor = collection.find(andQuery).into(new ArrayList<Document>());
        
        return cursor;
    }
}