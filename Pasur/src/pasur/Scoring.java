package pasur;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class Scoring implements IScoreStrategy, PropertyChangeListener {
    private PropertyChangeSupport propertyPublisher = new PropertyChangeSupport(this);
    

}




