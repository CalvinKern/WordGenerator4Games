package com.seakernel.android.wordgenerator4games

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model = ViewModelProviders.of(this).get(WordsViewModel::class.java)

        val fragment = getFragment(model)
        supportFragmentManager.beginTransaction()
                .add(R.id.controls_container, fragment, fragment.javaClass.simpleName)
                .commitAllowingStateLoss()

        score_value.text = model.getScore().value.toString()
        model.getScore().observe(this as LifecycleOwner, Observer { score_value.text = model.getScore().value.toString() })
        model.getGameState().observe(this, Observer {
            replaceGameLayout(getFragment(model))
        })
    }

    private fun getFragment(model: WordsViewModel): Fragment {
        return when (model.getGameState().value!!) {
            WordsViewModel.GameState.PLAYING -> ControlsGameFragment.newInstance()
            WordsViewModel.GameState.INTERMISSION -> IntermissionGameFragment.newInstance()
            WordsViewModel.GameState.EMPTY -> IntermissionGameFragment.newInstance()
        }
    }

    private fun replaceGameLayout(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.controls_container, fragment, fragment.javaClass.simpleName)
                .commitAllowingStateLoss()
    }
}
