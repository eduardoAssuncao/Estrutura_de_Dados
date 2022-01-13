package arvoreAVL;

import java.util.Scanner;

public class Execucao {
    public static void main(String[] args) {
        int tamanho = 9;

        ArvoreAVL arvore = new ArvoreAVL();
        String ArqConfig = "C:\\Users\\Kenny\\Documents\\IntelliJProjects\\ÁrvoresAVL\\src\\dados01.txt";
        String conteudo = Arquivo.Read(ArqConfig);
        String[] valores = new String[tamanho];

        int[] valoresInt = new int[tamanho];
        for(int i = 0; i < tamanho;  i++){
            valores[i] = conteudo.split(";") [i];
            valoresInt[i] = Integer.parseInt(conteudo.split(";") [i]);
            arvore.inserir(new Elemento(valoresInt[i]));
        }

        System.out.println("|======================================================|");
        System.out.println("->Árvore Não Balanceada:");
        System.out.println(arvore.printArvore(0));
        System.out.print("->Árvore Não Balanceada (PreOrdem): ");
        arvore.imprimirPreOrdem();
        System.out.print("\n");
        System.out.println("|======================================================|");
        valoresInt = new int[tamanho];
        for(int i = 0; i < tamanho;  i++){
            valores[i] = conteudo.split(";") [i];
            valoresInt[i] = Integer.parseInt(conteudo.split(";") [i]);
            arvore.inserir(new Elemento(valoresInt[i]));
            arvore = arvore.verificaBalanceamento();
        }

        System.out.println("=>Árvore Balanceada:");
        System.out.println(arvore.printArvore(0));
        System.out.print("=>Árvore Balanceada (PreOrdem): ");
        arvore.imprimirPreOrdem();
        System.out.print("\n");
        System.out.println("|======================================================|");
        System.out.println("Buscando valor:");
        System.out.println("Valor encontrado? "+ arvore.busca(17));

        System.out.println("|======================================================|");
        System.out.println("Removendo o valor 2:");
        arvore.remover(new Elemento(2));
        System.out.print("=>Árvore Não Balanceada (PreOrdem): ");
        arvore.imprimirPreOrdem();
        System.out.print("\n");
        for(int i = 0; i < tamanho;  i++){
            arvore = arvore.verificaBalanceamento();
        }
        System.out.print("=>Árvore Balanceada (PreOrdem): ");
        arvore.imprimirPreOrdem();



    }
}
