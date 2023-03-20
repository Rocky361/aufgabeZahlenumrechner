import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        hauptMenu();
    }





    private static void hauptMenu(){
        System.out.println("------------------------");
        System.out.println("Zahlen Umrechner");
        System.out.println("------------------------");
        System.out.println("(1)Dezimal zu Binär");
        System.out.println("(2)Dezimal zu Hexadezimal");
        System.out.println("(3)Binär zu Dezimal");
        System.out.println("(4)Hexadezimal zu Decimal");
        System.out.println("(E)nde");
        System.out.println("------------------------");
        System.out.println("Bitte auswählen");
        Scanner scanner = new Scanner(System.in);
        String menuEingabe = scanner.next().toUpperCase();
        try {
            if(menuEingabe.equals("1")){
                System.out.println("Zahl eingeben die umgewandelt werden soll:");
                while (true) {
                    try {
                        int umrechnungsZahl = scanner.nextInt();
                        dezimalNachBinaer(umrechnungsZahl);
                    } catch (InputMismatchException e) {
                        System.out.println("Fehler: Bitte eine gültige Dezimalzahl eingeben.");
                        scanner.nextLine();
                    }
                }
            }
            else if(menuEingabe.equals("2")){
                System.out.println("Zahl eingeben die umgewandelt werden soll:");
                while(true){
                    try{
                        int umrechnungsZahl = scanner.nextInt();
                        dezimalNachHHexadezimal(umrechnungsZahl);
                    } catch (InputMismatchException e){
                        System.out.println("Fehler: Bitte eine gültige Dezimalzahl eingeben.");
                        scanner.nextLine();
                    }
                }
            }
            else if(menuEingabe.equals("3")){
                System.out.println("Zahl eingeben die umgewandelt werden soll:");
                String umrechnungsZahl = scanner.next();
                binaerNachDezimal(umrechnungsZahl);
            }
            else if(menuEingabe.equals("4")){
                System.out.println("Zahl eingeben die umgewandelt werden soll:");
                String umrechnungsZahl = scanner.next();
                hexaNachDezimal(umrechnungsZahl);
            }
            else if (menuEingabe.equals("E")) {
                System.out.println("Programm wird beendet.....");
                System.exit(0);
            }
            else{
                throw new IllegalArgumentException("Falsche Eingabe!");
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            hauptMenu();
        }
    }

    private static String dezimalNachBinaer(int decimalZahl){
        String binary = "";
        try {
            binary = Integer.toBinaryString(decimalZahl);
        } catch (NumberFormatException e) {
            System.out.println("Fehler: Bitte geben Sie eine gültige Dezimalzahl ein.");
        }
        System.out.println(binary);
        hauptMenu();
        return binary;
    }

    private static String dezimalNachHHexadezimal(int decimalZahl) {
        String hex;
        try {
            hex = Integer.toHexString(decimalZahl);
        } catch (NumberFormatException e) {
            System.out.println("Fehler: Die eingegebene Dezimalzahl ist ungültig.");
            return null;
        }
        System.out.println(hex);
        hauptMenu();
        return hex;
    }

    private static int binaerNachDezimal(String binaer){
        try {
            int decimal = Integer.parseInt(binaer, 2);
            System.out.println(decimal);
            hauptMenu();
            return decimal;
        } catch (NumberFormatException ex) {
            System.out.println("Falsches Format für die binäre Zahl!");
            hauptMenu();
            return 0;
        }
    }

    private static int hexaNachDezimal(String hexa) {
        try {
            int decimal = Integer.parseInt(hexa, 16);
            System.out.println(decimal);
            hauptMenu();
            return decimal;
        } catch (NumberFormatException ex) {
            System.out.println("Falsches Format für die Hexadezimalzahl!");
            hauptMenu();
            return 0;
        }
    }



}