package study.step3.race

import study.step3.race.mock.ActualInputReader
import kotlin.random.Random

fun main() {
    val race = init()
    race.startRace()
}

fun init(): Race {
    val inputReader = ActualInputReader()
    val command = Command(inputReader)
    val random = Random
    command.setCommand()
    return Race(command, random)
}
