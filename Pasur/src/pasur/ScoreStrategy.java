package pasur;


import ch.aplu.jcardgame.Card;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ScoreStrategy implements IScoreStrategy{


    @Override
    public void updatePlayerScore(Player[] players) {
        for(int i = 0; i < players.length; i++){
            Player player = players[i];
            ArrayList<Card> currentS = player.getSurs().getCardList();
            ArrayList<Card> currentP = player.getPickedCards().getCardList();

            int currSurScore = currentS.size()*5;
            int eachAceScore = 0;
            int eachJackScore = 0;
            int tenOfDiamond = 0;
            int twoOfClub = 0;
            int clubsCount = 0;

            currentP.addAll(currentS);

            Set<Card> set = new HashSet<Card>(currentP);
            currentP.clear();
            currentP.addAll(set);

            for (Card card: currentP){
                if(card.getRank().toString().equals("ACE")){
                    eachAceScore++;
                }
                if(card.getRank().toString().equals("JACK")){
                    eachJackScore++;
                }
                if(card.getSuit().toString().equals("DIAMONDS") && card.getRank().toString().equals("TEN")){
                    tenOfDiamond += 3;
                }
                if(card.getSuit().toString().equals("CLUBS") && card.getRank().toString().equals("TWO")) {
                    twoOfClub +=2;
                }
                if(card.getSuit().toString().equals("CLUBS")){
                    clubsCount++;
                }

            }

            int sevenOrMoreScore = clubsCount >= 7 ? 7:0;

            int totalScore = currSurScore + eachAceScore + eachJackScore + tenOfDiamond + twoOfClub + sevenOrMoreScore;


            player.score = player.score + Math.max(totalScore - player.roundScore,0);
            player.setRoundScore(totalScore);



        }



    }
}