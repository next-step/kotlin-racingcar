package racingcar.domain.car

import racingcar.domain.car.action.RandomMovingStrategy
import racingcar.domain.car.status.Position

data class Cars(private val cars: List<Car>) {
    init {
        require(cars.isNotEmpty()) { "자동차는 1대 이상이어야 합니다." }
    }

    fun play() {
        cars.forEach { it.move(RandomMovingStrategy()) }
    }

    fun getPositions(): List<Position> {
        return cars.map { it.position }
    }
}
