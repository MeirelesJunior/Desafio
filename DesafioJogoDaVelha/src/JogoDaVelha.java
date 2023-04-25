import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        char[][] jogoVelha = new char[3][3];

        System.out.println("Bem vindo!, vamos jogar uma partida de jogo da velha?");
        System.out.println("Player 1 = X");
        System.out.println("Player 2 = O");

        boolean ganhou = false; // flag pra finalizar o jogo
        int jogada = 1;
        char sinal; // identificando o sinal de cada jogador
        int linha = 0, coluna = 0;

        while (!ganhou) {

            if (jogada % 2 == 1) {//jogador1

                System.out.println("Turno do jogador 1: Escolha linha e coluna (1-3).");
                sinal = 'X';
            } else {

                System.out.println("Turno do jogador 2: Escolha linha e coluna (1-3).");
                sinal = 'O';
            }

            boolean linhavalida = false;
            while (!linhavalida) {
                System.out.println("Entre com a linha (1,2 ou 3)");
                linha = leitor.nextInt();
                if (linha >= 1 && linha <= 3) {
                    linhavalida = true;
                } else {
                    System.out.println("Entrada inválida, tente novamente.");
                }

            }

            boolean colunaValida = false;
            while (!colunaValida) {
                System.out.println("Entre com a coluna (1,2 ou 3");
                coluna = leitor.nextInt();
                if (coluna >= 1 && coluna <= 3) {
                    colunaValida = true;
                } else {
                    System.out.println("Entrada inválida, tente novamente.");
                }
            }

            linha--;
            coluna--;
            //Verificando se a matriz já foi preenchida
            if (jogoVelha[linha][coluna] == 'X' || jogoVelha[linha][coluna] == 'O') {
                System.out.println("Posição já usada, tente novamente");
            } else {
                jogoVelha[linha][coluna] = sinal;
                jogada++;
            }

            //Imprimindo o tabuleiro.
            for (int i = 0; i < jogoVelha.length; i++) {
                for (int j = 0; j < jogoVelha[i].length; j++) {
                    System.out.print(jogoVelha[i][j] + " | ");
                }
                System.out.println();
            }

            //Verificando se tem ganhador
            if ((jogoVelha[0][0] == 'X' && jogoVelha[0][1] == 'X' && jogoVelha[0][2] == 'X') ||//linha1
                    (jogoVelha[1][0] == 'X' && jogoVelha[1][1] == 'X' && jogoVelha[1][2] == 'X') || //linha2
                    (jogoVelha[2][0] == 'X' && jogoVelha[2][1] == 'X' && jogoVelha[2][2] == 'X') ||//linha3
                    (jogoVelha[0][0] == 'X' && jogoVelha[1][0] == 'X' && jogoVelha[2][0] == 'X') ||//coluna1
                    (jogoVelha[0][1] == 'X' && jogoVelha[1][1] == 'X' && jogoVelha[2][1] == 'X') ||//coluna2
                    (jogoVelha[0][2] == 'X' && jogoVelha[1][2] == 'X' && jogoVelha[2][2] == 'X') ||//coluna3
                    (jogoVelha[0][0] == 'X' && jogoVelha[1][1] == 'X' && jogoVelha[2][2] == 'X')) {//diagonal
                ganhou = true;
                System.out.println("Parabéns , player 1 venceu!");

            } else if ((jogoVelha[0][0] == 'O' && jogoVelha[0][1] == 'O' && jogoVelha[0][2] == 'O') ||//linha1
                    (jogoVelha[1][0] == 'O' && jogoVelha[1][1] == 'O' && jogoVelha[1][2] == 'O') || //linha2
                    (jogoVelha[2][0] == 'O' && jogoVelha[2][1] == 'O' && jogoVelha[2][2] == 'O') ||//linha3
                    (jogoVelha[0][0] == 'O' && jogoVelha[1][0] == 'O' && jogoVelha[2][0] == 'O') ||//coluna1
                    (jogoVelha[0][1] == 'O' && jogoVelha[1][1] == 'O' && jogoVelha[2][1] == 'O') ||//coluna2
                    (jogoVelha[0][2] == 'O' && jogoVelha[1][2] == 'O' && jogoVelha[2][2] == 'O') ||//coluna3
                    (jogoVelha[0][0] == 'O' && jogoVelha[1][1] == 'O' && jogoVelha[2][2] == 'O')) {//diagonal
                ganhou = true;
                System.out.println("Parabéns , player 2 venceu!");
            } else if (jogada > 9) {
                System.out.println("Ninguém ganhou essa partida");
            }
        }

    }
}

