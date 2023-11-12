package racingcar

fun main() {
    val cars = initializeCars()

    val movedCars = moveCars(cars)
    val winners = RacingRule.findWinners(movedCars)
    OutputView.printWinners(winners)
}

private fun moveCars(cars: Cars): Cars {
    val numberOfMoves = InputView.inputNumberOfMoves()

    OutputView.printResultTitle()

    var movedCars = cars
    repeat(numberOfMoves) {
        movedCars = movedCars.move()
        OutputView.printResult(movedCars.cars)
    }
    return movedCars
}

private fun initializeCars(): Cars {
    val numberOfCars = InputView.inputNumberOfCars()
    val namesOfCars = InputView.inputNameOfCars()
    return Cars.initialize(numberOfCars, namesOfCars, RandomPowerGenerator)
}
