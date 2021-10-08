package hr.home;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int lineNumber = 1;

        while (!line.equals("az")) {
            String[] znakoviRed = line.split(" ");
            List<String> listaIspis = analizirajRed(znakoviRed, lineNumber);

        }
    }

    private static List<String> analizirajRed(String[] znakoviRed, int lineNumber) {
        List<String> lista = new ArrayList<>();
        boolean komentar = false;
        for (String s : znakoviRed) {
            if (s.equals("=")) {
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
            else if (s.matches("^[a-zA-z][a-zA-z0-9]*$")) {
                lista.add("IDN " + lineNumber + " " + s);
            }


        }



        return lista;
    }


}

