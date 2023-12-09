package src.jogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

import jplay.Keyboard;
import jplay.URL;
import jplay.Window;
import jplay.Scene;
public class Jogador extends Ator  {
	//ATRIBUTOS==========================================
	
	
	static int energia = 1000;
	static int pontos = 0;
	
	//construtor=========================================
	public Jogador(int x, int y) {
		super(URL.sprite("jogador.png"),20);
		this.x = x;
		this.y = y;
		this.setTotalDuration(2000);
	}
	ControleTiros tiros = new ControleTiros();
	///MEDOTOS===========================================
	public void atirar(Window janela, Scene cena, Keyboard teclado, Ator inimigo){
		if(teclado.keyDown(KeyEvent.VK_SPACE)){
			tiros.addTiro(x + 12, y + 12, direcao, cena);
			
		}
		tiros.run(inimigo);
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
		else if(teclado.keyDown(Keyboard.ESCAPE_KEY)) {
			System.exit(0);
		}

		if(movendo){
			update();
			movendo = false;
		}
		
	}

	Font f = new Font("arial", Font.BOLD, 30);
	
	public void energia(Window janela) {
		janela.drawText("Vida: " + Jogador.energia, 30, 30, Color.GREEN,f);
	}

	public void pontos(Window janela) {
        
		
        Font f = new Font("arial", Font.BOLD, 30);
        janela.drawText("Pontos: " + Jogador.pontos,30, 60, Color.GREEN,f);
    }
}

