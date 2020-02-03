package eckersley.ui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class HighScorePanel extends  JPanel{

    //Panel for holding the textfield and button for the hiscore lookup
    JPanel hiScorePanel;
    //Panel for holding the username
    JPanel playerNamePanel;
    //Text field for the name
    JTextField playerName;
    private final static String USERNAME = "     Username      ";
    public HighScorePanel(){
        setLayout(new GridLayout(2,1));
        addComponents();
    }

    private void addComponents() {
        playerNamePanel = new JPanel();
        playerName = new JTextField(USERNAME);
        playerName.addFocusListener(new ToolTipFocus(playerName));

        playerNamePanel.add(playerName);
        JPanel lookUpPanel = new JPanel();
        JButton lookUpButton = new JButton("Lookup");
        playerNamePanel.add(lookUpButton);

        add(playerNamePanel);
        add(lookUpPanel);
    }

    class ToolTipFocus implements FocusListener {
            JTextField field;
            public ToolTipFocus(JTextField field){
                    this.field = field;
            }
            @Override
            public void focusGained(FocusEvent focusEvent) {
                    field.setText("");
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {
                    if(field.getText().equals("")){
                            field.setText(USERNAME);
                    }
            }
    }
}
