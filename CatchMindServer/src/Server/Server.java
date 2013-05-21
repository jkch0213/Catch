package Server;
import java.net.*;

public class Server 
{
	public static ClientController clientcontroller;
	public static RoomController roomcontroller;
	protected ItemController itemcontroller;
	
	
	public static int inPort=5555;
	public static ServerSocket server = null;
	private int count;
	
	public static void main(String[] args) { 

		Server svr = new Server();  

	}

	public Server () {  
		try {
			server = new ServerSocket (inPort);
			
			clientcontroller = new ClientController();
			roomcontroller = new RoomController();
			itemcontroller = new ItemController();
		

			System.out.println("Server start..");

			// ServerSocket listening
			while(true) {	
				Socket socket = server.accept();

				count++;
				System.out.println(count + " 번째  접속자 : " + socket.getInetAddress());

				Client client = new Client(this,socket);		//새로운 client가 접속하면 모든 clientlist에 추가
				clientcontroller.getClientlist().addElement(client);
				
				System.out.println("현재 접속자 수: "+clientcontroller.getClientlist().size());

				clientcontroller.updateIDlist();	//새로운 client가 접속하면 모든 client들의 접속자 ID list를 업데이트
			}
		} catch (Exception e) { e.printStackTrace(); }
	}
	
	public RoomController getRoomController()
	{
		return roomcontroller;
	}
	public ClientController getClientController()
	{
		return clientcontroller;
	}
	public int getCount()
	{
		return count;
	}

} // class

