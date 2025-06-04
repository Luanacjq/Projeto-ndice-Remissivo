package IndiceRemissivo;

import java.io.*;
import java.util.*;

public class GeradorIndiceRemissivo {

    public static void gerar(String arqTexto, String arqPalavras, String arqSaida) throws IOException {
        TabelaHash tabela = new TabelaHash();

        // Inserir as palavras-chave
        List<String> chaves = LeitorArquivos.lerPalavrasChave(arqPalavras);
        for (String chave : chaves) {
            tabela.inserirPalavra(new Palavra(chave));
        }

        // Processar o texto
        LeitorArquivos.processarTexto(arqTexto, tabela);

        // Gerar o arquivo de saída
        BufferedWriter escritor = new BufferedWriter(new FileWriter(arqSaida));
        for (String chave : chaves) {
            Palavra p = tabela.buscarPalavra(chave);
            if (p != null) {
                escritor.write(p.toString() + "\n");
            }
        }
        escritor.close();
    }
}