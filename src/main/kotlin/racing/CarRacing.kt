package racing

class CarRacing {
    fun startRacing() {
        val (carNames, moveCount) = CarRacingInputView.input()

        val cars: List<Car> = createCars(carNames)
        moveCars(cars = cars, moveCount = moveCount)

        CarRacingResultView.printCarRacingResult(cars = cars, moveCount = moveCount)
    }

    fun moveCars(cars: List<Car>, moveCount: Int) {
        repeat(moveCount) { cars.forEach(Car::go) }
    }

    fun createCars(carNames: List<String>): List<Car> {
        return List(carNames.size) { index -> Car(carNames[index]) }
    }
}
