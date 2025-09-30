/*
 * Purpose: to play Rock Paper Scissors with a computer.
 *
 * Author: Mantsory
 * Version: 1.0
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

        String playerChoice;

        String playerInput = input.next();
        String playerInputChar = playerInput.substring(0,1);
        playerInputChar = playerInputChar.toUpperCase();
        String overflow = input.nextLine();
        switch (playerInputChar) {
            case "R":
                playerChoice = "rock";
                break;
            case "P":
                playerChoice = "paper";
                break;
            case "S":
                playerChoice = "scissors";
                break;
            default:
                playerChoice = null;
                System.out.println("You input a improper input. Exiting program...");
                System.exit(1);
        }
        return playerChoice;
    } //end of getPlayerChoice

    public static String getCompChoice() {

        String compChoice; //this will be the computers choice

        //Determines the computers choice
        int randInt = (int) (Math.random() * 3) + 1;
        switch (randInt) {
            case 1:
                compChoice = "rock";
                break;
            case 2:
                compChoice = "paper";
                break;
            case 3:
                compChoice = "scissors";
                break;
            default:
                compChoice = null;
                error();

        }
        return compChoice;
    }//end of getCompChoice

    public static String getGameResult(String choice, String compChoice) {

        Scanner input = new Scanner(System.in);

        String gameResult;

        switch (choice) {
            case "rock":
                switch (compChoice) {
                    case "rock":
                        gameResult = TIE_MSG;
                        break;
                    case "paper":
                        gameResult = LOS_MSG;
                        break;
                    case "scissors":
                        gameResult = WIN_MSG;
                        break;
                    default:
                        gameResult = null;
                        error();
                }
            break;
            case "paper":
                switch (compChoice) {
                    case "rock":
                        gameResult = WIN_MSG;
                        break;
                    case "paper":
                        gameResult = TIE_MSG;
                        break;
                    case "scissors":
                        gameResult = LOS_MSG;
                        break;
                    default:
                        gameResult = null;
                        error();
                }
            break;
            case "scissors":
                switch (compChoice) {
                    case "rock":
                        gameResult = LOS_MSG;
                        break;
                    case "paper":
                        gameResult = WIN_MSG;
                        break;
                    case "scissors":
                        gameResult = TIE_MSG;
                        break;
                    default:
                        gameResult = null;
                        error();
                }
            break;
            default:
                gameResult = null;
                error();
        }
        return gameResult;
    } //end of getGameResult


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        boolean gameActive = true;
        while (gameActive){
            System.out.println("Welcome to Rock Paper Scissors!");
            System.out.println("Please type in 'R', 'P', or 'S' to play.\n");

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

            if (again.equalsIgnoreCase("yes")) {
                System.out.println("PLaying again!");
            }
            else {
                System.out.println("You ended the game. Exiting program...");
                gameActive = false;
            }
        } //end of while loop
    } //end of main
}