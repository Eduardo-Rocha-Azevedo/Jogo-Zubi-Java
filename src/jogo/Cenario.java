package src.jogo;

import java.awt.Point;
import jplay.Window;
import java.util.Vector;

import jplay.GameObject;
import jplay.Scene;
import jplay.TileInfo;
import java.awt.Color;
import java.awt.Font;

public abstract class Cenario {
	public boolean tileCollision(int value, Jogador jogador,Scene cena) {
		Point min = new Point ((int) jogador.x, (int)jogador.y);
		Point max = new Point ((int)(jogador.x + jogador.width), (int)(jogador.y + jogador.height));
		
		Vector<?>tiles = cena.getTilesFromPosition(min, max);
		for(int i =0; i < tiles.size(); i++) {
			TileInfo tile = (TileInfo) tiles.elementAt(i);
			if(tileCollision(jogador, tile, value) == true) {
				return true;
			}
		}
		return false;
	}
	
	private boolean tileCollision(GameObject obj, TileInfo tile, int value) {
		if((tile.id == value) && obj.collided(tile)) {
			return true;
		}
		return false;
	}

	//pausa o jogo
	public void pause() {
		Cenario1.GameState = "PAUSA";
	}

	public void draw(Window janela) {
		//escreve na tela a tela de pause
		Font f = new Font("arial", Font.BOLD, 50);
		janela.drawText("Pausa", 200, 200, Color.RED,f);
	}

}
