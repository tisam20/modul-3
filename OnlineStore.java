import java.util.Scanner;

public class OnlineStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan total belanja: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Error: Input total belanja harus berupa angka.");
            return;
        }
        double totalBelanja = scanner.nextDouble();
        scanner.nextLine(); 

        if (totalBelanja < 0) {
            System.out.println("Error: Total belanja tidak bisa negatif.");
            return;
        }

        System.out.print("Masukkan tipe member (Platinum/Gold/Silver/None): ");
        String memberType = scanner.nextLine().trim();

        double diskonUtama = (totalBelanja > 500000) ? 0.20 :
                             (totalBelanja >= 250000) ? 0.10 : 0.0;
        double totalSetelahDiskon = totalBelanja * (1 - diskonUtama);

        double diskonTambahan;
        switch (memberType.toLowerCase()) {
            case "platinum":
                diskonTambahan = 0.05;
                break;
            case "gold":
                diskonTambahan = 0.03;
                break;
            case "silver":
                diskonTambahan = 0.02;
                break;
            case "none":
                diskonTambahan = 0.0;
                break;
            default:
                System.out.println("Error: Tipe member tidak valid.");
                return;
        }

        totalSetelahDiskon *= (1 - diskonTambahan);

        String statusDiskon = (diskonUtama > 0 || diskonTambahan > 0) ? "Ya" : "Tidak";
        System.out.println("Mendapatkan diskon: " + statusDiskon);
        System.out.printf("Total yang harus dibayar: Rp%.2f\n", totalSetelahDiskon);

        scanner.close();
    }
}
