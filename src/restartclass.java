

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class restartclass extends JFrame {
		JButton restart,cik;
		
		
		JPanel panel;
		ImageIcon resim=new ImageIcon(getClass().getResource( "gover.gif"));
		ImageIcon gov=new ImageIcon(getClass().getResource( "over.gif"));
		ImageIcon exit=new ImageIcon(getClass().getResource("exit.gif"));
		JLabel over;
	public restartclass()
	{     
		 setTitle("Yeniden Oyna");
		 setSize(300, 220);
		 setLocationRelativeTo(null);
		 setLayout(null);
		 setUndecorated(true);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setResizable(false);
		 setMinimumSize(null);
		 
		 panel=new JPanel();
		 panel.setBounds(0, 0, 300, 220);
		 panel.setBackground(Color.black);
		
		 restart = new JButton();
		 restart.setBounds(0,100,310,50);
		 restart.setOpaque(false);
		 restart.setContentAreaFilled(false);
		 restart.setBorderPainted(false);
		 restart.setIcon(gov);
		
		 cik=new JButton();
		 cik.setBounds(10, 150, 300, 50);
		 cik.setOpaque(false);
		 cik.setContentAreaFilled(false);
		 cik.setBorderPainted(false);
		 cik.setIcon(exit);

		 over=new JLabel(resim);
		 over.setBounds(0, -30, 300, 200);
		
		 add(restart);
		 add(cik);
		 add(over);
		 add(panel);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setVisible(true);
	}
	public static void main(String[] args)
	{
		new restartclass();
	}

}
