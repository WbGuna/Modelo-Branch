package br.com.wb;

import javax.swing.JOptionPane;

public class ExemploThread {

	public static void main(String[] args) {
		Thread threadRotina1 = new Thread(thread1);
		threadRotina1.start();
		Thread threadRotina2 = new Thread(thread2);
		threadRotina2.start();
		JOptionPane.showMessageDialog(null, "Continua a aplicação!");
		
	}
	
	//Primeira Thread exemplo.
	private static Runnable thread1 = new Runnable(){

		@Override
		public void run() {			
			for(int i = 0; i < 15; i++) {
				
				try {
					System.out.println("Executando uma rotina Exemplo1!");
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Finalizamos a Thread da rotina 1!");			
		}		
	};
	
	//Segunda Thread exemplo.
	private static Runnable thread2 = new Runnable(){

		@Override
		public void run() {			
			for(int i = 0; i < 10; i++) {
				
				try {
					System.out.println("Executando uma rotina Exemplo2!");
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Finalizamos a Thread da rotina 2!");			
		}		
	};
}
