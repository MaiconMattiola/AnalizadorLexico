
package analisadorlex;

public class semantico {
    private TabelaDeSimbolos tabela;
    
    public semantico() {
        tabela = new TabelaDeSimbolos();
    }
    
    public void insereSimbolo(String nome, int categoria) throws Exception {
    	tabela.insereSimbolo(nome, categoria);
    }
}
