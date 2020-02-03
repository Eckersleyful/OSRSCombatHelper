package eckersley.ui.components;


import eckersley.entities.Constants;
import eckersley.ui.UIData;



import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

import static eckersley.entities.Constants.STAT_STRINGS;



public class CustomMainFrame extends JFrame {

     public JPanel mainPanel;
     JPanel playerPanel;
     JPanel enemyPanel;
     JPanel skillPanel;
     JPanel submitPanel;
     JButton submitButton;
     UIData data;
     HashMap<String , CustomComboBox> dropDowns = new HashMap<>();
     ArrayList<JPanel> statPanels;
     JPanel statPanel;
     JPanel itemPanel;
     JPanel secondItemPanel;
     JPanel hiScorePanel;


    public CustomMainFrame(){
        statPanels = new ArrayList<>();
        data = new UIData();
        setMinimumSize(new Dimension(1280,720));
        setMaximumSize(new Dimension(1920,1080));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addComponents();
        start();
    }
     void start(){
        this.pack();
        this.setVisible(true);
    }
     void addComponents(){
        //Holds the two main panels, left and right
        mainPanel = new JPanel(new GridLayout(1,2));
        //The left panel, holds two larger panels top and bottom
        playerPanel = new JPanel(new GridLayout(3,2));
        //Holds 3 panels: item dropdowns, submit button panel and hiscores search
        itemPanel = new ItemPanel(2,1, data);
        secondItemPanel = new ItemPanel(2,1, data);
        //Hiscorepanel that holds the textarea for the player name and submit button
        hiScorePanel = new HighScorePanel();
        //FlowLayout panel for adding the scrollboxes dynamically
        //scrollBoxPanel = new JPanel();
        //Panel for the submit button

        //The right panel for the enemy stats etc.
        enemyPanel = new JPanel();
        //GridLayout panel for holding the player stats
        
        //Add the itempanel which has the dropdowns and the hiscore panel to the player panel
        playerPanel.add(itemPanel);
        playerPanel.add(secondItemPanel);
        skillPanel = new SkillPanel();
        playerPanel.add(skillPanel);


        playerPanel.add(hiScorePanel);

        //playerPanel.add(statPanel);
        /*submitButton = new JButton("Calculate stats");
        submitPanel.add(submitButton);
        playerPanel.add(submitPanel);*/
        mainPanel.add(playerPanel);
        mainPanel.add(enemyPanel);
        add(mainPanel);


    }


}
