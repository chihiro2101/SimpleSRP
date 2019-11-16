/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilegame.states;

import java.awt.Graphics;
import tilegame.Handler;
import tilegame.worlds.World;

/**
 *
 * @author haohoang
 */
public class GameState extends State {
    
    private World world;

    public GameState(Handler handler) {
        super(handler);
        world = new World(handler, "res/world/world1.txt");
        handler.setWorld(world);
    }

    @Override
    public void tick() {
        world.tick();
        
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        
    }
    
}
