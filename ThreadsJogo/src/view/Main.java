package view;

import java.util.concurrent.Semaphore;
import controller.ThreadCozinhar;

public class Main {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		for (int id = 0; id < 5; id++) {
			Thread thread = new ThreadCozinhar(id, semaforo);
			thread.start();

		}
	}

}
