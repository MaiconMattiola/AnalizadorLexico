package analisadorlex;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Lexico {

    String Teste;
    List<Integer> arrayderegras;
    List<Character> arraychar;
    List<Character> arrayinteiro;
    int controle;
    ArrayList<String> simbolos = new ArrayList<>();
    List<String> linhasRegras = new ArrayList<>();

    //Adicionado por Ramon para exibir a regra com a linha
    public List<String> getRegras() {
        return linhasRegras;
    }

    public Lexico() {
        this.arrayderegras = new ArrayList();
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

    public void token() {
        //int[] arrayderegras = new int[100];

        int i = 0;
        int linha = 1;

        String[] caractere = new String[i];
        int regra = 0;
        String nome = null;
        String nome_erro = null;
        char[] array = Teste.toCharArray();
        boolean verifica = false;
        boolean confirma = false;
        boolean erro = false;

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
                            regra = 30;
                            nome = "<=";
                            controle++;
                            arrayderegras.add(regra);
                            System.out.println(regra);
                            i++;
                            verifica = true;
                        } else if (array[i + 1] == '<') {
                            regra = 31;
                            nome = "<<";
                            controle++;
                            arrayderegras.add(regra);
                            System.out.println(regra);
                            i++;
                            verifica = true;
                        } else if (array[i] == '<') {
                            regra = 32;
                            nome = "<";//tratar espaço
                            controle++;
                            arrayderegras.add(regra);
                            System.out.println(regra);
                            verifica = true;
                        }
                    } else if (array[i] == '<') {
                        regra = 32;
                        nome = "<";//tratar espaço
                        controle++;
                        arrayderegras.add(regra);
                        System.out.println(regra);
                        verifica = true;
                    }
                    break;
                case '=':
                    if (i < array.length - 1) {
                        if (array[i + 1] == '=') {
                            nome = "==";
                            regra = 28;
                            controle++;
                            System.out.println(regra);
                            arrayderegras.add(regra);
                            verifica = true;
                            i++;
                        } else if (array[i] == '=') {
                            regra = 29;//tratar espaço
                            nome = "=";
                            controle++;
                            System.out.println(regra);
                            arrayderegras.add(regra);
                            verifica = true;
                        }
                    } else if (array[i] == '=') {
                        regra = 29;//tratar espaço
                        nome = "=";
                        controle++;
                        System.out.println(regra);
                        arrayderegras.add(regra);
                        verifica = true;
                    }
                    break;

                case '+':
                    if (i < array.length - 1) {
                        if (array[i + 1] == '+') {
                            regra = 33;
                            nome = "++";
                            controle++;
                            System.out.println(regra);
                            arrayderegras.add(regra);
                            verifica = true;
                            i++;
                        } else if (array[i] == '+') {
                            regra = 34;
                            nome = "+";
                            controle++;
                            System.out.println(regra);
                            arrayderegras.add(regra);
                            verifica = true;
                        }
                    } else if (array[i] == '+') {
                        regra = 34;
                        nome = "+";
                        controle++;
                        System.out.println(regra);
                        arrayderegras.add(regra);
                        verifica = true;
                    }
                    break;
                case '}':
                    if (array[i] == '}') {
                        regra = 35;
                        nome = "}";
                        controle++;
                        System.out.println(regra);
                        arrayderegras.add(regra);
                        verifica = true;
                    }
                    break;
                case '{':
                    if (array[i] == '{') {
                        regra = 36;
                        nome = "{";
                        controle++;
                        System.out.println(regra);
                        arrayderegras.add(regra);
                        verifica = true;
                    }
                    break;
                case ';':
                    if (array[i] == ';') {
                        regra = 37;
                        nome = ";";
                        controle++;
                        System.out.println(regra);
                        arrayderegras.add(regra);
                        verifica = true;
                    }

                case ':':
                    if (array[i] == ':') {
                        regra = 38;
                        nome = ":";
                        controle++;
                        System.out.println(regra);
                        arrayderegras.add(regra);
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
                                    regra = 49;
                                    nome = "Comentario de bloco";
                                    controle++;
                                    System.out.println(regra);
                                    arrayderegras.add(regra);
                                    verifica = true;
                                    i++;
                                }
                            }
                        } else if (array[i] == '/') {
                            regra = 39;
                            nome = "/";
                            controle++;
                            System.out.println(regra);
                            arrayderegras.add(regra);
                            verifica = true;
                        }
                    } else if (array[i] == '/') {
                        regra = 39;
                        nome = "/";
                        controle++;
                        System.out.println(regra);
                        arrayderegras.add(regra);
                        verifica = true;
                    }

                case ',':
                    if (array[i] == ',') {
                        regra = 40;
                        nome = ",";
                        controle++;
                        System.out.println(regra);
                        arrayderegras.add(regra);
                        verifica = true;
                    }

                case ')':
                    if (array[i] == ')') {
                        regra = 42;
                        nome = ")";
                        controle++;
                        System.out.println(regra);

                        arrayderegras.add(regra);
                        verifica = true;
                    }

                case '(':
                    if (array[i] == '(') {
                        regra = 43;
                        nome = "(";
                        controle++;
                        System.out.println(regra);
                        arrayderegras.add(regra);
                        verifica = true;
                    }

                case '@':
                    if (array[i] == '@') {
                        regra = 44;
                        nome = "@";
                        controle++;
                        System.out.println(regra);
                        arrayderegras.add(regra);
                        verifica = true;
                    }

                case '*':
                    if (array[i] == '*') {
                        regra = 41;
                        nome = "*";
                        controle++;
                        System.out.println(regra);
                        arrayderegras.add(regra);
                        verifica = true;
                    }

                case '!':
                    if (i < array.length - 1) {
                        if (array[i + 1] == '=') {
                            regra = 45;
                            nome = "!=";
                            controle++;
                            System.out.println(regra);
                            arrayderegras.add(regra);
                            verifica = true;
                            i++;

                        }
                    }

                case '-':
                    if (i < array.length - 1) {
                        if (array[i + 1] == '-') {
                            regra = 46;
                            nome = "--";
                            controle++;
                            System.out.println(regra);
                            arrayderegras.add(regra);
                            verifica = true;
                            i++;

                        } else if (array[i] == '-') {
                            regra = 47;
                            nome = "-";
                            controle++;
                            System.out.println(regra);
                            arrayderegras.add(regra);
                            verifica = true;
                        }
                    } else if (array[i] == '-') {
                        regra = 47;
                        nome = "-";
                        controle++;
                        System.out.println(regra);
                        arrayderegras.add(regra);
                        verifica = true;

                    }

                    break;

                case '#':
                    if (array[i] == '#') {
                        int aux = array.length - 1;

                        while (array[aux] != '\n') {
                            i++;
                            if (i == array.length) {
                                break;
                            }
                        }
                        regra = 48;
                        nome = "comentario de linha";
                        controle++;
                        System.out.println(regra);
                        arrayderegras.add(regra);
                        verifica = true;
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
                        System.out.println("o comprimento é" + lenght);
                    if (i == array.length) {
                        break;
                    }
                    if (lenght <= 30) {
                       
                        regra = 7;
                        nome = "nomevariavel";
                        controle++;
                        System.out.println(regra);
                        arrayderegras.add(regra);

                        verifica = true;
                    } else {
                        erro = true;
                        nome_erro = "Excedeu o Tamanho do Nome da Variavel";
                    }
                    break;

                case '\'':
                    i++;
                    while (array[i] != '\'') {
                        i++;
                        if (i == array.length) {
                            break;
                        }
                    }
                    if (i <= 2) {
                        regra = 8;
                        nome = "nomedochar";
                        controle++;
                        System.out.println(regra);
                        arrayderegras.add(regra);
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
                        regra = 9;
                        nome = "nomedastring";
                        controle++;
                        System.out.println(regra);
                        arrayderegras.add(regra);
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
                                    regra = 27;
                                    nome = ">";
                                    controle++;
                                    arrayderegras.add(regra);
                                    verifica = true;

                                    break;
                                case ">>":
                                    regra = 25;
                                    nome = ">>";
                                    controle++;
                                    arrayderegras.add(regra);
                                    System.out.println(regra);
                                    verifica = true;
                                    break;

                                case ">=":
                                    regra = 26;
                                    nome = ">=";
                                    controle++;
                                    arrayderegras.add(regra);
                                    System.out.println(regra);
                                    verifica = true;
                                    break;

                                case "while":
                                    regra = 1;
                                    nome = "while";
                                    controle++;
                                    arrayderegras.add(regra);
                                    System.out.println(regra);
                                    verifica = true;

                                    break;
                                case "void":
                                    regra = 2;
                                    nome = "void";
                                    controle++;
                                    arrayderegras.add(regra);
                                    System.out.println(regra);
                                    verifica = true;

                                    break;

                                case "string":
                                    regra = 3;
                                    nome = "string";
                                    controle++;
                                    arrayderegras.add(regra);
                                    System.out.println(regra);
                                    verifica = true;
                                    break;

                                case "return":
                                    regra = 4;
                                    nome = "return";
                                    controle++;
                                    arrayderegras.add(regra);
                                    System.out.println(regra);
                                    verifica = true;

                                    break;

                                case "main":
                                    regra = 10;
                                    nome = "main";
                                    controle++;
                                    arrayderegras.add(regra);
                                    System.out.println(regra);
                                    verifica = true;
                                    break;

                                case "integer":
                                    regra = 12;
                                    nome = "integer";
                                    controle++;
                                    arrayderegras.add(regra);
                                    System.out.println(regra);
                                    verifica = true;
                                    break;

                                case "inicio":
                                    regra = 13;
                                    nome = "inicio";
                                    controle++;
                                    arrayderegras.add(regra);
                                    System.out.println(regra);
                                    verifica = true;
                                    break;

                                case "if":
                                    regra = 14;
                                    nome = "if";
                                    controle++;
                                    arrayderegras.add(regra);
                                    System.out.println(regra);
                                    verifica = true;
                                    break;

                                case "for":
                                    regra = 16;
                                    nome = "for";
                                    controle++;
                                    arrayderegras.add(regra);
                                    System.out.println(regra);
                                    verifica = true;
                                    break;

                                case "float":
                                    regra = 17;
                                    nome = "float";
                                    controle++;
                                    arrayderegras.add(regra);
                                    System.out.println(regra);
                                    verifica = true;
                                    break;

                                case "fim":
                                    regra = 18;
                                    nome = "fim";
                                    controle++;
                                    arrayderegras.add(regra);
                                    System.out.println(regra);
                                    verifica = true;
                                    break;

                                case "else":
                                    regra = 19;
                                    nome = "else";
                                    controle++;
                                    arrayderegras.add(regra);
                                    System.out.println(regra);
                                    verifica = true;
                                    break;

                                case "do":
                                    regra = 20;
                                    nome = "do";
                                    controle++;
                                    arrayderegras.add(regra);
                                    System.out.println(regra);
                                    verifica = true;
                                    break;

                                case "cout":
                                    regra = 21;
                                    nome = "cout";
                                    controle++;
                                    arrayderegras.add(regra);
                                    System.out.println(regra);
                                    verifica = true;
                                    break;

                                case "cin":
                                    regra = 22;
                                    nome = "cin";
                                    controle++;
                                    arrayderegras.add(regra);
                                    System.out.println(regra);
                                    verifica = true;
                                    break;

                                case "char":
                                    regra = 23;
                                    nome = "char";
                                    controle++;
                                    arrayderegras.add(regra);
                                    System.out.println(regra);
                                    verifica = true;
                                    break;

                                case "callfuncao":
                                    regra = 24;
                                    nome = "callfuncao";
                                    controle++;
                                    arrayderegras.add(regra);
                                    System.out.println(regra);
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
                                regra = 6;
                                nome = "numerofloat";
                                arrayderegras.add(regra);
                                verifica = true;
                            } else {
                                erro = true;
                                nome_erro = "Número Float Excede o Tamanho Máximo";
                            }
                        } else {
                            int valorInt = Integer.parseInt(pal.trim());

                            if ((valorInt >= -32767) && (valorInt <= 32767)) {
                                regra = 5;
                                nome = "numerointeiro";
                                arrayderegras.add(regra);
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
            } else if (verifica) {
                linhasRegras.add("Regra: " + regra + " linha: " + linha + " Token: " + nome);
                verifica = false;
            }

            if (array[i] == '\n') {
                linha++;

            }
        }

    }
}
