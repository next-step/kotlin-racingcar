package racingcar

fun main() {
    val inputView = InputView()
    inputView.show()

    val result = FormularOne().start(numberOfCar = inputView.numberOfCar, numberOfGame = inputView.numberOfGame)

    ResultView().show(result)
}
