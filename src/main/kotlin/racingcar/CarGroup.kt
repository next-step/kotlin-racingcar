package racingcar

class CarGroup(private val cars: List<Car>) {
    fun move() {
        this.cars.forEach { car ->
            val oil = OilStation.generateOilRandomly()
            car.move(movePolicy = OilPolicy(oil = oil))
        }
    }

    fun getPositions(): List<CarPosition> {
        return this.cars.map { CarPosition.from(car = it) }
    }

    fun getWinners(): List<Winner> {
        val winnerCars = WinnerCalculator.execute(cars = this.cars)
        return winnerCars.map { Winner(name = it.name) }
    }
}
