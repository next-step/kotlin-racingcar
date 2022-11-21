package racingcar.domain

class CarGroup(private var cars: List<Car>) {
    fun move() {
        this.cars = this.cars.map { car ->
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
