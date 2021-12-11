package EduardoAssuncao_ATV04;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class RadixSort {
    // Utilizamos o Counting Sort para ordenar os elementos levando em consideração o seu lugar significativo
    void countingSort(int arr[], int tamanho, int posicao) {
        int[] result = new int[tamanho + 1];
        int maior = arr[0];
        for (int i = 1; i < tamanho; i++) {
            //Devemos descobrir o maior elemento do array.
            if (arr[i] > maior)
                maior = arr[i];
        }
        //Inicializa uma matriz de comprimento maior+1 com todos os elementos 0.
        // Este array é usado para armazenar a contagem dos elementos.
        int[] contagem = new int[maior + 1];

        //Tornando todos os elementos do array contagem igual a 0
        for (int i = 0; i < maior; ++i) {
            contagem[i] = 0;
        }

        // Devemos realizar o calculo da contagem de elementos
        // Basicamente temos que armazenar a quantidade que um certo elemento aparece em seu respectivo indice no array contagem.
        // No array contagem, o indice representa o valor e o elemento armazenado dentro do indice é a quantidade de aparicoes.
        for (int i = 0; i < tamanho; i++) {
            //121, 432, 564, 23, 1, 45, 788
            //Ex. O indice 0(valor 0) aparece 0 vezes no meu array. o indice 1(valor 1) aparece 2 vezes
            contagem[(arr[i] / posicao) % 10]++;
        }

        // Realizamos a contagem cumulativa dos elementos, somando o valor atual pelo anterior
        for (int i = 1; i <= maior; i++) {
            contagem[i] += contagem[i - 1];// contagem do atual mais o anterior
        }

        // Posicionando os elementos de maneira ordenada
        for (int i = tamanho - 1; i >= 0; i--) {
            // é o reposicionamento dos valores do array levando em cosideração os valores da contagem - 1
            result[contagem[(arr[i] / posicao) % 10] - 1] = arr[i];
            //result[contagem[(arr[6]/posicao) % 10] - 1] = arr[6];
            //resulta[contagem[(788/1)%10] - 1] = 788;
            //result[contagem[8 - 1]] = 788;
            //result[contagem[7]] = 788;
            //result[6] = 788;
            // atualização da contagem para a próxima chamada
            contagem[(arr[i] / posicao) % 10]--;
        }

        // Coloquemos o array de saída no array original
        for (int i = 0; i < tamanho; i++) {
            arr[i] = result[i];
        }

        System.out.println(Arrays.toString(arr));
    }

    // Função para pegar o maior elemento do array
    int maiorElemento(int array[], int n) {
        int maior = array[0];
        for (int i = 1; i < n; i++)
            if (array[i] > maior)
                maior = array[i];
        return maior;
    }

    // Função de implementação do Radix Sort
    void radixSort(int arr[], int tamanho) {
        // Encontar o maior elemento presente dentro do array
        int maior = maiorElemento(arr, tamanho);

        // Utilização do Counting Sort para ordenar os elementos tomando como base sua posição
        // o laço realiza o loop levando em consideração a quantidade de dígitos presente no maior valor.
        for (int posicao = 1; maior / posicao > 0; posicao *= 10)
            countingSort(arr, tamanho, posicao);
    }
}