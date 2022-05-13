package racing

class CarRacing {
    fun startRacing() {
        val (carNames, moveCount) = CarRacingInputView.input()

        val cars: List<Car> = createCars(carNames)
        moveCars(cars = cars, moveCount = moveCount)

        CarRacingResultView.printCarRacingResult(cars = cars, moveCount = moveCount)
        val winners: List<String> = pickWinners(cars = cars, moveCount = moveCount)
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

    fun pickWinners(cars: List<Car>, moveCount: Int): List<String> {
        var maxDistance = 0
        val winners = arrayListOf<String>()
        cars.forEach { car ->
            maxDistance = updateWinnersAndMaxDistance(winners = winners, car = car, moveCount = moveCount, maxDistance = maxDistance)
        }

        return winners
    }

    fun updateWinnersAndMaxDistance(winners: ArrayList<String>, car: Car, moveCount: Int, maxDistance: Int): Int {
        var newMaxDistance = maxDistance
        if (maxDistance < car.turnOfPosition[moveCount]) {
            winners.clear()
            winners.add(car.name)
            newMaxDistance = car.turnOfPosition[moveCount]
        } else if (maxDistance == car.turnOfPosition[moveCount]) {
            winners.add(car.name)
        }

        return newMaxDistance
    }
}
