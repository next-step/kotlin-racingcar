package study.racinggame.race

import study.racinggame.race.reader.ActualInputReader
import kotlin.random.Random

fun main() {
    val race = init()
    race.startRace()
}

fun init(): Race {
    val inputReader = ActualInputReader()
    val inputView = InputView(inputReader)
    val random = Random
    inputView.setCommand()
    return Race(inputView, random)
}
