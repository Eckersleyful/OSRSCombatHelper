package eckersley.ui.components;

import eckersley.apis.HTTPClient;
import eckersley.entities.ItemConstants;
import eckersley.ui.UIData;
import javafx.scene.control.ComboBox;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class CustomMainFrame extends JFrame {

    JPanel mainPanel;
    JPanel splitPanel;
    UIData data;
    HashMap<String , CustomComboBox> dropDowns = new HashMap<>();
    public CustomMainFrame(){
        data = new UIData();
        setMinimumSize(new Dimension(1280,720));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addComponents();
        start();
    }
    private void start(){
        this.pack();
        this.setVisible(true);
    }
    private void addComponents(){
        mainPanel = new JPanel(new GridLayout(1,2));
        splitPanel = new JPanel();
        //splitPanel.add(new CustomPanel(data));
        for(String slot : ItemConstants.EQUIPMENT_SLOTS){
            JPanel panel = new JPanel(new GridLayout(2,1));
            JLabel textLabel = new JLabel(slot);
            //holder.add(slotText);

            CustomComboBox newBox = new CustomComboBox(data.getItemBySlot(slot));
            //newBox.setMaximumSize(new Dimension(40,40));
            panel.add(textLabel);
            panel.add(newBox.getDropDown());
            splitPanel.add(panel);
            dropDowns.put(slot, newBox);
        }
        mainPanel.add(splitPanel);
        //splitPanel.add(new CustomPanel());
        add(mainPanel);


    }


}
