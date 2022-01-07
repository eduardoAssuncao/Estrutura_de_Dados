package arvoreAVL;

import java.util.Scanner;

public class Execucao {
    public static void main(String[] args) {
        int tamanho = 9;
        /*Scanner teclado = new Scanner(System.in);

        System.out.print("Informe um valor:");
        ArvoreAVL arvore = new ArvoreAVL(new Elemento(teclado.nextInt()));
        arvore.calcularBalanceamento();
        arvore = arvore.verificaBalanceamento(); // a cada novo elemento, iremos verificar o balanceamento
        System.out.println(arvore.printArvore(0));

        while(true){
            arvore = arvore.inserir(new Elemento(teclado.nextInt())); // voltar a referência da arvore para ela mesma
            arvore.calcularBalanceamento();
            arvore = arvore.verificaBalanceamento();
            System.out.println(arvore.printArvore(0));
        }*/
        //ArvoreAVL arvore = new ArvoreAVL();

        //arvore.lerArquivo();
        //System.out.println(arvore.printArvore(0));
        //System.out.println(arvore.printArvore(0));
       // arvore.imprimirInOrdem();
        //arvore.imprimirInOrdem();
        /*while(true){
            //arvore = arvore.inserir(new Elemento(teclado.nextInt())); // voltar a referência da arvore para ela mesma
            arvore.calcularBalanceamento();
            arvore = arvore.verificaBalanceamento();
            System.out.println(arvore.printArvore(0));
            //condição++;
        }*/
        ArvoreAVL arvore = new ArvoreAVL();
        String ArqConfig = "C:\\Users\\Kenny\\Documents\\IntelliJProjects\\ÁrvoresAVL\\src\\dados01.txt";
        String conteudo = Arquivo.Read(ArqConfig);
        String[] valores = new String[tamanho];

        int[] valoresInt = new int[tamanho];
        for(int i = 0; i < tamanho;  i++){
            valores[i] = conteudo.split(";") [i];
            valoresInt[i] = Integer.parseInt(conteudo.split(";") [i]);
            arvore.inserir(new Elemento(valoresInt[i]));
            //arvore = arvore.verificaBalanceamento();
        }

        System.out.println("|======================================================|");
        System.out.println("->Árvore Não Balanceada:");
        System.out.println(arvore.printArvore(0));
        System.out.print("->Árvore Não Balanceada: ");
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
        System.out.print("=>Árvore Balanceada: ");
        arvore.imprimirPreOrdem();
    }
}
