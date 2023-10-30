package racingcar.domain.car

object CarGenerator {
    fun createInOrder(count: Int): List<Car> = List(count) {
        Car(order = it)
    }
}
