package game.racingcar

import game.racingcar.domain.Car
import game.racingcar.domain.RacingTrack
import game.racingcar.strategy.MoveStrategy
import game.racingcar.strategy.RandomMoveStrategy
import game.racingcar.view.InputView
import game.racingcar.view.OutputView
import game.racingcar.view.StandardInputView
import game.racingcar.view.StandardOutputView

class RacingGame(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val moveStrategy: MoveStrategy,
) {
    fun run() {
        inputView.init()
        val racingTrack = RacingTrack(inputView.carNames().map { Car(it) })

        val cars = racingTrack.race(inputView.numberOfLap(), moveStrategy)

        val result = outputView.getResult(cars, racingTrack.getWinners())
        println("\n실행 결과")
        println(result)
    }
}

fun main() {
    val racingGame = RacingGame(StandardInputView(), StandardOutputView(), RandomMoveStrategy())
    racingGame.run()
}
