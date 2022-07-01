import java.util.Scanner;

/*
 * Uma chapa metálica tem seus quatro lados mantidos a temperaturas constantes, podendo ser diferentes ou não. A temperatura no interior da chapa, inicialmente valendo 0°C, tem seu valor modificado de acordo com a vizinhança de cada ponto. Suponha que, a cada etapa/round, a temperatura de um ponto interno seja a média dos seus quatro vizinhos (os dois da vertical – acima e abaixo - e os dois da horizontal – à esquerda e à direita). Nesse problema, todos os pontos serão atualizados ao mesmo tempo, não utilizando as novas temperaturas dos pontos internos enquanto todos não tiverem sido calculados. Os pontos dessa chapa podem ser representados em uma grade com linhas e colunas.

A respeito do contexto acima, faça programa(s) em Java para responder às seguintes questões (obs1.: construa métodos auxiliares que julgar necessários, importantes ou úteis. Obs2.: utilize os tipos primitivos para exercitar a lógica de programação):

1) Considere que a temperatura inicial seja dada da seguinte forma: a) Primeira coluna: 100°C b) Última coluna: -3°C c) Primeira linha: 20°C d) Última linha: 20°C

Para uma chapa com 6 linhas e 5 colunas, após quantas iterações a chapa entrará em equilíbrio térmico (isto é, as temperaturas de todos os pontos serão constantes)? Considere as temperaturas com duas casas decimais. (obs.: as temperaturas das quinas ou vértices não serão relevantes, e podem assumir o valor dado inicialmente nas linhas).

2) Faça uma versão do programa anterior que, dados um número máximo de iteração e um erro máximo aceitável (), itere até um desses dois casos acontecer. Compare o resultado com o exercício 1).

3) Faça uma versão dos programas anteriores que permita ao usuário: a) Digitar as dimensões da chapa (linhas e colunas) b) Digitar os valores das temperaturas dos lados c) Digitar o número máximo de iterações d) Digitar o erro máximo aceitável e) Digitar o número de casas decimais que serão mostrados os resultados
 */


public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número de linhas da matriz: ");
        int numLinhas = scanner.nextInt();
        System.out.println("Digite o número de colunas da matriz: ");
        int numColunas = scanner.nextInt();
        double[][] chapa2 = new double[numLinhas][numColunas];
        
        double[] tempLados = new double[4];
        System.out.println("Digite as temperaturas da primeira coluna, ultima coluna, primeira linha e ultima linha apertando enter entre cada um: ");
        tempLados[0] = scanner.nextDouble();
        tempLados[1] = scanner.nextDouble();
        tempLados[2] = scanner.nextDouble();
        tempLados[3] = scanner.nextDouble();

        System.out.println("\n\n\n");
        inicializandoMatriz(chapa2, tempLados);
        printMatriz(chapa2, 2);
        System.out.println("\n\n\n");
        System.out.println("Digite o número máximo de interações: ");
        int numMaxInteracoes = scanner.nextInt();
        System.out.println("Digite o erro máximo aceitável: ");
        double erroMaximo = scanner.nextDouble();
        System.out.println("Digite o número de casas decimais que serão mostrados os resultados: ");
        int numCasasDecimais = scanner.nextInt();

        atualizaMatriz(chapa2, erroMaximo, numMaxInteracoes);
        printMatriz(chapa2, numCasasDecimais);
        System.out.println("\n\n\n");

        
        System.out.println("A um erro máximo aceitável de 1e-7, \nsendo a primeira coluna 100, \na ultima coluna -3, \na primeira linha 20 e \na ultima linha 20, \na chapa entrará em equilíbrio térmico após 70 iterações.");
    }


    
    private static double erroMaximo(double[][] matriz, double[][] matrizAux){
        double erroMax = 0;
        double erroTemp = 0;
        int numLinhas = matriz.length;
        int numColunas = matriz[0].length;
        for(int i = 0; i < numLinhas -1; i++){
            for(int j = 0; j < numColunas -1 ; j++){
                erroMax = Math.abs(matriz[i][j] - matrizAux[i][j]);
                if(erroMax > erroTemp){
                    erroTemp = erroMax;
                }
            }
        }
        return erroTemp;
    }






    private static void printMatriz(double[][] matriz, int casasDecimais) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++)
                System.out.printf("%10." + casasDecimais + "f\t", matriz[i][j]);
            System.out.println();
        }
    }

    private static void inicializandoMatriz(double[][] chapa, double[] tempLados) {
        int numLinhas = chapa.length;
        int numColunas = chapa[0].length;
        // Inicializando a colula da esquerda com 100°C e da direita com -3°C
        for (int i = 0; i < numLinhas; i++) {
            chapa[i][0] = tempLados[0];
            chapa[i][numColunas - 1] = tempLados[1];
        }
        // printMatriz(chapa);
        System.out.println("\n");
        // Inicializando a linha de cima com 20°C e de baixo com 20°C
        for (int i = 0; i < numColunas; i++) {
            chapa[0][i] = tempLados[2];
            chapa[numLinhas - 1][i] = tempLados[3];
        }
    }

    private static void atualizaMatriz(double[][] matriz, double erroMaximo, int numMaxInteracoes) {
        int numLinhas = matriz.length;
        int numColunas = matriz[0].length;
        double erroTemp = erroMaximo +1;
        int count = 0;
        double[][] matrizAux = new double[numLinhas][numColunas];

        while(count < (numMaxInteracoes + 1) && erroTemp > erroMaximo){ 
            for (int i = 1; i < numLinhas -1; i++) {
                for (int j = 1; j < numColunas -1; j++) {
                    matriz[i][j] = (matrizAux[i][j-1] + matrizAux[i][j+1] + matrizAux[i-1][j] + matrizAux[i+1][j]) / 4;
                }
            }
            erroTemp = erroMaximo(matriz, matrizAux);
            copyMatriz(matriz,matrizAux );
            count++;
            System.out.println("Etapa " + count + ": " + erroTemp);
        }
    }

    private static void copyMatriz(double[][] matriz, double[][] matrizAux) {
        int numLinhas = matriz.length;
        int numColunas = matriz[0].length;

        for (int i = 0; i < numLinhas; i++) {
            for (int j = 0; j < numColunas; j++) {
               matrizAux[i][j] = matriz[i][j];
            }
        }
    }
}
