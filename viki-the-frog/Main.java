import java.util.*;

class Main{

	public static void main(String[] args){
		System.out.println("How far Viki needs to jump?");
		Scanner scanner = new Scanner(System.in);
		int distance = scanner.nextInt();
		Viki viki = new Viki();
		viki.setDistance(distance);
		System.out.println("Viki takes "+viki.calculateTime()+" seconds to jump");
	}
}