package pilhaDinamica2;

public class PilhaDinamica2 {
    Node topo;
    int tamanho;

    PilhaDinamica2(){
        tamanho = 0;
        topo = null;
    }

    boolean vazia(){
        return topo == null;
    }

    void inserir(Object info){
        Node no = new Node();
        no.info = info;
        no.proximo = topo;
        topo = no;
        tamanho++;
    }

    Object remover(){
        if (vazia()){
            return null;
        }
        Object info = topo.info;
        topo = topo.proximo;
        return info;
    }
}
