package fila;

public class Node {
    private Object info;
    private Node proximo;

    //////FUNÇÕES GETS AND SETS/////

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
}
