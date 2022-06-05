package racingcar.domain

import racingcar.view.response.CarSnapShot
import racingcar.view.response.RepsResult

class Car(
    val name: String,
) {
    var position: Int = 0
    fun move() {
        this.position++
    }
}

class Cars(
    private val cars: List<Car>,
) {
    init {
        require(cars.size >= 2) { "자동차 대수는 2대 이상이어야 합니다." }
    }

    fun play1Reps(moveStrategy: MoveStrategy): RepsResult {
        for (it in cars) {
            moveStrategy.move(it)
        }
        return RepsResult(cars.map { CarSnapShot(it.name, it.position) })
    }

    fun findWinners(): List<Car> {
        val maxPosition = cars.maxOfOrNull { it.position } ?: throw IllegalArgumentException("우승자가 존재하지 않습니다.")

        return cars.filter { it.position == maxPosition }
    }
}
