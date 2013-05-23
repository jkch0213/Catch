package Server;

import java.util.Timer;
import java.util.TimerTask;

public class GameController{

	
	static int minute=0;
	static int second=0;
	static String state = "gameOff";
	static String roomnumber;
	static int endturntime=6; //턴수제한
	Timer timer;
	WorkTask run;
	
	
	public GameController(String roomnumber) {
		// TODO Auto-generated constructor stub
		Timer timer = new Timer();
		
		timer.schedule(run = new WorkTask(), 0, 1000);
		
		
	}
	

	
	public static class WorkTask extends TimerTask {

		
		int turnNum=1;
		int i = 0;

		@Override
		public void run() {
			
		    String msg;	
		    if(turnNum<=endturntime)
		    {
		    	
			if (state == "gameOn") 
			{
				
				i = i + 1;
				if(second!=60)
				{
					second=i;
				}
//				timeprint();
//				System.out.println(i);
				if (second == 60) {
					i = 0;
					second=i;
					minute++;
					if(minute==1){ 
						minute =0;
					
					turnNum=turnNum+1;
					if(turnNum==endturntime)
					{
						state="gameOff";
						
					}
					
					}
				}

			}
		    }
		    else
		    {
		    	state="gameOff";
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
			second=0;
			i=0;
			System.out.println("서버턴"+turnNum+"종료");
			turnNum++;
			if(turnNum>endturntime)
			{
				state="gameOff";
			}
			System.out.println("서버턴"+turnNum+"시작");
			
		}
		
		public String ReturnState()
		{
			return state;
		}

	}

}





