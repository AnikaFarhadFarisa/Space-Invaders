package spaceInvaders;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

public class Game {
	
	Image iconImg = new ImageIcon(getClass().getClassLoader().getResource("enemy_ship.png")).getImage();
	
    Game(){
    	
    	JPanel mainPanel = new JPanel(new BorderLayout());
    	
        // Create the top panel
    	JPanel topPanel = new JPanel(null);
    	topPanel.setPreferredSize(new Dimension(800, 50));
		topPanel.setBackground(Color.BLUE);
    	
        
        //create score label
        JLabel score = new JLabel("Score: 0");
        score.setFont(new Font("Verdana",Font.BOLD, 18));
        score.setForeground(Color.WHITE);
        score.setBounds(500,13,150,20);
        
        
        JProgressBar bar = new JProgressBar();
        bar.setValue(100);
        bar.setBounds(100,13, 150, 25);
        bar.setForeground(Color.GREEN);
        
        
        Play panel = new Play(score, bar);
        
        
        topPanel.add(bar);
        topPanel.add(score);
        

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(panel, BorderLayout.EAST);
        
        
        
        JFrame frame = new JFrame("Space Invaders");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setIconImage(iconImg);
        frame.setLocationRelativeTo(null);
        
        frame.add(mainPanel);
        frame.setResizable(false);
        frame.setVisible(true);
        
    }
}
