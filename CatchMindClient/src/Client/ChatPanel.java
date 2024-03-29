package Client;
import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class ChatPanel extends JPanel implements ActionListener
{

//	private int WIDTH = 750;
//	private int HEIGHT = 250;
	
	public TextArea chatarea;
	private TextField waitinputmsg;
	private TextField gameinputmsg;
	
	
	public ChatPanel()
	{
//		this.setSize(new Dimension(WIDTH,HEIGHT));
		this.setBorder(new TitledBorder(new EtchedBorder(),"채팅"));

		chatarea = new TextArea(); 			// 메시지를 보여주는 영역
		chatarea.setEditable(false);

		waitinputmsg = new TextField();         // 보낼 메시지를 입력 하는 field
		waitinputmsg.addActionListener(this);
//		
		gameinputmsg = new TextField();

		this.setLayout(null);

		chatarea.setBounds(10, 20, 480, 200);
		waitinputmsg.setBounds(10, 220, 480, 20);

		this.add(chatarea);
		this.add(waitinputmsg);	
	}
	
	public void GameRoomChatPanel()
	{
		this.remove(chatarea);
//		this.remove(waitinputmsg);	
		gameinputmsg.addActionListener(this);
		chatarea.setBounds(10, 15, 480, 160);
		waitinputmsg.setBounds(10, 175, 480, 20);
		gameinputmsg.setBounds(10, 175, 480, 20);
		this.add(chatarea);
		this.add(waitinputmsg);
//		this.add(gameinputmsg);	
		
	}
	
	public void WaitRoomChatPanel()
	{
		this.remove(chatarea);
		this.remove(gameinputmsg);
		chatarea.setBounds(10, 20, 480, 200);
		waitinputmsg.setBounds(10, 220, 480, 20);

		this.add(chatarea);
		this.add(waitinputmsg);	
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		String msg;

		if(event.getSource()==waitinputmsg)
		{
			msg=waitinputmsg.getText();
			try {
				CatchmindDriver.getDos().writeUTF("[Chat] "+msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
			waitinputmsg.setText("");
		}
//		else if(event.getSource()==gameinputmsg)
//		{
//			msg=gameinputmsg.getText();
//			try {
//				CatchmindDriver.getDos().writeUTF("[GameChat] "+msg);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			gameinputmsg.setText("");
//			
//		}
	}

}
