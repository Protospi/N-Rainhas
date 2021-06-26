
// Importa biblioteca de utilidades para escanear entrada do usuário
import java.util.*;

// Declara nova classe de exceção
class inteiroNaoPositivo extends Exception {

    // Declara variável
    private int naoPositivo = 0;

    // Construtor com argumento de inteiro
    public inteiroNaoPositivo(int numero) {

        // Declara atributo número
        this.naoPositivo = numero;
    }
}

// Declara classe publica principal
public class NRainhas {

    // Declara classe publica estática com retorno vazio
    public static void main(String[] args) {

        // Declara variáveis
        int numeroEntrada = 0;
        int n = 0;

        // Inicializa escaneador entrada
        Scanner entrada = new Scanner(System.in);

        // Teste de entrada
        try {

            // Solicita entrada do usuário
            System.out.println("Por favor insira a quantidade de Rainhas:");

            // Declara entrada
            numeroEntrada = entrada.nextInt();

            // Condição de negativo
            if (numeroEntrada < 0) {

                // Lança exceção de inteiro não negativo
                throw new inteiroNaoPositivo(numeroEntrada);
            }

            // Caso contrário declara variável n com entrada do usuário
            n = numeroEntrada;

        // Captura exceção de não positivo
        } catch (inteiroNaoPositivo e) {

            // Menssagem para usuário
            System.out.println("Entrada de inteiro negativo recusada!\n");
            main(args);

        // Captura exceção de entrada diferente de inteiro
        } catch (InputMismatchException e) {

            // Menssagem de entrada diferente de inteiro
            System.out.println("Entrada diferente de inteiro recusada!\n");
            main(args);

        // Retorno dos testes
        } finally {

            // Chama a função nRainhas passando n por referência
            nRainhas(n);
        }

    }

    // Declara função estática privada NRainhas
    private static void nRainhas(int n) {

        // Declara tabuleiro com dimensão de N_rainhas
        int [] tabuleiro = new int[n];

        // Posiciona rainhas no tabuleiro
        posicione(tabuleiro, 0, n);
    }

    // Declare função privada posicione com retorno vazio
    private static void posicione(int[] tabuleiro, int coluna, int n) {

        // Condição de parada considerando o tamanho do problema
        if (coluna == n) {

            // Se verdadeiro imprime o tabuleiro
            imprima(tabuleiro);

            // Retorna vazio
            return;
        }

        // Laço para posicionar as rainhas
        for (int i = 0; i < n; i++) {

            // Popula rainha da vez para teste
            tabuleiro[coluna] = i;

            // Condição de verificação da posição
            if (verifique(tabuleiro, coluna)) {

                // Se verdadeiro popula tabuleiro
                posicione(tabuleiro, coluna + 1, n);
            }
        }
    }

    // Declara função de verificação privada com retorno boleano
    private static boolean verifique(int[] tabuleiro, int coluna) {

        // Laço para verificar linha
        for (int i = 0; i < coluna; i++) {

            // Verfica condição de linha
            if (tabuleiro[i] == tabuleiro[coluna])

                // Se verdadeiro retorna falso ou posição não segura
                return false;

            // Verifica condição de diagonal
            if ((coluna - i) == Math.abs(tabuleiro[coluna] - tabuleiro[i])) {

                // Se verdadeiro retorna falso ou posição não segura
                return false;
            }
        }

        // Retorna verdadeiro se a posição é segura
        return true;
    }

    // Declara função imprima estatica privada com retorno vazio
    private static void imprima(int[] tabuleiro) {

        // Declara tamanho do tabuleiro
        int tamanho = tabuleiro.length;

        // Condição de Separação
        if(tamanho > 1) {

            // Quebra de linha e divisão
            System.out.print("-----------------------------------");
            System.out.print("\n");
        }

        // Laço para impressão do tabuleiro
        for (int i = 0; i < tamanho; i++) {
            for (int valor : tabuleiro) {

                // Condição de Rainhas
                if (valor == i && tamanho > 1)

                    // Imprime rainha
                    System.out.print("R\t");

                else if(valor != i && tamanho > 1)

                    // Imprime posição vazia
                    System.out.print(".\t");
            }

            // Condição de quebra de linha
            if(tamanho > 1)

                // Imprime quebra de linha e separador
                System.out.print("\n");
        }
    }
}