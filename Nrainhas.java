import java.util.Scanner;

public class Nrainhas {

    public static boolean verifica(int tabuleiro[][], int linhas, int colunas ){ //Verificando
  
        for (int i = 0; i < tabuleiro.length; i++ ){ //Verifica Colunas
            if (tabuleiro [i][colunas] == 1){
                return false;
            } 
        }


        for (int i = linhas - 1, j = colunas - 1; i >= 0 && j >= 0; i--, j--){ //Verifica Diagonal para Esquerda
            if (tabuleiro[i][j] == 1) {
                return false;
                
            }
        }

        for (int i = linhas - 1, j = colunas + 1; i >= 0 && j < tabuleiro.length; i--, j++){ //Verifica Diagonal para Direita
            if (tabuleiro[i][j] == 1) {
                return false;
                
            }
        }


        return true;

    }

    public static void PrintTab(int tab[][]){//Printando Tabuleiro

        

        int n = tab.length;

     System.out.println("\nTabuleiro:");

        for (int i = 0; i < n; i++) {
         System.out.print("| ");
            for (int j = 0; j < n; j++) {
             if (tab[i][j] == 1) {
                System.out.print("Q "); // Q de Rainha
              } else {
                System.out.print(". "); // . para espaços vazios
              }
         }
        System.out.println("|");
    }
}

    public static boolean resolv(int tabu[][], int linha){//Resolvendo o Tabuleiro

        int n = tabu.length;

        if (linha >= n) {
            return true;
            
        }

        for(int i = 0; i < n; i++){

            if (tabu[linha][i] == 0) {

                if (verifica(tabu, linha, i) == true) {
                    tabu[linha][i] = 1;
                    if (resolv(tabu, linha + 1)) {
                       return true;
                    }
                    
                    tabu[linha][i] = 0;
                }

                
            }
        }

        return false;

            
    }
    public static void main(String[] args) { //Resolvendo Tabuleiro

        Scanner input = new Scanner(System.in); 

        System.out.println("Digite o valor de N (Tabuleiro N/N): "); //Definindo Tabuleiro
        int N = input.nextInt();
        int[][] tabuleiro = new int [N][N]; 

        if (resolv(tabuleiro, 0) == true) {
            System.out.println("Problema de N rainhas resolvido");
            PrintTab(tabuleiro);
            
        }else System.out.println("Erro!");
        

        input.close();
    }
    
}
