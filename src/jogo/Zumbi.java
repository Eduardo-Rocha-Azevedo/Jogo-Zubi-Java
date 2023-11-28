package src.jogo;

import jplay.URL;

public class Zumbi extends Ator{

	public Zumbi(int x, int y) {
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
}
