package Client;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Graphics2D;
/**
 * 
 * @author Administrator client
 */
public class Client extends Canvas implements MouseMotionListener, ActionListener {

	private int x = 0;
	private int y = 0;

	Color pp;				//지우개나 초기화시 색깔 보관
	Color t = Color.black;	//색깔 저장 초기에는 검은색
	
	String msg;
	
	
	
	public Client() {
		// TODO Auto-generated constructor stub
		super();
		addMouseMotionListener(this);
		setBackground(Color.WHITE);
		
	}
	
	public void setColor(String c){
		if(c == "Black"){
			this.getGraphics().setColor(Color.black);
			t = Color.black;
		}
		else if(c == "Blue"){
			this.getGraphics().setColor(Color.blue);
			t = Color.blue;
		}
		else if(c == "Green"){
			this.getGraphics().setColor(Color.green);
			t = Color.green;
		}
		else if(c == "Yellow"){
			this.getGraphics().setColor(Color.yellow);
			t = Color.yellow;
		}
		else if(c == "Red"){
			this.getGraphics().setColor(Color.red);
			t = Color.red;
		}
		else if(c == "Clear"){
			pp = this.getGraphics().getColor();
			this.getGraphics().setColor(Color.white);
			this.getGraphics().clearRect(0, 0, 460, 350);
			this.getGraphics().setColor(pp);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		Graphics gs = this.getGraphics();
		if(e.getModifiers() == InputEvent.BUTTON1_MASK){
			if(t == Color.black){
				gs.setColor(t);
				gs.drawLine(x, y, e.getX(), e.getY());
//				this.getGraphics().drawLine(x, y, e.getX(), e.getY());
			} else if(t == Color.blue){
				gs.setColor(t);
				gs.drawLine(x, y, e.getX(), e.getY());
			} else if(t == Color.green){
				gs.setColor(t);
				gs.drawLine(x, y, e.getX(), e.getY());
			} else if(t == Color.yellow){
				gs.setColor(t);
				gs.drawLine(x, y, e.getX(), e.getY());
			} else if(t == Color.red){
				gs.setColor(t);
				gs.drawLine(x, y, e.getX(), e.getY());
			}
			
			x = e.getX();
			y = e.getY();
			
			msg = "DRAW:" + x + "_" + y;
			try {
				CatchmindDriver.getDos().writeUTF(msg);
				CatchmindDriver.getDos().flush();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
			
		}
		else if(e.getModifiers() == InputEvent.BUTTON3_MASK){
			pp = this.getGraphics().getColor();
		
			this.getGraphics().clearRect(e.getX(), e.getY(), 30, 30);
			
			x = e.getX();
			y = e.getY();
			
			this.getGraphics().setColor(pp);
			
			msg = "ERASER:" + x + "_" + y;
			try {
				CatchmindDriver.getDos().writeUTF(msg);
				CatchmindDriver.getDos().flush();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		x = e.getX();
		y = e.getY();
		msg = "MOVE:" + x + "_" + y;
	
		try {
			CatchmindDriver.getDos().writeUTF(msg);
			CatchmindDriver.getDos().flush();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JRadioButton button = (JRadioButton)e.getSource();
		String source = button.getActionCommand();
	
		if(source.equals("Red")){
			setColor("Red");
			try {
				CatchmindDriver.getDos().writeUTF("Red:");
				CatchmindDriver.getDos().flush();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}else if(source.equals("Black")){
			setColor("Black");
			try {
				CatchmindDriver.getDos().writeUTF("Black:");
				CatchmindDriver.getDos().flush();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}else if(source.equals("Green")){
			setColor("Green");
			try {
				CatchmindDriver.getDos().writeUTF("Green:");
				CatchmindDriver.getDos().flush();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}else if(source.equals("Yellow")){
			setColor("Yellow");
			try {
				CatchmindDriver.getDos().writeUTF("Yellow:");
				CatchmindDriver.getDos().flush();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}else if(source.equals("Blue")){
			setColor("Blue");
			try {
				CatchmindDriver.getDos().writeUTF("Blue:");
				CatchmindDriver.getDos().flush();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}else if(source.equals("Clear")){
			setColor("Clear");
			try {
				CatchmindDriver.getDos().writeUTF("Clear:");
				CatchmindDriver.getDos().flush();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}

	
}
