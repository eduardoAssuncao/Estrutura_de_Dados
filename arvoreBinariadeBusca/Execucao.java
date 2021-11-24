package arvoreBinariadeBusca;

public class Execucao {
    public static void main(String[] args) {

        Elemento elem = new Elemento(0);

        ArvoreBinariaDeBusca arvore = new ArvoreBinariaDeBusca(new Elemento(10));
        arvore.inserir(new Elemento(5));
        arvore.inserir(new Elemento(3));
        arvore.inserir(new Elemento(6));
        arvore.inserir(new Elemento(12));
        arvore.inserir(new Elemento(11));
        arvore.inserir(new Elemento(20));

        arvore.imprimirInOrdem();
        System.out.println("");

        //elem.setValor(38);
        //arvore = arvore.remover(elem);

        /*System.out.println("Nova arvore....");
        arvore.imprimirInOrdem();
        System.out.println("");

        elem.setValor(25);
        arvore = arvore.remover(elem);

        System.out.println("Nova arvore....");
        arvore.imprimirInOrdem();
        System.out.println("");

        elem.setValor(20);
        arvore = arvore.remover(elem);*/

        elem.setValor(5);
        arvore.remover(elem);

        System.out.println("Nova arvore....");
        arvore.imprimirInOrdem();
        System.out.println("");

        //System.out.println("O elemento 5 "+ (arvore.busca(5)?" existe": " não existe"));
        //System.out.println("O elemento 2 "+ (arvore.busca(2)?" existe": " não existe"));
        System.out.print("\nPre-------------\n");
        arvore.imprimirPreOrdem();
        System.out.print("\nIn-------------\n");
        arvore.imprimirInOrdem();
        System.out.print("\nPos-------------\n");
        arvore.imprimirPosOrdem();
    }
}
