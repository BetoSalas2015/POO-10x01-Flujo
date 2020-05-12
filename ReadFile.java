/**
 * Write a description of class ReadFile here.
 * 
 * @author Roberto Salazar Márquez
 * @version 2.0
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ReadFile extends Frame
{
    // instance variables - replace the example below with your own
    private TextArea editor;
    private DataInputStream entrada;
    private DataOutputStream salida;
    
    private String nombres[] = {"Juan", "Andrés", "Sandra"};
    private String apellidos[] = {"López", "Pérez", "Sánchez"};
    private int edades[] = {35,  27, 25};

    /**
     * Constructor for objects of class ReadFile
     */
    public ReadFile() throws IOException
    {
        // initialise instance variables
        super("Lector de Archivos");
        String c;
        editor = new TextArea();
        add(editor, "Center");
        
        try {
            salida = new DataOutputStream(
                     new BufferedOutputStream(
                     new FileOutputStream("agenda.dat")));
            
            for(int i = 0; i < 3; ++i) {
                salida.writeUTF(nombres[i]);
                salida.writeUTF(apellidos[i]);
                salida.writeInt(edades[i]);
            }
        }catch (IOException e) {
              e.printStackTrace(); }
        finally {
            if(salida != null) 
                salida.close();
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

