import java.util.InputMismatchException;
import java.util.Scanner;

public class AutomaticBirdFeeder {
    public static void main(String[] args) {
        boolean doorsOpen = false;
        Brightness brightness = new Brightness();
        BirdChirp chirp = new BirdChirp();
        int birdSeed = 12; // initial amount of bird seed in oz.
        int water = 12; // initial amount of water in oz.
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a number to perform an action:");
            System.out.println("1. Raise brightness by 5%");
            System.out.println("2. Lower brightness by 5%");
            System.out.println("3. Remotely Open or Close the door");
            System.out.println("4. Listen for bird chirps");
            System.out.println("5. Bird is feeding");
            
            try {
	            int choice = scanner.nextInt();
	
	            switch (choice) {
	                case 1:
	                    doorsOpen = brightness.raiseBrightness(doorsOpen);
	                    break;
	
	                case 2:
	                	doorsOpen = brightness.lowerBrightness(doorsOpen);
	                	if(!doorsOpen)
	                        birdSeed = 12; // replenish bird seed when doors are closed
	                        water = 12; // replenish water when doors are closed
	                    break;
	
	                case 3:
	                    System.out.println("Enter 'o' to open the doors, 'c' to close the doors:");
	                    char doorAction = scanner.next().charAt(0);
	                    if (doorAction == 'o') {
	                        doorsOpen = true;
	                        System.out.println("Feeding doors are now open");
	                    } else if (doorAction == 'c') {
	                        doorsOpen = false;
	                        System.out.println("Feeding doors are now closed");
	                        birdSeed = 12; // replenish bird seed when doors are closed
	                        water = 12; // replenish water when doors are closed
	                    } else {
	                        System.out.println("Invalid input");
	                    }
	                    break;
	
	                case 4:
	                    doorsOpen = chirp.chirpHeard(doorsOpen);
	                    if(!doorsOpen) {
	                    	birdSeed = 12;
	                    	water = 12;
	                    }
	                    break;
	
	                case 5:
	                    if (doorsOpen) {
	                        System.out.println("Birds are feeding!");
	                        System.out.println("Enter the amount of bird seed eaten (in oz.):");
	                        int seedEaten = scanner.nextInt();
	                        if (seedEaten > birdSeed) {
	                            System.out.println("Not enough bird seed available");
	                        } else {
	                            birdSeed -= seedEaten;
	                            System.out.println("Feeding successful");
	                        }
	
	                        System.out.println("Enter the amount of water drunk (in oz.):");
	                        int waterDrunk = scanner.nextInt();
	                        if (waterDrunk > water) {
	                            System.out.println("Not enough water available");
	                        } else {
	                            water -= waterDrunk;
	                            System.out.println("Drinking successful");
	                        }
	                    } else {
	                        System.out.println("Feeding doors are closed, birds cannot feed");
	                    }
	                    break;
	
	                default:
	                    System.out.println("Invalid input, please try again");
	                    break;
	            }
	        }
            catch (InputMismatchException e){
            	System.out.println("Invalid input, please try again");
            	scanner.nextLine();
            }
	    }
	}
}