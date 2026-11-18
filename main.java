Main
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Usuario usuario = new Usuario("admin", "12345");

        boolean logado = false;
        for (int tentativa = 1; tentativa ,= 3; tentativa++){
            System.out.println("Usuario: ");
            String login = sc.nextLine();
            System.out.println("Senha: ");
            String senha = sc.nextLine();

            if(usuario.autenticar(login, senha)) {
                logado = true;
                System.out.println("Bem-vindo, " + usuario.getLogin() + "!");
                break;
            }
            System.out.println("Usuario ou senha incorretos. Tentativas restantes: " + (3 - tentativa));
        }
        if (!logado) {
            System.out.println("Número máximo de tentativas atingido. Acesso negado.");
            sc.close();
            return;
        }

        impressora impressora = new impressora();
        Menu menu = new Menu(impressora, sc);

        menu.executar();

        if(impressora.isConexaoAberta()) {
            impressora.fecharConexao();
            System.out.println("Conexão com a impressora fechada.");
        }
        sc.close();
    }
}

public class Usuario {
    private String login;
    private String senha;

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public boolean autenticar(String login, String senha) {
        return this.login.equals(login) && this.senha.equals(senha);
    }

    public String getLogin() {
        return login;
    }
}

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.InputMismatchException;

public class Menu{
    private impressora impressora;
    private Scanner sc;

    public Menu(impressora impressora, Scanner sc) {
        this.impressora = impressora;
        this.sc = sc;
    }

    void mostrarMenu() {
        System.out.println("=== Menu ===");
         System.out.println("1  - Configurar impressora");
        System.out.println("2  - Abrir conexao");
        System.out.println("3  - Fechar conexao");
        System.out.println("4  - Imprimir texto");
        System.out.println("5  - Imprimir QR Code");
        System.out.println("6  - Imprimir codigo de barras");
        System.out.println("7  - Imprimir XML SAT");
        System.out.println("8  - Imprimir XML de cancelamento SAT");
        System.out.println("9  - Abrir gaveta");
        System.out.println("10 - Sinal sonoro");
        System.out.println("11 - Avancar papel");
        System.out.println("12 - Status do papel");
        System.out.println("0  - Sair");
    }

    void executar(){
        int opcao;

        do{
            mostrarMenu();
            opcao = lerOpcao("Digite a opcao desejada: ");

            switch(opcao){
                case 1:
                    int tipo = lerOpcao("Digite o tipo de impressora (1 - USB, 2 - Serial, 3 - Rede, 4 - Bluetooth): ", 1 4);
                    system.out.println("Digite o modelo da impressora: ");
                    String modelo = sc.nextLine();
                    System.out.println("Digite a porta da impressora: ");
                    String porta = sc.nextLine();
                    int parametro = lerNumero("Parametro (ex: USB, COM2 ou iP); ");
                    break;
                case 2:
                    impressora.abrirConexao();
                    break;

                case 3:
                    impressora.fecharConexao();
                    break;
                case 4: 
                    if (!impressora.verificarConexao()) break;
                    System.out.println("Digite o texto a ser impresso: ");
                    String texto = sc.nextLine();
                    int copias = lerNumero("Digite o número de cópias: ");
                    impressora.imprimirTexto(texto, copias);    
                    break;
                    
                                case 5:
                    if (!impressora.verificarConexao()) break;
                    System.out.print("Conteudo do QR Code (ex.: um site): ");
                    String conteudoQR = sc.nextLine();
                    impressora.imprimirQRCode(conteudoQR);
                    break;

                case 6:
                    if (!impressora.verificarConexao()) break;
                    System.out.print("Numero do codigo de barras (ex.: 012345678912): ");
                    String codigo = sc.nextLine();
                    impressora.imprimirCodigoBarras(codigo);
                    break;

                case 7:
                    if (!impressora.verificarConexao()) break;
                    String xmlVenda = lerArquivo("XMLSAT.xml");
                    if (xmlVenda != null) {
                        impressora.imprimirXMLSAT(xmlVenda);
                    }
                    break;

                case 8:
                    if (!impressora.verificarConexao()) break;
                    String xmlCanc = lerArquivo("CANC_SAT.xml");
                    if (xmlCanc != null) {
                        impressora.imprimirXMLCancelamento(xmlCanc);
                    }
                    break;
                case 9:
                    if (!impressora.verificarConexao()) break;
                    impressora.abrirGaveta();
                    break;

                case 10:
                    if (!impressora.verificarConexao()) break;
                    int bips = lerNumeroEntre("Quantos bips (1 a 63)? ", 1, 63);
                    impressora.sinalSonoro(bips);
                    break;

                case 11:
                    if (!impressora.verificarConexao()) break;
                    int linhas = lerNumeroEntre("Quantas linhas avancar (1 a 20)? ", 1, 20);
                    impressora.avancarPapel(linhas);
                    break;

                int linhas = lerNumeroEntre("Quantas linhas avancar (1 a 20)? ", 1, 20);
                    impressora.avancarPapel(linhas);
                    break;

                case 12:
                    if (!impressora.verificarConexao()) break;
                    impressora.statusPapel();
                    break;

                case 0:
                    System.out.println("Saindo... ate mais!");
                    break;

                default:
                    System.out.println("Opcao invalida.");
            }


            }

        }
    }
