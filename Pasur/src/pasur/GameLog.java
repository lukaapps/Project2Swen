package pasur;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.*;


public class GameLog implements PropertyChangeListener {
    FileHandler file;
    Logger logger = Logger.getLogger("Log");
    BufferedWriter writer;

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public GameLog(){
        pcs.addPropertyChangeListener(this);

    }

    public void writeToLog(String s) throws IOException {
//        try {
//            file = new FileHandler("pasur.log", true);
//            logger.addHandler(file);
//            SimpleFormatter formatter = new SimpleFormatter();
//            file.setFormatter(formatter);
//            logger.setUseParentHandlers(false);
//            logger.info(s);
//            file.close();
//
//
//        }
//
//        catch(IOException e){
//            e.printStackTrace();
//        }
//        catch(SecurityException e){
//            e.printStackTrace();
//        }
        try {
            writer = new BufferedWriter(new FileWriter("pasur.log", true));
            writer.write(s);
            writer.newLine();
            writer.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("EVT" + evt.getSource());
        System.out.println("EVT");
    }
}

