/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilegame;

import tilegame.gfx.GameCamera;
import tilegame.input.KeyManager;
import tilegame.input.MouseManager;
import tilegame.worlds.World;

/**
 *
 * @author haohoang
 */
public class Handler {
    
    private Game game;
    private World world;
    
    public Handler(Game game) {
        this.game = game;
    }
    
    public GameCamera getGameCamera() {
        return game.getGameCamera();
    }
    
    public KeyManager getKeyManager() {
        return game.getKeyManager();
    }
    
    public int getWidth() {
        return game.getWidth();
    }
    
    public int getHeight() {
        return game.getHeight();
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public World getWorld() {
        return world;
    }

    public MouseManager getMouseManager() {
        return game.getMouseManager();
    }

    public Game getGame() {
        return game;
    }
    
    
}
