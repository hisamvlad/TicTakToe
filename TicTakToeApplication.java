package PetProjects.TikTakToe;

import java.util.Scanner;

public class TicTakToeApplication {

    public static void main(String[] args) {
        // GEtting input
        Scanner scr = new Scanner(System.in);
            //Allows for cont. games
            boolean doYouWantToPlay = true;
            while(doYouWantToPlay) {
                //Setting up our tokens and AI
                System.out.println("Welcome to Tic Tak Toe\n Select your character");
                System.out.println("Enter a single character of your choice");
                char playerToken = scr.next().charAt(0);
                System.out.println("Enter a single character for your AI opponent");
                char aiMarker = scr.next().charAt(0);
                TicTakToe game = new TicTakToe(playerToken, aiMarker);
                AI ai = new AI();

                // Set up the game
                System.out.println();
                System.out.println("Let's start the game! " +
                        "To play, enter a number 1-9 to place your token into the position" +
                        "on the board");
                TicTakToe.printIndexBoard();
                System.out.println();
                //Let's play
                while (game.gameOver().equals("Game is not yet over")) {
                    if(game.currentMarker == game.userMarker) {
                        //User turn
                        System.out.println("It's your turn. Enter a spot for your token");
                        int spot = scr.nextInt();
                        while(!game.playTurn(spot)) {
                            System.out.println("Try again. + " + spot + "is invalid." +
                                    "This spot is already taken" +
                                    " or it is out of range");
                            spot = scr.nextInt();
                        }
                        System.out.println("you picked " + spot + "!");
                    } else {
                        //AI turn
                        System.out.println("It's my turn!");
                        // Pick spot
                        int aiSpot = ai.pickSpot(game);
                        game.playTurn(aiSpot);
                        System.out.println("AI picked " + aiSpot + "!");
                    }
                    // Print out new board
                    System.out.println();
                    game.printBoard();
                }
                System.out.println(game.gameOver());
                System.out.println();
                // Set up a new game.. or quit the program
                System.out.println("Put 'Y' if you want another game " +
                        " or press any other key to exit");
                char userResponse = scr.next().charAt(0);
                doYouWantToPlay = (Character.toUpperCase(userResponse) == 'Y');
                System.out.println();
                System.out.println();

            }

        }
    }

