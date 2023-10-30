package step4.presentation

fun main() {
    val racingCourse = InputView.enterTryCount(InputView.enterCars())

    ResultView.showResultTitle()
    racingCourse.run(
        afterTrying = { ResultView.showCarMove(it) },
        afterOneRepeat = { ResultView.lineBreak() }
    )
    ResultView.showFinalResult(racingCourse.getWinnerList())
}
