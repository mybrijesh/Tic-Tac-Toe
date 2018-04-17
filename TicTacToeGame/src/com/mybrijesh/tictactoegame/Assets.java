package com.mybrijesh.tictactoegame;

import com.mybrijesh.framework.Pixmap;

public class Assets 
{
	//GAME DEFAULT ATTRIBUTE SUCH AS
	//BACKGROUND, LOGO, TITLE AND THEIR X AND Y COORDINATES
	public static Pixmap background;
	public static final int background_x = 0, background_y =0;
    public static Pixmap logo;
    public static final int logo_x = 35, logo_y = 150;
    public static Pixmap gameTitleImage;
    public static final int title_x = 10, title_y = 50;
    public static final String userDataRetriveNameWin = "Harsha Brijesh Patel Win";
    public static final String userDataRetriveNameLose = "Harsha Brijesh Patel Lose";
    public static final String userDataRetriveNameTie = "Harsha Brijesh Patel Tie";
    public static final String userName = "Harsha";
    
    //PLAY BUTTON ATTRIBUTE
    public static Pixmap play;
    public static Pixmap playClicked;
    public static final int play_x = 85;
    public static final int play_y = 175;
    public static final int play_width = 150,play_height = 75;
    
    //SCORE BUTTON ATTRIBUTE
    public static Pixmap score;
    public static Pixmap scoreClicked;
    public static final int score_x = 85, score_y = 175+60;
    public static final int score_width = 150,score_height = 75;
    
    //EXIT BUTTON ATTRIBUTE
    public static Pixmap exit;
    public static Pixmap exitClicked;
    public static final int exit_x = 85, exit_y = 175+120;
    public static final int exit_width = 150, exit_height = 75;
    
    //ONE PLAYER BUTTON ATTRIBUTES
    public static Pixmap OnePlayer;
    public static Pixmap OnePlayerClicked;
    public static final int OnePlayer_x = 35, OnePlayer_y = 175;
    public static final int OnePlayer_width = 250, OnePlayer_height = 75;
    
    //ONE PLAYER LEVEL OF DIFFICULTY ATTRIBUTES
    public static Pixmap easyLevel;
    public static Pixmap easyLevelClicked;
    public static final int easy_x = 75, easy_y = 160, easy_width = 200, easy_height = 65;
    public static Pixmap hardLevel;
    public static Pixmap hardLevelClicked;
    public static final int hard_x = 75, hard_y = 160+85, hard_width = 200, hard_height = 65;
    
    //TWO PLAYER BUTTON ATTRIBUTES
    public static Pixmap TwoPlayer;
    public static Pixmap TwoPlayerClicked;
    public static final int TwoPlayer_x = 35, TwoPlayer_y = 250;
    public static final int TwoPlayer_width = 250, TwoPlayer_height = 75;
    
    //PLAYER WON 
    public static Pixmap YouWon;
    public static final int YouWon_x = 40, YouWon_y = 350;//40,350
    public static Pixmap YouLost;
    public static final int YouLost_x = 40, YouLost_y = 350;
    public static Pixmap Tie;
    public static final int Tie_x = 40, Tie_y = 350;
    public static Pixmap CloseSign;
    public static final int CloseSign_x = 280, CloseSign_y=0;
    public static final int CloseSign_width = 50, CloseSign_height = 50;
    public static Pixmap TryAgain;
    public static final int TryAgain_x = 0, TryAgain_y=0;
    public static Pixmap gameEndBackground;
    public static final int gameEndBackground_x = 15,gameEndBackground_y=50;
    public static final int gameEndBackgrounnd_width = 200, gameEndBackground_height = 200;
    
    //GAME VERTICAL LINE
    public static Pixmap VerticalLine;
    public static final int VLine_x = 100, VLine_y = 60;
    public static final int VLine2_x = 200, VLine2_y = 60;
    
    //GAME HORIZONTAL LINE
    public static Pixmap HorizontalLine;
    public static final int HLine_x = -10, HLine_y = 153;
    public static final int HLine2_x = -10, Hline2_y = 248;
    
    //X AND O SIGNS FOR THE GAME
    public static Pixmap CircleSign;
    public static final int Circle_width = 90, Circle_height = 85;
    public static final int Circle1_x = 10, Circle1_y = 73;
    public static final int Circle2_x = 113, Circle2_y = 73;
    public static final int Circle3_x = 214, Circle3_y = 73;
    public static final int Circle4_x = 10, Circle4_y = 166;
    public static final int Circle5_x = 113, Circle5_y = 166;
    public static final int Circle6_x = 214, Circle6_y = 166;
    public static final int Circle7_x = 10, Circle7_y = 262;
    public static final int Circle8_x = 113, Circle8_y = 262;
    public static final int Circle9_x = 214, Circle9_y = 262;
    public static Pixmap XSign;
    
    //THIS ATTRIBUTE ARE FOR THE drawString(String text,float x, float y, float size)
    public static final int playerTurn_x = 10, playerTurn_y = 50, playerTurn_size = 35;
    public static final int humanTurn_x = 20, humanTurn_y = 50, humanTurn_size = 45;
}
