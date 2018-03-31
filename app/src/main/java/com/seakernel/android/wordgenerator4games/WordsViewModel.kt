package com.seakernel.android.wordgenerator4games

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import java.util.*
import kotlin.collections.ArrayList

class WordsViewModel : ViewModel() {
    private val LIST_OF_WORDS: String =
            "book\n" +
                    "avalanche\n" +
                    "Mount Everest\n" +
                    "puzzle\n" +
                    "swimming pool\n" +
                    "Valentine's Day\n" +
                    "wood chips\n" +
                    "children\n" +
                    "video\n" +
                    "video game\n" +
                    "phone\n" +
                    "phone charger\n" +
                    "shelf\n" +
                    "restaurant\n" +
                    "carpet\n" +
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
                    "school\n" +
                    "spouse\n" +
                    "student\n" +
                    "time\n" +
                    "water\n" +
                    "woman\n" +
                    "work\n" +
                    "world\n" +
                    "week\n" +
                    "year\n" +
                    "scientist\n" +
                    "black hole\n" +
                    "college\n" +
                    "flirting\n" +
                    "dictionary\n" +
                    "blanket\n" +
                    "internet\n" +
                    "forest\n" +
                    "medicine\n" +
                    "coral\n" +
                    "tsunami\n" +
                    "garden\n" +
                    "time travel\n" +
                    "kitchen\n" +
                    "chemistry\n" +
                    "locksmith\n" +
                    "cooking (food)\n" +
                    "Hogwarts\n" +
                    "farmer\n" +
                    "corn maze\n" +
                    "the Flu\n" +
                    "rhinoceros\n" +
                    "electricity\n" +
                    "stapler\n" +
                    "marathon\n" +
                    "Star Wars\n" +
                    "ceiling\n" +
                    "bamboo\n" +
                    "airport\n" +
                    "chimney\n" +
                    "zombie\n" +
                    "death\n" +
                    "magic\n" +
                    "obese\n" +
                    "back seat\n" +
                    "high chair\n" +
                    "rock band\n" +
                    "storm\n" +
                    "wizard\n" +
                    "birthday\n" +
                    "hockey\n" +
                    "climate change\n" +
                    "sasquatch\n" +
                    "hotel\n" +
                    "scrambled eggs\n" +
                    "blizzard\n" +
                    "jump rope\n" +
                    "seat belt\n" +
                    "burrito\n" +
                    "pirate\n" +
                    "koala\n" +
                    "skip\n" +
                    "captain\n" +
                    "leprechaun\n" +
                    "solar eclipse\n" +
                    "chandelier\n" +
                    "light\n" +
                    "space\n" +
                    "crib\n" +
                    "mask\n" +
                    "stethoscope\n" +
                    "cruise ship\n" +
                    "mechanic\n" +
                    "fireworks\n" +
                    "animal\n" +
                    "stork\n" +
                    "dance\n" +
                    "mom\n" +
                    "Antarctica\n" +
                    "sunburn\n" +
                    "deodorant\n" +
                    "Mr Potato Head\n" +
                    "Christmas\n" +
                    "thread\n" +
                    "Facebook\n" +
                    "family\n" +
                    "allergies\n" +
                    "haircut\n" +
                    "wedding\n" +
                    "mowing the lawn\n" +
                    "trampoline\n" +
                    "pantyhose\n" +
                    "tourist\n" +
                    "flat\n" +
                    "paper\n" +
                    "paper plate\n" +
                    "United States\n" +
                    "frame\n" +
                    "golf\n" +
                    "plant\n" +
                    "photo\n" +
                    "WIFI\n" +
                    "sneezing\n" +
                    "electric car\n" +
                    "full moon\n" +
                    "pilgrim\n" +
                    "alcohol\n" +
                    "zombie\n" +
                    "game\n" +
                    "pirate\n" +
                    "coffee\n" +
                    "brain\n" +
                    "kitten\n" +
                    "playground\n" +
                    "gym\n" +
                    "bubble bath\n" +
                    "kiwi\n" +
                    "pumpkin pie\n" +
                    "buckle\n" +
                    "lipstick\n" +
                    "raindrop\n" +
                    "bus\n" +
                    "lobster\n" +
                    "robot\n" +
                    "car accident\n" +
                    "lollipop\n" +
                    "sand castle\n" +
                    "castle\n" +
                    "magnet\n" +
                    "slipper\n" +
                    "chain saw\n" +
                    "megaphone\n" +
                    "snowball\n" +
                    "circus tent\n" +
                    "screw driver\n" +
                    "mermaid\n" +
                    "sprinkler\n" +
                    "computer\n" +
                    "minivan\n" +
                    "bank account\n" +
                    "road trip\n" +
                    "Statue of Liberty\n" +
                    "crib\n" +
                    "homework\n" +
                    "dragon\n" +
                    "Mount Rushmore\n" +
                    "tadpole\n" +
                    "music\n" +
                    "teepee\n" +
                    "dumbbell\n" +
                    "panda\n" +
                    "North Pole\n" +
                    "telescope\n" +
                    "eel\n" +
                    "nurse\n" +
                    "train\n" +
                    "ferris wheel\n" +
                    "owl\n" +
                    "tricycle\n" +
                    "paparazzi\n" +
                    "boots\n" +
                    "flag\n" +
                    "pacifier\n" +
                    "tutu\n" +
                    "junk mail\n" +
                    "piano\n" +
                    "heat\n" +
                    "cat\n" +
                    "sun\n" +
                    "cup\n" +
                    "ghost\n" +
                    "flower\n" +
                    "pie\n" +
                    "cow\n" +
                    "banana\n" +
                    "snowflake\n" +
                    "bug\n" +
                    "book\n" +
                    "jar\n" +
                    "snake\n" +
                    "light\n" +
                    "tree\n" +
                    "lips\n" +
                    "apple\n" +
                    "slide\n" +
                    "socks\n" +
                    "smile\n" +
                    "swing\n" +
                    "window\n" +
                    "coat\n" +
                    "shoe\n" +
                    "water\n" +
                    "heart\n" +
                    "hat\n" +
                    "ocean\n" +
                    "kite\n" +
                    "dog\n" +
                    "mouth\n" +
                    "milk\n" +
                    "duck\n" +
                    "eyes\n" +
                    "board game\n" +
                    "skateboard\n" +
                    "bird\n" +
                    "boy\n" +
                    "apple\n" +
                    "person\n" +
                    "girl\n" +
                    "mouse\n" +
                    "ball\n" +
                    "house\n" +
                    "star\n" +
                    "nose\n" +
                    "bed\n" +
                    "whale\n" +
                    "jacket\n" +
                    "shirt\n" +
                    "hippo\n" +
                    "beach\n" +
                    "egg\n" +
                    "face\n" +
                    "cookie\n" +
                    "cheese\n" +
                    "ice cream cone\n" +
                    "drum circle\n" +
                    "spoon\n" +
                    "city\n" +
                    "worm\n" +
                    "spider web"

