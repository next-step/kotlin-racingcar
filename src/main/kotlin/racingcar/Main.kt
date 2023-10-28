package racingcar

fun main() {
    val carSize = InputView.inputCarSize()
    val tryCount = InputView.inputTryCount()
    val cars = Cars(createRandomGenerator(), carSize)

    ResultView.printPositionsHeader()
    repeat(tryCount) {
        cars.move()
        ResultView.printPositions(cars.list())
    }
}

private fun createRandomGenerator(): RandomGenerator {
    return RandomGenerator { (0..9).random() }
}
