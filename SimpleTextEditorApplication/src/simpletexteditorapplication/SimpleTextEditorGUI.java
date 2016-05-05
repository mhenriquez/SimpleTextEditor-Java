package simpletexteditorapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Moises Henriquez
 * @date May 1, 2016
 */
public class SimpleTextEditorGUI extends JFrame implements ItemListener, ActionListener
{
    //Instance variables
    private int[] fontSize = {8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
    private String[] fontType = {"Ariel", "Calibri", "Consolas", "Courier", "System", "Tahoma"};
    
    //JPanel
    private JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
    
    //JMenu
    private JMenuBar mainMenu = new JMenuBar();
    private JMenu fileMenu = new JMenu("File");
    private JMenu helpMenu = new JMenu("Help");
    private JMenuItem open = new JMenuItem("Open");
    private JMenuItem save = new JMenuItem("Save");
    private JMenuItem exit = new JMenuItem("Exit");
    private JMenuItem about = new JMenuItem("About");
    
    //TextArea
    private JTextArea txtArea = new JTextArea("", 5, 25);
    
    //ScroolPane
    private JScrollPane scroll = new JScrollPane(txtArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    
    //Labels
    private JLabel lblFontSize = new JLabel("Font Size:");
    private JLabel lblFontType = new JLabel("Font:");
    private JLabel lblResponse = new JLabel("Status Information");
    
    //ComboBoxes
    private JComboBox<String> cmbFontSize = new JComboBox<>();
    private JComboBox<String> cmbFontType = new JComboBox<>();
    
    //CheckBoxes
    private JCheckBox chkBold = new JCheckBox("Bold", false);
    private JCheckBox chkItalic = new JCheckBox("Italic", false);
    private JCheckBox chkUnderline = new JCheckBox("Underline", false);
    
    public SimpleTextEditorGUI(String title, boolean visible) {
        super(title);
        setSize(500, 370);
        setResizable(false);
        initializeUI();
        setVisible(visible); //<--Must be placed at end to render JFrame components
    }
    
    public void initializeUI() {
        setLayout(new BorderLayout());
        
        //Set panel size
        panel.setPreferredSize(new Dimension(170, 370));
        
        //Font Size
        panel.add(lblFontSize);
        panel.add(cmbFontSize);
        for (int i = 0; i < fontSize.length; i++) {
            cmbFontSize.addItem(String.valueOf(fontSize[i]));
        }
        cmbFontSize.addItemListener(this);
        
        //Font Style
        panel.add(lblFontType);
        panel.add(cmbFontType);
        for (String font : fontType) {
            cmbFontType.addItem(font);
        }
        cmbFontType.addItemListener(this);
        
        //Bold checkbox
        panel.add(chkBold);
        chkBold.addItemListener(this);
        
        //Italic checkbox
        panel.add(chkItalic);
        chkItalic.addItemListener(this);
        
        //Underline checkbox
        panel.add(chkUnderline);
        chkUnderline.addItemListener(this);
        
        //Add elements to frame
        add(scroll);
        add(panel, BorderLayout.EAST);
        add(lblResponse, BorderLayout.SOUTH);
        
        //File Menu components
        fileMenu.add(open);
        open.addActionListener(this);
        fileMenu.add(save);
        save.addActionListener(this);
        fileMenu.addSeparator();
        fileMenu.add(exit);
        exit.addActionListener(this);
        fileMenu.setMnemonic('F');
        mainMenu.add(fileMenu);
        
        //Help Menu components
        helpMenu.add(about);
        about.addActionListener(this);
        helpMenu.setMnemonic('H');
        mainMenu.add(helpMenu);
        //
        setJMenuBar(mainMenu);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Object source = e.getSource();
        int select = e.getStateChange();
        if(source == cmbFontSize){
            if(select == ItemEvent.SELECTED){
                lblResponse.setText("The font size was changed to " + cmbFontSize.getSelectedItem().toString());
            }
        }else if(source == cmbFontType){
            if(select == ItemEvent.SELECTED){
                lblResponse.setText("The font style was changed to " + cmbFontType.getSelectedItem().toString());
            }
        }else if(source == chkBold){
            if(select == ItemEvent.SELECTED){
                lblResponse.setText("Bold was added.");
            }else{
                lblResponse.setText("Bold was removed.");
            }
        }else if(source == chkItalic){
            if(select == ItemEvent.SELECTED){
                lblResponse.setText("Italic was added.");
            }else{
                lblResponse.setText("Italic was removed.");
            }
        }else if(source == chkUnderline){
            if(select == ItemEvent.SELECTED){
                lblResponse.setText("Underline was added.");
            }else{
                lblResponse.setText("Underline was removed.");
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == open){
            lblResponse.setText("The Open option on the menu was selected.");
        }else if(source == save){
            lblResponse.setText("The Save option on the menu was selected.");
        }else if(source == exit){
            System.exit(0);
        }else if(source == about){
            JOptionPane.showMessageDialog(null, "Simple Text Editor \nVersion: 1.0 \nAuthor: Moises Henriquez", "About", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
