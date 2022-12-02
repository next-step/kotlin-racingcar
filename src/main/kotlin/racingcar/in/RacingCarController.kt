package racingcar.`in`

import racingcar.domain.MoveStrategy
import racingcar.domain.RacingGame
import racingcar.`in`.dto.GameResults
import racingcar.view.ConsoleInput
import racingcar.view.ConsoleOutput

class RacingCarController(private val input: ConsoleInput, private val output: ConsoleOutput, private val moveStrategy: MoveStrategy) {
    fun race() {
        val names = input.readNames()
        val round = input.readRoundsToRace()
        val racingGame = RacingGame(names, round)

        output.printGameStartSignal()

        start(names, racingGame)

        output.printWinners(racingGame.findWinners().map { it.name().name })
    }

    private tailrec fun start(names: List<String>, racingGame: RacingGame) {
        if (!racingGame.hasNextRound()) {
            return
        }

        val carPositions = racingGame.playNextRound(moveStrategy)

        val gameResults = GameResults(names, carPositions.map { it.position })
        output.printGameResult(gameResults)
        start(names, racingGame)
    }
}
