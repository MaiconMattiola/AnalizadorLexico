package analisadorlex;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Lexico {

    String Teste;
    List<Character> arraychar;
    List<Character> arrayinteiro;
    int controle;
    List<String> linhasPilhas = new ArrayList<>();
    List<String> linhasRegras = new ArrayList<>();

    public List<String> getRegras() {
        return linhasRegras;
    }

    public List<String> getPilhas() {
        return linhasPilhas;
    }

    public Lexico() {

        this.arraychar = new ArrayList();
        this.arrayinteiro = new ArrayList();
        arraychar.add('a');
        arraychar.add('b');
        arraychar.add('c');
        arraychar.add('d');
        arraychar.add('e');
        arraychar.add('f');
        arraychar.add('g');
        arraychar.add('h');
        arraychar.add('i');
        arraychar.add('j');
        arraychar.add('k');
        arraychar.add('l');
        arraychar.add('m');
        arraychar.add('n');
        arraychar.add('o');
        arraychar.add('p');
        arraychar.add('q');
        arraychar.add('r');
        arraychar.add('s');
        arraychar.add('t');
        arraychar.add('u');
        arraychar.add('v');
        arraychar.add('x');
        arraychar.add('y');
        arraychar.add('z');
        arraychar.add('w');
        arraychar.add('>');
        arraychar.add('=');
        arrayinteiro.add('0');
        arrayinteiro.add('1');
        arrayinteiro.add('2');
        arrayinteiro.add('3');
        arrayinteiro.add('4');
        arrayinteiro.add('5');
        arrayinteiro.add('6');
        arrayinteiro.add('7');
        arrayinteiro.add('8');
        arrayinteiro.add('9');

    }

    public void token() throws Exception {
        //int[] arrayderegras = new int[100];
        Sintatico pilha = new Sintatico();
        int i = 0;
        int linha = 1;

        String[] caractere = new String[i];
        int codigo = 0;
        String nome = null;
        String nome_erro = null;
        char[] array = Teste.toCharArray();
        boolean verifica = false;
        boolean comentario = false;
        boolean confirma = false;
        boolean erro = false;

        try {
            for (i = 0; i < array.length; i++) {
                char caracter = array[i];

                switch (caracter) {

                    case '\n':
                        linha++;
                        //break;
                        continue;

                    case '<':
                        if (i < array.length - 1) {
                            if (array[i + 1] == '=') {
                                codigo = 30;
                                nome = "<=";
                                controle++;
                                i++;
                                verifica = true;
                            } else if (array[i + 1] == '<') {
                                codigo = 31;
                                nome = "<<";
                                controle++;
                                i++;
                                verifica = true;
                            } else if (array[i] == '<') {
                                codigo = 32;
                                nome = "<";//tratar espaço
                                controle++;
                                verifica = true;
                            }
                        } else if (array[i] == '<') {
                            codigo = 32;
                            nome = "<";//tratar espaço
                            controle++;
                            verifica = true;
                        }
                        break;
                    case '=':
                        if (i < array.length - 1) {
                            if (array[i + 1] == '=') {
                                nome = "==";
                                codigo = 28;
                                controle++;
                                verifica = true;
                                i++;
                            } else if (array[i] == '=') {
                                codigo = 29;//tratar espaço
                                nome = "=";
                                controle++;
                                verifica = true;
                            }
                        } else if (array[i] == '=') {
                            codigo = 29;//tratar espaço
                            nome = "=";
                            controle++;
                            verifica = true;
                        }
                        break;

                    case '+':
                        if (i < array.length - 1) {
                            if (array[i + 1] == '+') {
                                codigo = 33;
                                nome = "++";
                                controle++;
                                verifica = true;
                                i++;
                            } else if (array[i] == '+') {
                                codigo = 34;
                                nome = "+";
                                controle++;
                                verifica = true;
                            }
                        } else if (array[i] == '+') {
                            codigo = 34;
                            nome = "+";
                            controle++;
                            verifica = true;
                        }
                        break;
                    case '}':
                        if (array[i] == '}') {
                            codigo = 35;
                            nome = "}";
                            controle++;
                            verifica = true;
                        }
                        break;
                    case '{':
                        if (array[i] == '{') {
                            codigo = 36;
                            nome = "{";
                            controle++;
                            verifica = true;
                        }
                        break;
                    case ';':
                        if (array[i] == ';') {
                            codigo = 37;
                            nome = ";";
                            controle++;
                            verifica = true;
                        }

                    case ':':
                        if (array[i] == ':') {
                            codigo = 38;
                            nome = ":";
                            controle++;
                            verifica = true;
                        }

                    case '/':
                        if (i < array.length - 1) {
                            if (array[i + 1] == '#') {
                                i++;
                                i++;
                                try {
                                    while (array[i] != '#') {
                                        i++;
                                    }
                                    System.out.println(array[i + 1]);
                                } catch (ArrayIndexOutOfBoundsException e) {
                                    nome_erro = "Comentario de Bloco Não fechado";
                                    erro = true;
                                    i--;
                                }

                                if (!erro) {
                                    if (array[i + 1] == '/') {
                                        verifica = true;
                                        comentario = true;
                                        i++;
                                    }
                                }

                            } else if (array[i] == '/') {
                                codigo = 39;
                                nome = "/";
                                controle++;
                                verifica = true;
                            }
                        } else if (array[i] == '/') {
                            codigo = 39;
                            nome = "/";
                            controle++;
                            verifica = true;
                        }

                    case ',':
                        if (array[i] == ',') {
                            codigo = 40;
                            nome = ",";
                            controle++;
                            verifica = true;
                        }

                    case ')':
                        if (array[i] == ')') {
                            codigo = 42;
                            nome = ")";
                            controle++;
                            verifica = true;
                        }

                    case '(':
                        if (array[i] == '(') {
                            codigo = 43;
                            nome = "(";
                            controle++;
                            verifica = true;
                        }

                    case '@':
                        if (array[i] == '@') {
                            codigo = 44;
                            nome = "@";
                            controle++;
                            verifica = true;
                        }

                    case '*':
                        if (array[i] == '*') {
                            codigo = 41;
                            nome = "*";
                            controle++;
                            verifica = true;
                        }

                    case '!':
                        if (i < array.length - 1) {
                            if (array[i + 1] == '=') {
                                codigo = 45;
                                nome = "!=";
                                controle++;
                                verifica = true;
                                i++;

                            }
                        }

                    case '-':
                        if (i < array.length - 1) {
                            if (array[i + 1] == '-') {
                                codigo = 46;
                                nome = "--";
                                controle++;
                                verifica = true;
                                i++;

                            } else if (array[i] == '-') {
                                codigo = 47;
                                nome = "-";
                                controle++;
                                verifica = true;
                            }
                        } else if (array[i] == '-') {
                            codigo = 47;
                            nome = "-";
                            controle++;
                            verifica = true;

                        }

                        break;

                    case '#':
                        if (array[i] == '#') {

                            while (array[i + 1] != '\n') {
                                i++;

                            }
                            if (i == array.length) {
                                comentario = true;
                                verifica = true;

                            }

                            controle++;
                            i++;
                        }
                        break;

                    case '$':
                        i++;
                        int first = i;
                        int lenght = 0;
                        while (arrayinteiro.contains(array[i]) || arraychar.contains(array[i])) {
                            if (first == i) {
                                if (arraychar.contains(array[i])) {
                                    i++;
                                } else {
                                    erro = true;
                                    nome_erro = "Variavel não pode Começar com Número";
                                    break;
                                }

                            } else {
                                i++;
                            }
                            lenght++;

                        }
                        if (i == array.length) {
                            break;
                        }
                        if (lenght <= 30) {

                            codigo = 7;
                            nome = "nomevariavel";
                            controle++;

                            verifica = true;
                        } else {
                            erro = true;
                            nome_erro = "Excedeu o Tamanho do Nome da Variavel";
                        }
                        break;

                    case '\'':
                        i++;
                        int c = 0;
                        while (array[i] != '\'') {
                            i++;
                            c++;
                            if (i == array.length) {
                                break;
                            }
                        }
                        if (c < 2) {
                            codigo = 8;
                            nome = "nomedochar";
                            controle++;

                            verifica = true;
                        } else {
                            erro = true;
                            nome_erro = "Excedeu a quantidade de caracter";

                        }
                        break;

                    case '"':
                        i++;
                        while (array[i] != '"') {
                            i++;
                            if (i == array.length) {
                                break;
                            }
                        }
                        if (i < 256) {
                            codigo = 11;
                            nome = "literal";
                            controle++;

                            verifica = true;
                        } else {
                            erro = true;
                            nome_erro = "Excedeu a quantidade de caracter";
                        }
                        break;
                    default:
                        if (arraychar.contains(caracter)) {
                            String palavra;
                            char aux;
                            palavra = String.valueOf(caracter);
                            aux = array[i];
                            while (arraychar.contains(aux)) {
                                switch (palavra) {

                                    case ">":
                                        codigo = 27;
                                        nome = ">";
                                        controle++;
                                        verifica = true;

                                        break;
                                    case ">>":
                                        codigo = 25;
                                        nome = ">>";
                                        controle++;
                                        verifica = true;
                                        break;

                                    case ">=":
                                        codigo = 26;
                                        nome = ">=";
                                        controle++;
                                        verifica = true;
                                        break;

                                    case "while":
                                        codigo = 1;
                                        nome = "while";
                                        controle++;
                                        verifica = true;

                                        break;
                                    case "void":
                                        codigo = 2;
                                        nome = "void";
                                        controle++;
                                        verifica = true;

                                        break;

                                    case "string":
                                        codigo = 3;
                                        nome = "string";
                                        controle++;
                                        verifica = true;
                                        break;

                                    case "return":
                                        codigo = 4;
                                        nome = "return";
                                        controle++;
                                        verifica = true;

                                        break;

                                    case "main":
                                        codigo = 10;
                                        nome = "main";
                                        controle++;
                                        verifica = true;
                                        break;

                                    case "integer":
                                        codigo = 12;
                                        nome = "integer";
                                        controle++;
                                        verifica = true;
                                        break;

                                    case "inicio":
                                        codigo = 13;
                                        nome = "inicio";
                                        controle++;
                                        verifica = true;
                                        break;

                                    case "if":
                                        codigo = 14;
                                        nome = "if";
                                        controle++;
                                        verifica = true;
                                        break;
                                    case "î":
                                        codigo = 15;
                                        nome = " ";
                                        controle++;
                                        verifica = true;
                                        break;

                                    case "for":
                                        codigo = 16;
                                        nome = "for";
                                        controle++;
                                        verifica = true;
                                        break;

                                    case "float":
                                        codigo = 17;
                                        nome = "float";
                                        controle++;
                                        verifica = true;
                                        break;

                                    case "fim":
                                        codigo = 18;
                                        nome = "fim";
                                        controle++;
                                        verifica = true;
                                        break;

                                    case "else":
                                        codigo = 19;
                                        nome = "else";
                                        controle++;
                                        verifica = true;
                                        break;

                                    case "do":
                                        codigo = 20;
                                        nome = "do";
                                        controle++;
                                        verifica = true;
                                        break;

                                    case "cout":
                                        codigo = 21;
                                        nome = "cout";
                                        controle++;
                                        verifica = true;
                                        break;

                                    case "cin":
                                        codigo = 22;
                                        nome = "cin";
                                        controle++;
                                        verifica = true;
                                        break;

                                    case "char":
                                        codigo = 23;
                                        nome = "char";
                                        controle++;
                                        verifica = true;
                                        break;

                                    case "callfuncao":
                                        codigo = 24;
                                        nome = "callfuncao";
                                        controle++;
                                        verifica = true;
                                        break;

                                }

                                if (i + 1 == array.length) {
                                    break;
                                }
                                aux = array[i + 1];
                                i++;
                                palavra += aux;

                            }
                        }

                        if (arrayinteiro.contains(caracter)) {
                            String pal;
                            char aux1;
                            pal = String.valueOf(caracter);

                            aux1 = array[i];
                            while (arrayinteiro.contains(aux1)) {
                                if (i + 1 == array.length) {
                                    break;
                                }

                                if (i + 1 <= array.length - 1) {
                                    if (array[i + 1] == ',') {
                                        confirma = true;
                                        pal += array[i + 1];
                                        i++;
                                    }
                                }

                                aux1 = array[i + 1];
                                pal += aux1;
                                i++;
                            }

                            if (confirma == true) {
                                float valorFloat = Float.parseFloat(pal.replace(',', '.').trim());
                                String[] split = pal.split(",");
                                int precision = split[1].length();

                                if (precision > 4) {
                                    erro = true;
                                    nome_erro = "Número Float Excede a Precisão Máxima";
                                } else if ((valorFloat >= -3.4E+38) && (valorFloat <= 3.4E+38)) {
                                    confirma = false;
                                    codigo = 6;
                                    nome = "numerofloat";

                                    verifica = true;
                                } else {
                                    erro = true;
                                    nome_erro = "Número Float Excede o Tamanho Máximo";
                                }
                            } else {
                                int valorInt = Integer.parseInt(pal.trim());

                                if ((valorInt >= -32767) && (valorInt <= 32767)) {
                                    codigo = 5;
                                    nome = "numerointeiro";

                                    verifica = true;
                                } else {
                                    erro = true;
                                    nome_erro = "Número Inteiro Excede o Tamanho Máximo";
                                }
                            }
                        }
                        break;
                }

                if (erro) {
                    linhasRegras.add("ERRO: " + nome_erro + " linha: " + linha);
                    erro = false;
                    break;
                } else if (verifica && !comentario) {
                    linhasRegras.add("Codigo: " + codigo + " linha: " + linha + " Token: " + nome);
                    linhasPilhas.add(pilha.getPilha().toString());
                    pilha.push((int) codigo);
                    verifica = false;
                }
                comentario = false;
                if (array[i] == '\n') {
                    linha++;

                }
            }

            if (!verifica) {
                linhasRegras.add("Codigo: 44" + " linha: " + (linha + 1) + " Token: Final de arquivo");
            }
        } catch (Exception ex) {
            linhasRegras.add("Linha:" + linha + ", " + ex.getMessage());
        }
    }
}
