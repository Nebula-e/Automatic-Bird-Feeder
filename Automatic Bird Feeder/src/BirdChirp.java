import java.util.Scanner;

public class BirdChirp {
	
	Scanner scanner = new Scanner(System.in);
	
	public BirdChirp() {}
	
	public boolean chirpHeard(boolean doorsOpen) {
        System.out.println("Enter 'w' for wanted bird chirp, 'u' for unwanted bird chirp:");
        char birdChirp = scanner.next().charAt(0);
        if (birdChirp == 'w') {
            if (doorsOpen) {
                System.out.println("Feeding doors are already open");
            } else {
                doorsOpen = true;
                System.out.println("Feeding doors are now open");
            }
        } else if (birdChirp == 'u') {
            doorsOpen = false;
            System.out.println("Feeding doors are now closed");
        } else {
            System.out.println("Invalid input");
        }
        return doorsOpen;
	}
}