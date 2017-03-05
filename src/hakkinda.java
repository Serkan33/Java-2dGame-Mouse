

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class hakkinda extends JFrame {
	JTextArea yazi;
	ImageIcon bg= new ImageIcon(getClass().getResource("hakkinda.jpg"));
	JLabel bglabel=new JLabel(bg);
	JPanel p=new JPanel();
	 public hakkinda()
	 {
		 setTitle("ABOUT");
			setSize(600, 400);
			setLocationRelativeTo(null);
			setLayout(null);
			setResizable(false);
			setMinimumSize(null);
			p.setBounds(0,0,600,400);
			p.setBackground(Color.white);
			bglabel.setBounds(100, 20, 400, 300);
			yazi=new JTextArea();
			yazi.setForeground(Color.black);
			yazi.setText
			("                                FAREYI KACIR \n\n Oyunumuzun amaci mouse ile hareket ettirdigimiz\n cismimizi hareketli nesnelerden"
					+ " kacirmaktir.Kacirdigimiz \n cisimlerden biri bonusa sahip olmadigimiz surece bize \n carparsa oyunu kaybetmis oluruz.Fakat ekranda "
					+ " rastgele  \n cikan bonusu(yesil cisim) aldigimizda verilen sure icerisinde \n cisimleri yok edebiliriz."
					+ "Cisimleri tamamen yok ettigimizde \n leveli bitirmis oluyoruz.Oyun icin basarilar...  "+""
					+ "\n\n\n                                  Hacer Ozyurt\n Serkan Tash                                                Hilal Ozdemir"+"");
			yazi.setFont(new Font("helvetica", Font.PLAIN, 18));
			yazi.setEditable(false);
			yazi.setBounds(70, 0, 600, 350);
			yazi.setOpaque(false);
			add(yazi);
			add(bglabel);
			add(p);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
	 }
	public static void main(String[] args)
	{
		new hakkinda();
	}
}
