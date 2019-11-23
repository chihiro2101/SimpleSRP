/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilegame.gfx;

import java.awt.image.BufferedImage;

/**
 *
 * @author haohoang
 */
public class Assets {
    private static final int width = 32, height = 32;
    public static BufferedImage inventory, dirt, grass, stone, tree, rock, fruit, water, stonegrass, bullet, buttons, tuto, tutov2, buttonv2;
    public static BufferedImage wood;
    public static BufferedImage[] player_down, player_up, player_left, player_right;
    public static BufferedImage[] zombie_down, zombie_up, zombie_left, zombie_right;
    public static BufferedImage[] zombie1_down, zombie1_up, zombie1_left, zombie1_right;
    public static BufferedImage[] monster_down, monster_up, monster_left, monster_right;
    public static BufferedImage[] btn_start;
    
    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
        SpriteSheet floor = new SpriteSheet(ImageLoader.loadImage("/textures/floortileset.png"));
        SpriteSheet zombie = new SpriteSheet(ImageLoader.loadImage("/textures/Monster-zombie.png"));
        SpriteSheet fruits = new SpriteSheet(ImageLoader.loadImage("/textures/PathAndObjects.png"));
        
        buttons = ImageLoader.loadImage("/textures/buttonsheet.png");
		buttonv2 = ImageLoader.loadImage("/textures/buttonv2.png");
		tutov2 = ImageLoader.loadImage("/textures/tutov2.png");
		tuto = ImageLoader.loadImage("/textures/tutorial.png");
		inventory = ImageLoader.loadImage("/textures/inventoryScreen.png");
        
        
        wood = sheet.crop(width, height, width, height);
        
        btn_start = new BufferedImage[2];
        btn_start[0] = sheet.crop(width * 6, height * 4, width * 2, height);
        btn_start[1] = sheet.crop(width * 6, height * 5, width * 2, height);

        player_down = new BufferedImage[2];
        player_up = new BufferedImage[2];
        player_left = new BufferedImage[2];
        player_right = new BufferedImage[2];

        player_down[0] = sheet.crop(width * 4, 0, width, height);
        player_down[1] = sheet.crop(width * 5, 0, width, height);
        player_up[0] = sheet.crop(width * 6, 0, width, height);
        player_up[1] = sheet.crop(width * 7, 0, width, height);
        player_left[0] = sheet.crop(width * 6, height, width, height);
        player_left[1] = sheet.crop(width * 7, height, width, height);
        player_right[0] = sheet.crop(width * 4, height, width, height);
        player_right[1] = sheet.crop(width * 5, height, width, height);
        
        
		zombie_down = new BufferedImage[2];
		zombie_up = new BufferedImage[2];
		zombie_left = new BufferedImage[2];
		zombie_right = new BufferedImage[2];
		
		zombie_down[0] = sheet.crop(width * 4, height * 2, width, height);
		zombie_down[1] = sheet.crop(width * 5, height * 2, width, height);
		zombie_up[0] = sheet.crop(width * 6, height * 2, width, height);
		zombie_up[1] = sheet.crop(width * 7, height * 2, width, height);
		zombie_right[0] = sheet.crop(width * 4, height * 3, width, height);
		zombie_right[1] = sheet.crop(width * 5, height * 3, width, height);
		zombie_left[0] = sheet.crop(width * 6, height * 3, width, height);
		zombie_left[1] = sheet.crop(width * 7, height * 3, width, height);
		
		
		zombie1_down = new BufferedImage[7];
		zombie1_up = new BufferedImage[7];
		zombie1_left = new BufferedImage[7];
		zombie1_right = new BufferedImage[7];
		
		zombie1_down[0] = zombie.crop(0, 0, width * 2, height * 2);
		zombie1_down[1] = zombie.crop(width * 2, 0, width * 2, height * 2);
		zombie1_down[2] = zombie.crop(width * 4, 0, width * 2, height * 2);
		zombie1_down[3] = zombie.crop(width * 6, 0, width * 2, height * 2);
		zombie1_down[4] = zombie.crop(width * 8, 0, width * 2, height * 2);
		zombie1_down[5] = zombie.crop(width * 10, 0, width * 2, height * 2);
		zombie1_down[6] = zombie.crop(width * 12, 0, width * 2, height * 2);		
		
