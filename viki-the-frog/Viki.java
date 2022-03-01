import java.util.Scanner;

class Viki{

	public static void main(String[] args){
		System.out.println("How far Viki needs to jump?");
		Scanner scanner = new Scanner(System.in);
		int distance = scanner.nextInt();
		System.out.println("Viki takes "+calculateTime(distance)+" seconds to jump");
	}

	public static int calculateTime(int distance){
		int seconds = 0;
		while(distance > 0){
			if(distance >= 5){
				distance -= 5;
				if(distance != 0){
					seconds += 1;
				}
				if(distance < 3){
					return seconds;
				}
			}
			if(distance >= 3){
				distance -= 3;
				if(distance != 0){
					seconds += 2;
				}	
			}
			if(distance >= 1){
				distance -= 1;
				if(distance != 0){
					seconds += 3;
				}
			}
			
		}
		return seconds;
	}
}