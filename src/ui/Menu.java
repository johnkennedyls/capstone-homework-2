package ui;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import exceptions.MiddleBoxException;
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
		if (option != EXIT_OPTION) {

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
		menu = "=============================\n";
		menu += "          LASER GAME\n";
		menu = "=============================\n";
		menu += "1. START.\n";
		menu += "0. EXIT.\n";
		menu += "Please enter the option: \n";

		return menu;
	}

	private void executeOperation(int option) throws Exception {
		switch (option) {
		case 1:
			createGame();
			break;
		case 0:
			exit();
			break;
		default:
			break;
		}

	}

	private void createGame() throws Exception {
		System.out.println("Enter Nickname, n, m, k");
		String[] line = br.readLine().split(" ");
		String nickName = line[0];
		int n = Integer.parseInt(line[1]);
		int m = Integer.parseInt(line[2]);
		if (m > 26) {
			System.out.println("The number of columns must not be greater than 26");
		}
		int k = Integer.parseInt(line[3]);
		if (!(k <= (m * n))) {
			System.out.println("Your k don't be greater than " + (m * n));
		}
		// displayInitialGame(n, m);
		if (m <= 26 && k <= (m * n)) {
			game = new Game(n, m, k, nickName);
			game.createMatrix();
			game.generateMirrors();
			System.out.println(game);
			System.out.println("Los espejos son: " + game.getTempMirrors());
			
			shoot();
		}

	}

	private void shoot() throws Exception, MiddleBoxException {
		try {
			System.out.print("Write box to shoot: ");
			String boxShooter = br.readLine();
			game.startShoot(boxShooter);
		} catch (MiddleBoxException mbe) {
			System.out.println(mbe.getMessage());
			mbe.printStackTrace();
		}

	}

	

	
	private void exit() throws Exception {
		br.close();

	}

}
