package com.seakernel.android.wordgenerator4games

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.arch.lifecycle.ViewModelProviders
import android.view.View
import kotlinx.android.synthetic.main.layout_controls.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_controls)

        val model = ViewModelProviders.of(this).get(WordsViewModel::class.java)
        model.getWords().observe(this as LifecycleOwner, Observer {
            guessing_word.text = model.nextWord()
        })

        val nextWordClickListener = View.OnClickListener { guessing_word.text = model.nextWord() }

        button_skip.setOnClickListener(nextWordClickListener)
        button_guessed.setOnClickListener(nextWordClickListener)
    }

    override fun onDestroy() {
        super.onDestroy()

        button_skip.setOnClickListener(null)
        button_guessed.setOnClickListener(null)
    }
}
