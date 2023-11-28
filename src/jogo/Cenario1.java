package src.jogo;

import jplay.Keyboard;
import jplay.Scene;
import jplay.URL;
import jplay.Window;

public class Cenario1 extends Cenario{
	private Window janela;
	private Scene cena;
	private Jogador jogador;
	private Keyboard teclado;
	private Zumbi zumbi; 
	
	public Cenario1(Window window) {
		janela = window;
		cena = new Scene();
		cena.loadFromFile(URL.scenario("Cenario1.scn"));
		jogador = new Jogador(640, 350);
		teclado = janela.getKeyboard();
		zumbi = new Zumbi(300,300);
		
		Som.play("musica.wav");

		run();
	}
	
	private void run() {
		while(true) {
			//cena.draw();
			jogador.controle(janela, teclado);
			jogador.caminho(cena);
			jogador.atirar(janela, cena, teclado);

			zumbi.caminho(cena);
			zumbi.perseguir(jogador.x, jogador.y);
			//simula a camera que segue o player
			cena.moveScene(jogador);
			
			zumbi.x += cena.getXOffset();//retorna o quanto o cenario se moveu
			zumbi.y += cena.getYOffset();
			
			
			
			jogador.draw();
			zumbi.draw();
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
