package step3.ui

import step3.domain.Game

object GameCommandInterface {
    fun play() {
        val input = InputInterface.input()

        val results =
            Game(numberOfCars = input.numberOfCars, numberOfTrials = input.numberOfTrials).process()

        ResultInterface.output(results)
    }
}
