
package studikasus;

public class Platinum extends Pelanggan implements Interface1{
    Film[] p;

    Platinum(int kode, String nama, int umur, String noTelp, String status) throws UmurNegatifException{
        this.kode = kode;
        this.nama = nama;
        this.umur = umur;
        this.noTelp = noTelp;
        this.status = status;
        super.kategoriPel = "Platinum";
        if (this.umur < 0) {
            throw new UmurNegatifException("Umur tidak boleh negatif");
        }
    }

    public void printFilm() {
        int x = 1;
        int y = 0;
        p = new Film[totalFilm()];
        for (int i = 0; i < pool.length; i++) {
            if (pool[i].filmDetail[5].equals("REGULER") || pool[i].filmDetail[5].equals("NEW")
                    || pool[i].filmDetail[5].equals("Ori")) {
                p[y] = pool[i];
                System.out.println(x + ". " + pool[i].filmDetail[0]);
                x++;
                y++;
            }
        }
    }

    public Film getPlaying(int i) {
        return pool[i - 1];
    }

    public int totalFilm() {
        int a = 1;
        for (int i = 0; i < pool.length; i++) {
            if (pool[i].filmDetail[5].equals("REGULER") || pool[i].filmDetail[5].equals("NEW")
                    || pool[i].filmDetail[5].equals("Ori")) {
                a++;
            }
        }
        return a;
    }

    public void printDetail(int i) {
        System.out.println("Judul   : " + pool[i - 1].filmDetail[0]);
        System.out.println("Genre   : " + pool[i - 1].filmDetail[1]);
        System.out.println("Tahun   : " + pool[i - 1].filmDetail[2]);
        System.out.println("Rating  : " + pool[i - 1].filmDetail[3]);
        System.out.println("Sinopsis: " + pool[i - 1].filmDetail[4]);
        System.out.println("Kategori: " + pool[i - 1].filmDetail[5]);
    }
}
