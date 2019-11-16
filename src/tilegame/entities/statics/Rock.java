/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilegame.entities.statics;

import java.awt.Graphics;
import tilegame.Handler;
import tilegame.gfx.Assets;
import tilegame.items.Item;
import tilegame.tiles.Tile;

/**
 *
 * @author haohoang
 */
public class Rock extends StaticEntity {
    
    public Rock(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
        
        bounds.x = 3;
        bounds.y = (int) (height / 2f);
        bounds.width = width - 6;
        bounds.height = (int) (height - height / 2f);
    }
    
    @Override
    public void tick() {
        
    }
    
    @Override
    public void die() {
        handler.getWorld().getItemManager().addItem(Item.rockItem.createNew((int)x, (int) y));

    }
    
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.rock, (int) (x - handler.getGameCamera().getxOffset()),
                (int) (y - handler.getGameCamera().getyOffset()), width / 2, height / 2, null);
    }
}
