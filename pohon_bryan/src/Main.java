/**
 * Class Main
 *
 * @author Bryan Oliver
 * @version 24.4.2021
 */
public class Main {

    public static void main(String[] args) {
    	
		//Specify number of days while using java Main
		  if (args.length != 1) { System.out.println("Please Import Days");
		  System.exit(1); }
		 
        int days = Integer.parseInt(args[0]);
        //object Declaration
        PohonMangga newmangotree = new PohonMangga();
        PohonMelon newmelontree = new PohonMelon();
        //Function to  add days until the specified parameters on java Main
        for (int age=0; age < days; age++) {
            System.out.println("Hari ke-" + (age + 1));
            System.out.println(newmangotree.dailyRoutine(age));
            System.out.println(newmelontree.dailyRoutine(age));
            System.out.println("\n");
        }
    }
}
