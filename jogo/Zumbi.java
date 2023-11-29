package src.jogo;

import jplay.URL;

public class Zumbi extends Ator{
	
	private double ataque = 0.01;
	

	public Zumbi(double x, double y) {
		super(URL.sprite("zumbi 02.png"),16);
		this.x = x;
		this.y = y;
		this.setTotalDuration(2000);
		this.vel = 0.1;
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
	
	public void atacar(Jogador jogador) {
		if(this.collided(jogador)) {
			Jogador.energia -= this.ataque ;
		}
		
		if(Jogador.energia <= 0) {
			System.exit(0);
		}
	}
}