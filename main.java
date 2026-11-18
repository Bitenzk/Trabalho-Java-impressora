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