/**
 * Class PohonMangga
 *
 * @author Bryan Oliver
 * @version 24.4.2021
 */
import java.util.Random;
import java.util.stream.IntStream;
import java.util.ArrayList;

public class PohonMangga extends Tumbuhan implements Penghijauan, Komoditas{

    private int gasMinimum = 1;
    private int gasMaximum = 4;
    private int price;
    private int sums;
    private int[] fruitStat = new int[3];
    private Random r = new Random();

    private ArrayList<BuahMangga> fruitList;

    public int hasilO2 = 0;
    public int hasilCO2 = 0;
    public int numofLeaves;
    
    // create collection var

    public PohonMangga()
    {
        fruitList = new ArrayList<BuahMangga>();
        numofLeaves = 3;
        price = 0;
    }
    //Override function for fotosintesis
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

    public ArrayList<BuahMangga> berbuah(int age)
    {
        if (age > 15) {
            if (age % 2 == 0) {
                fruitList.add(new BuahMangga(age));
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

    public String dailyRoutine(int age)
    {
    	//Mengosongkan isi statusBuah
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
        berbuah(age);

        //Fungsi for untuk pengukuran kematangan buah
       for(BuahMangga buah : fruitList){
            if(buah.ripelevel.matches("Belum matang"))
                fruitStat[0] += 1;
            if(buah.ripelevel.matches("Matang"))
                fruitStat[1] += 1;
            if(buah.ripelevel.matches("Busuk"))
                fruitStat[2] += 1;
        };

        int sums = IntStream.of(fruitStat).sum();
        //print status
        return "\n******* Kondisi Pohon Mangga*******" +
        "\nJumlah daun : " + numofLeaves +
        "\nTinggi batang pokok : " + lenght +
        "\nJumlah Buah : " + sums+
        "\n  - Buah Muda : " +  fruitStat[0] +
        "\n  - Buah Masak : " +  fruitStat[1] +
        "\n  - Buah Busuk : " +  fruitStat[2] +
        "\nCO2 yang diserap : " + hasilCO2 +
        "\nO2 yang dihasilkan : " + hasilO2;
//        "\nJumlah Buah : " + fruitList.size() +
        
    }
}
