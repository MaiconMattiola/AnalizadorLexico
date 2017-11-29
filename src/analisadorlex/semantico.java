
package analisadorlex;

public class semantico {
    private TabelaDeSimbolos tabela;
    private int tipoCmp1 = -1;
    private int tipoCmp2 = -1;
    private int regraCmp = -1;
    
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
    public void VerificaTipos (int tipo, String nome, int regra)throws Exception{
        switch(tipo){
            case 5 : tipo = 1; break;
            case 6 : tipo = 2; break;
            case 8 : tipo = 4; break;
            case 9 : tipo = 3; break;
            default:
                tipo = tabela.getTipoVar(nome);
            break;
        }
        
        if(regraCmp != -1 && regraCmp != regra){
            tipoCmp1 = -1;
            tipoCmp2 = -1;
        }
        regraCmp = regra;
        
        if (tipoCmp1 == -1) {
            tipoCmp1 = tipo;
        } else if(tipoCmp1 != -1 && tipoCmp2 == -1) {
            tipoCmp2 = tipo;
            if (tipoCmp1 != tipoCmp2){
                tipoCmp1 = -1;
                tipoCmp2 = -1;
                
                switch(regra){
                    case 105 :
                        throw new Exception("Tipos de Dados Incompátiveis na Atribuição");
                    case 106 :
                        throw new Exception("Tipos de Dados Incompátiveis na Operação");
                    case 107 :
                        throw new Exception("Tipos de Dados Incompátiveis na Comparação");
                }
            } else {
                tipoCmp1 = tipoCmp2;
                tipoCmp2 = -1;
            }
        }
    }
}
