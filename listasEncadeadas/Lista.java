package listasEncadeadas;

public class Lista {

    private Node inicio;

    //criando a lista vazia
    public Lista(){
        this.inicio = null;
    }

    public void inserir(int elemento){
        //tenho que criar um novo node
        Node nova = new Node();
        nova.setElemento(elemento);// inserir elemento no node
        nova.setProximo(null);// depois dela não vem ninguém

        if(inicio == null){// vai se o 1a Node?
            inicio = nova;
        }
        else{// já tem informação na lista
            Node aux;
            aux = inicio;
            while (aux.getProximo() != null){
                aux = aux.getProximo();
            }
            aux.setProximo(nova);
        }
    }
    public int retirar(){
        // este método considera que a lista sempre tem elementos
        // alguém na aplicação precisa, antes de remover, testar se a lista não está vazia

        if (inicio != null) {
            Node aux = inicio;
            int elemento = aux.getElemento();
            inicio = aux.getProximo();
            return elemento;
        }
        else{
            throw new RuntimeException("Lista vazia");
        }
    }
    public void listar(){
        if (inicio == null){
            System.out.println("Nada a exibir - Lista está vazia");
        }
        else{
            Node aux = inicio;
            while (aux != null){
                System.out.println("Elemento visto "+aux.getElemento());
                aux = aux.getProximo();
            }
        }
    }
    public boolean isEmpty(){
        return this.inicio == null;
    }
}
