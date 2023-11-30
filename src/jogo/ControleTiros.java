package src.jogo;

import java.util.LinkedList;

import jplay.Scene;
import jplay.Sound;
import jplay.URL;
import jplay.Window;
import java.awt.Color;
import java.awt.Font;

public class ControleTiros {
	
    LinkedList<Tiro> tiros = new LinkedList<Tiro>();

   
    public void addTiro(double x, double y, int caminho, Scene cena) {
        Tiro tiro = new Tiro(x, y, caminho);
        tiros.addFirst(tiro);
        cena.addOverlay(tiro);
        somDisparo();
    }

    public void run(Ator inimigo) {
        for (int i = 0; i < tiros.size(); i++) {
            Tiro tiro = tiros.removeFirst();
            tiro.mover();
            tiros.addLast(tiro);
            
            if(tiro.collided(inimigo)) {
            	tiro.x = 10_000;
            	inimigo.energia -= 250;
                Jogador.pontos++;
            }
        }  
    }

    private void somDisparo() {
        new Sound(URL.audio("tiro.wav")).play();
    }   

    //adiciona pontos ao jogador caso o tiro acerte o inimigo
   
}
