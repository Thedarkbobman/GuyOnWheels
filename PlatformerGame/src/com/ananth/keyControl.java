package com.ananth;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.*;

public class keyControl extends JPanel implements KeyListener {
	private static final long serialVersionUID = 1L;
	private int width, height, count, count2, count3, count4, moMove;
	private boolean[] keys = new boolean[65536];
	private Players p1, p2;
	private ArrayList<Bullets> bullets, bullets2;
	
	private boolean check, aCheck, dCheck, leftCheck, rightCheck;
	public boolean timerRun1, timerRun2;
	private ArrayList guy;
	int guyCheck,guyCheck2;
	public keyControl(int w, int h, Players a, ArrayList<Bullets> c,ArrayList i) {
		width = w;
		height = h;
		p1 = a;
		count = 0;
		check = false;
		timerRun1 = false;
		timerRun2 = false;
		bullets = c;
		aCheck = false;
		dCheck = false;
		
		rightCheck = true;
		guy = i;
		guyCheck2 = 1;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	public void tick() {
		if (keys[KeyEvent.VK_A] || keys[KeyEvent.VK_D]) {
			if(keys[KeyEvent.VK_A]){
		p1.moveLeft();
		guyCheck = 1;
		rightCheck = false;
			}
			if(keys[KeyEvent.VK_D]){
				p1.moveRight();
				guyCheck = 3;
				rightCheck = true;
			}
		} else{
			if(rightCheck){
				guyCheck = 2;
					}else{
				guyCheck = 0;
					}
		}

	
		if (keys[KeyEvent.VK_W]) {
	

		}
	
		if (keys[KeyEvent.VK_SPACE]) {
			//if(bullets.size()<7){
			if(rightCheck){
			Bullets b = new Bullets(p1.getX()+100, p1.getY()+20, rightCheck, bullets);
			bullets.add(b);
			}
			else{
				Bullets b = new Bullets(p1.getX()-20, p1.getY()+20, rightCheck, bullets);
				bullets.add(b);
			}
			//}
		}
		//System.out.println(guyCheck);
	}

	public int xLoc() {
		return 1;
	}

	public int yLoc() {
		return 1;
	}

	public Timer timer = new Timer(10, new ActionListener() {
		// count3C();
		@Override
		public void actionPerformed(ActionEvent e) {
			if (count < 25) {
				p1.setY(p1.getY() - 3);
			} else if (count > 25 && count <= 49) {
				p1.setY(p1.getY() + 3);
			} else if (count == 50) {
				p1.setY(p1.getY() + 1);
				count = 0;
				timerRun1 = false;
				timer.stop();
			}


			/*
			 * if(count3-p1.getY() == 50){ check = true; } else if(!check){
			 * p1.setY(p1.getY()-1); } else if(check){ p1.setY(p1.getY()+1); }
			 * if(p1.getY()==count3&& check == true){ check = false;
			 * timer.stop(); }
			 */
			count++;

		}

	});
	public Timer timer2 = new Timer(10, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (count2 < 25) {
				p2.setY(p2.getY() - 3);
			} else if (count2 > 25 && count2 <= 49) {
				p2.setY(p2.getY() + 3);
			} else if (count2 == 50) {
				p2.setY(p2.getY() + 1);
				count2 = 0;
				timerRun2 = false;
				timer2.stop();
			}

			/*
			 * if(count3-p1.getY() == 50){ check = true; } else if(!check){
			 * p1.setY(p1.getY()-1); } else if(check){ p1.setY(p1.getY()+1); }
			 * if(p1.getY()==count3&& check == true){ check = false;
			 * timer.stop(); }
			 */
			count2++;

		}

	});


	public boolean timerRun1() {
		return timerRun1;
	}

	public boolean timerRun2() {
		return timerRun2;
	}

	public boolean keyACheck() {
		return aCheck;
	}

	public boolean keyDCheck() {
		return dCheck;
	}

	public boolean keylCheck() {
		return leftCheck;
	}

	public boolean keyrCheck() {
		return rightCheck;
	}
	public int guyCheck(){
		return guyCheck;
	}
}
