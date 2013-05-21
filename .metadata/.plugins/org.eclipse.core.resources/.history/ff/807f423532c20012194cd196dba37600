package Client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;



public class RoomMakeFrame extends JFrame implements  ActionListener
{

	
	private int WIDTH = 400;
	private int HEIGHT =300;
	
	
	RoomPanel roompanel;		// 방 목록을 보고 입장하거나 방을 만들 수 있는 패널
	ChatPanel chatpanel;		// 접속한 client와 채팅을 할 수 있는 패널
	IDlistPanel idlistpanel;		// 접속중인 ID를 알려주는 패널
	InformationPanel informationpanel;		// 정보 및 상태를 알려 주는 패널
	GamePanel gamepanel;		// 게임을 진행하는 패널
	String state;//창여러개 뜨는걸 방지하기위해....나중에 자세히 코딩

	JComboBox selectNum;
	DefaultComboBoxModel nummodel;
	JLabel[] InputLabel;
	JTextField Titletext;
	
	JScrollPane roomscroll;
	String num;
	String msg;
	
	JButton exit;
	JButton enter;
	
	
	
	 public RoomMakeFrame(){	
		 this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
		 String major[]={"3","4",
					"5","6"};

		this.setTitle("방만들기");
//		this.setSize(new Dimension(WIDTH,HEIGHT));
		this.setSize(WIDTH,HEIGHT);
		
		
		exit = new JButton("취소");	
		enter = new JButton("확인");	
		
	
		
		
		
		exit.addActionListener(this);
		enter.addActionListener(this);
		
		
	

		this.setLayout(null);
		

		nummodel = new DefaultComboBoxModel();
		selectNum = new JComboBox(nummodel);		//인원수 콤보
		nummodel.addElement("3");
		nummodel.addElement("4");
		nummodel.addElement("5");
		nummodel.addElement("6");
		
		num = (String)nummodel.getElementAt(0);
		selectNum.addActionListener(this);	
//		this.add( s2 );
		InputLabel = new JLabel[2];
		InputLabel[0] = new JLabel("방 이 름  : ");
		InputLabel[1] = new JLabel("인     원  : ");
		exit.setBounds(200,125,95,30);
		enter.setBounds(100,125,95,30);

		Titletext = new JTextField(20);
		
		InputLabel[0].setBounds(50, 50, 80, 20);
		Titletext.setBounds(200, 50, 120, 20);
		InputLabel[1].setBounds(50, 80, 80, 20);
		selectNum.setBounds(200, 80, 120, 20);
		
		
		
		
		this.add(InputLabel[0]);
		this.add(Titletext);
		this.add(InputLabel[1]);
		this.add(selectNum);
		this.add(exit);
		this.add(enter);
		
		

		
		
	}

//		SoundEffect.init();



	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource() == selectNum)
		{  
			num = (String)nummodel.getElementAt(selectNum.getSelectedIndex());	//인원 수 콤보박스 모델의 String을 num 저장
			System.out.println("방인원:"+num);
		}
		if(event.getSource() == exit)
		{
			
			this.setVisible(false);
					// 배경음악을 끔
		}
		else if(event.getSource() == enter){
			if(Titletext.getText().equals(""))
			{
				JOptionPane.showMessageDialog(enter, "방제목을 입력하세요",
						"ID Error", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				
				msg= "[MakeRoom] "+ Titletext.getText() + "\t" +num ;
				System.out.println("방인원:"+num);
				try {
					CatchmindDriver.getDos().writeUTF(msg);
					setVisible(false);
				} catch (IOException e) {
					e.printStackTrace();
				}
				Titletext.setText("");
							
			}
			
			
			
		
			
		}
		
		
		
		
		

	}

}

