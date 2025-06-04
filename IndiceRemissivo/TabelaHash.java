package IndiceRemissivo;

public class TabelaHash {
    private ArvoreBinariaBusca[] tabela;

    public TabelaHash() {
        this.tabela = new ArvoreBinariaBusca[26];
        for (int i = 0; i < 26; i++) {
            tabela[i] = new ArvoreBinariaBusca();
        }
    }

    private int hash(String palavra) {
        return Character.toLowerCase(palavra.charAt(0)) - 'a';
    }

    public void inserirPalavra(Palavra palavra) {
        int indice = hash(palavra.getTexto());
        tabela[indice].insere(palavra);
    }

    public Palavra buscarPalavra(String palavra) {
        int indice = hash(palavra);
        return tabela[indice].buscar(palavra);
    }

    public void imprimirIndice() {
        for (int i = 0; i < 26; i++) {
            tabela[i].imprimeEmOrdem();
        }
    }
}