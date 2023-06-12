package study.racinggame // ktlint-disable filename

import study.racinggame.presentation.RaceController
import study.racinggame.reader.ActualInputReader

fun main() {
    val inputReader = ActualInputReader()
    val controller = RaceController(inputReader)
    controller.startRace()
}
