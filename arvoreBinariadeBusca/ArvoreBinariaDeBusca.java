package arvoreBinariadeBusca;

import javax.swing.text.html.parser.Element;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

//////DEVEMOS OBSERVAR QUE AS FUNÇÕES DA ÁRVORE BINÁRIA USAM MUITO DA RECURSIVIDADE, ENTÃO DEVEMOS ANALISAR COM CAUTELA CADA FUNÇÃO OBSERVANDO O QUE É FEITA A CADA CHAMADA//////

public class ArvoreBinariaDeBusca {
    private Elemento ele; // Cada elemento iserido é um No . Elemento == Node
    private ArvoreBinariaDeBusca dir;
    private ArvoreBinariaDeBusca esq;

    public ArvoreBinariaDeBusca() { // Construtor para inicialização
        this.ele = null;
        this.esq = null;
        this.dir = null;
    }

    public ArvoreBinariaDeBusca(Elemento elem) { // sobrecarga de contrutor para a inicialização com a informação de um valor Elemento elem (que é nada mais nada menos que um valor qualquer inteiro)
        this.ele = elem;
        this.dir = null;
        this.esq = null;
    }

    //inserção na árvore
    public void inserir(Elemento novo) {
        if (isEmpty()) {
            this.ele = novo;
        } else {
            ArvoreBinariaDeBusca novaArvore = new ArvoreBinariaDeBusca(novo);
            if (novo.getValor() < this.ele.getValor()) { // vou inserir na descendencia esquerda
                if (this.esq == null) { // sou um nó folha
                    this.esq = novaArvore;
                } else {
                    this.esq.inserir(novo); // respassei a responsabilidade para a sub-árvore esquerda
                }
            } else if (novo.getValor() > this.ele.getValor()) { // vou inserir da descendencia direita
                if (this.dir == null) { // a direita de "mim" é nulo?
                    this.dir = novaArvore; // sim? então a minha direita vai ser inserido o novo valor
                } else {
                    this.dir.inserir(novo);// vou para a direita e repito a função até o valor poder ser inserido
                }
            }
        }

    }

    // remocao do nó da arvore
    public ArvoreBinariaDeBusca remover(Elemento elem) {
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
                    ArvoreBinariaDeBusca aux = this.esq;
                    while (aux.dir != null) { // enquanto houver filhos à direita
                        aux = aux.dir;
                    }
                    // troco os elementos da árvore
                    this.ele = aux.getElemento(); // o nó atual (nó que encontrei fazendo a busca) recebe o elemento do aux
                    // o maior dentre os menores
                    aux.setElemento(elem);        // insirio no nó folha o elemento a ser eliminado (inversão de posição entre o nó aux e o nó que quero eliminar, tonarnandno-o um nó folha)
                    this.esq = esq.remover(elem); // reinicio a função e aplico o primeiro caso onde meu nó é um nó folha
                }
            }

        } else if (elem.getValor() < this.ele.getValor()) { // se o elemento a ser removido é menor que o nó atual, percorro a árvore a esquerda
            // delegar a resposabilidade à sub-arvore da esquerda
            this.esq = this.esq.remover(elem);
        } else if (elem.getValor() > this.ele.getValor()) { // se o elemento a ser removido é maior que o nó atual, percorro a árvore a direita
            // delegar a resposabilidade à sub-arvore da direita
            this.dir = this.dir.remover(elem);
        }
        return this;
    }

    public void lerArquivo(){ // Função de leitura dos valores a serem inseridos por meio de um arquivo.txt
        /*
         * /////EXEMPLO ARQUIVO/////
         *10
         *5
         *3
         *6
         *15
         *12
         *20
         */
        try{
            FileInputStream arquivo = new FileInputStream("C:\\Users\\Kenny\\Documents\\IntelliJProjects\\src\\testeLerArquivo\\TesteTexto.txt"); //File - para apontar para o arquivo que deseja ler.
            InputStreamReader input = new InputStreamReader(arquivo); //FileReader - para iniciar um leitor de arquivo
            BufferedReader br = new BufferedReader(input); //BufferedReader - para poder ler linha por linha do arquivo e jogar em uma lista.

            String linha;

            do{
                linha = br.readLine();
                if(linha != null){
                    String[] palavra = linha.split(";");

                    for(int i = 0; i < palavra.length; i++){
                        int valores = Integer.parseInt(palavra[i]);
                        inserir(new Elemento(valores));
                    }
                }
            } while (linha != null);
        } catch (Exception e){
            System.out.println("Erro ao ler arquivo");
        }
    }

    // metodos de controle;
    public boolean isEmpty() {
        return (this.ele == null);
    }

    //EX:  (D <- B -> E) <- A -> (F <- C -> G)
    public void imprimirPreOrdem() { //é a estratégia de varredura de uma árvore binária na qual o primeiro nó é o nó raiz, seguido pela sub-árvore esquerda em pré-ordem e finalmente pela sub-árvore direita em pré-ordem
        if (!isEmpty()) {
            System.out.print(this.ele.getValor() + "  ");
            if (this.esq != null) {
                this.esq.imprimirPreOrdem();
            }
            if (this.dir != null) {
                this.dir.imprimirPreOrdem();
            }
        } // percorro a esquerda e a direita já realizando a impressão
    } //R_EX: A, B, D, E, C, F, G

    //EX:  (D <- B -> E) <- A -> (F <- C -> G)
    public void imprimirInOrdem() { //é a estratégia de varredura de árvore binária na qual lê-se primeiro a sub-árvore esquerda em intra-ordem, seguido pelo nó raiz e finalmente pela sub-árvore direita em intra-ordem
        if (!isEmpty()) {
            if (this.esq != null) {
                this.esq.imprimirInOrdem();
            }
            System.out.print(this.ele.getValor() + "  ");
            if (this.dir != null) {
                this.dir.imprimirInOrdem();
            }
        } // percorro a árvore a esquerda e volto imprimindo até o nó raiz, depois percorro a árvore a esquerda e volto imprimindo os restantes
    } //R_EX: D, B, E, A, F, C, G

    //EX:  (D <- B -> E) <- A -> (F <- C -> G)
    public void imprimirPosOrdem() { //é a estratégia de varredura na qual primeiro lê-se os nós da sub-árvore esquerda em pós-ordem, depois os nós da sub-árvore direita em pós-ordem e finalmente o nó raiz
        if (!isEmpty()) {
            if (this.esq != null) {
                this.esq.imprimirPosOrdem();
            }
            if (this.dir != null) {
                this.dir.imprimirPosOrdem();
            }
            System.out.print(this.ele.getValor() + "  ");
        } // percorro a árvore a esqurda, imprimo os nós, depois percorro a direita, imprimo os nós e, por fim, imprimo a raiz
    } //R_EX: D, E, B, F, G, C, A

    public boolean busca(int valor) {
        if (isEmpty()) {
            return false;
        }
        if (this.ele.getValor() == valor) {
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

    // gets e sets
    public void setElemento(Elemento ele) {
        this.ele = ele;
    }
    public Elemento getElemento() {
        return this.ele;
    }
}
