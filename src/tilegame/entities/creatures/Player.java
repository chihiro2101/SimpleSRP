/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilegame.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import tilegame.Handler;
import tilegame.entities.Entity;
import tilegame.gfx.Animation;
import tilegame.gfx.Assets;
import tilegame.inventory.Inventory;

/**
 *
 * @author haohoang
 */
public class Player extends Creature {
    
    //Animations
    private Animation animDown, animUp, animLeft, animRight;
    private BufferedImage currentImage; // Image will be displayed when player stops
    // Attack timer
    private long lastAttackTimer, attackCooldown = 100, attackTimer = attackCooldown;
    //Inventory
    private Inventory inventory;
    
    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
    
        bounds.x = 22;
        bounds.y = 44;
        bounds.width = 19 ;
        bounds.height = 19;
        
        //Animation
        animDown = new Animation(200, Assets.player_down);
        animUp = new Animation(200, Assets.player_up);
        animLeft = new Animation(200, Assets.player_left);
        animRight = new Animation(200, Assets.player_right);
        
        currentImage = animDown.getFrames()[0];
        
        inventory  = new Inventory(handler);
    }

    @Override
    public void tick() {
        //Animation
        animDown.tick();
        animUp.tick();
        animLeft.tick();
        animRight.tick();
        //Movement
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
        //Attack
        checkAttacks();
        //Inventory
        inventory.tick();
    }
    
    public void checkAttacks() {
        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if(attackTimer < attackCooldown)
            return;
        Rectangle cb = getCollisionBounds(0,0);
        Rectangle ar = new Rectangle();
        int arSize = 20;
        ar.width = arSize;
        ar.height = arSize;
        
        //if(handler.getKeyManager().space) {
            if(currentImage == animUp.getFrames()[0]){
                ar.x = cb.x + cb.width / 2 - arSize / 2;
                ar.y = cb.y - arSize;
            } else if(currentImage == animDown.getFrames()[0]) {
                ar.x = cb.x + cb.width / 2 - arSize / 2;
                ar.y = cb.y + cb.height;
            }else if(currentImage == animLeft.getFrames()[0]) {
                ar.x = cb.x - arSize;
                ar.y = cb.y + cb.height / 2 - arSize;
            }else if(currentImage == animRight.getFrames()[0]) {
                ar.x = cb.x + cb.width;
                ar.y = cb.y + cb.height / 2 - arSize / 2;
            } else
                return;
        //}
        
        attackTimer = 0;
        
        for(Entity e: handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this))
                continue;
            if(e.getCollisionBounds(0, 0).intersects(ar)){
                e.hurt(1);
                return;
            }
        }
    }
    
    @Override
    public void die() {
        System.out.println("You lose");
    }
    
    private void getInput() {
        xMove = 0;
        yMove = 0;
        
        if(handler.getKeyManager().up)
            yMove = -speed;
        if(handler.getKeyManager().down)
            yMove = speed;
        if(handler.getKeyManager().left)
            xMove = -speed;
        if(handler.getKeyManager().right)
            xMove = speed;
               
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
        inventory.render(g);
    }
    
    private BufferedImage getCurrentAnimationFrame() {
        if(xMove < 0){
            currentImage = animLeft.getFrames()[0];
            return animLeft.getCurrentFrame();
        } else if (xMove > 0) {
            currentImage = animRight.getFrames()[0];
            return animRight.getCurrentFrame();
        } else if (yMove < 0) {
            currentImage = animUp.getFrames()[0];
            return animUp.getCurrentFrame();
        } else if (yMove > 0) {
            currentImage = animDown.getFrames()[0];
            return animDown.getCurrentFrame();
        } else{
            return currentImage;
        }
    }

    public Inventory getInventory() {
        return inventory;
    }
    
    
}
