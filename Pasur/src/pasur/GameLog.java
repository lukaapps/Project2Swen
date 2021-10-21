package pasur;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.*;


public class GameLog implements PropertyChangeListener {
    BufferedWriter writer;




    public GameLog() {

    }

    public void writeToLog(String s) throws IOException {

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




    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}

