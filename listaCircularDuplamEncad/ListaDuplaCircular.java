package listaCircularDuplamEncad;

public class ListaDuplaCircular {
    private NodeDuplo inicio;

    public ListaDuplaCircular() {
        this.inicio = null;
    }

    public boolean isEmpty() {
        return (this.inicio == null);
    }

    public void inserir(int elemento) {
        NodeDuplo novo = new NodeDuplo();
        novo.setElemento(elemento);

        if (isEmpty()) {
            novo.setProximo(novo);
            novo.setAnterior(novo);
            inicio = novo;
        } else {
            NodeDuplo tmp = inicio;
            while (tmp.getProximo() != inicio) {
                tmp = tmp.getProximo();
            }
            inicio.setAnterior(novo);
            tmp.setProximo(novo);
            novo.setAnterior(tmp);
            novo.setProximo(inicio);
        }
    }

    public void exibirNaOrdem() {
        NodeDuplo tmp;
        tmp = inicio;
        do {
            System.out.println("Elemento da lista = " + tmp.getElemento());
            tmp = tmp.getProximo();
        } while (tmp != inicio);
    }

    public void exibirNaOrdemInversa() {
        NodeDuplo tmp;
        tmp = inicio;
        do{
            System.out.println("Elemento da lista = "+tmp.getElemento());
            tmp = tmp.getAnterior();
        }while(tmp != inicio);
    }
}
