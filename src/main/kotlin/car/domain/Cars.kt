package car.domain

import car.domain.vo.Name
import car.domain.vo.Position

private const val MIN_VALUE = 0
private const val DEFAULT_POSITION = 0

class Cars(carNames: List<String>) {
    private val cars: List<Car>

    val winners: List<Car>
        get() = cars.filter { it.position == maxPosition }

    private val maxPosition: Position
        get() = cars.maxOf { it }.position

    init {
        require(carNames.size > MIN_VALUE) { "자동차 수는 $MIN_VALUE 보다 커야합니다." }

        cars = carNames.map { Car(Name(it), Position(DEFAULT_POSITION)) }
    }

    fun move(movingStrategy: MovingStrategy): List<Car> = cars.onEach { it.move(movingStrategy) }
}
