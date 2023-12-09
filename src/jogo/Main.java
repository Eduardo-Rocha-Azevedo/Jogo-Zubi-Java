package src.jogo;


import jplay.URL;

import java.awt.Color;
import java.awt.Font;

import jplay.GameImage;
import jplay.Keyboard;

import jplay.Window;

public class Main{
    public static void main(String[] args){
    	Window janela = new Window(800,600);
    	//GameImage plano = new GameImage(URL.sprite("menu2.png"));
    	Keyboard teclado = janela.getKeyboard();
    	Som.play("intro.wav");
    	
    	//cria o loop do jogo
    	while(true) {
    		
    		Font f = new Font("Comic Sans MS", Font.BOLD, 50);
			Font f2 = new Font("Comic Sans MS", Font.BOLD, 30);
			Font f3 = new Font("Comic Sans MS", Font.BOLD, 20);

			janela.clear(Color.BLACK);
		
			janela.drawText("Zumbi Game ", 200, 100, Color.RED,f);
			//instrucoes
			janela.drawText("Press Enter para iniciar", 200, 200, new Color(218,165,32),f2);
		;
			janela.drawText("Instruções" , 200, 350, Color.white,f2);
			janela.drawText("Seta de Cima           ESPAÇO para atirar" , 100, 400, Color.white,f3);
			janela.drawText("Seta de Baixo          ESC para sair ", 100, 450, Color.white,f3);
			janela.drawText("Seta da Esquerda                     " , 100, 500, Color.white,f3);
			janela.drawText("Seta da Direita                      " , 100, 550, Color.white,f3);
			
			
    		janela.update();
    		
    		//pega a tecla enter
    		if(teclado.keyDown(Keyboard.ENTER_KEY)) {
    			new Cenario1(janela);
    		}
			//pega a tecla esc
			if(teclado.keyDown(Keyboard.ESCAPE_KEY)) {
				System.exit(0);
			}
    	}
    
    
    
    }
    
    
}