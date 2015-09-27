package com.kct.fifthsem.cseb.assignment.hangman;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hangman {
	
	private Player player = null;
	
	private Word currentWordPlayerPlaying =  null;
	
	private static final int BONUS_LIFE_FOR_GUESSING_WORD = 2;
	
	private Scanner input =  new Scanner(System.in);
	
	private char[] correctlyGuessedLetters = null;
	
	private Hangman(String playerName) {

		player =  new Player(playerName);
		
		System.out.println("Hi "+player.getPlayerName()+" Welcome to Hangman Game !! ");
		
		System.out.println("Your game Starts Now");
		
		startNewGame();
	}
	
	public static void startGame(final String playerName)
	{
		new Hangman(playerName);
	}
	
	private void startNewGame()
	{
		System.out.println("Please find below new word to guess ");
		
		currentWordPlayerPlaying = this.getWordToPlayforPlayer();
		
		System.out.println(currentWordPlayerPlaying.wordInGameFormat());
		
		System.out.println("Number of lifes left for "+player.getPlayerName()+" to find this word is "+player.getNumberofLifes());
		
		this.guessGameStarts();
				
	}
	
	private void guessGameStarts()
	{
		while(player.getNumberofLifes()>0 
				&& !(currentWordPlayerPlaying.getNumberofLettersFoundinWord() == currentWordPlayerPlaying.wordLength()))
		{
			char guessedLetter = this.validCharfromPlayer();
			
			if(this.isLetterinCorrectlyGuessedLetterList(guessedLetter))
			{
				System.out.println("Sorry "+player.getPlayerName()+ " You have already guessed this letter ("+guessedLetter+") correctly");
				continue;
			}
			
			int[] indexcesforguessedLetter = currentWordPlayerPlaying.arrayofLetterIndexcesinWord(guessedLetter);
			
			if(indexcesforguessedLetter==null)
			{
				System.out.println("Sorry letter ("+ guessedLetter +") is not in the word ");
				player.reduceLifeofUserByOne();
				System.out.println("Life Left "+player.getNumberofLifes());
				continue;
			}
			else
			{
				currentWordPlayerPlaying.updateDisplayWordFormat(indexcesforguessedLetter, guessedLetter);
				
				this.updateListofCorrectlyGuessedLetter(guessedLetter);
				
				System.out.println("Word :"+currentWordPlayerPlaying.wordInGameFormat());
			}
			
			
		}
		
		if(player.getNumberofLifes()<=0)
		{
			System.out.println("Sorry ! " +player.getPlayerName()+" have lost all your lifes , Better Luck next time");
			player = null;
			
		}
		
		else if(player.getNumberofLifes()>0 
				&& currentWordPlayerPlaying.getNumberofLettersFoundinWord() == currentWordPlayerPlaying.wordLength())
		{
			System.out.println("Congrats "+ player.getPlayerName() +" You found the Word ("+ this.currentWordPlayerPlaying.wordInGameFormat() +") Your Life would be increased by 2");
			
			player.addLifetoUser(BONUS_LIFE_FOR_GUESSING_WORD);
			
			System.out.println("Number of lives left "+player.getNumberofLifes());
			
			System.out.println("Cont for next word");
			
			player.updateWordIndentifiedByPlayerInList(currentWordPlayerPlaying);
			
			currentWordPlayerPlaying = null;
			
			this.clearCorrectlyGuessedLettersList();
			
			this.startNewGame();
			
		}
		
	}
	

	private char validCharfromPlayer() 
	{
		Pattern pattern = Pattern.compile("[a-z]");
		Matcher matcher = null;
		Character guessedLetter = null;
		do
		{
			System.out.println("Guess a letter (pls enter a valid character): ");
		    guessedLetter = input.next().charAt(0);
			matcher = pattern.matcher(guessedLetter.toString());
		
		}while(!(matcher.find()));
		
		return guessedLetter;
	}

	private Word getWordToPlayforPlayer()
	{
		int numberoftries = 0;
		
		Word wordToreturn = null;
		
		if(!(WordsContainer.isPlayerPlayedAlltheWords(player)))
		{
			Word word = WordsContainer.wordToPlay();
			
			while(this.player.isPlayerIdentifiedThisWord(word)
					&& numberoftries<6)
			{
				word = WordsContainer.wordToPlay();
				numberoftries++;
			}
			
			wordToreturn = word;
			
		}
		
		return wordToreturn;
		
	}
	
	private boolean isLetterinCorrectlyGuessedLetterList(final char letter)
	{
		
			for(int index=0;index<this.getCorrectlyGuessedLettersList().length;index++)
			{
				if(this.getCorrectlyGuessedLettersList()[index]==letter)
				{
					return true;
				}
			}
			
		return false;
	}
	
	private char[] getCorrectlyGuessedLettersList()
	{
		if(this.correctlyGuessedLetters == null)
		{
			correctlyGuessedLetters = new char[currentWordPlayerPlaying.wordLength()];
		}
		
		return this.correctlyGuessedLetters;
	}
	
	private void clearCorrectlyGuessedLettersList()
	{
		this.correctlyGuessedLetters = null;
	}
	
	private void updateListofCorrectlyGuessedLetter(final char letter)
	{
		for(int index=0;index<this.getCorrectlyGuessedLettersList().length;index++)
			{
				if(this.getCorrectlyGuessedLettersList()[index] == letter)
				{
					break;
				}
				if(this.getCorrectlyGuessedLettersList()[index]=='\u0000')
				{
					this.getCorrectlyGuessedLettersList()[index] = letter;
					break;
				}
			}
		}

}
