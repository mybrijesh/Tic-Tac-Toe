package com.mybrijesh.tictactoegame;

import java.util.List;

import com.mybrijesh.framework.Input.TouchEvent;
import com.mybrijesh.framework.Game;
import com.mybrijesh.framework.Graphics;
import com.mybrijesh.framework.Screen;

public class MainMenuScreen extends Screen
{
	private boolean playClick;
	private boolean scoreClick;
	private boolean exitClick;
	private boolean fullyLoaded;
	private float deltaCounter;
	private boolean drawOnce;

	public MainMenuScreen(Game game)
	{
		// TODO Auto-generated constructor stub
		super(game);
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		touchEvents.clear();
		playClick = false;
		scoreClick = false;
		exitClick = false;
		fullyLoaded = false;
		deltaCounter = 0;
		drawOnce =true;
	}

	@Override
	public void update(float deltaTime)
	{
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		game.getInput().getKeyEvents();

		int len = touchEvents.size();
		for (int i = 0; i < len; i++)
		{
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_UP)
			{
				if (inBounds(event, Assets.play_x, Assets.play_y, Assets.play_width, Assets.play_height))
				{
					this.playClick = true;
				}
				if (inBounds(event, Assets.score_x, Assets.score_y, Assets.score_width, Assets.score_height))
				{
					this.scoreClick = true;
				}
				if (inBounds(event, Assets.exit_x, Assets.exit_y, Assets.exit_width, Assets.exit_height))
				{
					this.exitClick = true;
				}
			}
		}
	}

	private boolean inBounds(TouchEvent event, int x, int y, int width,
			int height)
	{
		if (event.x > x && event.x < x + width - 1 && event.y > y
				&& event.y < y + height - 1)
			return true;
		else
			return false;
	}

	@Override
	public void present(float deltaTime)
	{
		// TODO Auto-generated method stub
		Graphics g = game.getGraphics();

		if (!fullyLoaded)
		{
//			Graphics g = game.getGraphics();
			g.drawPixmap(Assets.background, Assets.background_x, Assets.background_y);
			g.drawPixmap(Assets.gameTitleImage, Assets.title_x, Assets.title_y);// 60,50
			g.drawPixmap(Assets.play, Assets.play_x, Assets.play_y);
			g.drawPixmap(Assets.score, Assets.score_x, Assets.score_y);
			g.drawPixmap(Assets.exit, Assets.exit_x, Assets.exit_y);
			fullyLoaded = true;
		}
		if (playClick)
		{
			deltaCounter += deltaTime;
			if(drawOnce)
			{
				g.drawPixmap(Assets.background, Assets.background_x, Assets.background_y);
				g.drawPixmap(Assets.gameTitleImage, Assets.title_x, Assets.title_y);// 10,50
				g.drawPixmap(Assets.playClicked, Assets.play_x, Assets.play_y);
				g.drawPixmap(Assets.score, Assets.score_x,Assets.score_y);//85,175+60
				g.drawPixmap(Assets.exit, Assets.exit_x,Assets.exit_y);
			}
			if(deltaCounter >0.2)
				game.setScreen(new GameTypeChoiceScreen(game));
		}
		if (scoreClick)
		{
			deltaCounter += deltaTime;
			if(drawOnce)
			{
				g.drawPixmap(Assets.background, Assets.background_x, Assets.background_y);
				g.drawPixmap(Assets.gameTitleImage, Assets.title_x, Assets.title_y);// 10,50
				g.drawPixmap(Assets.play, Assets.play_x, Assets.play_y);
				g.drawPixmap(Assets.scoreClicked, Assets.score_x, Assets.score_y);
				g.drawPixmap(Assets.exit, Assets.exit_x,Assets.exit_y);
			}
			if(deltaCounter >0.2)
				game.setScreen(new ScoreScreen(game));
		}
		if (exitClick)
		{
			deltaCounter += deltaTime;
			if(drawOnce)
			{		
				g.drawPixmap(Assets.background, Assets.background_x, Assets.background_y);
				g.drawPixmap(Assets.gameTitleImage, Assets.title_x, Assets.title_y);// 10,50
				g.drawPixmap(Assets.play, Assets.play_x, Assets.play_y);
				g.drawPixmap(Assets.score, Assets.score_x, Assets.score_y);
				g.drawPixmap(Assets.exitClicked, Assets.exit_x, Assets.exit_y);
			}
			if(deltaCounter > 0.2)
				System.exit(0);
		}

		
	}

	@Override
	public void pause()
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void resume()
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void dispose()
	{
		// TODO Auto-generated method stub
	}

}
