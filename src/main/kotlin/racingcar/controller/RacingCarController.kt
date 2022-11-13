package racingcar.controller

import racingcar.view.ConsoleInput
import racingcar.view.ConsoleOutput

class RacingCarController(private val input: ConsoleInput, private val output: ConsoleOutput) {
    fun race() {
        input.readCountOfCars()
        input.readRoundsToRace()
    }
}
