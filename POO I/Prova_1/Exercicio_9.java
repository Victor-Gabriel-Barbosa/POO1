import java.util.Scanner;

public class Exercicio_9 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Info info[] = new Info[150];
        int tam = 2, a, b, c;
        for (int i = 0; i < tam; i++) {
            LimparTela.limpar("Aperte [ENTER] para continuar... ");
            System.out.print("Digite o 1º número: ");
            a = entrada.nextInt();
            System.out.print("Digite o 2º número: ");
            b = entrada.nextInt();
            System.out.print("Digite o 3º número: ");
            c = entrada.nextInt();
            info[i] = new Info(a, b, c);
        }
        LimparTela.limpar("Aperte [ENTER] para continuar... ");
        for (int i = 0; i < tam; i++) {
            double resultado[] = info[i].computar();
            System.out.println("--------------------------------");
            System.out.println("Informações do " + (i + 1) + "º elemento:");
            System.out.println("Soma: " + resultado[0]);
            System.out.println("Média: " + resultado[1]);
            System.out.println("Raiz quadrada do 1º número: " + resultado[2]);
            System.out.println("Raiz quadrada do 2º número: " + resultado[3]);
            System.out.println("Raiz quadrada do 3º número: " + resultado[4]);
            System.out.println("Maior número: " + resultado[5]);
            System.out.println("Menor número: " + resultado[6]);
            System.out.println("--------------------------------");
        }
        entrada.close();
    }
        
}
