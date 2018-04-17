package com.mybrijesh.tictactoegame;

import java.util.List;

import com.mybrijesh.framework.Game;
import com.mybrijesh.framework.Graphics;
import com.mybrijesh.framework.Screen;
import com.mybrijesh.framework.Input.TouchEvent;

public class DifficultyChoiceAndName extends Screen
{
	private boolean easyClicked;
	private boolean hardClicked;
	private float counter;

	public DifficultyChoiceAndName(Game game)
	{
		super(game);
		easyClicked = false;
		hardClicked = false;
		counter = 0;
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		touchEvents.clear();
	}

	@Override
	public void update(float deltaTime)
	{
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		game.getInput().getKeyEvents();
		int len = touchEvents.size();
		for(int i=0; i < len;i++)
		{
			TouchEvent event = touchEvents.get(i);
			if(event.type == TouchEvent.TOUCH_UP)
			{
				if(inBounds(event, Assets.easy_x, Assets.easy_y, Assets.easy_width, Assets.easy_height))
				{
					this.easyClicked = true;
				}
				if(inBounds(event, Assets.hard_x,Assets.hard_y,Assets.hard_width,Assets.hard_height))
				{
					hardClicked = true;
				}
			}
		}
	}

	@Override
	public void present(float deltaTime)
	{
		Graphics g = game.getGraphics();
		g.drawPixmap(Assets.background, Assets.background_x, Assets.background_y);
		g.drawPixmap(Assets.gameTitleImage, Assets.title_x, Assets.title_y);
		if(easyClicked)
		{
			g.drawPixmap(Assets.easyLevelClicked, Assets.easy_x, Assets.easy_y);
			counter += deltaTime;
			if(counter > 0.5)
				game.setScreen(new OnePlayerGameScreen(game, true));
		}
		else
			g.drawPixmap(Assets.easyLevel, Assets.easy_x, Assets.easy_y);
		if(hardClicked)
		{
			g.drawPixmap(Assets.hardLevelClicked, Assets.hard_x, Assets.hard_y);
			counter += deltaTime;
			if(counter > 0.5)
				game.setScreen(new OnePlayerGameScreen(game, false));
		}
		else
			g.drawPixmap(Assets.hardLevel, Assets.hard_x, Assets.hard_y);
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
	public void pause()
	{}

	@Override
	public void resume()
	{}

	@Override
	public void dispose()
	{}

}
