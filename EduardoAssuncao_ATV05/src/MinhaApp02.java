import java.util.Scanner;

public class MinhaApp02 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int id;
        MapaHash mapa = new MapaHash();
        int tamanho = 15;
        String ArqCaminho = "C:\\Users\\Kenny\\Documents\\IntelliJProjects\\EduardoAssuncao_ATV05\\src\\dados01.txt";
        String conteudo = Arquivo.Read(ArqCaminho);
        String[] dados = new String[tamanho];
        for(int i = 0; i < tamanho;  i++){
            dados[i] = conteudo.split(";") [i];
        }

        Registro r;
        int indDados = 0;
        do {
            id = Integer.parseInt(conteudo.split(";") [indDados]);

            r = new Registro(id, dados[indDados+1], dados[indDados+2]);
            mapa.put(r);
            System.out.println("indDados " +indDados);
            indDados = indDados + 3;
            System.out.println("id: "+id);
        }while(indDados < 15);

        System.out.println("\n");

        do {
            System.out.println("===== CONSULTAR INFORMAÇÕES DO USUÁRIO =====");
            System.out.print("Digite uma chave: ");
            id = Integer.parseInt(teclado.next());
            r = mapa.get(id);
            if (id != -1) {
                if (r != null) {
                    System.out.println("===== INFORMAÇÕES DO USUÁRIO =====");
                    System.out.println("ID = " + r.getKey());
                    System.out.println("Nome = " + r.getNome());
                    System.out.println("E-mail = " + r.getEmail()+"\n\n");
                } else {
                    System.out.println("Não existe!");
                }
            }
        }while (id != -1);
    }
}
