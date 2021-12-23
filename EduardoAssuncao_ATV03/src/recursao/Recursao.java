package recursao;

public class Recursao {
    /*int maior, menor;
    public void recursao(int arr[], int tamanho){
        System.out.println(Arrays.toString(arr));
        int i = 0, j = 0, k = 1;
        if(tamanho >= 0){
            maior = arr[i];
            menor = arr[j];
            if (maior < arr[i+k]){
                maior = arr[i+k];
                tamanho--;
                k++;
                System.out.println("Maior: "+maior);
                recursao(arr, tamanho);
            }else{
                tamanho--;
                i++;
                recursao(arr, tamanho);
            }

        }else{
            System.out.println("Maior: "+maior);
            //System.out.println("Menor: "+menor);
            System.out.println("tamanho: "+tamanho);
            //System.out.println("I: "+i);
        }*/

    public int maior(int arr[], int tamanho) {
        //int maior = 0;
        if (tamanho == 1){
            //maior = arr[0];
            return arr[0];
        }
        else {
            int x;
            //System.out.println("Tamanho: "+tamanho);
            x = maior(arr, tamanho - 1);
            //System.out.println("X: "+x);
            if (x > arr[tamanho-1]){
                //System.out.println("Novo X: "+x);
                return x;
            }else{
                //System.out.println("Novo arr[tamanho-1]: "+arr[tamanho-1]);
                return arr[tamanho-1];
            }
        }
    }

    public int menor(int arr[], int tamanho) {
        //int menor = 0;
        if (tamanho == 1){
            //menor = arr[0];
            return arr[0];
        }
        else {
            int x;
            //System.out.println("Tamanho: "+tamanho);
            x = menor(arr, tamanho - 1);
            //System.out.println("X: "+x);
            if (x < arr[tamanho-1]){
                //System.out.println("Novo X: "+x);
                return x;
            }else{
                //System.out.println("Novo arr[tamanho-1]: "+arr[tamanho-1]);
                return arr[tamanho-1];
            }
        }
    }



    /*public static void main(String[] args) {
        int arr[] = {120, 150, 15, 1234, 2};
        Recursao recursao = new Recursao();
        System.out.println("Maior: "+recursao.maior(arr, 5));
        System.out.println("Menor: "+recursao.menor(arr, 5));
    }*/
}
