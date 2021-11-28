package listaDuplamenteEncadeada;

public class Node {
    private Object info; // Variável do tipo Object (pode assumir qualquer valor)
    private Node proximo; // Nó para o próxmo valor da lista
    private Node anterior; // Nó para o valor anterior da lista

    /////FUNÇÕES GETS AND SETS/////

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public Node getProximo() {
        return proximo;
    }

    public void setProximo(Node proximo) {
        this.proximo = proximo;
    }

    public Node getAnterior() {
        return anterior;
    }

    public void setAnterior(Node anterior) {
        this.anterior = anterior;
    }
}

