package racing

import racing.application.RacingCarFactory
import racing.participant.RacingGroup
import racing.result.GameResult
import racing.result.toGameResult

class RacingGame(private val cars: RacingGroup) {

    fun start(roundCount: Int): GameResult {
        return (1..roundCount)
            .map { round -> cars.race(round) }
            .toGameResult()
    }
}

fun main() {
    val form = InputView.writeApplicationForm()
    val group = RacingCarFactory.generate(form)

    val game = RacingGame(group)
    val result = game.start(InputView.inputRunCount())

    OutputView.printResult(result)
}