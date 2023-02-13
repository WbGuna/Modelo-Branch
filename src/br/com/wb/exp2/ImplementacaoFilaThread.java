package br.com.wb.exp2;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImplementacaoFilaThread extends Thread {

	private static ConcurrentLinkedQueue<ObjetoFilaThread> pilha_fila = 
			new ConcurrentLinkedQueue<ObjetoFilaThread>();
	
	protected static void add(ObjetoFilaThread objetoFilaThread) {
		pilha_fila.add(objetoFilaThread);
	}
	
	public void run() {
		
		System.out.println("Fila Rodando!");
		
		while(true) {			
			Iterator<ObjetoFilaThread> interacao = pilha_fila.iterator();
			synchronized (interacao) {
				
				while(interacao.hasNext()) {
					ObjetoFilaThread processar = (ObjetoFilaThread) interacao.next();
					
					System.out.println("=============================================");
					System.out.println(processar.getNome());
					System.out.println(processar.getEmail());
					
					interacao.remove();				
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}
}
