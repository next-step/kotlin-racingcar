package racingcar

fun main() {
    val carSize = InputView.inputCarSize()
    val tryCount = InputView.inputTryCount()
    val cars = Cars(createRandomGenerator(), createCarsListener(), carSize)

    ResultView.printPositionsHeader()
    cars.move(tryCount)
}

private fun createRandomGenerator(): RandomGenerator {
    return RandomGenerator { (0..9).random() }
}

private fun createCarsListener(): CarsListener {
    return CarsListener { ResultView.printPositions(it.positions()) }
}
