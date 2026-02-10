package model;

import java.util.List;

public class Professor extends Usuario {
    private int idProfessor;
    private List<Integer> disciplinasLecionadas;
    public Professor(String nome,String nomeUsuario,String senha,String tipo,String email,
                     int idProfessor,List<Integer> disciplinasLecionadas){
        super(nome,nomeUsuario,senha,tipo,email);
        this.idProfessor=idProfessor;
        this.disciplinasLecionadas=disciplinasLecionadas;
    }
    public int getIdProfessor(){
        return this.idProfessor;
    }
    public List<Integer> getDisciplinasLecionadas(){
        return this.disciplinasLecionadas;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "idProfessor=" + idProfessor +
                ", disciplinasLecionadas=" + disciplinasLecionadas +
                '}';
    }
}
