package com.mybrijesh.tictactoegame;

import java.util.List;

import com.mybrijesh.framework.Game;
import com.mybrijesh.framework.Graphics;
import com.mybrijesh.framework.Screen;
import com.mybrijesh.framework.Input.TouchEvent;

public class TwoPlayerGameScreen extends Screen
{
	enum GameState
	{
		Ready, Running, Paused, GameOver
	}

	GameState state;
	TicTacToeGame data;
	private int x;
	private int y;
	private boolean clicked;
	private boolean playerOneTurn = true;
	private boolean playerOneStarts = true;
	private boolean itsTie;
	private boolean playerOneWins;
	private boolean playerTwoWins;
	private float deltaCounter;
	private char[] movesRec;

	public TwoPlayerGameScreen(Game game)
	{
		super(game);
		state = GameState.Ready;
		data = new TicTacToeGame();
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		touchEvents.clear();
		itsTie = false;
		playerOneWins = false;
		playerTwoWins = false;
		deltaCounter = 0;
		movesRec = new char[9];
	}

	public void startNewGame()
	{
		state = GameState.Ready;
		x = 0;
		y = 0;
		clicked = false;
		itsTie = false;
		playerOneWins = false;
		playerTwoWins = false;
		playerOneTurn = playerOneStarts;
		deltaCounter = 0;
		data.clearBorad();
		clearMovesRecord();
		state = GameState.Ready;
	}

	public void clearMovesRecord()
	{
		for (int i = 0; i < movesRec.length; i++)
		{
			movesRec[i] = ' ';
		}
	}

	public void checkForWin(float deltaTime)
	{
		deltaCounter += deltaTime;
		if (data.checkWin() == 1)
			if (deltaCounter > 0.5)
				itsTie = true;
		if (data.checkWin() == 2)
			if (deltaCounter > 0.5)
				playerOneWins = true;
		if (data.checkWin() == 3)
			if (deltaCounter > 0.5)
				playerTwoWins = true;

		if (data.checkWin() != 0)
		{
			state = GameState.GameOver;
			deltaCounter = 0;
			if (playerOneStarts)
				playerOneStarts = false;
			else
				playerOneStarts = true;
		}

	}

	private void makeMove(int x, int y, boolean flag)
	{
		if (data.checkIfValidMove(x, y))
		{
			if (flag)
			{
				data.setMoveOnBoard(true, x, y);
				movesRec[data.getLocation(x, y)] = 'O';
				clicked = true;
			} else
			{
				data.setMoveOnBoard(false, x, y);
				movesRec[data.getLocation(x, y)] = 'X';
				clicked = true;
			}
		}
	}

	@Override
	public void update(float deltaTime)
	{
		List<TouchEvent> touchevent = game.getInput().getTouchEvents();
		Graphics g = game.getGraphics();
		if (state == GameState.Ready)
			updateReady(touchevent, g, deltaTime);
		if (state == GameState.Running)
			updateRunnning(touchevent, g, deltaTime);
		if (state == GameState.Paused)
			updatePaused(touchevent, g, deltaTime);
		if (state == GameState.GameOver)
			updateGameOver(touchevent, g, deltaTime);
	}

	private void updateReady(List<TouchEvent> touchevent, Graphics g,
			float deltaTime)
	{
		if (touchevent.size() > 0)
			state = GameState.Running;
	}

