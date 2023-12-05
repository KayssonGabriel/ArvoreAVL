package app;

import algoOrdenacao.MergeSort;
import arquivoDados.Arquivo;
import arvore.ArvoreAVL;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws Exception {
        Path entrada = Path.of(args.length > 0 ? args[0] : "src/arquivoDados/dados100_mil.txt");
        Path saida = Path.of(args.length > 1 ? args[1] : "resultados");
        Arquivo arquivo = new Arquivo();
        int[] vetor = arquivo.lerArquivo(entrada.toString());
        Files.createDirectories(saida);

        ArvoreAVL arvore = new ArvoreAVL();
        long inicioAVL = System.nanoTime();
        for (int numero : vetor) {
            arvore.raiz = arvore.insertNo(arvore.raiz, numero);
        }
        int[] resultadoAVL = arvore.inOrderToArray(arvore.raiz);
        long tempoAVL = tempoDecorridoEmMilissegundos(inicioAVL);
        arquivo.gravarArquivo(saida.resolve("ArvoreDadosGravados100_mil.txt").toString(), resultadoAVL, "Arvore AVL", tempoAVL);

        MergeSort mergeSort = new MergeSort();
        long inicioMerge = System.nanoTime();
        mergeSort.mergeSort(vetor, 0, vetor.length - 1);
        long tempoMerge = tempoDecorridoEmMilissegundos(inicioMerge);
        arquivo.gravarArquivo(saida.resolve("MergeSortDadosGravados100_mil.txt").toString(), vetor, "Merge Sort", tempoMerge);

        long inicioMergeOrd = System.nanoTime();
        mergeSort.mergeSort(vetor, 0, vetor.length - 1);
        long tempoMergeOrd = tempoDecorridoEmMilissegundos(inicioMergeOrd);
        arquivo.gravarArquivo(saida.resolve("já ordenado MergeSortDadosGravados100_mil.txt").toString(), vetor, "Merge Sort", tempoMergeOrd);

        for (int i = 0, j = vetor.length - 1; i < j; i++, j--) {
            int temp = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = temp;
        }

        long inicioMergeIn = System.nanoTime();
        mergeSort.mergeSort(vetor, 0, vetor.length - 1);
        long tempoMergeIn = tempoDecorridoEmMilissegundos(inicioMergeIn);
        arquivo.gravarArquivo(saida.resolve("já inversamente ordenado MergeSortDadosGravados100_mil.txt").toString(), vetor, "Merge Sort", tempoMergeIn);
    }

    private static long tempoDecorridoEmMilissegundos(long inicio) {
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - inicio);
    }
}
