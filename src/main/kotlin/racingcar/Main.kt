package racingcar

fun main() {
    val inputView = InputView()
    inputView.excute()

    val race = Race()

    race.start(inputView.carCount, inputView.roundCount)

    val resultView = ResultView(race.roundList)
    resultView.title()
    resultView.printResult()
}
