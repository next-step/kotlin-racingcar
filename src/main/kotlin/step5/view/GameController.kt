package step5.ui

import step5.domain.Game

object GameController {
    fun play() {
        val input = InputController.input()

        val game = Game(nameOfCars = input.nameOfCars, numberOfTrials = input.numberOfTrials)
            .also { it.process() }

        OutputController.output(
            gameLogs = game.getGameLogs(),
            winners = game.getWinners(),
        )
    }
}
