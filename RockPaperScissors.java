/*
 * Purpose: to play Rock Paper Scissors with a computer.
 *
 * Author: Mantsory
 * Version: 1.1.1
 */

import java.util.Scanner;

public class RockPaperScissors {

    //Declares constants
    public static final String WIN_MSG = "You won the game!"; //declares the message if you win
    public static final String LOS_MSG = "You lost the game! Maybe you have better luck next time."; //declares the message if you lose
    public static final String TIE_MSG = "The game was a tie!"; //declares the message if it's a tie

    public static void error() {
        System.out.println("Something went wrong. Exiting program...");
        System.exit(1);
    }//end of error

    public static String getPlayerChoice() {

        Scanner input = new Scanner(System.in);

        String playerInput = input.next();
        String playerInputChar = playerInput.substring(0,1);
        playerInputChar = playerInputChar.toUpperCase();
        String overflow = input.nextLine();
        switch (playerInputChar) {
            case "R":
                return "rock";
            case "P":
                return "paper";
            case "S":
                return "scissors";
            default:
                System.out.println("You input a improper input. Exiting program...");
                System.exit(1);
                return null;
        }
    } //end of getPlayerChoice

    public static String getCompChoice() {

        //Determines the computers choice
        int randInt = (int) (Math.random() * 3) + 1;
        switch (randInt) {
            case 1:
                return "rock";
            case 2:
                return "paper";
            case 3:
                return "scissors";
            default:
                error();
                return null;

        }
    }//end of getCompChoice

    public static String getGameResult(String choice, String compChoice) {

        Scanner input = new Scanner(System.in);

        String gameResult;

        switch (choice) {
            case "rock":
                switch (compChoice) {
                    case "rock":
                        return TIE_MSG;
                    case "paper":
                        return LOS_MSG;
                    case "scissors":
                        return WIN_MSG;
                    default:
                        error();
                        return null;
                }
            case "paper":
                switch (compChoice) {
                    case "rock":
                        return WIN_MSG;
                    case "paper":
                        return TIE_MSG;
                    case "scissors":
                        return LOS_MSG;
                    default:
                        error();
                        return null;
                }
            case "scissors":
                switch (compChoice) {
                    case "rock":
                        return LOS_MSG;
                    case "paper":
                        return WIN_MSG;
                    case "scissors":
                        return TIE_MSG;
                    default:
                        error();
                        return null;
                }
            default:
                error();
                return null;
        }
    } //end of getGameResult


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        boolean gameActive = true;
        while (gameActive){
            System.out.println("Welcome to Rock Paper Scissors!");
            System.out.println("Please type in '[R]ock', '[P]aper', or '[S]cissors' to play.\n");

            String choice = getPlayerChoice();
            String compChoice = getCompChoice();
            String gameResult = getGameResult(choice, compChoice);

            System.out.println("You selected: " + choice);
            System.out.println("The computer selected: " + compChoice);
            System.out.println(gameResult);
            System.out.println("Would you like to play again?");
            System.out.println("[YES/NO]");

            String again = input.next();
            String overflow = input.nextLine(); //removes any extra text

            String againChar = again.substring(0,1);
            if (againChar.equalsIgnoreCase("y")) {
                System.out.println("PLaying again!");
            }
            else {
                System.out.println("You ended the game. Exiting program...");
                gameActive = false;
            }
        } //end of while loop
    } //end of main
}