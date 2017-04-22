package com.ananth;

public class Enemy {
	int xloc,yloc,movement;
	Players p1;
	public Enemy(int x, int y,Players p){
		xloc= x;
		yloc = y;
		p1=p;
		movement = 7;
	}
	public void move(){
		
		if(p1.getX()<xloc){
			xloc-=movement;
		}
		else if(p1.getX()>xloc){
			xloc+=movement;
		}
	}
	public void reg(){
		if(Math.abs(p1.getX()-xloc)<5){
			System.out.println("hit");
			Main.damage++;
		}

	}
	public void tick(){
		this.move();
		this.reg();
	}
	
}
