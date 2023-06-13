package racingcar

object CarFactory {
    fun manufacture(carNum: Int): List<Car> {
        return List(carNum) { Car() }
    }
}
