/**
 * Class Buah
 *
 * @author Bryan Oliver
 * @version 24.4.2021
 */
public abstract class Buah {
    
    public String taste;
    public String ripelevel;
    public int age;

    public Buah(int age)
    {
        this.age = age;
        ubahRasa(age);
    }

    public void ubahRasa(int age)
    {
        if(age >= 20 && age < 25) {
            taste = "Asam";
            ripelevel = "Belum matang";
        } else if(age >= 25 && age < 30) {
            taste = "Manis";
            ripelevel = "Matang";
        } else if(age >= 30){
            taste = "Pahit";
            ripelevel = "Busuk";
        } else {
            taste = "N/A";
            ripelevel = "N/A";
        }    
    }
}
