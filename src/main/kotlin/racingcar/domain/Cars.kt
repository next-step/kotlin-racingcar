package racingcar.domain

import racingcar.domain.Car.Companion.createRandomMoveCar

class Cars(
    val values: List<Car>
) : List<Car> by values {
    init {
        require(values.isNotEmpty()) { "게임 생성에 필요한 자동차 대수는 1대 이상이어야 한다." }
    }

    fun run() = values.forEach { it.move() }

    fun leadCarNames(): List<String> {
        val leadPosition = values.maxOf { it.position }
        return values.filter { it.position == leadPosition }
            .map { it.name }
    }

    companion object {
        fun createRandomMoveCars(carNames: List<String>) = Cars(carNames.map { createRandomMoveCar(it) })
    }
}
