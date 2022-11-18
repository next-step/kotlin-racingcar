package racingcar.domain.car

import racingcar.domain.car.action.MovingStrategy

private const val MINIMUM_NUMBER_OF_RACERS = 2

data class Cars(val cars: List<Car>) {
    init {
        require(cars.size >= MINIMUM_NUMBER_OF_RACERS) { "자동차는 2대 이상이어야 합니다." }
    }

    constructor(cars: Array<String>) : this(cars.map { Car(it) })

    fun play(movingStrategy: MovingStrategy) {
        cars.forEach { it.move(movingStrategy) }
    }

    fun findTheWinner(): List<String> {
        val maxPosition = cars.maxOf { it.position.value }
        return cars.filter { it.position.value == maxPosition }.map { it.name.value }
    }
}
