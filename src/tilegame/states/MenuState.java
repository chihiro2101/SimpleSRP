/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilegame.states;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import tilegame.Game;
import tilegame.Handler;
import tilegame.gfx.Assets;
import tilegame.ui.ClickListener;
import tilegame.ui.UIImageButton;
import tilegame.ui.UIManager;

/**
 *
 * @author haohoang
 */
public class MenuState extends State {

    private UIManager uiManager;
	/** Default button's size. */
	private static int DEFAULT_BUTTON_WIDTH =Game.width-(Game.width/2);
	private static int DEFAULT_BUTTON_HEIGHT =Game.height-50;
	/** Button's position.
	 * The buttons position will go around the middle of the screen */
	private static int x=Game.width/4;
	private static int y=0;
	private static int width=MenuState.DEFAULT_BUTTON_WIDTH;
	private static int height=MenuState.DEFAULT_BUTTON_HEIGHT;
    
    public MenuState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);
        
        uiManager.addObject(new UIImageButton(200, 200, 128, 64, Assets.btn_start, () -> {
            handler.getMouseManager().setUiManager(null);
            State.setState(handler.getGame().gameState);
        }));
    }

    @Override
    public void tick() {
		
		
		if(handler.getKeyManager().space)
		{
			try {
				State.setState(handler.getGame().gameState);
			} catch (UnsupportedAudioFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(handler.getKeyManager().esc)
		{
			System.exit(0);
		}
		
		if(handler.getKeyManager().p)
		{
			try 
			{
				State.setState(handler.getGame().tutorialState);
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(handler.getKeyManager().m)
		{
			handler.getGame().getClip().close();
		}
		
	      
       
    }

    @Override
    public void render(Graphics g) {
		g.drawImage(Assets.buttonv2, x, y, width, height, null);
    }
    
	public static int getX() {
		return x;
	}

	public static int getY() {
		return y;
	}


	public static int getWidth() {
		return width;
	}


	public static int getHeight() {
		return height;
	}

    
}

