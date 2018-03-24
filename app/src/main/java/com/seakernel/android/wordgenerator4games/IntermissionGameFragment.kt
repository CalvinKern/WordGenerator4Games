package com.seakernel.android.wordgenerator4games

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.layout_game_intermission.*

/**
 * Created by Calvin on 3/24/2018.
 */
class IntermissionGameFragment: Fragment() {
    companion object {
        fun newInstance(): IntermissionGameFragment {
            return IntermissionGameFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_game_intermission, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val model = ViewModelProviders.of(this.activity!!).get(WordsViewModel::class.java)

        button_reset.setOnClickListener {
            model.reset()
        }

        button_start.setOnClickListener {
            model.startPlaying()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        button_reset?.setOnClickListener(null)
        button_start?.setOnClickListener(null)
    }
}