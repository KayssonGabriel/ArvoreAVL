//Fazer um programa utilizando uma árvore AVL. Inserir os  dos dados apresentados nos arquivos da aula 02 e fazer a impressão
// em ordem dos dados.  O programa deve marcar o tempo para a impressão de todos os dados.  (somente para o arquivo de 100.000 números).
// Faça a comparação com o mesmo arquivo utilizando um algoritmo de ordenação de sua escolha.
//
//Fazer um vídeo de 5 a 15 min.  Apresentando o programa, explicando o código e mostrando os resultados para cada arquivo.


package app;

import algoOrdenacao.MergeSort;
import arquivoDados.Arquivo;
import arvore.ArvoreAVL;

import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        ArvoreAVL arvore = new ArvoreAVL();
        MergeSort mergeSort = new MergeSort();
        Arquivo arquivo = new Arquivo();

        int[] vetor = arquivo.lerArquivo("C:\\Users\\kayss\\Documents\\ED2\\ArvoreAVL\\src\\arquivoDados\\dados100_mil.txt");


        // Arvore AVL
        for (int i = 0; i < vetor.length; i++) {
            arvore.raiz = arvore.insertNo(arvore.raiz, vetor[i]);
        }
        long inicioAVL = System.currentTimeMillis();
        int[] vetorResultadosAVL = arvore.inOrderToArray(arvore.raiz);
        long fimAVL = System.currentTimeMillis();
        long tempoAVL = fimAVL - inicioAVL;


        // Merge Sort
        long inicioMerge = System.currentTimeMillis();
        mergeSort.mergeSort(vetor, 0, vetor.length - 1);
        long fimMerge = System.currentTimeMillis();
        long tempoMerge = fimMerge - inicioMerge;

        // Gravar a árvore no arquivo
        arquivo.gravarArquivo("C:\\Users\\kayss\\Documents\\ED2\\ArvoreAVL\\src\\arquivoDados\\Gravados\\ArvoreDadosGravados100_mil.txt", vetorResultadosAVL, "Arvore AVL", tempoAVL);

        // Gravar Merge Sort no arquivo
        arquivo.gravarArquivo("C:\\Users\\kayss\\Documents\\ED2\\ArvoreAVL\\src\\arquivoDados\\Gravados\\MergeSortDadosGravados100_mil.txt", vetor, "Merge Sort", tempoMerge);


        long inicioMergeOrd = System.currentTimeMillis();
        mergeSort.mergeSort(vetor, 0, vetor.length - 1);
        long fimMergeOrd = System.currentTimeMillis();
        long tempoMergeOrd = fimMergeOrd - inicioMergeOrd;

        arquivo.gravarArquivo("C:\\Users\\kayss\\Documents\\ED2\\ArvoreAVL\\src\\arquivoDados\\Gravados\\já ordenado MergeSortDadosGravados100_mil.txt", vetor, "Merge Sort", tempoMerge);


        //Inverter vetor
        Stack<Integer> pilha = new Stack<>();
        for (int numero : vetor)
            pilha.push(numero);

        for (int i = 0; i < vetor.length; i++)
            vetor[i] = pilha.pop();

        long inicioMergeIn = System.currentTimeMillis();
        mergeSort.mergeSort(vetor, 0, vetor.length - 1);
        long fimMergeIn = System.currentTimeMillis();
        long tempoMergeIn = fimMergeIn - inicioMergeIn;


        // invers
        arquivo.gravarArquivo("C:\\Users\\kayss\\Documents\\ED2\\ArvoreAVL\\src\\arquivoDados\\Gravados\\já inversamente ordenaodo MergeSortDadosGravados100_mil.txt", vetor, "Merge Sort", tempoMerge);

    }
}
