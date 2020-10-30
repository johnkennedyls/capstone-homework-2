package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import model.Game;

public class Menu {
	
	public static BufferedReader br;
	public static BufferedWriter bw;
	private final static int EXIT_OPTION = 0;
	private Game game;
	
	public Menu() {
		br = new BufferedReader(new InputStreamReader(System.in));
		
	}
	

	public void startMenu() throws Exception {
		String menu = getMenuText();
		  System.out.println(menu);
		   
	       int option = readOption();
		if (option!= EXIT_OPTION) {
			
			executeOperation(option);
			startMenu();
		}
	 
	}


	private int readOption() throws Exception {
		int op;
		op = Integer.parseInt(br.readLine());
		return op;
	}


	private String getMenuText() {
		String menu;
	    menu  = "=============================\n";
	    menu += "          LASER GAME\n";
	    menu  = "=============================\n";
	    menu += "1. START.\n";
	    menu += "0. EXIT.\n";
	    menu += "Please enter the option: \n";

		return menu;
	}
	
	private void executeOperation(int option) throws Exception {
		switch(option) {
		case 1: createGame();                break;
		case 0: exit();                      break;
		default:                             break;
		}
		
	}
	
	private void createGame() throws Exception {
		System.out.println("Enter Nickname, n, m, k");
		String[] line = br.readLine().split(" ");
	    String nickName = line[0];
	    int n = Integer.parseInt(line[1]);

	    int m = Integer.parseInt(line[2]);
	    int k = Integer.parseInt(line[3]);
	    displayInitialGame(n, m);
	    game = new Game(n, m, k, nickName);
	    game.createMatrix();
	    
	    
		
		
	}
	
	private void displayInitialGame(int n, int m) throws Exception {
		
		if(n > 0) {
			displayRow(m);
			System.out.println();
			displayInitialGame( n - 1, m);
			
			
		}
	}


	private void displayRow(int m) throws Exception {
		if(m > 0) {
			System.out.print("[ ] ");
			
			displayRow(m - 1);
			
		}
		
	}


	private void exit() throws Exception {
		br.close();
		
		
	}

}
