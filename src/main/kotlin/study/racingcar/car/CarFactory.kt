package study.racingcar.car

object CarFactory {
    fun createCars(count: Int): List<Car> {
        return List(count) {
            Car()
        }
    }
}
