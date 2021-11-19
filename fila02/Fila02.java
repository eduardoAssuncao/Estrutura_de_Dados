package fila02;

public class Fila02 {
    Node cabeca;
    Node inicio;
    int tamanho;

    Fila02(){
        cabeca = null;
        inicio = null;
        tamanho = 0;
    }

    Object verificarCabeca(){
        if (cabeca == null){
            return null;
        }
        return cabeca.info;
    }

    boolean vazia(){
        return inicio == null;
    }

    void inserir(Object info){
        Node no = new Node();
        no.info = info;
        no.proximo = inicio;
        inicio = no;
        if (tamanho == 0){
            cabeca = no;
        }
        tamanho++;
    }

    Object remover(){
        if (vazia()){
            return null;
        }
        Object info = cabeca.info;
        if (tamanho == 1){ // ou inicio == cabeça
            inicio = null;
            cabeca = null;
        } else {
            Node local = inicio;
            while (local.proximo != cabeca) {
                local = local.proximo;
            }
            cabeca = local;
            cabeca.proximo = null;
        }
        tamanho --;
        return info;
    }
}
