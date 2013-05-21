package Server;

import java.util.Timer;
import java.util.TimerTask;

public class GameController{

	
	static int minute=0;
	static int second=0;
	static String state = "gameOff";
	static String roomnumber;
	Timer timer;
	
	
	public GameController(String roomnumber) {
		// TODO Auto-generated constructor stub
		Timer timer = new Timer();
		WorkTask run;
		timer.schedule(run = new WorkTask(), 0, 1000);
		
		
	}
	

	
	public static class WorkTask extends TimerTask {

		
		int turnNum=1;
		int i = 0;

		@Override
		public void run() {
		    String msg;	
		    
			if (state == "gameOn") {
				timeprint();
				i = i + 1;
				second=i;
			//	System.out.println(i);
				if (second == 60) {
					i = 0;
					second=i;
					minute++;
					if(minute==1){ 
						minute =0;
					
					turnNum=turnNum+1;
					if(turnNum==2)
					{
						state="gameOff";
						
					}
					
					}
				}

			}
		}
		public void timeprint(){
//			System.out.println(minute+"분"+second+"초\n");
		}
		
		public static String nextTurn()
		{
			return "next";
			
		}
		public void changeState()
		{
			state="gameOn";
		}
		
		public void Turnover() //아무도 정답을못마췃을때 다음 턴으로
		{
			
		}
		
		public void FinishTurn() //누군가 정답을 맞췃을때 다음턴으로
		{
			
		}

	}

}





