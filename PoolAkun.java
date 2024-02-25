
package studikasus;

public class PoolAkun {
    public Pelanggan[] pool = new Pelanggan[3];

    public void init(int umur) {
        try
        {
            pool[0] = new Gold(001, "APIK",umur , "0811", "AKTIF");
            pool[1] = new Reguler(002, "ARIK", umur,"0812", "TIDAK");
            pool[2] = new Platinum(003, "DANI", umur, "0813", "AKTIF");
        } catch (UmurNegatifException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