		zombie1_right[0] = zombie.crop(0, height * 2, width * 2, height * 2);
		zombie1_right[1] = zombie.crop(width * 2, height * 2, width * 2, height * 2);
		zombie1_right[2] = zombie.crop(width * 4, height * 2, width * 2, height * 2);
		zombie1_right[3] = zombie.crop(width * 6, height * 2, width * 2, height * 2);
		zombie1_right[4] = zombie.crop(width * 8, height * 2, width * 2, height * 2);
		zombie1_right[5] = zombie.crop(width * 10, height * 2, width * 2, height * 2);
		zombie1_right[6] = zombie.crop(width * 12, height * 2, width * 2, height * 2);

			
		zombie1_left[0] = zombie.crop(0, height * 4, width * 2, height * 2);
		zombie1_left[1] = zombie.crop(width * 2, height * 4, width * 2, height * 2);
		zombie1_left[2] = zombie.crop(width * 4, height * 4, width * 2, height * 2);
		zombie1_left[3] = zombie.crop(width * 6, height * 4, width * 2, height * 2);
		zombie1_left[4] = zombie.crop(width * 8, height * 4, width * 2, height * 2);
		zombie1_left[5] = zombie.crop(width * 10, height * 4, width * 2, height * 2);
		zombie1_left[6] = zombie.crop(width * 12, height * 4, width * 2, height * 2);

		zombie1_up[0] = zombie.crop(0, height * 6, width * 2, height * 2);
		zombie1_up[1] = zombie.crop(width * 2, height * 6, width * 2, height * 2);
		zombie1_up[2] = zombie.crop(width * 4, height * 6, width * 2, height * 2);
		zombie1_up[3] = zombie.crop(width * 6, height * 6, width * 2, height * 2);
		zombie1_up[4] = zombie.crop(width * 8, height * 6, width * 2, height * 2);
		zombie1_up[5] = zombie.crop(width * 10, height * 6, width * 2, height * 2);
		zombie1_up[6] = zombie.crop(width * 12, height * 6, width * 2, height * 2);
                
		monster_down = new BufferedImage[4];
		monster_up = new BufferedImage[4];
		monster_left = new BufferedImage[4];
		monster_right = new BufferedImage[4];
		
		monster_down[0] = zombie.crop(0, height * 8, width * 2, height * 2);
		monster_down[1] = zombie.crop(width * 2, height * 8, width * 2, height * 2);
		monster_down[2] = zombie.crop(width * 4, height * 8, width * 2, height * 2);
		monster_down[3] = zombie.crop(width * 6, height * 8, width * 2, height * 2);
		monster_up[0] = zombie.crop(width * 10, height * 10, width * 2, height * 2);
		monster_up[1] = zombie.crop(width * 12, height * 10, width * 2, height * 2);
		monster_up[2] = zombie.crop(0, height * 12, width * 2, height * 2);
		monster_up[3] = zombie.crop(width * 2, height * 12, width * 2, height * 2);
		monster_right[0] = zombie.crop(width * 8, height * 8, width * 2, height * 2);
		monster_right[1] = zombie.crop(width * 10, height * 8, width * 2, height * 2);
		monster_right[2] = zombie.crop(width * 12, height * 8, width * 2, height * 2);
		monster_right[3] = zombie.crop(0, height * 10, width * 2, height * 2);
		monster_left[0] = zombie.crop(width * 2, height * 10, width * 2, height * 2);
		monster_left[1] = zombie.crop(width * 4, height * 10, width * 2, height * 2);
		monster_left[2] = zombie.crop(width * 6, height * 10, width * 2, height * 2);
		monster_left[3] = zombie.crop(width * 8, height * 10, width * 2, height * 2);
		
        
		
		tree = floor.crop(width * 5, height * 7, width, height);
        dirt = floor.crop(width,height * 3, width, height);
        grass = floor.crop(0, height * 2, width, height);
        stone = floor.crop(0, 0, width, height);
        rock = sheet.crop(0, height * 2, width, height);
        fruit = fruits.crop(0, height * 4 , width , height);
        water = floor.crop(width * 3, height * 5, width, height);
        stonegrass = floor.crop(width * 2, 0, width, height);
        
        bullet = sheet.crop(0, height * 2, width, height);
    }
}
