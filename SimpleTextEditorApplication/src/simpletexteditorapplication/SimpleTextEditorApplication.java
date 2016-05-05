package simpletexteditorapplication;

import javax.swing.*;

/**
 * @author Moises Henriquez
 * @date May 1, 2016
 */
public class SimpleTextEditorApplication {

    public static void main(String[] args) {
        //Instatiate new GUI object
        SimpleTextEditorGUI window = new SimpleTextEditorGUI("Simple Text Editor", true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
