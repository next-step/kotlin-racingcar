package study.racinggame // ktlint-disable filename

import study.racinggame.controller.RaceController
import study.racinggame.race.reader.ActualInputReader

fun main() {
    val inputReader = ActualInputReader()
    val controller = RaceController(inputReader)
    controller.startRace()
}
