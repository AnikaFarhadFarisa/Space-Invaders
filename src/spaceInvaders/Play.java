package spaceInvaders;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Play extends JPanel{
	
	final int PANEL_WIDTH = 800;
	final int PANEL_HEIGHT = 750;
	
	Timer timer;
	Timer timer1;
	
	//Enemy enemy;
	int enemyAcceleration = 1;
	int enemX;
	int enemY;
	
	
	int shotAcceleration = 5;
	int shotX;
	int shotY;
	
	int count = 0;
	int maxCount = 20;
	
	Enemy enemyList[] = new Enemy[maxCount];
	Shot enemyShotList[] = new Shot[maxCount];
	
	Image playerShotImg;
	int playerAcceleration = 10;
	Shot playerShot;
	
	Player player = new Player();
	public ActionHandler M_Key = new ActionHandler();
	
	boolean winState;
	boolean gameOn = true;
	int numOfKill;
	
	JLabel scoreLabel;
	int score = 0;
	
	JProgressBar lifeBar;
	int remLife = 100;
	
	int countNull = 0;

	
	Play(JLabel score, JProgressBar bar){
		
		this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		this.setBackground(Color.black);
		this.addKeyListener(M_Key);
		this.setFocusable(true);
		this.setLayout(new BorderLayout());
		
		this.scoreLabel = score;
		this.lifeBar = bar;
        
		timer1 = new Timer(3000, new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				generateEnemy();
				generateEnemyShot();
				repaint();
				count = count + 1;
				if (count > maxCount-1 || gameOn == false) {
					((Timer) e.getSource()).stop();
				}
			}
			
		});
		timer1.start();
		
		timer = new Timer(10, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			moveEnemyShip();
			moveEnemShot();
			movePlayer();
			movePlayerShot();
			checkCollision();
			repaint();
			if(count == maxCount) {
				checkStatus();
			}
			if(gameOn == false) {
				((Timer) e.getSource()).stop();
			}
		    }
		});
		timer.start();
	}
	
	public void checkStatus() {
		countNull = 0;
		for(int i = 0; i < maxCount; i++) {
			
			if(enemyList[i] == null) {
				countNull = countNull + 1;
				//System.out.println(countNull);
			}
			
		}
		if (countNull > maxCount-1) {gameOn = false;}
	}
		
	
	public void generateEnemy() {
		
		enemyList[count] = new Enemy();
		
	}
	
	public void generateEnemyShot() {
		
		for (int i = 0; i < maxCount; i++) {
			if(enemyList[i] != null && enemyList[i].hasFired != true) {
				
				shotX = enemyList[i].getXPos() + 89;
				shotY = enemyList[i].getYPos() + 180;
				enemyShotList[i] = new Shot(shotX, shotY);
				enemyList[i].setHasFired();
			}
		}
		
	}
	
	public void moveEnemyShip() {
		
		for (int i = 0; i < maxCount; i++) {
				
			if(enemyList[i] != null) {
				
				if(enemyList[i].getYPos() > 800) {
					enemyList[i] = null;
				}
				else {
					enemyList[i].setYPos(enemyAcceleration);
				}
				
			}
		}
	}
	
	
	public void moveEnemShot() {
		for (int i = 0; i < maxCount; i++) {
			
			if(enemyShotList[i] != null) {
				
				if(enemyList[i] != null && enemyShotList[i].getYPos() > 1200 ) {
					shotX = enemyList[i].getXPos() + 89;
					shotY = enemyList[i].getYPos() + 180;
					enemyShotList[i] = new Shot(shotX, shotY);
				}
				else{
					enemyShotList[i].setYPos(shotAcceleration);
				}
				
			}
			
			else if(enemyShotList[i] == null && enemyList[i] != null) {
				shotX = enemyList[i].getXPos() + 89;
				shotY = enemyList[i].getYPos() + 180;
				enemyShotList[i] = new Shot(shotX, shotY);
				
			}
		}
	}
	
	
	public void movePlayer() {
		
		if(M_Key.up == true && player.getYPos() > 0) {
			player.setYPos(-playerAcceleration);
		}
		else if(M_Key.down == true && player.getYPos() < 525) {
			player.setYPos(playerAcceleration);
		}
		else if(M_Key.left == true && player.getXPos() > 21) {
			player.setXPos(-playerAcceleration);
		}
		else if(M_Key.right == true && player.getXPos() < 605) {
			player.setXPos(playerAcceleration);
		}
		else if(M_Key.shoot == true) {
			playerShoots();
		}
	}
	
	
	public void playerShoots() {
		
		playerShot = new Shot(player.getXPos() + 86, player.getYPos());
		
	}
	
	
	public void movePlayerShot() {
		
		if(playerShot != null && playerShot.getYPos() >= 0) {
			playerShot.setYPos(-shotAcceleration);
		}
		else if(playerShot != null && playerShot.getYPos() < 0) {
			playerShot = null;
		}
		
	}
	
	
	public void checkCollision() {
		
		for (int i = 0; i < maxCount; i++) {
			if(enemyList[i] != null && playerShot != null) {
				
				int enemX = enemyList[i].getXPos() ;
				int enemY = enemyList[i].getYPos();
				int enemXMax = enemX + 190;
				int enemXMin = enemX;
				int enemYMax = enemY + 180;
				int enemYMin = enemY;
				
				int playerShotX = playerShot.getXPos();
				int playerShotY = playerShot.getYPos();
				int plShotXMax = playerShotX + 20;
				int plShotYMax = playerShotY + 40;
				
				
				if (plShotXMax < enemXMax && plShotXMax > enemXMin && plShotYMax < enemYMax && plShotYMax > enemYMin) {
					enemyList[i] = null;
					playerShot = null;
					numOfKill = numOfKill + 1;
					incrementScore();
					if (numOfKill == maxCount) {
						winState = true;
						gameOn = false;
					}
				}
			}
			
			if(enemyShotList[i] != null && player != null) {
				int plX = player.getXPos();
				int plY = player.getYPos();
				int plXMax = plX + 190;
				int plXMin = plX;
				int plYMax = plY + 180;
				int plYMin = plY;
				
				int enemShotX = enemyShotList[i].getXPos();
				int enemShotY = enemyShotList[i].getYPos();
				int enemShotXMax = enemShotX + 20;
				int enemShotYMax = enemShotY + 40;
				
				if (enemShotXMax < plXMax && enemShotXMax > plXMin && enemShotYMax < plYMax && enemShotYMax > plYMin) {
					enemyShotList[i] = null;
					decrementLife();
					if (remLife <= 0) {
						winState = false;
						gameOn = false;
					}
					
				}
			}
		}
	}
	
	
	public void incrementScore() {
		score = score + 15;
		scoreLabel.setText("Score : " + score);
	}
	
	public void decrementLife() {
		remLife = remLife - 5;
		lifeBar.setValue(remLife);
		if(remLife < 50) {
			lifeBar.setForeground(Color.RED);
		}
	}
	
	
	public void paint(Graphics g) {
		
		super.paint(g);
		
		Graphics2D g2D = (Graphics2D) g;
		
		if(player != null) {
			g2D.drawImage(player.getPlayerImage(), player.getXPos(), player.getYPos(), null);
		}
		
		
		if (playerShot != null) {
			g2D.drawImage(playerShot.getPlayerShotImage(), playerShot.getXPos(), playerShot.getYPos(), null);
		}
		
		for (int i = 0; i < maxCount; i++) {
			
			if(enemyShotList[i] != null) {
				g2D.drawImage(enemyShotList[i].getEnShotImage(), enemyShotList[i].getXPos(), enemyShotList[i].getYPos(), null);
			}
			
			if(enemyList[i] != null) {
				g2D.drawImage(enemyList[i].getEnemyImage(), enemyList[i].getXPos(), enemyList[i].getYPos(), null);
			}
			
		}
		
		if (gameOn == false) {
			
			Font font = new Font("Arial", Font.BOLD, 40);
            g2D.setFont(font);
            g2D.setColor(Color.WHITE);
			
			if (winState) {
				
	            g2D.drawString("You Won!", 310, 350); 
				
			}
			else if(remLife <= 0 && !winState){
				
	            g2D.drawString("Game Over! You Lost", 210, 350);
				
			}
			
			else {
				
				g2D.drawString("Score: " + score, 345, 350);
				
			}
					
					
		}
		
		
	}
	
}
