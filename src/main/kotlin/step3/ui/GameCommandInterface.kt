package step3.ui

import step3.domain.Game

object GameCommandInterface {
    fun play() {
        val input = InputInterface.input()

        val result =
            Game(numberOfCars = input.numberOfCars, numberOfTrials = input.numberOfTrials).process()

        ResultInterface.output(result)
    }
}
