package racingcar

class Racing {

    fun start() {
        val carCount = InputView.inputCarCount()
        val tryCount = InputView.inputTryCount()
        val cars = createCars(carCount)

        ResultView.outputResult()
        repeat(tryCount) {
            cars.map(Car::drive)
            cars.forEach { car -> ResultView.outputPosition(car.position) }
            println()
        }
    }

    private fun createCars(carCount: Int) =
        Array(carCount) { index -> Car(index) }
}
