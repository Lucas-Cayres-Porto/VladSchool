class Usuario {
    constructor(nome, nomeUsuario, senha, tipo, email) {
        this.nome = nome;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.tipo = tipo;
        this.email = email;
    }

    getNome() { return this.nome; }
    getNomeUsuario() { return this.nomeUsuario; }
    getSenha() { return this.senha; }
    getTipo() { return this.tipo; }
    getEmail() { return this.email; }
}

export default Usuario;