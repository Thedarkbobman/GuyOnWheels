package com.ananth;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class HitBox extends Rectangle2D {
	private static int x, y, x2, y2;
	Rectangle player, bullet, shot, alien;
	
	public static boolean bulletEnemyCollision(Bullets b, Enemy e) {
		
		Rectangle player = new Rectangle(e.xloc, e.yloc, 150, 100);
		
		Rectangle bullet = new Rectangle(b.getX(), b.getY(), 10, 5);
		

		 return player.intersects(bullet);

	}

	

	@Override
	public Rectangle2D createIntersection(Rectangle2D r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle2D createUnion(Rectangle2D r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int outcode(double x, double y) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setRect(double x, double y, double w, double h) {
		// TODO Auto-generated method stub

	}

	@Override
	public double getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
