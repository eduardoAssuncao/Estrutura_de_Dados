package pilhaDinamica;

public class Node {
    private Object elemento; // variável referente ao elemento a ser inserido
    private Node proximo; // Nó que identifica o proximo elemento

    //////METODOS GETS AND SETS

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public Object getElemento() {
        return this.elemento;
    }

    public void setProximo(Node proximo) {
        this.proximo = proximo;
    }

    public Node getProximo() {
        return this.proximo;
    }
}
