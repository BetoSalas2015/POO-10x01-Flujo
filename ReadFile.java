/**
 * Write a description of class ReadFile here.
 * 
 * @author Roberto Salazar Márquez
 * @version 1.1
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ReadFile extends Frame
{
    // instance variables - replace the example below with your own
    private TextArea editor;
    private FileReader entrada;

    /**
     * Constructor for objects of class ReadFile
     */
    public ReadFile() throws IOException
    {
        // initialise instance variables
        super("Lector de Archivos");
        int c;
        editor = new TextArea();
        add(editor, "Center");
        
        try {
            entrada = new FileReader("ReadFile.java");
            
            while( (c = entrada.read()) != -1) 
                editor.append( String.valueOf((char) c ));
        }catch (IOException e) {
              e.printStackTrace(); }
        finally {
            if(entrada != null) 
                entrada.close();
            }
        
        addWindowListener(new CW());
        setSize(350,400);
        setVisible(true);
    }
    
    private class CW extends WindowAdapter
    {
        public void windowClosing(WindowEvent e)
        {
            setVisible(false);
            dispose();
            System.exit(0);
        }
    }

}

