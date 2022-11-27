package racingcar.`in`

import racingcar.domain.MoveStrategy
import racingcar.domain.RacingGame
import racingcar.`in`.dto.GameResults
import racingcar.view.ConsoleInput
import racingcar.view.ConsoleOutput

class RacingCarController(private val input: ConsoleInput, private val output: ConsoleOutput, private val moveStrategy: MoveStrategy) {
    fun race() {
        val countOfCars = input.readCountOfCars()
        val round = input.readRoundsToRace()
        val racingGame = RacingGame(countOfCars, round)

        output.printResults()

        start(racingGame)
    }

    private tailrec fun start(racingGame: RacingGame) {
        if (!racingGame.hasNextRound()) {
            return
        }

        val carPositions = racingGame.playNextRound(moveStrategy)

        val gameResults = GameResults(carPositions)
        output.printGameResult(gameResults)
        start(racingGame)
    }
}
