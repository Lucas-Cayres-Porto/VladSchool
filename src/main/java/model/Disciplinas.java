package model;

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

    @Override
    public String toString() {
        return "Disciplinas{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
