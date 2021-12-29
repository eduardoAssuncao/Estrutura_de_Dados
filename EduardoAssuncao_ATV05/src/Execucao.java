import java.util.Scanner;

public class Execucao {
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
            indDados = indDados + 3;
            System.out.println("ID Inserido: "+id);
        }while(indDados < 15);
        System.out.println("\n");

        ArqCaminho = "C:\\Users\\Kenny\\Documents\\IntelliJProjects\\EduardoAssuncao_ATV05\\src\\consulta.txt";
        conteudo = Arquivo.Read(ArqCaminho);
        dados = new String[1];
        for(int i = 0; i < 1;  i++){
            dados[i] = conteudo.split(";") [i];
        }

        int inf = 0;
        int chave;
        do {
            chave = Integer.parseInt(conteudo.split(";") [inf]);

            r = mapa.get(chave);
            inf++;
            System.out.println("===== CHAVE INFORMADA: "+chave);
            if (chave != -1) {
                if (r != null) {
                    System.out.println("===== INFORMAÇÕES DO USUÁRIO =====");
                    System.out.println("ID = " + r.getKey());
                    System.out.println("Nome = " + r.getNome());
                    System.out.println("E-mail = " + r.getEmail()+"\n\n");
                } else {
                    System.out.println("Não existe!");
                }
            }
        }while(inf < 1);
    }
}
