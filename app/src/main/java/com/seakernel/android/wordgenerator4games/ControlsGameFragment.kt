package com.seakernel.android.wordgenerator4games

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.layout_game_controls.*

/**
 * Created by Calvin on 3/24/2018.
 */
class ControlsGameFragment: Fragment() {

    companion object {
        fun newInstance(): ControlsGameFragment {
            return ControlsGameFragment()
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_game_controls, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val model = ViewModelProviders.of(activity!!).get(WordsViewModel::class.java)

        time_left.text = getTimeLeftFormatted(model.getTime().value!!)
        current_word.text = model.getCurrentWord()

        val nextWordClickListener = View.OnClickListener { current_word.text = model.skipWord() }
        val guessedClickListener = View.OnClickListener { current_word.text = model.scoreWord() }

        button_skip.setOnClickListener(nextWordClickListener)
        button_guessed.setOnClickListener(guessedClickListener)

        time_left.postDelayed(object: Runnable {
            override fun run() {
                val secondsLeft = model.getTimeAndDecrementOneSecond().value!!
                time_left.text = getTimeLeftFormatted(secondsLeft)

                if (secondsLeft > 0) {
                    time_left.postDelayed(this, 1000)
                }
            }
        }, 1000)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        button_skip?.setOnClickListener(null)
        button_guessed?.setOnClickListener(null)
    }

    private fun getTimeLeftFormatted(secondsLeft: Long): String {
        return getString(R.string.time_format, secondsLeft / 60, secondsLeft % 60)
    }
}