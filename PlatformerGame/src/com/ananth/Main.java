package com.ananth;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
//import java.awt.Toolkit;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.*;

@SuppressWarnings("serial")
public class Main extends JPanel {

	static JFrame frame;
	static keyControl keyControl;
	static HitBox box;
	static Players p1;
	static Players p2;
	int rand;
	double r, g2, b;

	public static ArrayList<Bullets> bullets;

	public static Ground ground;

	public Image guy, left, leftF, right, rightF, alien;
	public ArrayList<Image> images;
	public static ArrayList<Enemy> enemies;
	public int enemyspawn;
	public static int score,damage;
	public Main(JFrame jf) {
		frame = jf;
	}

	public void init(int x, int y) throws IOException {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		rand = (2 * getHeight()) / 3;
		p1 = new Players(600, 400, 1);

		bullets = new ArrayList();
		left = ImageIO.read(Main.class.getResource("/guyLeft.png"));
		leftF = ImageIO.read(Main.class.getResource("/guyLeftFire.png"));
		right = ImageIO.read(Main.class.getResource("/guyRight.png"));
		rightF = ImageIO.read(Main.class.getResource("/guyRightFire.png"));
		alien = ImageIO.read(Main.class.getResource("/sumbreroguy2.png"));

		guy = right;
		images = new ArrayList<Image>();
		images.add(left);
		images.add(leftF);
		images.add(right);
		images.add(rightF);
		keyControl = new keyControl(x, y, p1, bullets, images);

		box = new HitBox();
		ground = new Ground(0, 400, 1200, 400);
		enemies = new ArrayList<Enemy>();
		enemyspawn = (int) (Math.random() * 2000) + 100;
		enemies.add(new Enemy(1000, 400, p1));
		enemies.add(new Enemy(200, 400, p1));
		score = 0;
	}

	@Override
	public void paint(Graphics g) {

		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		setBackground(Color.cyan);
		g.setColor(new Color(166, 157, 157));
		g.fillRect(ground.x, ground.y, ground.width, ground.height);
		// System.out.println(ground.x + " " + ground.y);
		g.setColor(Color.yellow);
		g.fill3DRect(100, 550, 200, 50, true);
		g.fill3DRect(500, 550, 200, 50, true);
		g.fill3DRect(900, 550, 200, 50, true);
		if(!enemyGen.isRunning()){
			
			System.out.println("started");
			enemyGen.start();
		}
		g.drawImage(images.get(keyControl.guyCheck), p1.getX(), p1.getY(), 100, 150, null);
		for (int i = 0; i < bullets.size(); i++) {

			g.setColor(Color.black);

			g.setColor(Color.red);
			g.fillRect(bullets.get(i).getX(), bullets.get(i).getY(), 10, 5);

			bullets.get(i).move();
			if (bullets.get(i).getX() < 0 || bullets.get(i).getX() > getWidth()) {
				bullets.remove(i);
			}
		}
		g.setColor(Color.red);

		for (int i = 0; i < enemies.size(); i++) {
			g.drawImage(alien, enemies.get(i).xloc, enemies.get(i).yloc, 150, 100, null);

			enemies.get(i).tick();
		}
		g.setColor(Color.black);
		g.drawString("Score: "+ score, frame.getWidth()-100, 30);
		g.drawString("Damage: "+ damage, 10, 30);
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		JFrame frame = new JFrame("Fight");
		final Main game = new Main(frame);
		game.init(1200, 800);

		keyControl.addKeyListener(keyControl);
		keyControl.setFocusable(true);
		frame.add(keyControl);

		frame.add(game);
		frame.setSize(1200, 800);
		frame.setResizable(false);
		frame.setVisible(true);
		// frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBackground(Color.black);

		while (true) {

			keyControl.tick();

			game.repaint();
			Thread.sleep(30);
		}

	}

	public Timer enemyGen = new Timer(enemyspawn, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("timer");
			if (Math.random() > 0.5) {
				enemies.add(new Enemy(-400, 400, p1));
			} else {
				enemies.add(new Enemy(frame.getWidth(), 400, p1));
			}
			enemyspawn = (int) (Math.random() * 2000) + 100;
			enemyGen.setDelay(enemyspawn);
		}

	});

}
