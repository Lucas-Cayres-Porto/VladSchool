package testes;
import conexao.Conectar;
import dao.AlunosDAO;

public class Teste {
    public static void main(String[] args) throws InterruptedException {
        AlunosDAO alunosDAO = new AlunosDAO();
        System.out.println(alunosDAO.buscarPorIndex(0));
    }
}
