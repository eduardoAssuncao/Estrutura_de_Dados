package arvoreBinaria;

import java.util.Random;

public class Execucao {
    public static void main(String[] args) {
        Random rand = new Random();
        ArvoreBinaria tree = new ArvoreBinaria();

        for(int i = 0; i < 10; i++){
            tree.inserir(rand.nextInt(100), tree.root);
        }

        System.out.println("\nPRE-ORDER:");
        tree.preOrder(tree.root);

        System.out.println("\nIN-ORDER:");
        tree.inOrder(tree.root);

        System.out.println("\nPOS-ORDER:");
        tree.posOrder(tree.root);
    }
}
