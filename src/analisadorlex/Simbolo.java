package analisadorlex;

public class Simbolo {

    private String nome;
    private int categoria;
    private int tipo;
    private int nivel;

    public Simbolo() {
    }

    public Simbolo(String nome, int categoria, int tipo, int nivel) {
        this.nome = nome;
        this.categoria = categoria;
        this.tipo = tipo;
        this.nivel = nivel;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

}
