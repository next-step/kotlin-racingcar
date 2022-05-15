package racingcar.ui

import racingcar.game.RacingGame
import racingcar.painter.GameResultPainter

object ResultView {
    fun run(input: GameInput) {
        println("실행결과")

        val result = RacingGame(input.toRacingCars(), input.round)
            .getResults()
            .let(GameResultPainter::from)

        println(result)
    }
}
