public class ObraDeArte {
    private String titulo;
    private String artista;
    private int anoDeCriacao;
    private String tipo;
    private String localizacao;

    public ObraDeArte(String titulo, String artista, int anoDeCriacao, String tipo, String localizacao) {
        this.titulo = titulo;
        this.artista = artista;
        this.anoDeCriacao = anoDeCriacao;
        this.tipo = tipo;
        this.localizacao = localizacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getAnoDeCriacao() {
        return anoDeCriacao;
    }

    public void setAnoDeCriacao(int anoDeCriacao) {
        this.anoDeCriacao = anoDeCriacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    @Override
    public String toString() {
        return titulo + ", " + artista + ", " + anoDeCriacao + ", " + tipo + ", " + localizacao;
    }

    public static ObraDeArte fromString(String linha) {
        String[] dadosObra = linha.split(", ");
        return new ObraDeArte(dadosObra[0], dadosObra[1], Integer.parseInt(dadosObra[2]), dadosObra[3], dadosObra[4]);
    }
}
