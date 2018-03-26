package com.seakernel.android.wordgenerator4games

import android.arch.lifecycle.Observer
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

        setTeamReadyMessage(model)
        model.isTeamA().observe(this, Observer {
            setTeamReadyMessage(model)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()

        button_reset?.setOnClickListener(null)
        button_start?.setOnClickListener(null)
    }

    private fun setTeamReadyMessage(model: WordsViewModel) {
        val teamName = if (model.isTeamA().value!!) R.string.team_a else R.string.team_b
        ready_message.text = getString(R.string.team_ready_message, getString(teamName))
    }
}