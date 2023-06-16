package racingcar

class Cars(private val cars: List<Car>) {
    fun moveAll(): List<Int> {
        return cars.map { it.move((0..9).random()) }
    }
}
