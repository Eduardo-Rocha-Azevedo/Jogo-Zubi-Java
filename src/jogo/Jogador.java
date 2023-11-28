package src.jogo;

import java.awt.event.KeyEvent;

import jplay.Keyboard;
import jplay.URL;
import jplay.Window;
import jplay.Scene;
public class Jogador extends Ator  {
	//ATRIBUTOS==========================================
	
	
	static double energia = 100;
	
	//construtor=========================================
	public Jogador(int x, int y) {
		super(URL.sprite("jogador.png"),20);
		this.x = x;
		this.y = y;
		this.setTotalDuration(2000);
	}
	ControleTiros tiros = new ControleTiros();
	///MEDOTOS===========================================
	public void atirar(Window janela, Scene cena, Keyboard teclado){
		if(teclado.keyDown(KeyEvent.VK_A)){
			tiros.addTiro(x + 12, y + 12, direcao, cena);
		}
		tiros.run();
	}
	
	public void controle(Window janela, Keyboard teclado) {
	
		if(teclado.keyDown(Keyboard.LEFT_KEY)) {
			if(this.x >0) 
				this.x -= vel;
			if(this.direcao != 1) {
				setSequence(4, 8);
				direcao = 1;
			}movendo = true;
			
			
		}else if(teclado.keyDown(Keyboard.RIGHT_KEY)){
			if(this.x < janela.getWidth() - 40) 
				this.x += vel;
			if(this.direcao != 2) {
				setSequence(8, 12);
				direcao = 2;
			}movendo = true;
			
		}else if(teclado.keyDown(Keyboard.UP_KEY)) {
			if(this.y >0) 
				this.y -= vel;
			if(this.direcao != 4) {
				setSequence(12,16);
				direcao = 4;
			}movendo = true;
			
		}else if(teclado.keyDown(Keyboard.DOWN_KEY)) {
			if(this.y < janela.getHeight() - 50)
				this.y += vel;
			if(this.direcao != 5) {
				setSequence(0,4);
				direcao = 5;
			}movendo = true;
			
		}

		if(movendo){
			update();
			movendo = false;
		}
		
	}

	
}
