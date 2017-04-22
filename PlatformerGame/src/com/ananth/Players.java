package com.ananth;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.*;
import javax.swing.Timer;
public class Players {
int x,y,move,momentum,number,health,points;
boolean crouched,ableShot,momentumDir,canNade;

public Players(int ox,int oy,int n){
	x=ox;
	y=oy;


	number = n;
health = 100;

}
public void moveLeft(){
x-=10;
}
public void moveUp(){
	
}
public void moveRight(){
	x+=10;

}

public void setX(int x2){
	x= x2;
}
public void setY(int y2){
	y=y2;
}

public int getX(){
	return x;
}
public int getY(){
	return y;
}

public boolean canShoot(){
	return ableShot;
}
public void notAbleShot(){
	ableShot = false;
}
public boolean canNade(){
	return canNade;
}
public void notCanNade(){
	canNade = false;
}
private Timer timer = new Timer(750, new ActionListener(){
	//  count3C();
	@Override
	public void actionPerformed(ActionEvent e) {
		ableShot=true;
		
	}
	
});
private Timer timer2 = new Timer(1500, new ActionListener(){
	//  count3C();
	@Override
	public void actionPerformed(ActionEvent e) {
		canNade=true;
		
	}
	
});
public void runTimer(){
	timer.start();
}
public void runTimer2(){
	timer2.start();
}

public void hit(){
	health-=5;
}
public void gHit(){
	health-=10;
}
public int getHealth(){
	return health;
}
public void setHealth(int x){
	health = x;
}
public void setPoint(int x){
	points = x;
}
public int getPoint(){
	return points;
}
}
