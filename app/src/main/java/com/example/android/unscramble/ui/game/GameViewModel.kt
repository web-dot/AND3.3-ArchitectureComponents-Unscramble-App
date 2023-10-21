package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {



    private var _score = 0
    val score: Int get() = _score

    private var currentWordCount = 0
    private lateinit var _currentScrambledWord: String

    private var wordsList: MutableList<String> = mutableListOf()
    private lateinit var currentWord: String

    private fun getNextWord(){
        currentWord = allWordsList.random()
        val tempWord = currentWord.toCharArray()

        while (String(tempWord).equals(currentWord, false)){
            tempWord.shuffle()
        }

        if(wordsList.contains(currentWord)){
            getNextWord()
        }
        else{
            _currentScrambledWord = String(tempWord)
            ++currentWordCount
            wordsList.add(currentWord)
        }
    }
    init {
        Log.d("GameFragment", "GameViewModel created")
        getNextWord()
    }

    // backing property
    val currentScrambledWord: String
    get() = _currentScrambledWord

    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment", "GameViewModel destroyed")
    }

    fun nextWord(): Boolean{
        return if (currentWordCount < MAX_NO_OF_WORDS){
            getNextWord()
            true
        } else false
    }

}