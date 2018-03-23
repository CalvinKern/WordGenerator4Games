package com.seakernel.android.wordgenerator4games

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.arch.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_controls)

        val model = ViewModelProviders.of(this).get(WordsViewModel::class.java)
        model.getWords().observe(this, Observer { words ->
            // TODO: update UI
        })
    }
}
