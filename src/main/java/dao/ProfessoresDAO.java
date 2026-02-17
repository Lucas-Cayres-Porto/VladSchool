package dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import conexao.Conectar;
import model.Aluno;
import model.Professor;
import org.bson.Document;
import org.bson.types.ObjectId;
import util.ExceptionHandler;

public class ProfessoresDAO {
    private MongoCollection<Document> colecao;
    private Conectar conexao;

    public ProfessoresDAO() {
        this.colecao = conexao.getInstancia().getCollection("Usuarios");
    }
    public boolean criarProfessor(Professor professor){
        try {
            Document professorJson = professor.paraJson();
            colecao.insertOne(professorJson);
            return true;
        }catch (Exception e){
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
            return false;
        }
    }
    public int deletarAluno(int id_professor){
        try {

            long deletados;

            deletados = colecao.deleteOne(Filters.eq("dados_professor.id_professor", id_professor)).getDeletedCount();

            if (deletados > 0) {
                return 1;
            }
            return 0;
        } catch (Exception e) {
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
            return -1;
        }
    }
}
