package pasur;



public class ScoreStrategy implements IScoreStrategy{


    @Override
    public void updatePlayerScore(Player[] players) {
        for(int i = 0; i < players.length; i++){
            int clubCount = 0;
            Player p = players[i];
            System.out.println(clubCount);
            System.out.println("HAND CHECK: "+ p.getPickedCards());
            System.out.println("SURCHEECK: "+ p.getSurs());



            for(int j = 0; j < p.getPickedCards().getNumberOfCards(); j++){
                System.out.println("num: " + p.getPickedCards().get(j).getValue());
                if(p.getPickedCards().get(j).getValue() == 1 || p.getPickedCards().get(j).getValue() == 11){
                    p.score++;
                    System.out.println("ACEJACK");
                    continue;
//                    if (p.getPickedCards().get(j).getSuit() != Suit.CLUBS){
//                        p.pickedCards.remove(j, false);
//                    }



                }
                if(p.getPickedCards().get(j).getSuit() == Suit.CLUBS && p.getPickedCards().get(j).getValue() == 2){
                    clubCount++;

                    System.out.println("CLUB2");
                    p.score += 2;

                    continue;
                }
                else if(p.getPickedCards().get(j).getSuit() == Suit.CLUBS){
                    clubCount++;

                    System.out.println("CLUB");
                    continue;
                }
                if(p.getPickedCards().get(j).getSuit() == Suit.DIAMONDS && p.getPickedCards().get(j).getValue() == 10){
                    p.score += 3;
//                    p.pickedCards.remove(j, false);

                    System.out.println("DIAM");
                    continue;
                }
            }
//            for(int j = 0; j < players[i].getSurs().getNumberOfCards(); j++){
//                if(p.getSurs().get(j).getValue() == 1 || p.getSurs().get(j).getValue() == 11){
//                    p.score++;
//                    System.out.println("SIR1");
//                    continue;
//                }
//                if(p.getSurs().get(j).getSuit() == Suit.CLUBS && p.getSurs().get(j).getValue() == 2){
//                    clubCount++;
//                    System.out.println("SIR2");
//                    p.score += 2;
//                    continue;
//                }
//                else if(p.getSurs().get(j).getSuit() == Suit.CLUBS){
//                    clubCount++;
//                    System.out.println("SIR3");
//                    continue;
//                }
//                if(p.getSurs().get(j).getSuit() == Suit.DIAMONDS && p.getSurs().get(j).getValue() == 10){
//                    p.score += 3;
//                    System.out.println("SIR4");
//                    continue;
//                }
//            }
            System.out.println("c: "+ clubCount);
            if(clubCount >= 7){
                p.score += 7;
                clubCount = 0;
                for(int j = 0; j < p.getPickedCards().getNumberOfCards(); j++){
                    if (p.getPickedCards().get(j).getSuit() == Suit.CLUBS){
                        p.pickedCards.remove(j, true);
                    }
                }


            }
            System.out.println("sur:  " + p.getSurs().getNumberOfCards());

            for(int j = 0; j < p.getPickedCards().getNumberOfCards(); j++){
                if (p.getPickedCards().get(j).getSuit() != Suit.CLUBS){
                    p.pickedCards.remove(j, true);
                }
            }
        }

    }
}
