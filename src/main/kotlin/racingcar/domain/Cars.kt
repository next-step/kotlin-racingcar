package racingcar.domain

class Cars(
    private val cars: List<Car>
) {
    fun move(movingStrategy: MovingStrategy) {
        cars.forEach { it.move(movingStrategy) }
    }

    fun carRecord(): List<CarRecord> {
        return cars.map(CarRecord.Companion::of)
    }

    fun size(): Int {
        return cars.size
    }

    companion object {
        fun of(carNames: List<CarName>): Cars {
            return Cars(carNames.map(::Car))
        }
    }
}
