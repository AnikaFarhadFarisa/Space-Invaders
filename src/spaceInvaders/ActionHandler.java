package spaceInvaders;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ActionHandler implements KeyListener {
	public boolean up, down, left, right, shoot;

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	// set up the player's movement buttons
	@Override
	public void keyPressed(KeyEvent e) {

		switch (e.getKeyChar()) {
			case 'w':
				up = true;
				break;
			case 's':
				down = true;
				break;
			case 'a':
				left = true;
				break;
			case 'd':
				right = true;
				break;
			case KeyEvent.VK_SPACE:
				shoot = true;
				break;
		}
	}

	// set up the player's movement buttons
	@Override
	public void keyReleased(KeyEvent e) {

		switch (e.getKeyChar()) {
			case 'w':
				up = false;
				break;
			case 's':
				down = false;
				break;
			case 'a':
				left = false;
				break;
			case 'd':
				right = false;
				break;
			case KeyEvent.VK_SPACE:
				shoot = false;
				break;
		}
	}

}
