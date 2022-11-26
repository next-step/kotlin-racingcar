package racingcar.controller

import racingcar.controller.dto.GameResults
import racingcar.domain.MoveStrategy
import racingcar.domain.RacingGame
import racingcar.view.ConsoleInput
import racingcar.view.ConsoleOutput

class RacingCarController(private val input: ConsoleInput, private val output: ConsoleOutput, private val moveStrategy: MoveStrategy) {
    fun race() {
        val countOfCars = input.readCountOfCars()
        val round = input.readRoundsToRace()
        val racingGame = RacingGame(countOfCars, round)

        output.printResults()

        while (racingGame.hasNextRound()) {
            racingGame.playNextRound(moveStrategy)
            val gameResults = GameResults.of(racingGame.cars)
            output.printGameResult(gameResults)
        }
    }
}
