package studikasus;

public class Gold extends Pelanggan implements Interface1 {
    Film[] p;

    Gold(int kode, String nama, int umur, String noTelp, String status) throws UmurNegatifException{
        this.kode = kode;
        this.nama = nama;
        this.umur = umur;
        this.noTelp = noTelp;
        this.status = status;
        super.kategoriPel = "Gold";
        if (this.umur < 0) {
            throw new UmurNegatifException("Umur tidak boleh negatif");
        }
    }

    public void printFilm() {
        int x = 1;
        int y = 0;
        p = new Film[totalFilm()];
        for (int i = 0; i < pool.length; i++) {
            if (pool[i].filmDetail[5].equals("REGULER") || pool[i].filmDetail[5].equals("NEW")) {
                p[y] = pool[i];
                System.out.println(x + ". " + pool[i].filmDetail[0]);
                x++;
                y++;
            }
        }
    }

    public int totalFilm() {
        int a = 1;
        for (int i = 0; i < pool.length; i++) {
            if (pool[i].filmDetail[5].equals("REGULER") || pool[i].filmDetail[5].equals("NEW")) {
                a++;
            }
        }
        return a;
    }

    public void printDetail(int i) {
        System.out.println("Judul   : " + p[i - 1].filmDetail[0]);
        System.out.println("Genre   : " + p[i - 1].filmDetail[1]);
        System.out.println("Tahun   : " + p[i - 1].filmDetail[2]);
        System.out.println("Rating  : " + p[i - 1].filmDetail[3]);
        System.out.println("Sinopsis: " + p[i - 1].filmDetail[4]);
        System.out.println("Kategori: " + p[i - 1].filmDetail[5]);
    }

    public Film getPlaying(int i) {
        return p[i - 1];
    }

}