	private void updateRunnning(List<TouchEvent> touchEvents, Graphics g,
			float deltaTime)
	{
		int length = touchEvents.size();
		for (int i = 0; i < length; i++)
		{
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_UP)
			{
				if (inBounds(event, Assets.Circle1_x, Assets.Circle1_y,
						Assets.Circle_width, Assets.Circle_height))
				{
					x = Assets.Circle1_x;
					y = Assets.Circle1_y;
					setMove();
				}
				if (inBounds(event, Assets.Circle2_x, Assets.Circle2_y,
						Assets.Circle_width, Assets.Circle_height))
				{
					x = Assets.Circle2_x;
					y = Assets.Circle2_y;
					setMove();
				}
				if (inBounds(event, Assets.Circle3_x, Assets.Circle3_y,
						Assets.Circle_width, Assets.Circle_height))
				{
					x = Assets.Circle3_x;
					y = Assets.Circle3_y;
					setMove();
				}
				if (inBounds(event, Assets.Circle4_x, Assets.Circle4_y,
						Assets.Circle_width, Assets.Circle_height))
				{
					x = Assets.Circle4_x;
					y = Assets.Circle4_y;
					setMove();
				}
				if (inBounds(event, Assets.Circle5_x, Assets.Circle5_y,
						Assets.Circle_width, Assets.Circle_height))
				{
					x = Assets.Circle5_x;
					y = Assets.Circle5_y;
					setMove();
				}
				if (inBounds(event, Assets.Circle6_x, Assets.Circle6_y,
						Assets.Circle_width, Assets.Circle_height))
				{
					x = Assets.Circle6_x;
					y = Assets.Circle6_y;
					setMove();
				}
				if (inBounds(event, Assets.Circle7_x, Assets.Circle7_y,
						Assets.Circle_width, Assets.Circle_height))
				{
					x = Assets.Circle7_x;
					y = Assets.Circle7_y;
					setMove();
				}
				if (inBounds(event, Assets.Circle8_x, Assets.Circle8_y,
						Assets.Circle_width, Assets.Circle_height))
				{
					x = Assets.Circle8_x;
					y = Assets.Circle8_y;
					setMove();
				}
				if (inBounds(event, Assets.Circle9_x, Assets.Circle9_y,
						Assets.Circle_width, Assets.Circle_height))
				{
					x = Assets.Circle9_x;
					y = Assets.Circle9_y;
					setMove();
				}
			}
		}
	}
	private void setMove()
	{
		if (playerOneTurn)
			makeMove(x, y, true);
		else
			makeMove(x, y, false);
	}
	private void updatePaused(List<TouchEvent> touchevent, Graphics g,
			float deltaTime)
	{}

	private void updateGameOver(List<TouchEvent> touchevent, Graphics g,
			float deltaTime)
	{
		deltaCounter += deltaTime;
		int length = touchevent.size();
		if (deltaCounter > 1)
			if (touchevent.size() > 0)
			{
				for (int i = 0; i < length; i++)
				{
					TouchEvent event = touchevent.get(i);
					if (event.type == TouchEvent.TOUCH_UP)
					{
						if (inBounds(event, Assets.CloseSign_x,
								Assets.CloseSign_y, Assets.CloseSign_width,
								Assets.CloseSign_height))
						{
							game.setScreen(new MainMenuScreen(game));
						} else
						{
							startNewGame();
						}
					}
				}
			}
	}

	@Override
	public void present(float deltaTime)
	{
		Graphics g = game.getGraphics();
		if (state == GameState.Ready)
			presentReadyGUI(g, deltaTime);
		if (state == GameState.Running)
			presentRunnningGUI(g, deltaTime);
		if (state == GameState.Paused)
			presentPausedGUI(g, deltaTime);
		if (state == GameState.GameOver)
			presentGameOverGUI(g, deltaTime);
	}

	private void presentReadyGUI(Graphics g, float deltaTime)
	{
		g.drawPixmap(Assets.background, Assets.background_x,
				Assets.background_y);
		g.drawPixmap(Assets.VerticalLine, Assets.VLine_x, Assets.VLine_y);// 100,60
		g.drawPixmap(Assets.VerticalLine, Assets.VLine2_x, Assets.VLine2_y);// 200,60
		g.drawPixmap(Assets.HorizontalLine, Assets.HLine_x, Assets.HLine_y);// -10,150
		g.drawPixmap(Assets.HorizontalLine, Assets.HLine2_x, Assets.Hline2_y);// -10,245
		if (playerOneTurn)
		{
			g.drawStringEraserStyle("PLAYER 1 TURN", Assets.playerTurn_x,
					Assets.playerTurn_y, Assets.playerTurn_size);
		} else
		{
			g.drawStringEraserStyle("PLAYER 2 TURN", Assets.playerTurn_x,
					Assets.playerTurn_y, Assets.playerTurn_size);
		}
	}

	private void presentRunnningGUI(Graphics g, float deltaTime)
	{
		if (clicked)
		{
			drawTheMap(g);
			clicked = false;
			if (playerOneTurn)
			{
				playerOneTurn = false;
				g.drawStringEraserStyle("PLAYER 2 TURN", Assets.playerTurn_x,
						Assets.playerTurn_y, Assets.playerTurn_size);
			} else
			{
				playerOneTurn = true;
				g.drawStringEraserStyle("PLAYER 1 TURN", Assets.playerTurn_x,
						Assets.playerTurn_y, Assets.playerTurn_size);
			}
		}
		checkForWin(deltaTime);
	}

	private void drawTheMap(Graphics g)
	{
		g.drawPixmap(Assets.background, Assets.background_x,
				Assets.background_y);
		g.drawPixmap(Assets.VerticalLine, Assets.VLine_x, Assets.VLine_y);// 100,60
		g.drawPixmap(Assets.VerticalLine, Assets.VLine2_x, Assets.VLine2_y);// 200,60
		g.drawPixmap(Assets.HorizontalLine, Assets.HLine_x, Assets.HLine_y);// -10,150
		g.drawPixmap(Assets.HorizontalLine, Assets.HLine2_x, Assets.Hline2_y);// -10,245
		for (int i = 0; i < movesRec.length; i++)
		{
			if (movesRec[i] == ('O'))
			{
				g.drawPixmap(Assets.CircleSign, data.getX(i), data.getY(i));
			} else if (movesRec[i] == ('X'))
			{
				g.drawPixmap(Assets.XSign, data.getX(i), data.getY(i));
			}
		}
	}

	private void presentPausedGUI(Graphics g, float deltaTime)
	{}

	private void presentGameOverGUI(Graphics g, float deltaTime)
	{
		drawTheMap(g);
		if (playerOneWins)
			g.drawPixmap(Assets.YouWon, Assets.YouWon_x, Assets.YouWon_y);
		if (playerTwoWins)
			g.drawPixmap(Assets.YouLost, Assets.YouLost_x, Assets.YouLost_y);
		if (itsTie)
			g.drawPixmap(Assets.Tie, Assets.Tie_x, Assets.Tie_y);

		g.drawPixmap(Assets.CloseSign, Assets.CloseSign_x, Assets.CloseSign_y);
		g.drawPixmap(Assets.TryAgain, Assets.TryAgain_x, Assets.TryAgain_y);
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

	private boolean inBounds(TouchEvent event, int x, int y, int width,
			int height)
	{
		if (event.x > x && event.x < x + width - 1 && event.y > y
				&& event.y < y + height - 1)
			return true;
		else
			return false;
	}
}
