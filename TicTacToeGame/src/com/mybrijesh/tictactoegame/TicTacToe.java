package com.mybrijesh.tictactoegame;

import com.mybrijesh.framework.Screen;
import com.mybrijesh.framework.impl.AndroidGame;

public class TicTacToe extends AndroidGame
{
	@Override
	public Screen getStartScreen()
	{
		return new LoadingScreen(this);
	}
}
