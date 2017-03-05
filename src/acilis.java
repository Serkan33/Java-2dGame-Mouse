


import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;



public class acilis extends JFrame {
	
	ImageIcon start,ab,ex;
	JPanel p;
	JButton basla,about,exit;
	int level=0;
	public acilis()
	{
		setTitle("FAREYI KAÇIR");
		setSize(500, 500);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setMinimumSize(null);
		ImageIcon resim=new ImageIcon(getClass().getResource( "arka.png" ));
		start=new ImageIcon(getClass().getResource( "BASLA.png"));
		ab=new ImageIcon(getClass().getResource( "about.png"));
		ex=new ImageIcon(getClass().getResource( "ex.png"));
		JLabel ap=new JLabel(resim);
		ap.setBounds(0, 0, 500, 500);
	
		basla=new JButton();
		basla.setOpaque(false);
		basla.setContentAreaFilled(false);
		basla.setBorderPainted(false);
		basla.setBounds(10,80,300,100);
		basla.setIcon(start);
		basla.addActionListener(new ActionListener()
		{  
			public void actionPerformed(ActionEvent e)
			  {
				dispose();
					anaclass gec = new anaclass();
			    gec.setVisible(true);  
			    
			   
			  }

		});
		
		about=new JButton("");
		about.setOpaque(false);
		about.setContentAreaFilled(false);
		about.setBorderPainted(false);
		about.setBounds(10,140,300,100);
		about.setIcon(ab);
		about.addActionListener(new ActionListener()
		{  
			public void actionPerformed(ActionEvent e)
			  {
			    new hakkinda();
			  }

		});
		
		exit=new JButton("");
		exit.setOpaque(false);
		exit.setContentAreaFilled(false);
		exit.setBorderPainted(false);
		exit.setBounds(10,200,300,100);
		exit.setIcon(ex);
		exit.addActionListener(new ActionListener()
		{  
			public void actionPerformed(ActionEvent e)
			  {
			    System.exit(0); 
			  }

		});
		
		p=new JPanel();
		p.setBounds(100, 100, 300, 300);
		p.setLayout(null);
		p.setOpaque(false);
		p.add(basla);
		p.add(about);
		p.add(exit);
		add(p);
		add(ap);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
