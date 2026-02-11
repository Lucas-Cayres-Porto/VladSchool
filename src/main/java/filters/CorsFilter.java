package filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


//como o front e back funcionam em portas e hosts diferentes, o CORS bloqueia o front do back isso n pode ocorrer para isso usamos essa classe que permite o front de acessar pelo navegador
public class CorsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {


        //response e request
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        //header principaç, permite filtrar a origem da requisição
        httpResponse.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:5500");

        // Adiciona os filtros necessarios no header da requisção para permitir o front passar
        httpResponse.setHeader("Access-Control-Allow-Methods", "GET, POST");
        httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept");
        httpResponse.setHeader("Access-Control-Max-Age", "3600");


        //permite usar options, n me pergunte o pq ou como
        if ("OPTIONS".equalsIgnoreCase(httpRequest.getMethod())) {
            httpResponse.setStatus(HttpServletResponse.SC_OK);
            return;
        }

        //tipo o do get do servlet normal
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}
}