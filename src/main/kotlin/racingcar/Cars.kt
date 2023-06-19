package racingcar

class Cars(private val cars: List<Car>) {
    fun moveAll(): List<Int> {
        return cars.map { it.move() }
    }

    fun size(): Int {
        return cars.size
    }

    companion object {
        fun from(carNames: List<String>): Cars {
            return Cars(carNames.map { Car(it) })
        }
    }
}
