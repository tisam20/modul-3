import java.util.Scanner;

public class Vokal {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Masukkan sebuah kalimat: ");
        String kalimat = input.nextLine();

        int jumlahVokal = 0;
        for (int i = 0; i < kalimat.length(); i++) {
            char c = kalimat.charAt(i);
            if (c == 'a' || c == 'i' || c == 'u' || c == 'e' || c == 'o') {
                jumlahVokal++;
            }
        }

        System.out.println("Jumlah huruf vokal dalam kalimat: " + jumlahVokal);

        switch (jumlahVokal % 2) {
            case 0:
                System.out.println("Jumlah vokal genap");
                break;
            case 1:
                System.out.println("Jumlah vokal ganjil");
                break;
        }

        System.out.print("Kalimat terbalik: ");
        char[] karakter = kalimat.toCharArray();
        for (char c : reverseArray(karakter)) {
            System.out.print(c);
        }
        System.out.println();

        input.close();
    }

    public static char[] reverseArray(char[] array) {
        char[] reversed = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - 1 - i];
        }
        return reversed;
    }
}
