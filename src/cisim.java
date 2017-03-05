

import java.awt.Point;
import java.util.Random;

public class cisim {
	private Point p;
	private int yonx,yony;
	Random rnd=new Random();
	public cisim()
	{
		p=new Point(rnd.nextInt(500),20);
		yonx=rnd.nextInt(15);
		yony=rnd.nextInt(15);
	}
	public Point getP() {
		return p;
	}

	public void setP(Point p) {
		this.p = p;
	}

	public int getYonx() {
		return yonx;
	}

	public void setYonx(int yonx) {
		this.yonx = yonx;
	}

	public int getYony() {
		return yony;
	}

	public void setYony(int yony) {
		this.yony = yony;
	}
}
