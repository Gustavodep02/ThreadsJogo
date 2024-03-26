package controller;

import java.util.concurrent.Semaphore;

public class ThreadCozinhar extends Thread {
	private int idThread;
	private Semaphore semaforo;
	public ThreadCozinhar(int idThread, Semaphore semaforo){
		this.idThread = idThread;
		this.semaforo = semaforo;
	}
	@Override
	public void run() {
		if(idThread %2 != 0) {
			sopaDeCebola();
		}else {
			lasanhaBolonhesa();
		}
	}
	
	public void sopaDeCebola() {
		int sleep = (int) ((Math.random() * 501) + 300);
		System.out.println("Thread " + idThread + " - Sopa de Cebola - iniciou");
		try {
			tempo(sleep);
			Thread.sleep(sleep);
			try{
				semaforo.acquire();
				entrega();
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}finally {
				semaforo.release();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void lasanhaBolonhesa() {
		int sleep = (int) ((Math.random() * 601) + 600);
		System.out.println("Thread " + idThread + " - Lasanha a Bolonhesa - iniciou");
		try {
			tempo(sleep);
			Thread.sleep(sleep);
			try{
				semaforo.acquire();
				entrega();
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}finally {
				semaforo.release();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	public void tempo(int tempoTotal) {
		int tempoDecorrido = 100;
		int progresso = tempoDecorrido * 100 / tempoTotal;
		while(progresso < 100) {
			progresso = tempoDecorrido * 100 / tempoTotal;
			tempoDecorrido +=100;
			System.out.println("Thread " + idThread +" Progresso: " + progresso + "%");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}
	public void entrega() {
		System.out.println("Thread " + idThread + " Prato finalizado");
		try {
			Thread.sleep(500);
			System.out.println("Thread " + idThread + " Prato entregue");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
