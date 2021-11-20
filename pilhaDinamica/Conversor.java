package pilhaDinamica;

import pilha.Pilha;

public class Conversor {
    public static void main(String[] args) {

        PilhaDin pilha = new PilhaDin();

        pilha.push(1);
        pilha.push(2);
        pilha.push(3);

        while (!pilha.isEmpty()) {
            System.out.println("Valor: "+ pilha.pop());
        }

        /*//int numero = Integer.parseInt(args[0]);
        int numero = 172; // poderíamos usar um Scanner para informar o valor
        // PilhaDin p = new PilhaDin();
        PilhaDin p = new PilhaDin();
        // podemos executar diferentes estruturas com mesma interface (você pedir para escolher o tipo de pilha)
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
        */

        //IPilh p;
        /*try{
            // agora o usuario decide se querpilha estática ou dinamica
            p = (IPilha)Class.forName(args[1]).newInstance()}

            // fase 1 = empilhamento dos rstos
            while (numero != 0) {
                resto = numero % 2;// pega o resto da divisão deste número por 2 (vale 0 ou 1)
                p.push(resto);     // armazeno na pilha;
                numero = numero / 2;// gero um novo número, resultado da divisão dele por 2
            }

            // fase 2 = exibicao dos restos
            while (!p.isEmpty()) {
                resto = p.pop(); // remove da pilha (Sempre o cara que está no topo)
                System.out.print(resto);
            }
            System.out.println("\nFim do programa");
          }
          catch(Exception ex){
            System.err.println("Deu muito ruim...");
          }*/
    }
}
// (172)10 = (10101100)2
