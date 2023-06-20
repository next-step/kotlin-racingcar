package racingcar

class Cars(private val cars: List<Car>) {
    companion object {
        fun createCountOf(count: Int): Cars {
            val cars = List(count) { Car() }
            return Cars(cars)
        }
    }
}
