import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;


//import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class TicTacToe implements MouseListener
{
    private static final String PLAYERX = "Jugador X";
    private static final String PLAYERO = "Jugador O";
	
	private static Integer turno = 1;
    private String playerName = PLAYERX;
	
    private javax.swing.JButton button1;
    private javax.swing.JButton button2;
    private javax.swing.JButton button3;
    private javax.swing.JButton button4;
    private javax.swing.JButton button5;
    private javax.swing.JButton button6;
    private javax.swing.JButton button7;
    private javax.swing.JButton button8;
    private javax.swing.JButton button9;
    private javax.swing.JLabel playerNumber;
    private java.awt.Panel buttonsPanel,optionsPanel;

	private javax.swing.JButton buttonReset, buttonVsCpu;
	private javax.swing.JFrame frame;
	
	public static String[] panel = new String[9];
	public static boolean partidaEnCurso = false, vsCpu = false;
	
    public static void main(String[] args){
        TicTacToe ejemplo = new TicTacToe();
        ejemplo.initComponents();
    }

    private void initComponents(){
        buttonsPanel = new java.awt.Panel();
   		optionsPanel = new java.awt.Panel();

        button1 = new javax.swing.JButton();
        button2 = new javax.swing.JButton();
        button3 = new javax.swing.JButton();
        button4 = new javax.swing.JButton();
        button5 = new javax.swing.JButton();
        button6 = new javax.swing.JButton();
        button7 = new javax.swing.JButton();
        button8 = new javax.swing.JButton();
        button9 = new javax.swing.JButton();
        playerNumber = new javax.swing.JLabel(playerName, SwingConstants.CENTER);
        
        buttonReset = new javax.swing.JButton("Reiniciar");
        buttonVsCpu = new javax.swing.JButton("Vs. CPU");
        
        frame = new javax.swing.JFrame("Tic Tac Toe");

	    
        button1.addMouseListener(this);
        button2.addMouseListener(this);
        button3.addMouseListener(this);
        button4.addMouseListener(this);
        button5.addMouseListener(this);
        button6.addMouseListener(this);
        button7.addMouseListener(this);
        button8.addMouseListener(this);
        button9.addMouseListener(this);
        buttonReset.addMouseListener(this);
        buttonVsCpu.addMouseListener(this);
    
        Font buttonFont = new Font("Times New Roman", Font.PLAIN, 60);
	    
        button1.setFont(buttonFont);
        button2.setFont(buttonFont);
        button3.setFont(buttonFont);
        button4.setFont(buttonFont);
        button5.setFont(buttonFont);
        button6.setFont(buttonFont);
        button7.setFont(buttonFont);
        button8.setFont(buttonFont);
        button9.setFont(buttonFont);
	    
        buttonsPanel.setLayout(new java.awt.GridLayout(4, 8));
        
        buttonsPanel.add(button1);
        buttonsPanel.add(button2);
        buttonsPanel.add(button3);
        buttonsPanel.add(button4);
        buttonsPanel.add(button5);
        buttonsPanel.add(button6);
        buttonsPanel.add(button7);
        buttonsPanel.add(button8);
        buttonsPanel.add(button9);
        
        setPlayerName(PLAYERX); 
       
		buttonsPanel.add(playerNumber);
        
        optionsPanel.setLayout(new java.awt.GridLayout(1,1));
        
        optionsPanel.add(buttonReset);
        optionsPanel.add(buttonVsCpu);
        
        frame.add(optionsPanel);
		 frame.pack();
        frame.add(buttonsPanel);
       
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
		frame.setVisible(true);
		partidaEnCurso = true;
    }
	
    private void setPlayerName(String playerName){
        this.playerName = playerName;
        playerNumber.setText(playerName  + " tira. ");
    }
	
    private void reset(){
        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button5.setText("");
        button6.setText("");
        button7.setText("");
        button8.setText("");
        button9.setText("");
        
        button1.setForeground(Color.black);
        button2.setForeground(Color.black); 
        button3.setForeground(Color.black);
        button4.setForeground(Color.black);
        button5.setForeground(Color.black);
        button6.setForeground(Color.black);
        button7.setForeground(Color.black);
        button8.setForeground(Color.black);
        button9.setForeground(Color.black);
        turno = 1;
        
        partidaEnCurso = true;
        vsCpu = false;
        
        for (int i=0;i<9;i++){ panel[i] = "";}
        
        setPlayerName(PLAYERX);
    }
	
   public void checkForWinner(){
        String [] str = {"OK"};
        
        
        if(findThreeInARow()){
            
			String winnerName=(playerName == PLAYERX)?PLAYERX:PLAYERO;

           /* JOptionPane.showOptionDialog(frame, winnerName.concat(" won!!! Congratulations!!!"),
        		"Congratulations!", JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE, null, str, "OK");
        	*/	
        	playerNumber.setText(playerName  + " ha ganado. ");
        	
        	partidaEnCurso = false;
            //reset();
            
        }
        if (partidaEnCurso==true)
        {
			if (playerName == PLAYERX) setPlayerName(PLAYERO);
			else if (playerName == PLAYERO) setPlayerName(PLAYERX);
		}
		
		if (turno == 9 && partidaEnCurso == true)
		{
			partidaEnCurso = false;
			playerNumber.setText("Partida en tablas.");


		}
		turno++;
        
    }
    
    public void turnoCpu()
    {
		Random aleatorio = new Random();
		int tirada = 0;
		while (tirada == 0)
		{
			switch (aleatorio.nextInt(9))
			{
				case 0: if (button1.getText() == ""){ panel[0] = playerName; button1.setText("O"); tirada=1;} break;
				case 1: if (button2.getText() == ""){ panel[1] = playerName; button2.setText("O"); tirada=1;} break;
				case 2: if (button3.getText() == ""){ panel[2] = playerName; button3.setText("O"); tirada=1;} break;
				case 3: if (button4.getText() == ""){ panel[3] = playerName; button4.setText("O"); tirada=1;} break;
				case 4: if (button5.getText() == ""){ panel[4] = playerName; button5.setText("O"); tirada=1;} break;
				case 5: if (button6.getText() == ""){ panel[5] = playerName; button6.setText("O"); tirada=1;} break;
				case 6: if (button7.getText() == ""){ panel[6] = playerName; button7.setText("O"); tirada=1;} break;
				case 7: if (button8.getText() == ""){ panel[7] = playerName; button8.setText("O"); tirada=1;} break;
				case 8: if (button9.getText() == ""){ panel[8] = playerName; button9.setText("O"); tirada=1;} break;
				
			}
		}
	}
	
    public void mouseClicked(MouseEvent e) {
        javax.swing.JButton currentButton = (JButton)e.getComponent();
        
        if(currentButton == buttonVsCpu)
        {
			vsCpu = true;
			playerNumber.setText("IA activada.");
		}
        
		if(currentButton == buttonReset)
		{
			reset();
		}
		
        if (partidaEnCurso == true)
        {
			
			if (vsCpu == true && playerName == PLAYERO)
			{
				turnoCpu();
				checkForWinner();
			}
			else if (currentButton.getText() == ""){
				if (playerName == PLAYERX) {
					currentButton.setText("X");
					
					if (currentButton == button1) panel[0] = playerName;
					if (currentButton == button2) panel[1] = playerName;
					if (currentButton == button3) panel[2] = playerName;
					if (currentButton == button4) panel[3] = playerName;
					if (currentButton == button5) panel[4] = playerName;
					if (currentButton == button6) panel[5] = playerName;
					if (currentButton == button7) panel[6] = playerName;
					if (currentButton == button8) panel[7] = playerName;
					if (currentButton == button9) panel[8] = playerName;
									
				} 
				else if (playerName == PLAYERO){
					currentButton.setText("O");
					
					
					
						if (currentButton == button1) panel[0] = playerName;
						if (currentButton == button2) panel[1] = playerName;
						if (currentButton == button3) panel[2] = playerName;
						if (currentButton == button4) panel[3] = playerName;
						if (currentButton == button5) panel[4] = playerName;
						if (currentButton == button6) panel[5] = playerName;
						if (currentButton == button7) panel[6] = playerName;
						if (currentButton == button8) panel[7] = playerName;
						if (currentButton == button9) panel[8] = playerName;
					
				}
				
				checkForWinner();
				//  if (playerName == PLAYERX) setPlayerName(PLAYERO);
				//else if (playerName == PLAYERO) setPlayerName(PLAYERX);
				
			}
        }
        
        
        
    }

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
	
	private boolean findThreeInARow(){
 
 
	if (panel[0] == playerName && panel[1] == playerName && panel[2] == playerName){button1.setForeground(Color.yellow);button2.setForeground(Color.yellow); button3.setForeground(Color.yellow);return true;}
	else if (panel[3] == playerName && panel[4] == playerName && panel[5] == playerName){ button4.setForeground(Color.yellow);button5.setForeground(Color.yellow); button6.setForeground(Color.yellow); return true;}
	else if (panel[6] == playerName && panel[7] == playerName && panel[8] == playerName){ button7.setForeground(Color.yellow);button8.setForeground(Color.yellow); button9.setForeground(Color.yellow); return true;}
	else if (panel[0] == playerName && panel[3] == playerName && panel[6] == playerName){ button1.setForeground(Color.yellow);button4.setForeground(Color.yellow); button7.setForeground(Color.yellow); return true;}
	else if (panel[1] == playerName && panel[4] == playerName && panel[7] == playerName){ button2.setForeground(Color.yellow);button5.setForeground(Color.yellow); button8.setForeground(Color.yellow); return true;}
	else if (panel[2] == playerName && panel[5] == playerName && panel[8] == playerName){ button3.setForeground(Color.yellow);button6.setForeground(Color.yellow); button9.setForeground(Color.yellow); return true;}
	else if (panel[0] == playerName && panel[4] == playerName && panel[8] == playerName){ button1.setForeground(Color.yellow);button5.setForeground(Color.yellow); button9.setForeground(Color.yellow); return true;}
	else if (panel[2] == playerName && panel[4] == playerName && panel[6] == playerName){ button3.setForeground(Color.yellow);button5.setForeground(Color.yellow); button7.setForeground(Color.yellow); return true;}
	else return false;
   }
}
