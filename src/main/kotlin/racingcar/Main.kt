package racingcar

fun main() {
    val numberOfCars = InputView.inputNumberOfCars()
    val namesOfCars = InputView.inputNameOfCars()
    val cars = Cars.initialize(numberOfCars, namesOfCars, RandomPowerGenerator)

    val numberOfMoves = InputView.inputNumberOfMoves()

    OutputView.printResultTitle()

    var movedCars = cars
    repeat(numberOfMoves) {
        movedCars = movedCars.move()
        OutputView.printResult(movedCars.cars)
    }
}
