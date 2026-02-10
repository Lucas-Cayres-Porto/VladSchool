//CLASSE PURAMENTE DE TESTE
//TUDO FEITO POR IA
//NADA DISSO SERA UTILIZADO NO PROJETO REAL





import Usuario from './Usuario.js';
import Aluno from './Aluno.js';
import Notas from './Notas.js';
import Observacoes from './Observacoes.js';

// Criando algumas notas para o aluno
const nota1 = new Notas(1, 101, 8.5, "2024-1");
const nota2 = new Notas(2, 102, 9.0, "2024-1");

// Criando algumas observações para o aluno
const obs1 = new Observacoes(1, "2024-03-15", "Aluno participativo nas aulas");
const obs2 = new Observacoes(2, "2024-04-20", "Precisa melhorar na entrega de trabalhos");

// Instanciando o objeto Aluno
const alunoTeste = new Aluno(
    "João Silva",                // nome
    "joao.silva",                // nomeUsuario
    "senha123",                  // senha
    "aluno",                     // tipo
    "joao@escola.com",           // email
    "20240001",                  // matricula
    "9º ano",                    // serie
    "ativo",                     // status
    [nota1, nota2],              // notas
    [obs1, obs2]                 // observacoes
);

const jsonAluno = alunoTeste.paraJson();




async function enviarDados() {
    try {
        const resposta = await fetch('http://localhost:8080/TrabalhoDSV2/app/aluno/criar', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(jsonAluno)
        });

        // Verificar se a resposta foi ok
        if (!resposta.ok) {
            throw new Error(`Erro HTTP: ${resposta.status}`);
        }

        // Converter resposta para JSON
        const dadosResposta = await resposta.json();
        console.log('Sucesso:', dadosResposta);
        
        return dadosResposta;
    } catch (erro) {
        console.error('Erro ao enviar:', erro);
    }
}

enviarDados();