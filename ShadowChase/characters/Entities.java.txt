package characters;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

//class containing various variables related to the player and shadow characters
public class Entities{
     public int x, y, speed;
     public int shadowX, shadowY;
     public BufferedImage up1,up2,left1,left2,right1,right2,down1,down2;
     public BufferedImage shadowUp1,shadowUp2,shadowLeft1,shadowLeft2,shadowRight1,shadowRight2,shadowDown1,shadowDown2;
     public char shadowDirection;
     public char direction;
     
     public int spriteCounter = 0;
     public int spriteNumber = 1;
     
     public Rectangle collisionArea;
     public boolean collision = false;
     
     public Rectangle colArea;
     public boolean collisionOn = false;
}