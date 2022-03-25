package racingcar.domain.car

class Cars(private val cars: List<Car>) : List<Car> by cars {

    constructor(carNames: CarNames) : this(carNames.mapToCar())

    fun winners(): List<Car> {
        val maxPosition = maxOf { it.movedDistance() }
        return filter { it.movedDistance() == maxPosition }
    }

    fun race() {
        forEach { it.drive() }
    }
}
