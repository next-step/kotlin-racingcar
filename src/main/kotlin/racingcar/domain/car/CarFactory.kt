package racingcar.domain.car

object CarFactory {
    fun createCars(total: Int): List<Car> {
        require(total >= 0) { "Argument should be non negative number." }
        return List(total) { Car() }
    }
}
