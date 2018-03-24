package com.seakernel.android.wordgenerator4games

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.arch.lifecycle.ViewModelProviders
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_controls.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model = ViewModelProviders.of(this).get(WordsViewModel::class.java)

        model.getScore().observe(this as LifecycleOwner, Observer { score_value.text = model.getScore().value.toString() })

        guessing_word.text = model.nextWord()
        score_value.text = model.getScore().value.toString()

        val nextWordClickListener = View.OnClickListener { guessing_word.text = model.skipWord() }
        val guessedClickListener = View.OnClickListener { guessing_word.text = model.scoreWord() }

        button_skip.setOnClickListener(nextWordClickListener)
        button_guessed.setOnClickListener(guessedClickListener)

        val timer = Timer()
        timer.scheduleAtFixedRate(object: TimerTask() {
            override fun run() {
                time_left.post( {
                    val secondsLeft = model.getTimeAndDecrementOneSecond().value!!
                    time_left.text = getString(R.string.time_format, secondsLeft / 60, secondsLeft % 60)
                })
            }
        }, 1000, 1000)
    }

    override fun onDestroy() {
        super.onDestroy()

        button_skip.setOnClickListener(null)
        button_guessed.setOnClickListener(null)
    }
}
