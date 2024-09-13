package spaceInvaders;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Enemy {

	Image enemyImage;
	final int SHIP_WIDTH = 190;
	final int SHIP_HEIGHT = 180;
	boolean alive = true;
	int xPos;
	int yPos;
	final int maxPosX = 600;
	final int minPosX = 5;
	final int maxPosY = -180;
	final int minPosY = -180;
	boolean hasFired = false;
	// Rectangle collisionBox;

	// build the enemy and set it's position
	Enemy() {
		enemyImage = new ImageIcon(getClass().getClassLoader().getResource("enemy_ship.png")).getImage()
				.getScaledInstance(SHIP_WIDTH, SHIP_HEIGHT, Image.SCALE_DEFAULT);
		xPos = (int) Math.floor(Math.random() * (maxPosX - minPosX + 1) + minPosX);
		yPos = (int) Math.floor(Math.random() * (maxPosY - minPosY + 1) + minPosY);
		// collisionBox = new Rectangle(xPos, yPos, SHIP_WIDTH, SHIP_HEIGHT);
	}

	//// helper funtions to get enemy's image, set the image object to
	// null, get the size and position, set a new position, and
	//// check whether it is alive and has fired or not.

	public Image getEnemyImage() {
		return enemyImage;
	}

	public void setEnemyImage() {
		enemyImage = null;
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

	public void setYPos(int yAccerelate) {
		yPos = yPos + yAccerelate;
	}

	public boolean getAliveStatus() {
		return alive;
	}

	public boolean getHasFired() {
		return hasFired;
	}

	public void setHasFired() {
		hasFired = true;
	}

}
