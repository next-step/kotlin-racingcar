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
        repeat(moveCount) { cars.forEach(Car::go) }
    }

    fun createCars(carNames: List<String>): List<Car> {
        return List(carNames.size) { index -> Car(carNames[index]) }
    }

    fun pickWinners(cars: List<Car>, moveCount: Int): List<String> {
        var maxPosition = 0
        val list = arrayListOf<String>()
        cars.forEach { car ->
            if (maxPosition < car.turnOfPosition[moveCount]) {
                list.clear()
                list.add(car.name)
                maxPosition = car.turnOfPosition[moveCount]
            } else if (maxPosition == car.turnOfPosition[moveCount]) {
                list.add(car.name)
            }
        }

        return list
    }
}
