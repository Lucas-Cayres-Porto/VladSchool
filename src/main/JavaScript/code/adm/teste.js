import { logarAdm, exibirAdmPorEmail, enviarEmailAdm , recuperarAdm} from "./ConnectionAdm.js";
import readline from 'readline';

function perguntar(pergunta) {
  const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
  });
  
  return new Promise((resolve) => {
    rl.question(pergunta, (resposta) => {
      rl.close();
      resolve(resposta);
    });
  });
}

// 1. Primeiro enviar o email
const email = "nicolas25vlad@gmail.com";
console.log("1. Enviando código para:", email);
const envio = await enviarEmailAdm(email);
console.log("2. Resposta do envio:", envio);

// 2. Depois pedir o código
const codigo = await perguntar('3. Digite o código recebido: ');
console.log("4. Código digitado:", codigo);

// 3. Verificar o código
console.log("5. Verificando código...");
const verificacao = await recuperarAdm(email, codigo);
console.log("6. Resposta completa:", verificacao);