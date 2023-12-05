package arvore;


public class No {
    int item;
    int altura;
    int ocorrencias = 1;
    No left;
    No right;

    No(int d) {
        item = d;
        altura = 1;
    }
}