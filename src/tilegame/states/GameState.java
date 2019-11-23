/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilegame.states;

import java.awt.Graphics;

import javax.sound.sampled.UnsupportedAudioFileException;

import tilegame.Handler;
import tilegame.entities.creatures.Player;
import tilegame.worlds.World;

/**
 *
 * @author haohoang
 */
public class GameState extends State {
    
    private World world;
	public static boolean InventoryisOpened=false;

    public GameState(Handler handler) {
        super(handler);
        world = new World(handler, "res/world/world1.txt");
        handler.setWorld(world);
    }

    @Override
    public void tick() {
        world.tick();

		
		if(handler.getKeyManager().esc)
		{
			try 
			{
				State.setState(handler.getGame().menuState);
				Thread.sleep(500); // Wait a bit so that it doesn't exit game
			} 
			catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		if(handler.getKeyManager().i) // Open the inventory
		{
				InventoryisOpened = true;
				Player.playerCantMove=true;
		}
		
		if(handler.getKeyManager().j) // Close the inventory
		{
				InventoryisOpened = false;
				Player.playerCantMove=false;
				

				
		}
		
		
		
	}
        
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        
        
    }
    
}
