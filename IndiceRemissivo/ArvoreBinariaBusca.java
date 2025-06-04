package IndiceRemissivo;

public class ArvoreBinariaBusca {

    public class Nodo {
        public Palavra elemento;
        public Nodo esquerdo;
        public Nodo direito;

        public Nodo(Palavra elemento) {
            this.elemento = elemento;
            this.esquerdo = null;
            this.direito = null;
        }
    }

    public Nodo raiz;
    public int nElementos;

    public ArvoreBinariaBusca() {
        this.raiz = null;
        this.nElementos = 0;
    }

    public boolean estaVazia() {
        return this.raiz == null;
    }

    public int tamanho() {
        return this.nElementos;
    }

    public void insere(Palavra elemento) {
        this.raiz = insere(elemento, this.raiz);
    }

    private Nodo insere(Palavra elemento, Nodo nodo) {
        if (nodo == null) {
            nElementos++;
            return new Nodo(elemento);
        }

        int cmp = elemento.compareTo(nodo.elemento);
        if (cmp < 0) {
            nodo.esquerdo = insere(elemento, nodo.esquerdo);
        } else if (cmp > 0) {
            nodo.direito = insere(elemento, nodo.direito);
        }
        // Se for igual, não insere novamente (evita duplicata)

        return nodo;
    }

    public Palavra buscar(String palavra) {
        return buscar(palavra.toLowerCase(), this.raiz);
    }

    private Palavra buscar(String palavra, Nodo nodo) {
        if (nodo == null) return null;

        int cmp = palavra.compareTo(nodo.elemento.getTexto());

        if (cmp == 0) return nodo.elemento;
        if (cmp < 0) return buscar(palavra, nodo.esquerdo);
        return buscar(palavra, nodo.direito);
    }

    public void imprimeEmOrdem() {
        emOrdem(this.raiz);
        System.out.println();
    }

    private void emOrdem(Nodo nodo) {
        if (nodo == null) return;

        emOrdem(nodo.esquerdo);
        System.out.println(nodo.elemento); // Palavra já tem toString
        emOrdem(nodo.direito);
    }
}