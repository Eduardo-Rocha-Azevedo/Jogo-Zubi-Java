package src.jogo;

import jplay.Window;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.URL;

public class Main{
    public static void main(String[] args){
    	Window janela = new Window(800,600);
    	GameImage plano = new GameImage(URL.sprite("menu2.png"));
    	Keyboard teclado = janela.getKeyboard();
    	
    	
    	//cria o loop do jogo
    	while(true) {
    		plano.draw();
    		janela.update();
    		
    		//pega a tecla enter
    		if(teclado.keyDown(Keyboard.ENTER_KEY)) {
    			new Cenario1(janela);
    		}
    	}
    
    
    
    }
    
    
}