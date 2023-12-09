package src.jogo;

import jplay.URL;
import jplay.Keyboard;
import jplay.Scene;

import jplay.Window;

public class Cenario1 extends Cenario{
	private Window janela;
	private Scene cena;
	private Jogador jogador;
	private Keyboard teclado;
	private Zumbi zumbi[]; 
	public static String GameState;
	private Cenario cenario;

	public Cenario1(Window window) {
		janela = window;
		cena = new Scene();
		cena.loadFromFile(URL.scenario("Cenario1.scn"));
		jogador = new Jogador(140,350);
		teclado = janela.getKeyboard();
		zumbi = new Zumbi[20];
		
		Som.play("BeepBox-Song_1.wav");

		run();
	}
	
	private void run() {
		for(int i= 0; i < zumbi.length; i++) {
			zumbi[i] = new Zumbi(100*i,100*i);
		}
		
		while(true) {
		
			jogador.controle(janela, teclado);
			jogador.caminho(cena);
			//simula a camera que segue o player
			cena.moveScene(jogador);
						
			for(int i = 0; i < zumbi.length; i++) {
				zumbi[i].caminho(cena);
				zumbi[i].perseguir(jogador.x, jogador.y);
				zumbi[i].x += cena.getXOffset();//retorna o quanto o cenario se moveu
				zumbi[i].y += cena.getYOffset();
				zumbi[i].draw();
				jogador.atirar(janela, cena, teclado, zumbi[i]);
				zumbi[i].morrer();
				zumbi[i].atacar(jogador,janela);	
			}
			
			
			jogador.energia(janela);
			//escreve na tela a quantidade de pontos
		
			jogador.pontos(janela);
			jogador.draw();
			janela.update();
			mudarCenario();
		}
	}
	
	private void mudarCenario() {
		if(tileCollision(4,jogador, cena) == true) {
			new Cenario2(janela);
		}
	}
}
