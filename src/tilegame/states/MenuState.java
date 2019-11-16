/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilegame.states;

import java.awt.Color;
import java.awt.Graphics;
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
        uiManager.tick();        
       
    }

    @Override
    public void render(Graphics g) {
        uiManager.render(g);
    }
    
}

