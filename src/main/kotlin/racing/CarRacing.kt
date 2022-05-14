package racing

class CarRacing {
    fun startRacing() {
        val (carNames, moveCount) = CarRacingInputView.input()

        val cars: List<Car> = createCars(carNames)
        moveCars(cars = cars, moveCount = moveCount)

        CarRacingResultView.printCarRacingResult(cars = cars, moveCount = moveCount)

        val winners: Winners = pickWinners(cars)
        CarRacingResultView.printWinners(winners = winners)
    }

    fun moveCars(cars: List<Car>, moveCount: Int) {
        repeat(moveCount) {
            cars.forEach { car ->
                car.go { car.goIfAboveRequireGoValue() }
            }
        }
    }

    fun createCars(carNames: List<String>): List<Car> {
        return carNames.map { carName -> Car(carName) }
    }

    fun pickWinners(cars: List<Car>): Winners {
        val maxDistance: Int = cars.maxOf { car -> car.turnOfPosition.last() }
        val winnerNames: List<String> = cars.filter { car ->
            car.turnOfPosition.last() >= maxDistance
        }.map { car ->
            car.name
        }

        return Winners(winnerNames)
    }
}
