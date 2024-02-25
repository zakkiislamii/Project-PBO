package studikasus;

public abstract class Pelanggan {
    public String kategoriPel;
    protected Film[] pool = new Film[10];
    protected int kode;
    protected String nama;
    protected String noTelp;
    protected String status;
    protected int umur;

    public abstract void printDetail(int i);

    public abstract void printFilm();

    Pelanggan() {
        initialization();
    }

    public enum Genre {
        Drama,
        Action,
        Comedy,
        Horor,
        Romance,
        Fantasy,
        Adventure,
        Thriller,
        SciFi,
        Misteri;
    }

    public void initialization() {
        try
        {
            pool[0] = new Film("A", "" + Genre.Action, "1998", "13", "Seru");
            pool[1] = new Film("B", "" + Genre.Horor, "1911", "16", "Menakutkan");
            pool[2] = new Film("C", "" + Genre.Misteri, "1995", "13", "Membingungkan");
            pool[3] = new Film("D", "" + Genre.Romance, "1978", "14", "Seru");
            pool[4] = new Film("E", "" + Genre.SciFi, "1920", "13", "Seru", "Ori");
            pool[5] = new Film("F", "" + Genre.Thriller, "2022", "16", "Menyeramkan");
            pool[6] = new Film("G", "" + Genre.Adventure, "2017", "13", "Seru");
            pool[7] = new Film("H", "" + Genre.Comedy, "2016", "SU", "Seru");
            pool[8] = new Film("I", "" + Genre.Drama, "2015", "13", "Seru");
            pool[9] = new Film("J", "" + Genre.Fantasy, "2014", "13", "Seru");
        } catch (TahunTooOldException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public int getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public String getStatus() {
        return status;
    }

    public int getUmur() {
        return umur;
    }

    public Film getPlaying(int i) {
        return pool[i - 1];
    }
}
