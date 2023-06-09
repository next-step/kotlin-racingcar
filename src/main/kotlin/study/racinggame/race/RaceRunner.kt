package study.racinggame.race

import study.racinggame.race.reader.ActualInputReader
import kotlin.random.Random

fun main() {
    val race = init()
    race.startRace()
}

fun init(): Race {
    val inputReader = ActualInputReader()
    val random = Random
    val inputView = InputView().initInputView(inputReader)
    return Race(inputView, random)
}
