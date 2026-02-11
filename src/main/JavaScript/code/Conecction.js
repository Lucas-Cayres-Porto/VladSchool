import Aluno from './Aluno.js';

const url = 'http://localhost:8080/TrabalhoDSV2/';

async function criarAluno(aluno=Aluno) {
    try {
        aluno = aluno.paraJson();

        //metodo que que envia e conecta no backend para criar um aluno
        const resposta = await fetch(`${url}app/aluno/criar`, {
            method: 'POST',
            headers: {
                //seta o tipo de conteudo para json, para o backend entender que é um json
                'Content-Type': 'application/json',
            },
            //transforma para string o json aluno
            body: JSON.stringify(aluno)
        });

        // Verificar se a resposta foi ok
        if (!resposta.ok) {
            throw new Error(`Erro HTTP: ${resposta.status}`);
        }

        // Converter resposta para json
        const dadosResposta = await resposta.json();
        console.log('sucesso:', dadosResposta);
        

        //retorna os dados da resposta para o frontend
        return dadosResposta;
        
        //try e catch, igual o java
    } catch (e) {
        //mensagem de erro, como no front é menos comum n tem um tratamento completo
        console.error('erro ao enviar:', e);
    }
    
}


async function exibirAlunoPorNome(nome=String) {
    try {
        //constante do tipo de busca
        const tipo = "nome";
        //cria a url com os parametros, e usa fetch para fazer a requisição get
        const resposta = await fetch(`${url}app/aluno/exibir?tipo=${tipo}&nome=${(nome)}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            }
        });
        //verifica se a resposta foi ok
        if (!resposta.ok) {
            throw new Error(`Erro HTTP: ${resposta.status}`);
        }

        //converte a resposta para json
        const dadosResposta = await resposta.json();
        //separa da resposta de sucesso para resposta de aluno
        const alunosArray = dadosResposta.alunos;


        if (Array.isArray(alunosArray)) {
            // lista para armazenar objetos aluno
            const listaAlunos = [];
            //pega o lenght da respsota
            const length = alunosArray.length;
            //for de respostas
            for (let i = 0; i < length; i++) {

                //converte cada json da resposta para um objeto aluno usando o metodo deJson da classe Aluno, e adiciona na lista de alunos
                const alunoJson = alunosArray[i];
                //converte para objeto
                const alunoObj = Aluno.deJson(alunoJson);
                //coloca na lista
                listaAlunos.push(alunoObj);

            }
            //retorna lista de retorna
            return listaAlunos;

        }
    } catch (e) {
        console.error('Erro ao buscar aluno por nome:', e);
    }
    
}


async function exibirAlunoPorSerie(serie=String) {
    try {
        //constante do tipo de busca
        const tipo = "serie";
        //cria a url com os parametros, e usa fetch para fazer a requisição get
        const resposta = await fetch(`${url}app/aluno/exibir?tipo=${tipo}&serie=${(serie)}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            }
        });
        //verifica se a resposta foi ok
        if (!resposta.ok) {
            throw new Error(`Erro HTTP: ${resposta.status}`);
        }

        //converte a resposta para json
        const dadosResposta = await resposta.json();
        //separa da resposta de sucesso para resposta de aluno
        const alunosArray = dadosResposta.alunos;


        if (Array.isArray(alunosArray)) {
            // lista para armazenar objetos aluno
            const listaAlunos = [];
            //pega o lenght da respsota
            const length = alunosArray.length;
            //for de respostas
            for (let i = 0; i < length; i++) {

                //converte cada json da resposta para um objeto aluno usando o metodo deJson da classe Aluno, e adiciona na lista de alunos
                const alunoJson = alunosArray[i];
                //converte para objeto
                const alunoObj = Aluno.deJson(alunoJson);
                //coloca na lista
                listaAlunos.push(alunoObj);

            }
            //retorna lista de retorna
            return listaAlunos;

        }
    } catch (e) {
        console.error('Erro ao buscar aluno por nome:', e);
    }
    
}


