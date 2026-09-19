package environment;

import java.io.*;
import java.awt.*;
import main.GameWindow;
import javax.imageio.*;
import main.KeyHandler;

//class containing all graphical updates not related to the characters
public class Tiles {
     
     TileStorage[] tile;
     GameWindow gW;
     KeyHandler inputs;
     public static boolean map01Bool = false;
     
     public Tiles(GameWindow gW, KeyHandler inputs){
          this.gW = gW;
          this.inputs = inputs;
          
          tile = new TileStorage[10];
          getTileSprite();
     }
     
  
     //method collecting and storing all images for the tiles
     public void getTileSprite(){
          try{
               tile[0] = new TileStorage();
               tile[0] .sprite = ImageIO.read(getClass().getResourceAsStream("/sprites/floor.png"));  
               
               tile[1] = new TileStorage();
               tile[1] .sprite = ImageIO.read(getClass().getResourceAsStream("/sprites/lava.png")); 
            
               tile[2] = new TileStorage();
               tile[2] .sprite = ImageIO.read(getClass().getResourceAsStream("/sprites/TpBlock1.png")); 
               
               tile[3] = new TileStorage();
               tile[3] .sprite = ImageIO.read(getClass().getResourceAsStream("/sprites/TpBlock2.png")); 
               
               tile[4] = new TileStorage();
               tile[4] .sprite = ImageIO.read(getClass().getResourceAsStream("/sprites/closedDoor.png")); 
               
               tile[5] = new TileStorage();
               tile[5] .sprite = ImageIO.read(getClass().getResourceAsStream("/sprites/openDoor.png")); 
               
               tile[6] = new TileStorage();
               tile[6] .sprite = ImageIO.read(getClass().getResourceAsStream("/sprites/key.png")); 
               
               tile[7] = new TileStorage();
               tile[7] .sprite = ImageIO.read(getClass().getResourceAsStream("/sprites/void.png")); 
               
               tile[8] = new TileStorage();
               tile[8] .sprite = ImageIO.read(getClass().getResourceAsStream("/sprites/dmg.png")); 
              
               tile[9] = new TileStorage();
               tile[9] .sprite = ImageIO.read(getClass().getResourceAsStream("/sprites/mudFloor.png")); 
          }
          catch(IOException e){
               e.printStackTrace();
          }
     }
     //string array containing data of the map, 1 = lava and 0 = floor
     String[] map01 = {
          "1111111111111111",
          "1000000000000001",
          "1111111111111101",
          "1000000000000001",
          "1011111111111111",
          "1000000000000001",
          "1111111111111101",
          "1000000000000001",
          "1011111111111111",
          "1000000000000001",
          "1111111111111101",
          "1111111111111101"};
     String[] map02PreKey = {
          "7777777777777774",
          "7999999999999999",
          "7977777777779797",
          "7977777777779797",
          "7999997777779797",
          "7977777777999797",
          "7977779999779797",
          "7777779779999797",
          "7399779777779797",
          "7779999777779997",
          "7777777777777777",
          "7699999999999992"};
     String[] map02PostKey = {
          "7777777777777775",
          "7999999999999999",
          "7977777777779797",
          "7977777777779797",
          "7999997777779797",
          "7977777777999797",
          "7977779999779797",
          "7777779779999797",
          "7299779777779797",
          "7779999777779997",
          "7777777777777777",
          "7799999999999993"};
     
     public void draw(Graphics2D g2) {
       //for loop iterated through each character in each string of the array and changes temp to said char(casted to int)
       if(map01Bool){   
         for(int x = 0;x < gW.xAxis;x++){ 
           for(int y = 0;y < gW.yAxis;y++){
             int temp = (int)(map01[y].charAt(x))-48;
             
             g2.drawImage(tile[temp].sprite,x*gW.tileSize,y*gW.tileSize,gW.tileSize,gW.tileSize,null);
           }
         }
       }
       else if(!gW.hasKey){
         for(int x = 0;x < gW.xAxis;x++){ 
           for(int y = 0;y < gW.yAxis;y++){
             int temp = (int)(map02PreKey[y].charAt(x))-48;
             
             g2.drawImage(tile[temp].sprite,x*gW.tileSize,y*gW.tileSize,gW.tileSize,gW.tileSize,null);
           }
         }
       }
           else{
            for(int x = 0;x < gW.xAxis;x++){ 
           for(int y = 0;y < gW.yAxis;y++){
             int temp = (int)(map02PostKey[y].charAt(x))-48;
             
             g2.drawImage(tile[temp].sprite,x*gW.tileSize,y*gW.tileSize,gW.tileSize,gW.tileSize,null);
           } 
           }
         }
       }
     

