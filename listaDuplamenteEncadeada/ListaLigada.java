package listaDuplamenteEncadeada;

import java.io.*;
import java.util.Scanner;

public class ListaLigada {

    private Node inicio;
    private Node fim;
    private int tamanho;

    public int isEmpty(){
        if (inicio == null || fim == null){
            System.out.println("Lista vazia");
        }
        return 0;
    }

    public Object removerInicio(){ // Função realiza a remoção do primeio item da lista (caso exista)
        if (inicio == null){
            return isEmpty();
        }
        Object out = inicio.getInfo(); // salva informação do inicio
        inicio = inicio.getProximo();
        if (inicio != null){
            inicio.setAnterior(null);
        }else{
            fim = null;
        }
        tamanho--;
        return out;
    }

    public void inserirFim(Object info){ // Função para realizar a inserção no fim de um Object informado
        Node no = new Node(); // Alocação do No
        no.setInfo(info); // colocar informação
        no.setProximo(null);
        no.setAnterior(fim);
        if (fim != null){
            fim.setProximo(no);
        }
        fim = no;
        if (tamanho == 0){
            inicio = fim;
        }
        tamanho++;
    }

    public Object removerFim(){ // Função para realizar a remoção no fim
        if(fim == null){
            return null;
        }
        Object out = fim.getInfo();
        fim = fim.getAnterior();
        if (fim != null){
            fim.setProximo(null);
        }else{
            inicio = null;
        }
        tamanho--;
        return out;
    }

    public void inserirMeio(int id, Object info){ // Função para inserir um Object informado em uma posição informada
        if(id <= 0){
            inserirFim(info);
        } else if (id >= tamanho){
            inserirFim(info);
        } else{
            Node local = inicio; // Local é tipo um Aux
            for (int i = 0; i < id - 1; i++){
                local = local.getProximo();
            }
            Node no = new Node();
            no.setInfo(info);
            no.setAnterior(local);
            no.setProximo(local.getProximo());
            local.setProximo(no);
            no.getProximo().setAnterior(no);
            tamanho++;
        }
    }

    public Object removerMeio(int id){ // Função para realizar a remoção de um valor em uma posição informada
        if (id < 0 || id >= tamanho || inicio == null){
            return null;
        } else if(id == 0){
            return removerInicio();
        } else if(id == tamanho - 1){
            return removerFim();
        }
        Node local = inicio;
        for (int i = 0; i < id; i++){
            local = local.getProximo();
        }
        if (local.getAnterior() != null){
            local.getAnterior().setProximo(local.getProximo());
        }
        if (local.getProximo() != null){
            local.getProximo().setAnterior(local.getAnterior());
        }
        tamanho--;
        return local.getInfo();
    }

    public String toString(){ // Função de escopo da impressão
        String qtd= "(Qtd: " + tamanho + ") ";
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
        * Eduardo
        * Assuncao
        * de
        * Sousa
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
                        inserirFim(palavra[i]);
                    }
                }
            } while (linha != null);
        } catch (Exception e){
            System.out.println("Erro ao ler arquivo");
        }
    }
}
