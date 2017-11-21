/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisadorlex;

/**
 *
 * @author MATTIOLA
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class Sintatico {
    
    semantico semantico = new semantico();
    
    private int tabelaParsing[][] = new int[100][100];
    private int regra[][];
    private Stack<Integer> pilha;
    public static final Map<String, Integer> terminais;
    public static final Map<String, Integer> naoTerminais;

    public  Stack<Integer> getPilha() {
        return pilha;
    }
    
    static {
        naoTerminais = new HashMap<>();
        naoTerminais.put("BLOCO", 48);
        naoTerminais.put("DCLVAR", 49);
        naoTerminais.put("DCLFUNC", 50);
        naoTerminais.put("CORPO", 51);
        naoTerminais.put("REPIDENT", 52);
        naoTerminais.put("TIPO", 53);
        naoTerminais.put("LDVAR", 54);
        naoTerminais.put("LID", 55);
        naoTerminais.put("TIPO_RETORNO", 56);
        naoTerminais.put("DEFPAR", 57);
        naoTerminais.put("VALORRETORNO", 58);
        naoTerminais.put("PARAM", 59);
        naoTerminais.put("LPARAM", 60);
        naoTerminais.put("COMANDO", 61);
        naoTerminais.put("REPCOMANDO", 62);
        naoTerminais.put("EXPRESSAO", 63);
        naoTerminais.put("PARAMETROS", 64);
        naoTerminais.put("TPARAM", 65);
        naoTerminais.put("REPPAR", 66);
        naoTerminais.put("COMPARACAO", 67);
        naoTerminais.put("ELSEPARTE", 68);
        naoTerminais.put("CONTCOMPARACAO", 69);
        naoTerminais.put("INCREMENTO", 70);
        naoTerminais.put("SEQCOUT", 71);
        naoTerminais.put("SEQUENCIA", 72);
        naoTerminais.put("TERMO", 73);
        naoTerminais.put("REPEXP", 74);
        naoTerminais.put("FATOR", 75);
        naoTerminais.put("REPTERMO", 76);

    }

    static {
        terminais = new HashMap<>();
        terminais.put("while", 1);                                                          
        terminais.put("void", 2);                                                             
        terminais.put("string", 3);                                                           
        terminais.put("return", 4);                                                           
        terminais.put("numerointeiro", 5);                                                            
        terminais.put("numerofloat", 6);                                                              
        terminais.put("nomevariavel", 7);                                                             
        terminais.put("nomedochar", 8);                                                               
        terminais.put("nomedastring", 9);                                                             
        terminais.put("main", 10);                                                            
        terminais.put("literal", 11);                                            
        terminais.put("integer", 12);                                                         
        terminais.put("inicio", 13);                                                          
        terminais.put("if", 14);                                                              
        terminais.put("î", 15);                                                               
        terminais.put("for", 16);                                                             
        terminais.put("float", 17);                                                           
        terminais.put("fim", 18);                                                             
        terminais.put("else", 19);                                                            
        terminais.put("do", 20);                                                              
        terminais.put("cout", 21);                                                            
        terminais.put("cin", 22);                                                             
        terminais.put("char", 23);                                                            
        terminais.put("callfuncao", 24);                                                              
        terminais.put(">>", 25);                                                          
        terminais.put(">=", 26);                                                         
        terminais.put(">", 27);                                                               
        terminais.put("==", 28);                                                              
        terminais.put("=", 29);                                                               
        terminais.put("<=", 30);                                                              
        terminais.put("<<", 31);                                                              
        terminais.put("<", 32);                                                               
        terminais.put("++", 33);                                                              
        terminais.put("+", 34);                                                               
        terminais.put("}", 35);                                                               
        terminais.put("{", 36);                                                               
        terminais.put(";", 37);                                                               
        terminais.put(":", 38);                                                               
        terminais.put("/", 39);                                                               
        terminais.put(",", 40);                                                               
        terminais.put("*", 41);                                                               
        terminais.put(")", 42);                                                               
        terminais.put("(", 43);                                                               
        terminais.put("$", 44);                                                               
        terminais.put("!=", 45);                                                              
        terminais.put("--", 46);                                                              
        terminais.put("-", 47);    
    }

    public Sintatico() {
        pilha = new Stack<>();
        pilha.push(44); // final de arquivo / insere no final do arquivo.
        pilha.push(48); // inicial
        this.populaMatriz();
    }
    public void push(int a, String token) throws Exception {
        Boolean inLooping = true;
        int regraTemp[];
        int X;
        X = pilha.peek();
        //System.err.println("pilha "+pilha);
        while (inLooping) {
            if (X == 15) { // vazio
                pilha.pop();
                X = pilha.peek();
            } else {
                if (X <= 47) { // terminal?
                    if (X == a) {
                        pilha.pop();
                        X = pilha.peek();
                        if (X > 99 ){
                            
                            switch(X){
                                case 100 :
                                    System.err.println(token);
                                    semantico.insereSimbolo(token, 1);
                                    break; 
                                case 101 : 
                                    System.err.println(token);
                                    semantico.insereTipo(token);
                                    break;   
                                case 102 : 
                                    System.err.println(token);
                                    semantico.insereFuncao(token, 2);
                                    break;
                                case 103 : 
                                    System.err.println(token);
                                    semantico.verificaSimbolo(token, 1);
                                    break;
                                case 104 : 
                                    System.err.println(token);
                                    semantico.verificaFuncao(token, 2);
                                    break;
                                case 105 : break;
                                case 106 : break;
                                case 107 : break;
                            }
                            pilha.pop();
                        }
                        inLooping = false;
                    } else {
                        System.err.println(X + "==" + a);
                        throw new Exception("Erro sintático");
                    }
                } else {
                    if (X >= 48 && X <= 76) { // não terminal?
                        if (this.regra(X, a) > 0) { // regra existe?
                            pilha.pop();
                            regraTemp = regra[this.regra(X, a) - 1];
                            
                            for (int i = regraTemp.length; i > 0; i--) {
                                pilha.push(regraTemp[i - 1]);
                            }
                            X = pilha.peek();
                        } else {
                            System.err.println("PARSING regra("+X+","+a+")");
                            throw new Exception("Erro sintático");
                        }
                    }
                }
            }
        }
    }
              
    private int regra(int X, int a) {
        return tabelaParsing[X][a];
    }

    private void populaMatriz() {
        tabelaParsing[48][2] = 1;
        tabelaParsing[49][2] = 3;
        tabelaParsing[49][3] = 3;
        tabelaParsing[49][7] = 2;
        tabelaParsing[49][12] = 3;
        tabelaParsing[49][13] = 3;
        tabelaParsing[49][17] = 3;
        tabelaParsing[49][23] = 3;
        tabelaParsing[49][44] = 3;
        tabelaParsing[50][2] = 13;
        tabelaParsing[50][3] = 13;
        tabelaParsing[50][12] = 13;
        tabelaParsing[50][13] = 19;
        tabelaParsing[50][17] = 13;
        tabelaParsing[50][23] = 13;
        tabelaParsing[51][13] = 31;
        tabelaParsing[52][38] = 4;
        tabelaParsing[52][40] = 5;
        tabelaParsing[53][3] = 8;
        tabelaParsing[53][12] = 6;
        tabelaParsing[53][17] = 7;
        tabelaParsing[53][23] = 9;
        tabelaParsing[54][2] = 10;
        tabelaParsing[54][3] = 10;
        tabelaParsing[54][7] = 11;
        tabelaParsing[54][12] = 10;
        tabelaParsing[54][13] = 10;
        tabelaParsing[54][17] = 10;
        tabelaParsing[54][23] = 10;
        tabelaParsing[54][44] = 10;
        tabelaParsing[55][7] = 12;
        tabelaParsing[56][2] = 15;
        tabelaParsing[56][3] = 18;
        tabelaParsing[56][12] = 14;
        tabelaParsing[56][17] = 17;
        tabelaParsing[56][23] = 16;
        tabelaParsing[57][36] = 26;
        tabelaParsing[57][43] = 27;
        tabelaParsing[58][5] = 20;
        tabelaParsing[58][6] = 21;
        tabelaParsing[58][7] = 22;
        tabelaParsing[58][8] = 23;
        tabelaParsing[58][9] = 24;
        tabelaParsing[58][42] = 25;
        tabelaParsing[59][3] = 28;
        tabelaParsing[59][12] = 28;
        tabelaParsing[59][17] = 28;
        tabelaParsing[59][23] = 28;
        tabelaParsing[60][37] = 29;
        tabelaParsing[60][42] = 30;
        tabelaParsing[61][1] = 52;
        tabelaParsing[61][5] = 37;
        tabelaParsing[61][6] = 37;
        tabelaParsing[61][7] = 37;
        tabelaParsing[61][8] = 37;
        tabelaParsing[61][9] = 37;
        tabelaParsing[61][14] = 49;
        tabelaParsing[61][16] = 64;
        tabelaParsing[61][20] = 67;
        tabelaParsing[61][21] = 69;
        tabelaParsing[61][22] = 68;
        tabelaParsing[61][24] = 39; 
        tabelaParsing[61][37] = 38;
        tabelaParsing[61][43] = 37;
        tabelaParsing[62][18] = 32;
        //tabelaParsing[62][35] = 32;
        tabelaParsing[62][35] = 33;
        tabelaParsing[63][5] = 75;
        tabelaParsing[63][6] = 75;
        tabelaParsing[63][7] = 75;
        tabelaParsing[63][8] = 75;
        tabelaParsing[63][9] = 75;
        tabelaParsing[63][24] = 76;
        tabelaParsing[63][43] = 75;
        tabelaParsing[64][29] = 40;
        tabelaParsing[64][37] = 40;
        tabelaParsing[64][42] = 40;
        tabelaParsing[64][43] = 41;
        tabelaParsing[65][5] = 44;
        tabelaParsing[65][6] = 46;
        tabelaParsing[65][7] = 48;
        tabelaParsing[65][8] = 47;
        tabelaParsing[65][9] = 45;
        tabelaParsing[66][40] = 43;
        tabelaParsing[66][42] = 42;
        tabelaParsing[67][26] = 56;
        tabelaParsing[67][27] = 55;
        tabelaParsing[67][28] = 53;
        tabelaParsing[67][30] = 58;
        tabelaParsing[67][32] = 57;
        tabelaParsing[67][45] = 54;
        tabelaParsing[68][19] = 50;
        tabelaParsing[68][37] = 51;
        tabelaParsing[69][5] = 59;
        tabelaParsing[69][6] = 60;
        tabelaParsing[69][7] = 63;
        tabelaParsing[69][8] = 62;
        tabelaParsing[69][9] = 61;
        tabelaParsing[70][33] = 65;
        tabelaParsing[70][46] = 66;
        tabelaParsing[71][31] = 72;
        tabelaParsing[71][37] = 70;
        tabelaParsing[72][31] = 73;
        tabelaParsing[72][37] = 73;
        tabelaParsing[72][40] = 74;
        tabelaParsing[73][5] = 80;
        tabelaParsing[73][6] = 80;
        tabelaParsing[73][7] = 80;
        tabelaParsing[73][8] = 80;
        tabelaParsing[73][9] = 80;
        tabelaParsing[73][43] = 80;
        tabelaParsing[74][29] = 79;
        tabelaParsing[74][34] = 77;
        tabelaParsing[74][37] = 79;
        tabelaParsing[74][42] = 79;
        tabelaParsing[74][47] = 78;
        tabelaParsing[75][5] = 84;
        tabelaParsing[75][6] = 85;
        tabelaParsing[75][7] = 86;
        tabelaParsing[75][8] = 88;
        tabelaParsing[75][9] = 87;
        tabelaParsing[75][43] = 89;
        tabelaParsing[76][29] = 81;
        tabelaParsing[76][34] = 81;
        tabelaParsing[76][37] = 81;
        tabelaParsing[76][39] = 83;
        tabelaParsing[76][41] = 82;
        tabelaParsing[76][42] = 81;
        tabelaParsing[76][47] = 81;

        regra = new int[][]{
            /*1*/  {2, 10, 36, 49, 50, 51, 35},
            /*2*/  {7, 100, 52, 38, 53, 101, 37, 54},
            /*3*/  {15},
            /*4*/  {15},
            /*5*/  {40, 7, 100, 52},
            /*6*/  {12},
            /*7*/  {17},
            /*8*/  {3},
            /*9*/  {23},
            /*10*/ {15},
            /*11*/ {55, 38, 53, 101, 37, 54},
            /*12*/ {7, 100, 52},
            /*13*/ {56, 7, 102, 57, 36, 49, 50, 51, 4, 43, 58, 42, 35, 50}, 
            /*14*/ {12},
            /*15*/ {2},
            /*16*/ {23},
            /*17*/ {17},
            /*18*/ {3},
            /*19*/ {15},
            /*20*/ {5},
            /*21*/ {6},
            /*22*/ {7},
            /*23*/ {8},
            /*24*/ {9},
            /*25*/ {15},
            /*26*/ {15},
            /*27*/ {43, 59, 42},
            /*28*/ {53, 60},
            /*29*/ {37, 53, 60},
            /*30*/ {15},
            /*31*/ {13, 61, 37, 62, 18},
            /*32*/ {15},
            /*33*/ {61, 37, 62},
            /*34*/ {7, 103, 105, 29, 63, 105},
            /*35*/ {9, 29, 63},
            /*36*/ {8, 29, 63},
            /*37*/ {63, 29, 63},
            /*38*/ {15},
            /*39*/ {24, 7, 104, 64},
            /*40*/ {15},
            /*41*/ {43, 65, 66, 42},
            /*42*/ {15},
            /*43*/ {40, 65, 66},
            /*44*/ {5},
            /*45*/ {9},
            /*46*/ {6},
            /*47*/ {8},
            /*48*/ {7, 103},
            /*49*/ {14, 43, 7, 103, 107, 67, 42, 36, 61, 37, 62, 35, 68},
            /*50*/ {19, 36, 61, 37, 62, 35},
            /*51*/ {15},
            /*52*/ {1, 43, 7, 103, 107, 67, 107, 42, 36, 61, 37, 62, 35},
            /*53*/ {28, 69},
            /*54*/ {45, 69},
            /*55*/ {27, 69},
            /*56*/ {26, 69},
            /*57*/ {32, 69},
            /*58*/ {30, 69},
            /*59*/ {5},
            /*60*/ {6},
            /*61*/ {9},
            /*62*/ {8},
            /*63*/ {7, 103},
            /*64*/ {16, 43, 7, 103, 105, 29, 69, 105, 37, 7, 103, 107, 67, 107, 37, 70, 42, 36, 61, 37, 62, 35}, 
            /*65*/ {33, 5},
            /*66*/ {46, 5},
            /*67*/ {20, 36, 61, 37, 62, 35, 1, 43, 7, 103, 107, 67, 107, 42},
            /*68*/ {22, 25, 7, 103},
            /*69*/ {21, 31, 11, 71},
            /*70*/ {15},
            /*71*/ {31, 7, 103, 72, 71},
            /*72*/ {31, 11, 71},
            /*73*/ {15},
            /*74*/ {40, 7, 103, 72},
            /*75*/ {73, 7},
            /*76*/ {24, 7, 104, 64},
            /*77*/ {34, 73, 74},
            /*78*/ {47, 73, 74},
            /*79*/ {15},
            /*80*/ {75, 106, 7},
            /*81*/ {15},
            /*82*/ {41, 75, 106, 76},
            /*83*/ {39, 75, 106, 76},
            /*84*/ {5},
            /*85*/ {6},
            /*86*/ {7, 103},
            /*87*/ {9},
            /*88*/ {8},
            /*89*/ {43, 63, 42}
        };

    }
}
