package com.mybrijesh.tictactoegame;

import com.mybrijesh.tictactoegame.MainMenuScreen;
import com.mybrijesh.tictactoegame.Settings;
import com.mybrijesh.framework.Graphics;
import com.mybrijesh.framework.Graphics.PixmapFormat;
import com.mybrijesh.tictactoegame.Assets;
import com.mybrijesh.framework.Game;
import com.mybrijesh.framework.Screen;

public class LoadingScreen extends Screen
{
	boolean fullyLoaded;
	float deltaCounter;

	public LoadingScreen(Game game)
	{
		super(game);
		fullyLoaded = false;
		deltaCounter = 0;
	}

	@Override
	public void update(float deltaTime)
	{
		if (fullyLoaded == false)
		{
			Graphics g = game.getGraphics();
			Assets.background = g.newPixmap("gameBackground.png",
					PixmapFormat.RGB565);
			Assets.logo = g.newPixmap("Logo.png", PixmapFormat.ARGB4444);
			Assets.gameTitleImage = g.newPixmap("TicTacToeTitle.png",
					PixmapFormat.ARGB4444);
			Assets.play = g.newPixmap("play.png", PixmapFormat.ARGB4444);
			Assets.playClicked = g.newPixmap("playClicked.png",
					PixmapFormat.ARGB4444);
			Assets.exit = g.newPixmap("Exit.png", PixmapFormat.ARGB4444);
			Assets.exitClicked = g.newPixmap("ExitClicked.png",
					PixmapFormat.ARGB4444);
			Assets.score = g.newPixmap("Score.png", PixmapFormat.ARGB4444);
			Assets.scoreClicked = g.newPixmap("ScoreClicked.png",
					PixmapFormat.ARGB4444);
			Assets.OnePlayer = g.newPixmap("One Player.png",
					PixmapFormat.ARGB4444);
			Assets.OnePlayerClicked = g.newPixmap("One PlayerClicked.png",
					PixmapFormat.ARGB4444);
			Assets.easyLevel = g.newPixmap("easyLevel.png", PixmapFormat.ARGB4444);
			Assets.easyLevelClicked = g.newPixmap("easyLevelClicked.png", PixmapFormat.ARGB4444);
			Assets.hardLevel = g.newPixmap("hardLevel.png", PixmapFormat.ARGB4444);
			Assets.hardLevelClicked = g.newPixmap("hardLevelClicked.png", PixmapFormat.ARGB4444);
			Assets.TwoPlayer = g.newPixmap("Two Player.png", PixmapFormat.ARGB4444);
			Assets.TwoPlayerClicked = g.newPixmap("Two PlayerClicked.png", PixmapFormat.ARGB4444);
			Assets.YouWon = g.newPixmap("You Won2.png", PixmapFormat.ARGB4444);
			Assets.YouLost = g.newPixmap("You Lost.png", PixmapFormat.ARGB4444);
			Assets.Tie = g.newPixmap("tie.png", PixmapFormat.ARGB4444);
			Assets.CloseSign = g.newPixmap("Close Sign.png", PixmapFormat.ARGB4444);
			Assets.TryAgain = g.newPixmap("Try Again.png", PixmapFormat.ARGB4444);
			Assets.gameEndBackground = g.newPixmap("gameEnd.png", PixmapFormat.ARGB4444);
			Assets.VerticalLine = g.newPixmap("Vertical Lines.png",
					PixmapFormat.ARGB4444);
			Assets.HorizontalLine = g.newPixmap("Horizontal Line.png",
					PixmapFormat.ARGB4444);
			Assets.CircleSign = g.newPixmap("CircleSign.png",
					PixmapFormat.ARGB4444);
			Assets.XSign = g.newPixmap("XSign.png", PixmapFormat.ARGB4444);
			Settings.load(game.getFileIO());
			fullyLoaded = true;
		}
	}

	@Override
	public void present(float deltaTime)
	{
		deltaCounter += deltaTime;
		Graphics g = game.getGraphics();
		g.drawPixmap(Assets.background, Assets.background_x, Assets.background_y);
		g.drawPixmap(Assets.logo, Assets.logo_x, Assets.logo_y);

		if (deltaCounter > 2)
		{
			game.setScreen(new MainMenuScreen(game));
		}
	}

	@Override
	public void pause()
	{}

	@Override
	public void resume()
	{}

	@Override
	public void dispose()
	{}

}
