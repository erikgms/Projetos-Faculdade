package aps;

import java.util.Arrays;
import java.util.Random;

public class Aps {
    static final int REPETICOES = 5;

    public static void main(String[] args) {

        
        
        int[] tamanhos = {
            1_000, 10_000, 100_000, 1_000_000, 10_000_000, 100_000_000
        };

        System.out.println("================================================================");
        System.out.println("       COMPARATIVO: BUSCA SEQUENCIAL vs BUSCA BINÁRIA");
        System.out.println("================================================================");
        System.out.printf("%-15s %-20s %-20s %-12s%n",
                "Tamanho (N)", "Seq. (ms) média", "Bin. (ms) média", "Razão Seq/Bin");
        System.out.println("----------------------------------------------------------------");

        for (int n : tamanhos) {

            double totalSeq = 0;
            double totalBin = 0;

            for (int rep = 0; rep < REPETICOES; rep++) {

                // Gera array com intervalo de 1 até N
                int[] array = gerarArrayAleatorio(n, n);

                // Ordena
                Arrays.sort(array);

                // Último elemento PIOR CASO para busca sequencial 
                int alvo = array[n - 1];

                // Teste Sequencial
                long inicioSeq = System.nanoTime();
                buscaSequencial(array, alvo);
                long fimSeq = System.nanoTime();
                totalSeq += (fimSeq - inicioSeq) / 1_000_000.0;

                // Teste Binário
                long inicioBin = System.nanoTime();
                buscaBinaria(array, alvo);
                long fimBin = System.nanoTime();
                totalBin += (fimBin - inicioBin) / 1_000_000.0;
            }

            double mediaSeq = totalSeq / REPETICOES;
            double mediaBin = totalBin / REPETICOES;

            // Evita divisão por zero
            double razao = (mediaBin > 0) ? mediaSeq / mediaBin : Double.NaN;

            System.out.printf("%-15s %-20.4f %-20.6f %-12.1f%n",
                    formatarNumero(n), mediaSeq, mediaBin, razao);
        }

        System.out.println("================================================================");
        System.out.println("\nCONCLUSÃO:");
        System.out.println("  - A busca binária é ordens de magnitude mais rápida que a");
        System.out.println("    sequencial para grandes volumes de dados.");
        System.out.println("  - A razão Seq/Bin cresce aproximadamente com log2(N),");
        System.out.println("    confirmando as complexidades O(n) vs O(log n).");
        System.out.println("  - Para N=100 milhões, a busca sequencial pode ser");
        System.out.println("    milhares de vezes mais lenta que a binária.");
        System.out.println("================================================================");
    }

    // BUSCA SEQUENCIAL
    public static int buscaSequencial(int[] array, int alvo) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == alvo) return i;  // achou: retorna o índice
        }
        return -1;  // não encontrado
    }

    // BUSCA BINÁRIA
    public static int buscaBinaria(int[] array, int alvo) {
        int esquerda = 0;
        int direita  = array.length - 1;

        while (esquerda <= direita) {
            // Calcula o índice do meio evitando overflow
            int meio = esquerda + (direita - esquerda) / 2;

            if (array[meio] == alvo) return meio;
            if (array[meio] < alvo)  esquerda = meio + 1; // vai para a metade direita
            else                     direita   = meio - 1; // vai para a metade esquerda
        }
        return -1;  // não encontrado
    }
    
    // GERADOR DE ARRAY ALEATÓRIO
    // n = quantidade de elementos
    // intervalo = valor máximo gerado (proporcional ao tamanho, conforme enunciado)

    private static int[] gerarArrayAleatorio(int n, int intervalo) {
        Random rand = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(intervalo) + 1; // intervalo: 1 até N
        }
        return array;
    }

    // Formatação de grandes numeros
    private static String formatarNumero(int n) {
        if (n >= 1_000_000_000) return (n / 1_000_000_000) + " bi";
        if (n >= 1_000_000)     return (n / 1_000_000) + " mi";
        if (n >= 1_000)         return (n / 1_000) + " mil";
        return String.valueOf(n);
    }
}