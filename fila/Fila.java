package fila;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Fila {
    private Node cabeca; // Nó que aponta para a cabeça da fila e que nunca nunca ira mudar de posição... Podemos considera-lo como uma variável aux para a remoção de elementos
    private Node inicio;
    private int tamanho;

    public Fila() { // Contruto para estabelecer as inicializaçãoes
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

    boolean isEmpty() {
        return inicio == null;
    }

    void inserir(Object info) { // Função para inserir no final da fila
        Node no = new Node();
        no.setInfo(info);
        no.setProximo(inicio);
        inicio = no;
        if (tamanho == 0) {
            cabeca = no;
        }
        tamanho++;
    }

    Object remover() { // Função para remoção do primeiro elemento da fila, já que, em uma fila, o primeiro a sair é o primeiro a chegar
        if (isEmpty()) {
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

    public Object consultarElem(int id){ // Função para realizar a consultar de um item da fila por meio do indice
        if (isEmpty()){
            return null;
        }
        Node aux = inicio;
        for(int i = 0; i < id; i++){
            aux = aux.getProximo();
        }
        return aux.getInfo();
    }

    public String toString(){ // Função de escopo da impressão
        String qtd= "(" + tamanho + ") ";
        Node local = inicio;
        while(local != null){
            qtd += local.getInfo() + " ";
            local = local.getProximo();
        }
        return qtd;
    }

    public void lerArquivo(){ // Função de leitura dos valores a serem inseridos por meio de um arquivo.txt
        /*
         * /////EXEMPLO ARQUIVCO/////
         * 1
         * 2
         * 3
         * 4
         * 5
         * 6
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
                        inserir(palavra[i]);
                    }
                }
            } while (linha != null);
        } catch (Exception e){
            System.out.println("Erro ao ler arquivo");
        }
    }

}
