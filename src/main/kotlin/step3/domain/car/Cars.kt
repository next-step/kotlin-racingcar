package step3.domain.car

import step3.domain.car.action.MovingStrategyImpl
import step3.domain.car.status.Position

data class Cars(private val cars: List<Car>) {
    init {
        require(cars.isNotEmpty()) { "자동차는 1대 이상이어야 합니다." }
    }

    fun play() {
        cars.forEach { it.move(MovingStrategyImpl()) }
    }

    fun getPositions(): List<Position> {
        return cars.map { it.position }
    }
}
