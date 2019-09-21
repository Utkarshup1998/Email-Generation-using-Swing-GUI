//package EmailApplication;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UI extends JFrame implements ActionListener
{
	JTextField field1,field2;
	JLabel fname,lname,department1;
	JButton btn;
	JLabel start,submit;
	JComboBox cb;
	public UI()
		{
		Font f=new Font("SansSerif",Font.BOLD,30);
		Font f1=new Font("SansSerif",Font.BOLD,15);
		
		
			 super.setTitle("Email Generation System For IMSEC");
			 super.setIconImage(new ImageIcon("img/imsec.jpg").getImage());
			super.setBounds(100, 20, 550, 550);
			////////////////////////////////////////////////
			int x=90;
			int h=25;
			start = new JLabel("Welcome to IMSEC Ghaziabad");
			start.setBounds(50, 10, 450, h);
			super.add(start);
			start.setFont(f);
			
			
			fname=new JLabel("Enter Your First Name");
			fname.setBounds(x,70, 300, h);
			super.add(fname);
			field1=new JTextField("");
			field1.setBounds(x,100, 300, h+5);
			super.add(field1);
			fname.setFont(f1);
			
			
			lname=new JLabel("Enter Your Last Name");
			lname.setBounds(x,150, 300, h);
			super.add(lname);
			lname.setFont(f1);
			
			
			field2=new JTextField("");
			field2.setBounds(x,180, 300, h+5);
			super.add(field2);
			
			department1=new JLabel("Select Your Depeartment");
			department1.setBounds(x,220, 300, h);
			super.add(department1);
			department1.setFont(f1);
			
			
			String[] department= {"cse","mechanical","civil","electronics","electrical","biotech","it"};
			cb=new JComboBox(department);
			cb.setBounds(x,250, 200, h+5);
			super.add(cb);
			
			
			submit=new JLabel("Hit the Submit button to generate your Official Gmail ID and Password ");
			submit.setBounds(x-10,290,500, h);
			super.add(submit);
		
			
			btn=new JButton(new ImageIcon("img/submit.png"));
			btn.setBounds(x,330, 150, h+20);
			super.add(btn);
			btn.addActionListener(this);
			
			
			
			
			
			
			
			
			
			
			//////////////////////////////////////////
			super.setResizable(false);
			super.setLayout(null);
			super.setVisible(true);
			super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
		}
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		//JOptionPane.showMessageDialog(this,cb.getSelectedItem());
		//generateEmail(field1.getText(),field2.getText(),cb.getSelectedItem().toString())
		JOptionPane.showMessageDialog(this,generateEmail(field1.getText(),field2.getText(),cb.getSelectedItem().toString()));
;		this.dispose();
	}
	
	
	
	
	
		 private String generateEmail(String fname, String lname,String dept) 
		 {
			 String email=fname+"."+lname+"@"+dept+"."+"imsec.ac.in";
			 //call methood which generate password
			 int length=8;
			 
			 return "Your generated email id--\n"+email+"\nPassword for your Email ID is ---\n"+setpassword(length);

		
		
	}
		 private String setpassword(int length) 
		 {
		 	String s_alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		 	String c_alpha=s_alpha.toLowerCase();
		 	String num="1234567890";
		 	String symbol="!@#$%^&*()=+><?\"|";
		 	String value=s_alpha+c_alpha+num+symbol;
		 	
		 	
		 	
		 	char[] pass=new char[length];
		 	for (int i = 0; i <length; i++) 
		 	{
		 		int random=(int) (Math.random() * value.length());
		 		pass[i]=value.charAt(random);
		 	}
		 		return new String(pass);
		 }
		

		public static void main(String[] args) 
		 {
			UI u=new UI();
			
			
		}
}
