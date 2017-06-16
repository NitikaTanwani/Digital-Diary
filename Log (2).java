import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Log extends JFrame {

public static void main(String[] args) throws IOException {
       Log frameTabel = new Log();
}

        JButton blogin = new JButton("Login");
	JButton blo=new JButton("new user");
        JPanel panel = new JPanel();
       //Log user=new Log("username",Label.LEFT);
       JTextField txuser = new JTextField(15);
       JPasswordField pass = new JPasswordField(15);

Log(){
         super("Daily diary");
         setSize(400,300);
         setLocation(500,280);
         panel.setLayout (null); 


  txuser.setBounds(70,30,150,20);
  pass.setBounds(70,65,150,20);
  blogin.setBounds(110,100,80,20);
  blo.setBounds(120,130,150,20);

   panel.add(blogin);
   panel.add(txuser);
   panel.add(pass);
   panel.add(blo);

  getContentPane().add(panel);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setVisible(true);
  actionlogin();
  actionnewuser();
}

public void actionlogin() {
blogin.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae)  {
String puname = txuser.getText();
String ppaswd = pass.getText();
try
{
FileReader fr=new FileReader("users.txt");
BufferedReader br=new BufferedReader(fr);
String s,s1,s2,s3;
boolean found=false;
while((s=br.readLine())!=null){
s1=s.substring(0,10);
s2=s.substring(10,14);
System.out.println("String   "+s+" s1 "+s1+" s2 "+s2);
s3=s.substring(14);
if(puname.equals(s1.trim()) && ppaswd.equals(s2.trim())) 
{
found=true;
JOptionPane.showMessageDialog(null,"Correct Password / Username");
Frame regFace =new Frame();
regFace.setVisible(true);
dispose();
	/*try
	{
		FileReader fr1=new FileReader(s3);
		BufferedReader br1=new BufferedReader(fr1);
		String diaryS,diaryDate,diaryDes,diaryAct;
		while((diaryS=br1.readLine())!=null)
                {
		    diaryDate=diaryS.substring(0,10);
                    diaryDes=diaryS.substring(10,31);
                    diaryAct=diaryS.substring(31);
                    JOptionPane.showMessageDialog(null,diaryDate+"-"+diaryDes+"-"+diaryAct);
                }
 	} catch(IOException e)
          {
         		System.out.println("Enter Valid FileName");
 	  }*/
          Runtime runtime = Runtime.getRuntime();
          Process process = runtime.exec("C:\\Windows\\notepad.exe "+s3);
}
}
if (!found)
{

JOptionPane.showMessageDialog(null,"Wrong Password / Username");
txuser.setText("");
pass.setText("");
txuser.requestFocus();
}
} catch(IOException e)
	{
         System.out.println("Enter Valid FileName");
 	}
}
});
}
public void actionnewuser(){
blo.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae)  {
String puname1 = txuser.getText();
String ppaswd1 = pass.getText();
try
{
FileReader fr=new FileReader("users.txt");
BufferedReader br=new BufferedReader(fr);
String s,s1,s2;
boolean found=false;
while((s=br.readLine())!=null){
s1=s.substring(0,10);
s2=s.substring(10,14);
//System.out.println("String   "+s+" s1 "+s1+" s2 "+s2);
//s3=s.substring(14);
if(puname1.equals(s1.trim())) 
{
found=true;
JOptionPane.showMessageDialog(null,"User already exists");
Frame regFace =new Frame();
regFace.setVisible(true);
dispose();
}
}
if (!found)
{
fr.close();
FileWriter fw=new FileWriter("users.txt",true);
BufferedWriter bw=new BufferedWriter(fw);
s=txuser.getText()+pass.getText()+txuser.getText()+".txt\n";
bw.write(s);
bw.close();
JOptionPane.showMessageDialog(null,"User" + txuser.getText() + " created");
txuser.setText("");
pass.setText("");
txuser.requestFocus();
}
} catch(IOException e)
	{
         System.out.println("Enter Valid FileName");
 	}
}
});
}
}
