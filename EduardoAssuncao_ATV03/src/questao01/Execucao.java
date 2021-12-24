package questao01;

import java.util.Arrays;

public class Execucao {
    public static void main(String[] args) {
        int tamanho = 5;
        Recursao recursao = new Recursao();

        String ArqConfig = "C:\\Users\\Kenny\\Documents\\IntelliJProjects\\EduardoAssuncao_ATV03\\src\\questao01\\dados01.txt";
        String conteudo = Arquivo.Read(ArqConfig);
        String[] valores = new String[tamanho];

        int[] valoresInt = new int[tamanho];
        for(int i = 0; i < tamanho;  i++){
            valores[i] = conteudo.split(";") [i];
            valoresInt[i] = Integer.parseInt(conteudo.split(";") [i]);
        }
        System.out.println("Array 01: "+Arrays.toString(valoresInt));
        System.out.println("Maior valor: "+recursao.maior(valoresInt, tamanho));
        System.out.println("Menor valor: "+recursao.menor(valoresInt, tamanho));

        ArqConfig = "C:\\Users\\Kenny\\Documents\\IntelliJProjects\\EduardoAssuncao_ATV03\\src\\questao01\\dados02.txt";
        conteudo = Arquivo.Read(ArqConfig);
        valores = new String[tamanho];

        valoresInt = new int[tamanho];
        for(int i = 0; i < tamanho;  i++){
            valores[i] = conteudo.split(";") [i];
            valoresInt[i] = Integer.parseInt(conteudo.split(";") [i]);
        }
        System.out.println("----------------------------");
        System.out.println("Array 02: "+Arrays.toString(valoresInt));
        System.out.println("Maior valor: "+recursao.maior(valoresInt, tamanho));
        System.out.println("Menor valor: "+recursao.menor(valoresInt, tamanho));

        ArqConfig = "C:\\Users\\Kenny\\Documents\\IntelliJProjects\\EduardoAssuncao_ATV03\\src\\questao01\\dados03.txt";
        conteudo = Arquivo.Read(ArqConfig);
        valores = new String[tamanho];

        valoresInt = new int[tamanho];
        for(int i = 0; i < tamanho;  i++){
            valores[i] = conteudo.split(";") [i];
            valoresInt[i] = Integer.parseInt(conteudo.split(";") [i]);
        }
        System.out.println("----------------------------");
        System.out.println("Array 03: "+Arrays.toString(valoresInt));
        System.out.println("Maior valor: "+recursao.maior(valoresInt, tamanho));
        System.out.println("Menor valor: "+recursao.menor(valoresInt, tamanho));
    }
}
