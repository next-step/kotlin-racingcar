package racingcar

fun main() {
    val numberOfCars = InputView.inputNumberOfCars()
    val numberOfMoves = InputView.inputNumberOfMoves()

    val cars = Cars.initializeWithNumberOfCars(numberOfCars, RandomPowerGenerator)

    OutputView.printResultTitle()

    var movedCars = cars
    repeat(numberOfMoves) {
        movedCars = movedCars.move()
        OutputView.printResult(movedCars.cars)
    }
}
