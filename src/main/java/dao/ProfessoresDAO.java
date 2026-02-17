package dao;

import com.mongodb.client.MongoCollection;
import conexao.Conectar;
import org.bson.Document;

public class ProfessoresDAO {
    private MongoCollection<Document> colecao;
    private Conectar conexao;

    public ProfessoresDAO() {
        this.colecao = conexao.getInstancia().getCollection("Usuarios");
    }

}
