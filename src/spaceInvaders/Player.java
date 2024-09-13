package spaceInvaders;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Player {
	
	Image playerImage;
	final int SHIP_WIDTH = 190;
	final int SHIP_HEIGHT = 180;
	//boolean alive = true;
	int xPos;
	int yPos;
	final int maxPosX = 350;
	final int minPosX = 5;
	final int maxPosY = 525;
	final int minPosY = 0;
	boolean hasFired = false;
	Rectangle collisionBox;
	
	Player() {
		playerImage = new ImageIcon(getClass().getClassLoader().getResource("player_ship.png")).getImage().
				     getScaledInstance(SHIP_WIDTH, SHIP_HEIGHT, Image.SCALE_DEFAULT);
		xPos = (int) Math.floor(Math.random() *(maxPosX - minPosX + 1) + minPosX);
		yPos = (int) Math.floor(Math.random() *(maxPosY - minPosY + 1) + minPosY);
		collisionBox = new Rectangle(xPos, yPos, SHIP_WIDTH, SHIP_HEIGHT);
	}
	
	public Image getPlayerImage() {
		return playerImage;
	}
	
	public int getWidth() {
		return SHIP_WIDTH;
	}
	
	public int getHeight() {
		return SHIP_HEIGHT;
	}
	
	public int getXPos() {
		return xPos;
	}
	
	public int getYPos() {
		return yPos;
	}
	
	public void setXPos(int delX) {
		xPos = xPos + delX;
	}
	
	public void setYPos(int delY) {
		yPos = yPos + delY;
	}
	
	
	public boolean getHasFired() {
		return hasFired;
	}
	
	public void setHasFired() {
		hasFired = true;
	}
	
}


