package Server;

import java.util.Vector;

public class Room 
{
	protected GameController gamecontroller;

	private String number;		// 방번호
	private String title;		// 방제목
	private String max;			// 방에 들어올 수 있는 총 인원 수
	
	private String condition;		// 방에 입장 한 인원 / 총 인원 형태의 String

	protected Vector<Client> playerlist;		// 방에 입장한 client들

	private int count;			// 턴을 위해 계속 count

	public Room(Client player, String number, String title, String max)
	{
		
		playerlist = new Vector<Client>();
		gamecontroller = new GameController(number);
		
		playerlist.add(player);		//방에 입장한 client를 list에 추가한다.

		this.number = number;
		this.title = title;
		this.max = max;
		
		this.condition = playerlist.size() + " / " + max;

		count = 0;
	}

	public String getNumber()
	{
		return number;
	}

	public String getString() 
	{
		return number + "\t" + title + "\t" + condition ;
	}
	public void updateCondition()
	{
		if (playerlist.size() == Integer.parseInt(max)) this.condition = "Full";	// 방에 입장한 수가 max값과 같으면 Full로 나타냄
		else if (playerlist.size() == 0) this.condition = "null";		// 방에서 모두 퇴장하면 null로 표시
		else this.condition = playerlist.size() + " / " + max;		// max값을 넘지 않으면 입장한 수 / max로 나타냄
	}
	public String getCondition()
	{
		return condition;
	}

	
	
	public String getPlayerIDlist()		// 방의 정보와 모든 playerlist의 상태를 반환
	{
		String result = number +"  방 : " + title + "\n";
		
		result += "제한 인원 : " + max+"  ("+playerlist.size()+"명 입장)"+ "\n\n";

		for(int i=0;i<playerlist.size();i++)
		{
//			result += playerlist.get(i).getID()+ " / " +playerlist.get(i).team +"팀 / "+playerlist.get(i).state+"\n";
		}
		return result;
	}
	
	
	public String getRoomNum()
	{
		String result =number ;
		return result;
	}
	public String getRoomTitle()
	{
		String result =title ;
		
		
		return result;
	}
	public String getRoomPeopleCount()
	{
		String result = "";
		result+=max+"  /"+playerlist.size()+"명 입장";
		return result;
	}

    public String getRoomIdList()
    {
    	String result ="";
    	for(int i=0;i<playerlist.size();i++)
		{
			result += playerlist.get(i).getGameId()+ "/";
		}
    	return result;
    }


	public String nextTurn()		// 다음 턴의 player ID를 반환
	{
		int turn = count % playerlist.size();		// 턴은 count를 playerlist수만큼 나눈 나머지로 계산
		count++;

		return playerlist.get(turn).getGameId();		// 해당 턴의 ID를 반환
	}

	
	public String checkStart() {
		// TODO Auto-generated method stub
		for(int i=0;i<playerlist.size();i++)
		{
			if(playerlist.get(i).state.equals("")) return "wait";	//준비중이지 않은 player가 있을 경우
		}
		return "allReady";
	}
}
