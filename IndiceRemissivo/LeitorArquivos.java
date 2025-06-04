package IndiceRemissivo;

import java.io.*;
import java.util.*;

public class LeitorArquivos {

    public static List<String> lerPalavrasChave(String caminho) throws IOException {
        List<String> palavras = new ArrayList<>();
        BufferedReader leitor = new BufferedReader(new FileReader(caminho));
        String linha;
        while ((linha = leitor.readLine()) != null) {
            palavras.add(linha.trim().toLowerCase());
        }
        leitor.close();
        return palavras;
    }

    public static void processarTexto(String caminho, TabelaHash tabela) throws IOException {
        BufferedReader leitor = new BufferedReader(new FileReader(caminho));
        String linha;
        int numeroLinha = 1;

        while ((linha = leitor.readLine()) != null) {
            String[] palavras = linha.split("\\W+");
            for (String palavra : palavras) {
                if (!palavra.isEmpty()) {
                    Palavra p = tabela.buscarPalavra(palavra);
                    if (p != null) {
                        p.adicionarOcorrencia(numeroLinha);
                    }
                }
            }
            numeroLinha++;
        }
        leitor.close();
    }
}