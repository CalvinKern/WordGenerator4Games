package com.seakernel.android.wordgenerator4games

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.arch.lifecycle.ViewModelProviders
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_controls.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model = ViewModelProviders.of(this).get(WordsViewModel::class.java)

        model.getScore().observe(this as LifecycleOwner, Observer { score_value.text = model.getScore().value.toString() })

        guessing_word.text = model.nextWord()
        score_value.text = model.getScore().value.toString()

        val nextWordClickListener = View.OnClickListener { guessing_word.text = model.nextWord() }
        val guessedClickListener = View.OnClickListener { guessing_word.text = model.scoreWord() }

        button_skip.setOnClickListener(nextWordClickListener)
        button_guessed.setOnClickListener(guessedClickListener)
    }

    override fun onDestroy() {
        super.onDestroy()

        button_skip.setOnClickListener(null)
        button_guessed.setOnClickListener(null)
    }
}
