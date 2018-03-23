package com.seakernel.android.wordgenerator4games

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import java.util.*

class WordsViewModel : ViewModel() {
    private val LIST_OF_WORDS: String =
            "book\n" +
            "box\n" +
            "case\n" +
            "child\n" +
            "company\n" +
            "day\n" +
            "eye\n" +
            "fact\n" +
            "friend\n" +
            "government\n" +
            "group\n" +
            "hand\n" +
            "home\n" +
            "life\n" +
            "man\n" +
            "number\n" +
            "palace\n" +
            "part\n" +
            "party\n" +
            "person\n" +
            "point\n" +
            "problem\n" +
            "school\n" +
            "spouse\n" +
            "student\n" +
            "time\n" +
            "water\n" +
            "woman\n" +
            "work\n" +
            "world\n" +
            "week\n" +
            "year\n"

    private var words: MutableLiveData<List<String>> = MutableLiveData()

    fun getWords(): LiveData<List<String>> {
        if (words.value == null) {
            words.value = ArrayList()
            loadWords()
        }
        return words
    }

    private fun loadWords() {
        words.value?.plus(Collections.shuffle(LIST_OF_WORDS.split("\n")))
    }
}