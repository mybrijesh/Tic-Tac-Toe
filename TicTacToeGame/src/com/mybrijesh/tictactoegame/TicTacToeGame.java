package com.mybrijesh.tictactoegame;

import java.util.Random;

public class TicTacToeGame extends AI_Class
{
	private final static int boardSize = 9;

	private Random randNumber;
	public TicTacToeGame()
	{
		board = new int[boardSize];
		
		for(int i=0;i<boardSize;i++)
				board[i] = empty;
		randNumber = new Random();
	}
	public boolean setMoveOnBoard(boolean isHuman,int x, int y)
	{
		if(board[getLocation(x,y)] == empty)
		{
			if(isHuman)
				board[getLocation(x,y)] = human;
			else
				board[getLocation(x,y)] = computer;
		}
		else
			return false;
		return true;
	}
	public void clearBorad()
	{
		for(int i=0; i<boardSize; i++)
			board[i] = empty;
	}
	public int getComputerMove(boolean easy,boolean humanStarts)
	{	
		int move;
		if((move= doAttack(2,1)) != -1)
		{
			board[move] = 2;
			if(this.checkWin() ==  3)
			board[move] = 0;
				return move;
		}
		if(easy)
			move = doBlockEasy();
		else
			move = doBlock();
		if(move == -1)
			move = doAttack(2,1);
		if(move == -1)
			do
			{
				move = randNumber.nextInt(boardSize);
				
			}while(board[move] ==human|| board[move] == computer);
		return move;
	}
	public int getX(int location)
	{
		if (location == 0 || location == 3 || location == 6)
			return 10;
		if (location == 1 || location == 4 || location == 7)
			return 113;
		if (location == 2 || location == 5 || location == 8)
			return 214;
		return 0;
	}

	public int getY(int location)
	{
		if (location == 0 || location == 1 || location == 2)
			return 73;
		if (location == 3 || location == 4 || location == 5)
			return 166;
		if (location == 6 || location == 7 || location == 8)
			return 262;
		return 0;
	}

	public int getLocation(int x, int y)
	{
		if (x == 10 && y == 73)
			return 0;
		if (x == 113 && y == 73)
			return 1;
		if (x == 214 && y == 73)
			return 2;
		if (x == 10 && y == 166)
			return 3;
		if (x == 113 && y == 166)
			return 4;
		if (x == 214 && y == 166)
			return 5;
		if (x == 10 && y == 262)
			return 6;
		if (x == 113 && y == 262)
			return 7;
		if (x == 214 && y == 262)
			return 8;

		return 10;

	}
	public boolean checkIfValidMove(int x, int y)
	{
		int loc = getLocation(x,y);
		if(board[loc] == human || board[loc] == computer)
			return false;
		return true;
	}
	//1 = tie
	//2 = human
	//3 = computer
	//0 = game if not over
	public int checkWin()
	{
		//checking for horizontal win
		for(int i =0 ; i<= 6 ; i+=3)
		{
			{
				if(board[i] == human&&
					board[i+1] == human&&
					board[i+2] == human)
				{
					return 2;
				}
				if(board[i] == computer&&
					board[i+1] == computer&&
					board[i+2] == computer)
				{
					return 3;
				}
			}
			
		}
		
		//checking for vertical win
		for(int i=0;i<=2;i++)
		{
			if(board[i] == human&&
				board[i+3]==human&&
				board[i+6] == human)
			{
				return 2;
			}
			if(board[i] == computer&&
				board[i+3]==computer&&
				board[i+6] == computer)
			{
				return 3;
			}
		}
		
		//now checking for the cross/diagonal 
		if(board[0] == human &&
			board[4] == human &&
			board[8] == human ||
			board[2] == human &&
			board[4] == human &&
			board[6] == human)
		{
			return 2;
		}
		if(board[0] == computer &&
			board[4] == computer &&
			board[8] == computer ||
			board[2] == computer &&
			board[4] == computer &&
			board[6] == computer)
		{
			return 3;
		}
		
		for(int i=0;i<board.length;i++)
		{
			if(board[i] != human && board[i] != computer)
				return 0;//this if game is still going on
		}
		return 1;//only when game is tie
	}
}
