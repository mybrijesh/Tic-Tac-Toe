package com.mybrijesh.tictactoegame;

import com.mybrijesh.framework.Game;
import com.mybrijesh.framework.Graphics;
import com.mybrijesh.framework.Screen;

public class ScoreScreen extends Screen
{
	UserScore record;
	private boolean drawOnce;
	
	public ScoreScreen(Game game)
	{
		super(game);
		drawOnce = true;
		record = game.getPlayerRecord();
	}
	
	@Override
	public void update(float deltaTime)
	{
	}

	@Override
	public void present(float deltaTime)
	{
		Graphics g = game.getGraphics();
		if (drawOnce)
		{
			g.drawPixmap(Assets.background, Assets.background_x,
					Assets.background_y);
			g.drawStringDrawingGuidesStyle("SCORE", 10, 120, 125);// 80,150,75
			g.drawStringDrawingGuidesStyle(
					"Wins: " + record.getWin(Assets.userName), 50, 200, 50);
			g.drawStringDrawingGuidesStyle(
					"ties: " + record.getTie(Assets.userName), 50, 275, 50);
			g.drawStringDrawingGuidesStyle(
					"lost: " + record.getLoss(Assets.userName), 50, 350, 50);
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
