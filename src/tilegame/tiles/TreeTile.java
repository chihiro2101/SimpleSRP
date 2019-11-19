package tilegame.tiles;

import java.awt.image.BufferedImage;
import tilegame.gfx.Assets;

/**
 *
 * @author haohoang
 */
public class TreeTile extends Tile {

    public TreeTile(int id) {
        super(Assets.tree, id);
    }
    
    @Override
    public boolean isSolid() {
        return true;
    }
}
