package step4.presentation

import step4.data.RacingCourse

fun main() {
    val racingCar = InputView.enterCars()
    val tryCount = InputView.enterTryCount()

    val racingCourse = RacingCourse(tryCount, racingCar)

    println("실행 결과")
    racingCourse.run(
        afterTrying = { println(ResultView.getCarMoveView(it)) },
        afterOneRepeat = { println() }
    )
    println(ResultView.getFinalResultView(racingCourse.getWinnerList()))
}
