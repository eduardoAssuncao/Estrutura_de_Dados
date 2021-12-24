package questao02;

public class Recursao {

    public String prefixoComumMaisLongo(String[] arr){
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

}