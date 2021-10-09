package hr.home;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeksickiAnalizator{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lineNumber = 1;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] znakoviRed = line.split(" ");
            List<String> listaIspis = analizirajRed(znakoviRed, lineNumber);
            for (String s : listaIspis) {
                System.out.println(s);
            }
            lineNumber++;
        }
    }

    private static List<String> analizirajRed(String[] znakoviRed, int lineNumber) {
        List<String> lista = new ArrayList<>();
        boolean komentar = false;
        for (String s : znakoviRed) {
            if (s.startsWith("//")) {
                break;
            }
            else if (s.equals("=")) {
                lista.add("OP_PRIDRUZI " + lineNumber + " =");
            }
            else if (s.equals("+")) {
                lista.add("OP_PLUS " + lineNumber + " +");
            }
            else if (s.equals("-")) {
                lista.add("OP_MINUS " + lineNumber + " -");
            }
            else if (s.equals("/")) {
                lista.add("OP_DIJELI " + lineNumber + " /");
            }
            else if (s.equals("*")) {
                lista.add("OP_PUTA " + lineNumber + " *");
            }
            else if (s.equals("za")) {
                lista.add("KR_ZA " + lineNumber + " za");
            }
            else if (s.equals("az")) {
                lista.add("KR_AZ " + lineNumber + " az");
            }
            else if (s.equals("od")) {
                lista.add("KR_OD " + lineNumber + " od");
            }
            else if (s.equals("do")) {
                lista.add("KR_DO " + lineNumber + " do");
            }
            else if (s.equals("(")) {
                lista.add("L_ZAGRADA " + lineNumber + " (");
            }
            else if (s.equals(")")) {
                lista.add("D_ZAGRADA " + lineNumber + " )");
            }
            else if (s.matches("^[a-zA-z][a-zA-z0-9]*$")) {
                lista.add("IDN " + lineNumber + " " + s);
            }
            else if (s.matches("[0-9]+")) {
                lista.add("BROJ " + lineNumber + " " + s);
            }
            else {
                slozeniIzraz(s, lineNumber, lista);
            }



        }



        return lista;
    }

    private static void slozeniIzraz(String s, int lineNumber, List<String> lista) {
        for (int i = 0; i < s.length(); i++) {
            char znak = s.charAt(i);

            if (znak == '=') {
                lista.add("OP_PRIDRUZI " + lineNumber + " =");
            }
            else if (znak == '+') {
                lista.add("OP_PLUS " + lineNumber + " +");
            }
            else if (znak == '-') {
                lista.add("OP_MINUS " + lineNumber + " -");
            }
            else if (znak == '/') {
                lista.add("OP_DIJELI " + lineNumber + " /");
            }
            else if (znak == '*') {
                lista.add("OP_PUTA " + lineNumber + " *");
            }
            else if (znak == '(') {
                lista.add("L_ZAGRADA " + lineNumber + " (");
            }
            else if (znak == ')') {
                lista.add("D_ZAGRADA " + lineNumber + " )");
            }
            else if (Character.isAlphabetic(znak)) {
                StringBuilder sb = new StringBuilder(" " + znak);
                int j = i+1;
                while (j < s.length() && Character.isAlphabetic(s.charAt(j))){
                    sb.append(s.charAt(j));
                    j++;
                }
                i=j-1;
                lista.add("IDN " + lineNumber + sb);

            }
            else if (Character.isDigit(znak)) {
                StringBuilder sb = new StringBuilder(" " + znak);
                int j = i+1;
                while (j < s.length() && Character.isDigit(s.charAt(j))){
                   sb.append(s.charAt(j));
                   j++;
                }
                i=j-1;
                lista.add("BROJ " + lineNumber + sb);
            }

        }
    }



}