    enum class GameState {
        EMPTY, PLAYING, INTERMISSION, PAUSED
    }

    val INITIAL_TIME = 90L

    private var words: MutableLiveData<List<String>> = MutableLiveData()
    private var scoreTeamA: MutableLiveData<Int> = MutableLiveData<Int>().also { it.value = 0 }
    private var scoreTeamB: MutableLiveData<Int> = MutableLiveData<Int>().also { it.value = 0 }
    private var time: MutableLiveData<Long> = MutableLiveData<Long>().also { it.value = INITIAL_TIME }
    private var gameState: MutableLiveData<GameState> = MutableLiveData<GameState>().also { it.value = GameState.EMPTY }
    private var isTeamA: MutableLiveData<Boolean> = MutableLiveData<Boolean>().also { it.value = Math.random() < 0.5f }

    fun getGameState(): LiveData<GameState> {
        return gameState
    }

    fun isTeamA(): LiveData<Boolean> {
        return isTeamA
    }

    fun getScoreTeamA(): LiveData<Int> {
        return scoreTeamA
    }

    fun getScoreTeamB(): LiveData<Int> {
        return scoreTeamB
    }

    fun getTime(): LiveData<Long> {
        return time
    }

    fun getTimeAndDecrementOneSecond(): LiveData<Long> {
        time.value = time.value!! - if (gameState.value == GameState.PLAYING) 1L else 0

        if (time.value!! <= 0) {
            gameState.value = GameState.INTERMISSION
            isTeamA.value = !isTeamA.value!!
            nextWord()
        }

        return time
    }

    fun scoreWord(): String {
        val team = if (isTeamA.value!!) scoreTeamA else scoreTeamB

        team.value = team.value!! + 1
        return nextWord()
    }

    fun skipWord(): String {
        val team = if (isTeamA.value!!) scoreTeamA else scoreTeamB

        team.value = team.value!! - 1
        return nextWord()
    }

    fun getCurrentWord(): String {
        if (words.value == null || words.value!!.isEmpty()) {
            loadWords()
        }
        return words.value!![0]
    }

    private fun nextWord(): String {
        if (words.value != null && !words.value!!.isEmpty()) {
            (words.value as ArrayList<String>).removeAt(0)
        }
        return getCurrentWord()
    }

    // Load a shuffled version of the list of words
    private fun loadWords() {
        if (words.value == null) {
            words.value = ArrayList()
        }
        words.value = words.value!!.plus(LIST_OF_WORDS.split("\n").apply { Collections.shuffle(this) })
    }

    fun reset() {
        scoreTeamA.value = 0
        scoreTeamB.value = 0
        gameState.value = GameState.EMPTY
        isTeamA.value = Math.random() < 0.5f
    }

    fun startPlaying() {
        if (gameState.value!! != WordsViewModel.GameState.PLAYING) {
            if (gameState.value!! != GameState.PAUSED) {
                time.value = INITIAL_TIME
            }
            gameState.value = WordsViewModel.GameState.PLAYING
        }
    }

    // Can only pause from a running game
    fun pauseGame() {
        if (gameState.value!! == WordsViewModel.GameState.PLAYING) {
            gameState.value = WordsViewModel.GameState.PAUSED
        }
    }
}