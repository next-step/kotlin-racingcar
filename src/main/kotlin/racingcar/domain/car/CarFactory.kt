package racingcar.domain.car

object CarFactory {
    fun createCars(total: Int): List<Car> {
        return List(total) { Car() }
    }
}
