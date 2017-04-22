package com.ananth;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

public class Bullets {
	int x;
	double y;
	boolean direction;
	ArrayList<Bullets> BulletsPrime;
	public Bullets(int a, double b,boolean c,ArrayList<Bullets> bp) {
		x=a;
		y=b;
		direction = c;
	}
	public void move(){
		if(direction){
		x+=30;
		}
		else{
		x-=30;
		}
		y+=2;
		for(int i = 0; i < Main.enemies.size(); i++){
			Enemy e = Main.enemies.get(i);
			if(HitBox.bulletEnemyCollision(this, e)){
				Main.score+=10;
				Main.enemies.remove(i);
				die();
				i--;
				
				System.out.println(Main.score);
			}
		}
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return (int)y;
	}
	public boolean direction(){
		return direction;
	}
	public void die(){
		BulletsPrime.remove(this);
	}

}
