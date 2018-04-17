package com.mybrijesh.tictactoegame;

import java.util.HashMap;

public class UserScore
{
	private HashMap<String, GameScore> record;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public UserScore()
	{
		record = new HashMap();
	}
	
	public void addRecord(String userName, GameScore rec)
	{
		record.put(userName, rec);
	}
	public void addWin(String name, String w)
	{
		int winScore;
		if(w == "")
		{
			winScore = 0;
		}
		else
			winScore = Integer.parseInt(w);
		
		GameScore rec = record.get(name);
		if(rec == null)
		{
			rec = new GameScore();
			rec.win = winScore;
			record.put(name, rec);
		}
		else
		{
			rec.win += winScore;
		}
	}
	public void addLoss(String name, String l)
	{
		int lossScore;
		if(l == "")
		{
			lossScore = 0;
		}
		else
			lossScore = Integer.parseInt(l);
		
		GameScore rec = record.get(name);
		if(rec == null)
		{
			rec = new GameScore();
			rec.loss = lossScore;
			record.put(name, rec);
		}
		else
		{
			rec.loss += lossScore;
		}
	}
	public void addTie(String name, String t)
	{
		int tieScore;
		if(t == "")
		{
			tieScore = 0;
		}
		else
			tieScore = Integer.parseInt(t);
		
		GameScore rec = record.get(name);
		if(rec == null)
		{
			rec = new GameScore();
			rec.tie = tieScore;
			record.put(name, rec);
		}
		else
		{
			rec.tie += tieScore;
		}
	}
	public int getWin(String name)
	{
		GameScore rec = record.get(name);
		if(rec != null)
			return rec.win;
		return 0;
	}
	public int getLoss(String name)
	{
		GameScore rec = record.get(name);
		if(rec != null)
			return rec.loss;
		return 0;
	}
	public int getTie(String name)
	{
		GameScore rec = record.get(name);
		if(rec != null)
			return rec.tie;
		return 0;
	}
}
