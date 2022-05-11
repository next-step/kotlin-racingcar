package racing

class CarRacing {
    fun startRacing() {
        val (carCount, moveCount) = CarRacingInputView().input()

        val cars: List<Car> = createCars(carCount)
        moveCars(cars = cars, moveCount = moveCount)

        CarRacingResultView().printCarRacingResult(cars = cars, moveCount = moveCount)
    }

    fun moveCars(cars: List<Car>, moveCount: Int) {
        for (moveIndex in 0 until moveCount) {
            cars.forEach { car ->
                car.go()
            }
        }
    }

    fun createCars(carCount: Int): List<Car> {
        val cars = arrayListOf<Car>()
        for (index in 0 until carCount) {
            cars.add(Car())
        }

        return cars
    }
}
