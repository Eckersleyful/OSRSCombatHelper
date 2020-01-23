package eckersley.ui.components;

import eckersley.apis.jsonObjects.Item;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CustomComboBox extends JComboBox {

    JComboBox dropDown;

    public CustomComboBox(ArrayList<Item> itemList){
        dropDown = createNew(itemList);

    }

    private JComboBox<Object> createNew(ArrayList<Item> itemList) {
        DefaultComboBoxModel model = new DefaultComboBoxModel<Object>(itemList.toArray());
        JComboBox<Object> newComboBox = new JComboBox<>(model);
        newComboBox.setRenderer(new ItemRenderer());
        return newComboBox;

    }
    public JComboBox getDropDown(){
        return dropDown;
    }
}

class ItemRenderer extends DefaultListCellRenderer {
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus){
        JLabel label = (JLabel)super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if(value != null && value instanceof Item){
            Item item = (Item) value;
            label.setText(item.getItemName());

            if(isSelected){
                label.setBackground(Color.blue);
                label.setForeground(Color.white);
            }
            else{
                label.setBackground(Color.white);
                label.setForeground(Color.black);
            }
        }

        return label;
    }
}
