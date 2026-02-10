package dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
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
