package racingcar

class Cars(private val cars: List<Car>) {
    fun moveAll() {
        cars.forEach { it.move((0..9).random()) }
    }

    fun getPositions(): List<Int> {
        return cars.map { it.position }
    }
}
