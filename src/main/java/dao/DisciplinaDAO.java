package dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import model.Disciplinas;
import org.bson.Document;
import conexao.Conectar;
import util.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAO {
    private MongoCollection<Document> colecao;
    Conectar conexao;

    public DisciplinaDAO() {
        this.colecao = conexao.getInstancia().getCollection("Disciplinas");
    }
    public boolean criarDisciplina(Disciplinas disciplinas){
        try {
            Document disciplinaJson = disciplinas.paraJson();
            colecao.insertOne(disciplinaJson);
            return true;
        }catch (Exception e){
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
            return false;
        }
    }

    public int deletarDisciplina(int id_disciplina){
        try {


            long deletados;


            deletados = colecao.deleteOne(Filters.eq("id_disciplina", id_disciplina)).getDeletedCount();

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

    public int atualizarDisciplina(int idDisciplina, Document json) {
        try {

            if (json.containsKey("_id")) {
                json.remove("_id");
            }
            long alterados = colecao.replaceOne(
                    Filters.eq("id_disciplina", idDisciplina), json
            ).getModifiedCount();
            if (alterados > 0) {
                return 1;
            }
            return 0;
        } catch (Exception e) {
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
            return -1;
        }
    }
    public Document bucarPorId(int id){

        Document filtro = new Document();
        Document disciplina = null;

        filtro.append("id_disciplina",id);

        MongoCursor<Document> cursor = colecao.find(filtro).iterator();

        try{
            while (cursor.hasNext()){
                disciplina = cursor.next();
            }
        } catch (Exception e){
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
        } finally {
            cursor.close();
            return disciplina;
        }
    }
    public Document bucarPorNome(String nome){

        Document filtro = new Document();
        Document disciplina = null;

        filtro.append("nome",nome);
        filtro.append("nome",
                new Document("$regex",nome)
                        .append("$options","i"));

        MongoCursor<Document> cursor = colecao.find(filtro).iterator();

        try{
            while (cursor.hasNext()){
                disciplina = cursor.next();
            }
        } catch (Exception e){
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
        } finally {
            cursor.close();
            return disciplina;
        }
    }
    public List<Document> listarDisciplinas(){

        List<Document> listaDisciplina = new ArrayList<>();

        MongoCursor<Document> cursor = colecao.find().iterator();

        try{
            while (cursor.hasNext()){
                listaDisciplina.add(cursor.next());
            }
        } catch (Exception e){
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
        } finally {
            cursor.close();
            return listaDisciplina;
        }
    }
}
