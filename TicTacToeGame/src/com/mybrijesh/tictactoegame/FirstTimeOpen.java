package com.mybrijesh.tictactoegame;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.mybrijesh.framework.Game;
import com.mybrijesh.framework.Screen;
import com.mybrijesh.framework.Input.KeyEvent;
import com.mybrijesh.framework.Input.TouchEvent;

public class FirstTimeOpen extends Screen
{

	public FirstTimeOpen(Game game)
	{
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(float deltaTime)
	{
		List<KeyEvent> keyEvents = game.getInput().getKeyEvents();
		int length = keyEvents.size();
		for (int i = 0; i < length; i++)
		{
			KeyEvent event = keyEvents.get(i);
			if (event.type == TouchEvent.TOUCH_UP)
			{

			}
		}
	}

	public void showSoftKeyboard(View view)
	{
		if (view.requestFocus())
		{
//			InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//			imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
		}
	}

	@Override
	public void present(float deltaTime)
	{}

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
