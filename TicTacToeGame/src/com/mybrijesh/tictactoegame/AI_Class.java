package com.mybrijesh.tictactoegame;

import java.util.Random;

public class AI_Class
{
	private Random mRand;
	public int board[];
	public int computer = 2, human = 1, empty = 0;
	public AI_Class()
	{
		mRand = new Random();
	}
	//_____________________________________________________
	private int hor_ver_location(int x, int y, int arrLim, int inc, 
			int attack, int defend)
	{
		for(int i=0;i<arrLim;i+=inc)
		{
			if(board[i] == board[i+y] && board[i] == attack)
				if(board[i+x] !=computer && board[i+x] != defend)
					return i+x;
			if(board[i+x] == board[i] && board[i] == attack)
				if(board[i+y] != computer && board[i+y] != defend)
					return i+y;
			if(board[i+x] == board[i+y] && board[i+x] ==  attack)
				if(board[i] != computer  && board[i] != defend)
					return i;
		}
		return -1;
	}
	private int diagonally(int x, int y, int z,int attack, int defend)
	{
		if(board[x] == board[y] && board[x] == attack)
			if(board[z] != computer && board[z] != defend)
				return z;
		return -1;
	}
	public int doAttack(int attack, int defend)
	{
		int pos;
		//make AI do Offense Horizontal
		if((pos = hor_ver_location(2,1,9,3,attack,defend)) != -1)//horizontal
			return pos;
		else if((pos = hor_ver_location(6,3,3,1,attack,defend)) != -1)//vertical
			return pos;
		else if((pos = diagonally(0,4,8,attack,defend)) != -1)
			return pos;
		else if((pos = diagonally(8,4,0,attack,defend)) != -1)
			return pos;
		else if((pos = diagonally(8,0,4,attack,defend)) != -1)
			return pos;
		else if((pos = diagonally(6,4,2,attack,defend)) != -1)
			return pos;
		else if((pos = diagonally(2,4,6,attack,defend)) != -1)
			return pos;
		else if((pos = diagonally(2,6,4,attack,defend)) != -1)
			return pos;
		return -1;
	}
	//______________________________________________________________
	//THIS BLOCK METHOD IS FOR EASY MODE
	public int doBlockEasy()
	{
		return doAttack(human,computer);//block and attack shares same code
	}
	//THIS BLOCK METHOD IS FOR HARD MODE
	public int doBlock()
	{
		int pos;
		if((pos = doBlockEasy())!= -1)
			return pos;
		//defend two corner offense
		if(checkMovesMade() == 3 && ((board[0] == human && board[8] == human)||
				(board[2] == human && board[6] == human)))
		{
			pos = mRand.nextInt(3);
			if(pos == 1)
				return 1;
			else if(pos == 2)
				return 3;
			else if(pos == 3)
				return 5;
			else
				return 7;
		}
		//defend triangle when computer is in middle
		if(checkMovesMade() == 3 && (board[4] == computer))
		{
			if((board[0] == human && board[2] == human))
				return 1;
			else if((board[0] == human && board[6] == human))
				return 3;
			else if((board[2] == human && board[8] == human))
				return 5;
			else if((board[6] == human && board[8] == human))
				return 7;
		}
		//Triangle
		if(checkMovesMade() == 3 && (board[4] == human))
		{
			int findLastComPos = 0;
			for(int i=0;i<board.length;i++)
			{
				if(board[i] == computer)
				{
					findLastComPos = i;
					break;
				}
			}
			if(findLastComPos == 0 && board[2] != human)
				return 2;
			else if(findLastComPos == 0 && board[6] != human)
				return 6;
			else if(findLastComPos == 2 && board[0] != human)
				return 0;
			else if(findLastComPos == 2 && board[8] != human)
				return 8;
			else if(findLastComPos == 6 && board[0] != human)
				return 0;
			else if(findLastComPos == 6 && board[8] != human)
				return 8;
			else if(findLastComPos == 8 && board[2] != human)
				return 2;
			else if(findLastComPos == 8 && board[6] != human)
				return 6;
		}
		if(checkMovesMade()==1 && (board[0] ==human || board[2] ==human ||
				board[6] ==human || board[8] ==human))
		{
			return 4;
		}
		if(checkMovesMade()==1 && (board[4] == human))
		{
			pos =  mRand.nextInt(3);//to get random corner
			if(pos == 1)
				return 0;
			else if(pos == 2)
				return 2;
			else if(pos == 3)
				return 6;
			else
				return 8;
		}
		return -1;
	}
	//_________________________________________________________________
	//check how many moves made in game
	public int checkMovesMade()
	{
		int c=0;
		for(int i=0;i<board.length;i++)
		{
			if(board[i] == human || board[i] == computer)
				c++;
		}
		return c;
	}
}
/*horizontal offense
for(int i=0;i<=6;i+=3)
{
	if(board[i] == board[i+1] && board[i] == computer)
		if(board[i+2] !=computer && board[i+2] != human)
			return i+2;
	if(board[i+2] == board[i] && board[i] == computer)
		if(board[i+1] != computer && board[i+1] != human)
			return i+1;
	if(board[i+2] == board[i+1] && board[i+2] ==  computer)
		if(board[i] != computer  && board[i] != human)
			return i;
}
//AI Offense Vertical
	for(int i=0;i < 3;i++)
		if(board[i] == board[i+3] && board[i] ==  computer)
			if(board[i+6] != computer  && board[i+6] != human)
				return i+6;
	
	for(int i=0;i < 3;i++)
		if(board[i+6] == board[i+3] && board[i+6] ==  computer)
			if(board[i] != computer && board[i] != human)
				return i;
	
	for(int i=0;i < 3;i++)
		if(board[i+6] == board[i] && board[i] ==  computer)
			if(board[i+3] != computer && board[i+3] != human)
				return i+3;
*/