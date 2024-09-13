package spaceInvaders;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Shot {
	
	Image enShotImage;
	Image playerShotImage;
	
	final int SHOT_WIDTH = 20;
	final int SHOT_HEIGHT = 40;
	int xPos;
	int yPos;
	
	Rectangle collisionBox;
	
	Shot(int x, int y) {
		this.xPos = x;
		this.yPos = y;
		collisionBox = new Rectangle(xPos, yPos, SHOT_WIDTH, SHOT_HEIGHT);
		enShotImage = new ImageIcon(getClass().getClassLoader().getResource("enemy_shot.png")).getImage()
				.getScaledInstance(SHOT_WIDTH, SHOT_HEIGHT, Image.SCALE_DEFAULT);
		playerShotImage = new ImageIcon(getClass().getClassLoader().getResource("enemy_shot.png")).getImage()
				.getScaledInstance(SHOT_WIDTH, SHOT_HEIGHT, Image.SCALE_DEFAULT);
	}
	
	public Image getEnShotImage() {
		return enShotImage;
	}
	
	public Image getPlayerShotImage() {
		return playerShotImage;
	}
	
	public Rectangle getCollisionBox() {
		return collisionBox;
	}
	
	public void setEnShotImage() {
		enShotImage = null;
	}
	
	public int getWidth() {
		return SHOT_WIDTH;
	}
	
	public int getHeight() {
		return SHOT_HEIGHT;
	}
	
	public int getXPos() {
		return xPos;
	}
	
	public int getYPos() {
		return yPos;
	}
	
	public void setYPos(int yAccerelate) {
		yPos = yPos + yAccerelate;
	}
	
}
