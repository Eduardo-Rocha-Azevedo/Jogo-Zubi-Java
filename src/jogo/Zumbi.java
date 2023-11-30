package src.jogo;

import java.awt.Color;
import java.awt.Font;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.URL;
import jplay.Window;

public class Zumbi extends Ator{
	
	protected double ataque = 0.001;
	

	public Zumbi(double x, double y) {
		super(URL.sprite("zumbi 02.png"),16);
		this.x = x;
		this.y = y;
		this.setTotalDuration(2000);
		this.vel = 0.09;
	}
	
	
	public void perseguir(double x, double y) {
		if(this.x > x && this.y <= y + 50 && this.y >= y - 50) {
			moveTo(x, y, vel);
			if(direcao != 1) {
				setSequence(5,8);
				direcao = 1;
			}
			movendo = true;	
		}	
		else if(this.x < x && this.y <= y +50 && this.y >= -50) {
			moveTo(x, y, vel);
			if(direcao != 2) {
				setSequence(9,12);
				direcao = 2;
			}
			movendo = true;
		}
		else if(this.y > y) {
			moveTo(x, y, vel);
			if(direcao != 4) {
				setSequence(13,16);
				direcao = 4;
			}
			movendo = true;
		}
		
		else if(this.y < y) {
			moveTo(x, y, vel);
			if(direcao != 5) {
				setSequence(1,4);
				direcao = 5;
			}
			movendo = true;
		}
		
		if(movendo) {
			update();
			movendo = false;
		}
	}


	public void morrer() {
		if(this.energia <= 0) {
			this.vel = 0;
			//this.ataque = 0;
			this.direcao = 0;
			this.movendo = false;
			this.x = 1_000_000;
		}
	}
	
	public void atacar(Jogador jogador, Window janela) {
		if(this.collided(jogador)) {
			Jogador.energia -= this.ataque ;
			//mostra game over
			if(Jogador.energia <= 0) {
				//Window janela = new Window(800,600);
				GameImage plano = new GameImage(URL.sprite("game_over.png"));
				Font f = new Font("arial", Font.BOLD, 30);
				janela.clear(Color.BLACK);
				janela.drawText("GAME OVER: ", 200, 200, Color.RED,f);
				janela.drawText("Pontos: " + Jogador.pontos, 200, 300, Color.RED,f);
				janela.drawText("Press Enter ", 200, 500, Color.white,f);
		
				//para o zumbi
				this.vel = 0;
				this.ataque = 0;
				this.direcao = 0;
				this.morrer();
				
				//para o jogador
				this.movendo = false;
				jogador.movendo = false;
				jogador.vel = 0;
				jogador.direcao = 0;
				
				//reiinicia o jogo
				if(janela.getKeyboard().keyDown(Keyboard.ENTER_KEY)) {
					Jogador.pontos = 0;
					Jogador.energia = 1000;
					new Cenario1(janela);
					//reinicia o pontos
				
				}
			}
		}	
	}
}