package racingcar.domain

class Cars(private val cars: List<Car>) {
    fun moveAll(): List<PositionHistory> {
        return cars.map { PositionHistory(it.name, it.move()) }
    }

    fun size(): Int {
        return cars.size
    }

    companion object {
        fun from(carNames: CarNames): Cars {
            return Cars(carNames.value.map { Car(it) })
        }
    }
}
