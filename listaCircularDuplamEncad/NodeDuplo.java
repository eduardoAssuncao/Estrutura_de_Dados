package listaCircularDuplamEncad;

public class NodeDuplo {
    private int elemento;
    private NodeDuplo anterior;
    private NodeDuplo proximo;
    public void setElemento(int elemento){
        this.elemento = elemento;
    }
    public void setAnterior(NodeDuplo anterior){
        this.anterior = anterior;
    }
    public void setProximo(NodeDuplo proximo){
        this.proximo = proximo;
    }
    public int getElemento(){
        return this.elemento;
    }
    public NodeDuplo getAnterior(){
        return this.anterior;
    }
    public NodeDuplo getProximo(){
        return this.proximo;
    }
}
