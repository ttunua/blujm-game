package game;

import ecs100.UI;

import java.io.File;

/**
 * Created by Daniel Young on 4/30/2016.
 */
public class GWorldSelect {

    public static void main(String[] args){
        GWorldSelect temp = new GWorldSelect();
        temp.update();

    }


    private String[] worlds;

    //Image file for the background and title of world select screen
    private String backgroundImage = GFileChecker.RESOURCES_ROOT + File.separator
            + "images" + File.separator + "side-menu-1.png";
    private String buttonImage = GFileChecker.RESOURCES_ROOT + File.separator
            + "images" + File.separator + "world-select-button.png";



    private String worldsFolder = GFileChecker.RESOURCES_ROOT + File.separator
            + "worlds";
    private static final int spacing = 20;


    //Outlines the possible area for world select buttons
    public static final int LEFT = GGraphics.WORLD_LEFT + 2*spacing;
    private static final int RIGHT = GGraphics.WORLD_LEFT + GGraphics.WORLD_WIDTH - 4*spacing;
    private static final int TOP = GGraphics.WORLD_TOP + 90;
    private static final int BOT = GGraphics.WORLD_HEIGHT - 2*spacing;

    private static final int cellsPerRow = 5;
    private static final int buttonWidth = ((RIGHT - LEFT) - (cellsPerRow + 1)*spacing) / cellsPerRow;
    private static final int buttonHeight = ((BOT - TOP) - (cellsPerRow + 1)*spacing) / cellsPerRow;

    public GWorldSelect(){
        //Iterates through the worlds folder to find the names of the world to be loaded

        File f = new File(worldsFolder);
        worlds = f.list();
    }

    public void update(){
        int row = 0;
        int col = 0;
        int index = 0;
        int buttonLeft = 0;
        int buttonTop = 0;
        for(int counter = 0; counter < worlds.length; counter++){
            row = counter / cellsPerRow;
            col = counter % cellsPerRow;
            buttonLeft = LEFT + (col*spacing) +col*buttonWidth;
            buttonTop = TOP + (row*spacing) + row*buttonHeight;
            UI.drawImage(buttonImage, buttonLeft , buttonTop,
                          buttonWidth, buttonHeight);
            index = worlds[counter].indexOf(".");
            UI.drawString("World " + worlds[counter].substring(index - 1, index), buttonLeft, buttonTop + buttonHeight*(3/4));
        }
    }
}
