package arvoreAVL;

import java.util.Scanner;

public class Execucao {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

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
        }
    }
}
