public class MinhaApp02 {
    public static void main(String[] args) {
        java.util.Scanner teclado = new java.util.Scanner(System.in);
        String texto;
        int chave;
        int continua;
        MapaHash mapa = new MapaHash();

        Registro r;
        do {
            System.out.println("Digite uma chave");
            texto = teclado.next();
            chave = Integer.parseInt(texto);
            System.out.println("Digite um valor");
            texto = teclado.next();

            r = new Registro(chave, texto);
            mapa.put(r);

            System.out.println("Continua? (1-sim / 0-nao)");
            continua = Integer.parseInt(teclado.next());
        }while(continua != 0);

        System.out.println("=================================");
        do {
            System.out.println("Digite uma chave");
            chave = Integer.parseInt(teclado.next());
            r = mapa.get(chave);
            if (chave != -1) {
                if (r != null) {
                    System.out.println("Registro = " + r.getValue());
                } else {
                    System.out.println("Não existe");
                }
            }
        }while (chave != -1);
    }
}
