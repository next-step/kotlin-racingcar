package racingcar.domain.car

import racingcar.domain.car.action.RandomMovingStrategy
import racingcar.domain.car.status.Position

data class Cars(private val cars: List<Car>) {
    init {
        require(cars.isNotEmpty()) { "빈 문자열은 입력할 수 없습니다." }
        require(cars.size >= 2) { "자동차 이름은 2개 이상 입력해주세요." }
        require(cars.size == cars.distinct().size) { "자동차 이름은 중복될 수 없습니다." }
    }

    fun play(randomMovingStrategy: RandomMovingStrategy) {
        cars.forEach { it.move(randomMovingStrategy.isMovable) }
    }

    fun getPositions(): List<Position> {
        return cars.map { it.position }
    }
}
