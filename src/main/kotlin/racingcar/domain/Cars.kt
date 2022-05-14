package racingcar.domain

class Cars(
    private val cars: List<Car>
) {
    fun move(movingStrategy: MovingStrategy) {
        cars.forEach { it.move(movingStrategy) }
    }

    fun nameWithLocation(): List<CarRecord> {
        return cars.map {
            CarRecord(it.carName to it.location)
        }
    }

    fun size(): Int {
        return cars.size
    }

    companion object {
        fun of(carCount: Int): Cars {
            return Cars((0 until carCount).map { Car() })
        }

        fun of(carNames: List<CarName>): Cars {
            return Cars(carNames.map(::Car))
        }
    }
}
