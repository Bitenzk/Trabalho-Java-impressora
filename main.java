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
        }
    }
}