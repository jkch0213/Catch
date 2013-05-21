package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RoomInformationFrame extends JFrame implements  ActionListener
{

	
	private int WIDTH = 400;
	private int HEIGHT =300;

	JLabel[] InputLabel;
	JTextField Titletext;
	JButton exit;
	JButton join;
	JButton roadInfo;
	
	
	
	 public RoomInformationFrame(){	
		 this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
	

		this.setTitle("방정보");
//		this.setSize(new Dimension(WIDTH,HEIGHT));
//		this.setSize(WIDTH,HEIGHT);
		
		this.setLayout(null);
		
		roadInfo = new JButton("방정보불러오기");
		roadInfo.setBounds(100, 200, 200, 30);
		roadInfo.addActionListener(this);
		this.add(roadInfo);
		exit = new JButton("취소");	
		join = new JButton("참여하기");
		
		
		

		
		
	}
	    
	 public void removeRoadButton()
	 {
		 this.remove(roadInfo);
	 }
	   
		
//		SoundEffect.init();

	 public void setFrame()
	 {
	       setVisible(true);
	      
	 }
	 
	 public void roadInfo()
	 {
		 InputLabel = new JLabel[7];
			InputLabel[0] = new JLabel("[방 이 름] ");
			InputLabel[1] = new JLabel("[방 제 한 인 원/접 속 인 원] ");
			InputLabel[2] = new JLabel("[방 참 가 자 ]");
			InputLabel[3] = new JLabel("-Introduce-");
			InputLabel[4] = new JLabel(CatchmindDriver.getFrame().getTitle());
			
			InputLabel[5] = new JLabel(CatchmindDriver.getFrame().getPeopleCount());
			InputLabel[6] = new JLabel(CatchmindDriver.getFrame().getIdList());
			
			
			
			
			
			exit.setBounds(200,400,95,30);
			join.setBounds(100,400,95,30);
			JTextArea content= new JTextArea(50,1);
//			Titletext = new JTextField(500);
			
			InputLabel[0].setBounds(50, 50, 150, 20);
			content.setBounds(100, 170, 50,50);
			InputLabel[1].setBounds(50, 210,300, 20);

			InputLabel[2].setBounds(50, 130, 150, 20);
			InputLabel[3].setBounds(50, 270, 150, 20);
			InputLabel[4].setBounds(50, 80, 150, 20);
			InputLabel[5].setBounds(50, 240, 300, 20);
			InputLabel[6].setBounds(50, 160, 300, 20);
			
			
			
			
			this.add(InputLabel[0]);
//			this.add(content);
			this.add(InputLabel[1]);
			this.add(exit);
			this.add(join);
			this.add(InputLabel[2]);
//			this.add(InputLabel[3]);
			this.add(InputLabel[4]);
			this.add(InputLabel[5]);
			this.add(InputLabel[6]);
		
			
			
			
			exit.addActionListener(this);
			join.addActionListener(this);
			
			
			
			this.setLayout(null);
			
			exit.setBounds(200,320,95,30);
			join.setBounds(100,320,95,30);

			
			this.add(exit);
			this.add(join);
			
	 }

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
	
		if(event.getSource() == exit)
		{
			
			this.setVisible(false);
					
		}
		else if(event.getSource() == join)
		{
		
		}
		else if(event.getSource( ) == roadInfo)
		{
			
			removeRoadButton();
			roadInfo();
			repaint();
		}
		
		
		

	}

}

