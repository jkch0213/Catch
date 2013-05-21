package Client;


import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import javax.swing.border.*;

public class SignUp extends JFrame implements ActionListener{
	
	private int WIDTH = 380;
	private int HEIGHT = 400;
	
	JLabel NameLabel;
	JLabel IDLabel;
	JLabel PassLabel;
	JLabel RPassLabel;
	JLabel RegiNumLabel;
	TextField NameText;
	TextField IDText;
	TextField PassText;
	TextField RPassText;
	TextField RegiNumText;
	JButton IDCheck;
	JButton SignUp;
	JButton Close;
	
	public SignUp(){
		new TitledBorder(new EtchedBorder(),"Sign-Up");

		this.setSize(new Dimension(WIDTH,HEIGHT));

		this.setLayout(null);
		
		NameLabel = new JLabel("이름",10);
		IDLabel = new JLabel("아이디",10);
		PassLabel = new JLabel("비밀번호",10);
		RPassLabel = new JLabel("비밀번호 확인",10);
		RegiNumLabel = new JLabel("주민등록번호",10);
		NameText = new TextField(20);
		IDText = new TextField(20);
		PassText = new TextField(20);
		RPassText = new TextField(20);
		RegiNumText = new TextField(20);
		IDCheck = new JButton("중복확인");
		SignUp = new JButton("회원가입");
		Close = new JButton("닫기");
		
		NameLabel.setBounds(50, 45, 90, 30);
		IDLabel.setBounds(50, 85, 90, 30);
		PassLabel.setBounds(50, 125, 90, 30);
		RPassLabel.setBounds(50, 165, 90, 30);
		RegiNumLabel.setBounds(50, 205, 90, 30);
		NameText.setBounds(150, 50, 90, 20);
		IDText.setBounds(150, 90, 90, 20);
		PassText.setBounds(150, 130, 90, 20);
		RPassText.setBounds(150, 170, 90, 20);
		RegiNumText.setBounds(150, 210, 90, 20);
		IDCheck.setBounds(250, 90, 90, 20);
		SignUp.setBounds(80, 300, 90, 30);
		Close.setBounds(190, 300, 90, 30);
		
		this.add(NameLabel);
		this.add(IDLabel);
		this.add(PassLabel);
		this.add(RPassLabel);
		this.add(RegiNumLabel);
		this.add(NameText);
		this.add(IDText);
		this.add(PassText);
		this.add(RPassText);
		this.add(RegiNumText);
		this.add(IDCheck);
		this.add(SignUp);
		this.add(Close);
		
		Close.addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent event)
	{	
		if(event.getSource() == Close)
		{
			this.setVisible(false);		
		}

	}
}
