package racingcar

class Round(val id: Int) {
    fun start(cars: List<Car>): RoundResult {
        val carPositions = this.moveCars(cars = cars)
        return RoundResult(carPositions = carPositions)
    }

    private fun moveCars(cars: List<Car>): List<CarPosition> {
        return cars.map { car ->
            val oil = OilStation.generateOilRandomly()
            car.move(movePolicy = OilPolicy(oil = oil))
            CarPosition.from(car = car)
        }
    }
}
