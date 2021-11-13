package pilha;

public class Conversor {
    public static void main(String[] args) {
        //int numero = Integer.parseInt(args[0]);
        int numero = 172; // poderíamos usar um Scanner para informar o valor
        Pilha p = new Pilha();
        int resto;

        while (numero != 0) {
            resto = numero % 2;// pega o resto da divisão deste número por 2 (vale 0 ou 1)
            p.push(resto);     // armazeno na pilha;
            numero = numero / 2;// gero um novo número, resultado da divisão dele por 2
        }

        // fase 2 = exibição dos restos
        while (!p.isEmpty()) {
            resto = p.pop(); // remove da pilha (Sempre o cara que está no topo)
            System.out.print(resto);
        }
        System.out.println("\nFim do programa");
    }
}
// (172)10 = (10101100)2
