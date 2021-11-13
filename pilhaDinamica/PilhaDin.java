package pilhaDinamica;

public class PilhaDin implements IPilha{
    private Node topo;

    public PilhaDin() {
        topo = null;
    }

    public void push(int elemento) {
        Node novo = new Node();
        novo.setElemento(elemento);
        novo.setProximo(topo);

        topo = novo;
    }

    public int pop() {
        int elemento = topo.getElemento();
        topo = topo.getProximo();
        return elemento;
    }

    public boolean isEmpty() {
        return (topo == null);
    }
}
