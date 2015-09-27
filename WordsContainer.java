package com.kct.fifthsem.cseb.assignment.hangman;

public final class WordsContainer {
	
	private static final Word[] WORDSLISTTOPLAY = {
			
			new Word("apple"), new Word("india"), new Word("laptop"),
			new Word("bag"), new Word("charger"), new Word("picture"),
			new Word("draw"), new Word("sky"), new Word("box"),
			new Word("inch"), new Word("wish"), new Word("subject"),
			new Word("catch"), new Word("north"), new Word("eleven"),
			new Word("magnet"), new Word("universe"), new Word("philadelphia"),
			new Word("shallow"), new Word("shout"), new Word("occasionally")
	};
	
	private static final int SIZEOFWORDLIST = WORDSLISTTOPLAY.length;
	
	
	public static Word wordToPlay()
	{
		return (generateRandomWordToPlay());
		
	}
	
	private static Word generateRandomWordToPlay()
	{
		
		int randomNumber = (int)(Math.random()*SIZEOFWORDLIST); 
		
		return WORDSLISTTOPLAY[randomNumber];
	}

	public static boolean isPlayerPlayedAlltheWords(Player player)
	{
		if(player!=null 
			&& player.getNumberofWordsIdentified() == SIZEOFWORDLIST)
		{
			return true;
		}
		
		return false;
	}

}
