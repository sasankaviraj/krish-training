public class Viki{
	private int distance;

	public void setDistance(int  distance){
		this.distance = distance;
	}

	public int calculateTime(){
		int seconds = 0;
		while(distance > 0){
			if(distance >= 5){
				distance -= 5;
				if(distance != 0){
					seconds += 1;
					if(distance >=3){
						distance -= 3;
						if(distance != 0){
							seconds += 2;
							distance -= 1;
								if(distance!=0){
									seconds += 3;
								}
						}
					}
				}
			}else{
				distance = 0;
			}
		}
		return seconds;
	}

}