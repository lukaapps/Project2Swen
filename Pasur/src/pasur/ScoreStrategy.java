package pasur;


import ch.aplu.jcardgame.Card;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ScoreStrategy implements IScoreStrategy, PropertyChangeListener {


    @Override
    public void updatePlayerScore(Player[] players) {
        for(int i = 0; i < players.length; i++){
            Player player = players[i];
            ArrayList<Card> currentS = player.getSurs().getCardList();
            ArrayList<Card> currentP = player.getPickedCards().getCardList();

            int surScore = currentS.size()*5;
            int clubsCount = 0;
            int totalScore = 0;

            currentP.addAll(currentS);

            Set<Card> set = new HashSet<Card>(currentP);
            currentP.clear();
            currentP.addAll(set);

            for (Card card: currentP){
                if(card.getRank().equals(Rank.ACE)){
                    totalScore++;
                }
                if(card.getRank().equals(Rank.JACK)){
                    totalScore++;
                }
                if(card.getSuit().equals(Suit.DIAMONDS) && card.getRank().equals(Rank.TEN)){
                    totalScore += 3;
                }
                if(card.getSuit().equals(Suit.CLUBS) && card.getRank().equals(Rank.TWO)) {
                    totalScore +=2;
                }
                if(card.getSuit().equals(Suit.CLUBS)){
                    clubsCount++;
                }

            }

            int sevenOrMoreScore = clubsCount >= 7 ? 7:0;


            totalScore = totalScore + sevenOrMoreScore + surScore;
            player.score = player.score + Math.max(totalScore - player.roundPoints,0);
            player.setRoundPoints(totalScore);



        }



    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }
}