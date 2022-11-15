package step3

class Round(val id: Int) {
    fun start(cars: List<Car>): RoundResult {
        val carPositions = this.moveCars(cars = cars)
        return RoundResult(carPositions = carPositions)
    }

    private fun moveCars(cars: List<Car>): List<RoundResult.CarPosition> {
        return cars.map { car ->
            val oil = OilStation.generateOilRandomly()
            car.move(movePolicy = OilPolicy(oil = oil))
            RoundResult.CarPosition.from(car = car)
        }
    }
}
