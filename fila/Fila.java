package fila;

public class Fila {
    private Node cabeca;
    private Node inicio;
    private int tamanho;

    Fila() {
        cabeca = null;
        inicio = null;
        tamanho = 0;
    }

    Object verificarCabeca() {
        if (cabeca == null) {
            return null;
        }
        return cabeca.getInfo();
    }

    boolean vazia() {
        return inicio == null;
    }

    void inserir(Object info) {
        Node no = new Node();
        //no.info = info;
        no.setInfo(info);
        //no.proximo = inicio;
        no.setProximo(inicio);
        inicio = no;
        if (tamanho == 0) {
            cabeca = no;
        }
        tamanho++;
    }

    Object remover() {
        if (vazia()) {
            return null;
        }
        Object info = cabeca.getInfo();
        if (tamanho == 1) { // ou inicio == cabeça
            inicio = null;
            cabeca = null;
        } else {
            Node local = inicio;
            while (local.getProximo() != cabeca) {
                local = local.getProximo();
            }
            cabeca = local;
            cabeca.setProximo(null);
        }
        tamanho--;
        return info;
    }

    public Object consultarElem(int id){
        if (vazia()){
            return null;
        }
        Node aux = inicio;
        for(int i = 0; i < id; i++){
            aux = aux.getProximo();
        }
        return aux.getInfo();
    }

    //colocar uma função que busque um objeto por meio de um indice
}
