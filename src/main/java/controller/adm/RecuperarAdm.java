package controller.adm;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bson.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/app/adm/recuperar")
public class RecuperarAdm extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        Document resposta = new Document();

        try {
            StringBuilder jsonBuilder = new StringBuilder();
            String line;
            try (BufferedReader reader = req.getReader()) {
                while ((line = reader.readLine()) != null) {
                    jsonBuilder.append(line);
                }
            }

            String jsonString = jsonBuilder.toString();
            Document dados = Document.parse(jsonString);
            String email = dados.getString("email");
            String codigoRecebido = dados.getString("codigo");

            String codigoArmazenado = EmailAdm.codigosPorEmail.get(email);

            if (codigoArmazenado != null && codigoArmazenado.equals(codigoRecebido)) {
                EmailAdm.codigosPorEmail.remove(email);
                resposta.append("retorno", true)
                        .append("mensagem", "Código válido");
            } else {
                resposta.append("retorno", false)
                        .append("erro", "Código inválido");
            }

        } catch (Exception e) {
            resposta.append("retorno", false)
                    .append("erro", "Erro ao processar requisição: " + e.getMessage());
        }

        out.println(resposta.toJson());
    }
}