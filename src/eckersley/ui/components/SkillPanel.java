package eckersley.ui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SkillPanel extends JPanel {



    JPanel attackPanel;
    JTextField attackText;

    JPanel strengthPanel;
    JTextField strengthText;

    JPanel defencePanel;
    JTextField defenceText;

    JPanel rangedPanel;
    JTextField rangedText;

    JPanel magicPanel;
    JTextField magicText;


    JPanel hitpointsPanel;
    JTextField hitpointsText;


    public SkillPanel(){

        setLayout(new GridLayout(2,4));
        addComponents();

    }

    private void addComponents() {

        JPanel holder = new JPanel();
        attackPanel = new JPanel(new GridLayout(1,2));;
        attackText = new JTextField("", 3);
        attackText.addKeyListener(new NumberKeyListener());
        setAttackText(0);
        JPanel textPanel = new JPanel();
        textPanel.add(new JLabel("Attack"));
        attackPanel.add(textPanel);
        JPanel inputPanel = new JPanel();
        inputPanel.add(attackText);
        attackPanel.add(inputPanel);
        holder.add(attackPanel);
        add(holder);


        holder = new JPanel();
        strengthPanel = new JPanel(new GridLayout(1,2));;
        strengthText = new JTextField("", 3);
        strengthText.addKeyListener(new NumberKeyListener());
        setStrengthText(0);
        textPanel = new JPanel();
        textPanel.add(new JLabel("Strength"));
        strengthPanel.add(textPanel);
        inputPanel = new JPanel();
        inputPanel.add(strengthText);
        strengthPanel.add(inputPanel);
        holder.add(strengthPanel);
        add(holder);


        holder = new JPanel();
        defencePanel = new JPanel(new GridLayout(1,2));;
        defenceText = new JTextField("", 3);
        defenceText.addKeyListener(new NumberKeyListener());
        setDefenceText(0);
        textPanel = new JPanel();
        textPanel.add(new JLabel("Defence"));
        inputPanel = new JPanel();
        inputPanel.add(defenceText);
        defencePanel.add(textPanel);
        defencePanel.add(inputPanel);
        holder.add(defencePanel);
        add(holder);

        holder = new JPanel();
        rangedPanel = new JPanel(new GridLayout(1,2));;
        rangedText = new JTextField("", 3);
        rangedText.addKeyListener(new NumberKeyListener());
        setRangedText(0);
        textPanel = new JPanel();
        textPanel.add(new JLabel("Ranged"));

        inputPanel = new JPanel();
        inputPanel.add(rangedText);
        rangedPanel.add(textPanel);
        rangedPanel.add(inputPanel);
        holder.add(rangedPanel);
        add(holder);


        holder = new JPanel();
        magicPanel = new JPanel(new GridLayout(1,2));;
        magicText = new JTextField("", 3);
        magicText.addKeyListener(new NumberKeyListener());
        setMagicText(0);
        textPanel = new JPanel();
        textPanel.add(new JLabel("Magic"));
        magicPanel.add(textPanel);
        inputPanel = new JPanel();
        inputPanel.add(magicText);
        magicPanel.add(inputPanel);
        holder.add(magicPanel);
        add(holder);

        holder = new JPanel();
        hitpointsPanel = new JPanel(new GridLayout(1,2));;
        hitpointsText = new JTextField("", 3);
        hitpointsText.addKeyListener(new NumberKeyListener());
        setHitpointsText(0);
        textPanel = new JPanel();
        textPanel.add(new JLabel("Hitpoints"));
        hitpointsPanel.add(textPanel);
        inputPanel = new JPanel();
        inputPanel.add(hitpointsText);
        hitpointsPanel.add(inputPanel);
        holder.add(hitpointsPanel);
        add(holder);

    }

    public void setAttackText(int x) {
        attackText.setText(""+x);
    }

    public void setStrengthText(int x) {
        strengthText.setText("" + x);
    }

    public void setDefenceText(int x) {
        defenceText.setText("" + x);
    }

    public void setRangedText(int x) {
        rangedText.setText("" + x);
    }

    public void setMagicText(int x) {
        magicText.setText("" + x);
    }

    public void setHitpointsText(int x) {
        hitpointsText.setText("" + x);
    }
}

class NumberKeyListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        char pressedKey = keyEvent.getKeyChar();
        if(!((pressedKey>= '0') && (pressedKey <= '9') || pressedKey == KeyEvent.VK_BACK_SPACE || pressedKey == KeyEvent.VK_DELETE)){
            keyEvent.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}