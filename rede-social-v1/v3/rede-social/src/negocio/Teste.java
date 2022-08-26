// package negocio;

// import dados.*;

// public class Teste {
  
//   public static void main(String[] args) {
//     testarCadastro();
//     testarAutenticacao();
//     testarEdicaoDeUsuario();
//     testarObtencaoDeUsuario();
//     testarExclusaoDeUsuario();
//     testarCriacaoDePost();
//     testarObtencaoDePost();
//     testarExclusaoDePost();
//   }

//   public static void testarCadastro() {
//     Sistema sistema = new Sistema();

//     boolean t1 = true, t2 = true, t3 = true, t4 = true;

//     String resultado1 = sistema.cadastrarUsuario(
//         "Nome Sobrenome",
//         "nome.de.usuario.1",
//         "pedrofaria2002@hotmail.com",
//         "12345678");

//     String resultado2 = sistema.cadastrarUsuario(
//         "Pedro",
//         "ppedroffaria",
//         "pedrofaria2002@hotmail.com",
//         "12345678");

//     String resultado3 = sistema.cadastrarUsuario(
//         "Nome Sobrenome",
//         "nome.de.usuario.3",
//         "email invalido",
//         "123456");

//     String resultado4 = sistema.cadastrarUsuario(
//         "Nome Sobrenome",
//         "nome.de.usuario.1", // já existe!
//         "email@algumacoisa.com",
//         "12345678");

//     if (!resultado1.equals("Êxito"))
//       t1 = false;

//     if (!resultado2.equals("E-mail já existente!\nNome completo inserido muito curto!\n"))
//       t2 = false;

//     if (!resultado3.equals("E-mail inválido!\nSenha muito curta (< 8 caracteres)\n"))
//       t3 = false;

//     if (!resultado4.equals("Nome de usuário já existente!\n"))
//       t4 = false;

//     String resultadoFinal = "";
//     String status = (t1 && t2 && t3 && t4) ? "PASSOU" : "FALHOU";

//     resultadoFinal += "Teste do Cadastro: " + status + "\n";
//     resultadoFinal += "- Usuário inserido corretamente: " + (t1 ? "OK" : "ERRO") + "\n";
//     resultadoFinal += "- E-mail já existente e nome curto: " + (t2 ? "OK" : "ERRO") + "\n";
//     resultadoFinal += "- E-mail inválido e senha curta: " + (t3 ? "OK" : "ERRO") + "\n";
//     resultadoFinal += "- Nome de usuário já existente: " + (t4 ? "OK" : "ERRO") + "\n";

//     System.out.println(resultadoFinal);

//   }

//   public static void testarAutenticacao() {
//     Sistema sistema = new Sistema();
//     boolean t1 = true, t2 = true, t3 = true, t4 = true, t5 = true;

//     sistema.cadastrarUsuario(
//         "Fulano de Souza",
//         "fulaninho02",
//         "fulano@ciclano.com",
//         "87654321");

//     sistema.cadastrarUsuario(
//         "Ciclano de souza",
//         "ciclaninho02",
//         "ciclano@fulano.com",
//         "12345678");

//     boolean auth1 = sistema.autenticar(
//         "fulano@ciclano.com",
//         "12345678"); // Senha incorreta

//     boolean auth2 = sistema.autenticar(
//         "fulano@ciclano.com",
//         "87654321"); // OK

//     boolean auth3 = sistema.autenticar(
//         "ciclano@fulano.com",
//         "87654321"); // Senha incorreta

//     boolean auth4 = sistema.autenticar(
//         "ciclano@fulano.com",
//         "12345678"); // OK

//     boolean auth5 = sistema.autenticar(
//         "email@naoexistente.com",
//         "123123"); // E-mail não existente

//     if (auth1)
//       t1 = false;
//     if (!auth2)
//       t2 = false;
//     if (auth3)
//       t3 = false;
//     if (!auth4)
//       t4 = false;
//     if (auth5)
//       t5 = false;

//     String resultadoFinal = "";
//     String status = (t1 && t2 && t3 && t4 && t5) ? "PASSOU" : "FALHOU";

//     resultadoFinal += "Teste da Autenticação: " + status + "\n";
//     resultadoFinal += "- Senha incorreta 1: " + (t1 ? "OK" : "ERRO") + "\n";
//     resultadoFinal += "- Autenticação correta 1: " + (t2 ? "OK" : "ERRO") + "\n";
//     resultadoFinal += "- Senha incorreta 2: " + (t3 ? "OK" : "ERRO") + "\n";
//     resultadoFinal += "- Autenticação correta 2: " + (t4 ? "OK" : "ERRO") + "\n";
//     resultadoFinal += "- E-mail inválido: " + (t5 ? "OK" : "ERRO") + "\n";

