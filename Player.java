package com.kct.fifthsem.cseb.assignment.hangman;


public class Player {
	
	private String playerName = null;
	
	private int numberofLifes;
	
	private int numberofWordsIdentified;
	
	private Word[] wordsIdentifiedByPlayer = null;
	
	public Player(String playerName) 
	{
		this.playerName = playerName;
		this.numberofLifes = 4;
		this.numberofWordsIdentified = 0;
	}
	
	public String getPlayerName()
	{
		return this.playerName;
	}
	
	public int getNumberofLifes()
	{
		return this.numberofLifes;
	}
	
	public void addLifetoUser(final int numberofLifestoAdd)
	{
		this.numberofLifes+=numberofLifestoAdd;
	}
	
	public void reduceLifeofUserByOne()
	{
		this.numberofLifes--;
	}
	
	private void upadteUserWordIdentifiedCount()
	{
		this.numberofWordsIdentified++;
	}
	
	public int getNumberofWordsIdentified()
	{
		return this.numberofWordsIdentified;
	}
	
	public Word[] getListofWordsIdentifiedByPlayer()
	{
		return this.wordsIdentifiedByPlayer;
	}
	
	public void updateWordIndentifiedByPlayerInList(final Word word)
	{
		if(this.wordsIdentifiedByPlayer == null)
		{
			this.wordsIdentifiedByPlayer =  new Word[20];
		}
		
		for(int index=0;index<this.wordsIdentifiedByPlayer.length;
				 index++)
		{
			if(wordsIdentifiedByPlayer[index]==null)
			{
				wordsIdentifiedByPlayer[index] = word;
				break;
			}
			
		}
		
		
		
		this.upadteUserWordIdentifiedCount();
	}
	
	
	public boolean isPlayerIdentifiedThisWord(final Word word)
	{
		if(this.wordsIdentifiedByPlayer!=null)
		{
			for(Word wordinList : this.wordsIdentifiedByPlayer)
			{
				if(wordinList!=null && wordinList.equals(word))
				{
					return true;
				}
			
			}
			
		}
		
		return false;
	}

}
