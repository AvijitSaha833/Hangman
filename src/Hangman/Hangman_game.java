package Hangman;

import java.io.IOException;
import java.util.Scanner;

public class Hangman_game {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("Do you dare to play this game !! " +"\nPress enter key to Start the game :");
		sc.nextLine();
		boolean wanttoplaygame= true;
		while(wanttoplaygame) {
			Hangman game= new Hangman();
			//String word=game.word; // for bug fixing
			System.out.println("Guess the currect word :-");
			game.showhangman(0);
			while(!game.gameover()) {
				System.out.println("pick one letter :");
				game.check(sc.next().toLowerCase().charAt(0));
			}
//			System.out.println(game.rightguess.toString());
//			System.out.println(game.wrongguess.toString());
			if(game.maxtry==game.currenttry) {
				System.out.println("Ha! Ha! Ha! I know you can't beat me, LOOSER !!!!");
			}
			else {
				System.out.println("Congratulations!! you won the game ..");
			}
			System.out.println("\n"+ "Do you dare to play this game againg !!\n"+"Press:- \n   Y to accept my Challenge \n"+"\n   N if you are afraid of me" );
			System.out.println();
			char c=sc.next().toUpperCase().charAt(0);
			if(c=='Y') {
				System.out.println("Let's Begin The Game :-\n");
				wanttoplaygame=true;
			}else {
				wanttoplaygame=false;
			}
		}
		

	}


}
