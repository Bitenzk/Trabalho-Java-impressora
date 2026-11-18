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
            while(opcao != 0);
        }
        int lerNumero(String mensagem) {
            while(true) {
                System.out.print(mensagem);
                try {
                    int numero = sc.nextInt();
                    sc.nextLine(); // Limpar o buffer
                    return numero;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada invalida. Por favor, digite um numero.");
                    sc.nextLine(); // Limpar o buffer
                }
            }
        }
        int lerNumeroEntre(String mensagem, int min, int max) {
            while(true) {
                int numero = lerNumero(mensagem);
                if (numero >= min && numero <= max) {
                    return numero;
                } else {
                    System.out.println("Entrada invalida. Por favor, digite um numero entre " + min + " e " + max + ".");
                }
            }

            String lerArquivo(String caminho) {
                try {
                    return Files.readString(Paths.get(caminho));
                } catch (IOException e) {
                    System.out.println("Erro ao ler o arquivo: " + caminho);
                    return null;
                }
        }

    }
    public class Impressora{
        private int tipo;
        private String conexao;
        private int parametro;
        private boolean conexaoAberta = false;
        private String modelo;

        private static final String ASS_QRCODE_CANCELAMENTO = 
        "Q5DLkpdRijIRGY6YSSNsTWK1TztHL1vD0V1Jc4spo/CEUqICEb9SFy82ym8EhBRZjbh3btsZhF+sjHqEMR159i4agru9x6KsepK/q0"
                    + "E2e5xlU5cv3m1woYfgHyOkWDNcSdMsS6bBh2Bpq6s89yJ9Q6qh/J8YHi306ce9Tqb/drKvN2XdE5noRSS32TAWuaQEVd7u+TrvXlOQ"
                    + "sE3fHR1D5f1saUwQLPSdIv01NF6Ny7jZwjCwv1uNDgGZONJdlTJ6p0ccqnZvuE70aHOI09elpjEO6Cd+orI7XHHrFCwhFhAcbalc+Z"
                    + "fO5b/+vkyAHS6CYVFCDtYR9Hi5qgdk31v23w==";
       public Impressora(){
        this.tipo = 1;
        this.modelo = "i9";
        this.conexao = "USB";
        this.parametro = 0;
       }

       void configurarImpressora(int tipo, String modelo, String conexao, int parametro) {
            this.tipo = tipo;
            this.modelo = modelo;
            this.conexao = conexao;
            this.parametro = parametro;
            System.out.println("Dados da impressora configurados com sucesso!");
        }

        boolean abrirConexao() {
            if (!conexaoAberta) {
                System.out.println("Conexao ja esta aberta.");
                return false;
            }
            return true;
        }

        boolean isConexaoAberta() {
            return conexaoAberta;
        }

        void abrirConexao(){
            if (conexaoAberta) {
                System.out.println("Conexao ja esta aberta.");
                return;
            }
            try {
                int retorno = ImpressoraJNI.abrirConexao(tipo, modelo, conexao, parametro);
                if (retorno == 0) {
                    conexaoAberta = true;
                    System.out.println("Conexao com a impressora aberta com sucesso!");
                } else {
                    System.out.println("Falha ao abrir conexao com a impressora. Codigo de erro: " + retorno + "(confira se a impressora esta ligada e conectada corretamente!)");
                }
            } catch (UnsatisfiedLinkError | NoClassDefFoundError e) {
                System.out.println("Erro ao abrir conexao com a impressora." + e.getMessage());
            }
        }

        void fecharConexao() {
            if (!conexaoAberta) {
                System.out.println("Conexao ja esta fechada.");
                return;
            }
            int retorno = ImpressoraDLL.INSTANCE.FecharConexao();
            if (retorno == 0) {
                conexaoAberta = false;
                System.out.println("Conexao com a impressora fechada com sucesso!");
            } else {
                System.out.println("Falha ao fechar conexao com a impressora. Codigo de erro: " + retorno);
            }
        }

         void imprimirTexto(String texto, int copias) {
        for (int i = 1; i <= copias; i++) {
            int retorno = ImpressoraDLL.INSTANCE.ImpressaoTexto(texto, 1, 0, 0); // centro, fonte A, normal
            if (retorno < 0) {
                System.out.println("Erro ao imprimir a copia " + i + ". Retorno: " + retorno);
                return;
            }
            cortar();
        }
        System.out.println(copias + " copia(s) impressa(s) com sucesso.");
    }
        void imprimirQRCode(String conteudo) {
            int retorno = ImpressoraDLL.INSTANCE.ImpressaoQRCode(conteudo, 4, 2);
            if (retorno == 0) {
                cortar();
                System.out.println("QR Code impresso com sucesso!");
            } else {
                System.out.println("Erro ao imprimir QR Code. Retorno: " + retorno);
            }
        }
        void imprimirCodigoBarras(String codigo) {
            int retorno = ImpressoraDLL.INSTANCE.ImpressaoCodigoBarras(codigo, 100, 2, 2);
            if (retorno == 0) {
                cortar();
                System.out.println("Codigo de barras impresso com sucesso!");
            } else {
                System.out.println("Erro ao imprimir codigo de barras. Retorno: " + retorno);
            }
        }

        void imprimirXMLSAT(String xml) {
            int retorno = ImpressoraDLL.INSTANCE.ImpressaoXMLSAT(xml);
            if (retorno == 0) {
                cortar();
                System.out.println("XML SAT impresso com sucesso!");
            } else {
                System.out.println("Erro ao imprimir XML SAT. Retorno: " + retorno);
            }
        }

        void imprimirXMLCancelamento(String xml) {
            int retorno = ImpressoraDLL.INSTANCE.ImpressaoXMLCancelamentoSAT(xml, ASS_QRCODE_CANCELAMENTO);
            if (retorno == 0) {
                cortar();
                System.out.println("XML de cancelamento SAT impresso com sucesso!");
            } else {
                System.out.println("Erro ao imprimir XML de cancelamento SAT. Retorno: " + retorno);
            }
        }

        void abrirGaveta() {
            int retorno = ImpressoraDLL.INSTANCE.AbrirGaveta(1, 5, 10);
            if (retorno == 0) {
                System.out.println("Gaveta aberta com sucesso!");
            } else {
                System.out.println("Erro ao abrir gaveta. Retorno: " + retorno);
            }
        }

        void sinalSonoro(int bips) {
            int retorno = ImpressoraDLL.INSTANCE.SinalSonoro(bips, 50, 5);
            if (retorno == 0) {
                System.out.println("Bip!(" + bips + " vezes)");
            } else {
                System.out.println("Erro ao emitir sinal sonoro. Retorno: " + retorno + "(as vezes as impressoras não apitam)");
            }
        }

        void avancarPapel(int linhas) {
            int retorno = ImpressoraDLL.INSTANCE.AvancarPapel(linhas);
            if (retorno == 0) {
                System.out.println("Papel avançado " + linhas + " linha(s)");
            } else {
                System.out.println("Erro ao avançar papel. Retorno: " + retorno);
            }
        }
        void statusPapel() {
        int retorno = ImpressoraDLL.INSTANCE.StatusImpressora(3);
        switch (retorno) {
            case 5:
                System.out.println("Status: tem papel.");
                break;
            case 6:
                System.out.println("Status: papel acabando.");
                break;
            case 7:
                System.out.println("Status: sem papel!");
                break;
            default:
                System.out.println("Nao foi possivel ler o status do papel. Retorno: " + retorno);
        }
    }

        private void cortar() {
            int retorno = ImpressoraDLL.INSTANCE.Corte(1);
            if (retorno != 0) {
                System.out.println("Erro ao cortar o papel. Retorno: " + retorno);
            }
        }
    }
