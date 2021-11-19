package arvoreBinariadeBusca2;

public class Execucao {
    public static void main(String[] args) {

        Elemento elem = new Elemento(0);

        ArvoreBinariaDeBusca arvore = new ArvoreBinariaDeBusca(new Elemento(20));
        arvore.inserir(new Elemento(10));
        arvore.inserir(new Elemento(5));
        arvore.inserir(new Elemento(2));
        arvore.inserir(new Elemento(8));
        arvore.inserir(new Elemento(15));
        arvore.inserir(new Elemento(12));
        arvore.inserir(new Elemento(18));
        arvore.inserir(new Elemento(30));
        arvore.inserir(new Elemento(25));
        arvore.inserir(new Elemento(22));
        arvore.inserir(new Elemento(28));
        arvore.inserir(new Elemento(35));
        arvore.inserir(new Elemento(32));
        arvore.inserir(new Elemento(38));

        arvore.imprimirInOrdem();
        System.out.println("");

        elem.setValor(38);
        arvore = arvore.remover(elem);

        System.out.println("Nova arvore....");
        arvore.imprimirInOrdem();
        System.out.println("");

        elem.setValor(25);
        arvore = arvore.remover(elem);

        System.out.println("Nova arvore....");
        arvore.imprimirInOrdem();
        System.out.println("");

        elem.setValor(20);
        arvore = arvore.remover(elem);

        System.out.println("Nova arvore....");
        arvore.imprimirInOrdem();
        System.out.println("");

        //System.out.println("O elemento 5 "+ (arvore.busca(5)?" existe": " não existe"));
        //System.out.println("O elemento 2 "+ (arvore.busca(2)?" existe": " não existe"));
        /*System.out.println("Pre-------------");
        arvore.imprimirPreOrdem();
        System.out.println("In-------------");
        arvore.imprimirInOrdem();
        System.out.println("Pos-------------");
        arvore.imprimirPosOrdem();*/
    }
}
