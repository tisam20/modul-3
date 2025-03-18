import java.util.Scanner;

class Karyawan {
    String id, nama, shift;
    int jamKerja, absen;
    double gajiPerJam, gajiTotal;

    Karyawan(String idKaryawan, String namaKaryawan, String shiftKerja, int jamKerjaKaryawan, int absenKaryawan) {
        id = idKaryawan;
        nama = namaKaryawan;
        shift = shiftKerja;
        jamKerja = jamKerjaKaryawan;
        absen = absenKaryawan;
        gajiPerJam = hitungTarifPerJam(shift);
        gajiTotal = hitungGaji();
    }

    double hitungTarifPerJam(String shift) {
        switch (shift.toLowerCase()) {
            case "pagi": return 30000;
            case "siang": return 35000;
            case "malam": return 40000;
            default: return 0;
        }
    }

    double hitungGaji() {
        double gajiDasar = jamKerja * gajiPerJam;
        double lembur = 0;
        if (jamKerja > 40) {
            lembur = (jamKerja - 40) * (gajiPerJam * 1.5);
        }
        double potongan = (jamKerja < 30) ? (gajiDasar * 0.1) : 0;
        potongan += absen * 100000;
        return (gajiDasar + lembur - potongan);
    }

    void tampilkanGaji() {
        System.out.printf("%-10s %-15s %-10s %-10d %-10d Rp%,.2f\n",
                id, nama, shift, jamKerja, absen, gajiTotal);
    }
}

class HitungGajiKaryawan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan jumlah karyawan: ");
        int jumlahKaryawan = input.nextInt();
        input.nextLine();

        Karyawan[] karyawanList = new Karyawan[jumlahKaryawan];
        
        for (int i = 0; i < jumlahKaryawan; i++) {
            System.out.println("\nData Karyawan " + (i + 1));
            System.out.print("ID: ");
            String id = input.nextLine();
            System.out.print("Nama: ");
            String nama = input.nextLine();
            System.out.print("Shift (pagi/siang/malam): ");
            String shift = input.nextLine();

            int jamKerja;
            while (true) {
                System.out.print("Total jam kerja dalam seminggu: ");
                jamKerja = input.nextInt();
                if (jamKerja >= 0 && jamKerja <= 60) break;
                System.out.println("Jam kerja tidak valid. Masukkan antara 0 hingga 60 jam.");
            }

            int absen;
            while (true) {
                System.out.print("Jumlah hari absen: ");
                absen = input.nextInt();
                if (absen >= 0 && absen <= 7) break;
                System.out.println("Jumlah absen tidak valid. Masukkan antara 0 hingga 7 hari.");
            }
            input.nextLine();
            
            karyawanList[i] = new Karyawan(id, nama, shift, jamKerja, absen);
        }

        System.out.println("\nLaporan Gaji Karyawan:");
        System.out.printf("%-10s %-15s %-10s %-10s %-10s %-15s\n",
                "ID", "Nama", "Shift", "Jam Kerja", "Absen", "Total Gaji");
        for (Karyawan k : karyawanList) {
            k.tampilkanGaji();
        }
        input.close();
    }
}
// run program menggunakan run java agar program bisa dijalankan