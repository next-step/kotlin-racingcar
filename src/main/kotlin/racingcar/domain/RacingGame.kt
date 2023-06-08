package racingcar.domain

import racingcar.domain.Car.Companion.createRandomMoveCar

class RacingGame(
    var attemptCount: Int,
    val cars: List<Car>
) {
    init {
        require(attemptCount >= 1) { "게임 생성에 필요한 시도 횟수는 1회 이상이어야 한다." }
        require(cars.isNotEmpty()) { "게임 생성에 필요한 자동차 대수는 1대 이상이어야 한다." }
    }

    fun run() {
        check(attemptCount > 0) { "시도 횟수가 남지 않아 게임을 더이상 실행할 수 없다." }
        attemptCount--
        cars.forEach { it.move() }
    }

    fun isEndGame(): Boolean = attemptCount == 0

    companion object {
        fun createRandomMoveCarRacingGame(attemptCount: Int, carCount: Int): RacingGame {
            return RacingGame(
                attemptCount = attemptCount,
                cars = (0 until carCount).map { createRandomMoveCar() }
            )
        }
    }
}
