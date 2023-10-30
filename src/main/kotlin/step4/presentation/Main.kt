package step4.presentation

import step4.domain.ConsoleInputSupplier
import step4.domain.RacingGame

fun main() {
    val inputView = InputView(ConsoleInputSupplier())
    val racingCars = inputView.enterCars()
    val tryCount = inputView.enterTryCount()

    val racingGame = RacingGame(tryCount, racingCars)

    println("실행 결과")
    racingGame.run(
        afterTrying = { println(ResultView.getCarMoveView(it)) },
        afterOneRepeat = { println() }
    )
    println(ResultView.getFinalResultView(racingGame.getWinnerList()))
}
