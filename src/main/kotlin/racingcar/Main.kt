package racingcar

fun main() {
    val race = Race()

    val result = race.result(InputView.getCarCount(), InputView.getRoundCount())

    val resultView = ResultView(result)
    resultView.title()
    resultView.printResult()
}
