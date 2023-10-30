package step4.presentation

fun main() {
    InputView.showEnterCarIntro()
    val racingCar = InputView.enterCars()
    InputView.showTryCountIntro()
    val racingCourse = InputView.enterTryCount(racingCar)

    ResultView.showResultTitle()
    racingCourse.run(
        afterTrying = { ResultView.showCarMove(it) },
        afterOneRepeat = { ResultView.lineBreak() }
    )
    ResultView.showFinalResult(racingCourse.getWinnerList())
}
