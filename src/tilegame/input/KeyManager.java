/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilegame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 *
 * @author haohoang
 */
public class KeyManager implements KeyListener {

    private boolean[] keys, justPressed, cantPress;
    public boolean up, down, left, right,  esc, p, m, i, j, z, s, enter;
    public boolean space;
    
    public KeyManager(){
        keys = new boolean[256];
        justPressed = new boolean[keys.length];
        cantPress = new boolean[keys.length];
    }
    
    public void tick(){
        for(int i = 0; i < keys.length; i++) {
            if(cantPress[i] && !keys[i]) {
                cantPress[i] = false;
            } else if(justPressed[i]) {
                cantPress[i] = true;
                justPressed[i] = false;
            }
            if(!cantPress[i] && keys[i]) {
                justPressed[i] = true;
            }
        }
        
        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];
                
        space = keys[KeyEvent.VK_SPACE];
        enter = keys[KeyEvent.VK_ENTER];
        esc = keys[KeyEvent.VK_ESCAPE];
        
		
		p = keys[KeyEvent.VK_P];
		m = keys[KeyEvent.VK_M];
		
		// Inventory keys
		i = keys[KeyEvent.VK_I];
		j = keys[KeyEvent.VK_J];
		
		z = keys[KeyEvent.VK_Z];
		s = keys[KeyEvent.VK_S];
        
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
            return;
        keys[e.getKeyCode()] = true;
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length) // To prevent errors
			return;
		keys[e.getKeyCode()] = false;
    }
    
    public boolean keyJustPressed(int keyCode) {
        if(keyCode < 0 || keyCode >= keys.length)
            return false;
        return justPressed[keyCode];
    }
}
