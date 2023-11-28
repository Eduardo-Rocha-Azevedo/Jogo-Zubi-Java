package src.jogo;

import jplay.Sprite;
import jplay.URL;
public class Tiro extends Sprite{
	
	public static final int LEFT= 1, RIGHT= 2, STOP = 3, UP = 4, DOWN =5;
	protected static final double VELOCIDADE_TIRO = 0.6;
	protected int caminho = STOP;
	protected boolean movendo = false;
	protected int direcao = 3;
	
	public Tiro(double x, double y, int caminho) {
		super(URL.sprite("tiro2.png"), 7);
		this.x = x;
		this.y = y;
		this.caminho = caminho;
	}

	public void mover(){
		if(caminho == LEFT) {
			this.x -= VELOCIDADE_TIRO;
			if(this.direcao != 1) {
				setSequence(1, 3);
				direcao = 1;
			}movendo = true;

		}else if(caminho == RIGHT){
			this.x += VELOCIDADE_TIRO;
			if(this.direcao != 2) {
				setSequence(5,7);
				direcao = 2;
			}movendo = true;

		}else if(caminho == UP) {
			this.y -= VELOCIDADE_TIRO;
			if(this.direcao != 4) {
				setSequence(3,5);
				direcao = 4;
			}movendo = true;
		}else if(caminho == DOWN || caminho == STOP) {
			this.y += VELOCIDADE_TIRO;
			if(this.direcao != 5) {
				setSequence(1,4);
				direcao = 5;
			}movendo = true;
		}
		if(movendo){
			update();
			movendo = false;
		}
	} 
}
