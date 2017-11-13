
package analisadorlex;

import java.util.ArrayList;

public class TabelaDeSimbolos {

    private ArrayList<Simbolo> tabela;

    public TabelaDeSimbolos() {
        tabela = new ArrayList<Simbolo>();
    }

    public void insereSimbolo(String nome, int categoria) throws Exception {
        if(!isDeclarado(nome)){
            tabela.add(new Simbolo());
            tabela.get(tabela.size() - 1).setNome(nome);
            tabela.get(tabela.size() - 1).setCategoria(categoria);
        }else{
            throw new Exception("A variável ja existe!");
        }
        
    }
    
    public boolean isDeclarado(String nome) { 
        for(Simbolo s : tabela){
           if(s.getNome().equals(nome)){
               return true;
           }
        }        
        return false;
    }
   
}