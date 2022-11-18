package racingcar

fun main() {
    val inputView = InputView()
    inputView.show()

    val f1 = FormularOne()
    f1.start(numberOfCar = inputView.numberOfCar, numberOfGame = inputView.numberOfGame)

    ResultView().show(f1.result())
}
