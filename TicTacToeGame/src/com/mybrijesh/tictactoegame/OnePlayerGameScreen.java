package com.mybrijesh.tictactoegame;

import java.util.List;

import com.mybrijesh.framework.Game;
import com.mybrijesh.framework.Graphics;
import com.mybrijesh.framework.Input.TouchEvent;
import com.mybrijesh.framework.Screen;

public class OnePlayerGameScreen extends Screen
{
	enum GameState
	{
		Ready, Running, Paused, GameOver
	}
	
	GameState gState;
	TicTacToeGame data;
	UserScore record;
	
	private char[] movesRec;
	private int x;
	private int y;
	private boolean clicked;
	private boolean humanTurn = true;
	private boolean humanStarts = true;
	private boolean itsTie;
	private boolean humanWins;
	private boolean computerWins;
	private float deltaCounter,delayMove;
	private boolean easy;
	
	public OnePlayerGameScreen(Game game, boolean e)
	{
		super(game);
		gState = GameState.Ready;
		record = game.getPlayerRecord();
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		touchEvents.clear();
		movesRec = new char[9];
		clicked = false;
		data = new TicTacToeGame();
		itsTie = false;
		humanWins = false;
		computerWins = false;
		deltaCounter = 0;
		delayMove = 0;
		easy = e;
	}
	public void startNewGame()
	{
		clicked = false;
		x =0;
		y =0;
		itsTie = false;
		humanWins = false;
		computerWins = false;
		humanTurn = humanStarts;
		deltaCounter = 0;
		delayMove = 0;
		deltaCounter = 0;
		data.clearBorad();
		clearMovesRecord();
		gState = GameState.Ready;
	}
	public void clearMovesRecord()
	{
		for(int i=0;i<movesRec.length;i++)
		{
			movesRec[i] = ' ';
		}
	}
	public void checkForWin(float deltaTime)
	{
		deltaCounter  += deltaTime;
		if(data.checkWin() == 1)
			if(deltaCounter > 0.5)
			{
				itsTie = true;
				record.addTie(Assets.userName,""+ 1);
			}
		if(data.checkWin() == 2)
			if(deltaCounter > 0.5)
			{
				humanWins = true;
				record.addWin(Assets.userName,""+1);
			}
		if(data.checkWin() == 3)
			if(deltaCounter > 0.5)
			{
				computerWins = true;
				record.addLoss(Assets.userName,""+1);
			}
		
		if(data.checkWin() != 0)
		{
			gState = GameState.GameOver;
			deltaCounter = 0;
			if(humanStarts)
				humanStarts = false;
			else
				humanStarts = true;
		}
	}
	private void saveGame()
	{
		game.savePlayerRecord(record);
	}
	private void makeMove(int x, int y, boolean flag)
	{
		if(data.checkIfValidMove(x,y))
		{
			if(flag)
			{
				data.setMoveOnBoard(true, x,y);
//				movesRec[data.getLocation(x, y)] = 'O';
				clicked = true;
			}
			else
			{
				data.setMoveOnBoard(false, x,y);
//				movesRec[data.getLocation(x, y)] = 'X';
				clicked = true;
			}
		}	
	}
//__________________________________________________________________________________
	@Override
	public void update(float deltaTime)
	{
		List<TouchEvent> touchevent = game.getInput().getTouchEvents();
		game.getInput().getKeyEvents();
		
		if(gState == GameState.Ready)
			updateReadyState(touchevent);
		if(gState == GameState.Running)
			updateRunningState(touchevent, deltaTime);
		if(gState == GameState.GameOver)
			updateGameOverState(touchevent, deltaTime);
	}
	private void updateReadyState(List<TouchEvent> touchevent)
	{
		if(humanTurn)
		{
			if(touchevent.size() > 0)
				gState = GameState.Running;
		}
		else
		{
			gState = GameState.Running;
		}
	}
	private void updateRunningState(List<TouchEvent> touchEvents, float deltaTime)
	{
		int length = touchEvents.size();
		if(!humanTurn)
		{
			delayMove += deltaTime;
			if(delayMove > 1)
			{
				int move = data.getComputerMove(easy, this.humanStarts);
				x = data.getX(move);
				y = data.getY(move);
				makeMove(x,y,false);
				delayMove = 0;
			}
		}
		if(humanTurn)
		{
			for (int i = 0; i < length; i++)
			{
				TouchEvent event = touchEvents.get(i);
				if (event.type == TouchEvent.TOUCH_UP)
				{
					if (inBounds(event, Assets.Circle1_x, Assets.Circle1_y,Assets.Circle_width, Assets.Circle_height))
					{
						x = Assets.Circle1_x; y = Assets.Circle1_y;
						makeMove(x,y,true);
					}
					if (inBounds(event, Assets.Circle2_x, Assets.Circle2_y,Assets.Circle_width, Assets.Circle_height))
					{
						x = Assets.Circle2_x; y = Assets.Circle2_y;
						makeMove(x,y,true);
					}
					if (inBounds(event, Assets.Circle3_x, Assets.Circle3_y, Assets.Circle_width, Assets.Circle_height))
					{
						x = Assets.Circle3_x; y = Assets.Circle3_y;
						makeMove(x,y,true);
					}
					if (inBounds(event, Assets.Circle4_x, Assets.Circle4_y, Assets.Circle_width, Assets.Circle_height))
					{
						x = Assets.Circle4_x; y = Assets.Circle4_y;
						makeMove(x,y,true);
					}
					if (inBounds(event, Assets.Circle5_x, Assets.Circle5_y, Assets.Circle_width, Assets.Circle_height))
					{
						x = Assets.Circle5_x; y = Assets.Circle5_y;
						makeMove(x,y,true);
					}
					if (inBounds(event, Assets.Circle6_x, Assets.Circle6_y, Assets.Circle_width, Assets.Circle_height))
					{
						x = Assets.Circle6_x; y = Assets.Circle6_y;
						makeMove(x,y,true);
					}
					if (inBounds(event, Assets.Circle7_x, Assets.Circle7_y, Assets.Circle_width, Assets.Circle_height))
					{
						x = Assets.Circle7_x; y = Assets.Circle7_y;
						makeMove(x,y,true);
					}
					if (inBounds(event, Assets.Circle8_x, Assets.Circle8_y, Assets.Circle_width, Assets.Circle_height))
					{
						x = Assets.Circle8_x; y = Assets.Circle8_y;
						makeMove(x,y,true);
					}
					if (inBounds(event, Assets.Circle9_x, Assets.Circle9_y, Assets.Circle_width, Assets.Circle_height))
					{
						x = Assets.Circle9_x; y = Assets.Circle9_y;
						makeMove(x,y,true);
					}
				}
			}
		}
	}

