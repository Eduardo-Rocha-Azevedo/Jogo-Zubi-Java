package src.jogo;

import java.awt.Point;
import java.util.Vector;

import jplay.GameObject;
import jplay.Keyboard;
import jplay.Scene;
import jplay.Sprite;
import jplay.TileInfo;
import jplay.URL;
import jplay.Window;

public class Jogador extends Sprite{
	//ATRIBUTOS==========================================
	
	protected int direcao = 3;
	
	private double vel = 0.5;
	private boolean movendo = false;
	
	static double energia = 100;
	
	//construtor=========================================
	public Jogador(int x, int y) {
		super(URL.sprite("jogador.png"), 20);
		this.x = x;
		this.y = y;
		this.setTotalDuration(2000);
	}
	///MEDOTOS===========================================
	
	//pode ser chamado das classes cenerios
	public void controle(Window janela, Keyboard teclado) {
	
		if(teclado.keyDown(Keyboard.LEFT_KEY)) {
			if(this.x >0) 
				this.x -= vel;
			if(this.direcao != 1) {
				setSequence(4, 8);
				direcao = 1;
			}movendo = true;
			
			
		}else if(teclado.keyDown(Keyboard.RIGHT_KEY)){
			if(this.x < janela.getWidth() - 60) 
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
			if(this.y < janela.getHeight() - 60)
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
	
	Controle controle = new Controle();
	
	/**
	 * Controle dos caminhos que o personagem não pode passar
	 * @param cena
	 */

	public void caminho(Scene cena) {
		Point min = new Point((int)this.x, (int)this.y); 
		Point max = new Point((int)this.x + this.width, (int)this.y + this.height); 

		Vector<?>tiles = cena.getTilesFromRect(min, max);
		for(int i = 0; i < tiles.size(); i++) {
			TileInfo tile = (TileInfo) tiles.elementAt(i);
			
			if(colisaoVertical(this, tile)) {
				if(controle.colisao(this, tile) == true) {
					
					if(tile.y + tile.height - 2  < this.y) { //de baixo para cima
						this.y = tile.y + this.height;
					}
					
					else if(tile.y > this.y + this.height - 2) { //de cima para baixo
						this.y  = tile.y - this.height;
					}
				}
				
				if(colisaoHorizontal(this, tile) == true) {
					if(tile.x > this.x + this.width - 2) {
						this.x = this.x - tile.width;
					}else {
						this.x = this.x + tile.width; 
					}
				}
			}
		}
	}
	
	private boolean colisaoVertical(GameObject obj, GameObject obj2) {
		if(obj2.x + obj2.width <= obj.x) {
			return false;
		}
		
		if(obj.x + obj.width <= obj2.x) {
			return false;
		}
		
		return true;
	}
	
	private boolean colisaoHorizontal(GameObject obj, GameObject obj2) {
		if(obj2.y + obj2.height <= obj.y) {
			return false;
		}
		
		if(obj.y + obj.height <= obj2.x) {
			return false;
		}
		
		return true;
	}
	
}
