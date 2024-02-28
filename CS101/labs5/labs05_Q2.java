/*
 * Student Name: Mehmet Efe Mutlu
 * Student ID: 22303326
 * This program plays a card game called 'Pişti'
 */
import java.util.Random;

public class labs05_Q2
{
    public static void main(String[] args) 
    {
        Random random = new Random(); //First we call Random class

        String deck = "";

        for(int i=1; i<=9; i++) //These two for iterations is for defining deck correctly
        { 
            for(int m=1; m<=4; m++){  //This one prints numbers 1-9 four times row
                deck += i;
            } 
        }

        String str = "TJQK";
        for(int i=0; i<=3; i++)
        {   
            for(int m=1; m<=4; m++){   //This one prints "TJQK" string four times row
                deck = deck + str.substring(i,i+1);
            }  
        }
        System.out.println("Starting the game with the following deck:");
        System.out.println(deck);

        String shuffled = "";

        for(int j=0; j<52; j++)  //This iteration is to shuffle deck with using substring method
        {
            int chosen = random.nextInt(deck.length());
            shuffled = shuffled + deck.substring(chosen,chosen+1);
            deck = deck.substring(0,chosen) + deck.substring(chosen+1,deck.length());
        }
        System.out.println("Let's shuffle the deck:");
        System.out.println(shuffled + '\n');

        //We put first four cards on deck
        String cardsOnTable = "";
        cardsOnTable += shuffled.substring(0,4);
        System.out.println("Put first four cards on table..." + '\n' + cardsOnTable + '\n');
        shuffled = shuffled.replace(shuffled.substring(0, 4),"");

        //We define point variables for each player
        int pointsOne = 0;
        int pointsTwo = 0;
        int pointsThree = 0;
        int pointsFour = 0;
        
        for(int i=1; i<=3; i++) //There are 3 rounds so we will iterate the game three times
        {
            System.out.println("Game Round#" +i);

            int d = 0;
            for(int m=1; m<=4; m++)  //We print player's hands at each round
            {
                System.out.printf(" %10s %s %2s %2s \n", "Player" , m , ": " ,shuffled.substring(d, d+4));
                d = d+4;
            }
            System.out.println();

            //We initialize the starter cards of players
            String player1 = shuffled.substring(0, 4);
            String player2 = shuffled.substring(4,8);
            String player3 = shuffled.substring(8,12);
            String player4 = shuffled.substring(12, 16);
            
            shuffled = shuffled.replace(shuffled.substring(0,16),""); //Then we remove it from the deck

            for(int j=1; j<=4; j++) //At each round there should be four times that each player plays his/her turn
            {          
                boolean found = false; //We define a flag so when we found the matching card we should be able to quit the iteration
                int card = 0;
                do{
                    if(cardsOnTable.length()>0){
                        //We check the cards of players if there is any matching cards on the table
                        if(player1.charAt(card) == cardsOnTable.charAt(0)){
                            found = true;
                        }
                        else{
                            card++;
                        }
                    }
                    else{
                        found = false;
                    }
                }
                while(card<=player1.length()-1 && !found);
 
                if(found){ //If there is a match, player plays that card and fishes all the cards on the table
                    pointsOne += cardsOnTable.length();
                    cardsOnTable = " ";
                    System.out.println("Player1 hand " + player1 + " -> played: " + player1.charAt(card) + " current hand: " + player1.substring(0,card) + player1.substring(card+1,player1.length()) + " --Cards on table: " + cardsOnTable);
                    player1 = player1.substring(0,card) + player1.substring(card+1,player1.length());
                }

                else{ //If not player plays a random card and adds it to the cards on the table
                    int randomCard = random.nextInt(card);
                    cardsOnTable = player1.charAt(randomCard) + cardsOnTable;
                    System.out.println("Player1 hand " + player1 + " -> played: " + player1.charAt(randomCard) + " current hand: " + player1.substring(0,randomCard) + player1.substring(randomCard+1,player1.length()) + " --Cards on table: " + cardsOnTable);
                    player1 = player1.substring(0,randomCard) + player1.substring(randomCard+1,player1.length());
                }  
                found = false;
                card = 0;

                do{
                    if(cardsOnTable.length()>0){
                        if(player2.charAt(card) == cardsOnTable.charAt(0)){
                            found = true;
                        }
                        else{
                            card++;
                        }
                    }
                    else{
                        found = false;
                    }
                }
                while(card<=player2.length()-1 && !found);

                if(found){
                    pointsTwo += cardsOnTable.length();
                    cardsOnTable = " ";
                    System.out.println("Player2 hand " + player2 + " -> played: " + player2.charAt(card) + " current hand: " + player2.substring(0,card) + player2.substring(card+1,player2.length()) + " --Cards on table: " + cardsOnTable);
                    player2 = player2.substring(0,card) + player2.substring(card+1,player2.length());
                }
                else{
                    int randomCard = random.nextInt(card);
                    cardsOnTable = player2.charAt(randomCard) + cardsOnTable;
                    System.out.println("Player2 hand " + player2 + " -> played: " + player2.charAt(randomCard) + " current hand: " + player2.substring(0,randomCard) + player2.substring(randomCard+1,player2.length()) + " --Cards on table: " + cardsOnTable);
                    player2 = player2.substring(0,randomCard) + player2.substring(randomCard+1,player2.length());
                }
                found = false;
                card = 0;

                do{
                    if(cardsOnTable.length()>0){
                        if(player3.charAt(card) == cardsOnTable.charAt(0)){
                            found = true;
                        }
                        else{
                            card++;
                        }
                    }
                    else{
                        found = false;
                    }       

                }
                while(card<=player3.length()-1 && !found);

                if(found){
                    pointsThree += cardsOnTable.length();
                    cardsOnTable = " ";
                    System.out.println("Player3 hand " + player3 + " -> played: " + player3.charAt(card) + " current hand: " + player3.substring(0,card) + player3.substring(card+1,player3.length()) + " --Cards on table: " + cardsOnTable);
                    player3 = player3.substring(0,card) + player3.substring(card+1,player3.length());


                }
                else{
                    int randomCard = random.nextInt(card);
                    cardsOnTable = player3.charAt(randomCard) + cardsOnTable;
                    System.out.println("Player3 hand " + player3 + " -> played: " + player3.charAt(randomCard) + " current hand: " + player3.substring(0,randomCard) + player3.substring(randomCard+1,player3.length()) + " --Cards on table: " + cardsOnTable);
                    player3 = player3.substring(0,randomCard) + player3.substring(randomCard+1,player3.length());
                }
                found = false;
                card = 0;

                do{
                    if(cardsOnTable.length()>0){
                        if(player4.charAt(card) == cardsOnTable.charAt(0)){
                            found = true;
                        }
                        else{
                            card++;
                        }
                    }
                    else{
                        found = false;
                    }    
                }
                while(card<=player4.length()-1 && !found);

                if(found){
                    pointsFour += cardsOnTable.length();
                    cardsOnTable = " ";
                    System.out.println("Player4 hand " + player4 + " -> played: " + player4.charAt(card) + " current hand: " + player4.substring(0,card) + player4.substring(card+1,player4.length()) + " --Cards on table: " + cardsOnTable);
                    player4 = player4.substring(0,card) + player4.substring(card+1,player4.length());

                }
                else{
                    int randomCard = random.nextInt(card);
                    cardsOnTable = player4.charAt(randomCard) + cardsOnTable;
                    System.out.println("Player4 hand " + player4 + " -> played: " + player4.charAt(randomCard) + " current hand: " + player4.substring(0,randomCard) + player4.substring(randomCard+1,player4.length()) + " --Cards on table: " + cardsOnTable);
                    player4 = player4.substring(0,randomCard) + player4.substring(randomCard+1,player4.length());
                }

                //At the end of each round program prints the points
                System.out.print("Points *** " );  
                System.out.println("Player1: " + pointsOne + " Player2: " + pointsTwo + " Player3: " + pointsThree + " Player4: " + pointsFour + " *** " + '\n' );     
            }
            System.out.println();
        }

        //At the end of the game total points and the remaining cards are shown
        System.out.println("Total Points: "); 
        System.out.println("Player1: " + pointsOne + '\n' + "Player2: "+ pointsTwo + '\n' + "Player3: " + pointsThree + '\n' + "Player4: " + pointsFour);
        System.out.println("Number of cards on table: " + (cardsOnTable.length()) + '\n');
        
        //Finally we decide the winner by checking player's points
        int winner = Math.max(Math.max(Math.max(pointsOne,pointsTwo),pointsThree),pointsFour); 

        if(winner==pointsOne) {
            System.out.println("**** Player1 Wins! ****");
        }
        else if(winner==pointsTwo) {
            System.out.println("**** Player2 Wins! ****");
        }
        else if(winner==pointsThree) {
            System.out.println("**** Player3 Wins! ****");
        }
        else {
            System.out.println("**** Player4 Wins! ****");
        }         
    }   
}