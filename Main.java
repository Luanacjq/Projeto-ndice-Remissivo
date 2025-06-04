import IndiceRemissivo.GeradorIndiceRemissivo;

public class Main {
    public static void main(String[] args) {
        try {
            GeradorIndiceRemissivo.gerar("texto.txt", "palavras-chave.txt", "indice.txt");
            System.out.println("Índice remissivo gerado com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao gerar índice: " + e.getMessage());
        }
    }
}