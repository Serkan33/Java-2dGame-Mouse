


	import java.awt.Color;
	import java.awt.Cursor;
	import java.awt.Font;
	import java.awt.Graphics;
	import java.awt.Image;
	import java.awt.Point;
	import java.awt.Rectangle;
	import java.awt.Toolkit;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.MouseEvent;
	import java.awt.event.MouseMotionListener;
	import java.awt.image.BufferedImage;
	import java.util.ArrayList;
	import java.util.Random;
	import java.util.Timer;
	import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


	public class anaclass extends JFrame implements MouseMotionListener {
		ArrayList<cisim>konum=new ArrayList<cisim>();
		private Image resim,resimj,resimb;
		int x=400;
		int y=400;
		static int level=1,cisimsayisi=5,hiz=35;
		int puandurumu=0;
		static int bonusx=-30;
		static int bonusy=-30;
		static Random rnd=new Random();
		Timer bonus = new Timer();
		static int sayac=5;
		JLabel bonussaniye = new JLabel("<html><font color='white'>0</font></html>");
		JLabel kalansure=new JLabel("<html><font color='white'>0</font></html>");
		JLabel puanlbl,lev;
		JPanel panelbonus,panelpuan,bgpanel,levelpanel,pb;
		
		
	public anaclass()
	{
		
		
		if(level==2)
		{
			puandurumu=25;
		}
		if(level==3)
		{
			puandurumu=125;
		}
		ImageIcon icon=new ImageIcon(getClass().getResource("arkplan.jpg"));
		lev=new JLabel();
		lev.setText("<html><font color='white'>LEVEL:"+String.valueOf(level)+"</font></html>");
		lev.setBounds(190,0,150,25);
		JLabel sure = new JLabel("<html><font color='white'>BONUS KALAN SURE:</font></html>");
		sure.setBounds(20,0,150,20);
		sure.setFont(new Font("helvetica", Font.PLAIN, 14));
		bonussaniye.setBounds(165,0,100,20);
		bonussaniye.setFont(new Font("helvetica", Font.PLAIN, 14));
		JLabel puan=new JLabel("<html><font color='black'>PUAN:</font></html>");
		puan.setBounds(0,0,100,20);
		puanlbl=new JLabel("<html><font color='black'>"+puandurumu+"</font></html>");
		puanlbl.setBounds(50,0,150,20);
		
		levelpanel=new JPanel();
		levelpanel.setBackground(Color.red);
		levelpanel.setBounds(170, 0, 150, 25);
		levelpanel.add(lev);
		
		panelbonus=new JPanel();
		panelbonus.setLayout(null);
		panelbonus.setVisible(false);
		panelbonus.setBounds(320, 0, 180, 25);
		panelbonus.setBackground(Color.green);
		
		panelpuan=new JPanel();
		panelpuan.setLayout(null);
		panelpuan.setVisible(true);
		panelpuan.setBackground(Color.yellow);
		panelpuan.setBounds(0, 0, 170, 25);
		panelpuan.add(puan);
		panelpuan.add(puanlbl);
		panelpuan.add(lev);
		
		
		bgpanel = new JPanel();
		bgpanel.setVisible(true);
		bgpanel.setBounds(0, -5, 550, 450);
		bgpanel.add(new JLabel(icon));
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
	    Point hotSpot = new Point(0,0);
	    BufferedImage cursorImage = new BufferedImage(1, 1, BufferedImage.TRANSLUCENT); 
	    Cursor invisibleCursor = toolkit.createCustomCursor(cursorImage, hotSpot, "InvisibleCursor");        
	    setCursor(invisibleCursor);//Fare imlecimizi gizler 
	    for (int i = 0; i < cisimsayisi; i++) 
		{
			konum.add(new cisim());
		}
	    
	    zaman();
		zaman2();
		
	    panelbonus.add(sure);
	    panelbonus.add(bonussaniye);
	   
	    add(lev);
	    add(panelbonus);
	 
	    add(panelpuan);
	    add(levelpanel);
	    add(bgpanel);
	    
	    setSize(501,417);
		setLocationRelativeTo(null);
		this.setTitle("FAREYI KACIR");
		addMouseMotionListener(this);	
		setLayout(null);	 
		setResizable(false);
		setMinimumSize(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
	   
	}
	public void paint(Graphics g)
	{
		
		super.paint(g);
		
		
		ImageIcon im=new ImageIcon(getClass().getResource("ball.png"));
		
		ImageIcon im3=new ImageIcon(getClass().getResource("bonnus.png"));
		ImageIcon im2=new ImageIcon(getClass().getResource("kac.png"));
		for (int i = 0; i < konum.size(); i++) {
			konum.get(i).getP().x+=konum.get(i).getYonx();
			konum.get(i).getP().y+=konum.get(i).getYony();
			if (konum.get(i).getP().y >= 417 || konum.get(i).getP().y <= 0) {
				konum.get(i).setYony(-konum.get(i).getYony()) ;
			}
			if (konum.get(i).getP().x >= 501 || konum.get(i).getP().x <= 0) {
				konum.get(i).setYonx(-konum.get(i).getYonx()) ;
			}
			/*Ustteki islemde her cismin random yonunu alip point a ekleyip konumunu konumunu 
			degistiriyoruz
			
			if islemlerinde ise cisimler frame disina cikmasin diye yonlerini zit yonde setliyoruz
			*/
			
			resim=im.getImage();
			resimj=im2.getImage();
			resimb=im3.getImage();
			
			g.drawImage(resim, konum.get(i).getP().x-2, konum.get(i).getP().y-2, 20, 20, null);
		}
		
		g.drawImage(resimb,bonusx, bonusy, 40, 40,null);
		g.drawImage(resimj, x, y, 20, 20, null);
		Rectangle r1 =new Rectangle(x, y, 20, 20);
		Rectangle rb=new Rectangle(bonusx, bonusy, 40, 40);
		if (r1.intersects(rb)) {
			bonusx=600;
			bonusy=600;	
			panelbonus.setVisible(true);
		}
			
		else if(bonusx!=600&&bonusy!=600)
		{ 
			for (int i = 0; i < konum.size(); i++) {
				Rectangle r2 =new Rectangle(konum.get(i).getP().x-0, konum.get(i).getP().y-0, 20, 20);
				if(r1.intersects(r2)){
					this.dispose();
					final restartclass restartframe = new restartclass();
					restartframe.setVisible(true);
					restartframe.restart.addActionListener(new ActionListener()
					{  
						public void actionPerformed(ActionEvent e)
						  {
						    restartframe.dispose();
							 new anaclass();
							 bonus.cancel();
							
						  } 
							
					});
					restartframe.cik.addActionListener(new ActionListener()
					{  
						public void actionPerformed(ActionEvent e)
						  {
						    System.exit(0);
							
						  } 
							
					});
				}
			}
		}
		
		for (int i = 0; i < konum.size(); i++) {
			Rectangle r2 =new Rectangle(konum.get(i).getP().x-0, konum.get(i).getP().y-0, 20, 20);
			if(r1.intersects(r2)&&bonusx==600&&bonusy==600){
				
				konum.remove(i);
				i--;
				puandurumu+=5;
				
				if(konum.size()==0)
				{
				
				
					level++;
					cisimsayisi+=5;
					hiz=hiz-5;
					sayac=5;
					x=400;
					y=400;
					this.dispose();
				
					if(level==2)
					{	puandurumu=puandurumu+50;
						zaman();
						zaman2();
						new anaclass();
						bonus.cancel();
						
					
					}
					
					if(level==3)
					{
						zaman();
						zaman2();
						new anaclass();
						bonus.cancel();
						
					}
					
				}	
				
			if(level==1){
				puanlbl.setText(String.valueOf("<html><font color='black'>"+(puandurumu)+"</font></html>"));
			}
			if(level==2){
				
				puanlbl.setText(String.valueOf("<html><font color='black'>"+(puandurumu+50)+"</font></html>"));
			}
				
					
					
					
				}
				
				
				
			}
		

		
		try {
			Thread.sleep(hiz);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		repaint();
		
	}
	 
	public void zaman()
	{
		TimerTask gizle = new TimerTask()
				{

					@Override
					public void run() {
						
						bonusx=-30;
						bonusy=-30;
						
					}
			
				};
				bonus.schedule(gizle,0,10000 );
	}
	public void zaman2()
	{
		
		TimerTask goster = new TimerTask()
				{
				
					@Override
					public void run() {
						
						bonusx=rnd.nextInt(480);
						bonusy=rnd.nextInt(350);
						panelbonus.setVisible(true);
						sayac=5;
						}
					
					
				};
				bonus.schedule(goster,0,15000 );
				if(bonusx!=600&&bonusy!=600)
				{
					panelbonus.setVisible(true);
					
					TimerTask sure = new TimerTask()
							{

								@Override
								public void run() {
									
									sayac--;
									bonussaniye.setText(String.valueOf("<html><font color='white'>"+sayac+"</font></html>"));
									if (sayac==-1) {
										bonusx=-30;
										bonusy=-30;
										sayac=5;
									}
									if(bonusx==-30&&bonusy==-30)
									{
										panelbonus.setVisible(false);
									}
								}
								
							};
							bonus.schedule(sure, 0,1000);
				}
				
	}	
		
	public static void main(String[] args)
	{	
		new anaclass();
		
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
		x=e.getX();
		y=e.getY();
		
		
	

	}

}
