package step3

class Round(val id: Int) {

    fun start(cars: List<Car>): RoundResult {
        val carPositions = cars.map { car ->
            val oil = OilStation.getOilRandomly()
            car.move(oil = oil)
            RoundResult.CarPosition.from(car = car)
        }
        return RoundResult(carPositions = carPositions)
    }
}
