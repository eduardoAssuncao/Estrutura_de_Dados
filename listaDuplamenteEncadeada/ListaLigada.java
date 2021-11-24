package listaDuplamenteEncadeada;

import java.io.*;
import java.util.Scanner;

public class ListaLigada {

    //private Celula primeira;

    //private Celula ultima;

    //private int totalDeElementos;

    ///////////////////////////////////////

    private Node inicio;
    private Node fim;
    private int tamanho;

    /*public void adiciona(Object info){ // adiciona no fim da lista
        Node no = new Node();
        //no.info = info;
        no.setInfo(info);
        //no.anterior = null;
        no.setAnterior(null);
        //no.proximo = inicio;
        no.setProximo(inicio);
        if (inicio != null){
            //inicio.anterior = no;
            inicio.setAnterior(no);
        }
        inicio = no;
        if (tamanho == 0){
            fim = inicio;
        }
        tamanho++;
    }*/

    public Object removerInicio(){
        if (inicio == null){
            return null;
        }
        Object out = inicio.getInfo(); // salva informação do inicio
        inicio = inicio.getProximo();
        if (inicio != null){
            //inicio.anterior = null;
            inicio.setAnterior(null);
        }else{
            fim = null;
        }
        tamanho--;
        return out;
    }

    public void inserirFim(Object info){
        Node no = new Node(); // Alocação do No
        //no.info = info; // Colocar informação
        no.setInfo(info);
        //no.proximo = null;
        no.setProximo(null);
        //no.anterior = fim;
        no.setAnterior(fim);
        if (fim != null){
            //fim.proximo = no;
            fim.setProximo(no);
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
        //Object out = fim.info;
        Object out = fim.getInfo();
        //fim = fim.anterior;
        fim = fim.getAnterior();
        if (fim != null){
            //fim.proximo = null;
            fim.setProximo(null);
        }else{
            inicio = null;
        }
        tamanho--;
        return out;
    }

    public void inserirMeio(int id, Object info){
        if(id <= 0){
            inserirFim(info);
        } else if (id >= tamanho){
            inserirFim(info);
        } else{
            Node local = inicio; // Local é tipo um Aux
            for (int i = 0; i < id - 1; i++){
                //local = local.proximo;
                local = local.getProximo();
            }
            Node no = new Node();
            //no.info = info;
            no.setInfo(info);
            //no.anterior = local;
            no.setAnterior(local);
            //no.proximo = local.proximo;
            no.setProximo(local.getProximo());
            //local.proximo = no;
            local.setProximo(no);
            //no.proximo.anterior = no;
            no.getProximo().setAnterior(no);
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
            //local = local.proximo;
            local = local.getProximo();
        }
        if (local.getAnterior() != null){
            //local.anterior.proximo = local.proximo;
            local.getAnterior().setProximo(local.getProximo());
        }
        if (local.getProximo() != null){
            //local.proximo.anterior = local.anterior;
            local.getProximo().setAnterior(local.getAnterior());
        }
        tamanho--;
        //return local.info;
        return local.getInfo();
    }

    public String toString(){
        String str= "(" + tamanho + ") ";
        Node local = inicio;
        while(local != null){
            //str += local.info + " ";
            str += local.getInfo() + " ";
            //local = local.proximo;
            local = local.getProximo();
        }
        return str;
    }

    /*public void LerArquivo(){
        File file = new File("C:\\Users\\Kenny\\Documents\\IntelliJProjects\\src\\testeLerArquivo\\TesteTexto.txt");
            public static String[] LerArquivo(File "C:\\Users\\Kenny\\Documents\\IntelliJProjects\\src\\testeLerArquivo\\TesteTexto.txt") throws FileNotFoundException {
            String s = "";

            Scanner in = new Scanner(new FileReader( "C:\\Users\\Kenny\\Documents\\IntelliJProjects\\src\\testeLerArquivo\\TesteTexto.txt" ));
            while (in.hasNextLine()) {
                String line[] = in.nextLine().split(";"); //aqui depende da formação adotada
                if(s.equals("")) {
                    s += line[0];
                }else {
                    s += ";" + line[0];
                }

            }

            return s.split(";"); //retorna um vetor ... observe que a cada linha lida vc já poderia incluir na sua estrutura
        }
    }*/
    public void lerArquivo(){
        try{
            FileInputStream arquivo = new FileInputStream("C:\\Users\\Kenny\\Documents\\IntelliJProjects\\src\\testeLerArquivo\\TesteTexto.txt"); //File - para apontar para o arquivo que deseja ler.
            InputStreamReader input = new InputStreamReader(arquivo); //FileReader - para iniciar um leitor de arquivo
            BufferedReader br = new BufferedReader(input); //BufferedReader - para poder ler linha por linha do arquivo e jogar em uma lista.

            String linha;

            do{
                linha = br.readLine();
                if(linha != null){
                    //String[] palavra = linha.split(";");
                    String[] palavra = linha.split(";");

                    System.out.println("Nova linha-------------");
                    for(int i = 0; i < palavra.length; i++){
                        inserirFim(palavra[i]);
                        System.out.println("Palavra lida = "+palavra[i]);
                    }
                }
            } while (linha != null);
        } catch (Exception e){
            System.out.println("Erro ao ler arquivo");
        }
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
