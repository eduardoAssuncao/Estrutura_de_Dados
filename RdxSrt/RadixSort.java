package RdxSrt;

import java.util.Arrays;

public class RadixSort {
    // Using counting sort to sort the elements in the basis of significant places
    void countingSort(int array[], int size, int place) {
        int[] output = new int[size + 1];
        int max = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > max) //Descubra o elemento máximo (que seja max) de um determinado array.
                max = array[i];
            //System.out.println("Max: "+max);
        }
        int[] count = new int[max + 1]; //Inicialize uma matriz de comprimento max+1 com todos os elementos 0. Esta matriz é usada para armazenar a contagem dos elementos na matriz.

        for (int i = 0; i < max; ++i) { //Tornando todos os elementos do array count igual a 0
            count[i] = 0;
            //System.out.println("Count: "+count[i]);
        }

        // Calculate count of elements
        for (int i = 0; i < size; i++) { //Armazene a contagem de cada elemento em seu respectivo índice na count matriz.
            // Ou seja, a quantidade de vezes que um elemento aparece, sendo que o indice representa o elemento e o valor armazenado a quantidade de aparições
            //121, 432, 564, 23, 1, 45, 788
            //Ex. O indice 0(valor 0) aparece 0 vezes no meu array. o indice 1(valor 1) aparece
            count[(array[i] / place) % 10]++;

           //System.out.println("Count of elements: "+count[i]);
            //0 2 1 1 1 1 1
            //2 3 4 5 6 7
            //0 2 1 1 1 1 0
            //1 2 3 4 5 5
        }
        System.out.print("Count of elements:" );
        System.out.println(Arrays.toString(count));

        // Calculate cumulative count
        for (int i = 1; i < 10; i++) { // realiza a contagem acumulativa, somando o valor atual pelo anterior
            count[i] += count[i - 1];
            //System.out.println("Cumulative count: "+count[i]);
        }
        System.out.print("Cumulative count:" );
        System.out.println(Arrays.toString(count));

        // Place the elements in sorted order
        for (int i = size - 1; i >= 0; i--) {
            output[count[(array[i] / place) % 10] - 1] = array[i];
            count[(array[i] / place) % 10]--;
            //System.out.println("Output: "+output[i]);
            //System.out.println("Count: "+count[i]);
        }
        System.out.print("Count of elements:" );
        System.out.println(Arrays.toString(output));
        System.out.print("Count:" );
        System.out.println(Arrays.toString(count));

        //System.out.print("[");
        for (int i = 0; i < size; i++) {
            array[i] = output[i];
            //System.out.print(array[i]+ ",");
        }
        System.out.println(Arrays.toString(array));
        //System.out.print("]");
    }

    // Function to get the largest element from an array
    int getMax(int array[], int n) {
        int max = array[0];
        for (int i = 1; i < n; i++)
            if (array[i] > max)
                max = array[i];
        return max;
    }

    // Main function to implement radix sort
    void radixSort(int array[], int size) {
        // Get maximum element
        int max = getMax(array, size);

        // Apply counting sort to sort elements based on place value.
        for (int place = 1; max / place > 0; place *= 10) // realiza o loop três vezes. 3 é a quantidade de dígitos no maior valor
            countingSort(array, size, place);
    }

    // Driver code
    public static void main(String args[]) {
        int[] data = { 121, 432, 564, 23, 1, 45, 788 };
        //int[] data = { 4, 2, 2, 8, 3, 3, 1 };
        int size = data.length;
        System.out.println("Length: "+data.length);
        RadixSort rs = new RadixSort();
        System.out.println(Arrays.toString(data));
        rs.radixSort(data, size);
        System.out.println();
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }
}