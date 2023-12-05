# Árvore AVL e Merge Sort

Projeto da aula 10 de Estrutura de Dados II do bacharelado em Ciência da Computação do IF Goiano, Campus Morrinhos. O exercício compara o percurso em ordem de uma árvore AVL com o Merge Sort usando um arquivo com 100 mil números. A atividade original também pede um vídeo explicando o programa e os resultados. [Vídeo da atividade](https://youtu.be/WT2PtwcSWiE).

- [`src/app/App.java`](src/app/App.java) carrega o conjunto de dados, popula a AVL, mede os tempos e roda o Merge Sort com a entrada original, já ordenada e em ordem inversa.
- [`src/arvore/ArvoreAVL.java`](src/arvore/ArvoreAVL.java) insere chaves com rotações de balanceamento e produz o vetor em ordem.
- [`src/algoOrdenacao/MergeSort.java`](src/algoOrdenacao/MergeSort.java) implementa o Merge Sort recursivo.
- [`src/arquivoDados/`](src/arquivoDados/) contém a entrada `dados100_mil.txt`, a classe de leitura e gravação e os resultados originais em `Gravados/`.

## Como executar

Use o JDK 21 ou posterior. Na raiz do repositório, rode no PowerShell.

```powershell
javac --release 21 -encoding UTF-8 -d build (Get-ChildItem -Path src -Recurse -Filter *.java -File).FullName
java -cp build app.App
```

Por padrão, o programa lê `src/arquivoDados/dados100_mil.txt` e grava os quatro relatórios em `resultados/`. Passe um caminho de entrada e um diretório de saída como primeiro e segundo argumentos para usar outros locais.

A medição da AVL inclui a construção da árvore e o percurso em ordem. As duas estruturas preservam números repetidos, e cada execução do Merge Sort registra seu próprio tempo.
