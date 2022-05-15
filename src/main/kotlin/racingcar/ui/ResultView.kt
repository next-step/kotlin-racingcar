package racingcar.ui

import racingcar.game.RacingGame
import racingcar.painter.GameResultPainter

object ResultView {
    fun run(input: GameInput) {
        println("실행결과")

        val results = RacingGame(input.toRacingCars(), input.round).getResults()
        val resultString = GameResultPainter.from(results)

        println(resultString)
    }
}
