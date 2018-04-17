package com.mybrijesh.framework;

import com.mybrijesh.tictactoegame.UserScore;

public interface Game 
{
    public Input getInput();

    public FileIO getFileIO();

    public Graphics getGraphics();

    public Audio getAudio();

    public void setScreen(Screen screen);

    public Screen getCurrentScreen();

    public Screen getStartScreen();
    
    public UserScore getPlayerRecord();
    
    public void savePlayerRecord(UserScore rec);
    
    public void disableTouch(boolean flag);
}