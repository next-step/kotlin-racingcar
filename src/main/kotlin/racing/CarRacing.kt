package racing

class CarRacing {
    fun startRacing() {
        val (carCount, moveCount) = CarRacingInputView.input()

        val cars: List<Car> = createCars(carCount)
        moveCars(cars = cars, moveCount = moveCount)

        CarRacingResultView.printCarRacingResult(cars = cars, moveCount = moveCount)
    }

    fun moveCars(cars: List<Car>, moveCount: Int) {
        repeat(moveCount) { cars.forEach(Car::go) }
    }

    fun createCars(carCount: Int): List<Car> = List(carCount) { Car() }
}
