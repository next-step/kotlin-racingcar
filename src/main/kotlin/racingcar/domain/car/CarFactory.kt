package racingcar.domain.car

object CarFactory {
    fun createCars(total: Int): List<Car> {
        return buildList {
            repeat(total) { add(Car()) }
        }
    }
}
