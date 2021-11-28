package pilhaDinamica;

import javax.swing.text.html.parser.Parser;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class PilhaDin implements IPilha{ // Implementação da interface apenas como teste, mas é uma boa forma de melhorar a abstração
    private Node topo;

    public PilhaDin() { // Construtos que inicializa a pilha como nula
        topo = null;
    }

    public void push(Object elemento) { // Função para a inserção de um elemento no topo da pilha. Nas pilha só tem como relizar a inserção e remoção pelo topo
        Node novo = new Node();
        novo.setElemento(elemento);
        novo.setProximo(topo);

        topo = novo;
    }

    public Object pop() { // Função de remoção do elemento que está no topo da pilha
        Object elemento = topo.getElemento();
        topo = topo.getProximo();
        return elemento;
    }

    public Object consultarTopo(){ // Função para consultar qual valor está no topo
        if (topo == null){
            System.out.println("Pilha nula");
            return 0;
        }
        return topo.getElemento();
    }

    public boolean isEmpty() {
        return (topo == null);
    } // Função que verifica se a pilha está vazia

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
                        Object valores = Integer.parseInt(palavra[i]);
                        push(valores);
                    }
                }
            } while (linha != null);
        } catch (Exception e){
            System.out.println("Erro ao ler arquivo");
        }
    }
}
