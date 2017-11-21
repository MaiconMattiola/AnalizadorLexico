package analisadorlex;

import java.util.ArrayList;

public class TabelaDeSimbolos {

    private ArrayList<Simbolo> tabela;

    public TabelaDeSimbolos() {
        tabela = new ArrayList<Simbolo>();
    }

    public void insereSimbolo(String nome, int categoria) throws Exception {
        if (!isDeclarado(nome)) {
            tabela.add(new Simbolo());
            tabela.get(tabela.size() - 1).setNome(nome);
            tabela.get(tabela.size() - 1).setCategoria(categoria);
        } else {
            throw new Exception("A variável ja existe!");
        }

    }

    public void insereFuncao(String nome, int categoria) throws Exception {
        if (!isDeclarado(nome)) {
            tabela.add(new Simbolo());
            tabela.get(tabela.size() - 1).setNome(nome);
            tabela.get(tabela.size() - 1).setCategoria(categoria);
        } else {
            throw new Exception("A função já está declarada");
        }

    }

    public void insereTipo(int tipo) {
        tabela.get(tabela.size() - 1).setTipo(tipo);
    }

    public void verificaSimbolo(String nome, int categoria) throws Exception {
        if (!isDeclarado(nome)) {
            throw new Exception("A variavel não foi declarada!");
        }
    }
    public void verificaFuncao(String nome, int categoria) throws Exception {
        if (!isDeclarado(nome) && categoria == 2) {
            throw new Exception("A função não foi declarada!");
        }
    }

    public boolean isDeclarado(String nome) {
        for (Simbolo s : tabela) {
            if (s.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }

}
