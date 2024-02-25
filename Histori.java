package studikasus;

public class Histori {
    private Film[] histori = new Film[10];
    private int hitungan = 0;

    Histori() {
        initHistori();
    }

    public void initHistori() {
        for (int i = 0; i < 10; i++) {
            histori[i] = new Film();
        }
    }

    public void masukHistori(Film in) {
        if (hitungan < 10) {
            for (int i = 0; i < histori.length; i++) {
                if (histori[i].filmDetail[0] == null) {
                    histori[i] = in;
                    hitungan++;
                    break;
                }
            }
        } else {
            for (int i = 0; i < histori.length - 1; i++) {
                histori[i] = histori[i + 1];
            }
            histori[9] = in;
        }
    }

    public void printHistori() {
        System.out.print("Histori : ");
        for (int i = 0; i < 10; i++) {
            if (histori[i].filmDetail[0] == null)
                break;
            System.out.print(histori[i].filmDetail[0]);
            if (i != 9) {
                System.out.print("-");
            }
        }
    }
}
