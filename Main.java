package conversor;

import java.util.Scanner;

public class Main {
    public static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        exibirMenu();
        s.close();
        System.exit(0);
    }

    public static void exibirMenu() {
        int opcao = -1;
        do {
            System.out.println("Menu:");
            System.out.println("1 - Converter número para binário");
            System.out.println("2 - Converter número para octal");
            System.out.println("3 - Converter número para decimal");
            System.out.println("4 - Converter número para hexadecimal");
            System.out.println("0 - Sair");
            System.out.print("Selecione uma opção: ");
            opcao = s.nextInt();
            s.nextLine();

            if (opcao == 0) {
                sair();
                break;
            }

            System.out.println();
            System.out.print("Informe um número para conversão: ");
            String numeroParaConversao = s.nextLine();
            System.out.print("Informe a base do número informado: ");
            int baseDoNumeroInformado = s.nextInt();
            s.nextLine();

            switch (opcao) {
                case 1:
                    converterNumeroParaBinarioEExibir(numeroParaConversao, baseDoNumeroInformado);
                    break;
                case 2:
                    converterNumeroParaOctalEExibir(numeroParaConversao, baseDoNumeroInformado);
                    break;
                case 3:
                    converterNumeroParaDecimalEExibir(numeroParaConversao, baseDoNumeroInformado);
                    break;
                case 4:
                    converterNumeroParaHexadecimalEExibir(numeroParaConversao, baseDoNumeroInformado);
                    break;
                default:
                    System.out.println("Opção inválida selecionada! Tente novamente.");
                    opcao = s.nextInt();
                    break;
            }
        } while (opcao != 0);
    }

    public static void converterNumeroParaBinarioEExibir(String numeroParaConversao, int baseDoNumeroInformado) {
        if (baseDoNumeroInformado == 2) {
            System.out.println("Conversão desnecessária, portanto o número é: " + numeroParaConversao);
        } else if (baseDoNumeroInformado == 8) {
            String[] caracteres = numeroParaConversao.split("");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < caracteres.length; i++) {
                for (int j = Integer.parseInt(caracteres[i]); (j / 2 == 0) || (j / 2 >= 1); j /= 2) {
                    if (j == 0) {
                        break;
                    }

                    if (j % 2.0 > 0) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                }
            }
            String resultado = sb.toString();
            System.out.println("O resultado da conversão de octal para binário é: " + resultado);
        } else if (baseDoNumeroInformado == 10) {
            int numeroInteiro = Integer.parseInt(numeroParaConversao);
            StringBuilder sb = new StringBuilder();
            for (int i = numeroInteiro; (i / 2 == 0) || (i / 2 >= 1); i /= 2) {
                double numero = (double) i;
                if (numero == 0) {
                    break;
                }

                if (numero % 2.0 > 0) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
            }
            String resultado = sb.reverse().toString();
            System.out.println("O resultado da conversão de decimal para binário é: " + resultado + "\n");
        } else if (baseDoNumeroInformado == 16) {
            String[] caracteres = numeroParaConversao.split("");
            for (int i = 0; i < caracteres.length; i++) {
                if (caracteres[i].equalsIgnoreCase("a")) {
                    caracteres[i] = "10";
                } else if (caracteres[i].equalsIgnoreCase("b")) {
                    caracteres[i] = "11";
                } else if (caracteres[i].equalsIgnoreCase("c")) {
                    caracteres[i] = "12";
                } else if (caracteres[i].equalsIgnoreCase("d")) {
                    caracteres[i] = "13";
                } else if (caracteres[i].equalsIgnoreCase("e")) {
                    caracteres[i] = "14";
                } else if (caracteres[i].equalsIgnoreCase("f")) {
                    caracteres[i] = "15";
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < caracteres.length; i++) {
                for (int j = Integer.parseInt(caracteres[i]); (j / 2 == 0) || (j / 2 >= 1); j /= 2) {
                    if (j == 0) {
                        break;
                    }

                    if (j % 2.0 > 0) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                }
            }
            String resultado = sb.toString();
            System.out.println("O resultado da conversão de Hexadecimal para binário é: " + resultado);
        }
    }

    public static void converterNumeroParaOctalEExibir(String numeroParaConversao, int baseDoNumeroInformado) {
        if (baseDoNumeroInformado == 2) {
            String[] caracteres = numeroParaConversao.split("");
            String[] valores = new String[(int)Math.ceil(caracteres.length/3.0)];
            int[] valoresInteiros = new int[valores.length];
            StringBuilder sb = new StringBuilder();
            int k = 0;
            for(int i = 0; i < caracteres.length; i++){
                for(int j = k; j <= k+3; j++){
                    if(j < caracteres.length - 1){
                        sb.append(caracteres[j]);
                    }else{
                        break;
                    }
                    if(sb.length() == 3){
                        valores[i] = sb.toString();
                        sb.setLength(0);
                        k += 3;
                        j += 2;
                    }
                }
            }

            for(int i = 0; i < valores.length; i++){
                for(int j = 0; j < valores[i].length(); j++){
                    valoresInteiros[i] += Integer.parseInt(valores[i].split("")[j]) * Math.pow(2,j);
                }
            }
            sb.setLength(0);
            for(int valor : valoresInteiros){
                sb.append(valor);
            }
            String resultado = sb.toString();
            System.out.println("O resultado da conversão de binário para octal é: " + resultado);
        } else if (baseDoNumeroInformado == 8) {
            System.out.println("Conversão desnecessária, portanto o número é: " + numeroParaConversao);
        } else if (baseDoNumeroInformado == 10) {
            String[] caracteres = numeroParaConversao.split("");
        } else if (baseDoNumeroInformado == 16) {

        }
    }

    public static void converterNumeroParaDecimalEExibir(String numeroParaConversao, int baseDoNumeroInformado) {
        if (baseDoNumeroInformado == 2) {
            String[] caracteres = numeroParaConversao.split("");
            int[] numeros = new int[caracteres.length];
            int[] numerosOrdenados = new int[numeros.length];
            for (int i = 0; i < numeros.length; i++) {
                numeros[i] = Integer.parseInt(caracteres[i]);
            }
            for (int i = 0; i < numeros.length; i++) {
                numerosOrdenados[i] = numeros[numeros.length - 1 - i];
            }
            int resultado = 0;
            for (int i = 0; i < numerosOrdenados.length; i++) {
                resultado += numerosOrdenados[i] * Math.pow(2, i);
            }
            System.out.println("O resultado da conversão de binário para decimal é: " + resultado + "\n");
        } else if (baseDoNumeroInformado == 8) {

        } else if (baseDoNumeroInformado == 10) {
            System.out.println("Conversão desnecessária, portanto o número é: " + numeroParaConversao);
        } else if (baseDoNumeroInformado == 16) {
            String[] caracteres = numeroParaConversao.split("");
            for (int i = 0; i < caracteres.length; i++) {
                if (caracteres[i].equalsIgnoreCase("a")) {
                    caracteres[i] = "10";
                } else if (caracteres[i].equalsIgnoreCase("b")) {
                    caracteres[i] = "11";
                } else if (caracteres[i].equalsIgnoreCase("c")) {
                    caracteres[i] = "12";
                } else if (caracteres[i].equalsIgnoreCase("d")) {
                    caracteres[i] = "13";
                } else if (caracteres[i].equalsIgnoreCase("e")) {
                    caracteres[i] = "14";
                } else if (caracteres[i].equalsIgnoreCase("f")) {
                    caracteres[i] = "15";
                }
            }
            int[] numeros = new int[caracteres.length];
            for (int i = 0; i < caracteres.length; i++) {
                numeros[i] = Integer.parseInt(caracteres[i]);
            }
            int[] numerosOrdenados = new int[numeros.length];
            for (int i = 0; i < numeros.length; i++) {
                numerosOrdenados[i] = numeros[numeros.length - 1 - i];
            }
            int resultado = 0;
            for (int i = 0; i < numerosOrdenados.length; i++) {
                resultado += numerosOrdenados[i] * Math.pow(16, i);
            }
            System.out.println("O resultado da conversão de Hexadecimal para Decimal é: " + resultado + "\n");
        }
    }

    public static void converterNumeroParaHexadecimalEExibir(String numeroParaConversao, int baseDoNumeroInformado) {
        if (baseDoNumeroInformado == 2) {

        } else if (baseDoNumeroInformado == 8) {

        } else if (baseDoNumeroInformado == 10) {
            int numeroInteiro = Integer.parseInt(numeroParaConversao);
            StringBuilder sb = new StringBuilder();
            for (int i = numeroInteiro; (i / 16 >= 0) || (i / 16 <= 15); i /= 16) {

                if (i / 16 == 10) {
                    sb.append("a");
                } else if (i / 16 == 11) {
                    sb.append("b");
                } else if (i / 16 == 12) {
                    sb.append("c");
                } else if (i / 16 == 13) {
                    sb.append("d");
                } else if (i / 16 == 14) {
                    sb.append("e");
                } else if (i / 16 == 15) {
                    sb.append("f");
                } else if ((i / 16 > 0) && (i / 16 <= 9)) {
                    sb.append(i % 16);
                } else {
                    if (i == 0) {
                        break;
                    }
                }
            }
            String resultado = sb.toString();
            System.out.println("O resultado da conversão de Decimal para Hexadecimal é: " + resultado + "\n");
        } else if (baseDoNumeroInformado == 16) {
            System.out.println("Conversão desnecessária, portanto o número é: " + numeroParaConversao);
        }
    }

    public static void sair() {
        System.out.println("Saindo...");
        s.close();
        System.exit(0);
    }
}