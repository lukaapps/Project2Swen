package pasur;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public abstract class Scoring implements IScoreStrategy, PropertyChangeListener {
    public static final String ON_CARD_TRANSFER = "onCardTransfer";
    public static final String ON_UPDATE_SCORE = "updateScore";
    private PropertyChangeSupport propertyPublisher = new PropertyChangeSupport(this);



}




