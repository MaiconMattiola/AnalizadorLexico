
package analisadorlex;

public class semantico {
    private TabelaDeSimbolos tabela;
    
    public semantico() {
        tabela = new TabelaDeSimbolos();
    }
    
    public void insereSimbolo(String nome, int categoria) throws Exception {
    	tabela.insereSimbolo(nome, categoria);
    }
    public void insereFuncao(String nome, int categoria) throws Exception {
    	tabela.insereFuncao(nome, categoria);
    }
    public void verificaSimbolo (String nome, int categoria) throws Exception {
        tabela.verificaSimbolo(nome, categoria);
    }
     public void verificaFuncao (String nome, int categoria) throws Exception {
        tabela.verificaFuncao(nome, categoria);
    }
    public void insereTipo (String nome) throws Exception {
    	if (nome.equals("integer")){
        tabela.insereTipo(1);
        }
        if (nome.equals("float")){
        tabela.insereTipo(2);
        }
        if (nome.equals("string")){
        tabela.insereTipo(3);
        }
        if (nome.equals("char")){
        tabela.insereTipo(4);
        }
    }
    public void VerificaTipos (String nome, int tipo)throws Exception{
        if (!tabela.VerificaTipo(nome, tipo)){
         throw new Exception("Tipo de dados diferentes");
        }
    }
}
