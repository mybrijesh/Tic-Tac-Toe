package com.mybrijesh.tictactoegame;

import java.util.List;

import com.mybrijesh.framework.Game;
import com.mybrijesh.framework.Graphics;
import com.mybrijesh.framework.Screen;
import com.mybrijesh.framework.Input.TouchEvent;

public class GameTypeChoiceScreen extends Screen
{

	private boolean OnePlayerClick, TwoPlayerClick;
	private float deltaCounter;

	public GameTypeChoiceScreen(Game game)
	{
		super(game);
		// TODO Auto-generated constructor stub
		deltaCounter=0;
		OnePlayerClick = false;
		TwoPlayerClick = false;
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		touchEvents.clear();
	}

	@Override
	public void update(float deltaTime)
	{
		// TODO Auto-generated method stub
		Graphics g = game.getGraphics();
		g.drawPixmap(Assets.background, Assets.background_x, Assets.background_y);
		g.drawPixmap(Assets.gameTitleImage, Assets.title_x, Assets.title_y);
	}

	@Override
	public void present(float deltaTime)
	{
		// TODO Auto-generated method stub
		Graphics g = game.getGraphics();
		
		if(OnePlayerClick)
		{
			g.drawPixmap(Assets.OnePlayerClicked, Assets.OnePlayer_x, Assets.OnePlayer_y);//35,175
			deltaCounter  += deltaTime;
			if(deltaCounter > 0.3)
//				game.setScreen(new OnePlayerGameScreen(game));
				game.setScreen(new DifficultyChoiceAndName(game));
		}
		else
			g.drawPixmap(Assets.OnePlayer, Assets.OnePlayer_x, Assets.OnePlayer_y);
		
		if(TwoPlayerClick)
		{
			g.drawPixmap(Assets.TwoPlayerClicked, Assets.TwoPlayer_x, Assets.TwoPlayer_y);
			deltaCounter += deltaTime;
			if(deltaCounter >0.3)
				game.setScreen(new TwoPlayerGameScreen(game));
		}
		else
			g.drawPixmap(Assets.TwoPlayer, Assets.TwoPlayer_x, Assets.TwoPlayer_y);
		
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		game.getInput().getKeyEvents();
		
		int len = touchEvents.size();
		for(int i=0; i < len;i++)
		{
			TouchEvent event = touchEvents.get(i);
			if(event.type == TouchEvent.TOUCH_UP)
			{
				if(inBounds(event, Assets.OnePlayer_x, Assets.OnePlayer_y, Assets.OnePlayer_width, Assets.OnePlayer_height))
				{
					this.OnePlayerClick = true;
				}
				if(inBounds(event,Assets.TwoPlayer_x,Assets.TwoPlayer_y,Assets.TwoPlayer_width,Assets.TwoPlayer_height))
					TwoPlayerClick = true;
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
