package car.domain

import car.domain.vo.NumberOfCar

private const val MIN_VALUE = 0
private const val DEFAULT_POSITION = 0

class Cars(numberOfCar: NumberOfCar) {
    private val cars: List<Car>

    init {
        require(numberOfCar.value > MIN_VALUE) { "자동차 수는 $MIN_VALUE 보다 커야합니다." }

        cars = List(numberOfCar.value) { Car(Position(DEFAULT_POSITION)) }
    }

    fun move(movingStrategy: MovingStrategy): List<Position> = cars.onEach { it.move(movingStrategy) }.map { it.position }
}
