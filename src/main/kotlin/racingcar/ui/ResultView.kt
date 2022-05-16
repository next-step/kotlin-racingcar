package racingcar.ui

import racingcar.game.GameResult
import racingcar.game.RacingGame
import racingcar.painter.GameResultPainter

object ResultView {

    fun run(input: GameInput): List<GameResult> {
        println("실행결과")

        val result = RacingGame(input.toRacingCars(), input.round).getResults()

        println(GameResultPainter.from(result))

        return result
    }
}
