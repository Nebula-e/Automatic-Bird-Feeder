
public class Brightness {
	
	private int brightness;
	
	public Brightness() {
		brightness = 30;
	}
	
	public boolean raiseBrightness(boolean doorsOpen) {
		if(this.brightness == 95) {
			System.out.println("Brightness has reached a maximum");
		}
		else{
			this.brightness += 5;
			System.out.println("Brightness level increased to " + brightness + "%");
			if (this.brightness >= 40 && !doorsOpen) {
                doorsOpen = true;
                System.out.println("Feeding doors are now open");
            }
		}
		return doorsOpen;
	}
	public boolean lowerBrightness(boolean doorsOpen) {
		if(this.brightness == 5) {
			System.out.println("Brightness has reached a minimum");
		}
		else{
            brightness -= 5;
            System.out.println("Brightness level decreased to " + brightness + "%");
            if (brightness <= 25 && doorsOpen) {
                doorsOpen = false;
                System.out.println("Feeding doors are now closed");
            }
		}
		return doorsOpen;
	}

}
