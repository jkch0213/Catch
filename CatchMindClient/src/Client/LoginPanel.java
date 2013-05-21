package Client;


import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.*;

public class LoginPanel extends JPanel {
	SignUp signUp;
	ButtonListener BL;
	
	private int WIDTH = 380;
	private int HEIGHT = 180;
	
	
	JLabel IDLabel;
	JLabel PasswordLabel;
	JLabel ForgotID;
	JLabel ForgotPS;
	TextField IDText;
	TextField PasswordText;
	JButton Login;
	JButton SignUp;
	JButton exit;
	
	public LoginPanel(){
		this.setBorder(new TitledBorder(new EtchedBorder(),"Login"));
		this.setSize(new Dimension(WIDTH,HEIGHT));
		this.setLayout(null);
		
		signUp = new SignUp();

		IDLabel = new JLabel("ID",10);
		PasswordLabel = new JLabel("Password",10);
		IDText = new TextField(20);
		PasswordText = new TextField(20);
		Login = new JButton("Login");
		ForgotID = new JLabel("Forgot ID");
		ForgotPS = new JLabel("ForgotPassword");
		SignUp = new JButton("SignUp");
		exit = new JButton("Exit");	
		
		IDLabel.setBounds(50, 45, 70, 30);
		IDText.setBounds(140, 50, 100, 20);
		PasswordLabel.setBounds(50, 75, 70, 30);
		PasswordText.setBounds(140, 80, 100, 20);
		Login.setBounds(250, 80, 80, 20);
		ForgotID.setBounds( 50, 115, 100, 30);
		ForgotPS.setBounds(140, 115, 100, 30);
		SignUp.setBounds(250, 120, 80, 20);
		exit.setBounds(250,150,80,20);
		
		this.add(IDLabel);
		this.add(PasswordLabel);
		this.add(ForgotID);
		this.add(ForgotPS);
		this.add(IDText);
		this.add(PasswordText);
		this.add(Login);
		this.add(SignUp);
		this.add(exit);
		SignUp.setVisible(true);
		
		BL = new ButtonListener();
		//ActionListener 생성
		SignUp.addActionListener(BL);	
		Login.addActionListener(BL);
		exit.addActionListener(BL);
	}
	
	
	
	public class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Component event = (Component)e.getSource();
			
			if(event == SignUp){
				signUp.setVisible(true);
			}else if(event == Login){
				String ID = IDText.getText().trim();
				String PW = PasswordText.getText().trim();
				if(ID.length() == 0 || ID == null ){
					JOptionPane.showMessageDialog(Login, "아이디를 입력하세요",
							"ID Error", JOptionPane.ERROR_MESSAGE);
				}else if(PW.length() == 0 || PW == null){
					JOptionPane.showMessageDialog(Login, "비밀번호를 입력하세요",
							"Password Error", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					
					try {
						CatchmindDriver.getDos().writeUTF("[login] "+ID);
//						CatchmindDriver.getDos().writeUTF("[loginId] "+ID);
//						CatchmindDriver.getDos().writeUTF("[loginPw]"+ PW);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				// DB로 ID,Password 확인하는 작업
				// DB가 완성될때까지 임시로 아무값만 넣으면 로그인
			
			}
			
			if(event == exit){
				
					try {
						CatchmindDriver.exit();		// 서버와 접속을 해지함 : 메인함수의 socket, dis, dos를 close
					} catch (IOException ea) {
						ea.printStackTrace();
					}
					CatchmindDriver.getFrame().setVisible(false);			// 종료 버튼을 누르면 프레임을 닫음
//					SoundEffect.BGM.stop();			// 배경음악을 끔
				
			}
		}
	}

}
