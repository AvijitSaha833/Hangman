package Hangman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Hangman {
	String word;
	StringBuilder currentguess;
	ArrayList<String> wrongguess= new ArrayList<>();
	ArrayList<String> rightguess= new ArrayList<>();
	
	FileReader read;
	BufferedReader input;
	ArrayList <String>dictionary= new ArrayList<>();
	int maxtry=6;
	int currenttry=0;
	public Hangman()throws IOException {
		try{
			File file =new File("Hangman_Dictionary.txt");
			read=  new FileReader(file);
			input=new BufferedReader(read);
			word=input.readLine();
			while(word!=null) {
				dictionary.add(word);
				word=input.readLine();
			}
		}catch(IOException e){
			System.out.println("there is a problem in input");
		}
		read.close();
		input.close();
		word=pickword();
		currentguess=blankline();
	}
	private String pickword() {
		// TODO Auto-generated method stub
		Random rand =new Random();
		String word=dictionary.get(rand.nextInt(dictionary.size()));
		return word;
	}
	private StringBuilder blankline() {
		// TODO Auto-generated method stub
		StringBuilder initial =new StringBuilder();
		for(int i=0;i<word.length()*2;i++) {
			if(i%2==0) {
				initial.append("_");	
			}else {
				initial.append(" ");
			}
		}
		return initial;
	}
	public boolean gameover() {
		return (currenttry<maxtry && !containsallletter())? false : true;
	}
	private boolean containsallletter() {
		// TODO Auto-generated method stub
		int f1=0;
		for(int i=0;i<word.length()*2;i+=2) {
			if(currentguess.charAt(i)=='_') {
				f1++;
				break;
			}else {
				continue;
			}
		}
		return (f1==0)? true: false;
	}
	public void check(char choosingletter) {
		String tmp=Character.toString(choosingletter); // tmp to hold the Choosing Letter
		if(!rightguess.contains(tmp) && !wrongguess.contains(tmp))
		{
			if(word.contains(tmp)) {
			replaceblanck(tmp);
			rightguess.add(tmp);
			showhangman(currenttry);
			}
			else {
				wrongguess.add(tmp);
				currenttry++;
				showhangman(currenttry);
			}
		}
		else
			System.out.println("You have already chosen that letter!! Please try again.\n");
	}
	private boolean notcontains(String tmp) {
		// TODO Auto-generated method stub
		
		return (rightguess.contains(tmp) || wrongguess.contains(tmp))? false:true;
	}
	private void replaceblanck(String letter) {
		// TODO Auto-generated method stub
		char tmp[]=word.toCharArray();
		char  ltr = letter.charAt(0);
		int f=0;
		for(int i=0;i<tmp.length*2;i++) {
			if(i%2==0) {
				if(tmp[f]==ltr) {
					currentguess.setCharAt(i, ltr);
				}
				f++;
			}
		}
	}
	public void showhangman(int currenttry2) {
		// TODO Auto-generated method stub
		String guess=currentguess.toString();
	switch(currenttry2) {
	case 0:
		System.out.println("=============");
		System.out.println("|          ||");
		System.out.println("|         ||");
		System.out.println("|          ||");
		System.out.println("          ||");
		System.out.println("           ||");
		System.out.println("          ||");
		System.out.println("           ||");
		System.out.println("          ||");
		System.out.println("        |----|");
		System.out.println();
		System.out.println(guess);
		System.out.println();
		break;
	case 1:
		System.out.println("=============");
		System.out.println("|          ||");
		System.out.println("|         ||");
		System.out.println("|          ||");
		System.out.println("O         ||");
		System.out.println("           ||");
		System.out.println("          ||");
		System.out.println("           ||");
		System.out.println("          ||");
		System.out.println("        |----|");
		System.out.println();
		System.out.println(guess);
		System.out.println("\nWrong Guess:\n"+wrongguess);
		System.out.println();
		break;
	case 2:
		System.out.println("   =============");
		System.out.println("   |          ||");
		System.out.println("   |         ||");
		System.out.println("   O          ||");
		System.out.println("   |         ||");
		System.out.println("   |          ||");
		System.out.println("             ||");
		System.out.println("              ||");
		System.out.println("            |----|");
		System.out.println();
		System.out.println(guess);
		System.out.println("\nWrong Guess:\n"+wrongguess);
		System.out.println();
		break;
	case 3:
		System.out.println("   =============");
		System.out.println("   |          ||");
		System.out.println("   |         ||");
		System.out.println("   O          ||");
		System.out.println("   |         ||");
		System.out.println("   |          ||");
		System.out.println("  /          ||");
		System.out.println("              ||");
		System.out.println("            |----|");
		System.out.println();
		System.out.println(guess);
		System.out.println("\nWrong Guess:\n"+wrongguess);
		System.out.println();
		break;
	case 4:
		System.out.println("   =============");
		System.out.println("   |          ||");
		System.out.println("   |         ||");
		System.out.println("   O          ||");
		System.out.println("   |         ||");
		System.out.println("   |          ||");
		System.out.println("  / \\        ||");
		System.out.println("              ||");
		System.out.println("            |----|");
		System.out.println();
		System.out.println(guess);
		
		System.out.println("\nWrong Guess:\n"+wrongguess);
		System.out.println();
		break;
	case 5:
		System.out.println("   =============");
		System.out.println("   |          ||");
		System.out.println("   |         ||");
		System.out.println("   O          ||");
		System.out.println("  /|         ||");
		System.out.println("   |          ||");
		System.out.println("  / \\        ||");
		System.out.println("              ||");
		System.out.println("            |----|");
		System.out.println();
		System.out.println(guess);
		System.out.println("\nWrong Guess:\n"+wrongguess);
		System.out.println();
		break;
	case 6:
		System.out.println("   =============");
		System.out.println("   |          ||");
		System.out.println("   |         ||");
		System.out.println("   O          ||");
		System.out.println("  /|\\        ||");
		System.out.println("   |          ||");
		System.out.println("  / \\        ||");
		System.out.println("              ||");
		System.out.println("            |----|");
		System.out.println();
		System.out.println(guess);
		System.out.println("\nWrong Guess:\n"+wrongguess);
		System.out.println();
		System.out.println("The Right Word Is :-"+word);
		System.out.println();
		break;
	}
	}
}
