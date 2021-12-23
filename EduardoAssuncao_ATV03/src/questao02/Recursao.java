package questao02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Recursao {
    public static String prefixoMaisLongo(String[] arr){
        if(arr == null || arr.length == 0){
            return "";
        }
        //arr = {"abcdevida", "abcdevida2", "abcdemorte", "abcdequalquercoisa", "abcdeAEDII"};
        String lcp = arr[0];

        for(int i = 1; i < arr.length; i++){

            String atual = arr[i];
            int j = 0;

            while(j < atual.length() && j < lcp.length() && atual.charAt(j) == lcp.charAt(j)){
                j++;
            }

            if(j == 0){
                return "";
            }

            lcp = atual.substring(0, j);
        }
        return lcp;
    }

    public static String read(String caminho){
        String conteudo = "";
        int contador = 0;
        try {
            FileReader arq = new FileReader(caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha="";
            try {
                linha = lerArq.readLine();
                while(linha!=null){
                    conteudo += linha+"\n";
                    linha = lerArq.readLine();
                }
                arq.close();
                return conteudo;
            } catch (IOException ex) {
                System.out.println("Erro: Não foi possível ler o arquivo!");
                return "";
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Erro: Arquivo não encontrado!");
            return "";
        }
    }

    public static void main(String[] args) {
        int tamanho = 5;

        String ArqCaminho = "C:\\Users\\Kenny\\Documents\\IntelliJProjects\\EduardoAssuncao_ATV03\\src\\dados.txt";
        String conteudo = read(ArqCaminho);
        String[] teste = new String[tamanho];

        int[] valoresInt = new int[tamanho];
        for(int i = 0; i < tamanho;  i++){
            teste[i] = conteudo.split(";") [i];
            System.out.println("Teste:"+ teste[i]);
        }
        String resultado = prefixoMaisLongo(teste);
        System.out.println(resultado);
    }
}
