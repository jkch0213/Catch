package Client;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;









public class GamePanel extends JPanel implements ActionListener
{
	static int minute=0;
	static int second=0;
	static String state = "gameOff";
	static String roomnumber;
	Timer timer;
	static int endturntime=6; //턴수제한
	WorkTask run;
	
	public static JLabel statusBar=new JLabel();
	public static TextField word;
	
	
	JButton ready;		// 게임 준비
	JButton cancel;		// 준비 취소
	JButton start;
	
	
	
	TextArea idlistarea;		// 방에 있는 IDlist
	public GamePanel()
	{
		this.setBorder(new TitledBorder(new EtchedBorder(),"게임"));
		Timer timer = new Timer();
		
		timer.schedule(run = new WorkTask(), 0, 1000); 
		this.setLayout(null);
		
		ready=new JButton("Ready");
		cancel=new JButton("Cancel");
		start=new JButton("Start");
		word =new TextField();
		
		ready.setBounds(395, 410, 100, 30);
		cancel.setBounds(395, 410, 100, 30);
		start.setBounds(300, 410, 90, 30);
		statusBar.setBounds(20,410,80,30);
		word.setBounds(100, 10, 300, 30);
		
		
		statusBar.setText( "[0" + minute+"분:"+
                " " + second + "초]" );
		
		ready.addActionListener(this);
		cancel.addActionListener(this);
		start.addActionListener(this);
		this.add(ready);
		this.add(statusBar);
		this.add(word);
		
	
	}
	public void SetStartButton(){
		this.add(start);
		repaint();
	}
	public void RemoveStartButton(){
		this.remove(start);
		repaint();
	}
	public void EndGame()
	{
		this.add(ready);
		minute=0;
		second=0;
		state="gameOff";
		
		try {
			CatchmindDriver.getDos().writeUTF("[EndAllTurn]");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void startGame()
	{
		this.remove(start);
		this.remove(ready);
		this.remove(cancel);
		state="gameOn";
		try {
			CatchmindDriver.getDos().writeUTF("[GameGetWord]");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		repaint();
	}
	
	public void SetWord(String msg)
	{
		word.setText(msg);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Component event = (Component)e.getSource();
		
		if(event==ready)
		{
			this.remove(ready);
			this.add(cancel);
			System.out.println("눌림");
			try {
				CatchmindDriver.getDos().writeUTF("[GameSetReady]");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			repaint();
		}
		if(event==cancel)
		{
			this.remove(cancel);
			this.add(ready);
			try {
				CatchmindDriver.getDos().writeUTF("[GameSetCancel]");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			repaint();
		}
		if(event==start)
		{
			try {
				CatchmindDriver.getDos().writeUTF("[GameStart]");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	public void Init()
	{

	}

	
public static class WorkTask extends TimerTask {

		
		int turnNum=0;
		int i = 0;

		@Override
		public void run() {
		    String msg;	
			if (state == "gameOn") {
			
				 GamePanel.statusBar.setText( "[0" + minute+"분:"+
		                 " " + second + "초]" );
//				timeprint();
				i = i + 1;
				if(second!=60)
				{
					second=i;
				}
			//	System.out.println(i);
				if (second == 60) {
					i = 0;
					second=i;
					minute++;
					if(minute==1){ 
						minute =0;
						
//					    Server.clientcontroller.sendToRoom(Integer.parseInt(roomnumber), msg);
					turnNum=turnNum+1;
					if(turnNum>endturntime)
					{
						state="gameOff";
						msg="[GameFnishAllTurn]";
//						try {
//							CatchmindDriver.getDos().writeUTF(msg);
//						} catch (IOException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
					}
					else
					{
						msg="[GameNextTurn]";
//						try {
//							CatchmindDriver.getDos().writeUTF(msg);
//						} catch (IOException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
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
			second=0;
			i=0;
			System.out.println("쿨라이언트턴"+turnNum+"종료");
			
			word.setText("");
			
			turnNum++;
			if(turnNum>endturntime)
			{
				state="gameOff";
				turnNum=0;
				GamePanel.statusBar.setText( "[0" + minute+"분:"+
		                 " " + second + "초]" );				
			}
			System.out.println("클라이언트턴"+turnNum+"시작");
			
		}

		
		
	}
}
