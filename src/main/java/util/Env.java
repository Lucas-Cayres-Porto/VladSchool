package util;

import io.github.cdimascio.dotenv.Dotenv;

public class Env {
    String urlConexao;
    String DBName;

    public Env() {
        Dotenv env = Dotenv.load();
        this.urlConexao = env.get("CONNECTION_STRING");
        this.DBName = env.get("DB_NAME");
    }
    public String getUrlConexao(){
        return this.urlConexao;
    }

    public String getDBName(){
        return this.DBName;
    }
}
