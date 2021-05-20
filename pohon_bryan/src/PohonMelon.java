/**
 * Class PohonPepaya
 *
 * @author Bryan Oliver
 * @version 24.4.2021
 */
import java.util.Random;
import java.util.stream.IntStream;
import java.util.ArrayList;

public class PohonMelon extends Tumbuhan implements Penghijauan, Komoditas{

    private int gasMinimum = 1;
    private int gasMaximum = 4;
    private int price;
    private int[] fruitStat = new int[3];
    private int sums;
    private Random r = new Random();

    private ArrayList<BuahMelon> fruitList;

    public int hasilO2 = 0;
    public int hasilCO2 = 0;
    public int numofLeaves = 3;
    
 // create collection var


    public PohonMelon()
    {
        fruitList = new ArrayList<BuahMelon>();
        numofLeaves = 5;
        price = 0;
    }

    @Override
    public void fotosintesis()
    {
        hasilO2 += r.nextInt((gasMaximum - gasMinimum) + 1) + gasMinimum;
        hasilCO2 += r.nextInt((gasMaximum - gasMinimum) + 1) + gasMinimum;
    }

    @Override
    public void tumbuhDaun()
    {
        numofLeaves += r.nextInt(5);
    }

    @Override
    public void rontokDaun()
    {
        numofLeaves -= r.nextInt(2);
    }
    //fungsi berbuah untuk BuahMelon membuat PohonMelon lebih sulit berbuah dari Pohon
    public ArrayList<BuahMelon> berbuah(int age)
    {
        if (age > 15) {
            if (age % 5 == 0) {
                fruitList.add(new BuahMelon(age));
            }
        }
        return fruitList;
    }

    @Override
    public void setHarga(int price)
    {
    	this.price = price;
    }

    @Override
    public int getHarga()
    {
        return price;
    }

    public String dailyRoutine(int umur)
    {
        //Reset statusBuah
        fruitStat[0] = 0;
        fruitStat[1] = 0;
        fruitStat[2] = 0;

        //Pemanggilan fungsi tumbuh
        tumbuh();

        //Pemanggilan fungsi fotosintessis
        fotosintesis();

        // Pemanggilan fungsi tumbuhDaun
        tumbuhDaun();

        // Pemanggilan fungsi rontokDaun
        rontokDaun();

        //Pemanggilan fungsi berbuah dengan parameter umur
        berbuah(umur);

        //Fungsi for untuk pengukuran kematangan buah
       for(BuahMelon buah : fruitList){
        if(buah.ripelevel.matches("Belum matang"))
            fruitStat[0] += 1;
        if(buah.ripelevel.matches("Matang"))
            fruitStat[1] += 1;
        if(buah.ripelevel.matches("Busuk"))
            fruitStat[2] += 1;
        };
        int sums = IntStream.of(fruitStat).sum();
        //result
        return "\n******* Kondisi Pohon Melon*******" +
                "\nJumlah daun : " + numofLeaves +
                "\nTinggi batang pokok : " + lenght +
                "\nJumlah Buah : " + sums+
                "\n  - Buah Muda : " +  fruitStat[0] +
                "\n  - Buah Masak : " +  fruitStat[1] +
                "\n  - Buah Busuk : " +  fruitStat[2] +
                "\nCO2 yang diserap : " + hasilCO2 +
                "\nO2 yang dihasilkan : " + hasilO2;
    }

    
}