/*
 * Copyright (C) 2019 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.android.guesstheword.R

/**
 * ViewModel containing all the logic needed to run the game
 */
class GameViewModel : ViewModel() {

    // The current word
    private var word = 0
    var resource = R.drawable.cupcake

    // The current score
    var score = 0

    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<Int>


    /**
     * Resets the list of words and randomizes the order
     */
    // var cards= arrayOf(R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5,R.drawable.image6,R.drawable.image7);
//    button.setOnClickListener {
//        var  r = new Random()
//        var  n=r.nextInt(7)
//        imageview.setImageResource(cards[n]);
//
//    }
//    private fun resetList(){
//        wordList = arrayOf(R.drawable.image7, R.drawable.image3).toMutableList();
//    }
    private fun resetList() {
        wordList = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
        wordList.shuffle()
    }
    //        wordList = mutableListOf(
//                "queen",
//                "hospital",
//                "basketball",
//                "cat",
//                "change",
//                "snail",
//                "soup",
//                "calendar",
//                "sad",
//                "desk",
//                "guitar",
//                "home",
//                "railway",
//                "zebra",
//                "jelly",
//                "car",
//                "crow",
//                "trade",
//                "bag",
//                "roll",
//                "bubble"
//        )

    init {
        Log.i("GameViewModel", "GameViewModel created!")
        resetList()
        nextWord()
    }

    /**
     * Callback called when the ViewModel is destroyed
     */
    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }

    /** Methods for updating the UI **/
    fun onSkip() {
        score--
        nextWord()
    }
    fun onCorrect() {
        score++
        nextWord()
    }

    /**
     * Moves to the next word in the list.
     */
    private fun nextWord() {
        //Select and remove a word from the list
        if (wordList.isNotEmpty()) {
            word = wordList.removeAt(0)
            resource = when (word) {
                1 -> R.drawable.cupcake
                2 -> R.drawable.donut
                3 -> R.drawable.eclair
                4 -> R.drawable.froyo
                5 -> R.drawable.gingerbread
                6 -> R.drawable.honeycomb
                7 -> R.drawable.kitkat
                8 -> R.drawable.lollipop
                9 -> R.drawable.jellybean
                10 -> R.drawable.marshmallow
                11 -> R.drawable.nougat
                12 -> R.drawable.oreo
                else -> R.drawable.kitkat
            }
        }
    }
}
