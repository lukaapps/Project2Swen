package pasur;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class Scoring implements IScoreStrategy, PropertyChangeListener {
    public static final String ON_CARD_TRANSFER = "onCardTransfer";
    public static final String ON_UPDATE_SCORE = "updateScore";
    private PropertyChangeSupport propertyPublisher = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener){
        this.propertyPublisher.addPropertyChangeListener(listener);

    }
    public void removePropertyChangeListener(PropertyChangeListener listener){
        this.propertyPublisher.removePropertyChangeListener(listener);
    }



    public void setValue(String scoreString){
        this.propertyPublisher.firePropertyChange(ON_UPDATE_SCORE, null, scoreString);
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt){}
    @Override
    public void updatePlayerScore(Player[] players) {}
}




