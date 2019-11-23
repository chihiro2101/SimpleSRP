/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilegame.inventory;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import tilegame.Game;
import tilegame.Handler;
import tilegame.items.Item;
import tilegame.states.GameState;

/**
 *
 * @author haohoang
 */
public class Inventory {
    private Handler handler;
    private boolean active = false;
    private ArrayList<Item> inventoryItems;
	// Inventory variables for disposition
	/** Disposition of inventory. */
	private int invImageX=Game.width/3+25;
	private int invImageY=Game.height/26;
	private int invImageWidth=65;
	private int invImageHeight=65;
	
	private int InvListSpacing =30;
	
	private int selectedItem=0;

    public Inventory(Handler handler) {
        this.handler = handler;
        inventoryItems = new ArrayList<Item>();
    }
    
    public void tick() {
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_E))
            active = !active;
        if(!active)
            return;
		if(handler.getKeyManager().z)
		{
			selectedItem--;		
			try {
				Thread.sleep(150); // This allows the scrolling to be smooth
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		if(handler.getKeyManager().s)
		{
			selectedItem++;	
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		if(selectedItem<0)
			selectedItem=inventoryItems.size()-1;
		else if (selectedItem >= inventoryItems.size())
			selectedItem=0;
    }
    
    public void render(Graphics g) {
		if (GameState.InventoryisOpened == true)
		{
			g.drawImage(texture, 0, 0, Game.width/2-50, Game.height/2, null);
			
			int len = inventoryItems.size();
			if (len==0)
			{
				return;
			}
			for (int i=-5; i<6;i++)
			{
				if(selectedItem+i<0 || selectedItem+i >= len)
					continue;
				if(i==0)
				{
				// Write the items name
				g.setFont(new Font("Arial", Font.PLAIN, 28));
				g.drawString("> " + inventoryItems.get(selectedItem + i).getName() + " <",Game.width/10, 195+i*InvListSpacing);
				}
				else
				{
					g.setFont(new Font("Arial", Font.PLAIN, 28));
					g.drawString(inventoryItems.get(selectedItem + i).getName(),Game.width/10, 195+i*InvListSpacing);
				}
					
			}
			
			Item item = inventoryItems.get(selectedItem);
			g.drawImage(item.getTexture(), invImageX, invImageY, invImageWidth, invImageHeight, null); // Draw the texture of the item
			
			String counts = String.valueOf(inventoryItems.get(selectedItem).getCount());
			g.setFont(new Font("Arial", Font.PLAIN, 28));
			g.drawString(counts,invImageX+25, invImageY+100); // Draw the count of the item
		}
		else
			return;
	}
	    
    //Inventory methods
    public void addItem(Item item){
        for(Item i : inventoryItems) {
            if(i.getId() == item.getId()) {
                i.setCount(i.getCount() + item.getCount());
                return;
            }
        }
        inventoryItems.add(item);
        
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
    
    
}
