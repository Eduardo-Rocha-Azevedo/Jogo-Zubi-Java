package src.jogo;

import jplay.Keyboard;
import jplay.Scene;
import jplay.URL;
import jplay.Window;

public class Cenario1 {
	private Window janela;
	private Scene cena;
	private Jogador jogador;
	private Keyboard teclado;
	
	public Cenario1(Window window) {
		janela = window;
		cena = new Scene();
		cena.loadFromFile(URL.scenario("Cenario1.scn"));
		jogador = new Jogador(640, 350);
		teclado = janela.getKeyboard();
		Som.play("intro.wav");
		run();
	}
	
	private void run() {
		while(true) {
			//cena.draw();
			jogador.controle(janela, teclado);
			jogador.caminho(cena);
			//simula a camera que segue o player
			cena.moveScene(jogador);
			
			jogador.x += cena.getXOffset();//retorna o quanto o cenario se moveu
			jogador.y += cena.getYOffset();
			jogador.draw();
			janela.update();
			
		}
	}
}