	private void updateGameOverState(List<TouchEvent> touchevent, float deltaTime)
	{
		deltaCounter  += deltaTime;
		int length = touchevent.size();
		if(deltaCounter > 1)
			if(touchevent.size() > 0)
			{
				for (int i = 0; i < length; i++)
				{
					TouchEvent event = touchevent.get(i);
					if (event.type == TouchEvent.TOUCH_UP)
					{
						if(inBounds(event, Assets.CloseSign_x, Assets.CloseSign_y, Assets.CloseSign_width, Assets.CloseSign_height))
						{
							saveGame();
							game.setScreen(new MainMenuScreen(game));
						}
						else
						{
							startNewGame();
						}
					}
				}
			}
	}
//______________________________________________________________________________________
	@Override
	public void present(float deltaTime)
	{
		if(gState == GameState.Ready)
			presentReadyState();
		if(gState == GameState.Running)
			presentRunningState(deltaTime);
		if(gState == GameState.GameOver)
			presentGameOverState();
	}
	private void presentReadyState()
	{
		Graphics g = game.getGraphics();
		g.drawPixmap(Assets.background, Assets.background_x, Assets.background_y);
		g.drawPixmap(Assets.VerticalLine, Assets.VLine_x, Assets.VLine_y);// 100,60
		g.drawPixmap(Assets.VerticalLine, Assets.VLine2_x, Assets.VLine2_y);// 200,60
		g.drawPixmap(Assets.HorizontalLine, Assets.HLine_x, Assets.HLine_y);// -10,150
		g.drawPixmap(Assets.HorizontalLine, Assets.HLine2_x, Assets.Hline2_y);// -10,245
		
		if(humanTurn)
			g.drawStringEraserStyle("YOUR TURN", Assets.humanTurn_x, Assets.humanTurn_y, Assets.humanTurn_size);
	}
	
	private void presentRunningState(float deltaTime)
	{
		Graphics g = game.getGraphics();
		{
			if(clicked)
			{
				drawTheMap(g);
				
				if(humanTurn)
				{
					g.drawPixmap(Assets.CircleSign, x, y);
					movesRec[data.getLocation(x, y)] = 'O';
					humanTurn = false;
				}
				else
				{
					g.drawPixmap(Assets.XSign, x, y);
					movesRec[data.getLocation(x, y)] = 'X';
					humanTurn = true;
					g.drawStringEraserStyle("YOUR TURN", Assets.humanTurn_x, Assets.humanTurn_y, Assets.humanTurn_size);
				}
				clicked = false;
			}
			checkForWin(deltaTime);

		}
	}
	private void drawTheMap(Graphics g)
	{
		g.drawPixmap(Assets.background, Assets.background_x, Assets.background_y);
		g.drawPixmap(Assets.VerticalLine, Assets.VLine_x, Assets.VLine_y);// 100,60
		g.drawPixmap(Assets.VerticalLine, Assets.VLine2_x, Assets.VLine2_y);// 200,60
		g.drawPixmap(Assets.HorizontalLine, Assets.HLine_x, Assets.HLine_y);// -10,150
		g.drawPixmap(Assets.HorizontalLine, Assets.HLine2_x, Assets.Hline2_y);// -10,245
		for(int i=0;i<movesRec.length;i++)
		{
			if(movesRec[i]==('O'))
			{
				g.drawPixmap(Assets.CircleSign, data.getX(i), data.getY(i));
			}
			else if(movesRec[i]==('X'))
			{
				g.drawPixmap(Assets.XSign, data.getX(i), data.getY(i));
			}
		}
	}
	private void presentGameOverState()
	{
		Graphics g = game.getGraphics();
		drawTheMap(g);
//		g.drawPixmap(Assets.gameEndBackground, Assets.gameEndBackground_x, Assets.gameEndBackground_y);
		if(humanWins)
			g.drawPixmap(Assets.YouWon, Assets.YouWon_x, Assets.YouWon_y);
		if(computerWins)
			g.drawPixmap(Assets.YouLost, Assets.YouLost_x, Assets.YouLost_y);
		if(itsTie)
			g.drawPixmap(Assets.Tie, Assets.Tie_x, Assets.Tie_y);
		
		g.drawPixmap(Assets.CloseSign, Assets.CloseSign_x, Assets.CloseSign_y);
		g.drawPixmap(Assets.TryAgain, Assets.TryAgain_x, Assets.TryAgain_y);
	}
	//________________________________________________________________________________________
	@Override
	public void pause()
	{
		
	}

	@Override
	public void resume()
	{
		
	}

	@Override
	public void dispose()
	{
		
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
}
