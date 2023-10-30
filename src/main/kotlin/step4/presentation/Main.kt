package step4.presentation

fun main() {
    InputView.showEnterCarIntro()
    val racingCar = InputView.enterCars()
    InputView.showTryCountIntro()
    val racingCourse = InputView.enterTryCount(racingCar)

    println("실행 결과")
    racingCourse.run(
        afterTrying = { println(ResultView.getCarMoveView(it)) },
        afterOneRepeat = { println() }
    )
    println(ResultView.getFinalResultView(racingCourse.getWinnerList()))
}