//     System.out.println(resultadoFinal);
//   }

//   public static void testarEdicaoDeUsuario() {
//     Sistema s = new Sistema();

//     s.cadastrarUsuario("Pedro Fernandes", "ppedroffaria", "pedrofaria2002@hotmail.com", "12312345");

//     s.autenticar("pedrofaria2002@hotmail.com", "12312345");

//     s.editarUsuario("ppedroffaria-edit", "Pedro Faria Fernandes", "ppedroffaria2002@gmail.com", "biografia", Seguranca.obterHash("12312312"));

//     Usuario u = s.getUsuariosCadastrados().get(0);

//     boolean t1 = u.getNomeCompleto().equals("Pedro Faria Fernandes");
//     boolean t2 = u.getNomeUsuario().equals("ppedroffaria-edit");
//     boolean t3 = u.getEmail().equals("ppedroffaria2002@gmail.com");
//     boolean t4 = u.getBiografia().equals("biografia");
//     boolean t5 = u.getHashSenha().equals(Seguranca.obterHash("12312312"));

//     String resultadoFinal = "";
    
//     String status = (t1 && t2 && t3 && t4 && t5) ? "PASSOU" : "FALHOU";

//     resultadoFinal += "Teste de modificação de usuário: " + status + "\n";
//     resultadoFinal += "- O nome completo do usuário foi modificado no sistema: " + (t1 ? "OK" : "ERRO") + "\n";
//     resultadoFinal += "- O nome de usuário do usuário foi modificado no sistema: " + (t2 ? "OK" : "ERRO") + "\n";
//     resultadoFinal += "- O email do usuário foi modificado no sistema: " + (t3 ? "OK" : "ERRO") + "\n";
//     resultadoFinal += "- Uma nova biografia foi adicionada no sistema: " + (t4 ? "OK" : "ERRO") + "\n";
//     resultadoFinal += "- A senha do usuário foi atualizada: " + (t4 ? "OK" : "ERRO") + "\n";

//     System.out.println(resultadoFinal);
//   }

//   public static void testarObtencaoDeUsuario() {
//     Sistema s = new Sistema();

//     s.cadastrarUsuario("Pedro Faria", "ppedroffaria", "ppedroffaria2002@gmail.com", "12312345");
//     s.cadastrarUsuario("Fulano da Silva", "fulaninho02", "fulano@dasilva.com.br", "12312312");

//     s.autenticar("ppedroffaria2002@gmail.com", "12312345");

//     Usuario u = s.obterUsuario(1);

//     boolean t1 = u.getNomeCompleto().equals("Fulano da Silva");
//     boolean t2 = u.getNomeUsuario().equals("fulaninho02");
//     boolean t3 = u.getEmail().equals("fulano@dasilva.com.br");
//     boolean t4 = u.getHashSenha().equals(Seguranca.obterHash("12312312"));

//     String status = (t1 && t2 && t3 && t4) ? "PASSOU" : "FALHOU";
//     String resultadoFinal = "";

//     resultadoFinal = "Teste de obtenção de Usuário: " + status + "\n";
//     resultadoFinal += "- O nome correto foi encontrado: " + (t1 ? "OK" : "ERRO") + "\n";
//     resultadoFinal += "- O nome de usuário correto foi encontrado: " + (t2 ? "OK" : "ERRO") + "\n";
//     resultadoFinal += "- O email correto foi encontrado: " + (t3 ? "OK" : "ERRO") + "\n";
//     resultadoFinal += "- O Hash correto de senha foi encontrado: " + (t4 ? "OK" : "ERRO") + "\n";

//     System.out.println(resultadoFinal);
  
//   }

//   public static void testarExclusaoDeUsuario() {
//     Sistema s = new Sistema();

//     s.cadastrarUsuario("Pedro Faria", "ppedroffaria", "ppedroffaria2002@gmail.com", "12312345");
//     s.cadastrarUsuario("Fulano da Silva", "fulaninho02", "fulano@dasilva.com.br", "12312312");

//     s.autenticar("ppedroffaria2002@gmail.com", "12312345");

//     s.excluirUsuario();

//     Usuario u = s.getUsuariosCadastrados().get(0);

//     boolean t1 = s.getUsuariosCadastrados().size() == 1;
//     boolean t2 = u.getNomeCompleto().equals("Fulano da Silva");
//     boolean t3 = u.getNomeUsuario().equals("fulaninho02");
//     boolean t4 = u.getEmail().equals("fulano@dasilva.com.br");
//     boolean t5 = u.getHashSenha().equals(Seguranca.obterHash("12312312"));

