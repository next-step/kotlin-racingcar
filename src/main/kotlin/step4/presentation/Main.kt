package step4.presentation

import step4.domain.RacingGame

fun main() {
    val racingCar = InputView.enterCars()
    val tryCount = InputView.enterTryCount()

    val racingGame = RacingGame(tryCount, racingCar)

    println("실행 결과")
    racingGame.run(
        afterTrying = { println(ResultView.getCarMoveView(it)) },
        afterOneRepeat = { println() }
    )
    println(ResultView.getFinalResultView(racingGame.getWinnerList()))
}
