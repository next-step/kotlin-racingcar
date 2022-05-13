package racing

class CarRacing {
    fun startRacing() {
        val (carNames, moveCount) = CarRacingInputView.input()

        val cars: List<Car> = createCars(carNames)
        moveCars(cars = cars, moveCount = moveCount)

        CarRacingResultView.printCarRacingResult(cars = cars, moveCount = moveCount)

        val winners: List<String> = pickWinners(cars)
        CarRacingResultView.printWinners(carNames = winners)
    }

    fun moveCars(cars: List<Car>, moveCount: Int) {
        repeat(moveCount) {
            cars.forEach { car ->
                car.go { car.goIfAboveRequireGoValue() }
            }
        }
    }

    fun createCars(carNames: List<String>): List<Car> {
        return List(carNames.size) { index -> Car(carNames[index]) }
    }

    fun pickWinners(cars: List<Car>): List<String> {
        val maxDistance: Int = cars.maxOf { car -> car.turnOfPosition.last() }

        val winners: List<String> = cars.filter { car ->
            car.turnOfPosition.last() >= maxDistance
        }.map { car ->
            car.name
        }

        return winners
    }
}
