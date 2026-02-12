package model;

import org.bson.Document;
import org.json.JSONObject;
import util.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

public class Disciplinas {
    private int id;
    private String nome;
    public Disciplinas(int id, String nome){
        this.id=id;
        this.nome=nome;
    }
    public int getId(){
        return this.id;
    }
    public String getNome(){
        return this.nome;
    }
    public static Disciplinas deJson(Document jsonDoc) {
        try{
            // Extrair dados do usuário
            int id = jsonDoc.getInteger("id_disciplina");
            String nome = jsonDoc.getString("nome");

            // Criar e retornar o objeto Disciplina
            return new Disciplinas(id,nome);

        }catch (Exception e) {
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
            return null;
        }
    }

    public Document paraJson(){
        try {


            JSONObject disciplinaJson = new JSONObject();

            disciplinaJson.put("id_disciplina",this.id);
            disciplinaJson.put("nome",this.nome);

            return Document.parse(disciplinaJson.toString());
        } catch (Exception e) {
            ExceptionHandler eh = new ExceptionHandler(e);
            eh.printExeption();
            return null;
        }
    }
    @Override
    public String toString() {
        return "Disciplinas{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
