package com.kct.fifthsem.cseb.assignment.hangman;

public class Word {
	
	private String wordString  = null;
	
	private int length = 0;
	
	private char[] wordInCharArray = null;
	
	private char[] listofLettersFound =  null;
	
	private int numberofLettersFoundinWord = 0;
	
	private char[] displayWordForGame = null;
	
	public Word(final String word)
	{
		if(word!=null && word.length()>0)
		{
			this.wordString = word;
			
			this.length = word.length();
			
			this.wordInCharArray = word.toCharArray();
			
			this.initilizeDisplayWordFormart();
		}
	}
	
	private void initilizeDisplayWordFormart() {
		
		displayWordForGame =  new char[length];
		
		for(int index=0;index<length;index++)
		{
			displayWordForGame[index] = '_';
		}
		
	}
	
	public String wordInGameFormat()
	{
		return new String(this.displayWordForGame);
	}
	
	public void updateDisplayWordFormat(final int[] indexcestoUpatde,char letter)
	{
		if(indexcestoUpatde!=null)
		{
			int numberofTimesLetterOcurred = 0;
			for(int index=0;index<indexcestoUpatde.length;index++)
			{
				if(indexcestoUpatde[index]==1)
				{
					this.displayWordForGame[index] = letter;
					numberofTimesLetterOcurred++;
				}
			}
			
			this.updateNumberofLettersFoundinWord(numberofTimesLetterOcurred);
			
		}
		
	}

	public int wordLength()
	{
		return length;
	}
	
	public int[] arrayofLetterIndexcesinWord(char letter)
	{
		int[] letterIndexces = null;
		
		for(int index=0;index<wordInCharArray.length;index++)
		{
			
			if(letter == wordInCharArray[index])
			{
				if(letterIndexces == null)
				{
					letterIndexces =  new int[this.length];
				}
				letterIndexces[index] = 1;
				
			}
			
		}
		
		return letterIndexces;
	}
	
	public char[] getListofLettersFound()
	{
		return this.listofLettersFound;
	}
	
	public void addLetterTotheFoundLettersList(final char letterFound)
	{
		if(this.listofLettersFound == null)
		{
			this.listofLettersFound = new char[length];
		}
		
		for(int index=0;index<listofLettersFound.length;index++)
		{
			if(listofLettersFound[index]=='\u0000')
			{
				listofLettersFound[index] = letterFound;
				break;
			}
		}
	}
	
	public int getNumberofLettersFoundinWord()
	{
		return this.numberofLettersFoundinWord;
	}
	
	private void updateNumberofLettersFoundinWord (final int count)
	{
		this.numberofLettersFoundinWord += count;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj!=null && obj instanceof Word)
		{
			Word word = (Word) obj;
			
			if(word.wordString.equals(this.wordString)
					&& word == this)
			{
				return true;
			}
			
		}
		
		return false;
	}

}
