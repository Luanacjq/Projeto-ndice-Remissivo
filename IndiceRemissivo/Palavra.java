package IndiceRemissivo;

public class Palavra implements Comparable<Palavra> {
    private String texto;
    private ListaEncadeadas ocorrencias;

    public Palavra(String texto) {
        this.texto = texto.toLowerCase();
        this.ocorrencias = new ListaEncadeadas();
    }

    public String getTexto() {
        return texto;
    }

    public ListaEncadeadas getOcorrencias() {
        return ocorrencias;
    }

    public void adicionarOcorrencia(int linha) {
        ocorrencias.insereFinal(linha);
    }

    @Override
    public int compareTo(Palavra outra) {
        return this.texto.compareTo(outra.texto);
    }

    @Override
    public String toString() {
        return texto + " " + ocorrencias.toString();
    }
}