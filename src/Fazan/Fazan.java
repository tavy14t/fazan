package Fazan;
import java.io.*;
import javax.swing.*;

/**
 *
 * @author Tavy
 */
public class Fazan {

    
    public static void main(String[] args) throws FileNotFoundException {
   
        
       SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                GUI go = new GUI();

            }
        });
        }
}