async function exibirAlunoPorStatus(status=String) {
    try {
        //constante do tipo de busca
        const tipo = "status";
        //cria a url com os parametros, e usa fetch para fazer a requisição get
        const resposta = await fetch(`${url}app/aluno/exibir?tipo=${tipo}&status=${(status)}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            }
        });
        //verifica se a resposta foi ok
        if (!resposta.ok) {
            throw new Error(`Erro HTTP: ${resposta.status}`);
        }

        //converte a resposta para json
        const dadosResposta = await resposta.json();
        //separa da resposta de sucesso para resposta de aluno
        const alunosArray = dadosResposta.alunos;


        if (Array.isArray(alunosArray)) {
            // lista para armazenar objetos aluno
            const listaAlunos = [];
            //pega o lenght da respsota
            const length = alunosArray.length;
            //for de respostas
            for (let i = 0; i < length; i++) {

                //converte cada json da resposta para um objeto aluno usando o metodo deJson da classe Aluno, e adiciona na lista de alunos
                const alunoJson = alunosArray[i];
                //converte para objeto
                const alunoObj = Aluno.deJson(alunoJson);
                //coloca na lista
                listaAlunos.push(alunoObj);

            }
            //retorna lista de retorna
            return listaAlunos;

        }
    } catch (e) {
        console.error('Erro ao buscar aluno por nome:', e);
    }
    
}






async function exibirAlunoPorIndex(index=String) {
    try {
        //constante do tipo de busca
        const tipo = "index";
        //cria a url com os parametros, e usa fetch para fazer a requisição get
        const resposta = await fetch(`${url}app/aluno/exibir?tipo=${tipo}&indice=${(index)}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            }
        });
        //verifica se a resposta foi ok
        if (!resposta.ok) {
            throw new Error(`Erro HTTP: ${resposta.status}`);
        }

        //converte a resposta para json
        const dadosResposta = await resposta.json();
        //separa da resposta de sucesso para resposta de aluno
        const alunosArray = dadosResposta.alunos;


        if (Array.isArray(alunosArray)) {
            // lista para armazenar objetos aluno
            const listaAlunos = [];
            //pega o lenght da respsota
            const length = alunosArray.length;
            //for de respostas
            for (let i = 0; i < length; i++) {

                //converte cada json da resposta para um objeto aluno usando o metodo deJson da classe Aluno, e adiciona na lista de alunos
                const alunoJson = alunosArray[i];
                //converte para objeto
                const alunoObj = Aluno.deJson(alunoJson);
                //coloca na lista
                listaAlunos.push(alunoObj);

            }
            //retorna lista de retorna
            return listaAlunos;

        }
    } catch (e) {
        console.error('Erro ao buscar aluno por nome:', e);
    }
    
}


async function deletarAluno(id=String) {
    try {
        //constante do tipo de busca

        //cria a url com os parametros, e usa fetch para fazer a requisição post
        const resposta = await fetch(`${url}app/aluno/deletar?_id=${id}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            }
        });
        //verifica se a resposta foi ok
        if (!resposta.ok) {
            throw new Error(`Erro HTTP: ${resposta.status}`);
        }

        //converte a resposta para json
        const dadosResposta = await resposta.json();
        //separa da resposta de sucesso para resposta de aluno

        return dadosResposta;
    } catch (e) {
        console.error('Erro ao buscar aluno por nome:', e);
    }
    
}



//no JS n tem tipagem, portanto usamos o = para dizer que os atributos da função só aceitam string e Aluno
async function atualizarAluno(id=String, aluno=Aluno) {
    try {
        aluno = aluno.paraJson();

        //metodo que que envia e conecta no backend para atualizar um aluno
        const resposta = await fetch(`${url}app/aluno/atualizar?_id=${id}`, {
            method: 'POST',
            headers: {
                //seta o tipo de conteudo para json, para o backend entender que é um json
                'Content-Type': 'application/json',
            },
            //transforma para string o json aluno
            body: JSON.stringify(aluno)
        });

        // Verificar se a resposta foi ok
        if (!resposta.ok) {
            throw new Error(`Erro HTTP: ${resposta.status}`);
        }

        // Converter resposta para json
        const dadosResposta = await resposta.json();
        console.log('sucesso:', dadosResposta);
        

        //retorna os dados da resposta para o frontend
        return dadosResposta;
        
        //try e catch, igual o java
    } catch (e) {
        //mensagem de erro, como no front é menos comum n tem um tratamento completo
        console.error('erro ao enviar:', e);
    }
    
}




export { criarAluno, exibirAlunoPorIndex, exibirAlunoPorNome, exibirAlunoPorSerie, exibirAlunoPorStatus, deletarAluno, atualizarAluno };