package study.racingcar

fun main() {
    val inputView = InputView(DefaultInputProvider())
    val numberOfCars = inputView.getNumberOfCars()
    val numberOfRounds = inputView.getNumberOfRounds()

    val race = Race(numberOfCars, numberOfRounds)
    val resultView = ResultView(DefaultOutputReceiver())

    resultView.startDisplayResult()
    race.run { cars ->
        resultView.displayRound(cars)
    }
}
