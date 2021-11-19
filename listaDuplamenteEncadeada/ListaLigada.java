package listaDuplamenteEncadeada;

public class ListaLigada {

    //private Celula primeira;

    //private Celula ultima;

    //private int totalDeElementos;

    ///////////////////////////////////////

    Node inicio;
    Node fim;
    int tamanho;

    public void adiciona(Object info){ // adiciona no fim da lista
        Node no = new Node();
        no.info = info;
        no.anterior = null;
        no.proximo = inicio;
        if (inicio != null){
            inicio.anterior = no;
        }
        inicio = no;
        if (tamanho == 0){
            fim = inicio;
        }
        tamanho++;
    }

    public Object removerInicio(){
        if (inicio == null){
            return null;
        }
        Object out = inicio.info; // salva informação do inicio
        inicio = inicio.proximo;
        if (inicio != null){
            inicio.anterior = null;
        }else{
            fim = null;
        }
        tamanho--;
        return out;
    }

    public void inserirFim(Object info){
        Node no = new Node(); // Alocação do No
        no.info = info; // Colocar informação
        no.proximo = null;
        no.anterior = fim;
        if (fim != null){
            fim.proximo = no;
        }
        fim = no;
        if (tamanho == 0){
            inicio = fim;
        }
        tamanho++;
    }

    public Object removerFim(){
        if(fim == null){
            return null;
        }
        Object out = fim.info;
        fim = fim.anterior;
        if (fim != null){
            fim.proximo = null;
        }else{
            inicio = null;
        }
        tamanho--;
        return out;
    }

    public void inserirMeio(int id, Object info){
        if(id <= 0){
            adiciona(info);
        } else if (id >= tamanho){
            inserirFim(info);
        } else{
            Node local = inicio; // Local é tipo um Aux
            for (int i = 0; i < id - 1; i++){
                local = local.proximo;
            }
            Node no = new Node();
            no.info = info;
            no.anterior = local;
            no.proximo = local.proximo;
            local.proximo = no;
            no.proximo.anterior = no;
            tamanho++;
        }
    }

    public Object removerMeio(int id){
        if (id < 0 || id >= tamanho || inicio == null){
            return null;
        } else if(id == 0){
            return removerInicio();
        } else if(id == tamanho - 1){
            return removerFim();
        }
        Node local = inicio;
        for (int i = 0; i < id; i++){
            local = local.proximo;
        }
        if (local.anterior != null){
            local.anterior.proximo = local.proximo;
        }
        if (local.proximo != null){
            local.proximo.anterior = local.anterior;
        }
        tamanho--;
        return local.info;
    }

    public String toString(){
        String str= "(" + tamanho + ") ";
        Node local = inicio;
        while(local != null){
            str += local.info + " ";
            local = local.proximo;
        }
        return str;
    }

    /*public void adiciona(int posicao, Object elemento){

    }

    public Object pega(int posicao){
        return null;
    }

    public void remove(int posicao){

    }

    public int tamanho(){
        return 0;
    }

    public boolean contem(Object o){
        return false;
    }

    public void adicionaNoComeco(Object elemento){

    }

    public void removeDoComeco(){

    }

    public void removeDoFim(){

    }*/


}
