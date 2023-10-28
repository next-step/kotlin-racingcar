package racingcar.domain

object CarGenerator {
    fun createInOrder(count: Int): List<Car> =
        buildList {
            repeat(count) { index ->
                add(Car(order = index))
            }
        }
}