           //method creating the pause screen
           public void pauseScreen(Graphics2D g2){
             
             if(inputs.pause = true){
               
               String shadowScoreString = Integer.toString(gW.shadowScore);
               String playerScoreString = Integer.toString(gW.playerScore);
               
               Font bigFont = new Font ("TimesRoman", 1, 120);
               Font mediumFont = new Font ("TimesRoman", 1, 60);
               Font smallFont = new Font ("TimesRoman", 1, 40);
               g2.setFont(bigFont);
               g2.setColor(Color.white);
               g2.drawString("PAUSED", 276, 250); 
               g2.setFont(mediumFont);
               g2.drawString("Scoreboard",372,400);
               g2.setFont(smallFont);
               g2.drawString("Computer: ",370,475);
               g2.drawString(shadowScoreString,592,475);
               g2.drawString("Player: ",432,525);
               g2.drawString(playerScoreString,592,525);
             }
          
           }
           
           //method creating the title screen
           public void drawTitleScreen(Graphics2D g2){
             if(inputs.titleScreen == true){
               
               int titleX = 256;
               int titleY = 256;
               String title = "Shadow Chase";
               
               Font myFont = new Font ("TimesRoman", 1, 80);
               g2.setFont(myFont);
               g2.setColor(Color.white);
               g2.drawString(title, titleX, titleY);
               Font smallFont = new Font ("TimesRoman", 1, 40);
               g2.setFont(smallFont);
               g2.drawString("Select the number of rounds (1-9) ", 236, 448);
               g2.drawString("you would like to play", 340, 512);
             }
           }
           //method creating the GAME OVER screen
           public void outputResults(Graphics2D g2){
             if(inputs.endScreen == true){
               String shadowScoreString = Integer.toString(gW.shadowScore);
               String playerScoreString = Integer.toString(gW.playerScore);
               String winner;
               
               if(gW.shadowScore>gW.playerScore){
                winner = "Computer Wins!"; 
               }
               else if (gW.shadowScore<gW.playerScore)
               {
                winner = "Player Wins!"; 
               }
               else
               {
                winner = "It's a Draw!"; 
               }
               
               Font bigFont = new Font ("TimesRoman", 1, 120);
               Font mediumFont = new Font ("TimesRoman", 1, 60);
               Font smallFont = new Font ("TimesRoman", 1, 40);
               
               g2.setFont(bigFont);
               g2.setColor(Color.white);
               g2.drawString("GAME OVER", 170, 250); 
               
               g2.setFont(mediumFont);
               g2.drawString("Scoreboard",372,400);
               g2.drawString(winner,332,600);
               
               g2.setFont(smallFont);
               g2.drawString("Computer: ",370,475);
               g2.drawString(shadowScoreString,592,475);
               g2.drawString("Player: ",432,525);
               g2.drawString(playerScoreString,592,525);
               g2.drawString("Press ENTER to play again",32,752);
               
             }
           }
           //method creating the mapSelection screen
           public void drawMapSelection(Graphics2D g2){
             if(inputs.mapSelection == true){
               
               Font bigFont = new Font ("TimesRoman", 1, 120);
               Font mediumFont = new Font ("TimesRoman", 1, 60);
               Font smallFont = new Font ("TimesRoman", 1, 40);
               g2.setFont(bigFont);
               g2.setColor(Color.white);
               g2.drawString("Select Your Map", 100, 250); 
               g2.setFont(smallFont);
               g2.drawString("Click 1 for map 1 ",125,460);
               g2.drawString("Click 2 for map 2 ",645,460);
               
             }
           }
}

