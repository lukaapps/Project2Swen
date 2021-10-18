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
            ArrayList<Card> currSurs = player.getSurs().getCardList();
            ArrayList<Card> currPicked = player.getPickedCards().getCardList();

            int currSurScore = currSurs.size()*5;
            int eachAceScore = 0;
            int eachJackScore = 0;
            int tenOfDiamond = 0;
            int twoOfClub = 0;
            int clubsCount = 0;

            currPicked.addAll(currSurs);

            Set<Card> set = new HashSet<Card>(currPicked);
            currPicked.clear();
            currPicked.addAll(set);

            for (Card card: currPicked){
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








//
//for(int i = 0; i < players.length; i++){
//        Player p = players[i];

//            ArrayList<Card> currSurs = player.getSurs().getCardList();
//            ArrayList<Card> currPicked = player.getPickedCards().getCardList();
//            int currSurScore = currSurs.size()*5;
//            int eachAceScore = 0;
//            int eachJackScore = 0;
//            int tenOfDiamond = 0;
//            int twoOfClub = 0;
//            int clubsCount = 0;
//
//            currPicked.add
//        int totalScore = 0;
//
//
//        for(int j = 0; j < p.getPickedCards().getCardList().size(); j++){
//        System.out.println("num: " + p.getPickedCards().get(j).getValue());
//        if(p.getPickedCards().get(j).getValue() == 1 || p.getPickedCards().get(j).getValue() == 11){
////                    p.score++;
//        totalScore++;
//
//        }
//        if(p.getPickedCards().get(j).getSuit() == Suit.CLUBS && p.getPickedCards().get(j).getValue() == 2){
//        p.clubCount++;
////                    p.score += 2;
//        totalScore+=2;
//
//        }
//        else if(p.getPickedCards().get(j).getSuit() == Suit.CLUBS){
////                    p.clubCount++;
//
//        }
//        if(p.getPickedCards().get(j).getSuit() == Suit.DIAMONDS && p.getPickedCards().get(j).getValue() == 10){
////                    p.score += 3;
//        totalScore += 3;
//        }
//
//
//        }
//        for(int j = 0; j < players[i].getSurs().getNumberOfCards(); j++){
//        if(p.getSurs().get(j).getValue() == 1 || p.getSurs().get(j).getValue() == 11){
////                    p.score++;
//        totalScore++;
//        }
//        if(p.getSurs().get(j).getSuit() == Suit.CLUBS && p.getSurs().get(j).getValue() == 2){
//        p.clubCount++;
////                    p.score += 2;
//        totalScore++;
//        }
//        else if(p.getSurs().get(j).getSuit() == Suit.CLUBS){
//        p.clubCount++;
//        }
//        if(p.getSurs().get(j).getSuit() == Suit.DIAMONDS && p.getSurs().get(j).getValue() == 10){
////                    p.score += 3;
//        totalScore += 3;
//        }
//        }
//
//        System.out.println("c: "+ p.clubCount);
//        if(p.clubCount >= 7){
////                p.score += 7;
//        totalScore +=7;
//        p.clubCount = 0;
//        }
//
//        int check = p.getScore();
//        int h = Math.max(totalScore - check, 0);
//        System.out.println("AFD" + h);
//        p.score += h;
//
//        }