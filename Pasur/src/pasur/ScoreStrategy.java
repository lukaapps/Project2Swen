package pasur;



public class ScoreStrategy implements IScoreStrategy{


    @Override
    public void updatePlayerScore(Player[] players) {
        for(int i = 0; i < players.length; i++){
            int clubCount = 0;
            Player p = players[i];



            for(int j = 0; j < players[i].getPickedCards().getNumberOfCards(); j++){
                if(p.getPickedCards().get(j).getCardNumber() == 1 || p.getPickedCards().get(j).getCardNumber() == 11){
                    p.score++;
                }
                if(p.getPickedCards().get(j).getSuit() == Suit.CLUBS && p.getPickedCards().get(j).getCardNumber() == 2){
                    clubCount++;
                    p.score += 2;
                }
                else if(p.getPickedCards().get(j).getSuit() == Suit.CLUBS){
                    clubCount++;
                }
                if(p.getPickedCards().get(j).getSuit() == Suit.DIAMONDS && p.getPickedCards().get(j).getCardNumber() == 10){
                    p.score += 3;
                }
            }
            for(int j = 0; j < players[i].getSurs().getNumberOfCards(); j++){
                if(p.getSurs().get(j).getCardNumber() == 1 || p.getSurs().get(j).getCardNumber() == 11){
                    p.score++;
                }
                if(p.getSurs().get(j).getSuit() == Suit.CLUBS && p.getSurs().get(j).getCardNumber() == 2){
                    clubCount++;
                    p.score += 2;
                }
                else if(p.getSurs().get(j).getSuit() == Suit.CLUBS){
                    clubCount++;
                }
                if(p.getSurs().get(j).getSuit() == Suit.DIAMONDS && p.getSurs().get(j).getCardNumber() == 10){
                    p.score += 3;
                }
            }
            if(clubCount >= 7){
                p.score += 7;
            }
            p.score += p.getSurs().getNumberOfCards() * 5;
        }

    }
}
