package racingcar

fun main() {
    val inputValues = InputView().receiveValues()

    val racing = Racing(
        trials = inputValues.trials,
        cars = generateCars(inputValues.numberOfCars)
    )

    val results = racing.start()

    ResultView().print(results)
}

private fun generateCars(numberOfCars: Int): List<Car> {
    return (1..numberOfCars).map { Car(RacingEngine()) }
}
