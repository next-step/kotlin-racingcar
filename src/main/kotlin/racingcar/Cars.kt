package racingcar

class Cars(private val cars: List<Car>) {
    fun moveAll(): List<Pair<String, Int>> {
        return cars.map { it.name to it.move() }
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
