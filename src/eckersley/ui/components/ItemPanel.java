package eckersley.ui.components;

import eckersley.entities.Constants;
import eckersley.ui.UIData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

public class ItemPanel extends JPanel {
        //List of all the dropdowns
        ArrayList<JComboBox> dropDowns;
        //Panel for holding all the dropdowns
        JPanel dropDownPanel;

        //Panel for holding the
        public ItemPanel(int rows, int cols, UIData data){
                dropDowns = new ArrayList<>();
                dropDownPanel = new JPanel();
                
                addComponents(data);
        }

        private void addComponents(UIData data) {
                for(String slot : Constants.EQUIPMENT_SLOTS){

                        JPanel panel = new JPanel(new GridLayout(2,1));
                        JLabel textLabel = new JLabel(slot);

                        CustomComboBox newBox = new CustomComboBox(data.getItemBySlot(slot));
                        panel.add(textLabel);
                        panel.add(newBox);
                        dropDownPanel.add(panel);
//                        dropDowns.add(newBox.getDropDown());

                }
                add(dropDownPanel);

        }
}
