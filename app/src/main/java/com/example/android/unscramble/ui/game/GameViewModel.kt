package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {

    init {
        Log.d("Game Fragment", "GameViewModel created")
    }

    private var score = 0
    private var currentWordCount = 0
    private var _currentScrambledWord = "test"

    // backing property
    val currentScrambledWord: String
    get() = _currentScrambledWord

    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment", "GameViewModel destroyed")
    }
}