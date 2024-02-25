package studikasus;

public class Film {
    protected String[] filmDetail = new String[6];

    Film() {
    }

    Film(String judul, String genre, String tahun, String rekomenUmur, String sinopsis) throws TahunTooOldException{
        filmDetail[0] = judul;
        filmDetail[1] = genre;
        filmDetail[2] = tahun;
        filmDetail[3] = rekomenUmur;
        filmDetail[4] = sinopsis;
        checkKategori();
        if (Integer.parseInt(filmDetail[2]) <= 1800)
            throw new TahunTooOldException("Film harus diatas tahun 1800!");
    }

    Film(String judul, String genre, String tahun, String rekomenUmur, String sinopsis, String kategoriFilm) {
        filmDetail[0] = judul;
        filmDetail[1] = genre;
        filmDetail[2] = tahun;
        filmDetail[3] = rekomenUmur;
        filmDetail[4] = sinopsis;
        filmDetail[5] = kategoriFilm;
    }

    private void checkKategori() {
        if (2023 - Integer.parseInt(filmDetail[2]) > 5) {
            filmDetail[5] = "REGULER";
        } else {
            filmDetail[5] = "NEW";

        }
    }

}