//     String status = (t1 && t2 && t3 && t4 && t5) ? "PASSOU" : "FALHOU";
//     String resultadoFinal = "Teste de exclusão de usuários: " + status + "\n";
//     resultadoFinal += "- O tamanho da lista de usuários cadastrados diminuiu: " + (t1 ? "OK" : "ERRO") + "\n";
//     resultadoFinal += "- O nome completo do usuário que não foi removido foi encontrado: " + (t2 ? "OK" : "ERRO") + "\n";
//     resultadoFinal += "- O nome de usuário do usuário que não foi removido foi encontrado: " + (t3 ? "OK" : "ERRO") + "\n";
//     resultadoFinal += "- O email correto do usuário que não foi removido foi encontrado: " + (t4 ? "OK" : "ERRO") + "\n";
//     resultadoFinal += "- O hash de senha correto do usuário que não foi removido foi encontrado: " + (t5 ? "OK" : "ERRO") + "\n";

//     System.out.println(resultadoFinal);
//   }

//   public static void testarCriacaoDePost() {
//         Sistema s = new Sistema();

//     s.cadastrarUsuario("Pedro Faria", "ppedroffaria", "ppedroffaria2002@gmail.com", "12312345");
    
//     s.autenticar("ppedroffaria2002@gmail.com", "12312345");
    
//     boolean t = s.novoPost("https://url.foto.com", "Legenda da minha mais nova publicação", "30/05/2022");

//     String status = (t ? "PASSOU" : "FALHOU");
//     String resultadoFinal = "";

//     resultadoFinal += "Teste de criação de posts: " + status + "\n";
//     resultadoFinal += "- O post foi criado com sucesso: " + (t ? "OK" : "ERRO") + "\n";

//     System.out.println(resultadoFinal);

//   }

//   public static void testarObtencaoDePost() {
//     Sistema s = new Sistema();

//     s.cadastrarUsuario("Pedro Faria", "ppedroffaria", "ppedroffaria2002@gmail.com", "12312345");

//     s.autenticar("ppedroffaria2002@gmail.com", "12312345");

//     s.novoPost("https://url.foto.com", "Legenda da minha mais nova publicação", "30/05/2022");

//     s.novoPost("https://url.foto2.com", "Legenda de um novo post", "30/05/2022");

//     boolean t1 = s.obterPost(0).getUrlFoto().equals("https://url.foto.com");
//     boolean t2 = s.obterPost(1).getUrlFoto().equals("https://url.foto2.com");

//     String status = (t1 && t2) ? "PASSOU" : "FALHOU";
//     String resultadoFinal = "";

//     resultadoFinal += "Teste de obtenção de posts: " + status + "\n";
//     resultadoFinal += "- Post 1 encontrado com sucesso: " + (t1 ? "OK" : "ERRO") + "\n";
//     resultadoFinal += "- Post 2 encontrado com sucesso: " + (t2 ? "OK" : "ERRO") + "\n";

//     System.out.println(resultadoFinal);
    
//   }

//   public static void testarExclusaoDePost() {
//     Sistema s = new Sistema();

//     s.cadastrarUsuario("Pedro Faria", "ppedroffaria", "ppedroffaria2002@gmail.com", "12312345");

//     s.autenticar("ppedroffaria2002@gmail.com", "12312345");

//     s.novoPost("https://url.foto.com", "Legenda da minha mais nova publicação", "30/05/2022");

//     s.novoPost("https://url.foto2.com", "Legenda de um novo post", "30/05/2022");

//     boolean t1 = s.excluirPost(0);
//     boolean t2 = s.getPosts().get(0).getUrlFoto().equals("https://url.foto2.com");

//     s.novoPost("https://url.foto3.com", "Legenda de um mais novo ainda post", "30/05/2022");

//     boolean t3 = s.excluirPost(1);
//     boolean t4 = s.getPosts().get(0).getUrlFoto().equals("https://url.foto2.com");

//     String status = (t1 && t2 && t3 && t4) ? "PASSOU" : "FALHOU";
//     String resultadoFinal = "";

//     resultadoFinal += "Teste da exclusão de posts: " + status + "\n";
//     resultadoFinal += "- O primeiro post foi excluído com sucesso: " + (t1 ? "OK" : "ERRO") + "\n";
//     resultadoFinal += "- A lista foi atualizada corretamente após a primeira exclusão: " + (t2 ? "OK" : "ERRO") + "\n";
//     resultadoFinal += "- O segundo post foi excluído com sucesso: " + (t3 ? "OK" : "ERRO");
//     resultadoFinal += "- A lista foi atualizada corretamente após a segunda exclusão: " + (t4 ? "OK" : "ERRO") + "\n";

//     System.out.println(resultadoFinal);
//   }
  
// }