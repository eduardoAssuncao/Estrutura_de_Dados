package arvoreAVL;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ArvoreAVL {
    private Elemento ele;
    private ArvoreAVL dir;
    private ArvoreAVL esq;
    private int bal; // balanceamento

    public ArvoreAVL() {
        this.ele = null;
        this.esq = null;
        this.dir = null;
        this.bal = 0;
    }

    public ArvoreAVL(Elemento elem) {
        this.ele = elem;
        this.dir = null;
        this.esq = null;
        this.bal = 0;
    }

    public int calcularAltura(){
        if (this.esq == null && this. dir == null){ // não tenho filhos
            return 1;
        }else if(this.esq != null && this.dir == null){ // filho só na esquerda
            return 1 + this.esq.calcularAltura();
        }else if(this.esq == null && this.dir != null){ // filho só na direita
            return 1 + this.dir.calcularAltura();
        }else{ // filho dos dois lados
            return 1 + Math.max(this.esq.calcularAltura(), this.dir.calcularAltura()); // pegar a maior altura de um dos lados
        }
    }

    public void calcularBalanceamento(){ // altura da direita menos altura da esquerda
        if (this.dir == null && this.esq == null){
            this.bal = 0;
        } else if (this.esq == null && this.dir != null){
            this.bal = this.dir.calcularAltura() - 0;
        } else if(this.esq != null && this.dir == null){
            this.bal = 0 - this.esq.calcularAltura();
        }else{
            this.bal = this.dir.calcularAltura() - this.esq.calcularAltura();
        }
        if (this.dir != null) this.dir.calcularBalanceamento();
        if (this.esq != null) this.esq.calcularBalanceamento();
    }

    //--------métodos de verificação e rotação
    public  ArvoreAVL verificaBalanceamento(){
        if (this.bal >= 2 || this.bal <= -2){
            if (this.bal >= 2){
                if (this.bal * this.dir.getBal() > 0){ // se o resultado da multiplicação for maior que 0, significa que os valores tem mesmo sinal
                    //System.out.println("Rotação Simples Direita");
                    return rotacaoSimplesDireita();
                }else{
                    //System.out.println("Rotação Dupla Direita"); // se for menor que 0, os valores tem sinal diferente
                    return rotacaoDuplaDireita();
                }
            }else{ // bal <= -2
                if (this.bal * this.esq.getBal() > 0){
                    //System.out.println("Rotação Simples Esquerda");
                    return rotacaoSimplesEsquerda();
                }else{
                    //System.out.println("Rotação Dupla Esquerda");
                    return rotacaoDuplaEsquerda();
                }
            }
        }
        this.calcularBalanceamento();
        if (this.esq != null) this.esq = this.esq.verificaBalanceamento();// fazer a verificação até os nós folhas
        if (this.dir != null) this.dir = this.dir.verificaBalanceamento();
        return this;
    }

    public ArvoreAVL rotacaoSimplesDireita(){
        ArvoreAVL filhoDir;
        ArvoreAVL filhoDoFilho = null;

        filhoDir = this.getDireita();
        if (this.dir != null){ // se meu filho a direita...
            if (this.dir.getEsqueda() != null){ // ...tem filho a esquerda
                filhoDoFilho = filhoDir.getEsqueda();
            }
        }
        filhoDir.setEsquerda(this);
        this.setDireita(filhoDoFilho);

        return filhoDir;
        // o filho a direita da raiz passa a ser o filhoDoFilho; o filho a esquerda do filho a direita passa a ser a raiz e o filho a direita se torna a raiz
    }

    public ArvoreAVL rotacaoSimplesEsquerda(){
        ArvoreAVL filhoEsq;
        ArvoreAVL filhoDoFilho = null;

        filhoEsq = this.getEsqueda();
        if (this.esq != null){
            if (this.esq.getDireita() != null){
                filhoDoFilho = filhoEsq.getDireita();
            }
        }
        filhoEsq.setDireita(this);
        this.setEsquerda(filhoDoFilho);

        return filhoEsq;
    }

    public ArvoreAVL rotacaoDuplaDireita(){
        ArvoreAVL arvore = this; //10
        ArvoreAVL filhoDir = this.getDireita(); //20
        ArvoreAVL filhoDoFilho = filhoDir.getEsqueda(); //15
        ArvoreAVL noInserido = filhoDoFilho.getDireita(); //17
        // parte 1: alinhar os nós

        filhoDir.setEsquerda(noInserido); // filhoDir passa a ter a esquerda o nó inserido
        filhoDoFilho.setDireita(filhoDir); // o filhoDoFilho passa a ter a direita o filhoDir
        this.setDireita(filhoDoFilho); // e a atual raiz tem como direita o filhoDoFilho

        // parte 2: tornar o filho à direita a nova raiz
        ArvoreAVL novoFilhoDireita = this.getDireita(); // armazeno o valor do filho a direita
        arvore.setDireita(null); // seto o valor a direita da raiz como nullo
        novoFilhoDireita.setEsquerda(arvore); // seto o valor a esquerda do novoFilhoDDireita como o valor da raiz
        return novoFilhoDireita; // o novoFilhoireita passa a ser a nova raiz
    }

    public ArvoreAVL rotacaoDuplaEsquerda(){
        ArvoreAVL arvore = this; //10
        ArvoreAVL filhoEsq = this.getEsqueda();
        ArvoreAVL filhoDoFilho = filhoEsq.getDireita();
        ArvoreAVL noInserido = filhoDoFilho.getEsqueda();
        // parte 1: alinhas os nós

        filhoEsq.setDireita(noInserido);
        filhoDoFilho.setEsquerda(filhoEsq);
        this.setEsquerda(filhoDoFilho);

        // parte 2: tornar o filho à direita a nova raiz
        ArvoreAVL novoFilhoEsquerda = this.getEsqueda();
        arvore.setEsquerda(null);
        novoFilhoEsquerda.setDireita(arvore);
        return novoFilhoEsquerda;
    }

    //--------INSERÇÃO NA ÁRVORE
    public ArvoreAVL inserir(Elemento novo) {
        if (isEmpty()) {
            this.ele = novo;
        } else {
            ArvoreAVL novaArvore = new ArvoreAVL(novo);
            if (novo.getValor() < this.ele.getValor()) { // vou inserir na descendencia esquerda
                if (this.esq == null) { // sou um nó folha
                    this.esq = novaArvore;
                } else {
                    this.esq = this.esq.inserir(novo); // respassei a responsabilidade para a sub-árvore esquerda
                }
            } else if (novo.getValor() > this.ele.getValor()) { // vou inserir da descendencia direita
                if (this.dir == null) {
                    this.dir = novaArvore;
                } else {
                    this.dir = this.dir.inserir(novo);
                }
            }
        }
        return this;
    }

    //-----------REMOCAO DO NÓ DA ÁRVORE
    public ArvoreAVL remover(Elemento elem) {
        // primeiro caso - achei o elemento
        if (this.ele.getValor() == elem.getValor()) {
            // caso mais simples - o elemento está em um nó folha
            if (this.dir == null && this.esq == null) {
                return null;
            } else {
                // caso 2 - eu tenho filhos à esquerda, porém nao tenho à direita
                if (this.esq != null && this.dir == null) {
                    return this.esq;
                }
                // caso 3 - eu tenho filhos à direita, porém não à esquerda
                else if (this.dir != null && this.esq == null) {
                    return this.dir;
                }
                // caso 4 - tenho filhos dos dois lados (esquerda e direita)
                else {
                    // vamos adotar a estratégia do maior dentre os menores
                    ArvoreAVL aux = this.esq;
                    while (aux.dir != null) { // enquanto houver filhos à direita
                        aux = aux.dir;
                    }
                    // troco os elementos da árvore
                    this.ele = aux.getElemento(); // o nó atual recebe o elemento do aux
                    // o maior dentre os menores
                    aux.setElemento(elem);        // insirio no nó folha o elemento a ser eliminado
                    this.esq = esq.remover(elem);
                }
            }

        } else if (elem.getValor() < this.ele.getValor()) {
            // delegar a resposabilidade à sub-arvore da esquerda
            this.esq = this.esq.remover(elem);
        } else if (elem.getValor() > this.ele.getValor()) {
            // delegar a resposabilidade à sub-arvore da direita
            this.dir = this.dir.remover(elem);
        }
        return this;
    }

    //--------MÉTODOS DE CONTROLE;
    public boolean isEmpty() {
        return (this.ele == null);
    }

    public void imprimirPreOrdem() { //é a estratégia de varredura de uma árvore binária na qual o primeiro nó é o nó raiz, seguido pela sub-árvore esquerda em pré-ordem e finalmente pela sub-árvore direita em pré-ordem
        if (!isEmpty()) {
            System.out.print(this.ele.getValor() + "  ");
            if (this.esq != null) {
                this.esq.imprimirPreOrdem();
            }
            if (this.dir != null) {
                this.dir.imprimirPreOrdem();
            }
        }
    }

    public void imprimirInOrdem() { //é a estratégia de varredura de árvore binária na qual lê-se primeiro a sub-árvore esquerda em intra-ordem, seguido pelo nó raiz e finalmente pela sub-árvore direita em intra-ordem
        if (!isEmpty()) {
            if (this.esq != null) {
                this.esq.imprimirInOrdem();
            }
            System.out.print(this.ele.getValor() + "  ");
            if (this.dir != null) {
                this.dir.imprimirInOrdem();
            }
        }
    }


    public void imprimirPosOrdem() { //é a estratégia de varredura na qual primeiro lê-se os nós da sub-árvore esquerda em pós-ordem, depois os nós da sub-árvore direita em pós-ordem e finalmente o nó raiz
        if (!isEmpty()) {
            if (this.dir != null) {
                this.dir.imprimirPosOrdem();
            }
            if (this.esq != null) {
                this.esq.imprimirPosOrdem();
            }
            System.out.print(this.ele.getValor() + "  ");
        }
    }

    public boolean busca(int valor) {
        if (isEmpty()) {
            return false;
        }
        if (this.ele.getValor() == valor) {
            System.out.println("Valor: "+valor);
            return true;
        } else {
            if (valor < this.ele.getValor()) {
                if (this.esq == null) {
                    return false;
                } else {
                    return this.esq.busca(valor);
                }
            } else if (valor > this.ele.getValor()) {
                if (this.dir == null) {
                    return false;
                } else {
                    return this.dir.busca(valor);
                }
            }
            return false;
        }
    }

    //----------GETS E SETS
    public void setElemento(Elemento ele) {
        this.ele = ele;
    }

    public void setDireita(ArvoreAVL dir) {
        this.dir = dir;
    }

    public void setEsquerda(ArvoreAVL esq) {
        this.esq = esq;
    }

    public int getBal(){
        return this.bal;
    }

    public void setBal(int bal){
        this.bal = bal;
    }

    public ArvoreAVL getDireita() {
        return this.dir;
    }

    public ArvoreAVL getEsqueda() {
        return this.esq;
    }

    public Elemento getElemento() {
        return this.ele;
    }

    //-----------MÉTODO DE DEPURACAO
    public String printArvore(int level){
        String str = this.toString()+"\n";
        for (int i = 0; i < level; i++){
            str += "\t"; // \t é utilizado para dar um tab antes da informação exibida
        }
        if (this.esq != null){
            str += "+-ESQ: "+this.esq.printArvore(level + 1);
        }else{
            str += "+-ESQ: NULL";
        }
        str += "\n";

        for (int i = 0; i < level; i++){
            str += "\t";
        }
        if (this.dir != null){
            str += "+-DIR: "+this.dir.printArvore(level + 1);
        }else{
            str += "+-DIR: NULL";
        }
        str += "\n";
        return str;
    }

    public String toString(){
        return "["+this.ele.getValor()+"]";
    }
}

