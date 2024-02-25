package studikasus;

import java.util.Scanner;

public class JalaFlix {
    public static void main(String[] args) {
        PoolAkun pa = new PoolAkun();
        Scanner sc = new Scanner(System.in);
        boolean login = false;
        boolean aktif = true;
        boolean stop = false;
        boolean admin = false;
        int x = -1;

        System.out.println("LOGIN");
        System.out.println("=====================");

        do {
            int code = 000;
            String nama = "";
            int inputUmur = -1;
            while (inputUmur < 0)
            {
                aktif = true;
                System.out.print("User Code : ");
                code = sc.nextInt();
                sc.nextLine();
                System.out.print("Nama      : ");
                nama = sc.nextLine();
                System.out.print("Umur      : ");
                inputUmur = sc.nextInt(); sc.nextLine();
                pa.init(inputUmur);
            }
            for (int i = 0; i < pa.pool.length; i++) {
                if (code == pa.pool[i].getKode() && nama.toUpperCase().equals(pa.pool[i].getNama())
                        && pa.pool[i].getStatus() == "AKTIF") {
                    login = true;
                    x = i;
                    System.out.println("=====================");
                } else if (code == pa.pool[i].getKode() && nama.toUpperCase().equals(pa.pool[i].getNama())
                        && pa.pool[i].getStatus() == "TIDAK") {
                    aktif = false;
                }
            }
            if (login == false && aktif == true) {
                System.out.println();
                System.out.println("Akun tidak terdaftar");
                System.out.println("=====================");
            } else if (login == false && aktif == false) {
                System.out.println();
                System.out.println("Akun tidak aktif");
                System.out.println("=====================");
            }
        } while (login == false);

        System.out.println("Code    : " + pa.pool[x].getKode());
        System.out.println("Nama    : " + pa.pool[x].getNama());
        System.out.println("Umur    : " + pa.pool[x].getUmur());
        System.out.println("No Telp : " + pa.pool[x].getNoTelp());
        System.out.println("Status  : " + pa.pool[x].getStatus());
        System.out.println("=====================");
        System.out.println();

        Pelanggan pel = pa.pool[x];
        Histori his = new Histori();

        if (pa.pool[x].nama.equals("DANI")) {
            stop = true;
            admin = true;
            System.out.println("Admin mode");
        }

        if (admin) {
            while (true) {
                System.out.println("=====================");
                System.out.println("Masukkan tahun film yang ingin di masukan: ");
                String tahun = sc.nextLine();
                try 
                {
                    Film tes = new Film("A", "B", tahun, "C", "D");
                    System.out.println("Film masuk dalam daftar");
                    break;
                }
                catch (TahunTooOldException e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }

        while (!stop) {
            menu();
            System.out.println("=====================");
            int in = sc.nextInt();
            sc.nextLine();
            switch (in) {
                case 1:
                    System.out.println("=====================");
                    pel.printFilm();
                    System.out.print("Input : ");
                    int z = sc.nextInt();
                    System.out.println("=====================");
                    pel.printDetail(z);
                    his.masukHistori(pel.getPlaying(z));
                    System.out.println("=====================");
                    System.out.println("Playing");
                    System.out.println("O===================O");
                    System.out.println("=====================");
                    break;
                case 2:
                    if (pel.kategoriPel.equals("Reguler")) {
                        System.out.println("Gold/Platinum");
                        String masuk2 = sc.next();
                        System.out.println("=====================");
                        if (masuk2.toUpperCase().equals("GOLD")) {
                            try
                            {pel = new Gold(pa.pool[x].getKode(), pa.pool[x].getNama(), pa.pool[x].getUmur(),
                                    pa.pool[x].getNoTelp(), pa.pool[x].getStatus());}
                            catch (UmurNegatifException e)
                            {
                                System.out.println(e.getMessage());
                            }
                        } else if (masuk2.toUpperCase().equals("PLATINUM")) {
                            try
                            {pel = new Platinum(pa.pool[x].getKode(), pa.pool[x].getNama(), pa.pool[x].getUmur(),
                                    pa.pool[x].getNoTelp(), pa.pool[x].getStatus());}
                            catch (UmurNegatifException e)
                            {
                                System.out.println(e.getMessage());
                            }
                        } else {
                            System.out.println("=====================");
                            System.out.println("Input tidak valid");
                            System.out.println("=====================");
                        }
                    } else if (pel.kategoriPel.equals("Gold")) {
                        System.out.println("=====================");
                        try
                            {pel = new Platinum(pa.pool[x].getKode(), pa.pool[x].getNama(), pa.pool[x].getUmur(),
                                    pa.pool[x].getNoTelp(), pa.pool[x].getStatus());}
                            catch (UmurNegatifException e)
                            {
                                System.out.println(e.getMessage());
                            }
                    } else {
                        System.out.println("=====================");
                        System.out.println("Tidak bisa upgrade lagi");
                        System.out.println("=====================");
                    }
                    break;
                case 3:
                    System.out.println("=====================");
                    if (pel.kategoriPel.equals("Platinum")) {
                        System.out.println("Gold/Reguler");
                        String masuk2 = sc.next();
                        System.out.println("=====================");
                        if (masuk2.toUpperCase().equals("GOLD")) {
                            try
                            {pel = new Gold(pa.pool[x].getKode(), pa.pool[x].getNama(), pa.pool[x].getUmur(),
                                    pa.pool[x].getNoTelp(), pa.pool[x].getStatus());}
                            catch (UmurNegatifException e)
                            {
                                System.out.println(e.getMessage());
                            }
                        } else if (masuk2.toUpperCase().equals("REGULER")) {
                            System.out.println("=====================");
                            try
                            {pel = new Reguler(pa.pool[x].getKode(), pa.pool[x].getNama(), pa.pool[x].getUmur(),
                                    pa.pool[x].getNoTelp(), pa.pool[x].getStatus());}
                            catch (UmurNegatifException e)
                            {
                                System.out.println(e.getMessage());
                            }
                        } else {
                            System.out.println("=====================");
                            System.out.println("Input tidak valid");
                            System.out.println("=====================");
                        }
                    } else if (pel.kategoriPel.equals("Gold")) {
                        try
                            {pel = new Reguler(pa.pool[x].getKode(), pa.pool[x].getNama(), pa.pool[x].getUmur(),
                                    pa.pool[x].getNoTelp(), pa.pool[x].getStatus());}
                            catch (UmurNegatifException e)
                            {
                                System.out.println(e.getMessage());
                            }
                    } else {
                        System.out.println("=====================");
                        System.out.println("Tidak bisa downgrade lagi");
                        System.out.println("=====================");
                    }
                    break;
                case 4:
                    stop = true;
                    his.printHistori();
                    break;
            }
        }
        sc.close();
    }

    static void menu() {
        System.out.println("Menu : ");
        System.out.println("1. Film List");
        System.out.println("2. Status Upgrade");
        System.out.println("3. Status Downgrade");
        System.out.println("4. Quit");
    }

}
