import java.util.*;

class Viki{

	public static void main(String[] args){
		System.out.println("How far Viki needs to jump?");
		Scanner scanner = new Scanner(System.in);
		int distance = scanner.nextInt();
		int seconds = 0; 
		while(distance > 0){
			if(distance >= 5){
				distance -= 5;
				if(distance != 0){
					seconds += 1;
					distance -= 3;
					if(distance != 0){
						seconds += 2;
						distance -= 1;
						if(distance!=0){
							seconds += 3;
						}
					}
				}
			}else{
				distance = 0;
			}
		}
		System.out.println("Viki takes "+seconds+" seconds to jump");
	}
}
